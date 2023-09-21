package com.vvvital.teamchallenge.repository.jdbc;

import com.vvvital.teamchallenge.entity.Categories;
import com.vvvital.teamchallenge.entity.Psychologist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Repository
public class PsychologistRepository {

    private final Logger logger = LoggerFactory.getLogger(PsychologistRepository.class);
    private final static BeanPropertyRowMapper<Psychologist> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Psychologist.class);
    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert insert;

    private final NamedParameterJdbcTemplate namedParameter;

    public PsychologistRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameter) {
        this.jdbcTemplate = jdbcTemplate;
        this.insert = new SimpleJdbcInsert(jdbcTemplate);
        this.namedParameter = namedParameter;
        insert.withTableName("psychologist");
        insert.usingGeneratedKeyColumns("id");
    }

    public Psychologist create(Psychologist psychologist) {
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(psychologist);
        Number keyNew = insert.executeAndReturnKey(parameterSource);
        psychologist.setId(keyNew.intValue());
        namedParameter.batchUpdate("UPDATE psychologist SET location=:location.name WHERE id=:id", SqlParameterSourceUtils.createBatch(psychologist));
        insertCategories(psychologist);
        System.out.println(psychologist);
        return psychologist;
    }

    public Psychologist update(Psychologist psychologist) {
        namedParameter.batchUpdate("UPDATE psychologist SET name=:name, surname=:surName, email=:email,password=:password,phone=:phone," +
                "price=:price,location=:location.name,experience=:experience,rating=:rating,description=:description,photolink=:photoLink WHERE id=:id", SqlParameterSourceUtils.createBatch(psychologist));
        updateCategories(psychologist);
        return get(psychologist.getId());
    }


    public Psychologist get(Integer id) {
        List<Psychologist> psychologists = jdbcTemplate.query("SELECT * FROM psychologist WHERE id=?", ROW_MAPPER, id);
        Psychologist psychologist = DataAccessUtils.singleResult(psychologists);
        if (psychologist != null) {
            psychologist.setCategoriesSet(getCategories(id));
            return psychologist;
        }
        return null;
    }

    public List<Psychologist> getAll() {
        List<Psychologist> psychologists = jdbcTemplate.query("SELECT * FROM psychologist", ROW_MAPPER);
        psychologists.forEach(psychologist -> psychologist.setCategoriesSet(getCategories(psychologist.getId())));
        return psychologists;
    }

    public Psychologist getEmail(String email) {
        List<Psychologist> psychologists = jdbcTemplate.query("SELECT * FROM psychologist WHERE email=?", ROW_MAPPER, email);
        return DataAccessUtils.singleResult(psychologists);
    }

    public void delete(Integer id) {
        jdbcTemplate.update("DELETE FROM psychologist WHERE id=?", id);
    }

    public void insertCategories(Psychologist psychologist) {
        logger.info("**************insertCategories {}**************",psychologist.getCategories());
        Set<Categories> categories = psychologist.getCategories();
        if (!CollectionUtils.isEmpty(categories)) {
            jdbcTemplate.batchUpdate("INSERT INTO psychologist_categories VALUES (?,?)", categories, categories.size(),
                    (ps, category) -> {
                        ps.setInt(1, psychologist.getId());
                        ps.setObject(2, category.name());
                    }
            );
        }
    }

    public Set<Categories> getCategories(Integer id) {
        logger.info("*********getCategories************");
        Map<Integer, Set<Categories>> map = new HashMap<>();
        jdbcTemplate.query("SELECT * FROM psychologist_categories", rs -> {
            map.computeIfAbsent(rs.getInt("psychologist_id"), userId -> EnumSet.noneOf(Categories.class))
                    .add(Categories.valueOf(rs.getString("categories")));
        });
        return map.get(id);
    }

    public void deleteCategories(Psychologist psychologist){
        logger.info("//////////deleteCategories////////////////////");
        jdbcTemplate.update("DELETE FROM psychologist_categories WHERE psychologist_id=?",psychologist.getId());
    }

    public void updateCategories(Psychologist psychologist){
        if (!psychologist.getCategories().equals(getCategories(psychologist.getId()))){
            logger.info("**************updateCategories***********");
            deleteCategories(psychologist);
            insertCategories(psychologist);
        }
    }

}
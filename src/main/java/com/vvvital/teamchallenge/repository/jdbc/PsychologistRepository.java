package com.vvvital.teamchallenge.repository.jdbc;

import com.vvvital.teamchallenge.entity.Categories;
import com.vvvital.teamchallenge.entity.Psychologist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.*;

import static com.vvvital.teamchallenge.entity.Location.DNIPRO;

@Repository
public class PsychologistRepository {

    private final Logger logger = LoggerFactory.getLogger(PsychologistRepository.class);
    private final static BeanPropertyRowMapper<Psychologist> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Psychologist.class);
    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert insert;

    private final String GET_ALL="SELECT * FROM psychologist";
    private final String GET_ALL_LOCATION="";

    public PsychologistRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.withTableName("psychologist");
        insert.usingGeneratedKeyColumns("id");
    }

    public Psychologist create(Psychologist psychologist) {
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(psychologist);
        Number keyNew = insert.executeAndReturnKey(parameterSource);
        Integer id = keyNew.intValue();
        psychologist.setId(id);
        for (Categories s:psychologist.getCategories()
             ) {
            System.out.println(s);
            jdbcTemplate.update("insert into psychologist_categories values (?,?)",id,s.toString());
        }
        System.out.println(psychologist);
        Psychologist psychologistNew=get(id);
        System.out.println(psychologistNew);
        return psychologistNew;
    }

    public Psychologist get(Integer id) {
        List<Psychologist> psychologists = jdbcTemplate.query("SELECT * FROM psychologist WHERE id=?", ROW_MAPPER, id);
        Psychologist psychologist= DataAccessUtils.singleResult(psychologists);
        assert psychologist != null;
        psychologist.setCategoriesSet(getCategories(id));
        return psychologist;
    }

    public List<Psychologist> getAll(){
        List<Psychologist>psychologists = jdbcTemplate.query("SELECT * FROM psychologist",ROW_MAPPER);
        psychologists.forEach(psychologist -> psychologist.setCategoriesSet(getCategories(psychologist.getId())));
        return psychologists;
    }

    public Psychologist getEmail(String email){
        List<Psychologist>psychologists=jdbcTemplate.query("SELECT * FROM psychologist WHERE email=?",ROW_MAPPER,email);
        return DataAccessUtils.singleResult(psychologists);
    }

    public void delete(Integer id) {
        jdbcTemplate.update("DELETE FROM psychologist WHERE id=?", id);
    }

    public Set<Categories> getCategories(Integer id){
        Map<Integer, Set<Categories>> map = new HashMap<>();
        jdbcTemplate.query("SELECT * FROM psychologist_categories", rs -> {
            map.computeIfAbsent(rs.getInt("psychologist_id"), userId -> EnumSet.noneOf(Categories.class))
                    .add(Categories.strToEnum(rs.getString("categories")));
        });
        Set<Categories>categoriesSet=map.get(id);
        return categoriesSet;
    }

}

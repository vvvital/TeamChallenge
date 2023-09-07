package com.vvvital.teamchallenge.repository.jdbc;

import com.vvvital.teamchallenge.entity.Psychologist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PsychologistRepository {

    private final Logger logger = LoggerFactory.getLogger(PsychologistRepository.class);
    private final static BeanPropertyRowMapper<Psychologist> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Psychologist.class);
    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert insert;

    public PsychologistRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.withTableName("psychologist");
        insert.usingGeneratedKeyColumns("id");
    }

    public Psychologist create(Psychologist psychologist) {
        BeanPropertySqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(psychologist);
        Number keyNew = insert.executeAndReturnKey(sqlParameterSource);
        Integer id = keyNew.intValue();
        psychologist.setId(id);
        return get(id);
    }

    public Psychologist get(Integer id) {
        List<Psychologist> psychologists = jdbcTemplate.query("SELECT * FROM psychologist WHERE id=?", ROW_MAPPER, id);
        return DataAccessUtils.singleResult(psychologists);
    }

    public List<Psychologist> getAll(){
        return jdbcTemplate.query("SELECT * FROM psychologist",ROW_MAPPER);
    }

    public Psychologist getEmail(String email){
        List<Psychologist>psychologists=jdbcTemplate.query("SELECT * FROM psychologist WHERE email=?",ROW_MAPPER,email);
        return DataAccessUtils.singleResult(psychologists);
    }

    public void delete(Integer id) {
        jdbcTemplate.update("DELETE FROM psychologist WHERE id=?", id);
    }
}

package com.vvvital.teamchallenge.repository.jdbc;

import com.vvvital.teamchallenge.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcUserRepository {

    private final Logger logger = LoggerFactory.getLogger(JdbcUserRepository.class);

    private final JdbcTemplate jdbcTemplate;

    private final SimpleJdbcInsert insertUser;

    private final static BeanPropertyRowMapper<User> ROW_MAPPER = BeanPropertyRowMapper.newInstance(User.class);

    @Autowired
    public JdbcUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        insertUser = new SimpleJdbcInsert(jdbcTemplate);
        insertUser.withTableName("users");
        insertUser.usingGeneratedKeyColumns("id");
    }

    public User create(User user) {
        logger.info("*************User Repository/create Users***********");
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
        Number keyNew = insertUser.executeAndReturnKey(parameterSource);
        Integer id = keyNew.intValue();
        user.setId(id);
        return get(id);
    }

    public void update(User user) {
        logger.info("*************User Repository/update Users id***********");
        jdbcTemplate.update("insert into users values (?,?,?,?,?,?)",
                user.getId(), user.getName(), user.getName(), user.getEmail(), user.getPhone());
    }

    public List<User> getAll() {
    //    logger.info("*************User Repository/get Users***********");
        return jdbcTemplate.query("SELECT * FROM users ORDER BY id", ROW_MAPPER);
    }

    public User get(Integer id) {
        logger.info("*************User Repository/get User id***********");
        List<User> users = jdbcTemplate.query("SELECT * FROM users WHERE id=?", ROW_MAPPER, id);
        return DataAccessUtils.singleResult(users);
    }



    public void delete(Integer id) {
        logger.info("*************User Repository/delete Users id" + "***********");
        jdbcTemplate.update("DELETE FROM users WHERE id=?", id);
    }

}

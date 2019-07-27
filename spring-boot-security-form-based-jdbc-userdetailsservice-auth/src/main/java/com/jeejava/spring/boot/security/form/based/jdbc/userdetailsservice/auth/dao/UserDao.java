package com.jeejava.spring.boot.security.form.based.jdbc.userdetailsservice.auth.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jeejava.spring.boot.security.form.based.jdbc.userdetailsservice.auth.model.User;
import com.jeejava.spring.boot.security.form.based.jdbc.userdetailsservice.auth.rowmapper.UserRowMapper;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public User getUser(final String username) {
		return jdbcTemplate.queryForObject(
				"select u.user_name user_name, u.user_pass user_pass, ur.user_role user_role from user u, user_role ur where u.user_name = ? and u.user_name = ur.user_name",
				new String[] { username }, new UserRowMapper());
	}

}

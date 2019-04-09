package com.github.iam20.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

public class DbConfig {
	private static NamedParameterJdbcTemplate jdbcTemplate;

	public static void dataSourceInit() {
		DataSource dataSource = DataSourceBuilder.create()
				.driverClassName("com.mysql.cj.jdbc.Driver")
				.url("jdbc:mysql://106.10.54.51:3306/playdb?useSSL=false&serverTimezone=UTC")
				.username("root")
				.password("Qkrtjdrud!007")
				.build();

		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public static NamedParameterJdbcTemplate getJdbc() {
		return jdbcTemplate;
	}
}

package com.github.iam20.model;

import static com.github.iam20.config.DbConfig.getJdbc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class DeviceDao {
	private static final String INSERT_DEVICE = "INSERT INTO device (state) VALUES ( :state );";
	private static final String SELECT_DEVICE = "SELECT * FROM device;";
	private static final String UPDATE_DEVICE = "UPDATE device SET state = :state where id = :id ;";
	private static MapSqlParameterSource namedParameters = new MapSqlParameterSource();

	public static List<Device> getDevices() {
		NamedParameterJdbcTemplate jdbcTemplate = getJdbc();
		return jdbcTemplate.query(SELECT_DEVICE, BeanPropertyRowMapper.newInstance(Device.class));
	}

	public static int insertDevice(Device device) {
		return insertDevice(device.getState());
	}

	public static int insertDevice(String state) {
		NamedParameterJdbcTemplate jdbcTemplate = getJdbc();
		namedParameters.addValue("state", state);
		return jdbcTemplate.update(INSERT_DEVICE, namedParameters);
	}

	public static int updateDevice(Device device) {
		return updateDevice(device.getId(), device.getState());
	}

	public static int updateDevice(int id, String state) {
		NamedParameterJdbcTemplate jdbcTemplate = getJdbc();
		namedParameters.addValue("state", state);
		namedParameters.addValue("id", id);
		return jdbcTemplate.update(UPDATE_DEVICE, namedParameters);
	}
}

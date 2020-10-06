package kr.or.ddit.prop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import kr.or.ddit.vo.DataBasePropertyVO;

public class DataBasePropertyDAO_JDBC implements IDataBasePropertyDAO{
	
	@Inject
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<String> selectAllProperty_names() {
			String sql = " SELECT PROPERTY_NAME FROM DATABASE_PROPERTIES ";
			return jdbcTemplate.queryForList(sql, String.class);
			
	}
	
	
	@Override
	public List<DataBasePropertyVO> selectDataBaseProperties(DataBasePropertyVO param) {
		
		String sql = "SELECT PROPERTY_NAME, PROPERTY_VALUE, DESCRIPTION FROM DATABASE_PROPERTIES";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<DataBasePropertyVO>(DataBasePropertyVO.class));

	}
}

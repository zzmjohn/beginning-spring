package com.wiley.beginningspring.ch4;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class AccountDaoJdbcImpl implements AccountDao {

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				jdbcTemplate);
	}

	public void insert(Account account) {
		// TODO Auto-generated method stub

	}

	public void update(Account account) {
		// TODO Auto-generated method stub

	}

	public void update(List<Account> accounts) {
		// TODO Auto-generated method stub

	}

	public void delete(long accountId) {
		// TODO Auto-generated method stub

	}

	public Account find(long accountId) {
		return jdbcTemplate
				.queryForObject(
						"select id,owner_name,balance,access_time,locked from account where id = ?",
						new RowMapper<Account>() {
							public Account mapRow(ResultSet rs, int rowNum)
									throws SQLException {
								Account account = new Account();
								account.setId(rs.getLong("id"));
								account.setOwnerName(rs.getString("owner_name"));
								account.setBalance(rs.getDouble("balance"));
								account.setAccessTime(rs
										.getTimestamp("access_time"));
								account.setLocked(rs.getBoolean("locked"));
								return account;
							}

						}, accountId);
	}

	public List<Account> find(List<Long> accountIds) {
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(
				"accountIds", accountIds);
		return namedParameterJdbcTemplate.query(
				"select * from account where id in (:accountIds)",
				sqlParameterSource, new RowMapper<Account>() {
					public Account mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Account account = new Account();
						account.setId(rs.getLong("id"));
						account.setOwnerName(rs.getString("owner_name"));
						account.setBalance(rs.getDouble("balance"));
						account.setAccessTime(rs.getTimestamp("access_time"));
						account.setLocked(rs.getBoolean("locked"));
						return account;
					}

				});
	}

	public List<Account> find(String ownerName) {
		return namedParameterJdbcTemplate
				.query("select id,owner_name,balance,access_time,locked from account where owner_name = :ownerName",
						Collections.singletonMap("ownerName", ownerName),
						new RowMapper<Account>() {
							public Account mapRow(ResultSet rs, int rowNum)
									throws SQLException {
								Account account = new Account();
								account.setId(rs.getLong("id"));
								account.setOwnerName(rs.getString("owner_name"));
								account.setBalance(rs.getDouble("balance"));
								account.setAccessTime(rs
										.getTimestamp("access_time"));
								account.setLocked(rs.getBoolean("locked"));
								return account;
							}
						});
	}

	public List<Account> find(boolean locked) {
		// TODO Auto-generated method stub
		return null;
	}

	// method implementations...
}

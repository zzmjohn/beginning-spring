package com.wiley.beginningspring.ch4;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Collections;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class AccountDaoJdbcImpl implements AccountDao {

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	private MappingSqlQuery<Account> accountByIdQuery;

	public void setAccountByIdQuery(MappingSqlQuery<Account> accountByIdQuery) {
	    this.accountByIdQuery = accountByIdQuery;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				jdbcTemplate);
	}

	public void insert(Account account) {
		PreparedStatementCreatorFactory psCreatorFactory = new PreparedStatementCreatorFactory(
				"insert into account(owner_name,balance,access_time,locked) values(?,?,?,?)",
				new int[] { Types.VARCHAR, Types.DOUBLE, Types.TIMESTAMP,
						Types.BOOLEAN });
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int count = jdbcTemplate.update(
				psCreatorFactory.newPreparedStatementCreator(new Object[] {
						account.getOwnerName(), account.getBalance(),
						account.getAccessTime(), account.isLocked() }),
				keyHolder);
		if (count != 1)
			throw new InsertFailedException("Cannot insert account");
		account.setId(keyHolder.getKey().longValue());
	}

	public void update(Account account) {
		int count = jdbcTemplate
				.update("update account  set (owner_name,balance,access_time,locked) = (?,?,?,?) where id = ?",
						account.getOwnerName(), account.getBalance(),
						account.getAccessTime(), account.isLocked(),
						account.getId());
		if (count != 1)
			throw new UpdateFailedException("Cannot update account");
	}

	public void update(final List<Account> accounts) {
		int[] counts = jdbcTemplate.batchUpdate(
				"update account set (owner_name,balance,access_time,locked) = (?,?,?,?) where id = ?",
				new BatchPreparedStatementSetter() {        
				        public void setValues(PreparedStatement ps, int i) throws SQLException {
				            Account account = accounts.get(i);
				            ps.setString(1, account.getOwnerName());
				            ps.setDouble(2, account.getBalance());
				            ps.setTimestamp(3, new Timestamp(account.getAccessTime().getTime()));
				            ps.setBoolean(4, account.isLocked());
				            ps.setLong(5, account.getId());
				        }
				        
				        public int getBatchSize() {
				            return accounts.size();
				        }
				    });
				    int i = 0;
				    for(int count:counts) {
				        if(count == 0) throw new RuntimeException("Row not updated :" + i);
				        i++;
				    }


	}

	public void delete(long accountId) {
		int count = jdbcTemplate.update("delete account where id = ?",
				accountId);
		if (count != 1)
			throw new DeleteFailedException("Cannot delete account");
	}

	public Account find(long accountId) {
		return accountByIdQuery.findObject(accountId);
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

	public List<Account> find(final boolean locked) {
		PreparedStatementCreatorFactory psCreatorFactory = new PreparedStatementCreatorFactory(
				"select * from account where locked = ?",
				new int[] { Types.BOOLEAN });
		return jdbcTemplate.query(psCreatorFactory
				.newPreparedStatementCreator(new Object[] { locked }),
				new RowMapper<Account>() {
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

	// method implementations...
}

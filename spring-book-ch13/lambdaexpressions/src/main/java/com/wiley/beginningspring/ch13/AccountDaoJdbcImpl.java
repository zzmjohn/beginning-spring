package com.wiley.beginningspring.ch13;

import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDaoJdbcImpl implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Account find(long accountId) {
        return jdbcTemplate.queryForObject("select id,owner_name,balance,access_time,locked from account where id = " + accountId,
                (rs, rowNum) -> new Account(rs.getLong("id"),
                        rs.getString("owner_name"),
                        rs.getDouble("balance"),
                        rs.getTimestamp("access_time"),
                        rs.getBoolean("locked")));
    }
}

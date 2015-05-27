package com.wiley.beginningspring.ch4;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;

public class AccountByIdQuery extends MappingSqlQuery<Account> {
	
	private LobHandler lobHandler = new DefaultLobHandler();

	public AccountByIdQuery(DataSource dataSource) {
		super(dataSource, 
		        "select id,owner_name,balance,access_time,locked,owner_photo from account where id = ?");
		declareParameter(new SqlParameter(Types.BIGINT));
        compile();

	}
	
    @Override
    protected Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(rs.getLong("id"));
        account.setOwnerName(rs.getString("owner_name"));
        account.setBalance(rs.getDouble("balance"));
        account.setAccessTime(rs.getTimestamp("access_time"));
        account.setLocked(rs.getBoolean("locked"));
        account.setOwnerPhoto(lobHandler.getBlobAsBytes(rs, "owner_photo"));
        return account;
    }
}

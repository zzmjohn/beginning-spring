package com.wiley.beginningspring.ch4;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;

public class Main {
	public static void main(String[] args) throws SQLException {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				Ch4Configuration.class);

		JdbcTemplate jdbcTemplate = applicationContext
				.getBean(JdbcTemplate.class);

		final LobHandler lobHandler = new DefaultLobHandler();
		final String textualContent = "test";
		final byte[] binaryContent = textualContent.getBytes();
		
		final long accountId = 100L;

		jdbcTemplate
				.update("update account set (owner_photo,account_desc) = (?,?) where id = ? ",
						new PreparedStatementSetter() {
							public void setValues(PreparedStatement ps)
									throws SQLException {
								LobCreator lobCreator = lobHandler
										.getLobCreator();
								lobCreator.setBlobAsBytes(ps, 1, binaryContent);
								lobCreator.setClobAsString(ps, 2,
										textualContent);
								ps.setLong(3, accountId);
							}
						});

	}
}

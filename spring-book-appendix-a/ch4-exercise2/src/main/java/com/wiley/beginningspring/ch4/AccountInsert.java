package com.wiley.beginningspring.ch4;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class AccountInsert extends SqlUpdate {
    public AccountInsert(DataSource dataSource) {
        super(dataSource,
        "insert into account(owner_name,balance,access_time,locked) values(?,?,?,?)");
        setParameters(new SqlParameter[] { 
                new SqlParameter(Types.VARCHAR),
                new SqlParameter(Types.DOUBLE),
                new SqlParameter(Types.TIMESTAMP),
                new SqlParameter(Types.BOOLEAN) });
        setReturnGeneratedKeys(true);
        setGeneratedKeysColumnNames(new String[]{"id"});
        compile();
    }
}


package com.wiley.beginningspring.ch4;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class AccountUpdate extends SqlUpdate {
    public AccountUpdate(DataSource dataSource) {
        super(dataSource, 
"update account set (owner_name,balance,access_time,locked) = (?,?,?,?) where id=?");
        setParameters(new SqlParameter[] { 
                new SqlParameter(Types.VARCHAR),
                new SqlParameter(Types.DOUBLE),
                new SqlParameter(Types.TIMESTAMP),
                new SqlParameter(Types.BOOLEAN),
                new SqlParameter(Types.BIGINT)});
        compile();
    }
}

package com.wiley.beginningspring.ch4;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class ConcatStoredProcedure extends StoredProcedure {
    public ConcatStoredProcedure(DataSource dataSource) {
        setDataSource(dataSource);
        setSql("concat");
        declareParameter(new SqlParameter("param1",Types.VARCHAR));
        declareParameter(new SqlParameter("param2",Types.VARCHAR));
        compile();
    }
    
    public String execute(String param1, String param2) {
        Map<String,Object> inParams = new HashMap<String,Object>();
        inParams.put("param1", param1);
        inParams.put("param2", param2);
        Map<String, Object> map = execute(inParams);
        List<Map> list = (List<Map>) map.get("#result-set-1");
        return list.get(0).values().iterator().next().toString();
    }
}

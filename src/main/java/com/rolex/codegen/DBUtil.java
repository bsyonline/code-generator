/*
 * Copyright (C) 2018 bsyonline
 */
package com.rolex.codegen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author rolex
 * @since 2018
 */
@Component
public class DBUtil {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<String> showTables() {
        List<String> list = jdbcTemplate.queryForList("show tables", String.class);
        System.out.println(list);
        return list;
    }

    public List<Property> showColumns(String tableName) {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select column_name,data_type,column_key from information_schema.COLUMNS where table_name = ?", new Object[]{tableName});
        List<Property> propertyList = list.stream().map(kv->new Property((String) kv.get("column_name"),(String) kv.get("data_type"),"PRI".equals((String) kv.get("column_key"))?true:false)).collect(Collectors.toList());
        return propertyList;
    }

}

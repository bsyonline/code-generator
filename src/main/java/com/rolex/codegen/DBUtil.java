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

    public Map<String, String> showColumns(String tableName) {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select column_name,data_type from information_schema.COLUMNS where table_name = ?", new Object[]{tableName});
        Map<String, String> map = list.stream().collect(Collectors.toMap(kv -> (String) kv.get("column_name"), kv -> (String) kv.get("data_type")));
        System.out.println(map);
        return map;
    }

}

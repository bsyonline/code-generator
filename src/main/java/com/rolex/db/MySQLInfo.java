package com.rolex.db;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*******************************************************************************
 * - Copyright (c)  2018  chinadaas.com
 *   @author rolex
 * - File Name: com.rolex.db.MySQLInfo
 * - Description:
 *
 *
 * - Function List:
 *
 *
 * - History:
 * Date         Author          Modification
 * 2018/12/26   rolex           Create file
 *******************************************************************************/
public class MySQLInfo implements DatabaseInfo {
    
    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    JdbcTemplate jdbcTemplate;
    
    @Override
    public List<String> showTables() {
        List<String> list = jdbcTemplate.queryForList("show tables", String.class);
        System.out.println(list);
        return list;
    }
    
    @Override
    public List<ColumnInfo> showColumns(String tableName) {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select column_name,data_type,column_key from information_schema.COLUMNS where table_name = ?", new Object[]{tableName});
        List<ColumnInfo> columnInfoList = list.stream()
            .map(kv -> new ColumnInfo((String) kv.get("column_name"),
                DataType.get((String) kv.get("data_type"))==null?(String) kv.get("data_type"):DataType.get((String) kv.get("data_type")),
                "PRI".equals((String) kv.get("column_key")) ? true : false)).collect(Collectors.toList());
        return columnInfoList;
    }
}

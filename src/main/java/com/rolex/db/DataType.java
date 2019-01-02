package com.rolex.db;

import java.util.HashMap;
import java.util.Map;

/*******************************************************************************
 * - Copyright (c)  2018  chinadaas.com
 *   @author rolex
 * - File Name: com.rolex.db.DataType
 * - Description:
 *
 *
 * - Function List:
 *
 *
 * - History:
 * Date         Author          Modification
 * 2019/01/02   rolex           Create file
 *******************************************************************************/
public class DataType {
    
    static Map<String, String> map = new HashMap<>();
    
    static {
        map.put("CHAR", "java.lang.String");
        map.put("VARCHAR", "java.lang.String");
        map.put("BLOB", "java.lang.byte[]");
        map.put("TEXT", "java.lang.String");
        map.put("INTEGER", "java.lang.Integer");
        map.put("INT", "java.lang.Integer");
        map.put("TINYINT", "java.lang.Integer");
        map.put("SMALLINT", "java.lang.Integer");
        map.put("MEDIUMINT", "java.lang.Integer");
        map.put("BIT", "java.lang.Boolean");
        map.put("BIGINT", "java.lang.Long");
        map.put("FLOAT", "java.lang.Float");
        map.put("DOUBLE", "java.lang.Double");
        map.put("DECIMAL", "java.math.BigDecimal");
        map.put("DATE", "java.util.Date");
        map.put("TIME", "java.util.Date");
        map.put("DATETIME", "java.util.Date");
        map.put("TIMESTAMP", "java.util.Date");
        map.put("YEAR", "java.util.Date");
    }
    
    public static String get(String key) {
        return map.get(key.toUpperCase());
    }
}

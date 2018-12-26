package com.rolex.db;

import java.util.List;

/*******************************************************************************
 * - Copyright (c)  2018  chinadaas.com
 *   @author rolex
 * - File Name: com.rolex.db.DatabaseInfo
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
public interface DatabaseInfo {
    
    List<String> showTables();
    List<ColumnInfo> showColumns(String tableName);
    
}

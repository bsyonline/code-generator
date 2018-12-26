package com.rolex.db;

import lombok.Data;

import java.util.List;

/*******************************************************************************
 * - Copyright (c)  2018  chinadaas.com
 *   @author rolex
 * - File Name: com.rolex.db.TableInfo
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
@Data
public class TableInfo {
    
    String tableName;
    List<ColumnInfo> columnInfos;
    
}

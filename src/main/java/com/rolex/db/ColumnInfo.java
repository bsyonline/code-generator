package com.rolex.db;

import lombok.AllArgsConstructor;
import lombok.Data;

/*******************************************************************************
 * - Copyright (c)  2018  chinadaas.com
 *   @author rolex
 * - File Name: com.rolex.db.ColumnInfo
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
@AllArgsConstructor
public class ColumnInfo {
    
    String name;
    String type;
    boolean primaryKey;
    
}

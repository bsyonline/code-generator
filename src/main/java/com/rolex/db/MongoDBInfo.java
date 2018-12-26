package com.rolex.db;

import com.google.common.collect.Lists;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.stream.Collectors;

/*******************************************************************************
 * - Copyright (c)  2018  chinadaas.com
 *   @author rolex
 * - File Name: com.rolex.db.MongoDBInfo
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
public class MongoDBInfo implements DatabaseInfo {
    
    private MongoDatabase mongoDatabase;
    
    public MongoDBInfo() {
        try (MongoClient mongoClient = new MongoClient("192.168.100.44", 27017)) {
            mongoDatabase = mongoClient.getDatabase("riskbell");
        }
    }
    
    @Override
    public List<String> showTables() {
        return Lists.newArrayList(mongoDatabase.listCollectionNames());
    }
    
    @Override
    public List<ColumnInfo> showColumns(String tableName) {
        return mongoDatabase.getCollection(tableName)
            .find().first().entrySet().stream()
            .map(kv -> new ColumnInfo(kv.getKey(), kv.getValue().getClass().getSimpleName(), kv.getValue() instanceof ObjectId ? true : false))
            .collect(Collectors.toList());
    }
    
    public static void main(String[] args) {
        System.out.println(new MongoDBInfo().showTables());
        System.out.println(new MongoDBInfo().showColumns("alter"));
    }
}

/*
 * Copyright (C) 2018 bsyonline
 */
package com.rolex.config;

import com.rolex.db.DatabaseInfo;

import java.util.HashMap;

/**
 * @author rolex
 * @since 2018
 */
public interface Config {
    
     String controller = "template/controller.java.vm";
     String service = "template/service.java.vm";
     String serviceImpl = "template/serviceImpl.java.vm";
     String entity = "template/entity.java.vm";
     String dao = "template/dao.java.vm";
     String model = "template/model.java.vm";
     String vo = "template/vo.java.vm";
    
    HashMap<String, String> configMap();

    String outputPath();

    TemplateConfig template();
    
    DatabaseInfo databaseInfo();
}

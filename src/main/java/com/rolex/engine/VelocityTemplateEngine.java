/*
 * Copyright (C) 2018 bsyonline
 */
package com.rolex.engine;

import com.rolex.config.GlobalConfig;
import com.rolex.db.ColumnInfo;
import com.rolex.db.DatabaseInfo;
import com.rolex.db.MySQLInfo;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;

/**
 * @author rolex
 * @since 2018
 */
@Component
public class VelocityTemplateEngine implements TemplateEngine {
    
    DatabaseInfo databaseInfo;
    VelocityEngine velocityEngine;
    
    public VelocityTemplateEngine() {
        velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        
        velocityEngine.init();
    }
    
    @Override
    public void writer(GlobalConfig config) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        if ("mysql".equals(config.getConfigMap().get("db.type"))) {
            Class clazz = Class.forName((String) config.getConfigMap().get("db.infoClass"));
            MySQLInfo info = (MySQLInfo) clazz.newInstance();
    
            BasicDataSource ds = new BasicDataSource();
            ds.setUrl((String) config.getConfigMap().get("db.url"));
            ds.setUsername((String) config.getConfigMap().get("db.username"));
            ds.setPassword((String) config.getConfigMap().get("db.password"));
            
            info.setJdbcTemplate(ds);
            List<ColumnInfo> columnInfoList = info.showColumns("book");
            config.getConfigMap().put("propertyList",columnInfoList);
            Template template = velocityEngine.getTemplate(config.getConfigMap().get("domain.templatePath").toString());
            File file = new File(config.getConfigMap().get("domain.entityPath").toString());
            if (!file.getParentFile().exists()) {
                boolean flag = file.getParentFile().mkdirs();
            }
            file.delete();
            
            FileOutputStream outStream = new FileOutputStream(file);
            OutputStreamWriter writer = new OutputStreamWriter(outStream);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            template.merge(new VelocityContext(config.getConfigMap()), bufferWriter);
            bufferWriter.flush();
            outStream.close();
            bufferWriter.close();
        }
        
    }
    
}

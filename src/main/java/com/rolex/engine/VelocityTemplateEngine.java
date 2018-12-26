/*
 * Copyright (C) 2018 bsyonline
 */
package com.rolex.engine;

import com.rolex.config.Config;
import com.rolex.db.DatabaseInfo;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * @author rolex
 * @since 2018
 */
@Component
public class VelocityTemplateEngine implements TemplateEngine {
    
    DatabaseInfo databaseInfo;
    VelocityEngine velocityEngine;
    
    public VelocityTemplateEngine(){
        velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
    
        velocityEngine.init();
    }
    
    @Override
    public void writer(Config config) throws IOException {
        
        Template template = velocityEngine.getTemplate(config.template().toString());
        File file = new File(config.outputPath());
        if (!file.getParentFile().exists()) {
            boolean flag = file.getParentFile().mkdirs();
        }
        file.delete();

        FileOutputStream outStream = new FileOutputStream(file);
        OutputStreamWriter writer = new OutputStreamWriter(outStream);
        BufferedWriter bufferWriter = new BufferedWriter(writer);
        template.merge(new VelocityContext(config.configMap()), bufferWriter);
        bufferWriter.flush();
        outStream.close();
        bufferWriter.close();
    }
}

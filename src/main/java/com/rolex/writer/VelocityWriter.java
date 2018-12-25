/*
 * Copyright (C) 2018 bsyonline
 */
package com.rolex.writer;

import com.rolex.config.Config;
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
public class VelocityWriter implements TemplateWriter {
    @Override
    public void writer(Config config) throws IOException {
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();
        Template template = velocityEngine.getTemplate(config.template().getEntity());
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

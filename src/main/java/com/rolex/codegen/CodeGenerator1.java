/*
 * Copyright (C) 2018 bsyonline
 */
package com.rolex.codegen;

import com.rolex.config.*;
import com.rolex.writer.TemplateWriter;
import com.rolex.writer.VelocityWriter;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rolex
 * @since 2018
 */
@Component
public class CodeGenerator1 {

    Config config;

    @Autowired
    DBUtil dbUtil;

    public void test() throws IOException {
        TemplateWriter velocityWriter = new VelocityWriter();
        velocityWriter.writer(config);
    }

}

/*
 * Copyright (C) 2018 bsyonline
 */
package com.rolex.codegen;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.*;
import java.util.*;

/**
 * @author rolex
 * @since 2018
 */
public class CodeGenerator {
    static String basePackage = "com.rolex";
    static String controllerPackage = "controller";
    static String servicePackage = "service";
    static String daoPackage = "dao";
    static String entityPackage = "dao.entity";
    static String modelPackage = "service.model";
    static String voPackage = "controller.vo";
    static String objectName = "User";

    public static void main(String[] args) throws IOException {
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

        ve.init();


        String tableName = "User";

        Map<String, String> map = new HashMap<String, String>();
        map.put(controllerPackage, "template/controller.vm");
        map.put(servicePackage, "template/service.vm");
        map.put(daoPackage, "template/dao.vm");
        map.put(entityPackage, "template/entity.vm");
        map.put(modelPackage, "template/model.vm");
        map.put(voPackage, "template/vo.vm");

        String root = System.getProperty("user.dir") + File.separator + "src/main/resources/";
        for (Map.Entry<String, String> kv : map.entrySet()) {
            VelocityContext ctx = new VelocityContext();
            Template t = ve.getTemplate(kv.getValue());

            String fullPackageName = basePackage + "." + kv.getKey();
            String postfix = fullPackageName.substring(fullPackageName.lastIndexOf(".") + 1);
            String javaObjectName = objectName + postfix.substring(0, 1).toUpperCase() + postfix.substring(1);
            String fullName = fullPackageName.replace(".", "/") + File.separator + javaObjectName + ".java";
            ctx.put("copyright", "Copyright (C) 2018 bsyonline");
            ctx.put("author", "rolex");
            ctx.put("since", "2018");

            ctx.put("controllerPackage", "com.rolex.controller");
            ctx.put("servicePackage", "com.rolex.service");
            ctx.put("daoPackage", "com.rolex.dao");
            ctx.put("voPackage", "com.rolex.controller.vo");
            ctx.put("modelPackage", "com.rolex.service.model");
            ctx.put("entityPackage", "com.rolex.dao.entity");

            ctx.put("controllerName", "UserController");
            ctx.put("serviceName", "UserService");
            ctx.put("daoName", "UserDao");
            ctx.put("modelName", "UserModel");
            ctx.put("entityName", "UserEntity");
            ctx.put("voName", "UserVO");
            ctx.put("primaryKeyType", "Long");


            File file = new File(root + File.separator + fullName);
            if (!file.getParentFile().exists()) {
                boolean flag = file.getParentFile().mkdirs();
            }
            file.delete();

            FileOutputStream outStream = new FileOutputStream(file);
            OutputStreamWriter writer = new OutputStreamWriter(outStream);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            t.merge(ctx, bufferWriter);
            bufferWriter.flush();
            outStream.close();
            bufferWriter.close();

        }

    }

    static String javaObjectName(String packageName, String objectName) {
        String fullPackageName = basePackage + "." + packageName;
        String postfix = fullPackageName.substring(fullPackageName.lastIndexOf(".") + 1);
        return objectName + postfix.substring(0, 1).toUpperCase() + postfix.substring(1);
    }

}

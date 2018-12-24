/*
 * Copyright (C) 2018 bsyonline
 */
package com.rolex;

import com.rolex.codegen.CodeGenerator1;
import com.rolex.codegen.DBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author rolex
 * @since 2018
 */
@SpringBootApplication
public class CodeGeneratorApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CodeGeneratorApplication.class, args);
    }

    @Autowired
    DBUtil dbUtil;

    @Autowired
    CodeGenerator1 codeGenerator1;
    
    @Override
    public void run(String... args) throws Exception {
//        dbUtil.showTables();
//        dbUtil.showColumns("book");
        codeGenerator1.test();
    }
}

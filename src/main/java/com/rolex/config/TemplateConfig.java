/*
 * Copyright (C) 2018 bsyonline
 */
package com.rolex.config;

import lombok.Data;

/**
 * @author rolex
 * @since 2018
 */
@Data
public class TemplateConfig {

    private Type type = Type.VELOCITY;
    private String controller = "template/controller.java.vm";
    private String service = "template/service.java.vm";
    private String serviceImpl = "template/serviceImpl.java.vm";
    private String entity = "template/entity.java.vm";
    private String dao = "template/dao.java.vm";
    private String model = "template/model.java.vm";
    private String vo = "template/vo.java.vm";

    enum Type{

        VELOCITY("velocity"),
        FREEMARKER("freemarker");

        String type;
        Type(String type){
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}

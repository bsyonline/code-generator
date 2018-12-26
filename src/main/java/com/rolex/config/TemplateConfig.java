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
    private boolean controller = false;
    private boolean service = false;
    private boolean serviceImpl = false;
    private boolean entity = false;
    private boolean dao = false;
    private boolean model = false;
    private boolean vo = false;

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

package com.rolex.engine;

import com.rolex.config.Config;

import java.io.IOException;

/**
 * @author rolex
 * @since 2018
 */
public interface TemplateEngine {

    void writer(Config config) throws IOException;
}

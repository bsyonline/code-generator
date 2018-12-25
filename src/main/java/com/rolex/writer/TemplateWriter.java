package com.rolex.writer;

import com.rolex.config.Config;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author rolex
 * @since 2018
 */
public interface TemplateWriter {

    void writer(Config config) throws IOException;
}

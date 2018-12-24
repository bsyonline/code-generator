package com.rolex.codegen;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Property {
    
    String name;
    String type;
    boolean primaryKey;
    
}
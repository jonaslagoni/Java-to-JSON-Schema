/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.json_schema.builder.model.draft7;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 *
 * @author lagoni
 */
public enum SimpleType {
    ARRAY("array"), 
    BOOLEAN("boolean"), 
    INTEGER("integer"), 
    NULL("null"), 
    NUMBER("number"), 
    OBJECT("object"), 
    STRING("string");
    
    @JsonValue
    private String type;

    private SimpleType(String type) {
        this.type = type;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.json.schema.builder.draft7;

import com.json_schema.builder.model.draft7.Schema;
import com.json_schema.builder.model.draft7.SimpleType;
import java.util.List;

/**
 *
 * @author lagoni
 */
public abstract class AbstractBuilder {
    private Schema schema;
    public void allOf(List<Schema> allOfSchema){
        
    }
    
    /**
     * @param schema the schema to set
     */
    protected void setSchema(Schema schema) {
        this.schema = schema;
    }
}

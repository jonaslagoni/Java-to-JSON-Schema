/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.json.schema.builder.draft7;

import com.json_schema.builder.model.draft7.Schema;

/**
 *
 * @author lagoni
 */
public class AllOfBuilder {
    
    private Schema schema;
    
    public AllOfBuilder(Schema schema){
        this.schema = schema;
    }
    
    public SchemaBuilder newItem(){
        return new SchemaBuilder(schema);
    }
}

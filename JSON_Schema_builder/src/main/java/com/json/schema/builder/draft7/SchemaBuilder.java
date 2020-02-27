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
public class SchemaBuilder implements Builder{
    private Schema schema;
    public SchemaBuilder(){
        this.schema = new Schema();
    }
    public SchemaBuilder(Schema schema){
        this.schema = schema;
    }
    public ObjectSchemaBuilder object(){
        return new ObjectSchemaBuilder(this, this.schema);
    }
    public AllOfBuilder allOf(){
        return new AllOfBuilder(this.schema);
    }

    @Override
    public Schema build() {
        return this.schema;
    }
    protected void setRootSchema(Schema schema){
        this.schema = schema;
    }
}

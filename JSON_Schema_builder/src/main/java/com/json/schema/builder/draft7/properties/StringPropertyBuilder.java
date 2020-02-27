/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.json.schema.builder.draft7.properties;

import com.json.schema.builder.draft7.ObjectSchemaBuilder;
import com.json_schema.builder.model.draft7.Schema;
import com.json_schema.builder.model.draft7.SimpleType;

/**
 *
 * @author lagoni
 */
public class StringPropertyBuilder extends AbstractPropertyBuilder<StringPropertyBuilder>{

    public StringPropertyBuilder() {
        super();
    }

    public StringPropertyBuilder(Schema schema) {
        super(schema);
    }

    public StringPropertyBuilder(ObjectSchemaBuilder ob) {
        super(ob);
    }

    public StringPropertyBuilder(ObjectSchemaBuilder ob, Schema schema) {
        super(ob, schema);
    }

// <editor-fold desc="Methods for fluent interface">
    /**
     * 
     * @param format
     * @return 
     */
    public StringPropertyBuilder format(String format){
        this.getSchema().setFormat(format);
        return this;
    }
    
// </editor-fold>
    
    @Override
    protected void setSchema(Schema schema) {
        super.setSchema(schema);
        schema.setType(SimpleType.STRING);
    }
    
}


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
public class NumberPropertyBuilder extends AbstractPropertyBuilder<NumberPropertyBuilder>{

    public NumberPropertyBuilder() {
        super();
    }

    public NumberPropertyBuilder(Schema schema) {
        super(schema);
    }

    public NumberPropertyBuilder(ObjectSchemaBuilder ob) {
        super(ob);
    }

    public NumberPropertyBuilder(ObjectSchemaBuilder ob, Schema schema) {
        super(ob, schema);
    }

    @Override
    protected void setSchema(Schema schema) {
        super.setSchema(schema);
        schema.setType(SimpleType.NUMBER);
    }
    
}

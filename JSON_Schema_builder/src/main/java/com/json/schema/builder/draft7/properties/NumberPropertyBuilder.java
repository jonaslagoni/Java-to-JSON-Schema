/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.json.schema.builder.draft7.properties;

import com.json.schema.builder.draft7.ObjectSchemaBuilder;
import com.json_schema.builder.model.draft7.NumberSchema;

/**
 *
 * @author lagoni
 */
public class NumberPropertyBuilder extends AbstractPropertyBuilder<NumberPropertyBuilder, NumberSchema> {

    public NumberPropertyBuilder() {
        this(new NumberSchema());
    }

    public NumberPropertyBuilder(NumberSchema schema) {
        super(schema);
    }

    public NumberPropertyBuilder(ObjectSchemaBuilder ob) {
        this(ob, new NumberSchema());
    }

    public NumberPropertyBuilder(ObjectSchemaBuilder ob, NumberSchema schema) {
        super(ob, schema);
    }

}

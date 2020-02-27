/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.json.schema.builder.draft7.properties;

import com.json.schema.builder.draft7.ObjectSchemaBuilder;
import com.json_schema.builder.model.draft7.IntegerSchema;

/**
 *
 * @author lagoni
 */
public class IntegerPropertyBuilder extends AbstractPropertyBuilder<IntegerPropertyBuilder, IntegerSchema> {

    public IntegerPropertyBuilder() {
        this(new IntegerSchema());
    }

    public IntegerPropertyBuilder(IntegerSchema schema) {
        super(schema);
    }

    public IntegerPropertyBuilder(ObjectSchemaBuilder ob) {
        super(ob, new IntegerSchema());
    }

    public IntegerPropertyBuilder(ObjectSchemaBuilder ob, IntegerSchema schema) {
        super(ob, schema);
    }

// <editor-fold desc="Methods for fluent interface">
    /**
     *
     * @param minimum
     * @return
     */
    public IntegerPropertyBuilder minimum(Double minimum) {
        this.getSchema().setMinimum(minimum);
        return this;
    }

    public IntegerPropertyBuilder minimum(int minimum) {
        this.getSchema().setMinimum(Double.valueOf(minimum));
        return this;
    }

// </editor-fold>
}

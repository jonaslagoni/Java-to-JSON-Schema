/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.json.schema.builder.draft7;

import com.json_schema.builder.model.draft7.IntegerSchema;

/**
 *
 * @author Lagoni
 */
public class TestWrapper extends IntegerSchemaBuilder<ObjectSchemaBuilder> {

    public TestWrapper(ObjectSchemaBuilder parentBuilder, IntegerSchema schema) {
        super(parentBuilder, schema);
    }

    public IntegerSchemaBuilder<ObjectSchemaBuilder> done() {
        return (IntegerSchemaBuilder<ObjectSchemaBuilder>) super.getParentBuilder();
    }

}

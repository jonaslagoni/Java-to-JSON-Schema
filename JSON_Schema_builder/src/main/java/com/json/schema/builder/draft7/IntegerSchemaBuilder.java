/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.json.schema.builder.draft7;

import com.json_schema.builder.model.draft7.IntegerSchema;

/**
 *
 * @author lagoni
 * @param <ParentBuilder>
 */
public class IntegerSchemaBuilder<ParentBuilder extends Builder<ParentBuilder>> extends SchemaBuilder<ParentBuilder, IntegerSchemaBuilder, IntegerSchema> {

    public IntegerSchemaBuilder(ParentBuilder parentBuilder, IntegerSchema schema) {
        super.setSchema(schema);
        super.setParentBuilder(parentBuilder);
    }

// <editor-fold desc="Methods for fluent interface">
    public IntegerSchemaBuilder<ParentBuilder> title(String title) {
        return super.title(title);
    }

    public IntegerSchemaBuilder<ParentBuilder> description(String description) {
        return super.description(description);
    }

    /**
     *
     * @param minimum
     * @return
     */
    public IntegerSchemaBuilder<ParentBuilder> minimum(Double minimum) {
        this.getSchema().setMinimum(minimum);
        return this;
    }

    public IntegerSchemaBuilder<ParentBuilder> minimum(int minimum) {
        this.getSchema().setMinimum(Double.valueOf(minimum));
        return this;
    }

// </editor-fold>
    public ParentBuilder done() {
        return super.getParentBuilder();
    }
}

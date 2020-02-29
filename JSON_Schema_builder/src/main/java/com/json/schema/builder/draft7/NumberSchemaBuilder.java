/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.json.schema.builder.draft7;

import com.json_schema.builder.model.draft7.NumberSchema;

/**
 *
 * @author lagoni
 * @param <ParentBuilder>
 */
public class NumberSchemaBuilder<ParentBuilder extends Builder> extends SchemaBuilder<ParentBuilder, NumberSchemaBuilder, NumberSchema> {

    public NumberSchemaBuilder(ParentBuilder parentBuilder, NumberSchema schema) {
        super.setSchema(schema);
        super.setParentBuilder(parentBuilder);
    }

// <editor-fold desc="Methods for fluent interface">
    public NumberSchemaBuilder<ParentBuilder> title(String title) {
        return super.title(title);
    }

    public NumberSchemaBuilder<ParentBuilder> description(String description) {
        return super.description(description);
    }
// </editor-fold>

    @Override
    public ParentBuilder done() {
        return super.getParentBuilder();
    }
}

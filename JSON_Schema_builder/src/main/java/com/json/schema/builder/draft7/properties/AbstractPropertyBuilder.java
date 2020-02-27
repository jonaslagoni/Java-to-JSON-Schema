/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.json.schema.builder.draft7.properties;

import com.json.schema.builder.draft7.ObjectSchemaBuilder;
import com.json.schema.builder.draft7.SchemaBuilder;
import com.json.schema.builder.draft7.SecondaryBuilders;
import com.json_schema.builder.model.draft7.Schema;

/**
 *
 * @author lagoni
 * @param <T>
 */
public abstract class AbstractPropertyBuilder<T extends AbstractPropertyBuilder, U extends Schema> extends SchemaBuilder implements SecondaryBuilders<ObjectSchemaBuilder> {

    private U schema;
    private ObjectSchemaBuilder ob;

    protected AbstractPropertyBuilder(U schema) {
        this.setSchema(schema);
    }

    protected AbstractPropertyBuilder(ObjectSchemaBuilder ob, U schema) {
        this.setSchema(schema);
        this.ob = ob;
    }

// <editor-fold desc="Methods for fluent interface">
    /**
     *
     * @param title
     * @return
     */
    public T title(String title) {
        this.getSchema().setTitle(title);
        return (T) this;
    }

    /**
     *
     * @param description
     * @return
     */
    public T description(String description) {
        this.getSchema().setDescription(description);
        return (T) this;
    }
// </editor-fold>

    /**
     * @param schema the schema to set
     */
    protected void setSchema(U schema) {
        this.schema = schema;
    }

    /**
     * @return the schema
     */
    protected U getSchema() {
        return schema;
    }

    /**
     *
     * @return The root schema, either the local schema in this builder or from
     * ObjectSchemaBuilder.
     */
    @Override
    public Schema build() {
        return ob == null ? getSchema() : ob.build();
    }

    /**
     * Finishes a local build and returns to previous ObjectSchemaBuilder
     *
     * @return null if this is not in conjunction with an ObjectSchemaBuilder
     */
    @Override
    public ObjectSchemaBuilder done() {
        return ob;
    }

}

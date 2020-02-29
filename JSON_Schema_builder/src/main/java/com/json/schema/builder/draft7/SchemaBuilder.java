/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.json.schema.builder.draft7;

import com.json_schema.builder.model.draft7.Schema;

/**
 *
 * @author Lagoni
 * @param <ParentBuilder>
 * @param <ActiveBuilder>
 * @param <BuilderSchema>
 */
public abstract class SchemaBuilder<ParentBuilder extends Builder<ParentBuilder>, ActiveBuilder extends SchemaBuilder, BuilderSchema extends Schema> extends Builder {

    private ParentBuilder parentBuilder;
    private BuilderSchema schema;

// <editor-fold desc="Methods for fluent interface">
    public ActiveBuilder title(String title) {
        this.getSchema().setTitle(title);
        return (ActiveBuilder) this;
    }

    public ActiveBuilder description(String description) {
        this.getSchema().setDescription(description);
        return (ActiveBuilder) this;
    }

//    public abstract <T extends Builder> T anyOf();
//
//    public abstract ActiveBuilder allOf();
//
//    public abstract ActiveBuilder oneOf();
//
//    public abstract ActiveBuilder enums();
//
//    public abstract ActiveBuilder conditionalIf();
//
//    public abstract ActiveBuilder conditionalThen();
//
//    public abstract ActiveBuilder conditionalElse();
//
//    public abstract ActiveBuilder conditionalNot();
// </editor-fold>
    /**
     * @return the schema
     */
    public BuilderSchema getSchema() {
        return schema;
    }

    /**
     * @param schema the schema to set
     */
    public void setSchema(BuilderSchema schema) {
        this.schema = schema;
    }

    /**
     * @return the parentBuilder
     */
    public ParentBuilder getParentBuilder() {
        return parentBuilder;
    }

    /**
     * @param parentBuilder the parentBuilder to set
     */
    public void setParentBuilder(ParentBuilder parentBuilder) {
        this.parentBuilder = parentBuilder;
    }

}

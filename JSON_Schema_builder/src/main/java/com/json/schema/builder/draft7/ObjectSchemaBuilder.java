/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.json.schema.builder.draft7;

import com.json_schema.builder.model.draft7.IntegerSchema;
import com.json_schema.builder.model.draft7.NumberSchema;
import com.json_schema.builder.model.draft7.ObjectSchema;
import com.json_schema.builder.model.draft7.Schema;
import com.json_schema.builder.model.draft7.StringSchema;

/**
 *
 * @author lagoni
 * @param <ParentBuilder>
 */
public class ObjectSchemaBuilder<ParentBuilder extends Builder> extends SchemaBuilder<ParentBuilder, ObjectSchemaBuilder, ObjectSchema> {

    public ObjectSchemaBuilder(ParentBuilder parentBuilder, ObjectSchema schema) {
        super.setSchema(schema);
        super.setParentBuilder(parentBuilder);
    }

// <editor-fold desc="Methods for fluent interface">
    public ObjectSchemaBuilder requiredProperty(String propertyName) {
        this.addRequiredPropertyToSchema(propertyName);
        return this;
    }

    public AllOfSchemaBuilder anyOf() {
        return new AllOfSchemaBuilder();
    }

// <editor-fold desc="Properties">
    public ObjectSchemaBuilder<ObjectSchemaBuilder> objectProperty(String propertyName) {
        return this.objectProperty(propertyName, false);
    }

    public ObjectSchemaBuilder<ObjectSchemaBuilder> objectProperty(String propertyName, boolean required) {
        ObjectSchema newSchema = new ObjectSchema();
        this.property(newSchema, propertyName, required);
        return new ObjectSchemaBuilder(this, newSchema);
    }

    public StringSchemaBuilder<ObjectSchemaBuilder> stringProperty(String propertyName) {
        return this.stringProperty(propertyName, false);
    }

    public StringSchemaBuilder<ObjectSchemaBuilder> stringProperty(String propertyName, boolean required) {
        StringSchema newSchema = new StringSchema();
        this.property(newSchema, propertyName, required);
        return new StringSchemaBuilder(this, newSchema);
    }

    public IntegerSchemaBuilder<ObjectSchemaBuilder> integerProperty(String propertyName) {
        return this.integerProperty(propertyName, false);
    }

    public IntegerSchemaBuilder<ObjectSchemaBuilder> integerProperty(String propertyName, boolean required) {
        IntegerSchema newSchema = new IntegerSchema();
        this.property(newSchema, propertyName, required);
        return new IntegerSchemaBuilder(this, newSchema);
    }

    public NumberSchemaBuilder<ObjectSchemaBuilder> numberProperty(String propertyName) {
        return this.numberProperty(propertyName, false);
    }

    public NumberSchemaBuilder<ObjectSchemaBuilder> numberProperty(String propertyName, boolean required) {
        NumberSchema newSchema = new NumberSchema();
        this.property(newSchema, propertyName, required);
        return new NumberSchemaBuilder(this, newSchema);
    }

// </editor-fold>
// </editor-fold>
    private void addRequiredPropertyToSchema(String propertyName) {
        this.getSchema().addRequired(propertyName);
    }

    private <GenericSchema extends Schema> void property(GenericSchema newObjectSchema, String propertyName, boolean required) {
        this.getSchema().addProperty(propertyName, newObjectSchema);
        if (required) {
            this.addRequiredPropertyToSchema(propertyName);
        }
    }

    public ParentBuilder done() {
        return super.getParentBuilder();
    }
}

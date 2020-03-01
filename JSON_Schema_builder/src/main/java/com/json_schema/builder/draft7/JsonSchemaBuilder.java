/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.json_schema.builder.draft7;

import com.json_schema.builder.model.draft7.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author Lagoni
 */
public class JsonSchemaBuilder {

    private Deque<Schema> parentList = new ArrayDeque();
    private Schema rootSchema;
    private Schema currentSchema;

    // <editor-fold desc="Schema builder">
    public JsonSchemaBuilder title(String title) {
        currentSchema.setTitle(title);
        return this;
    }

    public JsonSchemaBuilder description(String description) {
        currentSchema.setDescription(description);
        return this;
    }

    public JsonSchemaBuilder elseDo() {
        Schema newSchema = initSchemaFromCurrent();
        if (newSchema != null) {
            currentSchema.setSchemaElse(newSchema);
            changeCurrentSchema(newSchema);
        } else {
            System.out.println("Could not add else schema");
        }
        return this;
    }

    public JsonSchemaBuilder thenDo() {
        Schema newSchema = initSchemaFromCurrent();
        if (newSchema != null) {
            currentSchema.setSchemaThen(newSchema);
            changeCurrentSchema(newSchema);
        } else {
            System.out.println("Could not add then schema");
        }
        return this;
    }

    public JsonSchemaBuilder ifCondition() {
        Schema newSchema = initSchemaFromCurrent();
        if (newSchema != null) {
            currentSchema.setSchemaIf(newSchema);
            changeCurrentSchema(newSchema);
        } else {
            System.out.println("Could not add then schema");
        }
        return this;
    }

    public JsonSchemaBuilder oneOf(SimpleType type) {
        Schema newSchema = initSchema(type);
        if (newSchema != null) {
            currentSchema.addOneOf(newSchema);
            changeCurrentSchema(newSchema);
        } else {
            System.out.println("Could not add schema");
        }
        return this;
    }

    public JsonSchemaBuilder allOf(SimpleType type) {
        Schema newSchema = initSchema(type);
        if (newSchema != null) {
            currentSchema.addAllOf(newSchema);
            changeCurrentSchema(newSchema);
        } else {
            System.out.println("Could not add schema");
        }
        return this;
    }

    public JsonSchemaBuilder anyOf(SimpleType type) {
        Schema newSchema = initSchema(type);
        if (newSchema != null) {
            currentSchema.addAnyOf(newSchema);
            changeCurrentSchema(newSchema);
        } else {
            System.out.println("Could not add schema");
        }
        return this;
    }

    // </editor-fold>
    // <editor-fold desc="String builder">
    public JsonSchemaBuilder pattern(String pattern) {
        if (!ensureSchemaOfType(StringSchema.class)) {
            System.out.println("Current schema not of type StringSchema");
        } else {
            ((StringSchema) currentSchema).setPattern(pattern);
        }
        return this;
    }

    public JsonSchemaBuilder contentMediaType(String type) {
        if (!ensureSchemaOfType(StringSchema.class)) {
            System.out.println("Current schema not of type StringSchema");
        } else {
            ((StringSchema) currentSchema).setContentMediaType(type);
        }
        return this;
    }

    public JsonSchemaBuilder encoding(ContentEncoding encoding) {
        if (!ensureSchemaOfType(StringSchema.class)) {
            System.out.println("Current schema not of type StringSchema");
        } else {
            ((StringSchema) currentSchema).setContentEncoding(encoding);
        }
        return this;
    }

    public JsonSchemaBuilder format(StringFormat format) {
        if (!ensureSchemaOfType(StringSchema.class)) {
            System.out.println("Current schema not of type StringSchema");
        } else {
            ((StringSchema) currentSchema).setFormat(format);
        }
        return this;
    }

    public JsonSchemaBuilder minLength(int minLength) {
        if (!ensureSchemaOfType(StringSchema.class)) {
            System.out.println("Current schema not of type StringSchema");
        } else {
            ((StringSchema) currentSchema).setMinLength(minLength);
        }
        return this;
    }

    public JsonSchemaBuilder maxLength(int maxLength) {
        if (!ensureSchemaOfType(StringSchema.class)) {
            System.out.println("Current schema not of type StringSchema");
        } else {
            ((StringSchema) currentSchema).setMaxLength(maxLength);
        }
        return this;
    }

    // </editor-fold>
    // <editor-fold desc="Array builder">
    public JsonSchemaBuilder allowAdditionalItems() {
        if (!ensureSchemaOfType(ArraySchema.class)) {
            System.out.println("Current schema not of type ArraySchema");
        } else {
            ((ArraySchema) currentSchema).setAdditionalItems(true);
        }
        return this;
    }

    public JsonSchemaBuilder onlyUniqueItems() {
        if (!ensureSchemaOfType(ArraySchema.class)) {
            System.out.println("Current schema not of type ArraySchema");
        } else {
            ((ArraySchema) currentSchema).setUniqueItems(true);
        }
        return this;
    }

    public JsonSchemaBuilder minItems(int minItems) {
        if (ensureSchemaOfType(ArraySchema.class)) {
            System.out.println("Current schema not of type ArraySchema");
        } else {
            ((ArraySchema) currentSchema).setMinItems(minItems);
        }
        return this;
    }

    public JsonSchemaBuilder maxItems(int maxItems) {
        if (!ensureSchemaOfType(ArraySchema.class)) {
            System.out.println("Current schema not of type ArraySchema");
        } else {
            ((ArraySchema) currentSchema).setMaxItems(maxItems);
        }
        return this;
    }

    public JsonSchemaBuilder item(SimpleType type) {
        if (!ensureSchemaOfType(ArraySchema.class)) {
            System.out.println("Current schema not of type ArraySchema");
        } else {
            Schema newSchema = initSchema(type);
            if (newSchema != null) {
                ((ArraySchema) currentSchema).addItem(newSchema);
                changeCurrentSchema(newSchema);
            } else {
                System.out.println("Could not add schema");
            }
        }
        return this;
    }

    public JsonSchemaBuilder contain(SimpleType type) {
        if (!ensureSchemaOfType(ArraySchema.class)) {
            System.out.println("Current schema not of type ArraySchema");
        } else {
            Schema newSchema = initSchema(type);
            if (newSchema != null) {
                ((ArraySchema) currentSchema).addContain(newSchema);
                changeCurrentSchema(newSchema);
            } else {
                System.out.println("Could not add schema");
            }
        }
        return this;
    }

    // </editor-fold>
    // <editor-fold desc="Numeric builders">
    public JsonSchemaBuilder minimum(double minimum) {
        if (!ensureSchemaOfType(NumericSchema.class)) {
            System.out.println("Current schema not of type NumericSchema");
        } else {
            ((NumericSchema) currentSchema).setMinimum(minimum);
        }
        return this;
    }

    public JsonSchemaBuilder exclusiveMinimum(double exclusiveMinimum) {
        if (!ensureSchemaOfType(NumericSchema.class)) {
            System.out.println("Current schema not of type NumericSchema");
        } else {
            ((NumericSchema) currentSchema).setExclusiveMinimum(exclusiveMinimum);
        }
        return this;
    }

    public JsonSchemaBuilder maximum(double maximum) {
        if (!ensureSchemaOfType(NumericSchema.class)) {
            System.out.println("Current schema not of type NumericSchema");
        } else {
            ((NumericSchema) currentSchema).setMaximum(maximum);
        }
        return this;
    }

    public JsonSchemaBuilder exclusiveMaximum(double exclusiveMaximum) {
        if (!ensureSchemaOfType(NumericSchema.class)) {
            System.out.println("Current schema not of type NumericSchema");
        } else {
            ((NumericSchema) currentSchema).setExclusiveMaximum(exclusiveMaximum);
        }
        return this;
    }

    public JsonSchemaBuilder multipleOf(double multipleOf) {
        if (!ensureSchemaOfType(NumericSchema.class)) {
            System.out.println("Current schema not of type NumericSchema");
        } else {
            ((NumericSchema) currentSchema).setMultipleOf(multipleOf);
        }
        return this;
    }

    // </editor-fold>
    // <editor-fold desc="Object builder">
    public JsonSchemaBuilder object() {
        currentSchema = new ObjectSchema();
        return this;
    }

    public JsonSchemaBuilder property(String propertyName, SimpleType type) {
        return property(propertyName, type, false);
    }

    public JsonSchemaBuilder property(String propertyName, SimpleType type, boolean required) {
        if (!ensureSchemaOfType(ObjectSchema.class)) {
            System.out.println("Current schema not of type ObjectSchema");
        } else {
            Schema newSchema = initSchema(type);
            if (newSchema != null) {
                ((ObjectSchema) currentSchema).addProperty(propertyName, newSchema);
                if (required) {
                    ((ObjectSchema) currentSchema).addRequired(propertyName);
                }
                changeCurrentSchema(newSchema);
            } else {
                System.out.println("Could not add schema");
            }
        }
        return this;
    }

    public JsonSchemaBuilder minProperties(int minProperties) {
        if (!ensureSchemaOfType(ObjectSchema.class)) {
            System.out.println("Current schema not of type ObjectSchema");
        } else {
            ((ObjectSchema) currentSchema).setMinProperties(minProperties);
        }
        return this;
    }

    public JsonSchemaBuilder maxProperties(int maxProperties) {
        if (!ensureSchemaOfType(ObjectSchema.class)) {
            System.out.println("Current schema not of type ObjectSchema");
        } else {
            ((ObjectSchema) currentSchema).setMaxProperties(maxProperties);
        }
        return this;
    }

    //</editor-fold>
    private <T extends Schema> boolean ensureSchemaOfType(Class<T> schemaClass) {
        return schemaClass.isInstance(currentSchema);
    }

    public Schema build() {
        return rootSchema;
    }

    public JsonSchemaBuilder parent() {
        currentSchema = parentList.poll();
        return this;
    }

    private void changeCurrentSchema(Schema newSchema) {
        if (parentList.isEmpty() && rootSchema == null) {
            rootSchema = currentSchema;
        }
        parentList.add(currentSchema);
        currentSchema = newSchema;
    }

    private Schema initSchemaFromCurrent() {
        if (currentSchema instanceof StringSchema) {
            return new StringSchema();
        } else if (currentSchema instanceof IntegerSchema) {
            return new IntegerSchema();
        } else if (currentSchema instanceof NumberSchema) {
            return new NumberSchema();
        } else if (currentSchema instanceof ArraySchema) {
            return new ArraySchema();
        } else if (currentSchema instanceof ObjectSchema) {
            return new ObjectSchema();
        } else if (currentSchema instanceof NullSchema) {
            return new NullSchema();
        } else if (currentSchema instanceof BooleanSchema) {
            return new BooleanSchema();
        } else {
            System.out.println("Schema type not found?");
            return null;
        }
    }

    private Schema initSchema(SimpleType type) {
        switch (type) {
            case STRING:
                return new StringSchema();
            case INTEGER:
                return new IntegerSchema();
            case NUMBER:
                return new NumberSchema();
            case ARRAY:
                return new ArraySchema();
            case OBJECT:
                return new ObjectSchema();
            case NULL:
                return new NullSchema();
            case BOOLEAN:
                return new BooleanSchema();
            default:
                return null;
        }
    }

}

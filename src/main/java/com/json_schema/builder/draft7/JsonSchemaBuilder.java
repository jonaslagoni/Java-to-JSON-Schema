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
public class JsonSchemaBuilder<T extends JsonSchemaBuilder> {

    private Deque<Schema> parentList = new ArrayDeque();
    private Schema rootSchema;
    private Schema currentSchema;

    // <editor-fold desc="Schema builder">
    public T nullSchema() {
        currentSchema = new NullSchema();
        rootSchema = currentSchema;
        return (T) this;
    }

    public T booleanSchema() {
        currentSchema = new BooleanSchema();
        rootSchema = currentSchema;
        return (T) this;
    }

    public T title(String title) {
        currentSchema.setTitle(title);
        return (T) this;
    }

    public T description(String description) {
        currentSchema.setDescription(description);
        return (T) this;
    }

    public T elseDo() {
        Schema newSchema = initSchemaFromCurrent();
        if (newSchema != null) {
            currentSchema.setSchemaElse(newSchema);
            changeCurrentSchema(newSchema);
        } else {
            System.out.println("Could not add else schema");
        }
        return (T) this;
    }

    public T thenDo() {
        Schema newSchema = initSchemaFromCurrent();
        if (newSchema != null) {
            currentSchema.setSchemaThen(newSchema);
            changeCurrentSchema(newSchema);
        } else {
            System.out.println("Could not add then schema");
        }
        return (T) this;
    }

    public T ifCondition() {
        Schema newSchema = initSchemaFromCurrent();
        if (newSchema != null) {
            currentSchema.setSchemaIf(newSchema);
            changeCurrentSchema(newSchema);
        } else {
            System.out.println("Could not add then schema");
        }
        return (T) this;
    }

    public T oneOf(SimpleType type) {
        Schema newSchema = initSchema(type);
        if (newSchema != null) {
            currentSchema.addOneOf(newSchema);
            changeCurrentSchema(newSchema);
        } else {
            System.out.println("Could not add schema");
        }
        return (T) this;
    }

    public T allOf(SimpleType type) {
        Schema newSchema = initSchema(type);
        if (newSchema != null) {
            currentSchema.addAllOf(newSchema);
            changeCurrentSchema(newSchema);
        } else {
            System.out.println("Could not add schema");
        }
        return (T) this;
    }

    public T anyOf(SimpleType type) {
        Schema newSchema = initSchema(type);
        if (newSchema != null) {
            currentSchema.addAnyOf(newSchema);
            changeCurrentSchema(newSchema);
        } else {
            System.out.println("Could not add schema");
        }
        return (T) this;
    }

    // </editor-fold>
    // <editor-fold desc="String builder">
    public T string() {
        currentSchema = new StringSchema();
        rootSchema = currentSchema;
        return (T) this;
    }

    public T pattern(String pattern) {
        if (!ensureSchemaOfType(StringSchema.class)) {
            System.out.println("Current schema not of type StringSchema");
        } else {
            ((StringSchema) currentSchema).setPattern(pattern);
        }
        return (T) this;
    }

    public T contentMediaType(String type) {
        if (!ensureSchemaOfType(StringSchema.class)) {
            System.out.println("Current schema not of type StringSchema");
        } else {
            ((StringSchema) currentSchema).setContentMediaType(type);
        }
        return (T) this;
    }

    public T encoding(ContentEncoding encoding) {
        if (!ensureSchemaOfType(StringSchema.class)) {
            System.out.println("Current schema not of type StringSchema");
        } else {
            ((StringSchema) currentSchema).setContentEncoding(encoding);
        }
        return (T) this;
    }

    public T format(StringFormat format) {
        if (!ensureSchemaOfType(StringSchema.class)) {
            System.out.println("Current schema not of type StringSchema");
        } else {
            ((StringSchema) currentSchema).setFormat(format);
        }
        return (T) this;
    }

    public T minLength(int minLength) {
        if (!ensureSchemaOfType(StringSchema.class)) {
            System.out.println("Current schema not of type StringSchema");
        } else {
            ((StringSchema) currentSchema).setMinLength(minLength);
        }
        return (T) this;
    }

    public T maxLength(int maxLength) {
        if (!ensureSchemaOfType(StringSchema.class)) {
            System.out.println("Current schema not of type StringSchema");
        } else {
            ((StringSchema) currentSchema).setMaxLength(maxLength);
        }
        return (T) this;
    }

    // </editor-fold>
    // <editor-fold desc="Array builder">
    public T array() {
        currentSchema = new ArraySchema();
        rootSchema = currentSchema;
        return (T) this;
    }

    public T allowAdditionalItems() {
        if (!ensureSchemaOfType(ArraySchema.class)) {
            System.out.println("Current schema not of type ArraySchema");
        } else {
            ((ArraySchema) currentSchema).setAdditionalItems(true);
        }
        return (T) this;
    }

    public T onlyUniqueItems() {
        if (!ensureSchemaOfType(ArraySchema.class)) {
            System.out.println("Current schema not of type ArraySchema");
        } else {
            ((ArraySchema) currentSchema).setUniqueItems(true);
        }
        return (T) this;
    }

    public T minItems(int minItems) {
        if (ensureSchemaOfType(ArraySchema.class)) {
            System.out.println("Current schema not of type ArraySchema");
        } else {
            ((ArraySchema) currentSchema).setMinItems(minItems);
        }
        return (T) this;
    }

    public T maxItems(int maxItems) {
        if (!ensureSchemaOfType(ArraySchema.class)) {
            System.out.println("Current schema not of type ArraySchema");
        } else {
            ((ArraySchema) currentSchema).setMaxItems(maxItems);
        }
        return (T) this;
    }

    public T item(SimpleType type) {
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
        return (T) this;
    }

    public T contain(SimpleType type) {
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
        return (T) this;
    }

    // </editor-fold>
    // <editor-fold desc="Numeric builders">
    public T number() {
        currentSchema = new NumberSchema();
        rootSchema = currentSchema;
        return (T) this;
    }

    public T integer() {
        currentSchema = new IntegerSchema();
        rootSchema = currentSchema;
        return (T) this;
    }

    public T minimum(double minimum) {
        if (!ensureSchemaOfType(NumericSchema.class)) {
            System.out.println("Current schema not of type NumericSchema");
        } else {
            ((NumericSchema) currentSchema).setMinimum(minimum);
        }
        return (T) this;
    }

    public T exclusiveMinimum(double exclusiveMinimum) {
        if (!ensureSchemaOfType(NumericSchema.class)) {
            System.out.println("Current schema not of type NumericSchema");
        } else {
            ((NumericSchema) currentSchema).setExclusiveMinimum(exclusiveMinimum);
        }
        return (T) this;
    }

    public T maximum(double maximum) {
        if (!ensureSchemaOfType(NumericSchema.class)) {
            System.out.println("Current schema not of type NumericSchema");
        } else {
            ((NumericSchema) currentSchema).setMaximum(maximum);
        }
        return (T) this;
    }

    public T exclusiveMaximum(double exclusiveMaximum) {
        if (!ensureSchemaOfType(NumericSchema.class)) {
            System.out.println("Current schema not of type NumericSchema");
        } else {
            ((NumericSchema) currentSchema).setExclusiveMaximum(exclusiveMaximum);
        }
        return (T) this;
    }

    public T multipleOf(double multipleOf) {
        if (!ensureSchemaOfType(NumericSchema.class)) {
            System.out.println("Current schema not of type NumericSchema");
        } else {
            ((NumericSchema) currentSchema).setMultipleOf(multipleOf);
        }
        return (T) this;
    }

    // </editor-fold>
    // <editor-fold desc="Object builder">
    public T object() {
        currentSchema = new ObjectSchema();
        rootSchema = currentSchema;
        return (T) this;
    }

    public T property(String propertyName, SimpleType type) {
        return property(propertyName, type, false);
    }

    public T property(String propertyName, SimpleType type, boolean required) {
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
        return (T) this;
    }

    public T minProperties(int minProperties) {
        if (!ensureSchemaOfType(ObjectSchema.class)) {
            System.out.println("Current schema not of type ObjectSchema");
        } else {
            ((ObjectSchema) currentSchema).setMinProperties(minProperties);
        }
        return (T) this;
    }

    public T maxProperties(int maxProperties) {
        if (!ensureSchemaOfType(ObjectSchema.class)) {
            System.out.println("Current schema not of type ObjectSchema");
        } else {
            ((ObjectSchema) currentSchema).setMaxProperties(maxProperties);
        }
        return (T) this;
    }

    //</editor-fold>
    private <T extends Schema> boolean ensureSchemaOfType(Class<T> schemaClass) {
        return schemaClass.isInstance(currentSchema);
    }

    public Schema build() {
        return rootSchema;
    }

    public T parent() {
        currentSchema = parentList.poll();
        return (T) this;
    }

    private void changeCurrentSchema(Schema newSchema) {
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

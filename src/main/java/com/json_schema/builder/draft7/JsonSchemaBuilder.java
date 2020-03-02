/*
 * The MIT License
 *
 * Copyright 2020 lagoni.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.json_schema.builder.draft7;

import com.json_schema.builder.model.draft7.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author Lagoni
 * @param <T>
 */
public class JsonSchemaBuilder<T extends JsonSchemaBuilder> {

    private Deque<Schema> parentList = new ArrayDeque();
    private Schema rootSchema;
    private Schema currentSchema;

    // <editor-fold desc="Schema builder">
    
    /**
     * Initiate a JSON Schema as a root Null schema.
     * 
     * @return this
     */
    public T nullSchema() {
        currentSchema = new NullSchema();
        rootSchema = currentSchema;
        return (T) this;
    }

    /**
     * Initiate a JSON Schema as a root boolean schema.
     * 
     * @return this
     */
    public T booleanSchema() {
        currentSchema = new BooleanSchema();
        rootSchema = currentSchema;
        return (T) this;
    }

    /**
     * Set the title of the current schema.
     * 
     * @param title to set
     * @return this
     */
    public T title(String title) {
        currentSchema.setTitle(title);
        return (T) this;
    }

    /**
     * Set the description of the current schema.
     * 
     * @param description to set
     * @return this
     */
    public T description(String description) {
        currentSchema.setDescription(description);
        return (T) this;
    }

    /**
     * Initiate an else schema
     * 
     * @return this
     */
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

    /**
     * Initiate a then schema
     * 
     * @return this
     */
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

    
    /**
     * Initiate an if schema
     * 
     * @return this
     */
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

    /**
     * Initiate a oneOf schema.
     * 
     * @param type of JSON Schema which should be used
     * @return this
     */
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

    /**
     * Initiate an allOf schema.
     * 
     * @param type of JSON Schema which should be used
     * @return this
     */
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

    /**
     * Initiate an anyOf schema.
     * 
     * @param type of JSON Schema which should be used
     * @return this
     */
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
    
    /**
     * Initiate a JSON Schema as a root string schema.
     * 
     * @return this
     */
    public T string() {
        currentSchema = new StringSchema();
        rootSchema = currentSchema;
        return (T) this;
    }

    /**
     * Set the pattern, only works if current schema is of type StringSchema
     * 
     * @param pattern to set
     * @return this
     */
    public T pattern(String pattern) {
        if (!ensureSchemaOfType(StringSchema.class)) {
            System.out.println("Current schema not of type StringSchema");
        } else {
            ((StringSchema) currentSchema).setPattern(pattern);
        }
        return (T) this;
    }

    /**
     * Set the content media type, only works if current schema is of type StringSchema
     * 
     * @param contentMediaType to set
     * @return this
     */
    public T contentMediaType(String contentMediaType) {
        if (!ensureSchemaOfType(StringSchema.class)) {
            System.out.println("Current schema not of type StringSchema");
        } else {
            ((StringSchema) currentSchema).setContentMediaType(contentMediaType);
        }
        return (T) this;
    }

    /**
     * Set the content encoding, only works if current schema is of type StringSchema
     * 
     * @param encoding to set
     * @return this
     */
    public T encoding(ContentEncoding encoding) {
        if (!ensureSchemaOfType(StringSchema.class)) {
            System.out.println("Current schema not of type StringSchema");
        } else {
            ((StringSchema) currentSchema).setContentEncoding(encoding);
        }
        return (T) this;
    }

    /**
     * Set the string format, only works if current schema is of type StringSchema
     * 
     * @param format to set
     * @return this
     */
    public T format(StringFormat format) {
        if (!ensureSchemaOfType(StringSchema.class)) {
            System.out.println("Current schema not of type StringSchema");
        } else {
            ((StringSchema) currentSchema).setFormat(format);
        }
        return (T) this;
    }

    /**
     * Set the minimum length of the string, only works if current schema is of type StringSchema
     * 
     * @param minLength to set
     * @return this
     */
    public T minLength(int minLength) {
        if (!ensureSchemaOfType(StringSchema.class)) {
            System.out.println("Current schema not of type StringSchema");
        } else {
            ((StringSchema) currentSchema).setMinLength(minLength);
        }
        return (T) this;
    }

    /**
     * Set the maximum length of the string, only works if current schema is of type StringSchema
     * 
     * @param maxLength to set
     * @return this
     */
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
    /**
     * Initiate a JSON Schema as an array schema.
     * 
     * @return this
     */
    public T array() {
        currentSchema = new ArraySchema();
        rootSchema = currentSchema;
        return (T) this;
    }

    /**
     * Allow the use of additional items, only works if current schema is of type ArraySchema
     * 
     * @return this
     */
    public T allowAdditionalItems() {
        if (!ensureSchemaOfType(ArraySchema.class)) {
            System.out.println("Current schema not of type ArraySchema");
        } else {
            ((ArraySchema) currentSchema).setAdditionalItems(true);
        }
        return (T) this;
    }

    /**
     * Only allow unique items, only works if current schema is of type ArraySchema
     * 
     * @return this
     */
    public T onlyUniqueItems() {
        if (!ensureSchemaOfType(ArraySchema.class)) {
            System.out.println("Current schema not of type ArraySchema");
        } else {
            ((ArraySchema) currentSchema).setUniqueItems(true);
        }
        return (T) this;
    }

    /**
     * Set the minimum amount of items allowed, only works if current schema is of type ArraySchema
     * 
     * @param minItems to set
     * @return this
     */
    public T minItems(int minItems) {
        if (ensureSchemaOfType(ArraySchema.class)) {
            System.out.println("Current schema not of type ArraySchema");
        } else {
            ((ArraySchema) currentSchema).setMinItems(minItems);
        }
        return (T) this;
    }

    /**
     * Set the maximum amount of items allowed, only works if current schema is of type ArraySchema
     * 
     * @param maxItems to set
     * @return this
     */
    public T maxItems(int maxItems) {
        if (!ensureSchemaOfType(ArraySchema.class)) {
            System.out.println("Current schema not of type ArraySchema");
        } else {
            ((ArraySchema) currentSchema).setMaxItems(maxItems);
        }
        return (T) this;
    }

    /**
     * Add an item to the array changes the current schema to a new one of selected type, only works if current schema is of type ArraySchema
     * 
     * @param type to add
     * @return this
     */
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

    /**
     * Add a contain item changes the current schema to a new one of selected type, only works if current schema is of type ArraySchema
     * 
     * @param type to contain
     * @return this
     */
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
    
    /**
     * Initiate a JSON Schema as a number schema.
     * 
     * @return this
     */
    public T number() {
        currentSchema = new NumberSchema();
        rootSchema = currentSchema;
        return (T) this;
    }

    /**
     * Initiate a JSON Schema as a integer schema.
     * 
     * @return this
     */
    public T integer() {
        currentSchema = new IntegerSchema();
        rootSchema = currentSchema;
        return (T) this;
    }

    /**
     * Set the minimum allowed numeric number, only works if the current schema is a numeric type (integer or number)
     * 
     * @param minimum to set
     * @return this
     */
    public T minimum(double minimum) {
        if (!ensureSchemaOfType(NumericSchema.class)) {
            System.out.println("Current schema not of type NumericSchema");
        } else {
            ((NumericSchema) currentSchema).setMinimum(minimum);
        }
        return (T) this;
    }

    /**
     * Set the exclusive minimum number allowed, only works if the current schema is a numeric type (integer or number)
     * 
     * @param exclusiveMinimum to set
     * @return this
     */
    public T exclusiveMinimum(double exclusiveMinimum) {
        if (!ensureSchemaOfType(NumericSchema.class)) {
            System.out.println("Current schema not of type NumericSchema");
        } else {
            ((NumericSchema) currentSchema).setExclusiveMinimum(exclusiveMinimum);
        }
        return (T) this;
    }

    /**
     * Set the maximum number allowed, only works if the current schema is a numeric type (integer or number)
     * 
     * @param maximum to set
     * @return this
     */
    public T maximum(double maximum) {
        if (!ensureSchemaOfType(NumericSchema.class)) {
            System.out.println("Current schema not of type NumericSchema");
        } else {
            ((NumericSchema) currentSchema).setMaximum(maximum);
        }
        return (T) this;
    }

    /**
     * Set the exclusive maximum number allowed, only works if the current schema is a numeric type (integer or number)
     * 
     * @param exclusiveMaximum to set
     * @return this
     */
    public T exclusiveMaximum(double exclusiveMaximum) {
        if (!ensureSchemaOfType(NumericSchema.class)) {
            System.out.println("Current schema not of type NumericSchema");
        } else {
            ((NumericSchema) currentSchema).setExclusiveMaximum(exclusiveMaximum);
        }
        return (T) this;
    }

    /**
     * Set the multiple of constraint, only works if the current schema is a numeric type (integer or number)
     * 
     * @param multipleOf to set
     * @return this
     */
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
    
    /**
     * Initiate a JSON Schema as an object schema.
     * 
     * @return this
     */
    public T object() {
        currentSchema = new ObjectSchema();
        rootSchema = currentSchema;
        return (T) this;
    }

    /**
     * Add a given property of type to the object, only works if the current schema is of type ObjectSchema.
     * 
     * @param propertyName to use
     * @param type to create
     * @return this
     */
    public T property(String propertyName, SimpleType type) {
        return property(propertyName, type, false);
    }

    /**
     * Add a given property of type to the object, only works if the current schema is of type ObjectSchema.
     * 
     * @param propertyName to use
     * @param type to create
     * @param required
     * @return this
     */
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

    /**
     * Set the minimum amount of properties allowed, only works if the current schema is of type ObjectSchema.
     * 
     * @param minProperties to set
     * @return this
     */
    public T minProperties(int minProperties) {
        if (!ensureSchemaOfType(ObjectSchema.class)) {
            System.out.println("Current schema not of type ObjectSchema");
        } else {
            ((ObjectSchema) currentSchema).setMinProperties(minProperties);
        }
        return (T) this;
    }


    /**
     * Set the maximum amount of properties allowed, only works if the current schema is of type ObjectSchema.
     * 
     * @param maxProperties to set
     * @return this
     */
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

    /**
     * Return the build Schema object of the root.
     * 
     * @return rootSchema
     */
    public Schema build() {
        return rootSchema;
    }

    /**
     * Traverse to the parent Schema, only works if there are any.
     * 
     * @return 
     */
    public T parent() {
        if(parentList.size() > 0)
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

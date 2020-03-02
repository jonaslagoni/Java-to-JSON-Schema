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
package com.json_schema.builder.model.draft7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lagoni
 */
public class ObjectSchema extends Schema {

    private Map<String, Schema> properties;
    private List<String> required;
    private Integer minProperties;
    private Integer maxProperties;
    private Map<String, List<String>> dependencies;

    public ObjectSchema() {
        super.addType(SimpleType.OBJECT);
    }

    /**
     * @return the properties
     */
    public Map<String, Schema> getProperties() {
        return properties;
    }

    /**
     * @param properties the properties to set
     */
    public void setProperties(Map<String, Schema> properties) {
        this.properties = properties;
    }

    /**
     *
     * @param propertyName the name of the property
     * @param schema the schema object to addType as schema to the property name
     */
    public void addProperty(String propertyName, Schema schema) {
        if (this.properties == null) {
            this.properties = new HashMap();
        }
        this.properties.put(propertyName, schema);
    }

    /**
     * @return the required
     */
    public List<String> getRequired() {
        return required;
    }

    /**
     * @param required the required to set
     */
    public void setRequired(List<String> required) {
        this.required = required;
    }

    /**
     * @param property the required property
     */
    public void addRequired(String property) {
        if (this.required == null) {
            this.required = new ArrayList();
        }
        this.required.add(property);
    }

    /**
     * @return the minProperties
     */
    public Integer getMinProperties() {
        return minProperties;
    }

    /**
     * @param minProperties the minProperties to set
     */
    public void setMinProperties(Integer minProperties) {
        this.minProperties = minProperties;
    }

    /**
     * @return the maxProperties
     */
    public Integer getMaxProperties() {
        return maxProperties;
    }

    /**
     * @param maxProperties the maxProperties to set
     */
    public void setMaxProperties(Integer maxProperties) {
        this.maxProperties = maxProperties;
    }

    /**
     * @return the dependencies
     */
    public Map<String, List<String>> getDependencies() {
        return dependencies;
    }

    /**
     * @param dependencies the dependencies to set
     */
    public void setDependencies(Map<String, List<String>> dependencies) {
        this.dependencies = dependencies;
    }

}

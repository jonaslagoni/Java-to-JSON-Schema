/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    private String propertyNames;

    public ObjectSchema() {
        super.setType(SimpleType.OBJECT);
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
     * @param schema the schema object to add as schema to the property name
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

    /**
     * @return the propertyNames
     */
    public String getPropertyNames() {
        return propertyNames;
    }

    /**
     * @param propertyNames the propertyNames to set
     */
    public void setPropertyNames(String propertyNames) {
        this.propertyNames = propertyNames;
    }
}

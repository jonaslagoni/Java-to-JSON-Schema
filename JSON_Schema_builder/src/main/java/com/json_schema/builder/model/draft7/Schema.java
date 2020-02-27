/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.json_schema.builder.model.draft7;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lagoni
 */
@JsonInclude(Include.NON_NULL)
public class Schema {
    private List<Schema> items;
    private List<SimpleType> type;
    private Map<String, Schema> properties;
    private List<String> required;
    private List<Schema> anyOf;
    private List<Schema> allOf;
    private List<Schema> oneOf;
    private String title;
    private String description;
    private Double minimum;
    private String format;
    public Schema(){
    }

    @Override
    public String toString() {
        return "Schema{" + "items=" + getItems() + ", type=" + getType() + ", properties=" + getProperties() + ", anyOf=" + getAnyOf() + ", allOf=" + getAllOf() + ", oneOf=" + getOneOf() + '}';
    }
    
    public String toJson() throws IOException{
        // Creating Object of ObjectMapper define in Jakson Api 
        ObjectMapper Obj = new ObjectMapper();
        return Obj.writeValueAsString(this);
    }

    /**
     * @return the items
     */
    public List<Schema> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<Schema> items) {
        this.items = items;
    }

    /**
     * @return the type
     */
    public List<SimpleType> getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(SimpleType type) {
        if(this.type == null)
            this.type = new ArrayList();
        this.type.add(type);
    }
    /**
     * @param type the type to set
     */
    public void setType(List<SimpleType> type) {
        this.type = type;
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
    public void addProperty(String propertyName, Schema schema){
        if(this.properties == null)
            this.properties = new HashMap();
        this.properties.put(propertyName, schema);
    }

    /**
     * @return the anyOf
     */
    public List<Schema> getAnyOf() {
        return anyOf;
    }

    /**
     * @param anyOf the anyOf to set
     */
    public void setAnyOf(List<Schema> anyOf) {
        this.anyOf = anyOf;
    }

    /**
     * @return the allOf
     */
    public List<Schema> getAllOf() {
        return allOf;
    }

    /**
     * @param allOf the allOf to set
     */
    public void setAllOf(List<Schema> allOf) {
        this.allOf = allOf;
    }

    /**
     * @return the oneOf
     */
    public List<Schema> getOneOf() {
        return oneOf;
    }

    /**
     * @param oneOf the oneOf to set
     */
    public void setOneOf(List<Schema> oneOf) {
        this.oneOf = oneOf;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the minimum
     */
    public Double getMinimum() {
        return minimum;
    }

    /**
     * @param minimum the minimum to set
     */
    public void setMinimum(Double minimum) {
        this.minimum = minimum;
    }

    /**
     * @return the format
     */
    public String getFormat() {
        return format;
    }

    /**
     * @param format the format to set
     */
    public void setFormat(String format) {
        this.format = format;
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
        if(this.required == null)
            this.required = new ArrayList();
        this.required.add(property);
    }
}

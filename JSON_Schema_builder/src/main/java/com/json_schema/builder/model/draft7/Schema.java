/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.json_schema.builder.model.draft7;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lagoni
 */
@JsonInclude(Include.NON_NULL)
public class Schema {

    private List<SimpleType> type;
    @JsonProperty("enum")
    private List<Object> enums;
    private List<Schema> anyOf;
    private List<Schema> allOf;
    private List<Schema> oneOf;
    private String title;
    private String description;
    @JsonProperty("default")
    private String defaultValue;
    @JsonProperty("if")
    private Schema schemaIf;
    @JsonProperty("then")
    private Schema schemaThen;
    @JsonProperty("else")
    private Schema schemaElse;

    public Schema() {
    }

    public String toJson() throws IOException {
        // Creating Object of ObjectMapper define in Jakson Api
        ObjectMapper Obj = new ObjectMapper();
        return Obj.writeValueAsString(this);
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
        if (this.type == null) {
            this.type = new ArrayList();
        }
        this.type.add(type);
    }

    /**
     * @param type the type to set
     */
    public void setType(List<SimpleType> type) {
        this.type = type;
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
     * @return the enums
     */
    public List<Object> getEnums() {
        return enums;
    }

    /**
     * @param enums the enums to set
     */
    public void setEnums(List<Object> enums) {
        this.enums = enums;
    }

    /**
     * @return the defaultValue
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * @param defaultValue the defaultValue to set
     */
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     * @return the schemaIf
     */
    public Schema getSchemaIf() {
        return schemaIf;
    }

    /**
     * @param schemaIf the schemaIf to set
     */
    public void setSchemaIf(Schema schemaIf) {
        this.schemaIf = schemaIf;
    }

    /**
     * @return the schemaThen
     */
    public Schema getSchemaThen() {
        return schemaThen;
    }

    /**
     * @param schemaThen the schemaThen to set
     */
    public void setSchemaThen(Schema schemaThen) {
        this.schemaThen = schemaThen;
    }

    /**
     * @return the schemaElse
     */
    public Schema getSchemaElse() {
        return schemaElse;
    }

    /**
     * @param schemaElse the schemaElse to set
     */
    public void setSchemaElse(Schema schemaElse) {
        this.schemaElse = schemaElse;
    }

}

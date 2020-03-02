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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    public String toJson() throws JsonProcessingException {
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
    public void addType(SimpleType type) {
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
     *
     * @param schema to add
     */
    public void addAnyOf(Schema schema) {
        if (this.anyOf == null) {
            this.anyOf = new ArrayList();
        }
        this.anyOf.add(schema);
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
     *
     * @param schema to add
     */
    public void addAllOf(Schema schema) {
        if (this.allOf == null) {
            this.allOf = new ArrayList();
        }
        this.allOf.add(schema);
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
     *
     * @param schema to add
     */
    public void addOneOf(Schema schema) {
        if (this.oneOf == null) {
            this.oneOf = new ArrayList();
        }
        this.oneOf.add(schema);
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

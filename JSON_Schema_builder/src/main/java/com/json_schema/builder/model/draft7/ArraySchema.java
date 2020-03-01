/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.json_schema.builder.model.draft7;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lagoni
 */
public class ArraySchema extends Schema {

    private List<Schema> items;
    private List<Schema> contains;
    private Boolean additionalItems;
    private Integer minItems;
    private Integer maxItems;
    private Boolean uniqueItems;

    public ArraySchema() {
        super.addType(SimpleType.ARRAY);
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
     * @param item the schema item to addType
     */
    public void addItem(Schema item) {
        if (this.items == null) {
            this.items = new ArrayList();
        }
        this.items.add(item);
    }

    /**
     * @return the contains
     */
    public List<Schema> getContains() {
        return contains;
    }

    /**
     * @param contains the contains to set
     */
    public void setContains(List<Schema> contains) {
        this.contains = contains;
    }

    /**
     * @param contain the schema to contain
     */
    public void addContain(Schema contain) {
        if (this.contains == null) {
            this.contains = new ArrayList();
        }
        this.contains.add(contain);
    }

    /**
     * @return the additionalItems
     */
    public Object getAdditionalItems() {
        return additionalItems;
    }

    /**
     * @param additionalItems the additionalItems to set
     */
    public void setAdditionalItems(Boolean additionalItems) {
        this.additionalItems = additionalItems;
    }

    /**
     * @return the minItems
     */
    public Integer getMinItems() {
        return minItems;
    }

    /**
     * @param minItems the minItems to set
     */
    public void setMinItems(Integer minItems) {
        this.minItems = minItems;
    }

    /**
     * @return the maxItems
     */
    public Integer getMaxItems() {
        return maxItems;
    }

    /**
     * @param maxItems the maxItems to set
     */
    public void setMaxItems(Integer maxItems) {
        this.maxItems = maxItems;
    }

    /**
     * @return the uniqueItems
     */
    public Boolean getUniqueItems() {
        return uniqueItems;
    }

    /**
     * @param uniqueItems the uniqueItems to set
     */
    public void setUniqueItems(Boolean uniqueItems) {
        this.uniqueItems = uniqueItems;
    }

}

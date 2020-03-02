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

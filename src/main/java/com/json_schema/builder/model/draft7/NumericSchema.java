/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.json_schema.builder.model.draft7;

/**
 *
 * @author Lagoni
 */
public abstract class NumericSchema extends Schema {

    private Double minimum;
    private Double exclusiveMinimum;
    private Double maximum;
    private Double exclusiveMaximum;
    private Double multipleOf;

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
     * @return the exclusiveMinimum
     */
    public Double getExclusiveMinimum() {
        return exclusiveMinimum;
    }

    /**
     * @param exclusiveMinimum the exclusiveMinimum to set
     */
    public void setExclusiveMinimum(Double exclusiveMinimum) {
        this.exclusiveMinimum = exclusiveMinimum;
    }

    /**
     * @return the maximum
     */
    public Double getMaximum() {
        return maximum;
    }

    /**
     * @param maximum the maximum to set
     */
    public void setMaximum(Double maximum) {
        this.maximum = maximum;
    }

    /**
     * @return the exclusiveMaximum
     */
    public Double getExclusiveMaximum() {
        return exclusiveMaximum;
    }

    /**
     * @param exclusiveMaximum the exclusiveMaximum to set
     */
    public void setExclusiveMaximum(Double exclusiveMaximum) {
        this.exclusiveMaximum = exclusiveMaximum;
    }

    /**
     * @return the multipleOf
     */
    public Double getMultipleOf() {
        return multipleOf;
    }

    /**
     * @param multipleOf the multipleOf to set
     */
    public void setMultipleOf(Double multipleOf) {
        this.multipleOf = multipleOf;
    }
}

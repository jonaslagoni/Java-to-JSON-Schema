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

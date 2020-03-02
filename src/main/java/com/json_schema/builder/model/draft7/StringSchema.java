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
public class StringSchema extends Schema {

    private String pattern;
    private StringFormat format;
    private Integer minLength;
    private Integer maxLength;
    private ContentEncoding contentEncoding;
    private String contentMediaType;

    public StringSchema() {
        super.addType(SimpleType.STRING);
    }

    /**
     * @return the pattern
     */
    public String getPattern() {
        return pattern;
    }

    /**
     * @param pattern the pattern to set
     */
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /**
     * @return the format
     */
    public StringFormat getFormat() {
        return format;
    }

    /**
     * @param format the format to set
     */
    public void setFormat(StringFormat format) {
        this.format = format;
    }

    /**
     * @return the minLength
     */
    public Integer getMinLength() {
        return minLength;
    }

    /**
     * @param minLength the minLength to set
     */
    public void setMinLength(Integer minLength) {
        this.minLength = minLength;
    }

    /**
     * @return the maxLength
     */
    public Integer getMaxLength() {
        return maxLength;
    }

    /**
     * @param maxLength the maxLength to set
     */
    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    /**
     * @return the contentEncoding
     */
    public ContentEncoding getContentEncoding() {
        return contentEncoding;
    }

    /**
     * @param contentEncoding the contentEncoding to set
     */
    public void setContentEncoding(ContentEncoding contentEncoding) {
        this.contentEncoding = contentEncoding;
    }

    /**
     * @return the contentMediaType
     */
    public String getContentMediaType() {
        return contentMediaType;
    }

    /**
     * @param contentMediaType the contentMediaType to set
     */
    public void setContentMediaType(String contentMediaType) {
        this.contentMediaType = contentMediaType;
    }
}

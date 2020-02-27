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
public class StringSchema extends Schema {

    private String pattern;
    private StringFormat format;
    private int minLength;
    private int maxLength;
    private ContentEncoding contentEncoding;
    private String contentMediaType;

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
    public int getMinLength() {
        return minLength;
    }

    /**
     * @param minLength the minLength to set
     */
    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    /**
     * @return the maxLength
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * @param maxLength the maxLength to set
     */
    public void setMaxLength(int maxLength) {
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

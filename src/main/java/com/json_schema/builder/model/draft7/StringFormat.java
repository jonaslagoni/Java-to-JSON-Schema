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

import com.fasterxml.jackson.annotation.JsonValue;

/**
 *
 * @author Lagoni
 */
public enum StringFormat {
    DATE_TIME("date-time"),
    TIME("time"),
    DATE("date"),
    EMAIL("email"),
    IDN_EMAIL("idn-email"),
    HOSTNAME("hostname"),
    IDN_HOSTNAME("idn-hostname"),
    IPV4("ipv4"),
    IPV6("ipv6"),
    URI("uri"),
    URI_REFERENCE("uri_reference"),
    IRI("iri"),
    IRI_REFERENCE("iri-reference"),
    URI_TEMPLATE("uri-template"),
    JSON_POINTER("json-pointer"),
    RELATIVE_JSON_POINTER("relative-json-pointer"),
    REGEX("regex");

    @JsonValue
    private String format;

    private StringFormat(String format) {
        this.format = format;
    }

    /**
     * @return the type
     */
    public String getFormat() {
        return format;
    }

}

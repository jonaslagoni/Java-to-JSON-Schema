/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

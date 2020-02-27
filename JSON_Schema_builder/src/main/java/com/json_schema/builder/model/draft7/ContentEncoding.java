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
public enum ContentEncoding {
    BIT_7("7bit"),
    BIT_8("7bit"),
    BINARY("binary"),
    QUOTED_PRINTABLE("quoted-printable"),
    BASE_64("base64");

    @JsonValue
    private String type;

    private ContentEncoding(String type) {
        this.type = type;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

}

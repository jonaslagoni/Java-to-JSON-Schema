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
public class BooleanSchema extends Schema {

    public BooleanSchema() {
        super.addType(SimpleType.BOOLEAN);
    }
}
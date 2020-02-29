/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.json.schema.builder.draft7;

import com.json_schema.builder.model.draft7.ObjectSchema;

/**
 *
 * @author lagoni
 */
public class MainSchemaBuilder implements Builder {

    public MainSchemaBuilder() {
    }

    public ObjectSchemaBuilder<MainSchemaBuilder> object() {
        return new ObjectSchemaBuilder(this, new ObjectSchema());
    }

}

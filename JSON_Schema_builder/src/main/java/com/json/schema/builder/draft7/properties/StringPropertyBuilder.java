/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.json.schema.builder.draft7.properties;

import com.json.schema.builder.draft7.ObjectSchemaBuilder;
import com.json_schema.builder.model.draft7.Schema;
import com.json_schema.builder.model.draft7.StringFormat;
import com.json_schema.builder.model.draft7.StringSchema;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lagoni
 */
public class StringPropertyBuilder extends AbstractPropertyBuilder<StringPropertyBuilder, StringSchema> {

    public StringPropertyBuilder() {
        this(new StringSchema());
    }

    public StringPropertyBuilder(StringSchema schema) {
        super(schema);
    }

    public StringPropertyBuilder(ObjectSchemaBuilder ob) {
        this(ob, new StringSchema());
    }

    public StringPropertyBuilder(ObjectSchemaBuilder ob, StringSchema schema) {
        super(ob, schema);
    }

// <editor-fold desc="Methods for fluent interface">
    /**
     *
     * @param format
     * @return
     */
    public StringPropertyBuilder format(StringFormat format) {
        this.getSchema().setFormat(format);
        return this;
    }

    public StringPropertyBuilder allOfFormats(List<StringFormat> formats) {
        List<Schema> formatSchemas = new ArrayList();
        for (StringFormat f : formats) {
            StringSchema formatSchema = new StringSchema();
            formatSchema.setFormat(f);
        }
        this.getSchema().setAllOf(formatSchemas);
        return this;
    }

// </editor-fold>
}

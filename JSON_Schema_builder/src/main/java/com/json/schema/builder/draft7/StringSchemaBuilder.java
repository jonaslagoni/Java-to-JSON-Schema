/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.json.schema.builder.draft7;

import com.json_schema.builder.model.draft7.Schema;
import com.json_schema.builder.model.draft7.StringFormat;
import com.json_schema.builder.model.draft7.StringSchema;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lagoni
 * @param <ParentBuilder>
 */
public class StringSchemaBuilder<ParentBuilder extends Builder> extends SchemaBuilder<ParentBuilder, StringSchemaBuilder, StringSchema> {

    public StringSchemaBuilder(ParentBuilder parentBuilder, StringSchema schema) {
        super.setSchema(schema);
        super.setParentBuilder(parentBuilder);
    }

// <editor-fold desc="Methods for fluent interface">
    public StringSchemaBuilder<ParentBuilder> title(String title) {
        return super.title(title);
    }

    public StringSchemaBuilder<ParentBuilder> description(String description) {
        return super.description(description);
    }

    /**
     *
     * @param format
     * @return
     */
    public StringSchemaBuilder format(StringFormat format) {
        this.getSchema().setFormat(format);
        return this;
    }

    public StringSchemaBuilder allOfFormats(List<StringFormat> formats) {
        List<Schema> formatSchemas = new ArrayList();
        for (StringFormat f : formats) {
            StringSchema formatSchema = new StringSchema();
            formatSchema.setFormat(f);
        }
        this.getSchema().setAllOf(formatSchemas);
        return this;
    }

// </editor-fold>
    @Override
    public ParentBuilder done() {
        return super.getParentBuilder();
    }
}

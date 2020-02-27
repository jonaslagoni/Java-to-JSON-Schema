/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.json.schema.builder.draft7;

import com.json.schema.builder.draft7.properties.AbstractPropertyBuilder;
import com.json.schema.builder.draft7.properties.IntegerPropertyBuilder;
import com.json.schema.builder.draft7.properties.NumberPropertyBuilder;
import com.json.schema.builder.draft7.properties.StringPropertyBuilder;
import com.json_schema.builder.model.draft7.Schema;
import com.json_schema.builder.model.draft7.SimpleType;

/**
 *
 * @author lagoni
 */
public class ObjectSchemaBuilder implements SecondaryBuilders<SchemaBuilder>{
    private Schema schema;
    private ObjectSchemaBuilder ob;
    private SchemaBuilder sb;
    
    public ObjectSchemaBuilder(SchemaBuilder sb, Schema schema){
        this(schema);
        this.sb = sb;
    }
    public ObjectSchemaBuilder(ObjectSchemaBuilder ob, Schema schema){
        this(schema);
        this.ob = ob;
    }
    public ObjectSchemaBuilder(ObjectSchemaBuilder ob){
        this(ob, new Schema());
    }
    public ObjectSchemaBuilder(SchemaBuilder sb){
        this(sb, new Schema());
    }
    public ObjectSchemaBuilder(){
        this(new Schema());
    }
    public ObjectSchemaBuilder(Schema schema){
        this.setSchema(schema);
    }
    
    
    
// <editor-fold desc="Methods for fluent interface">
    
// <editor-fold desc="Properties">
    
    
    public ObjectSchemaBuilder objectProperty(String propertyName){
        return this.objectProperty(propertyName, false);
    }
    public ObjectSchemaBuilder objectProperty(String propertyName, boolean required){
        return new ObjectSchemaBuilder(this, this.property(propertyName, required));
    }
    
    public StringPropertyBuilder stringProperty(String propertyName){
        return this.stringProperty(propertyName, false);
    }
    public StringPropertyBuilder stringProperty(String propertyName, boolean required){
        return new StringPropertyBuilder(this, this.property(propertyName, required)).title(propertyName);
    }
    
    
    public IntegerPropertyBuilder integerProperty(String propertyName){
        return this.integerProperty(propertyName, false);
    }
    public IntegerPropertyBuilder integerProperty(String propertyName, boolean required){
        return new IntegerPropertyBuilder(this, this.property(propertyName, required)).title(propertyName);
    }
    
    public NumberPropertyBuilder numberProperty(String propertyName){
        return this.numberProperty(propertyName, false);
    }
    public NumberPropertyBuilder numberProperty(String propertyName, boolean required){
        return new NumberPropertyBuilder(this, this.property(propertyName, required)).title(propertyName);
    }
    
    private Schema property(String propertyName, boolean required){
        Schema schema = new Schema();
        this.schema.addProperty(propertyName, schema);
        if(required)
            this.schema.addRequired(propertyName);
        return schema;
    }
    
// </editor-fold>
    
// </editor-fold>
    
    
    /**
     * 
     * @return 
     */
    @Override
    public SchemaBuilder done() {
        if(sb == null){
            sb = new SchemaBuilder();
            sb.setRootSchema(schema);
        }
        return sb;
    }

    @Override
    public Schema build() {
        return sb.build();
    }


    /**
     * @param schema the schema to set
     */
    private void setSchema(Schema schema) {
        this.schema = schema;
        this.schema.setType(SimpleType.OBJECT);
    }
    
}

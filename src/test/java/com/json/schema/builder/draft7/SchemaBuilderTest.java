/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.json.schema.builder.draft7;

import com.json_schema.builder.draft7.JsonSchemaBuilder;
import com.json_schema.builder.model.draft7.SimpleType;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author lagoni
 */
public class SchemaBuilderTest {

    /**
     * Test of object method, of class SchemaBuilder.
     */
    @Test
    public void testSimpleStringObject() throws IOException {
        System.out.println("object");
        JsonSchemaBuilder instance = new JsonSchemaBuilder();
        instance.object().property("TestProp", SimpleType.STRING);
        String expResult = "{\"type\":[\"object\"],\"properties\":{\"TestProp\":{\"type\":[\"string\"]}}}";
        String result = instance.build().toJson();
        assertEquals(expResult, result);
    }

    /**
     * Test of object method, of class SchemaBuilder.
     */
    @Test
    public void testSimpleStringObjectWithTitle() throws IOException {
        System.out.println("object");
        JsonSchemaBuilder instance = new JsonSchemaBuilder();
        instance.object().property("TestProp", SimpleType.STRING).title("TestTitle");
        String expResult = "{\"type\":[\"object\"],\"properties\":{\"TestProp\":{\"type\":[\"string\"],\"title\":\"TestTitle\"}}}";
        String result = instance.build().toJson();
        assertEquals(expResult, result);
    }

    /**
     * Test of object method, of class SchemaBuilder.
     */
    @Test
    public void testSimpleStringObjectWithDescriptionAndTitle() throws IOException {
        System.out.println("object");
        JsonSchemaBuilder instance = new JsonSchemaBuilder();
        instance.object().property("TestProp", SimpleType.STRING).description("TestDescription").title("TestTitle");
        String expResult = "{\"type\":[\"object\"],\"properties\":{\"TestProp\":{\"type\":[\"string\"],\"title\":\"TestTitle\",\"description\":\"TestDescription\"}}}";
        String result = instance.build().toJson();
        assertEquals(expResult, result);
    }

    /**
     * Test of object method, of class SchemaBuilder.
     */
    @Test
    public void testSimpleStringObjectWithDescription() throws IOException {
        System.out.println("object");
        JsonSchemaBuilder instance = new JsonSchemaBuilder();
        instance.object().property("TestProp", SimpleType.STRING).description("TestDescription");
        String expResult = "{\"type\":[\"object\"],\"properties\":{\"TestProp\":{\"type\":[\"string\"],\"description\":\"TestDescription\"}}}";
        String result = instance.build().toJson();
        assertEquals(expResult, result);
    }

}

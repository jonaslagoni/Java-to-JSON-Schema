/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.json.schema.builder.draft7;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

/**
 *
 * @author lagoni
 */
public class SchemaBuilderTest {
    
    /**
     * Test of object method, of class MainSchemaBuilder.
     */
    @Test
    public void testSimpleStringObject() throws IOException {
        System.out.println("object");
        MainSchemaBuilder instance = new MainSchemaBuilder();
        instance.object().stringProperty("TestProp");
        String expResult = "{\"type\":[\"object\"],\"properties\":{\"TestProp\":{\"type\":[\"string\"],\"title\":\"TestProp\"}}}";
        String result = instance.build().toJson();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of object method, of class MainSchemaBuilder.
     */
    @Test
    public void testSimpleStringObjectWithDescription() throws IOException {
        System.out.println("object");
        MainSchemaBuilder instance = new MainSchemaBuilder();
        instance.object().stringProperty("TestProp").description("TestDescription");
        String expResult = "{\"type\":[\"object\"],\"properties\":{\"TestProp\":{\"type\":[\"string\"],\"title\":\"TestProp\",\"description\":\"TestDescription\"}}}";
        String result = instance.build().toJson();
        assertEquals(expResult, result);
    }

    
}

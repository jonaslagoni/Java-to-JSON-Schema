/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.json.schema.builder.draft7;

import com.json_schema.builder.model.draft7.Schema;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author lagoni
 */
public class CompleteBuilderTest {
    
    /**
     * Test of object method, of class SchemaBuilder.
     */
    @Test
    public void testScenario1() throws IOException {
        System.out.println("object");
        SchemaBuilder instance = new SchemaBuilder();
        instance.object().integerProperty("id").
                        minimum(0).
                        description("Id of the streetlight.").done().
                    integerProperty("lumens").
                        minimum(0).
                        description("Light intensity measured in lumens.").done().
                    stringProperty("sentAt").
                        format("date-time").
                        description("Date and time when the message was sent.");
        String expResult = "{\"type\":[\"object\"],\"properties\":{\"TestProp\":{\"type\":[\"string\"],\"title\":\"TestProp\"}}}";
        String result = instance.build().toJson();
        assertEquals(expResult, result);
    }
}

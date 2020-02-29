/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.json.schema.builder.draft7;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author lagoni
 */
public class CompleteBuilderTest {

    /**
     * Test of object method, of class MainSchemaBuilder.
     */
    @Test
    public void testScenario1() throws IOException {
        MainSchemaBuilder instance = new MainSchemaBuilder();
        instance.object().integerProperty("").done();
        instance.object().integerProperty("id").
                minimum(0).
                description("Id of the streetlight.")
                .done().
                integerProperty("lumens").
                minimum(0).
                description("Light intensity measured in lumens.").
                .
        done().
                integerProperty("lumens").
                minimum(0).
                description("Light intensity measured in lumens.")
                .done().
                integerProperty("lumens").
                minimum(0).
                description("Light intensity measured in lumens.");
//                stringProperty("sentAt").
//                format(StringFormat.DATE_TIME).
//                description("Date and time when the message was sent.");
        String expResult = "{\"type\":[\"object\"],\"properties\":{\"TestProp\":{\"type\":[\"string\"],\"title\":\"TestProp\"}}}";
        String result = instance.build().toJson();
        assertEquals(expResult, result);
    }
}

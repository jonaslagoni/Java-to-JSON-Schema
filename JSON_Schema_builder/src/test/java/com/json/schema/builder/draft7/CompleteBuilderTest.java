/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.json.schema.builder.draft7;

import com.json_schema.builder.draft7.JsonSchemaBuilder;
import com.json_schema.builder.model.draft7.SimpleType;
import com.json_schema.builder.model.draft7.StringFormat;
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
        JsonSchemaBuilder instance = new JsonSchemaBuilder();
        instance.object().
                property("id", SimpleType.INTEGER).
                minimum(0).
                description("Id of the streetlight.").parent().
                property("lumens", SimpleType.INTEGER).
                minimum(0).
                description("Light intensity measured in lumens.").parent().
                property("sentAt", SimpleType.STRING).
                format(StringFormat.DATE_TIME).
                description("Date and time when the message was sent.");
        String expResult = "{\"type\":[\"object\"],\"properties\":{\"lumens\":{\"type\":[\"integer\"],\"description\":\"Light intensity measured in lumens.\",\"minimum\":0.0},\"id\":{\"type\":[\"integer\"],\"description\":\"Id of the streetlight.\",\"minimum\":0.0},\"sentAt\":{\"type\":[\"string\"],\"description\":\"Date and time when the message was sent.\",\"format\":\"date-time\"}}}";
        String result = instance.build().toJson();
        assertEquals(expResult, result);
    }
}

/*
 * The MIT License
 *
 * Copyright 2020 lagoni.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
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

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

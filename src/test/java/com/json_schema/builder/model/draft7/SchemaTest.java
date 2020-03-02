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
package com.json_schema.builder.model.draft7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lagoni
 */
public class SchemaTest {

    /**
     * Test of setItems method, of class Schema.
     */
    @Test
    public void testSetItems() throws Exception {
        System.out.println("setItems");
        Schema itemSchema = new Schema();
        itemSchema.setTitle("TestTitle");
        List<Schema> items = new ArrayList();
        items.add(itemSchema);
        ArraySchema instance = new ArraySchema();
        instance.setItems(items);
        String expResult = "{\"type\":[\"array\"],\"items\":[{\"title\":\"TestTitle\"}]}";
        String result = instance.toJson();
        assertEquals(expResult, result);
    }

    /**
     * Test of addType method, of class Schema.
     */
    @Test
    public void testSetType() throws Exception {
        System.out.println("setType");
        List<SimpleType> type = new ArrayList();
        type.add(SimpleType.INTEGER);
        Schema instance = new Schema();
        instance.setType(type);
        String expResult = "{\"type\":[\"integer\"]}";
        String result = instance.toJson();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProperties method, of class Schema.
     */
    @Test
    public void testSetProperties() throws Exception {
        System.out.println("setProperties");
        Schema propertySchema = new Schema();
        propertySchema.setTitle("TestTitle");
        Map<String, Schema> properties = new HashMap();
        properties.put("TestProperty", propertySchema);
        ObjectSchema instance = new ObjectSchema();
        instance.setProperties(properties);
        String expResult = "{\"type\":[\"object\"],\"properties\":{\"TestProperty\":{\"title\":\"TestTitle\"}}}";
        String result = instance.toJson();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAnyOf method, of class Schema.
     */
    @Test
    public void testSetAnyOf() throws Exception {
        System.out.println("setAnyOf");
        Schema anyOfSchema = new Schema();
        anyOfSchema.setTitle("TestTitle");
        List<Schema> anyOf = new ArrayList();
        anyOf.add(anyOfSchema);
        Schema instance = new Schema();
        instance.setAnyOf(anyOf);
        String expResult = "{\"anyOf\":[{\"title\":\"TestTitle\"}]}";
        String result = instance.toJson();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAllOf method, of class Schema.
     */
    @Test
    public void testSetAllOf() throws Exception {
        System.out.println("setAllOf");
        Schema allOfSchema = new Schema();
        allOfSchema.setTitle("TestTitle");
        List<Schema> allOf = new ArrayList();
        allOf.add(allOfSchema);
        Schema instance = new Schema();
        instance.setAllOf(allOf);
        String expResult = "{\"allOf\":[{\"title\":\"TestTitle\"}]}";
        String result = instance.toJson();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOneOf method, of class Schema.
     */
    @Test
    public void testSetOneOf() throws Exception {
        System.out.println("setOneOf");
        Schema oneOfSchema = new Schema();
        oneOfSchema.setTitle("TestTitle");
        List<Schema> oneOf = new ArrayList();
        oneOf.add(oneOfSchema);
        Schema instance = new Schema();
        instance.setOneOf(oneOf);
        String expResult = "{\"oneOf\":[{\"title\":\"TestTitle\"}]}";
        String result = instance.toJson();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTitle method, of class Schema.
     */
    @Test
    public void testSetTitle() throws Exception {
        System.out.println("setTitle");
        Schema instance = new Schema();
        instance.setTitle("TestTitle");
        String expResult = "{\"title\":\"TestTitle\"}";
        String result = instance.toJson();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class Schema.
     */
    @Test
    public void testSetDescription() throws Exception {
        System.out.println("setDescription");
        Schema instance = new Schema();
        instance.setDescription("TestDescription");
        String expResult = "{\"description\":\"TestDescription\"}";
        String result = instance.toJson();
        assertEquals(expResult, result);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

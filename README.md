# JSON Schema Draft 7 builder

This JSON Schema builder can be used to create JSON Schemas or even extending the builder i.e. see [AsyncAPI builder](https://github.com/jonaslagoni/AsyncAPI-internal-DSL).

The builder is very fluent and therefore it can be error pruning which methods which can be used when, check out [Method combinations](#Method-combinations) section for complet information about how to use and initilize the builder. Further the builder does not include a comprehensive check for nullpoint errors.

The following is an example usecase of the builder:

```java
new JsonSchemaBuilder().
    object().
        property("id", SimpleType.INTEGER).
            minimum(0).
            description("Id of the streetlight.").parent().
        property("lumens", SimpleType.INTEGER).
            minimum(0).
            description("Light intensity measured in lumens.").parent().
        property("sentAt", SimpleType.STRING).
            format(StringFormat.DATE_TIME).
            description("Date and time when the message was sent.");
```

## Method combinations

In below section an attempt is given to try an explain how to use the builder with the different method combinations which are available.

### Initiating the root

Initiating the root is one of the first methods that is required to be called to prime the builder, any of the following methods can be used:

```java
new JsonSchemaBuilder().
    object(). //Use an Object schema as root schema.
    nullSchema(). //Use a null type as a root schema.
    booleanSchema(). //Use a boolean type as a root schema.
    string(). //Use a string type as a root schema.
    array(). //Use an array type as a root schema.
    number(). //Use a number type as a root schema.
    integer(). //Use an integer type as a root schema.
```

Based on which root schema is used it opens up for a number of methods:

- [Generic methods](#Generic-methods) and [special methods](#Special-methods) are always available no matter which root schema is choosen.
- [Object schema](#Object-schema) are available to the `object()` root schema.
- `nullSchema()` and `booleanSchema()` root schemas does not have any extra methods.
- [String schema](#String-schema) are available to the `string()` root schema.
- [Array schema](#Array-schema) are available to the `array()` root schema.
- [Integer and Number schema](#Integer-and-Number-schema) are available to the `number()` and `integer()` root schema.

### Special methods

`build()` are always available to return the root Schema object, which can then return the JSON string representation by calling `toJson()` i.e:

```java
String jsonString = new JsonSchemaBuilder().booleanSchema().build().toJson();
```

`parent()` are used to return back to a previous schema. For example in the example usecase defined in the beginning of the readme `parent()` are used to move from the inner integer schemas to the root Object schema to define more properties.

```java
new JsonSchemaBuilder().
    object().
        property("id", SimpleType.INTEGER).
            minimum(0).
            description("Id of the streetlight.").parent().
        property("lumens", SimpleType.INTEGER).
            minimum(0).
            description("Light intensity measured in lumens.").parent().
        property("sentAt", SimpleType.STRING).
            format(StringFormat.DATE_TIME).
            description("Date and time when the message was sent.");
```

When the `SimpleType type` parameter is seen it means a new schema object is created based on the type provided and is then used as the "active" schema, use `parent()` to return to the previous schema. I.e. for the object adding a property can be done by calling `property(String propertyName, SimpleType type)` which as shown below will create an Integer schema and use that as the current schema. Which then opens up for the use of [string schema methods](#String-schema).

```java
new JsonSchemaBuilder().
    object().
        property("lumens", SimpleType.INTEGER).
            minimum(0).
            description("Light intensity measured in lumens.")
```

### Generic methods

Below is all the generic methods which available regardless of which root schema is choosen:

```java
new JsonSchemaBuilder().
    object().
    nullSchema().
    booleanSchema().
    string().
    array().
    number().
    integer().
        title(String title).
        description(String description).
        elseDo().
        thenDo().
        ifCondition().
        oneOf(SimpleType type).
        allOf(SimpleType type).
        anyOf(SimpleType type);
```

### Object schema

The following methods canbe used if the current schema is an object schema:

```java
new JsonSchemaBuilder().
    object().
        property(String propertyName, SimpleType type).
        property(String propertyName, SimpleType type, boolean required).
        minProperties(int minProperties).
        maxProperties(int maxProperties);
```

### Null schema

Does not have any extra methods.

### Boolean schema

Does not have any extra methods.

### String schema

The following methods canbe used if the current schema is a string schema:

```java
new JsonSchemaBuilder().
    string().
        pattern(String pattern).
        contentMediaType(String contentMediaType).
        encoding(ContentEncoding encoding).
        format(StringFormat format).
        minLength(int minLength).
        maxLength(int maxLength);
```

### Array schema

The following methods canbe used if the current schema is an array schema:

```java
new JsonSchemaBuilder().
    array().
        allowAdditionalItems().
        onlyUniqueItems().
        minItems(int minItems).
        maxItems(int maxItems).
        item(SimpleType type).
        contain(SimpleType type);
```

### Integer and Number schema

The following methods canbe used if the current schema is an integer and number schema:

```java
new JsonSchemaBuilder().
    number().
    integer().
        minimum(double minimum).
        exclusiveMinimum(double exclusiveMinimum).
        maximum(double maximum).
        exclusiveMaximum(double exclusiveMaximum).
        multipleOf(double multipleOf);
```

## What are not supported in the builder

Besides what the metamodel does not support, the following features are not supported in the builder:

- dependencies
- propertyNames
- anyOf, allOf, oneOf root schemas

# JSON Schema draft 7 model

The underlying metamodel for JSON Schema draft 7 does not fully support all the different options available by the specification. The below section highlights what is not available

- References
- [\$schema](https://json-schema.org/understanding-json-schema/reference/schema.html#the-schema-keyword)
- [Custom Format - besides Regular Expressions](https://json-schema.org/understanding-json-schema/reference/string.html#format)
- [Property names](https://json-schema.org/understanding-json-schema/reference/object.html#property-names)
- [Dependencies](https://json-schema.org/understanding-json-schema/reference/object.html#dependencies) - [Schema dependencies](https://json-schema.org/understanding-json-schema/reference/object.html#schema-dependencies)
- [Pattern Properties](https://json-schema.org/understanding-json-schema/reference/object.html#pattern-properties)

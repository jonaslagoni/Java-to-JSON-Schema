# JSON Schema Draft 7 builder
This JSON Schema builder can be used to create JSON Schemas or even extending the builder i.e. see [AsyncAPI builder](https://github.com/jonaslagoni/AsyncAPI-internal-DSL). 

The builder is very fluent and therefore it can be error pruning which methods which can be used when, check out 

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

## Not supported
Besides what the metamodel does not support, the following Object features are not supported in the builder:
- dependencies
- propertyNames



# JSON Schema draft 7 model

### Not supported

- References
- [\$schema](https://json-schema.org/understanding-json-schema/reference/schema.html#the-schema-keyword)

#### String

- [Custom Format - besides Regular Expressions](https://json-schema.org/understanding-json-schema/reference/string.html#format)

#### Object

- [Property names](https://json-schema.org/understanding-json-schema/reference/object.html#property-names)
- [Dependencies](https://json-schema.org/understanding-json-schema/reference/object.html#dependencies) - [Schema dependencies](https://json-schema.org/understanding-json-schema/reference/object.html#schema-dependencies)
- [Pattern Properties](https://json-schema.org/understanding-json-schema/reference/object.html#pattern-properties)

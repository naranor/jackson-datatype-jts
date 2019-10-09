
# Jackson-datatype-jts

This is a fork of the library https://github.com/bedatadriven/jackson-datatype-jts for porting from com.vividsolutions.jts to org.locationtech.jts

Jackson Module which provides custom serializers and deserializers for
[JTS Geometry](https://github.com/locationtech/jts) objects
using the [GeoJSON format](http://www.geojson.org/geojson-spec.html)

### Registering module

To use JTS geometry datatypes with Jackson, you will first need to register the module first (same as
with all Jackson datatype modules):

```java
ObjectMapper mapper = new ObjectMapper();
mapper.registerModule(new JtsModule());
```

### Reading and Writing Geometry types

After registering JTS module, [Jackson Databind](https://github.com/FasterXML/jackson-databind)
will be able to write Geometry instances as GeoJSON and
and read GeoJSON geometries as JTS Geometry objects.

To write a Point object as GeoJSON:

```java
GeometryFactory gf = new GeometryFactory();
Point point = gf.createPoint(new Coordinate(1.2345678, 2.3456789));
String geojson = objectMapper.writeValueAsString(point);
```

You can also read GeoJSON in as JTS geometry objects:

```java
InputStream in;
Point point = mapper.readValue(in, Point.class);
```

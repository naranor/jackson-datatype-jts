package com.naranor.jackson.datatype.jts.parsers;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.MultiPolygon;
import org.locationtech.jts.geom.Polygon;

import static com.naranor.jackson.datatype.jts.GeoJson.COORDINATES;

public class MultiPolygonParser extends BaseParser implements GeometryParser<MultiPolygon> {

    private PolygonParser helperParser;

    public MultiPolygonParser(GeometryFactory geometryFactory) {
        super(geometryFactory);
        helperParser = new PolygonParser(geometryFactory);
    }

    public MultiPolygon multiPolygonFromJson(JsonNode root) {
        JsonNode arrayOfPolygons = root.get(COORDINATES);
        return geometryFactory.createMultiPolygon(polygonsFromJson(arrayOfPolygons));
    }

    private Polygon[] polygonsFromJson(JsonNode arrayOfPolygons) {
        Polygon[] polygons = new Polygon[arrayOfPolygons.size()];
        for (int i = 0; i != arrayOfPolygons.size(); ++i) {
            polygons[i] = helperParser.polygonFromJsonArrayOfRings(arrayOfPolygons.get(i));
        }
        return polygons;
    }

    @Override
    public MultiPolygon geometryFromJson(JsonNode node) throws JsonMappingException {
        return multiPolygonFromJson(node);
    }
}

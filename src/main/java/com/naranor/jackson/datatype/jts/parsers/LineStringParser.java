package com.naranor.jackson.datatype.jts.parsers;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;

import static com.naranor.jackson.datatype.jts.GeoJson.COORDINATES;

public class LineStringParser extends BaseParser implements GeometryParser<LineString> {

    public LineStringParser(GeometryFactory geometryFactory) {
        super(geometryFactory);
    }

    public LineString lineStringFromJson(JsonNode root) {
        return geometryFactory.createLineString(
                PointParser.coordinatesFromJson(root.get(COORDINATES)));
    }

    @Override
    public LineString geometryFromJson(JsonNode node) throws JsonMappingException {
        return lineStringFromJson(node);
    }
}

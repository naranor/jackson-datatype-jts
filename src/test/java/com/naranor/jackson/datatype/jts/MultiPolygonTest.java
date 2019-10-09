package com.naranor.jackson.datatype.jts;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom.MultiPolygon;
import org.locationtech.jts.geom.Polygon;

public class MultiPolygonTest extends BaseJtsModuleTest<MultiPolygon> {
    @Override
    protected Class<MultiPolygon> getType() {
        return MultiPolygon.class;
    }

    @Override
    protected String createGeometryAsGeoJson() {
        return "{\"type\":\"MultiPolygon\",\"coordinates\":[[[[102.0,2.0],[103.0,2.0],[103.0,3.0],[102.0,3.0],[102.0,2.0]]]]}";
    }

    @Override
    protected MultiPolygon createGeometry() {
        LinearRing shell = gf.createLinearRing(new Coordinate[]{
                new Coordinate(102.0, 2.0), new Coordinate(103.0, 2.0),
                new Coordinate(103.0, 3.0), new Coordinate(102.0, 3.0),
                new Coordinate(102.0, 2.0)});
        return gf.createMultiPolygon(new Polygon[]{gf
                .createPolygon(shell, null)});
    }
}

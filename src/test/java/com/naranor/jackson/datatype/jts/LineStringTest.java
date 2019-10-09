package com.naranor.jackson.datatype.jts;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.LineString;

public class LineStringTest extends BaseJtsModuleTest<LineString> {
    @Override
    protected Class<LineString> getType() {
        return LineString.class;
    }

    @Override
    protected String createGeometryAsGeoJson() {
        return "{\"type\":\"LineString\",\"coordinates\":[[100.0,0.0],[101.0,1.0]]}";
    }

    @Override
    protected LineString createGeometry() {
        return gf.createLineString(new Coordinate[]{
                new Coordinate(100.0, 0.0), new Coordinate(101.0, 1.0)});
    }

}
package com.rotatingmind.stackoverflow;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Problem74259436 {

    public static void main(String[] args) {
        Point3d parentStartVertex = null;
        List<Point3d> points = new ArrayList<>();
        Point3d point3d = extracted(points);

        // ----------------------------------------------------------------------

        TreeMap<Double, Point3d> distanceMap = new TreeMap<Double, Point3d>();
        points.forEach(point -> distanceMap.put(parentStartVertex.distanceTo(point), point));
        Point3d point3d1 = distanceMap.firstEntry().getValue();
    }

    private static Point3d extracted(List<Point3d> points) {
        Point3d parentStartVertex = null;
        TreeMap<Double, Point3d> distanceMap = points.stream().collect(
                Collectors.toMap(
                        Point3d::distanceTo,
                        Function.identity(),
                        (k1, k2) -> k2,
                        TreeMap::new));
        return distanceMap.firstEntry().getValue();
    }
}

class Point3d {

    public static Double distanceTo(Point3d point) {
        return 0.0;
    }
}


package org.example.N87377;

import java.util.*;
import java.util.stream.Collectors;
import org.example.Ut;
import java.util.stream.Stream;


public class Main {
}


class Solution {
    public String[] solution(int[][] line) {

        Points points = intersections(line);

        char[][] matrix = points.toMatrix();

        return drawOnCoordinate(matrix);
    }

    // 교점 하나 구하기
    private Point intersection(int[] line1, int[] line2) {
        double A = line1[0];
        double B = line1[1];
        double E = line1[2];
        // int 끼리의 연산값은 int를 벗어날 수 없다.
        double C = line2[0];
        double D = line2[1];
        double F = line2[2];

        double divisor = A * D - B * C;

        if (divisor == 0) {
            return null;
        }

        double x = (B * F - E * D) / divisor;
        double y = (E * C - A * F) / divisor;

        if (x != (long) x) {
            return null;
        }
        if (y != (long) y) {
            return null;
        }

        return Point.of(x, y);
    }

    // 모든 교점 구하기 (정수로 이루어진 교점만)
    Points intersections(int[][] line) { // Set은 중복을 허용하지 않는다.
        Points points = Points.of();

        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                int[] line1 = line[i];
                int[] line2 = line[j];

                Point point = intersection(line1, line2);

                if (point != null) {
                    points.add(point);
                }
            }
        }
        return points;
    }

    // 교점의 위치와 필드의 위치 맞추기
    String[] drawOnCoordinate(char[][] matrix) {
        return Ut.revRange(0, matrix.length)
                .boxed()
                .map(i -> matrix[i])
                .map(row -> new String(row))
                .toArray(String[]::new);
    }
}

class Point {
    public final long x;
    public final long y;

    private Point(long x, long y) {
        this.x = x;
        this.y = y;
    }


    public static Point of(long x, long y) {
        return new Point(x, y);
    }

    public static Point of(double x, double y) {
        return of((long) x, (long) y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    // 객체의 고유키를 비교, 속도 빠름, 가독성 안좋음
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class Points implements Iterable<Point>{ // 일급콜렉션을 for each문에 사용할 수 없기 때문에 implements Iterable<Point>를 쓴다.
    private final Set<Point> data;

    private Points(Set<Point> data) {
        this.data = data;
    }

    public static Points of(Point... pointArray) {
        return new Points(
                Arrays.stream(pointArray)
                        .collect(Collectors.toCollection(HashSet::new))
        );
    }

    public boolean add(Point point) {
        return data.add(point);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Points points)) return false;
        return Objects.equals(data, points.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public Iterator<Point> iterator() { // 일급콜렉션을 for each문으로 돌리기 위해 사용
        return data.iterator();
    }

    public Stream<Point> stream() {
        return data.stream();
    }

    private Point getMinPoint() {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for (Point point : data) {
            x = Math.min(x, point.x);
            y = Math.min(y, point.y);
        }
        return Point.of(x, y);
    }

    private Point getMaxPoint() {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for (Point point : data) {
            x = Math.max(x, point.x);
            y = Math.max(y, point.y);
        }
        return Point.of(x, y);
    }

    // 필드를 (0,0) 위치로 만들기
    private Points positivePoints() {
        Point minPoint = getMinPoint();

        return Points.of(
                data.stream()
                        .map(p -> Point.of(p.x - minPoint.x, p.y - minPoint.y))
                        .toArray(Point[]::new)
        );
    }

    // 빈 필드 생성
    private char[][] emptyMatrix() {
        Point minPoint = getMinPoint();
        Point maxPoint = getMaxPoint();

        int width = (int) (maxPoint.x - minPoint.x + 1);
        int height = (int) (maxPoint.y - minPoint.y + 1);

        char[][] matrix = new char[height][width];

        Arrays.stream(matrix).forEach(row -> Arrays.fill(row, '.'));

        return matrix;
    }

    // 교점의 위치에 * 찍기
    public char[][] toMatrix() {
        char[][] matrix = emptyMatrix();
        Points points = positivePoints();

        points.forEach(p -> matrix[(int) p.y][(int) p.x] = '*');

        return matrix;
    }

}
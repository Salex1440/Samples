package com.salex.equals_hashcode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class DefineEqualsWithoutHashcode {

    public static void main(String[] args) {
        Point point = new Point(0, 0);
        Set<Point> set = new HashSet<>();
        set.add(point);

        System.out.println(set.contains(new Point(0,0)));
    }

    public static class Point {
        protected int x;
        protected int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point point)) return false;
            return x == point.x && y == point.y;
        }

//        @Override
//        public int hashCode() {
//            return Objects.hash(x, y);
//        }
    }
}

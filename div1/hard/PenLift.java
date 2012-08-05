package div1.hard;

import java.util.ArrayList;
import java.util.Collections;

/** SRM 144 */
public class PenLift {
    static ArrayList<Point> points;

    public int numTimes (String[] segments, int n) {
        ArrayList<Segment> segs = new ArrayList<Segment>();
        for (int i = 0; i < segments.length; i++) {
            String str[] = segments[i].split(" ");
            int x1 = Integer.parseInt(str[0]);
            int y1 = Integer.parseInt(str[1]);
            int x2 = Integer.parseInt(str[2]);
            int y2 = Integer.parseInt(str[3]);
            segs.add(new Segment(x1, y1, x2, y2));
        }
        for (int i = 0; i < segs.size(); i++) {
            Segment seg1 = segs.get(i);
            for (int j = i + 1; j < segs.size(); j++) {
                Segment seg2 = segs.get(j);
                if (Segment.isOverlap(seg1, seg2) == true) {
                    segs.set(i, Segment.combine(seg1, seg2));
                    segs.remove(j);
                    i--;
                    break;
                }
            }
        }
        points = new ArrayList<Point>();
        for (int i = 0; i < segs.size(); i++) {
            Segment seg = segs.get(i);
            Point p1 = new Point(seg.x1, seg.y1);
            if (points.indexOf(p1) == -1) {
                points.add(p1);
            }
            Point p2 = new Point(seg.x2, seg.y2);
            if (points.indexOf(p2) == -1) {
                points.add(p2);
            }
            for (int j = 0; j < i; j++) {
                Segment seg1 = segs.get(j);
                Point cross = Segment.intersect(seg, seg1);
                if (cross != null) {
                    if (points.indexOf(cross) == -1) {
                        points.add(cross);
                    }
                }
            }
        }
        for (int i = 0; i < segs.size(); i++) {
            Segment seg = segs.get(i);
            ArrayList<Point> line = new ArrayList<Point>();
            for (int j = 0; j < points.size(); j++) {
                Point point = points.get(j);
                if (point.x >= seg.x1 && point.x <= seg.x2 && point.y >= seg.y1 && point.y <= seg.y2) {
                    line.add(point);
                }
            }
            Collections.sort(line);
            for (int j = 0; j < line.size() - 1; j++) {
                line.get(j).adjacents.add(points.indexOf(line.get(j + 1)));
                line.get(j + 1).adjacents.add(points.indexOf(line.get(j)));
            }
        }
        int count = 0;
        for (int i = 0; i < points.size(); i++) {
            if (points.get(i).visited == false) {
                points.get(i).visited = true;
                int odd = DFS(i);
                if (n % 2 == 0 || odd == 0) {
                    count++;
                } else {
                    count += odd / 2;
                }
            }
        }
        return count - 1;
    }

    static int DFS (int index) {
        Point point = points.get(index);
        int odd;
        if (point.adjacents.size() % 2 == 0) {
            odd = 0;
        } else {
            odd = 1;
        }
        for (int i = 0; i < point.adjacents.size(); i++) {
            int next = point.adjacents.get(i);
            if (points.get(next).visited == false) {
                points.get(next).visited = true;
                odd += DFS(next);
            }
        }
        return odd;
    }

    static class Segment {
        int x1;
        int y1;
        int x2;
        int y2;
        boolean horizontal;

        Segment (int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            if (this.y1 == this.y2) {
                this.horizontal = true;
            } else {
                this.horizontal = false;
            }
        }

        static boolean isOverlap (Segment a, Segment b) {
            if (a.horizontal == true && b.horizontal == true && a.y1 == b.y1) {
                if ((a.x1 >= b.x1 && a.x1 <= b.x2) || (a.x2 >= b.x1 && a.x2 <= b.x2) || (b.x1 >= a.x1 && b.x1 <= a.x2) || (b.x2 >= a.x1 && b.x2 <= a.x2)) {
                    return true;
                }
            } else if (a.horizontal == false && b.horizontal == false && a.x1 == b.x2) {
                if ((a.y1 >= b.y1 && a.y1 <= b.y2) || (a.y2 >= b.y1 && a.y2 <= b.y2) || (b.y1 >= a.y1 && b.y1 <= a.y2) || (b.y2 >= a.y1 && b.y2 <= a.y2)) {
                    return true;
                }
            }
            return false;
        }

        static Segment combine (Segment a, Segment b) {
            if (a.horizontal == true && b.horizontal == true) {
                int x1 = Math.min(a.x1, b.x1);
                int x2 = Math.max(a.x2, b.x2);
                int y = a.y1;
                return new Segment(x1, y, x2, y);
            } else {
                int x = a.x1;
                int y1 = Math.min(a.y1, b.y1);
                int y2 = Math.max(a.y2, b.y2);
                return new Segment(x, y1, x, y2);
            }
        }

        static Point intersect (Segment a, Segment b) {
            if (a.horizontal == b.horizontal) {
                return null;
            }
            if (a.horizontal == false) {
                Segment temp = a;
                a = b;
                b = temp;
            }
            if (a.y1 >= b.y1 && a.y1 <= b.y2 && b.x1 >= a.x1 && b.x1 <= a.x2) {
                return new Point(b.x1, a.y1);
            }
            return null;
        }
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;
        ArrayList<Integer> adjacents;
        boolean visited;

        public Point (int X, int Y) {
            this.x = X;
            this.y = Y;
            this.adjacents = new ArrayList<Integer>();
            this.visited = false;
        }

        public boolean equals (Object obj) {
            Point another = (Point) obj;
            if (this.x == another.x && this.y == another.y) {
                return true;
            } else {
                return false;
            }
        }

        public int compareTo (Point another) {
            if (this.x != another.x) {
                return this.x - another.x;
            } else {
                return this.y - another.y;
            }
        }
    }
}

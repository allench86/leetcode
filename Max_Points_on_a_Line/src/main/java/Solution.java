import java.awt.Point;
import java.util.HashMap;
import java.util.Map.Entry;

public class Solution {
    public int maxPoints(Point[] points) {
        int max = 0;
        if (points == null || points.length == 0) {
            return 0;
        }
        else if (points.length == 1) {
            return 1;
        } else if (points.length == 2) {
            return 2;
        }
        HashMap<Integer, Integer> sameX = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> sameY = new HashMap<Integer, Integer>();
        HashMap<Double, Integer> wholeSameSlope = new HashMap<Double, Integer>();

        int i = 0;
        int j = 0;

        while (i < points.length - 1) {
            j = i + 1;
            int samePoint = 0;
            int sameXAsP1 = 0;
            int sameYAsP1 = 0;
            HashMap<Double, Integer> sameSlope = new HashMap<Double, Integer>();
            Point p1 = points[i];
            while (j < points.length) {
                Point p2 = points[j];
                if (isSameX(p1, p2) && isSameY(p1, p2)) {
                    samePoint++;
                    sameXAsP1++;
                    sameYAsP1++;
                    if (samePoint + 1 > max) {
                        max = samePoint + 1;
                    }
                }
                else if (isSameX(p1, p2) && !sameX.containsKey(p1.x)) {
                    sameXAsP1++;
                    if (sameXAsP1 + 1 > max) {
                        max = sameXAsP1 + 1;
                    }
                }
                else if (isSameY(p1, p2) && !sameY.containsKey(p1.y)) {
                    sameYAsP1++;
                    if (sameYAsP1 + 1 > max) {
                        max = sameYAsP1 + 1;
                    }
                }
                else {
                    Double slope = calSlope(p1, p2);
                    if (!wholeSameSlope.containsKey(slope)) {
                        if (sameSlope.containsKey(slope)) {
                            int sameSlopeNum = sameSlope.get(slope);
                            sameSlopeNum++;
                            sameSlope.put(slope, sameSlopeNum);
                        }
                        else {
                            sameSlope.put(slope, 1);
                        }
                    }
                }
                j++;
            }

            if (sameXAsP1 > 0) {
                sameX.put(p1.x, sameXAsP1 + 1);
            }
            if (sameYAsP1 > 0) {
                sameY.put(p1.y, sameYAsP1 + 1);
            }
            for (Entry<Double, Integer> e : sameSlope.entrySet()) {
                int sameSlopeNum = e.getValue() + samePoint;
                wholeSameSlope.put(e.getKey(), sameSlopeNum);
                if (sameSlopeNum + 1 > max) {
                    max = sameSlopeNum +1;
                }
            }

            if (max > points.length / 2) {
                break;
            }
            i++;
        }

        return max;
    }

    private Double calSlope(Point p1, Point p2) {
        return Double.valueOf((p1.x - p2.x) * 1.0 / (p1.y - p2.y));
    }

    private boolean isSameY(Point p1, Point p2) {
        return p1.y == p2.y;
    }

    private boolean isSameX(Point p1, Point p2) {
        return p1.x == p2.x;
    }
}

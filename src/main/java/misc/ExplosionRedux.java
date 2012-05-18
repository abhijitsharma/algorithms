package misc;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * User: absharma
 * Date: 5/18/12
 */
public class ExplosionRedux {


    public int[][] process(List<Bird> birds) {

        Map<Integer, Set<Bird>> neighbourMap = new HashMap<Integer, Set<Bird>>();
        int length = birds.size();

        for (int i = 0; i < length; i++) {
            neighbours(birds, i, neighbourMap);
        }
//        for (Integer i : neighbourMap.keySet()) {
//            System.out.print(i + " -> ");
//            for (Bird b : neighbourMap.get(i)) {
//                System.out.print(b.index + " ");
//            }
//            System.out.println();
//        }
        doProcess(neighbourMap, birds);
        return getQualifying(birds);
    }

    private void doProcess(Map<Integer, Set<Bird>> neighbourMap, List<Bird> birds) {
        for (Bird b : birds) {
//            System.out.println("b.index = " + b.index);
            Set<Bird> visited = new HashSet<Bird>();
            _process(neighbourMap, b, visited);
            b.count = visited.size();
//            System.out.println(b.index);
//            for(Bird v :  visited) {
//                System.out.print(v.index + " ");
//            }
//            System.out.println();
        }
    }

    private int indent = 0;

    private void _process(Map<Integer, Set<Bird>> neighbourMap, Bird bird, Set<Bird> visited) {
//        System.out.println("ExplosionRedux._process");
//        indent += 4;
//        System.out.println(spaces(indent) + " Bird -> " + bird.index);
        visited.add(bird);
        for (Bird b : neighbourMap.get(bird.index)) {
            if (!visited.contains(b)) {
                _process(neighbourMap, b, visited);
            }
        }
//        indent -= 4;
    }

    private String spaces(int indent) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < indent; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private void neighbours(List<Bird> birds, int currIdx, Map<Integer, Set<Bird>> neighbourMap) {
        Bird current = birds.get(currIdx);
        Set<Bird> neighbours = neighbourMap.get(current.index);
        if (neighbours == null) {
            neighbours = new HashSet<Bird>();
            neighbourMap.put(current.index, neighbours);
        }
        for (Bird bird : birds) {
            if (bird.index == current.index)
                continue;
            if (bird.x >= current.x - current.radius && bird.index < current.index) {
                neighbours.add(bird);
            } else if (bird.x <= current.x + current.radius && bird.index > current.index) {
                neighbours.add(bird);
            } else if (bird.x > current.x + current.radius) {
                break;
            }
        }
    }


    private int[][] getQualifying(List<Bird> birds) {
        Collections.sort(birds, new Comparator<Bird>() {
            @Override
            public int compare(Bird o1, Bird o2) {
                return o2.count - o1.count;
            }
        });
        List<Bird> qualifying = new ArrayList<Bird>();
        Bird last = null;
        for (Bird bird : birds) {
            if (last == null) {
                last = bird;
                qualifying.add(bird);
            } else if (bird.count == last.count) {
                qualifying.add(bird);
            } else {
                break;
            }
        }
        int[][] result = new int[qualifying.size()][2];
        for (int i = 0; i < qualifying.size(); i++) {
            Bird r = qualifying.get(i);
            result[i][0] = r.index;
            result[i][1] = r.count;
        }
        return result;
    }

    public List<Bird> createRanges(InputStream in) {
        Scanner scanner = new Scanner(new BufferedInputStream(in));
        scanner.useDelimiter("\n");

        String firstLine = scanner.nextLine();
        int count = Integer.parseInt(firstLine.trim());
        List<Bird> birds = new ArrayList<Bird>();
        for (int i = 0; i < count; i++) {
            birds.add(new Bird());
        }
        String line = scanner.nextLine();
        processPositions(birds, line);
        line = scanner.nextLine();
        processRadii(birds, line);
        return birds;
    }

    private void processPositions(List<Bird> birds, String line) {
        String[] parts = line.split(" ");
        for (int i = 0; i < parts.length; i++) {
            Bird bird = birds.get(i);
            bird.index = i + 1;
            bird.x = Integer.parseInt(parts[i].trim());
            bird.count = 1;
        }
    }

    private void processRadii(List<Bird> birds, String line) {
        String[] parts = line.split(" ");
        for (int i = 0; i < parts.length; i++) {
            Bird bird = birds.get(i);
            bird.radius = Integer.parseInt(parts[i]);
        }
    }

    public static void main(String[] args) {
        ExplosionRedux explosion = new ExplosionRedux();
        List<Bird> birds = explosion.createRanges(System.in);
        StringBuilder sb = new StringBuilder();
        int[][] birdKills = explosion.process(birds);
        for (int[] bk : birdKills) {
            sb.append(bk[0]).append(" ").append(bk[1]);
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }

    public class Bird {
        public int index;
        public int x;
        public int radius;
        public int count;

        @Override
        public String toString() {
            return "Bird{" +
                    "index=" + index +
                    ", x=" + x +
                    ", radius=" + radius +
                    ", count=" + count +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Bird bird = (Bird) o;

            if (index != bird.index) return false;
            if (radius != bird.radius) return false;
            if (x != bird.x) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = index;
            result = 31 * result + x;
            result = 31 * result + radius;
            return result;
        }
    }

}

package recursion.backtrack;

import utils.Utils;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * User: absharma
 * Date: 4/26/12
 */
public class Schedule {
    
    public int[][] solve(int[][] taskDays) {
        int[][] dayTasks = flip(taskDays);
//        print(dayTasks);
        Map<Integer, Integer> assignment = new TreeMap<Integer, Integer>();
        Set<Integer> tasks = new HashSet<Integer>();
        List<Map<Integer, Integer>> solutions = new ArrayList<Map<Integer, Integer>>();
        search(0, dayTasks, assignment, tasks, solutions);
        if(solutions.size() == 0) {
            throw new IllegalStateException("");
        }
        int [][] results = new int[solutions.size()][];
        int i = 0;
        for(Map<Integer, Integer> solution : solutions) {
            results[i++] = mapToArray(solution);
        }
        return results;
    }

    private void search(int day, int[][] dayTasks, Map<Integer, Integer> assignment, Set<Integer> tasks, List<Map<Integer, Integer>> solutions) {
        indent += 2;
//        System.out.println(chars(indent, ' ') + "> search " + day);
        if (day >= dayTasks.length)
            return;

        for (int i = 0; i < dayTasks[day].length; i++) {
            int t = dayTasks[day][i];
            if(!tasks.contains(t)) {
                assignment.put(day, t);
                tasks.add(t);
//                System.out.println(chars(indent, ' ') + "day " + day + " task = " + t + " ::: " + i);
                search(day + 1, dayTasks, assignment, tasks, solutions);
                if(tasks.size() == dayTasks.length) {
                    solutions.add(new TreeMap<Integer, Integer>(assignment));
                }
                assignment.remove(day);
                tasks.remove(t);
            } else {
//                System.out.println(chars(indent, ' ') + "day " + day + " already assigned task = " + t);
            }
        }
        indent -= 2;
    }


    private int[] mapToArray(Map<Integer, Integer> map) {
        int[] result = new int[map.size()];
        int i = 0;
        for(int key : map.keySet()) {
            result[i++] = map.get(key);
        }
        return result;
    }
    
    private void print(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " :");
            }
            System.out.println();
        }
    }

    private int[][] flip(int[][] taskDays) {
        Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
        for (int task = 0; task < taskDays.length; task++) {
            for (int j = 0; j < taskDays[task].length; j++) {
                int day = taskDays[task][j];
                List<Integer> tasks = map.get(day);
                if (tasks == null) {
                    tasks = new ArrayList<Integer>();
                    map.put(day, tasks);
                }
                tasks.add(task + 1);
            }
        }
//        System.out.println("map = " + map);
        int[][] dayTasks = new int[taskDays.length][];
        for (int day = 1; day <= taskDays.length; day++) {
            List<Integer> tasks = map.get(day);
            if(tasks != null) {
                dayTasks[day - 1] = new int[tasks.size()];
                int i = 0;
                for (int t : tasks) {
                    dayTasks[day - 1][i++] = t;
                }
            } else {
                dayTasks[day - 1] = new int[0];
            }
//            System.out.println(day + " : " + tasks);
        }
        return dayTasks;
    }

    public static void main(String[] args) {
        try {
            Schedule sort = new Schedule();
            int[][] schedules = sort.solve(sort.createData(System.in));
            for (int[] schedule : schedules) {
                for (int task : schedule) {
                    System.out.print(task + " ");
                }
                System.out.println();
            }
        } catch (IllegalStateException e) {
            System.out.println("No Solution");
        }
    }

    public int[][] createData(InputStream in) {
        Scanner scanner = new Scanner(new BufferedInputStream(in));
        scanner.useDelimiter("\n");

        int nv = Integer.parseInt(Utils.getLine(scanner));
        int[][] data = new int[nv][];
        for (int i = 0; i < nv; i++) {
            String[] segs = Utils.getLine(scanner).split(" ");
            data[i] = new int[segs.length];
            for (int j = 0; j < segs.length; j++) {
                data[i][j] = Integer.parseInt(segs[j]);
            }
        }
        return data;
    }

    private String chars(int n, char c) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    private int indent = 0;

}

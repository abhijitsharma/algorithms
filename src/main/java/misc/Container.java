package misc;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * User: absharma
 * Date: 9/13/12
 */
public class Container {
    private List<Stack<Character>> stackList;

    public static void main(String[] args) {
        Container container = new Container();
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        scanner.useDelimiter("\n");
        String seq = scanner.nextLine();
        int pixels = container.process(seq);
        System.out.println(pixels);
    }

    public int process(String seq) {
        stackList = new ArrayList<Stack<Character>>();
        stackList.add(new Stack<Character>());
        for (Character c : seq.toCharArray()) {
            int stackNo = 0;
            while (stackNo < stackList.size()) {
                Stack<Character> curr = stackList.get(stackNo);
                if (curr.empty() || curr.peek() >= c) {
                    curr.push(c);
                } else {
                    if (stackNo == stackList.size() - 1) {
                        Stack<Character> newStack = new Stack<Character>();
                        stackList.add(newStack);
                        stackNo = 0;
                    } else {
                        stackNo++;
                    }
                    Stack<Character> temp = new Stack<Character>();
                    while (curr.peek() < c) {
                        temp.push(curr.pop());
                    }
                    curr.push(c);
                    curr = stackList.get(stackNo);
                    while (!temp.empty()) {
                        curr.push(temp.pop());
                    }
                }
                System.out.println(stackList);
                break;
            }
        }
        System.out.println("stackList = " + stackList);
        return stackList.size();
    }

}

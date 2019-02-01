package Chapter11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueue {

    public static void main(String[] args) {
        Queue q = new LinkedList();
        Stack s = new Stack();

        s.push("0");
        s.push("1");
        s.push("2");

        q.offer("0");
        q.offer("1");
        q.offer("2");

        while(!s.empty()){
            System.out.println(s.pop());
        }

        while(!q.isEmpty()){
            System.out.println(q.poll());
        }
    }
}

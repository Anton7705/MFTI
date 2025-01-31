package algorithms;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

class Stack<K> {
    List<K> list = new ArrayList<>();

    public void push(K elem) {
        list.add(elem);
    }

    public K pop() {
        if (!isEmpty()) {
            int x = list.size() - 1;
            return list.remove(x);
        }
        throw new RuntimeException("Stack is empty");
    }

    public K top() {
        if (!isEmpty()) {
            int x = list.size() - 1;
            return list.get(x);
        }
        throw new RuntimeException("Stack is empty");
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}

class Queue<K> {
    Stack<K> stack1 = new Stack<>();
    Stack<K> stack2 = new Stack<>();

    public void push(K element) {
        stack1.push(element);
    }

    public K pop() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}


public class Starter4 {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine();

            if (command.startsWith("новичок:")) {
                String name = scanner.nextLine();
                queue.push(name);
            } else if (command.equals("следующий")) {
                String nextPerson = queue.pop();
                System.out.println(nextPerson);
            } else if (command.equals("Смена закончилась!")) {
                break;
            }
            if (queue.isEmpty()) {
                System.out.println("Все вылечены!");
                break;
            }
        }
        scanner.close();
    }
}
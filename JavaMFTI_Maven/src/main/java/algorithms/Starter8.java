package algorithms;

import java.util.Scanner;

class Node {
    int key;
    Node left;
    Node right;
    double priority = Math.random();

    public Node(int key) {
        this.key = key;
        left = null;
        right = null;
    }
}

class Treap {
    public Node root;

    static class Pair {
        Node first;
        Node second;

        public Pair(Node first, Node second) {
            this.first = first;
            this.second = second;
        }
    }

    private Node merge(Node nodeLeft, Node nodeRight) {
        if (nodeLeft == null) {
            return nodeRight;
        }
        if (nodeRight == null) {
            return nodeLeft;
        }
        if (nodeLeft.priority > nodeRight.priority) {
            nodeLeft.right = merge(nodeLeft.right, nodeRight);
            return nodeLeft;
        } else {
            nodeRight.left = merge(nodeLeft, nodeRight.left);
            return nodeRight;
        }
    }

    private Pair split(Node node, int key) {
        if (node == null) {
            return new Pair(null, null);
        }
        if (key >= node.key) {
            Pair rightSplit = split(node.right, key);
            node.right = rightSplit.first;
            return new Pair(node, rightSplit.second);
        } else {
            Pair leftSplit = split(node.left, key);
            node.left = leftSplit.second;
            return new Pair(leftSplit.first, node);
        }
    }

    public void remove(int key) {
        Node parent = null;
        Node runner = root;

        while (runner != null && runner.key != key) {
            parent = runner;
            if (key < runner.key) {
                runner = runner.left;
            } else {
                runner = runner.right;
            }
        }
        if (runner == null) {
            return;
        }
        if (runner.left == null && runner.right == null) {
            if (runner == root) {
                root = null;
            } else if (parent.left == runner) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (runner.left == null || runner.right == null) {
            Node child = (runner.left != null) ? runner.left : runner.right;
            if (runner == root) {
                root = child;
            } else if (parent.left == runner) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        } else {
            Node successorParent = runner;
            Node successor = runner.right;

            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }
            runner.key = successor.key;

            if (successorParent.left == successor) {
                successorParent.left = successor.right;
            } else {
                successorParent.right = successor.right;
            }
        }
    }

    private void check() {
        if (root == null) {
            throw new RuntimeException("Tree is empty");
        }
    }

    public void add(int key) {
        root = add(root, key);
    }

    private Node add(Node node, int key) {
        Pair pair = split(node, key);
        Node newNode = new Node(key);
        pair.first = merge(pair.first, newNode);
        return merge(pair.first, pair.second);
    }

    public int getMax() {
        check();
        Node runner = root;
        while (runner.right != null) {
            runner = runner.right;
        }
        return runner.key;
    }

    public int getMin() {
        check();
        Node runner = root;
        while (runner.left != null) {
            runner = runner.left;
        }
        return runner.key;
    }

    public boolean find(int key) {
        Node runner = root;
        while (runner != null) {
            if (runner.key == key) {
                return true;
            }
            if (runner.key > key) {
                runner = runner.left;
            } else runner = runner.right;
        }
        return false;
    }
}


public class Starter8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Treap bst = new Treap();

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String command = scanner.next();
            if (command.equals("push")) {
                int value = scanner.nextInt();
                bst.add(value);
            } else if (command.equals("pop")) {
                int value = scanner.nextInt();
                bst.remove(value);
            } else if (command.equals("get_min")) {
                System.out.println(bst.getMin());
            } else if (command.equals("get_max")) {
                System.out.println(bst.getMax());
            } else if (command.equals("find")) {
                int value = scanner.nextInt();
                System.out.println(bst.find(value) ? "TRUE" : "FALSE");
            }
        }
        scanner.close();
        System.out.println(bst);
    }
}




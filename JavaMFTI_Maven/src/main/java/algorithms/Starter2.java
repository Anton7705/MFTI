//package algorithms;
//
//import java.util.Scanner;
//
//class Node {
//    int key;
//    Node1 left;
//    Node1 right;
//
//    public Node(int key) {
//        this.key = key;
//        left = null;
//        right = null;
//    }
//}
//
//class BinarySearchTree {
//    Node1 root;
//
//    public void remove(int key) {
//        Node1 parent = null;
//        Node1 current = root;
//
//        while (current != null && current.key != key) {
//            parent = current;
//            if (key < current.key) {
//                current = current.left;
//            } else {
//                current = current.right;
//            }
//        }
//        if (current == null) {
//            return;
//        }
//        if (current.left == null && current.right == null) {
//            if (current == root) {
//                root = null;
//            } else if (parent.left == current) {
//                parent.left = null;
//            } else {
//                parent.right = null;
//            }
//        } else if (current.left == null || current.right == null) {
//            Node1 child = (current.left != null) ? current.left : current.right;
//            if (current == root) {
//                root = child;
//            } else if (parent.left == current) {
//                parent.left = child;
//            } else {
//                parent.right = child;
//            }
//        } else {
//            Node1 successorParent = current;
//            Node1 successor = current.right;
//
//            while (successor.left != null) {
//                successorParent = successor;
//                successor = successor.left;
//            }
//            current.key = successor.key;
//
//            if (successorParent.left == successor) {
//                successorParent.left = successor.right;
//            } else {
//                successorParent.right = successor.right;
//            }
//        }
//    }
//
//    private void check() {
//        if (root == null) {
//            throw new RuntimeException("Tree is empty");
//        }
//    }
//
//    public void add(int key) {
//        if (root == null) {
//            root = new Node1(key);
//            return;
//        }
//        Node1 runner = root;
//        while (true) {
//            if (key >= runner.key) {
//                if (runner.right == null) {
//                    runner.right = new Node1(key);
//                    return;
//                } else runner = runner.right;
//                continue;
//            }
//            if (runner.left == null) {
//                runner.left = new Node1(key);
//                return;
//            } else runner = runner.left;
//        }
//    }
//
//    public int getMax() {
//        check();
//        Node1 runner = root;
//        while (runner.right != null) {
//            runner = runner.right;
//        }
//        return runner.key;
//    }
//
//    public int getMin() {
//        check();
//        Node1 runner = root;
//        while (runner.left != null) {
//            runner = runner.left;
//        }
//        return runner.key;
//    }
//
//    public boolean find(int key) {
//        Node1 runner = root;
//        while (runner != null) {
//            if (runner.key == key) {
//                return true;
//            }
//            if (runner.key > key) {
//                runner = runner.left;
//            } else runner = runner.right;
//        }
//        return false;
//    }
//}
//
//
//class Starter2 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        BinarySearchTree1 bst = new BinarySearchTree1();
//
//        int n = scanner.nextInt();
//        for (int i = 0; i < n; i++) {
//            String command = scanner.next();
//            if (command.equals("push")) {
//                int value = scanner.nextInt();
//                bst.add(value);
//            } else if (command.equals("pop")) {
//                int value = scanner.nextInt();
//                bst.remove(value);
//            } else if (command.equals("get_min")) {
//                System.out.println(bst.getMin());
//            } else if (command.equals("get_max")) {
//                System.out.println(bst.getMax());
//            } else if (command.equals("find")) {
//                int value = scanner.nextInt();
//                System.out.println(bst.find(value) ? "TRUE" : "FALSE");
//            }
//        }
//        scanner.close();
//    }
//}
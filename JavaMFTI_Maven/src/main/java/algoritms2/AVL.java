package algoritms2;

import java.util.Scanner;

class Node {
    int height;
    int key;
    Node left;
    Node right;

    public Node(int key) {
        this.key = key;
        left = null;
        right = null;
    }
}

class AVLTree {
    Node root;

    private int height(Node node) {
        if (node == null) {
            return 0;
        } else return node.height;
    }

    private void fixHeight(Node node) {
        int heightLeft = height(node.left);
        int heightRight = height(node.right);
        node.height = Math.max(heightLeft, heightRight) + 1;
    }

    private int bFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.right) - height(node.left);
    }

    private Node balance(Node node) {
        fixHeight(node);
        int bFactor = bFactor(node);
        if (bFactor == 2) {
            if (bFactor(node.right) >= 0) {
                return leftRotation(node);
            } else {
                return leftRotationBig(node);
            }
        } else if (bFactor == -2) {
            if (bFactor(node.left) <= 0) {
                return rightRotation(node);
            } else {
                return rightRotationBig(node);
            }
        }
        return node;
    }

    private Node rightRotation(Node node) {
        Node nodeB = node.left;
        node.left = nodeB.right;
        nodeB.right = node;
        fixHeight(node);
        fixHeight(nodeB);
        return nodeB;
    }

    private Node rightRotationBig(Node node) {
        Node nodeB = node.left;
        Node nodeC = nodeB.right;
        Node nodeM = nodeC.right;
        Node nodeN = nodeC.left;
        node.left = nodeM;
        nodeB.right = nodeN;
        nodeC.right = node;
        nodeC.left = nodeB;
        fixHeight(node);
        fixHeight(nodeB);
        fixHeight(nodeC);
        return nodeC;
    }

    private Node leftRotation(Node node) {
        Node nodeB = node.right;
        node.right = nodeB.left;
        nodeB.left = node;
        fixHeight(node);
        fixHeight(nodeB);
        return nodeB;
    }

    private Node leftRotationBig(Node node) {
        Node nodeB = node.right;
        Node nodeC = nodeB.left;
        Node nodeM = nodeC.left;
        Node nodeN = nodeC.right;
        node.right = nodeM;
        nodeB.left = nodeN;
        nodeC.left = node;
        nodeC.right = nodeB;
        fixHeight(node);
        fixHeight(nodeB);
        fixHeight(nodeC);
        return nodeC;
    }

    public void remove(int key) {
        remove(root, key);
    }

    Node remove(Node node, int key) {
        if (node == null) {
            return node;
        } else if (node.key > key) {
            node.left = remove(node.left, key);
        } else if (node.key < key) {
            node.right = remove(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                node.key = getMin();
                node.right = remove(node.right, node.key);
            }
        }

        if (node != null) {
            node = balance(node);
        }
        return node;
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
        if (node == null) {
            node = new Node(key);
            return node;
        }
        if (key < node.key) {
            node.left = add(node.left, key);
        } else {
            node.right = add(node.right, key);
        }
        return balance(node);
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

class Starter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AVLTree avlTree = new AVLTree();

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String command = scanner.next();
            if (command.equals("push")) {
                int value = scanner.nextInt();
                avlTree.add(value);
            } else if (command.equals("pop")) {
                int value = scanner.nextInt();
                avlTree.remove(value);
            } else if (command.equals("get_min")) {
                System.out.println(avlTree.getMin());
            } else if (command.equals("get_max")) {
                System.out.println(avlTree.getMax());
            } else if (command.equals("find")) {
                int value = scanner.nextInt();
                System.out.println(avlTree.find(value) ? "TRUE" : "FALSE");
            }
        }
        scanner.close();
    }
}


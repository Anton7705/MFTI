package algorithms;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class HashTableString {
    List<String>[] table;
    int count;
    int size;
    private final double LOAD_FACTOR;

    public HashTableString(int size, double loadFactor) {
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
        LOAD_FACTOR = loadFactor;
        this.size = size;
        count = 0;
    }

    public HashTableString() {
        this(10, 0.75);
    }

    private void resize() {
        int newSize = size * 2;
        List<String>[] newTable = new LinkedList[newSize];
        for (int i = 0; i < newSize; i++) {
            newTable[i] = new LinkedList<>();
        }

        for (int i = 0; i < size; i++) {
            for (String key : table[i]) {
                int newIndex = hashFunction(key, newSize);
                newTable[newIndex].add(key);
            }
        }
        table = newTable;
        size = newSize;
    }

    private int hashFunction(String key, int size) {
        int hash = 0;
        int prime = 31;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash * prime + key.charAt(i)) % size;
        }
        return hash;
    }

    public void push(String key) {
        if (search(key) || key == null || key.isEmpty()) return;
        int index = hashFunction(key, size);
        table[index].add(key);
        count++;
        if ((double) count / size >= LOAD_FACTOR) {
            resize();
        }
    }

    public boolean pop(String key) {
        int index = hashFunction(key, size);
        if (table[index].remove(key)) {
            count--;
            return true;
        }
        return false;
    }

    public boolean search(String key) {
        int index = hashFunction(key, size);
        return table[index].contains(key);
    }
}

public class Starter7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        HashTableString hashTable = new HashTableString();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            if (parts.length < 2) {
                continue;
            }

            String command = parts[0];
            String key = parts[1];

            switch (command) {
                case "push":
                    hashTable.push(key);
                    break;
                case "pop":
                    if (hashTable.pop(key)) {
                        System.out.println("TRUE");
                    } else System.out.println("FALSE");
                    break;
                case "search":
                    if (hashTable.search(key)) {
                        System.out.println("TRUE");
                    } else System.out.println("FALSE");
                    break;
            }
        }
        scanner.close();
    }
}

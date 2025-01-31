package algorithms;

import java.util.*;

class Heap<K> {
    private final Comparator<K> rule;
    List<K> list = new ArrayList<>();

    public Heap(Comparator<K> rule) {
        this.rule = rule;
    }

    public void makeHeap(K[] array) {
        list.clear();
        Collections.addAll(list, array);
        for (int i = (list.size() / 2) - 1; i >= 0; i--) {
            shiftDown(i);
        }
    }

    public void shiftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (rule.compare(list.get(index), list.get(parent)) > 0) {
                Collections.swap(list, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void shiftDown(int index) {
        while (index < list.size()) {
            int indexCh1 = 2 * index + 1;
            int indexCh2 = 2 * index + 2;
            int indexMax = index;
            if (indexCh1 < list.size() && rule.compare(list.get(indexCh1), list.get(indexMax)) > 0) {
                indexMax = indexCh1;
            }
            if (indexCh2 < list.size() && rule.compare(list.get(indexCh2), list.get(indexMax)) > 0) {
                indexMax = indexCh2;
            }
            if (indexMax == index) {
                break;
            } else {
                Collections.swap(list, indexMax, index);
                index = indexMax;
            }
        }
    }

    public K getMax() {
        if (isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public K popMax() {
        if (isEmpty()) {
            return null;
        }
        K max = getMax();
        Collections.swap(list, 0, list.size() - 1);
        list.remove(list.size() - 1);
        shiftDown(0);
        return max;
    }

    public void push(K value) {
        list.add(value);
        shiftUp(list.size() - 1);
    }

    public int size() {
        return list.size();
    }
}


public class Starter6 {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>(Comparator.comparingInt(x -> x));
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(scanner.nextLine());
        }

        heap.makeHeap(array);

        List<Integer> list = new ArrayList<>();
        int j = heap.size();
        for (int i = 0; i < j; i++) {
            list.add(heap.popMax());
        }
        for (Integer integer : list) {
            System.out.println(integer);
        }
        scanner.close();
    }
}
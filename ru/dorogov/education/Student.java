package ru.dorogov.education;
// 1.6.9
// 5.1.4

import ru.dorogov.сhapter5.MyComparable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Student implements MyComparable<Student> {
    private String name;
    private final List<Integer> marks = new ArrayList<>();
    private final Predicate<Integer> rule;
    private List<Action> undoList = new ArrayList<>();

    public Student (String name, int... marks) {
        this(name, x -> true, marks);
    }

    public Student(String name, Predicate<Integer> rule, int... marks) {
        this.rule = rule;
        this.name = name;
        for (int i : marks) {
            if (rule.test(i)) {
                this.marks.add(i);
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public void addMarks(int... marks) {
        for (int i : marks) {
            if (rule.test(i))
                this.marks.add(i);
            else {
                throw new IllegalArgumentException();
            }
        }
        undoList.add(() -> {
            int count = marks.length;
            while (count > 0) {
                this.marks.removeLast();
                count--;
            }
        });
    }

    public void removeMark(int index) {

        int tmp = this.marks.remove(index);
        undoList.add(() -> this.marks.add(index, tmp));
    }

    public List<Integer> getMarks() {
        return new ArrayList<>(marks);
    }

    public void setName(String name) {
        String str = this.name;
        undoList.add(() -> this.name = str);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getAver() {
        if (marks.isEmpty()) {
            return 0;
        }
        int sum = 0;
        int count = 0;
        for (Integer i :
                marks) {
            sum += i;
            count++;
        }
        return (double) sum / count;
    }

    @Override
    public String toString() {
        if (this.marks.isEmpty()) {
            return name + ": нет оценок";
        } else return name + ": " + marks;
    }

    @Override
    public int compare(Student compareStud) {
        if (this.getAver() > compareStud.getAver()) return 1;
        if (this.getAver() < compareStud.getAver()) return -1;
        return 0;
    }

    public void undo () {
        undoList.removeLast().make();

    }
}
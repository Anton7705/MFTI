package ru.dorogov.education;// 1.6.9

import java.util.Arrays;

public class Student {
    private String name;
    private int[] grades;

    public Student(String name, int... grades) {
        this.name = name;
        setGrades(grades);
    }

    public double middle() {
        if (grades == null || grades.length == 0) {
            return 0;
        }
        double count = 0;
        for (int grade : grades) {
            count = count + grade;
        }
        return count / grades.length;
    }

    public boolean isExcellent() {
        return middle() == 5.0;
    }

    public String getName() {
        return name;
    }

    public int[] getGrades() {
        return grades.clone();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrades(int[] grades) {
        for (int i = 0; i < grades.length; i++) {
            if (!(grades[i] >= 2 && grades[i] <= 5)) {
                throw new IllegalArgumentException("Студент может получать оценки в диапозоне от 2 до 5");
            }
        }
        this.grades = grades.clone();
    }

    @Override
    public String toString() {
        return name + ": " + Arrays.toString(grades);
    }

}

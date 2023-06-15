package edu.upvictoria.fpoo;

public class Student {
    private String name;
    private String enrollment;
    private Integer unitCount;
    private Integer[] grades;

    public Student(String enrollment, String name, Integer unitCount) {
        this.enrollment = enrollment;
        this.name = name;
        this.unitCount = unitCount;
        this.grades = new Integer[unitCount];
    }

    public void assignGrades(Integer... grades) {
        for (int i = 0; i < grades.length; i++) {
            this.grades[i] = grades[i];
        }
    }

    public void assignGrades(int index, int grade) {
        this.grades[index] = grade;
    }

    public Float calculateGPA() {
        Float gpa = 0f;
        for (var grade : this.grades) {
            gpa += grade;
        }
        return gpa / this.unitCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    public Integer getUnitCount() {
        return unitCount;
    }

    public void setUnitCount(Integer unitCount) {
        this.unitCount = unitCount;
    }

    public Integer[] getGrades() {
        return grades;
    }

    public void setGrades(Integer[] grades) {
        this.grades = grades;
    }
}

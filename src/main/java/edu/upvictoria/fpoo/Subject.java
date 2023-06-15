package edu.upvictoria.fpoo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Subject {
    private String UID;
    private HashMap<String,Student> gradeList;
    private Integer unitCount;
    private String path;
    private String delim;

    public Subject(String path, String delim) {
        this.UID = "";
        this.unitCount = -2;
        this.gradeList = new HashMap<String,Student>();
        this.path = path;
        this.delim = delim;
    }

    public void loadFile() {
        var file = new FileReaderWrapper(this.path);
        var file_content = file.getFile_content();
        this.UID = file.getFileName();
        for (var row : file_content) {
            var columns = new StringTokenizer(row,this.delim);
            var temp_content = new ArrayList<String>();
            while (columns.hasMoreTokens()) {
                temp_content.add(columns.nextToken());
            }
            var student = new Student(temp_content.get(0),temp_content.get(1),0);
            ArrayList<Integer> grades = new ArrayList<Integer>();
            for (int i = 2; i < temp_content.size(); i++) {
                grades.add(Integer.parseInt(temp_content.get(i)));
            }
            this.unitCount = grades.size();
            student.setUnitCount(this.unitCount);
            var aux_grades = new Integer[grades.size()];
            for (int i = 0; i < grades.size(); i++) {
                aux_grades[i] = grades.get(i);
            }
            student.setGrades(aux_grades);
            student.setGpa();
            this.gradeList.put(student.getEnrollment(),student);

        }
    }

    public Float getStudentGPA(String enrollment) {
        return this.gradeList.get(enrollment).calculateGPA();
    }

    public String[] getStudentInfo(String enrollment) {
        var data = new String[3];
        for (var entry : this.gradeList.entrySet()) {
            if (entry.getKey().equals(enrollment)) {
                data[0] = entry.getValue().getEnrollment();
                data[1] = entry.getValue().getName();
                var auxArrGrades = entry.getValue().getGrades();
                data[2] = auxArrGrades[0].toString();
                for (int i = 1; i < auxArrGrades.length; i++) {
                    data[2] += "," + auxArrGrades[i];
                }
            }
        }
        return data;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "UID='" + UID + '\'' +
                ", gradeList=" + gradeList +
                ", unitCount=" + unitCount +
                '}';
    }
}

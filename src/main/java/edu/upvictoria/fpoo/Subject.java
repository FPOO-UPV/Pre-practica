package edu.upvictoria.fpoo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Subject {
    private String UID;
    private HashMap<String,Student> gradeList;
    private Integer unitCount;

    public Subject() {
        this.UID = "";
        this.unitCount = -2;
        this.gradeList = new HashMap<String,Student>();
    }

    public void loadFile(String path, String delim) {
        var file = new FileReaderWrapper(path);
        var file_content = file.getFile_content();
        this.UID = file.getFileName();
        for (var row : file_content) {
            var columns = new StringTokenizer(row,delim);
            var aux_content = new ArrayList<String>();
            while (columns.hasMoreTokens()) {
                aux_content.add(columns.nextToken());
            }
            var aux_student = new Student(aux_content.get(0), aux_content.get(1), 0);
            var aux_grades = new ArrayList<Integer>();
            for (int i = 2; i < aux_content.size(); i++) {
                // aux_grades[i - 2] = Integer.parseInt(aux_content.get(i));
                aux_grades.add(Integer.parseInt(aux_content.get(i)));
            }
            var aux_aux_grades = new Integer[aux_grades.size()];
            for (int i = 0; i < aux_grades.size(); i++ ) {
                aux_aux_grades[i] = aux_grades.get(i);
            } // me da flojera reescribir la clase Student
            this.unitCount = aux_grades.size();
            aux_student.setGrades(aux_aux_grades);
            this.gradeList.put(aux_student.getEnrollment(), aux_student);
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

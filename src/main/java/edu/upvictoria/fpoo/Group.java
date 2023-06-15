package edu.upvictoria.fpoo;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Group {
    private String UID_Group;
    private ArrayList<Subject> subjects;
    private File dir;
    private String delim;

    public Group(File path, String delim) {
        this.dir = path;
        this.delim = delim;
        this.UID_Group = this.dir.getName();
        this.subjects = new ArrayList<Subject>();
    }

    public Group(String path, String delim) {
        this(new File(path),delim);
    }

    public void setSubjects() {
        int i = 0;
        for (var file : this.dir.listFiles()) {
            this.subjects.add(new Subject(file.getAbsolutePath(),this.delim));
            this.subjects.get(i).loadFile();
            i++;
        }
    }

    public String getUID_Group() {
        return UID_Group;
    }

    public void setUID_Group(String UID_Group) {
        this.UID_Group = UID_Group;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setDir(File dir) {
        this.dir = dir;
    }

    public File getDir() {
        return dir;
    }
}

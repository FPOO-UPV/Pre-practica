package edu.upvictoria.fpoo;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Group {
    private HashMap<String, ArrayList<Subject>> groups;
    private File dir_path;

    public Group(File path) {
        this.dir_path = path;
        this.groups = new HashMap<String, ArrayList<Subject>>();
    }

    public Group(String path) {
        this(new File(path));
    }

    public void setSubjects(String delim) {
        int n = this.dir_path.listFiles().length;
        ArrayList<File[]> dirs = new ArrayList<>();
        for (var dir : this.dir_path.listFiles()) {
            dirs.add(dir.listFiles());
        }
        for (int i = 0; i < dirs.size(); i++) {
            var auxArr = new ArrayList<Subject>();
            for (var file : dirs.get(i)) {
                var auxSubject = new Subject();
                if (isCSV(file)) {
                    auxSubject.loadFile(file.getPath(),delim);
                    auxArr.add(auxSubject);
                }
                this.groups.put(this.dir_path.listFiles()[i].getName(),auxArr);
            }
        }
        System.out.println();
    }

    public HashMap<String, ArrayList<Subject>> getGroups() {
        return groups;
    }

    public boolean isCSV(File file) {
        return file.getName().endsWith("csv");
    }


    public File getDir_path() {
        return dir_path;
    }

    public void setDir_path(File dir_path) {
        this.dir_path = dir_path;
    }
}

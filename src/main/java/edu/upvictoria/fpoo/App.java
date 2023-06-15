package edu.upvictoria.fpoo;

import java.io.File;

public class App {
    public static void main(String[] args) {
        var root = "src/main/resources/";
        var g = new Group(root + "grupo1","\t");
        g.setSubjects();
        System.out.println(g.getDir().getAbsolutePath());
    }
}

package edu.upvictoria.fpoo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReaderWrapper {
    private ArrayList<String> file_content;
    private File file;
    private String fileName;
    private String fileExtension;

    public FileReaderWrapper(File path) {
        this.file = path;
        this.file_content = new ArrayList<String>();
        System.out.println(!this.file.exists() ? "File does not exist" : "File found");
        this.loadFileContent();
        var name = this.file.getName();
        this.fileName = name.substring(0, name.length() - 4);
        this.fileExtension = name.substring(name.length() - 4, name.length());
    }

    public FileReaderWrapper(String path) {
        this(new File(path));
    }

    private void loadFileContent() {
        String line;
        try {
            var fileReader = new FileReader(this.file);
            var buffReader = new BufferedReader(fileReader);
            while ((line = buffReader.readLine()) != null) {
                this.file_content.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getFile_content() {
        return file_content;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }
}

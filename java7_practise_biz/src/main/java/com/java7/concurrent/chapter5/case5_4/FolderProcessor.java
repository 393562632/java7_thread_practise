package com.java7.concurrent.chapter5.case5_4;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * Created by lenovo on 2016/5/12.
 */
public class FolderProcessor extends RecursiveTask<List<String>> {
    private static final long serialVersionUID = 4683703664857330888L;
    private String path;
    private String extension;


    public FolderProcessor(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }

    @Override
    protected List<String> compute() {
        List<String> list = new ArrayList<String>();
        List<FolderProcessor> tasks = new ArrayList<FolderProcessor>();
        File file = new File(path);
        File content[] = file.listFiles();
        if(content != null) {
            for(int i=0; i<content.length; i++) {
                if(content[i].isDirectory()) {
                    FolderProcessor task = new FolderProcessor(content[i].getAbsolutePath(), extension);
                    task.fork();
                    tasks.add(task);
                } else {
                    if(checkFile(content[i].getName())) {
                        list.add(content[i].getAbsolutePath());
                    }
                }
            }
        }
        if(tasks.size() > 50) {
            System.out.printf("%s: %d tasks ran.\n", file.getAbsoluteFile(), tasks.size());
        }
        addResultsFromTask(list, tasks);
       return list;
    }

    private void addResultsFromTask(List<String> list, List<FolderProcessor> tasks) {
        for(FolderProcessor item: tasks) {
            list.addAll(item.join());
        }
    }

    private boolean checkFile(String name) {
        return name.endsWith(extension);
    }
}

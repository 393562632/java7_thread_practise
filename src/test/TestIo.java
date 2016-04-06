package test;

import java.io.File;

/**
 * Created by dell on 2016/4/5.
 */
public class TestIo {
    public static void main(String[] args) {
        File file= new File(".");
        String path=file.getAbsolutePath();
        System.out.println(path);
    }
}

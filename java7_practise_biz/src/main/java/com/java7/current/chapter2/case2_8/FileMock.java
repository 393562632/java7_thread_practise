package com.java7.current.chapter2.case2_8;

/**
 * Created by lenovo on 2016/4/15.
 */
public class FileMock {

    private String content[];

    private int index;

    public FileMock(int size, int length) {
        content = new String[size];
        for(int i=0; i<size; i++) {
            StringBuilder buffer = new StringBuilder(length);
            for(int j=0; j<length; j++) {
                int indice = (int)Math.random() * 255 ;
                System.out.println(indice);
                buffer.append((char)indice);
            }
            content[i] = buffer.toString();
        }
            index = 0;
    }

    public boolean hasMoreLines() {
        return index < content.length;
    }

    //返回行内容，索引自动加一
    public String getLine() {
        if(this.hasMoreLines()) {
            System.out.println("Mock :" + (content.length - index));
            return content[index++];
        }
        return null;
    }
}

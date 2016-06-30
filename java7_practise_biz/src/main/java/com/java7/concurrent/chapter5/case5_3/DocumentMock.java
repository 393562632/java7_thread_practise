package com.java7.concurrent.chapter5.case5_3;

import java.util.Random;

/**
 * Created by lenovo on 2016/5/10.
 */
public class DocumentMock {
    private String words[] = {"the","hello","goodbye","packt","java","thread","pool","random","class","main"};

    public String[][] generateDocument(int numLines, int numWords, String word) {
        int counter = 0;
        String document[][] = new String[numLines][numWords];
        Random random = new Random();
        //对数组进行初始化，并记录相关world被初始化的次数。
        for(int i=0; i<numLines; i++) {
            for(int j=0; j<numWords; j++) {
                int index = random.nextInt(word.length());
                document[i][j] = words[index];
                if(document[i][j].equals(word)) {
                    counter++;
                }
            }
        }
        System.out.printf("DocumentMock: the word appears " + counter + " times int the document\n");
        return document;
    }
}

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2016/4/8.
 */
public class RandomTest {

    @Test
    public void randomTest1() {
        Random random = new Random((new Date()).getTime());
        Double data = random.nextDouble();
        System.out.println(data);
    }

    @Test
    public void test1() {
        int a = 95;
        int b = 95/2;
        System.out.printf("b:" + b + "\n");
    }

    @Test
    public void timeUnitTest() throws InterruptedException {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        Date first = new Date();
        TimeUnit.SECONDS.sleep(2);
        Date second = new Date();
        System.out.printf("First: %s\n", first);
        System.out.printf("Second: %s\n", second);
        long firstTime = first.getTime();
        long SecondTime = second.getTime();
        System.out.printf("FirstTime: %s\n", firstTime);
        System.out.printf("SecondTime: %s\n", SecondTime);
        TimeUnit.SECONDS.sleep(2);
        Date now = new Date();
        System.out.printf("now: %s\n", now.getTime());
        long firstdif = firstTime - now.getTime();
        firstdif = timeUnit.convert(firstdif, TimeUnit.MILLISECONDS);
        long secondtdif = SecondTime - now.getTime();
        secondtdif = timeUnit.convert(secondtdif, TimeUnit.MILLISECONDS);
        System.out.printf("firstdif: %s\n", firstdif);
        System.out.printf("secondtdif: %s\n", secondtdif);
        long result = firstdif - secondtdif;
        System.out.printf("result: %s\n", result);
    }

    @Test
    public void testFindbugs() {
        System.out.printf("+++++++++++++++++++++++=%n");
        System.out.printf("+++++++++++++++++++++++=%n");
    }

    /**
     * 生成容器副本
     */
    @Test
    public void copyList() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        List list1 = new ArrayList(list);
        if(list == list1) {
            System.out.printf("true");
        } else {
            System.out.printf("false");
        }
    }

    @Test
    public void test2() {
        LinkedTransferQueue<String> queue = new LinkedTransferQueue<>();
        try {
            queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

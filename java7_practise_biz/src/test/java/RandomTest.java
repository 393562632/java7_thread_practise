import org.junit.Test;

import java.util.Date;
import java.util.Random;

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
}

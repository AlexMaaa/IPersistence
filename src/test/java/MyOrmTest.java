import com.lagou.io.Resources;
import org.junit.Test;

import java.io.InputStream;

/**
 * @author majm
 * @create 2020-01-05 22:07
 * @desc
 **/

public class MyOrmTest {
    @Test
    public void queryTest(){
        System.out.println("查询测试");
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");

    }
}

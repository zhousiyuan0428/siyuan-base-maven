import com.siyuan.base.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTests {
    @Before
    public void init() {
        System.out.println("开始测试-----------------");
    }
    @After
    public void after() {
        System.out.println("测试结束-----------------");
    }
}

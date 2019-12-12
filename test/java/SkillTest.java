import com.siyuan.base.biz.service.SkillCardService;
import com.siyuan.base.biz.service.ThingRecordService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SkillTest extends ApplicationTests {
    @Autowired
    private SkillCardService skillCardService;
    @Autowired
    private ThingRecordService thingRecordService;
    @Test
    public void test11(){
        System.out.println(skillCardService.queryCurrentDayInfo());
        //Assert.assertSame("企业数量有误",500,);
    }
    @Test
    public void test2(){
        System.out.println(thingRecordService.queryAll());
    }
}

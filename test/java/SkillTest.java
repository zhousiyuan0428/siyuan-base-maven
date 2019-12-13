import com.siyuan.base.biz.service.SkillCardService;
import com.siyuan.base.biz.service.SolutionRecordService;
import com.siyuan.base.biz.service.ThingRecordService;
import com.siyuan.base.web.form.SolutionRecordForm;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SkillTest extends ApplicationTests {
    @Autowired
    private SkillCardService skillCardService;
    @Autowired
    private ThingRecordService thingRecordService;
    @Autowired
    private SolutionRecordService solutionRecordService;
    @Test
    public void test11(){
        System.out.println(skillCardService.queryCurrentDayInfo());
        //Assert.assertSame("企业数量有误",500,);
    }
    @Test
    public void test2(){
        System.out.println(thingRecordService.getOneQuestion());
    }
    @Test
    public void testSolutionSave(){
        SolutionRecordForm form = new SolutionRecordForm();
        form.setImproveWay("Test");
        form.setSolutionDescribe("Test");
        form.setSolutionPicture("Test");
        //form.setThingId(1);
        System.out.println(solutionRecordService.saveSolution(form));
    }
}

import com.siyuan.base.biz.service.SkillCardService;
import com.siyuan.base.dao.repository.SkillCardRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SkillTest extends ApplicationTests {
    @Autowired
    private SkillCardService skillCardService;
    @Autowired
    private SkillCardRepository skillCardRepository;

    @Test
    public void test2(){
        System.out.println(skillCardRepository.getCurrentInfo());
    }

    @Test
    public void test7DayInfo(){
        System.out.println(skillCardService.querySevenDayInfo());
    }

}

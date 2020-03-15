import com.siyuan.base.biz.service.ThingRecordService;
import com.siyuan.base.dao.entity.ThingRecordEntity;
import com.siyuan.base.dao.repository.ThingRecordRepository;
import com.siyuan.base.web.form.ThingRecordForm;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class ThingRecordTest extends ApplicationTests {
    @Autowired
    private ThingRecordRepository thingRecordRepository;
    @Autowired
    private ThingRecordService thingRecordService;

    @Test
    public void findByStatus() {
        System.out.println(thingRecordRepository.findByStatus(0));
    }

    @Test
    @Transactional
    public void updateById() {
        ThingRecordEntity entity = new ThingRecordEntity();
        Long id = Long.valueOf("1576568734254");
        entity.setId(id);
        entity.setThingStatus(4);
        entity.setSolutionDescribe("TEST");
        System.out.println(thingRecordRepository.updateById(entity));
    }

    @Test
    @Transactional
    public void TestSolution() {
        ThingRecordForm form = new ThingRecordForm();
        Long id = Long.valueOf("1576571176758");
        form.setId(id);
        form.setSolutionDescribe("TEST");
        System.out.println(thingRecordService.dealRecordInfo(form));
    }

    public void TimeUtil() {
//        SkillCardEntity entity = new SkillCardEntity();
//        ThingRecordEntity thingRecordEntity = thingRecordRepository.findById(form.getThingId()).get();
//        NumberFormat nf = NumberFormat.getNumberInstance();
//        nf.setMaximumFractionDigits(2);
//        String point = nf.format(CalculateUtil.calculatetimeGapHour(thingRecordEntity.getCreateTime(), new Date()));
//        entity.setSkillPoints(point);
//        entity.setCreateBy("周思远");
//        entity.setCreateDate(new Date());
//        entity.setAcquisitionTime(new Date());
//        entity.setUpdateDate(new Date());
//        entity.setSkillType(thingRecordEntity.getSkillType());
//        entity.setSkillDescribe(thingRecordEntity.getThingDescribe());
    }
}

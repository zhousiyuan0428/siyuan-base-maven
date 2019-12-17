import com.siyuan.base.biz.service.ThingRecordService;
import com.siyuan.base.dao.entity.ThingRecordEntity;
import com.siyuan.base.dao.repository.ThingRecordRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class ThingRecordTest extends ApplicationTests {
    @Autowired
    private ThingRecordRepository thingRecordRepository;
    @Autowired
    private ThingRecordService thingRecordService;

    @Test
    public void findByStatus(){
        System.out.println(thingRecordRepository.findByStatus(0));
    }

    @Test
    @Transactional
    public void updateById(){
        ThingRecordEntity entity = new ThingRecordEntity();
        entity.setId(67);
        entity.setThingStatus(2);
        System.out.println(thingRecordRepository.updateById(entity));
    }

}

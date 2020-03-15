import com.siyuan.base.dao.repository.ThingRecordRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

public class RedisTest extends ApplicationTests {
    @Autowired
    private StringRedisTemplate template;
    @Autowired
    private ThingRecordRepository thingRecordRepository;

    @Test
    public void findByStatus() {

        System.out.println(thingRecordRepository.findAll());
    }
}

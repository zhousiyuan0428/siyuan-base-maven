import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class JdbcTemplateTest extends ApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testJdbcTemplate() {
        String sql = "SELECT * FROM public_code where bus_code=? and bus_name=?;";
        List<Map<String, Object>> listMap = jdbcTemplate.queryForList(sql,20001,"支出");
        listMap.forEach(el -> {
            for (Map.Entry<String, Object> entry : el.entrySet()) {
                System.out.println(entry.getKey() + "---" + entry.getValue());
            }
        });
    }
}






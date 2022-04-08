import com.sanxiadaba.dao.UserTestMapper;
import com.sanxiadaba.pojo.UserTest;
import com.sanxiadaba.service.UserTestImpl;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTest {

    // 初始化定义log4j
    static Logger logger = Logger.getLogger(TestTest.class);
    static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    // 测试log4j
    @Test
    public void testLog4j() {
        logger.info("info,测试log4j");
        logger.debug("debug,测试log4j");
        logger.error("error,测试log4j");
        logger.warn("warn,测试log4j");
    }


    @Test
    public void selectAll_01() {
        UserTestMapper userTestMapper = context.getBean("userTestMapper", UserTestMapper.class);
        for (UserTest userTest : userTestMapper.selectAll()) {
            System.out.println(userTest);
        }
    }

    @Test
    public void selectAll_02() {
        UserTestMapper userTestMapper = context.getBean("userTestImpl", UserTestImpl.class);
        for (UserTest userTest : userTestMapper.selectAll()) {
            System.out.println(userTest);
        }
    }

}

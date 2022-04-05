package test;

import com.zhang.dao.BlogMapper;
import com.zhang.pojo.Blog;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BlogTest {
    // 初始化定义log4j
    static Logger logger = Logger.getLogger(BlogTest.class);
    static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    // 测试log4j
    @Test
    public void testLog4j() {
        logger.info("info,测试log4j");
        logger.debug("debug,测试log4j");
        logger.error("error,测试log4j");
        logger.warn("warn,测试log4j");
    }

    @Test
    public void selectALL() {
        BlogMapper blogMapper = context.getBean("blogMapper", BlogMapper.class);
        for (Blog blog : blogMapper.selectAll()) {
            System.out.println(blog);
        }

    }

    @Test
    public void selectALL_02() {
        BlogMapper blogMapper = context.getBean("blogMapper_02", BlogMapper.class);
        for (Blog blog : blogMapper.selectAll()) {
            System.out.println(blog);
        }

    }


}

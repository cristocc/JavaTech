package study;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by crist on 2023/1/3
 *
 * @author cc
 */
public class MySqlTest {

    //https://bugstack.cn/md/spring/source-code/2019-12-25-%5B%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90%5DMybatis%E6%8E%A5%E5%8F%A3%E6%B2%A1%E6%9C%89%E5%AE%9E%E7%8E%B0%E7%B1%BB%E4%B8%BA%E4%BB%80%E4%B9%88%E5%8F%AF%E4%BB%A5%E6%89%A7%E8%A1%8C%E5%A2%9E%E5%88%A0%E6%94%B9%E6%9F%A5.html
    public void test_queryUserInfoById() {
        String resource = "spring/mybatis-config-datasource.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);

            SqlSession session = sqlMapper.openSession();
            try {
/*                User user = session.selectOne("org.itstack.demo.dao.IUserDao.queryUserInfoById", 1L);
                System.out.println(JSON.toJSONString(user));*/
            } finally {
                session.close();
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

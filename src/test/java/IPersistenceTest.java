import com.lagou.io.Resources;
import com.lagou.sqlSession.SqlSession;
import com.lagou.sqlSession.SqlSessionFactory;
import com.lagou.sqlSession.SqlSessionFactoryBuilder;
import com.lagou.dao.IUserDao;
import org.dom4j.DocumentException;
import org.junit.Test;
import com.lagou.pojo.User;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.List;

public class IPersistenceTest {

    @Test
    public void test() throws Exception {
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //调用
        User user = new User();
        user.setId(1);
        user.setUsername("张三");
      /*  User user2 = sqlSession.selectOne("user.selectOne", user);

        System.out.println(user2);*/

       /* List<User> users = sqlSession.selectList("user.selectList");
        for (User user1 : users) {
            System.out.println(user1);
        }*/

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        List<User> all = userDao.findAll();
        for (User user1 : all) {
            System.out.println(user1);
        }


    }
    @Test
    public void test111() throws PropertyVetoException, DocumentException {
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        IUserDao mapper = sqlSession.getMapperUpdate(IUserDao.class);
//        User user = new User();
//        user.setId(1);
//        user.setUsername("张三");
//        mapper.update(user);
//        IUserDao mapper1 = sqlSession.getMapperInsert(IUserDao.class);
//        User user1 = new User();
//        user1.setId(3);
//        user1.setUsername("ali");
//        mapper1.insert(user1);
        IUserDao mapper1 = sqlSession.getMapperDelete(IUserDao.class);
        User user1 = new User();
        user1.setId(3);
        user1.setUsername("ali");
        mapper1.delete(user1);
    }

}

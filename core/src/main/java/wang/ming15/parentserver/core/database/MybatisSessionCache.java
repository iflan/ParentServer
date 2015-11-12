package wang.ming15.parentserver.core.database;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * Created by wanggnim on 2015/9/10.
 */
public enum MybatisSessionCache {

    INSTANCE;

    private final SqlSessionFactory sqlSessionFactory;

    MybatisSessionCache() {
        String resource = "/mybatis/mybatis-config.xml";

        InputStream inputStream = MybatisSessionCache.class.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "development");
    }

    public SqlSession openSession() {
       return sqlSessionFactory.openSession();

    }
}

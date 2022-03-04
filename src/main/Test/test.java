import com.mapper.ProviderMapper;
import com.pojo.Provider;
import com.service.ProviderService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class test {
    @Test
    public void tt() throws IOException {
        String resources = "configuration.xml";

        InputStream is = Resources.getResourceAsStream(resources);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession();

//        Provider pro = new Provider();
//        pro.setId(Long.valueOf(1));
        Long i = Long.valueOf(1);
        Provider count = sqlSession.getMapper(ProviderMapper.class).selectByPrimaryKey(i);
        System.out.println("inflecting---> " + count);

        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void tt2() throws IOException {
        String resources = "configuration.xml";

        InputStream is = Resources.getResourceAsStream(resources);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession();

        Provider pro = new Provider();
        pro.setProcode("GY");
        //pro.setProname("广");
        List<Provider> count = sqlSession.getMapper(ProviderMapper.class).selectByCodeName(pro);
        for (Provider p : count){
            //System.out.println("inflecting---> " + p);
            System.out.println(p.getProname()+"name\t"+p.getProcode()+"code");
        }


        sqlSession.close();
    }
    @Test
    public void tt3() throws IOException {
        String resources = "configuration.xml";

        InputStream is = Resources.getResourceAsStream(resources);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession();

        Provider pro = new Provider();
        pro.setId(Long.valueOf(16));
//        pro.setProcode("GY");
//        pro.setProname("广州优乐玩具厂");
//        pro.setProdesc("短期合作伙伴");
//        pro.setProcontact("马云");
        pro.setProphone("19216811");
        int count = sqlSession.getMapper(ProviderMapper.class).updateByPrimaryKeySelective(pro);
        System.out.println("inflecting---> " + count);

        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void tt4() {
        String resources = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(resources);
        ProviderService providerService = (ProviderService) applicationContext.getBean("providerService");
        List<Provider> providerList = new ArrayList<Provider>();
        Provider p = new Provider();
        p.setProcode("GY");
        providerList = providerService.selectByCodeName(p);

    }

}

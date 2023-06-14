package am.hitech.jdbc.test;

import am.hitech.jdbc.util.DataSourse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NewBean {
    public void f1(){
        System.out.println("in newBen class");
    }
    @Bean
    public DataSourse dataSourse7(){
        return new DataSourse("jdbc:mysql://localhost:3306/group1","root","");
    }
    @Bean
    public NewBean1 newBean2(){
        return new NewBean1(new NewBean());
    }
}

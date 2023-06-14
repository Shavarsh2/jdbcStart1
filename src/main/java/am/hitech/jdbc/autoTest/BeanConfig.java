package am.hitech.jdbc.autoTest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanConfig {

    @Qualifier("ref1")
    @Bean
    public RefTestClass refTestClass1(){
        return new RefTestClass("@bean");
    }
}

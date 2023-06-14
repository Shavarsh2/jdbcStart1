package am.hitech.jdbc.autoTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TestClass {

    @Qualifier("ref1")
    @Autowired
    private RefTestClass refTest1;

    public void t1(){
        refTest1.test();
    }
}

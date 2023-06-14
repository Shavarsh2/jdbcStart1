package am.hitech.jdbc.autoTest;

import org.springframework.stereotype.Service;

//@Service
public class RefTestClass {
    private String x;

    public RefTestClass(String x){
        this.x = x;
    }
    public void test(){
        System.out.println("in ref class " + x);
    }
}

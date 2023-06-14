package am.hitech.jdbc;

public class SpringTest {
    SoringRef soringRef;
    public SpringTest(SoringRef soringRef){
        this.soringRef = soringRef;

    }
    public void f1(){
        System.out.println(soringRef.getS());
    }
}

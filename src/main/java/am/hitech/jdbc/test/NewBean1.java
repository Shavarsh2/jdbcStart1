package am.hitech.jdbc.test;

public class NewBean1 {
     private NewBean newBean;
    public NewBean1(NewBean newBean){
        this.newBean = newBean;
    }
    public void nb1(){
        newBean.f1();
    }

}

package am.hitech.jdbc.model;

public class TestMain {
    public static void main(String[] args) {
        TestUser testUser = new TestUser();
        testUser.setAge(25);
        System.out.println(testUser.getAge());
    }
}

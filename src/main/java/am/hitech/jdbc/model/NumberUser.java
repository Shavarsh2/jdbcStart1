package am.hitech.jdbc.model;

public class NumberUser {
    private String firstName;
    private String lastName;
    private int number;
    public NumberUser(){}

    public NumberUser(String firstName, String lastName, int number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        if(number == 0){
            return  " /fisrsName - "+firstName+" /lastName - "+lastName+" /number - no number\n";
        }
        return  " /fisrsName - "+firstName+" /lastName - "+lastName+" /number - " + number + "\n";
    }
}

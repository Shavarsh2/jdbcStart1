package am.hitech.jdbc.model;

import javax.persistence.*;

@Entity
@Table(name = "phone_codes")
public class PhoneCodes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "code",nullable = false)
    private int code;
    @Column(name = "operator_id",nullable = false)
    private int operatorId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }
}

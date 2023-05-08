package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.eclipse.persistence.annotations.UuidGenerator;

@Entity
@UuidGenerator(name = "ADMIN_ID")
public class Admin {

    @Id
    @GeneratedValue(generator = "ADMIN_ID")
    private String id;
    private String memberId;

    public Admin(){

    }

    public Admin(String memberId) {
        this.memberId = memberId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

}

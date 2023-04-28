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
    private String member_id;

    public Admin(){

    }

    public Admin(String member_id) {
        this.member_id = member_id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

}

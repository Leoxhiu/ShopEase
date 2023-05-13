package model;

import jakarta.persistence.*;
import org.eclipse.persistence.annotations.UuidGenerator;

@Entity
@Cacheable(false)
@UuidGenerator(name = "ADMIN_ID")
public class Admin {

    @Id
    @GeneratedValue(generator = "ADMIN_ID")
    private String id;
    @OneToOne // A member can be an admin
    @JoinColumn(name = "memberId", referencedColumnName = "id")
    private Member member;

    public Admin(){

    }

    public Admin(Member member) {
        this.member = member;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}

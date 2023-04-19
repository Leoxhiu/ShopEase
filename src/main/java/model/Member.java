package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.UuidGenerator;

@Entity
public class Member {
    @Id
    @GeneratedValue
    @UuidGenerator (style = UuidGenerator.Style.TIME)
    private String id;
    private String name;
    private String email;
    private String password;
    private char user_type;

    public Member() {
    }

    public Member(String name, String email, String password, char user_type) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.user_type = user_type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getUser_type() {
        return user_type;
    }

    public void setUser_type(char user_type) {
        this.user_type = user_type;
    }
}

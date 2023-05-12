package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.eclipse.persistence.annotations.UuidGenerator;

@Entity
@UuidGenerator(name = "MEMBER_ID")
public class Member {
    @Id
    @GeneratedValue(generator = "MEMBER_ID")
    private String id;
    private byte[] profile;
    private String name;
    private String email;
    private String password;
    private String userType;
    private int isDeleted;

    public Member() {
    }

    public Member(byte[] profile, String name, String email, String password, String userType, int isDeleted) {
        this.profile = profile;
        this.name = name;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.isDeleted = isDeleted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public byte[] getProfile() {
        return profile;
    }

    public void setProfile(byte[] profile) {
        this.profile = profile;
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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setDeleted(int deleted) {
        isDeleted = deleted;
    }
}

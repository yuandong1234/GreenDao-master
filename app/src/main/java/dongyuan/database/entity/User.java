package dongyuan.database.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by dong.yuan on 2017/5/17.
 */

@Entity
public class User {
    @Id
    public Long id;
    public String userName;
    public int age;
    public String gender;
    @Generated(hash = 1778444354)
    public User(Long id, String userName, int age, String gender) {
        this.id = id;
        this.userName = userName;
        this.age = age;
        this.gender = gender;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGender() {
        return this.gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setId(Long id) {
        this.id = id;
    }
}

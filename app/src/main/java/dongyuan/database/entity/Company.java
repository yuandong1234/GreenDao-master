package dongyuan.database.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by dong.yuan on 2017/5/17.
 */
@Entity
public class Company {
    @Id
    private long id;
    private String companyName;
    @Generated(hash = 397862322)
    public Company(long id, String companyName) {
        this.id = id;
        this.companyName = companyName;
    }
    @Generated(hash = 1096856789)
    public Company() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getCompanyName() {
        return this.companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}

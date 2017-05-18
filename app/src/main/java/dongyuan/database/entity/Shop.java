package dongyuan.database.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Property;

/**
 * Created by dong.yuan on 2017/5/17.
 */
@Entity
public class Shop {
    @Id
    public Long id;
    public String shopName;
    @Generated(hash = 2071525901)
    public Shop(Long id, String shopName) {
        this.id = id;
        this.shopName = shopName;
    }
    @Generated(hash = 633476670)
    public Shop() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getShopName() {
        return this.shopName;
    }
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}

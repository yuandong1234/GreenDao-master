package dongyuan.database;

import android.app.Application;

import com.facebook.stetho.Stetho;

import dongyuan.database.greendao.DaoManager;

/**
 * Created by dong.yuan on 2017/5/17.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        //初始化数据库
        DaoManager.getInstance().init(getApplicationContext());
    }
}

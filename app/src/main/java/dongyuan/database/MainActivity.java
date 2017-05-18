package dongyuan.database;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import dongyuan.database.entity.User;
import dongyuan.database.greendao.DaoManager;
import dongyuan.database.greendao.DaoSession;
import dongyuan.database.greendao.UserDao;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static String TAG = MainActivity.class.getSimpleName();
    private DaoSession daoSession;
    private UserDao userDao;
    private long lastTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        daoSession = DaoManager.getInstance().getDaoSession();
        userDao = daoSession.getUserDao();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                add();
                break;
            case R.id.button2:
                addList();
                break;
            case R.id.button3:
                query();
                break;
            case R.id.button4:
                update();
                break;
            case R.id.button5:
                delete();
                break;
            case R.id.button6:
                multipleQuery();
                break;
        }
    }

    private void add() {
        boolean flag = false;
        User user = new User();
        user.userName = "袁栋";
        user.age = 25;
        user.gender = "man";
        flag = userDao.insert(user) != -1;
        Log.e(TAG, "插入 ：" + flag);
    }

    private void addList() {
        final ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.userName = "袁栋" + i;
            user.age = 25 + i;
            user.gender = "man";
            users.add(user);
        }
        lastTime = System.currentTimeMillis();
        userDao.insertInTx(users);
        Log.e(TAG, "批量插入耗时 ：" + (System.currentTimeMillis() - lastTime));
    }

    //更新(注意更新的时候一定对象ID一定要有)
    private void update() {
        User user = new User();
        user.id = (long) 1;
        user.userName = "唐晓泽";
        user.age = 24;
        user.gender = "woman";
        userDao.update(user);
    }

    //全部查询
    private void query() {
        lastTime = System.currentTimeMillis();
        List<User> list = userDao.loadAll();
        Log.e(TAG, "查询耗时 ：" + (System.currentTimeMillis() - lastTime));
        Log.e(TAG, "查询数量 ：" + list.size());
    }

    //删除 对象必须有主键Id(只要存在主键就会删除对象数据)
    private void delete() {
        User user = new User();
        user.id = (long) 2;
        user.userName = "唐晓泽";
        user.age = 24;
        user.gender = "woman";
        userDao.delete(user);
    }

    //多条件查询
    private void multipleQuery() {
        Query<User> query = userDao.queryBuilder()
                //.where()
               // .where(UserDao.Properties.Age.gt(25))
                .where(UserDao.Properties.Age.ge(25),UserDao.Properties.UserName.eq("袁栋"))
                .build();
        List<User> list = query.list();
//        QueryBuilder<User> qb=userDao.queryBuilder();
//        qb.where(UserDao.Properties.Gender.eq("man"));
//        qb.and(UserDao.Properties.Age.eq(25),UserDao.Properties.UserName.eq("袁栋"));
//        List<User> list = qb.list();
        Log.e(TAG, "查询数量 ：" + list.size());
        //删除
        //userDao.deleteInTx(list);
    }
}

package net.httpletters_archive.simplesporttimer;

import android.app.Application;

import org.greenrobot.greendao.database.Database;

/**
 * Created by MyComp on 10.02.2017.
 */

public class TimerApplication extends Application {
    /** A flag to show how easily you can switch from standard SQLite to the encrypted SQLCipher. */
    public static final boolean ENCRYPTED = true;

//    private DaoSession daoSession;

//    @Override
//    public void onCreate() {
//        super.onCreate();
//
//        DevOpenHelper helper = new DevOpenHelper(this, ENCRYPTED ? "notes-db-encrypted" : "notes-db");
//        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret") : helper.getWritableDb();
//        daoSession = new DaoMaster(db).newSession();
//    }

//    public DaoSession getDaoSession() {
//        return daoSession;
//    }

}

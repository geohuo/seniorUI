package com.geohuo.dongnao.seniorui;

import android.app.Application;

import java.security.SecureRandom;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by geohuo on 2017/7/7.
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        byte[] key = new byte[64];
        new SecureRandom().nextBytes(key);
        RealmConfiguration config = new RealmConfiguration.Builder()
                //.encryptionKey(key)
                .name("myrealm.realm") //文件名
                .schemaVersion(0) //版本号

                .build();
        Realm.deleteRealm(config);
        Realm.setDefaultConfiguration(config);
    }

}

package com.geohuo.dongnao.seniorui.bean;

import io.realm.RealmObject;

/**
 * Created by geohuo on 2017/7/7.
 */

public class HistoryString extends RealmObject {
    private String name;
    private int searchCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSearchCount() {
        return searchCount;
    }

    public void setSearchCount(int searchCount) {
        this.searchCount = searchCount;
    }
}

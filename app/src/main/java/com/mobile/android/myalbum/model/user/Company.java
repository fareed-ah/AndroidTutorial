package com.mobile.android.myalbum.model.user;

import android.arch.persistence.room.ColumnInfo;

public class Company {

    @ColumnInfo(name = "company_name")
    private String name;

    @ColumnInfo(name = "company_catchphrase")
    private String catchPhrase;

    public Company(String name, String catchPhrase) {
        this.name = name;
        this.catchPhrase = catchPhrase;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }
}

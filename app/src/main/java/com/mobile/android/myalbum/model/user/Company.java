package com.mobile.android.myalbum.model.user;

public class Company {
    private String name;
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

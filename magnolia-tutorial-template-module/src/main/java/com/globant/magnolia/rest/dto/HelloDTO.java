package com.globant.magnolia.rest.dto;

import java.io.Serializable;

public class HelloDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public String userName;
    public String mood;

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}

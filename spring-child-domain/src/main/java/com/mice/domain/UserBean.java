package com.mice.domain;

import java.io.Serializable;

/**
 * Created by AmbitiousMice on 2018/1/9.
 */
public class UserBean implements Serializable{
    private static final long serialVersionUID = -1780498159996307574L;
    private Long id;
    private String userName;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.mice.domain;

/**
 * Created by AmbitiousMice on 2018/1/9.
 */
public class RoleBean {
    private Long id;
    private String roleName;
    private String remark;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

package com.hhit.dao;

import com.hhit.model.Admin;

public interface AdminDao {
    Admin selectByadminname(String username);
    void adminupdatepwd(Admin admin);
    Admin selectByadminid(String userid);
}

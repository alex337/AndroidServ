package com.hhit.service;

import com.hhit.model.Admin;

public interface AdminService {
    Admin selectByadminname(String username);
    Admin selectByteaid(String userid);
    void adminupdatepwd(Admin admin);

}

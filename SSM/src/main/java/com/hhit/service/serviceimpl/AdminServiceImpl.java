package com.hhit.service.serviceimpl;

import com.hhit.dao.AdminDao;
import com.hhit.model.Admin;
import com.hhit.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value="adminservice")
public class AdminServiceImpl implements AdminService {
    @Resource
    AdminDao adminDao;
    @Override
    public Admin selectByadminname(String username) {
        return adminDao.selectByadminname(username);
    }

    @Override
    public Admin selectByteaid(String userid) {
        return adminDao.selectByadminid(userid);
    }

    @Override
    public void adminupdatepwd(Admin admin) {
        adminDao.adminupdatepwd(admin);

    }
}

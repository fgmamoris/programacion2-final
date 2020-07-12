package com.programacion2.Final.service;

import com.programacion2.Final.controller.LoginController;
import com.programacion2.Final.entity.RolEntity;
import com.programacion2.Final.repository.RolJPARepo;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("servicioRol")
public class RolServiceImpl implements RolService {

    private static final Log LOGGER = LogFactory.getLog(LoginController.class);

    @Autowired
    @Qualifier("rolJPARepo")
    private RolJPARepo rolRepo;

    @Override
    public List<RolEntity> getListRoles() {

        return rolRepo.findAll();
    }

    @Override
    public RolEntity findById(int id) {
        return rolRepo.findByIdRol(id);

    }

    @Override
    public void removeRol(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

package com.programacion2.Final.service;

import com.programacion2.Final.controller.LoginController;
import com.programacion2.Final.entity.UsuarioEntity;
import com.programacion2.Final.repository.UsuarioJPARepo;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("servicioUsuario")
public class UsuarioServiceImpl implements UsuarioService {

    private static final Log LOGGER = LogFactory.getLog(LoginController.class);

    @Autowired
    @Qualifier("usuarioJPARepo")
    private UsuarioJPARepo usuarioRepo;

    @Override
    public List<UsuarioEntity> getListUser() {
        return usuarioRepo.findAll();
    }

    @Override
    public UsuarioEntity addUsuario(UsuarioEntity usuario) {
        return usuarioRepo.save(usuario);
    }

    @Override
    public UsuarioEntity updateUsuario(UsuarioEntity usuario) {
        return usuarioRepo.save(usuario);

    }

    @Override
    public UsuarioEntity findUserCredential(int legajo, String password) {
        if (usuarioRepo.findByLegajoAndPassword(legajo, password) != null) {
            return usuarioRepo.findByLegajoAndPassword(legajo, password);
        }
        return null;
    }

    @Override
    public UsuarioEntity findUserLegajo(int legajo) {
        if (null != usuarioRepo.findByLegajo(legajo)) {

            return usuarioRepo.findByLegajo(legajo);
        }
        return null;
    }
///////////////////////METODOS CON ENTIDAD ID

    @Override
    public UsuarioEntity findById(int id) {
        return usuarioRepo.findById(id);
    }

    @Override
    public void removeUser(int id) {
        UsuarioEntity usuario = usuarioRepo.findById(id);
        if (usuario != null) {
            usuarioRepo.delete(usuario);
        }
    }

    @Override
    public int findLegajo() {
        //********OBTENGO EL NUMERO DE LEGAJO DEL ULTIMO EN LA TABLA****************

        UsuarioEntity usuarioUltimoLegajo = usuarioRepo.findTopByOrderByIdDesc();
        return usuarioUltimoLegajo.getLegajo() + 1;
    }

}

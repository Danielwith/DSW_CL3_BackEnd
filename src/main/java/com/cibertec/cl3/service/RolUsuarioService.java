package com.cibertec.cl3.service;

import com.cibertec.cl3.entity.RolUsuario;
import com.cibertec.cl3.entity.RolUsuarioID;
import com.cibertec.cl3.repository.RolUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RolUsuarioService {
    @Autowired
    private RolUsuarioRepository rolUsuarioRepository;

    public void saveRoleUser(RolUsuario bean){
        rolUsuarioRepository.save(bean);
    }
    public RolUsuario buscarPorIDUsuario(int bean){
        return rolUsuarioRepository.findByIdUsuario(bean);
    }

    public void actualizarIDRolporIDUsuario(int idRol, int idUsuario){
        rolUsuarioRepository.updateIdRolByUsuarioId(idRol, idUsuario);
    }

    public void eliminarPorIDUsuario(int idUsuario){
        rolUsuarioRepository.deleteByIdUsuario(idUsuario);
    }

}

package com.cibertec.cl3.service;

import com.cibertec.cl3.entity.Usuario;
import com.cibertec.cl3.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuario(){
        return usuarioRepository.findAll();
    }

    public void registrarUsuario(Usuario bean){
        usuarioRepository.save(bean);
    }

    public void eliminarUsuario(Integer idUsuario){
        usuarioRepository.deleteById(idUsuario);
    }
}

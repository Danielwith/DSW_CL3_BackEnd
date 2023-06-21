package com.cibertec.cl3.service;

import com.cibertec.cl3.entity.Rol;
import com.cibertec.cl3.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;

    public List<Rol> listarRoles(){
        return rolRepository.findAll();
    }

    public void guardarRol(Rol bean){
        rolRepository.save(bean);
    }

    public Optional<Rol> buscarPorID(Integer id){
        return rolRepository.findById(id);
    }
}

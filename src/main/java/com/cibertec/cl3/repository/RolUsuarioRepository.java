package com.cibertec.cl3.repository;

import com.cibertec.cl3.entity.RolUsuario;
import com.cibertec.cl3.entity.RolUsuarioID;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface RolUsuarioRepository extends JpaRepository<RolUsuario, RolUsuarioID> {
    @Query("SELECT r FROM RolUsuario r WHERE r.id.idUsuario = ?1")
    public RolUsuario findByIdUsuario(int idUsuario);

    @Modifying
    @Transactional
    @Query("UPDATE RolUsuario ru SET ru.id.idRol = ?1 WHERE ru.id.idUsuario = ?2")
    void updateIdRolByUsuarioId(int newIdRol, int idUsuario);

    @Modifying
    @Transactional
    @Query("DELETE FROM RolUsuario ru WHERE ru.id.idUsuario = ?1")
    void deleteByIdUsuario(int idUsuario);
}

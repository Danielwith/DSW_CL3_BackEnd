package com.cibertec.cl3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class RolUsuarioID {
    @Column(name = "id_usuario")
    private int idUsuario;

    @Column(name = "id_rol")
    private int idRol;
}

package com.cibertec.cl3.entity.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponse {
    private Integer idUsuario;
    private String nombres;
    private String apaterno;
    private String amaterno;
    private String correo;
    private String dni;
    private LocalDate fechaNacimiento;
    private LocalDateTime fechaRegistro;
    private String ubigeo;
    private Integer role;
}

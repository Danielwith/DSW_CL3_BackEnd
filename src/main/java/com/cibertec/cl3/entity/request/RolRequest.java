package com.cibertec.cl3.entity.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RolRequest {
    private Integer idRol;
    private String nombre;
    private String estado;

}

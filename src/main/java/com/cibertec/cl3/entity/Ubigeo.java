package com.cibertec.cl3.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "ubigeo")
public class Ubigeo {
    @Id
    private String id;
    private int idUbigeo;
    private String departamento;
    private String provincia;
    private String distrito;
}

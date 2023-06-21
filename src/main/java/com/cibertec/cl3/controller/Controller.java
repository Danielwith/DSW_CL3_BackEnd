package com.cibertec.cl3.controller;

import com.cibertec.cl3.entity.*;
import com.cibertec.cl3.entity.request.RolRequest;
import com.cibertec.cl3.entity.request.UsuarioRequest;
import com.cibertec.cl3.entity.response.UsuarioResponse;
import com.cibertec.cl3.service.RolService;
import com.cibertec.cl3.service.RolUsuarioService;
import com.cibertec.cl3.service.UbigeoService;
import com.cibertec.cl3.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/rest/")
public class Controller {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private RolService rolService;
    @Autowired
    private UbigeoService ubigeoService;
    @Autowired
    private RolUsuarioService rolUsuarioService;

    @GetMapping("ubigeo")
    public ResponseEntity<?> listarUbigeo(){
        List<Ubigeo> ubigeoList = ubigeoService.listarUbigeo();
        return ResponseEntity.ok(ubigeoList);
    }

    @GetMapping("users")
    public ResponseEntity<List<UsuarioResponse>> listarUsuarios(){
        List<Usuario> usuarioList = usuarioService.listarUsuario();
        List<UsuarioResponse> responseList = new ArrayList<>();
        for(var item : usuarioList) {
            RolUsuario rolUsuario = rolUsuarioService.buscarPorIDUsuario(item.getIdUsuario());
            UsuarioResponse response = UsuarioResponse.builder()
                    .idUsuario(item.getIdUsuario())
                    .nombres(item.getNombres())
                    .apaterno(item.getApaterno())
                    .amaterno(item.getAmaterno())
                    .correo(item.getCorreo())
                    .dni(item.getDni())
                    .fechaNacimiento(item.getFechaNacimiento())
                    .fechaRegistro(item.getFechaRegistro())
                    .ubigeo(item.getUbigeo())
                    .role(rolUsuario.getId().getIdRol())
                    .build();

            responseList.add(response);
        }

        return ResponseEntity.ok(responseList);
    }

    @GetMapping("role")
    public ResponseEntity<?> listarRoles(){
        List<Rol> rolList = rolService.listarRoles();
        return ResponseEntity.ok(rolList);
    }

    @PostMapping("users")
    public ResponseEntity<?> registrarUsuario(@RequestBody UsuarioRequest request){
        try {
            Map<String, String> response = new HashMap<>();
            response.put("response", "Usuario registrado");

            Optional<Rol> role = rolService.buscarPorID(request.getRole());
            if(role.isPresent()) {
                Usuario newUser = Usuario.builder()
                        .idUsuario(request.getIdUsuario())
                        .nombres(request.getNombres())
                        .apaterno(request.getApaterno())
                        .amaterno(request.getAmaterno())
                        .correo(request.getCorreo())
                        .dni(request.getDni())
                        .fechaNacimiento(request.getFechaNacimiento())
                        .fechaRegistro(LocalDateTime.now())
                        .ubigeo(request.getUbigeo())
                        .build();

                Rol rol = role.get();
                usuarioService.registrarUsuario(newUser);

                RolUsuarioID IDrolUsuario = RolUsuarioID.builder()
                        .idRol(rol.getIdRol())
                        .idUsuario(newUser.getIdUsuario())
                        .build();

                RolUsuario searchRepeatedID = rolUsuarioService.buscarPorIDUsuario(IDrolUsuario.getIdUsuario());
                if(searchRepeatedID == null){
                    RolUsuario rolUsuario = RolUsuario.builder()
                            .id(IDrolUsuario)
                            .build();

                    rolUsuarioService.saveRoleUser(rolUsuario);
                }
                else{
                    searchRepeatedID.getId().setIdRol(rol.getIdRol());
                    rolUsuarioService.actualizarIDRolporIDUsuario(request.getRole(), searchRepeatedID.getId().getIdUsuario());
                }

                return ResponseEntity.ok(response);
            }
            else{
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("role")
    public ResponseEntity<?> registrarRol(@RequestBody RolRequest request){
        try {
            Map<String, String> response = new HashMap<>();
            response.put("response", "Rol registrado");

            Rol newRole = Rol.builder()
                    .nombre(request.getNombre())
                    .estado(request.getEstado())
                    .build();
            rolService.guardarRol(newRole);
            return ResponseEntity.ok(response);
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("users/{idUsuario}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Integer idUsuario){
        try {
            Map<String, String> response = new HashMap<>();
            response.put("response", "Usuario eliminado");
            usuarioService.eliminarUsuario(idUsuario);
            rolUsuarioService.eliminarPorIDUsuario(idUsuario);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            System.out.println(e);
            return ResponseEntity.internalServerError().build();
        }
    }
}

package co.edu.uniquindio.unilocal.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegistroUsuarioDTO(

        @NotBlank String nickName,
        @NotBlank String Ciudad,
        @NotBlank String fotoPerfil,
        @NotBlank String nombre,
        @NotBlank String password,
        @NotBlank @Email String email
){

}

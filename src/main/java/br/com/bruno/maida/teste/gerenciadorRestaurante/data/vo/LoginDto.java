package br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginDto {

    @JsonProperty("email")
    private String email;
    @JsonProperty("senha")
    private String password;

}

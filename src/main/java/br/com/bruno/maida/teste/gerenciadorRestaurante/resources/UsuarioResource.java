package br.com.bruno.maida.teste.gerenciadorRestaurante.resources;

import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.UsuarioDto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.exceptions.ExceptionResponse;
import br.com.bruno.maida.teste.gerenciadorRestaurante.facade.impl.UsuarioFacadeImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/restaurante/user/")
@Tag(name = "Usuario", description = "Este endpoint administra os acessos," +
        " podendo tanto gerenciar o acesso do gestor da aplicação" +
        "como os acessos dos clientes.")
public class UsuarioResource {

    @Autowired
    private UsuarioFacadeImpl usuarioFacadeImpl;

    @GetMapping("/login")
    @Operation(summary = "login", description = "Realiza o login do usuario",
            tags = {"Usuario"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = UsuarioDto.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ExceptionResponse.class))
                            )
                    }),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ExceptionResponse.class))
                            )
                    }),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ExceptionResponse.class))
                            )
                    }),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ExceptionResponse.class))
                            )
                    }),
            }
    )
    public UsuarioDto findUsuario(@RequestParam(name = "email") String email,
                                    @RequestParam(name = "senha") String senha){
        return usuarioFacadeImpl.findUsuario(email,senha);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca usuario", description = "Realiza a busca por um determinado usuario pelo seu id",
            tags = {"Usuario"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = UsuarioDto.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ExceptionResponse.class))
                            )
                    }),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ExceptionResponse.class))
                            )
                    }),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ExceptionResponse.class))
                            )
                    }),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ExceptionResponse.class))
                            )
                    }),
            }
    )
    public UsuarioDto findById(@PathVariable Integer id){
        return usuarioFacadeImpl.findById(id);
    }


    @PostMapping("/create")
    @Operation(summary = "salvar", description = "cria um novo usuario obedecendo as regras imposta pela api," +
            "- Podendo um unico usuario gestor ser cadastrado." +
            "- os demais é para os clientes do estabelecimento",
            tags = {"Usuario"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = UsuarioDto.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ExceptionResponse.class))
                            )
                    }),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ExceptionResponse.class))
                            )
                    }),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ExceptionResponse.class))
                            )
                    }),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ExceptionResponse.class))
                            )
                    }),
            }
    )
    public UsuarioDto create(@RequestBody UsuarioDto user){
        return usuarioFacadeImpl.create(user);
    }

    @PutMapping("/update")
    @Operation(summary = "Alteração de cadastro", description = "Realiza a alteração do cadastro do usuario",
            tags = {"Usuario"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = UsuarioDto.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ExceptionResponse.class))
                            )
                    }),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ExceptionResponse.class))
                            )
                    }),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ExceptionResponse.class))
                            )
                    }),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ExceptionResponse.class))
                            )
                    }),
            }
    )
    public UsuarioDto update(@RequestBody UsuarioDto user){
        return usuarioFacadeImpl.update(user);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "delete", description = "Remove usuarios através de seu id",
            tags = {"Usuario"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ExceptionResponse.class))
                            )
                    }),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ExceptionResponse.class))
                            )
                    }),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ExceptionResponse.class))
                            )
                    }),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ExceptionResponse.class))
                            )
                    }),
            }
    )
    public void delete(@PathVariable Integer id){
        usuarioFacadeImpl.delete(id);
    }
}

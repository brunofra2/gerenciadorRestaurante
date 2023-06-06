package br.com.bruno.maida.teste.gerenciadorRestaurante.resources;

import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.ClienteDto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.ProdutoDto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.exceptions.ExceptionResponse;
import br.com.bruno.maida.teste.gerenciadorRestaurante.facade.impl.ClienteFacadeImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/restaurante/cliente/")
@Tag(name = "Cliente",description = "Este endpoint realiza a administração dos clientes")
public class  ClienteResource  {

    @Autowired
    private ClienteFacadeImpl clienteFacade;

    @GetMapping("/all")
    @Operation(summary = "Busca", description = "Realiza a busca por clientes, trazendo o todos os produtos",
            tags = {"Cliente"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = ClienteDto.class))
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
    public List<ClienteDto> findAll(){
        return clienteFacade.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca por cliente", description = "Realiza a busca de um determinado cliente através de seu id",
            tags = {"Cliente"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = ClienteDto.class))
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
    public ClienteDto findById(@PathVariable Integer id){
        return clienteFacade.findById(id);
    }

    @PostMapping("/create")
    @Operation(summary = "salvar", description = "Adiciona as informações do cliente",
            tags = {"Cliente"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = ClienteDto.class))
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
    public ClienteDto create(@RequestBody ClienteDto cli){
        return clienteFacade.create(cli);
    }

    @PutMapping("/update")
    @Operation(summary = "Alterar", description = "Altera as informações do cliente selecionado",
            tags = {"Cliente"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = ClienteDto.class))
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
    public ClienteDto update(@RequestBody ClienteDto cli){
        return clienteFacade.update(cli);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Remover", description = "Deleta as informações do cliente selecionado",
            tags = {"Cliente"},
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
        clienteFacade.delete(id);
    }
}


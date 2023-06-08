package br.com.bruno.maida.teste.gerenciadorrestaurante.resources;

import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.ProdutoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.ExceptionResponse;
import br.com.bruno.maida.teste.gerenciadorrestaurante.facade.impl.ProdutoFacadeImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/restaurante/produto")
@Tag(name="Produto",description = "Este endpoint realiza a administração dos produtos oferecidos pelo estabelecimento")
public class ProdutoResource {

    @Autowired
    private ProdutoFacadeImpl produtoFacade;

    @GetMapping("/all")
    @Operation(summary = "Busca", description = "Realiza a busca por produtos, trazendo o todos os produtos",
            tags = {"Produto"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = ProdutoDto.class))
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
    public List<ProdutoDto> findall(){
        return produtoFacade.findall();
    }

    @GetMapping("by/{id}")
    @Operation(summary = "Busca por produto", description = "Realiza a busca por produto através de seu id",
            tags = {"Produto"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = ProdutoDto.class))
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
    public List<ProdutoDto>  findById(@PathVariable Integer id){
        List<ProdutoDto> lista = new ArrayList<>();
        lista.add(produtoFacade.findById(id));
        return lista;
    }

    @PostMapping("/create")
    @Operation(summary = "salvar produto", description = "Realiza a adição de um novo produto",
            tags = {"Produto"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = ProdutoDto.class))
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
    public ProdutoDto create(@RequestBody ProdutoDto pag){
        return produtoFacade.create(pag);
    }

    @PutMapping("/update")
    @Operation(summary = "Alterar", description = "Altera informações no produto selecionado por seu id",
            tags = {"Produto"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = ProdutoDto.class))
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
    public ProdutoDto update(@RequestBody ProdutoDto pag){
        return produtoFacade.update(pag);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Remover", description = "Realiza a remoção de produtos do cardapio ",
            tags = {"Produto"},
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
        produtoFacade.delete(id);
    }
}

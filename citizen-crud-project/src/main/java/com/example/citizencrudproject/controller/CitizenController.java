package com.example.citizencrudproject.controller;

import com.example.citizencrudproject.dto.CitizenDto;
import com.example.citizencrudproject.exception.UniqueUserException;
import com.example.citizencrudproject.service.CitizenService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Citizens", description = "контроллер для работы с сущностью Citizen")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/citizens")
public class CitizenController {
    private final CitizenService citizenService;

    @ApiResponses({
            @ApiResponse(responseCode = "200", content =
                @Content(schema = @Schema(implementation = CitizenDto.class)),
                description = "Возврат данных о Citizen"),

            @ApiResponse(responseCode = "404", content =
                @Content(schema = @Schema(implementation = String.class)),
                description = "Возврат сообщения об ошибке в случае отстствия Citizen в базе данных"),

            @ApiResponse(responseCode = "500", description = "Возврат ошибки в случае проблем на сервере") })
    @GetMapping("/{id}")
    public ResponseEntity<CitizenDto> getCitizenById(@PathVariable Long id) throws EntityNotFoundException {
        return citizenService.getCitizenById(id);
    }

    @ApiResponses({
            @ApiResponse(responseCode = "200", content =
                @Content(schema = @Schema(implementation = CitizenDto.class)),
                description = "Возврат данных о Citizen"),

            @ApiResponse(responseCode = "404", content =
                @Content(schema = @Schema(implementation = String.class)),
                description = "Возврат сообщения об ошибке в случае отстствия Citizen в базе данных"),
            @ApiResponse(responseCode = "500", description = "Возврат ошибки в случае проблем на сервере") })
    @GetMapping
    public ResponseEntity<List<CitizenDto>> getAllCitizens() {
        return citizenService.getAllCitizens();
    }

    @ApiResponses({
            @ApiResponse(responseCode = "200", content =
                @Content(schema = @Schema(implementation = Long.class)),
                description = "Возврат id Citizen"),

            @ApiResponse(responseCode = "422", content =
                @Content(schema = @Schema(implementation = String.class)),
                description = "Возврат сообщения об ошибке в случае существования сущности"),

            @ApiResponse(responseCode = "400", content =
                @Content(schema = @Schema(implementation = String.class)),
                description = "Возврат сообщения об ошибке в случае невалидных значений в полях"),

            @ApiResponse(responseCode = "500", description = "Возврат ошибки в случае проблем на сервере") })
    @PostMapping
    public ResponseEntity<Long> createCitizen(@Valid @RequestBody CitizenDto citizenDto) throws UniqueUserException {
        return citizenService.createCitizen(citizenDto);
    }

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Возврат положительного кода ответа"),

            @ApiResponse(responseCode = "422", content =
                @Content(schema = @Schema(implementation = String.class)),
                description = "Возврат сообщения об ошибке в случае существования сущности"),

            @ApiResponse(responseCode = "400", content =
                @Content(schema = @Schema(implementation = String.class)),
                description = "Возврат сообщения об ошибке в случае невалидных значений в полях"),

            @ApiResponse(responseCode = "500", description = "Возврат ошибки в случае проблем на сервере") })
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCitizen(@PathVariable Long id, @Valid @RequestBody CitizenDto citizenDto) {
        return citizenService.updateCitizen(id, citizenDto);
    }

    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Возврат положительного кода ответа"),

            @ApiResponse(responseCode = "404", content =
                @Content(schema = @Schema(implementation = String.class)),
                description = "Возврат сообщения об отсутствии Citizen"),

            @ApiResponse(responseCode = "500", description = "Возврат ашибки в случае проблем на сервере") })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCitizenById(@PathVariable Long id) {
        return citizenService.deleteCitizen(id);
    }
}
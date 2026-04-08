package com.senai.cadastro.controller;

import com.senai.cadastro.DTO.ClienteRequisicao;
import com.senai.cadastro.DTO.ClienteResposta;
import com.senai.cadastro.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    public ResponseEntity<ClienteResposta> cadastrarClientes (@Valid @RequestBody ClienteRequisicao requisicao) {
        return ResponseEntity.status(HttpStatus.CREATED)
                        .body(service.cadastrarCliente(requisicao));
    }

    @GetMapping
    public ResponseEntity<List<ClienteResposta>> listarClientes () {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.listarClientes());
    }
}
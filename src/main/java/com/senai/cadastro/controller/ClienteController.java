package com.senai.cadastro.controller;

import com.senai.cadastro.DTO.ClienteRequisicao;
import com.senai.cadastro.DTO.ClienteResposta;
import com.senai.cadastro.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    public ClienteResposta cadastrarClientes (@Valid @RequestBody ClienteRequisicao requisicao) {
        return service.cadastrarCliente(requisicao);
    }

    @GetMapping
    public List<ClienteResposta> listarClientes () {
        return service.listarClientes();
    }
}


package com.senai.cadastro.controller;

import com.senai.cadastro.DTO.PedidoRequisicao;
import com.senai.cadastro.DTO.PedidoResposta;
import com.senai.cadastro.repository.PedidoRepo;
import com.senai.cadastro.service.PedidoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService service;

    @PostMapping
    public ResponseEntity<PedidoResposta> cadastrarPedido (@Valid @RequestBody PedidoRequisicao requisicao) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.cadastrarPedido(requisicao));
    }

    @GetMapping
    public ResponseEntity<List<PedidoResposta>> listarPedidos () {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.listarPedidos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResposta> findByClienteId (@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findByClienteId(id));
    }

    @GetMapping("/buscarNome")
    public ResponseEntity<PedidoResposta> findByClienteNome (@RequestParam String nome) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findByClienteNome(nome));
    }

    @GetMapping("/buscarDescricao")
    public ResponseEntity<PedidoResposta> findByIdAndDescricao (@RequestParam Long id, @RequestParam String descricao) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findByIdAndDescricao(id, descricao));
    }




}

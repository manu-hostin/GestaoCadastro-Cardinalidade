package com.senai.cadastro.service;

import com.senai.cadastro.DTO.ClienteRequisicao;
import com.senai.cadastro.DTO.ClienteResposta;
import com.senai.cadastro.mapper.ClienteMapper;
import com.senai.cadastro.model.Cliente;
import com.senai.cadastro.repository.ClienteRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepo repo;
    private final ClienteMapper mapper;

    public ClienteResposta cadastrarCliente (ClienteRequisicao requisicao) {
        Cliente cliente = mapper.paraEntidade(requisicao);
        Cliente salvar = repo.save(cliente);

        return mapper.paraResposta(salvar);
    }

    public List<ClienteResposta> listarClientes () {
        List<Cliente> clientes = repo.findAll();
        List<ClienteResposta> clienteRespostas = new ArrayList<>();

        for(Cliente cliente : clientes) {
           clienteRespostas.add(mapper.paraResposta(cliente));
        }

        return clienteRespostas;
    }

}

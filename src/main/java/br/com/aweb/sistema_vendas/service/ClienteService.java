package br.com.aweb.sistema_vendas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.aweb.sistema_vendas.model.Cliente;
import br.com.aweb.sistema_vendas.repository.ClienteRepository;
import jakarta.transaction.Transactional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Cadastrar Clientes
    @Transactional
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Listar todos os Clientes
    @Transactional
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    // Listar por Id
    @Transactional
    public Optional<Cliente> listarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    // Editar Cliente
    @Transactional
    public Cliente atualizar(Long id, Cliente cliente) {

        var optionalCliente = listarPorId(id);

        if (!optionalCliente.isPresent()) {
            throw new IllegalArgumentException("Cliente não encontrado");
        }

        var clienteExistente = optionalCliente.get();

        clienteExistente.setNome(cliente.getNome());
        clienteExistente.setEmail(cliente.getEmail());
        clienteExistente.setCpf(cliente.getCpf());
        clienteExistente.setTelefone(cliente.getTelefone());

        // Endereço separado
        clienteExistente.setLogradouro(cliente.getLogradouro());
        clienteExistente.setNumero(cliente.getNumero());
        clienteExistente.setComplemento(cliente.getComplemento());
        clienteExistente.setBairro(cliente.getBairro());
        clienteExistente.setCidade(cliente.getCidade());
        clienteExistente.setUf(cliente.getUf());
        clienteExistente.setCep(cliente.getCep());

        return clienteRepository.save(clienteExistente);
    }

    // Deletar Cliente
    @Transactional
    public void excluir(Long id) {

        var optionalCliente = listarPorId(id);

        if (!optionalCliente.isPresent()) {
            throw new IllegalArgumentException("Cliente não encontrado");
        }

        clienteRepository.deleteById(id);
    }
}

package br.com.aweb.sistema_vendas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aweb.sistema_vendas.model.Pedido;
import br.com.aweb.sistema_vendas.model.StatusPedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
    public List<Pedido> findByStatus(StatusPedido status);
}

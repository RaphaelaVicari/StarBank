package com.grupo1.bancodigital.dao;

import com.grupo1.bancodigital.model.cliente.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class ClienteRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //    @Query("select cliente from ClienteEntity cliente where cliente.cpf = :cpf")
    public ClienteEntity procurarPorCpf(String cpf) {
        String sql = "SELECT * FROM cliente WHERE cpf = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<ClienteEntity>(ClienteEntity.class), cpf);
    }

    public ClienteEntity save(ClienteEntity cliente) {
        String sql = "INSERT INTO cliente (cpf, nomeCliente, dataNascimento, categoria) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, cliente.getCpf(), cliente.getNomeCliente(), cliente.getDataNascimento(), cliente.getCategoria());
        return cliente;
    }

    public ClienteEntity update(ClienteEntity cliente) {
        String sql = "UPDATE cliente set nomeCliente = ?, dataNascimento =?, categoria=? where cpf = ?";
        jdbcTemplate.update(sql, cliente.getNomeCliente(), cliente.getDataNascimento(), cliente.getCategoria(), cliente.getCpf());
        return cliente;
    }

    public List<ClienteEntity> findAll() {
        String sql = "select * from cliente";
        List<ClienteEntity> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<ClienteEntity>(ClienteEntity.class));
        return query;
//        return jdbcTemplate.query(query, (rs, row) -> new ClienteEntity(
//                rs.getString("cpf"),
//                rs.getString("nomeCliente"),
//                LocalDate.now(),
//                rs.getInt("categoria"))
//        );
    }
}
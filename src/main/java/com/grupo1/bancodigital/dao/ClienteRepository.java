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
        String sql = "SELECT * FROM clientes WHERE cpf = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(), cpf);
    }

    public ClienteEntity save(ClienteEntity cliente) {
        String sql = "INSERT INTO cliente (cpf, nomeCliente, dataNascimento, categoria) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, cliente.getCpf(), cliente.getNomeCliente(), cliente.getDataNascimento(), cliente.getCategoria());
        return cliente;
    }

    public List<ClienteEntity> findAll() {
        String query = "select * from cliente";
        return jdbcTemplate.query(query, (rs, row) -> ClienteEntity.builder()
                .nomeCliente(rs.getString("nomeCliente"))
                .dataNascimento(LocalDate.now())
                .categoria(rs.getInt("categoria"))
                .cpf("cpf")
                .build()
        );
    }
}

package com.grupo1.bancodigital.dao;

import com.grupo1.bancodigital.model.cliente.CategoriaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CategoriaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //    @Query("select p from CategoriaEntity p where p.nomeCategoria = :nomeCategoria")
    public CategoriaEntity findById(Integer idCategoria) {
        String sql = "select * from categoria where idcategoria = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new CategoriaEntity(rs.getInt("idcategoria"), rs.getString("nomecategoria")), idCategoria);
    }

    public CategoriaEntity findByNomeCategoria(String nomeCategoria) {
        String sql = "select * from categoria where nomecategoria = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new CategoriaEntity(rs.getInt("idcategoria"), rs.getString("nomecategoria")), nomeCategoria);
    }

    public void save(CategoriaEntity e) {
        String sql = "insert into categoria(nomecategoria) values(?)";
        jdbcTemplate.update(sql, e.getNomeCategoria());
    }
}
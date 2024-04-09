package com.grupo1.bancodigital.dao;

import com.grupo1.bancodigital.model.cliente.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {

    @Query("select p from CategoriaEntity p where p.nomeCategoria = :nomeCategoria")
    CategoriaEntity findByNomeCategoria(@Param("nomeCategoria") String nomeCategoria);

}

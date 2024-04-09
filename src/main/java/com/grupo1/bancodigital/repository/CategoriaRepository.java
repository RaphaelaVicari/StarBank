package com.grupo1.bancodigital.repository;

import com.grupo1.bancodigital.entity.cliente.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {

    @Query("select p from CategoriaEntity p where p.nomeCategoria = :nomeCategoria")
    CategoriaEntity findByNomeCategoria(@Param("nomeCategoria") String nomeCategoria);

}

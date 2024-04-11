package com.grupo1.bancodigital.dao;

import com.grupo1.bancodigital.model.cliente.CategoriaEntity;
import com.grupo1.bancodigital.model.conta.TipoContaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoContaRepository extends JpaRepository<TipoContaEntity, Long> {

    @Query("select p from TipoContaEntity p where p.nomeTipoConta = :nomeTipoConta")
    TipoContaEntity findByNomeTipoConta(@Param("nomeTipoConta") String nomeTipoConta);

}

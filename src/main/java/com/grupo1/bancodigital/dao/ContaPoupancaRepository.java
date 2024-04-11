package com.grupo1.bancodigital.dao;

import com.grupo1.bancodigital.model.conta.ContaPoupancaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContaPoupancaRepository extends JpaRepository<ContaPoupancaEntity, Long> {

    @Query("select conta_poupanca from ContaPoupancaEntity conta_poupanca where conta_poupanca.idContaPoupanca = :idContaPoupanca")
    ContaPoupancaEntity procurarPorId(@Param("idContaPoupanca") Long idContaPoupanca);

    @Query("select conta_poupanca from ContaPoupancaEntity conta_poupanca inner join conta_poupanca.conta conta inner join conta.cliente cliente where cliente.cpf = :cpf")
    List<ContaPoupancaEntity> procurarPorCpf(@Param("cpf") String cpf);

}

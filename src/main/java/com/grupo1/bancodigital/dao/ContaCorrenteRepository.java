//package com.grupo1.bancodigital.dao;
//
//import com.grupo1.bancodigital.model.conta.ContaCorrenteEntity;
//import com.grupo1.bancodigital.model.conta.ContaPoupancaEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface ContaCorrenteRepository extends JpaRepository<ContaCorrenteEntity, Long> {
//    @Query("select conta_corrente " +
//            "from ContaCorrenteEntity conta_corrente " +
//            "where conta_corrente.idContaCorrente = :idContaCorrente")
//    ContaCorrenteEntity procurarPorId(@Param("idContaCorrente") Long idContaCorrente);
//
//
//
//   @Query("select conta_corrente from ContaCorrenteEntity conta_corrente inner join conta_corrente.conta conta inner join conta.cliente cliente where cliente.cpf = :cpf")
// List<ContaCorrenteEntity> procurarPorCpf(@Param("cpf") String cpf);
//}

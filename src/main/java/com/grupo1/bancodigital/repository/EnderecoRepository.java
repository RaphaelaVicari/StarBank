package com.grupo1.bancodigital.repository;

import com.grupo1.bancodigital.entity.cliente.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Long> {

    @Query("select endereco from EnderecoEntity endereco where endereco.idEndereco = :idEndereco")
    EnderecoEntity procurarPorId(@Param("idEndereco") Long idEndereco);

    @Query("select endereco from EnderecoEntity endereco inner join endereco.cliente cliente where cliente.cpf = :cpf")
    List<EnderecoEntity> procurarPorCpf(@Param("cpf") String cpf);
}

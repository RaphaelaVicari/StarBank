package com.grupo1.bancodigital.repository;

import com.grupo1.bancodigital.entity.cliente.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, String> {

    @Query("select cliente from ClienteEntity cliente where cliente.cpf = :cpf")
    ClienteEntity procurarPorCpf(@Param("cpf") String cpf);

}

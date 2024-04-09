package com.grupo1.bancodigital.dao;

import com.grupo1.bancodigital.model.conta.TipoContaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoContaRepository extends JpaRepository<TipoContaEntity, Long> {

}

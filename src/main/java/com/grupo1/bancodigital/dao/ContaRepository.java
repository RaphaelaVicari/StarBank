package com.grupo1.bancodigital.dao;

import com.grupo1.bancodigital.model.conta.ContaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<ContaEntity,Long> {


}

package com.grupo1.bancodigital.dao;

import com.grupo1.bancodigital.model.cartao.CartaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRespository extends JpaRepository<CartaoEntity,Long> {


}

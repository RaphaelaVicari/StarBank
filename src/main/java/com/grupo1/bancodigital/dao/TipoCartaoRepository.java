//package com.grupo1.bancodigital.dao;
//
//import com.grupo1.bancodigital.model.cartao.TipoCartaoEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//public interface TipoCartaoRepository extends JpaRepository<TipoCartaoEntity,Long> {
//    @Query("select p from TipoCartaoEntity p where p.nomeTipo = :nomeTipo")
//    TipoCartaoEntity findByNomeTipo(@Param("nomeTipo") String nomeTipo);
//}

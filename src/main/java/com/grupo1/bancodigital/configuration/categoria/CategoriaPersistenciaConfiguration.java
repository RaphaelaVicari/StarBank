/*package com.grupo1.bancodigital.configuration.categoria;

import com.grupo1.bancodigital.dto.CategoriaEnum;
import com.grupo1.bancodigital.model.cliente.CategoriaEntity;
import com.grupo1.bancodigital.dao.CategoriaRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoriaPersistenciaConfiguration {

    @Autowired
    private CategoriaRepository repository;

    @PostConstruct
    public void iniciarCategoriaTabela() {
        CategoriaEntity e = CategoriaEntity.builder()
                .nomeCategoria(CategoriaEnum.SUPER.name())
                .build();

        CategoriaEntity e2 = CategoriaEntity.builder()
                .nomeCategoria(CategoriaEnum.COMUM.name())
                .build();

        CategoriaEntity e3 = CategoriaEntity.builder()
                .nomeCategoria(CategoriaEnum.PREMIUM.name())
                .build();

        repository.save(e);
        repository.save(e2);
        repository.save(e3);
    }

}*/

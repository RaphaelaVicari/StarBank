package com.grupo1.bancodigital.service;

import com.grupo1.bancodigital.dto.CategoriaEnum;
import com.grupo1.bancodigital.entity.cliente.CategoriaEntity;
import com.grupo1.bancodigital.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaEntity procurarCategoriaPorNome(CategoriaEnum e) {
        return categoriaRepository.findByNomeCategoria(e.name());
    }

}

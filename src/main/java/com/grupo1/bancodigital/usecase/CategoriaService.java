package com.grupo1.bancodigital.usecase;

import com.grupo1.bancodigital.dto.CategoriaEnum;
import com.grupo1.bancodigital.model.cliente.CategoriaEntity;
import com.grupo1.bancodigital.dao.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaEntity procurarCategoriaPorNome(CategoriaEnum e) {
        return categoriaRepository.findByNomeCategoria(e.name());
    }

    public CategoriaEntity procurarCategoriaPorId(Integer id) {
        return categoriaRepository.findById(id);
    }


}

package com.cenfotec.sucondofeliz.services;

import com.cenfotec.sucondofeliz.domain.Condominio;

import java.util.List;
import java.util.Optional;

public interface CondominioService {

    public void save(Condominio condominio);
    public Optional<Condominio> get(Long id);
    public List<Condominio> getAll();
    public List<Condominio> getAllActivos();
    public List<Condominio> getAllInactivos();
    public void update(Condominio condominio);
}

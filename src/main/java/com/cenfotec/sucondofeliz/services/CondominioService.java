package com.cenfotec.sucondofeliz.services;

import com.cenfotec.sucondofeliz.domain.Amenidad;
import com.cenfotec.sucondofeliz.domain.Condominio;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CondominioService {

    public void save(Condominio condominio);
    public void saveCondominio(Condominio condominio, Long id);
    public Optional<Condominio> get(Long id);
    public List<Condominio> getAll();
    public List<Condominio> getAllActivos();
    public List<Condominio> getAllInactivos();
    public Set<Condominio> getCondominios(Long id);
    public void update(Condominio condominio);
    public void activar(Long id);
    public void desactivar(Long id);
    public Optional<Condominio> delete(Long id);

}

package com.cenfotec.sucondofeliz.services;

import com.cenfotec.sucondofeliz.domain.Amenidad;
import com.cenfotec.sucondofeliz.domain.Condominio;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CondominioService {

    public void save(Condominio condominio);
    public ResponseEntity<Condominio> saveCondominio(Condominio condominio, Long id);
    public ResponseEntity<Condominio> get(Long id);
    public List<Condominio> getAll();
    public List<Condominio> getAllActivos();
    public List<Condominio> getAllInactivos();
    public ResponseEntity<Set<Condominio>> getCondominios(Long id);
    public ResponseEntity<Condominio> update(Condominio condominio);
    public ResponseEntity<Condominio> activar(Long id);
    public ResponseEntity<Condominio> desactivar(Long id);
    public ResponseEntity<Optional<Condominio>> delete(Long id);

}

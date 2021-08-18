package com.cenfotec.sucondofeliz.services;

import com.cenfotec.sucondofeliz.domain.Amenidad;

import java.util.List;
import java.util.Optional;

public interface AmenidadService {

    public void save(Amenidad amenidad);
    public Optional<Amenidad> get(Long id);
    public List<Amenidad> getAll();
    public void update(Amenidad amenidad);
}

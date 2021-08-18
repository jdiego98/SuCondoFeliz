package com.cenfotec.sucondofeliz.services;


import com.cenfotec.sucondofeliz.domain.Cuota;

import java.util.List;
import java.util.Optional;

public interface CuotaService {

    public void save(Cuota cuota);
    public Optional<Cuota> get(Long id);
    public List<Cuota> getAll();
    public void update(Cuota cuota);
}

package com.cenfotec.sucondofeliz.services;

import com.cenfotec.sucondofeliz.domain.Amenidad;
import com.cenfotec.sucondofeliz.repo.AmenidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AmenidadServiceImpl implements  AmenidadService{

    @Autowired
    AmenidadRepository amenidadRepo;

    @Override
    public void save(Amenidad amenidad) {
        amenidadRepo.save(amenidad);
    }

    @Override
    public Optional<Amenidad> get(Long id) {
        return amenidadRepo.findById(id);
    }

    @Override
    public List<Amenidad> getAll() {
        return amenidadRepo.findAll();
    }

    @Override
    public void update(Amenidad amenidad) {
        amenidadRepo.saveAndFlush(amenidad);

    }
}

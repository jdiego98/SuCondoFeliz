package com.cenfotec.sucondofeliz.services;

import com.cenfotec.sucondofeliz.domain.Cuota;
import com.cenfotec.sucondofeliz.repo.CoutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CuotaServiceImpl implements CuotaService{

    @Autowired
    CoutaRepository cuotaRepo;

    @Override
    public void save(Cuota cuota) {
        cuotaRepo.save(cuota);
    }

    @Override
    public Optional<Cuota> get(Long id) {
        return cuotaRepo.findById(id);
    }

    @Override
    public List<Cuota> getAll() {
        return cuotaRepo.findAll();
    }

    @Override
    public void update(Cuota cuota) {
        cuotaRepo.saveAndFlush(cuota);

    }
}

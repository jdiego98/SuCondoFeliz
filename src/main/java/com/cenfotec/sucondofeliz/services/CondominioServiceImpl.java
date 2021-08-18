package com.cenfotec.sucondofeliz.services;

import com.cenfotec.sucondofeliz.domain.Condominio;
import com.cenfotec.sucondofeliz.repo.CondominioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CondominioServiceImpl implements CondominioService{

    @Autowired
    CondominioRepository condominioRepositoryRepo;

    @Override
    public void save(Condominio condominio) {
        condominioRepositoryRepo.save(condominio);
    }

    @Override
    public Optional<Condominio> get(Long id) {
        return condominioRepositoryRepo.findById(id);
    }

    @Override
    public List<Condominio> getAll() {
        return condominioRepositoryRepo.findAll();
    }

    @Override
    public void update(Condominio condominio) {
        condominioRepositoryRepo.saveAndFlush(condominio);
    }

}

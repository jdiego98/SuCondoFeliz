package com.cenfotec.sucondofeliz.services;

import com.cenfotec.sucondofeliz.domain.Cuota;
import com.cenfotec.sucondofeliz.repo.CuotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CuotaServiceImpl implements CuotaService{

    @Autowired
    CuotaRepository cuotaRepo;

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
        return this.cuotaRepo.findAll();
    }


    @Override
    public List<Cuota> getHistorico(Long id) {
        List<Cuota> historico = new ArrayList<Cuota>();

        for(Cuota c: this.cuotaRepo.findAll()){
            if(id == c.getCondominio().getId()){
                historico.add(c);
            }
        }
        return historico;
    }

    @Override
    public void update(Cuota cuota) {
        cuotaRepo.saveAndFlush(cuota);
    }


}

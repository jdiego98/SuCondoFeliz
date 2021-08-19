package com.cenfotec.sucondofeliz.services;

import com.cenfotec.sucondofeliz.domain.Condominio;
import com.cenfotec.sucondofeliz.domain.Cuota;
import com.cenfotec.sucondofeliz.repo.CondominioRepository;
import com.cenfotec.sucondofeliz.repo.CuotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CondominioServiceImpl implements CondominioService{

    @Autowired
    CondominioRepository condominioRepositoryRepo;

    @Autowired
    CuotaRepository cuotaRepository;

    @Override
    public void save(Condominio condominio) {
        condominioRepositoryRepo.save(condominio);
        Cuota cuota = new Cuota(condominio.getCuota(), new Date(), condominio);
        this.cuotaRepository.save(cuota);
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
    public List<Condominio> getAllActivos() {
        List<Condominio> result = new ArrayList<Condominio>();

        for (Condominio c : this.condominioRepositoryRepo.findAll()) {
            if(c.isEstado()){
                result.add(c);
            }
        }
        return result;
    }

    @Override
    public List<Condominio> getAllInactivos() {
        List<Condominio> result = new ArrayList<Condominio>();

        for (Condominio c : this.condominioRepositoryRepo.findAll()) {
            if(!c.isEstado()){
                result.add(c);
            }
        }
        return result;
    }

    @Override
    public void update(Condominio condominio) {

        Condominio condo = this.condominioRepositoryRepo.findById(condominio.getId()).get();

        if(condo.getCuota() != condominio.getCuota()){
            Cuota cuota = new Cuota(condominio.getCuota(), new Date(), condominio);
            this.cuotaRepository.save(cuota);
        }
        this.condominioRepositoryRepo.saveAndFlush(condominio);
    }

    @Override
    public void activar(Long id) {
        Optional<Condominio> condo = this.condominioRepositoryRepo.findById(id);
        if(condo.isPresent()){
            condo.get().setEstado(true);
            this.condominioRepositoryRepo.saveAndFlush(condo.get());
        }else {
            // NO EXISTE ESE REGISTRO, ENVIAR EL CODIGO CORRECTO
        }
    }

    @Override
    public void desactivar(Long id) {
        Optional<Condominio> condo = this.condominioRepositoryRepo.findById(id);
        if(condo.isPresent()){
            condo.get().setEstado(false);
            this.condominioRepositoryRepo.saveAndFlush(condo.get());
        }else {
            // NO EXISTE ESE REGISTRO, ENVIAR EL CODIGO CORRECTO
        }

    }

}

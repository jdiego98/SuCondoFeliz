package com.cenfotec.sucondofeliz.services;

import com.cenfotec.sucondofeliz.domain.Amenidad;
import com.cenfotec.sucondofeliz.domain.Condominio;
import com.cenfotec.sucondofeliz.domain.Cuota;
import com.cenfotec.sucondofeliz.repo.AmenidadRepository;
import com.cenfotec.sucondofeliz.repo.CondominioRepository;
import com.cenfotec.sucondofeliz.repo.CuotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CondominioServiceImpl implements CondominioService{

    @Autowired
    CondominioRepository condominioRepositoryRepo;

    @Autowired
    CuotaRepository cuotaRepository;

    @Autowired
    AmenidadRepository amenidadRepository;

    @Override
    public void save(Condominio condominio) {
        condominioRepositoryRepo.save(condominio);
        Cuota cuota = new Cuota(condominio.getCuota(), new Date(), condominio);
        this.cuotaRepository.save(cuota);
    }

    @Override
    public void saveCondominio(Condominio condominio, Long id) {

        Optional<Condominio> c = this.condominioRepositoryRepo.findById(id);

        if(c.isPresent()){

            Condominio nuevoCondominio = this.condominioRepositoryRepo.save(condominio);

            c.get().getCondominios().add(nuevoCondominio);
            this.condominioRepositoryRepo.saveAndFlush(c.get());

        }else {
            //No existe ese condominio al que se le va a agregar el condominio
        }
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
    public Set<Condominio> getCondominios(Long id) {

        Optional<Condominio> condo = this.condominioRepositoryRepo.findById(id);
        if(condo.isPresent()){
            return condo.get().getCondominios();

        }else {
            // NO EXISTE ESE REGISTRO, ENVIAR EL CODIGO CORRECTO

            return null;
        }


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

    @Override
    public Optional<Condominio> delete(Long id) {
        Optional<Condominio> condo = this.condominioRepositoryRepo.findById(id);
        if(condo.isPresent()){
            condo.get().setEliminado("ex-condominio");
            return Optional.of(this.condominioRepositoryRepo.saveAndFlush(condo.get()));
        }else {
            // NO EXISTE ESE REGISTRO, ENVIAR EL CODIGO CORRECTO
            return Optional.empty();
        }
    }


}

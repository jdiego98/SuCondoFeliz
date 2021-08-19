package com.cenfotec.sucondofeliz.services;

import com.cenfotec.sucondofeliz.domain.Amenidad;
import com.cenfotec.sucondofeliz.domain.Condominio;
import com.cenfotec.sucondofeliz.domain.Cuota;
import com.cenfotec.sucondofeliz.repo.AmenidadRepository;
import com.cenfotec.sucondofeliz.repo.CondominioRepository;
import com.cenfotec.sucondofeliz.repo.CuotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Condominio> saveCondominio(Condominio condominio, Long id) {

        Optional<Condominio> c = this.condominioRepositoryRepo.findById(id);
        if(c.isPresent()){

            Condominio nuevoCondominio = this.condominioRepositoryRepo.save(condominio);
            c.get().getCondominios().add(nuevoCondominio);
            this.condominioRepositoryRepo.saveAndFlush(c.get());
            return ResponseEntity.ok().body(nuevoCondominio);

        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @Override
    public ResponseEntity<Condominio> get(Long id) {

        Optional<Condominio> condo = this.condominioRepositoryRepo.findById(id);
        if(condo.isPresent()){
            return ResponseEntity.ok().body(condo.get());
        }else {
            return ResponseEntity.noContent().build();
        }
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
    public ResponseEntity<Set<Condominio>> getCondominios(Long id) {

        Optional<Condominio> condo = this.condominioRepositoryRepo.findById(id);
        if(condo.isPresent()){
            return ResponseEntity.ok().body(condo.get().getCondominios());
        }else {
            return ResponseEntity.noContent().build();
        }


    }

    @Override
    public ResponseEntity<Condominio> update(Condominio condominio) {

        Optional<Condominio> condo = this.condominioRepositoryRepo.findById(condominio.getId());

        if(condo.isPresent()){
            if(condo.get().getCuota()!= condominio.getCuota()){
                Cuota cuota = new Cuota(condominio.getCuota(), new Date(), condominio);
                this.cuotaRepository.save(cuota);
            }

            this.condominioRepositoryRepo.saveAndFlush(condominio);
            return ResponseEntity.ok().body(condominio);

        }else {
            return ResponseEntity.noContent().build();
        }

    }

    @Override
    public ResponseEntity<Condominio> activar(Long id) {
        Optional<Condominio> condo = this.condominioRepositoryRepo.findById(id);
        if(condo.isPresent()){
            condo.get().setEstado(true);
            this.condominioRepositoryRepo.saveAndFlush(condo.get());
            return ResponseEntity.ok().body(condo.get());
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @Override
    public ResponseEntity<Condominio> desactivar(Long id) {
        Optional<Condominio> condo = this.condominioRepositoryRepo.findById(id);
        if(condo.isPresent()){
            condo.get().setEstado(false);
            this.condominioRepositoryRepo.saveAndFlush(condo.get());
            return ResponseEntity.ok().body(condo.get());
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @Override
    public ResponseEntity<Optional<Condominio>> delete(Long id) {
        Optional<Condominio> condo = this.condominioRepositoryRepo.findById(id);
        if(condo.isPresent()){
            condo.get().setEliminado("ex-condominio");
            return ResponseEntity.ok().body(Optional.of(this.condominioRepositoryRepo.saveAndFlush(condo.get())));
        }else {
            return ResponseEntity.noContent().build();
        }
    }


}

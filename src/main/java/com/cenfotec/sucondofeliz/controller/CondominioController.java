package com.cenfotec.sucondofeliz.controller;

import com.cenfotec.sucondofeliz.domain.Amenidad;
import com.cenfotec.sucondofeliz.domain.Condominio;
import com.cenfotec.sucondofeliz.domain.Cuota;
import com.cenfotec.sucondofeliz.services.AmenidadService;
import com.cenfotec.sucondofeliz.services.CondominioService;
import com.cenfotec.sucondofeliz.services.CuotaService;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class CondominioController {

    @Autowired
    CondominioService condominioService;

    @Autowired
    CuotaService cuotaService;

    @Autowired
    AmenidadService amenidadService;



    @GetMapping("/condominio")
    public List<Condominio> getAllCondiminio(){
        return this.condominioService.getAll();
    }

    @GetMapping("/condominio/activos")
    public List<Condominio> getAllCondiminioActivos(){
        return this.condominioService.getAllActivos();
    }

    @GetMapping("/condominio/inactivos")
    public List<Condominio> getAllCondiminioInactivos(){
        return this.condominioService.getAllInactivos();
    }

    @GetMapping("/condominio/{id}")
    public ResponseEntity<Condominio> getGameById(@PathVariable(value = "id") Long id) {
      return this.condominioService.get(id);
    }

    @PostMapping(value="/condominio")
    public void createCondominio(@RequestBody Condominio condomnio){
        this.condominioService.save(condomnio);
    }

    @PostMapping(value="/condominio/{id}")
    public ResponseEntity<Condominio> createCondominio(@RequestBody Condominio condomnio, @PathVariable Long id){
        return this.condominioService.saveCondominio(condomnio, id);
    }

    @PutMapping(value="/condominio")
    public ResponseEntity<Condominio> updateCondominio(@RequestBody Condominio condominio){
        return this.condominioService.update(condominio);
    }

    @PutMapping(value="/condominio/activar/{id}")
    public ResponseEntity<Condominio> activar(@PathVariable(value = "id") Long id){
        return this.condominioService.activar(id);
    }

    @PutMapping(value="/condominio/desactivar/{id}")
    public ResponseEntity<Condominio> desacticar(@PathVariable(value = "id") Long id){
        return this.condominioService.desactivar(id);
    }

    @GetMapping("/condominio/cuotas/{id}")
    public List<Cuota> getCuotas(@PathVariable(value = "id") Long id){
        return this.cuotaService.getHistorico(id);
    }

    @PostMapping(value="/condominio/amenidades/{id}")
    public void createAmenidad(@RequestBody Amenidad amenidad, @PathVariable Long id){
        this.amenidadService.save(amenidad, id);
    }

    @GetMapping("/condominio/amenidades/{id}")
    public List<Amenidad> getAmenidades(@PathVariable(value = "id") Long id){
        return this.amenidadService.getAllByCondominio(id);
    }


    @GetMapping("/condominio/condominios/{id}")
    public ResponseEntity<Set<Condominio>> getCondominiosCondo(@PathVariable(value = "id") Long id){
        return this.condominioService.getCondominios(id);
    }

    @DeleteMapping("condominio/{id}")
    public ResponseEntity<Optional<Condominio>> delete(@PathVariable(value="id") Long id){
        return this.condominioService.delete(id);
    }



}

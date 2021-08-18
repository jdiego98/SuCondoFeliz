package com.cenfotec.sucondofeliz.controller;

import com.cenfotec.sucondofeliz.domain.Condominio;
import com.cenfotec.sucondofeliz.services.CondominioService;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CondominioController {

    @Autowired
    CondominioService condominioService;

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
       Optional<Condominio> result = this.condominioService.get(id);
       if(result.isPresent()){
           return ResponseEntity.ok().body(result.get());
       }else {
           return ResponseEntity.notFound().build();
       }
    }

    @PostMapping(value="/condominio")
    public void createCondominio(@RequestBody Condominio condomnio){
        this.condominioService.save(condomnio);
    }

    @PutMapping(value="/condominio")
    public void updateCondominio(@RequestBody Condominio condominio){
        this.condominioService.update(condominio);
    }

}

package com.cenfotec.sucondofeliz.controller;

import com.cenfotec.sucondofeliz.domain.Condominio;
import com.cenfotec.sucondofeliz.services.CondominioService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/condominio/{id}")
    public Optional<Condominio> getGameById(@PathVariable(value = "id") Long id) {
        return this.condominioService.get(id);
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

package com.cenfotec.sucondofeliz.services;

import com.cenfotec.sucondofeliz.domain.Amenidad;
import com.cenfotec.sucondofeliz.domain.Condominio;
import com.cenfotec.sucondofeliz.repo.AmenidadRepository;
import com.cenfotec.sucondofeliz.repo.CondominioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AmenidadServiceImpl implements  AmenidadService{

    @Autowired
    AmenidadRepository amenidadRepository;

    @Autowired
    CondominioRepository condominioRepository;

    @Override
    public void save(Amenidad amenidad, Long idCondominio) {

          Optional<Condominio> condo = this.condominioRepository.findById(idCondominio);

          if(condo.isPresent()){
              amenidad.setCondominio(condo.get());
              this.amenidadRepository.save(amenidad);
          }else {
              // NO EXISTE ESE REGISTRO, ENVIAR EL CODIGO CORRECTO
          }
    }


    @Override
    public Optional<Amenidad> get(Long id) {
        return amenidadRepository.findById(id);
    }

    @Override
    public List<Amenidad> getAllByCondominio(Long idConodminio) {

        ArrayList<Amenidad> amenidades = new ArrayList<Amenidad>();

        for(Amenidad a: this.amenidadRepository.findAll()){
            if(a.getCondominio().getId() == idConodminio){
                amenidades.add(a);
            }else{
                //No Hay amenidades para ese registro
            }
        }

        return amenidades;
    }

    @Override
    public void update(Amenidad amenidad) {
        amenidadRepository.saveAndFlush(amenidad);
    }


}

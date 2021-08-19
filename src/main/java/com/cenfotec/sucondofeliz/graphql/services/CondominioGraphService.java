package com.cenfotec.sucondofeliz.graphql.services;

import com.cenfotec.sucondofeliz.graphql.entities.CondominioGraph;
import com.cenfotec.sucondofeliz.graphql.repositories.CondominioGraphRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CondominioGraphService {

    @Autowired
    CondominioGraphRepository condominioRepository;

    public List<CondominioGraph> getAllCondominios(int count) {
        return this.condominioRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }
    public Optional<CondominioGraph> getCondominio(int id) {
        return this.condominioRepository.findById(id);
    }

    public CondominioGraph createCondominio(String nombre, String direccion, String cedulaJuridica, String representante,
                                            int unidades, boolean estado, double cuota, String eliminado,
                                            Set<CondominioGraph> condominios) {
        CondominioGraph condominio = new CondominioGraph();
        condominio.setNombre(nombre);
        condominio.setDireccion(direccion);
        condominio.setCedulaJuridica(cedulaJuridica);
        condominio.setRepresentante(representante);
        condominio.setUnidades(unidades);
        condominio.setEstado(estado);
        condominio.setCuota(cuota);
        condominio.setEliminado(eliminado);
        condominio.setCondominios(condominios);

        return this.condominioRepository.save(condominio);
    }

}

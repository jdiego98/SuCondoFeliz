package com.cenfotec.sucondofeliz.graphql.query;

import com.cenfotec.sucondofeliz.graphql.entities.CondominioGraph;
import com.cenfotec.sucondofeliz.graphql.services.CondominioGraphService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CondominioQuery implements GraphQLQueryResolver {

    @Autowired
    private CondominioGraphService condominioService;


    public List<CondominioGraph> getCondominios(int count) {
        return this.condominioService.getAllCondominios(count);
    }
    public Optional<CondominioGraph> getVehicle(int id) {
        return this.condominioService.getCondominio(id);
    }


}

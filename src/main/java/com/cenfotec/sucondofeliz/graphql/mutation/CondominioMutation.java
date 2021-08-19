package com.cenfotec.sucondofeliz.graphql.mutation;

import com.cenfotec.sucondofeliz.graphql.entities.CondominioGraph;
import com.cenfotec.sucondofeliz.graphql.services.CondominioGraphService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class CondominioMutation implements GraphQLMutationResolver {

    @Autowired
    private CondominioGraphService condominioService;

    public CondominioGraph createCondominio(String nombre, String direccion, String cedulaJuridica, String representante,
                                            int unidades, boolean estado, double cuota, String eliminado,
                                            Set<CondominioGraph> condominios) {
        return this.condominioService.createCondominio(nombre, direccion, cedulaJuridica,
                representante,unidades,estado, cuota, eliminado, condominios);
    }

}

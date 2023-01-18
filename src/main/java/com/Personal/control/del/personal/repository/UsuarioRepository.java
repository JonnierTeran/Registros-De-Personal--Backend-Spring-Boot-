package com.Personal.control.del.personal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.Personal.control.del.personal.models.UsuarioModels;

@Repository //Indicamos que es un repositorio
public interface UsuarioRepository extends CrudRepository<UsuarioModels, Integer>//Extendemos de la clase CrudRepository e indicamos el tipo de dato que es, y el tipo de dato de su pk
{
    
}

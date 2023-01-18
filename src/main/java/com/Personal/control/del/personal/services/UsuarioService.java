package com.Personal.control.del.personal.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Personal.control.del.personal.models.UsuarioModels;
import com.Personal.control.del.personal.repository.UsuarioRepository;

@Service
public class UsuarioService {
   
    @Autowired // Crea la instancia automaticamente
    UsuarioRepository usuarioRepository; //Generamos un objeto de tipo UsuarioRepository

    //Creamos un metodo para obtener todos los usuarios Registrados en un arreglo
    public ArrayList<UsuarioModels> getUsers(){
       return (ArrayList<UsuarioModels>)  usuarioRepository.findAll(); //Usamos el metodo FindAll del repositorio para retornar todos los registros de la tabla usuarios
    }

    //Creamos el metodo para registrar
    public UsuarioModels NewUser(UsuarioModels User){
        return usuarioRepository.save(User); // Con el metodo save del repositorio registramos un nuevo usuario
    }

    
}

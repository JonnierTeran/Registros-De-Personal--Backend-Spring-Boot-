package com.Personal.control.del.personal.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    //Buscar un usuario de tipo opcional por si no existe
    public Optional<UsuarioModels> GetUser(Integer id){
        return usuarioRepository.findById(id);
    }

    //Object == Any /// Buscar un usuario por id y validar que exista
    public Object GetUser2(Integer id){ 
        Optional<UsuarioModels> item = usuarioRepository.findById(id); //Optional si no existe es null puede o no estar presente un valor
        if (item.isPresent()) {  //isPresent determina si hay un valor diferente a null en un elemento Optional
            return item.get(); // get Obtiene el valor del elemento Optional
        } else {
            return new ResponseEntity<>("No existe en la base de datos", HttpStatus.OK); // Respondemos un cuerpo y un estado
        }
    }

    

    
    
}

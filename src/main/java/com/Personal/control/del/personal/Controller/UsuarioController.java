package com.Personal.control.del.personal.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Personal.control.del.personal.models.UsuarioModels;
import com.Personal.control.del.personal.services.UsuarioService;

@RestController // Indicamos que es un controlador Rest
@RequestMapping("/usuarios") // Indicamos la ruta Especifica de los endPoints
public class UsuarioController {
    
    @Autowired //Generamos una instancia automatica
    UsuarioService usuarioService; // Creamos un objeto UsuarioService

    //Metodo get para obtener todos los usuarios
    @GetMapping("/Obtener") //Indicamos que es un get y le damos un path
    public ArrayList<UsuarioModels> GetUsers(){
        return this.usuarioService.getUsers(); // Retornamos el metodo del servicio
    }
    //Metodo post para registrar un usuario / Y actualizar con el id
    @PostMapping("/Add") // Indicamos que es un post y le damos una path
    public UsuarioModels GuardarUser(@RequestBody UsuarioModels User){
        return this.usuarioService.NewUser(User); //Retornamos el metodo del servicio
    }
    

}

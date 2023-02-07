package com.Personal.control.del.personal.Controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Personal.control.del.personal.models.UsuarioModels;
import com.Personal.control.del.personal.services.UsuarioService;

@RestController // Indicamos que es un controlador Rest
@RequestMapping(path = "/usuarios") // Indicamos la ruta Especifica de los endPoints
public class UsuarioController {
    
    @Autowired //Generamos una instancia automatica
    UsuarioService usuarioService; // Creamos un objeto UsuarioService

/*************************************************************************************************************************************** */
    //Metodo get para obtener todos los usuarios
    @GetMapping(path = "/Obtener") //Indicamos que es un get y le damos un path
    public ArrayList<UsuarioModels> GetUsers(){
        return this.usuarioService.getUsers(); // Retornamos el metodo del servicio
    }
/*************************************************************************************************************************************** */
    //Metodo post para registrar un usuario / Y actualizar con el id
    @PostMapping(path = "/Add") // Indicamos que es un post y le damos una path
    public ResponseEntity<String> GuardarUser(@RequestBody UsuarioModels User){
        this.usuarioService.NewUser(User);
        return new ResponseEntity<>("Usuario Registrado Exitosamente", HttpStatus.OK);
        //return this.usuarioService.NewUser(User); //Retornamos el metodo del servicio
    }

/*************************************************************************************************************************************** */
    //Buscar un usuario y retornar user/null
    @GetMapping(path = "/user/{id}")
    public Optional<UsuarioModels> OneUser(@PathVariable("id") int Id){
        return this.usuarioService.GetUser(Id);
    }

/*************************************************************************************************************************************** */    
    //Buscar un usuario y retornar user/null con validacion de existencia
    @GetMapping(path = "/user2/{id}")
    public Object Bucar(@PathVariable("id") int Id){
        return this.usuarioService.GetUser2(Id);
    }

/*************************************************************************************************************************************** */
    @GetMapping(path ="/test")
    @ResponseBody //Responder un cuerpo en la funcion
    public ResponseEntity<String> function(){
        return new ResponseEntity<>("Hello si funciona", HttpStatus.OK);
    }
}

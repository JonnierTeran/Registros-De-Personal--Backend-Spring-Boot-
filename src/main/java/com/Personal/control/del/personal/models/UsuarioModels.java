package com.Personal.control.del.personal.models;


//Notaciones necesarias para indicar las caracteristicas de la tabla sql
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity // Indicador de que es un modelo Real para una Base de datos
@Table(name = "PersonasAct") // Indicamos el nombre que queremos para la tabla en la bd para que no use el de la clase
public class UsuarioModels {

    @Id // Indicamos que es un id o primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ES Autoincrementable
    @Column(unique = true, nullable = false) // Es unico  y no nullo
    private int id;

    @Column(columnDefinition = "VARCHAR(250) DEFAULT 'JUAN'") // no es nullo y tamaño definido y default
     private String Nombres; 
     
     @Column(nullable = false)  // No null y tamaño definido
     private String Apellidos;

    //Metodo constructor
    public UsuarioModels(){}

    //Metodos set y gett para cada atributo
    public void setId(int id){
        this.id= id;
    }
    public int getId(){
        return this.id;
    }
    public void setNombres(String Nombres){
        this.Nombres = Nombres;
    }
    public String Nombres(){
        return this.Nombres;
    }
    public void setApellidos(String Apellidos){
        this.Apellidos = Apellidos;
    }
    public String getApellidos(){
        return this.Apellidos;
    }


    //Con esto ya tenemos una entidad real en una base de datos

}

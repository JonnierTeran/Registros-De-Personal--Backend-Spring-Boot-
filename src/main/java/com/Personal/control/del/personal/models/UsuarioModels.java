package com.Personal.control.del.personal.models;


//Notaciones necesarias para indicar las caracteristicas de la tabla sql
import jakarta.persistence.*;



@Entity // Indicador de que es un modelo Real para una Base de datos
@Table(name = "Personas") // Indicamos el nombre que queremos para la tabla en la bd para que no use el de la clase
public class UsuarioModels {

    @Id // Indicamos que es un id o primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ES Autoincrementable
    @Column(unique = true, nullable = false) // Es unico  y no nullo
    private int id;
    @Column(nullable = false, columnDefinition = "VARCHAR(250) DEFAULT 'JUAN'") // tamaño definido y default
     private String nombres; 
    @Column(nullable = false)  // No null y tamaño definido
     private String apellidos;

    //Metodo constructor
    public UsuarioModels(){}

    //Metodos set y gett para cada atributo
    public void setId(int id){
        this.id= id;
    }
    public int getId(){
        return this.id;
    }
    public void setNombres(String nombres){
        this.nombres = nombres;
    }
    public String getNombres(){
        return this.nombres;
    }
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    public String getApellidos(){
        return this.apellidos;
    }


    //Con esto ya tenemos una entidad real en una base de datos

}

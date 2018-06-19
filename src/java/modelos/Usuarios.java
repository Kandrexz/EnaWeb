
package modelos;


public class Usuarios {
    private int id;
    private String nombre,pass;

    public Usuarios() {
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public Usuarios(String nombre ) {
        this.nombre = nombre;
       
    }

    public Usuarios(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

  
    
    
}

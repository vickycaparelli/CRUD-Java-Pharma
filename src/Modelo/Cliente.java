package Modelo;

public class Cliente {
    private int DNI;
    private String nombre;
    private String apellido;
    private int telefono;
    private String ultDispensacion; //La puse como String porque si mal no recuerdo la clase Date me habia dado problemas, si ustedes la usaron como Datesin pribemas cambienla

    //No olvidar el constructor para simplificar el trabajo
   
    public Cliente( int DNI,String nombre, String apellido, int telefono, String ultDispensacion){
		this.DNI=DNI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.ultDispensacion = ultDispensacion;
	}
    
    
    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getUltDispensacion() {
        return ultDispensacion;
    }

    public void setUltDispensacion(String ultDispensacion) {
        this.ultDispensacion = ultDispensacion;
    }
}

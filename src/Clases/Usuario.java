package Clases;

public class Usuario{
   String Nombre;
   String telefono;
   String fecha_nac;
   private String idUsuario;
   private String constraseña;
   
   public Usuario(){
       this.idUsuario=null;
       this.constraseña=null;
   }

    @Override
    public String toString() {
        return Nombre +" "+ telefono +" "+ fecha_nac +" "+ idUsuario +" "+constraseña;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getConstraseña() {
        return constraseña;
    }

    public void setConstraseña(String constraseña) {
        this.constraseña = constraseña;
    }
   
}

package Clases;

public class PerfildeUsuario{
    String id_Usuario;
    ListaInteres intereses; 

    @Override
    public String toString() {
        return "PerfildeUsuario{" + "id_Usuario=" + id_Usuario + ", intereses=" + intereses + '}';
    }
    public PerfildeUsuario(Usuario nuevo){
        id_Usuario=nuevo.getIdUsuario();
        intereses=null;
    }

    public String getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(String id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public ListaInteres getIntereses() {
        return intereses;
    }

    public void setIntereses(ListaInteres intereses) {
        this.intereses = intereses;
    }
    
}

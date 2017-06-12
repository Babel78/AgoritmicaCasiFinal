package Clases;

public class ListaUsuarios {

    
    NodoUsuario cab;
    NodoUsuario ult;
    
       public ListaUsuarios(){
        this.cab=null;
        this.ult=null;
    }
    
    public void insertar(Usuario nue){
        NodoUsuario nuevo=new NodoUsuario(nue);
        if(cab==null){
             cab=nuevo;
             ult=nuevo;
        }
        else{
            ult.setSgte(nuevo);
            ult=nuevo;
        }
    }
    public void Listar(){
        NodoUsuario aux=cab;
        while(aux!=null){
            System.out.println(aux.getUsuario().toString());
            aux=aux.getSgte();
        }
    }
    
    public Usuario LoguearUsuario(String id,String contra){
        NodoUsuario aux=cab;
        boolean encontrado=false;
        Usuario nuevo = null;
        while(aux!=null && !encontrado){
            if(aux.getUsuario().getIdUsuario().equals(id) && aux.getUsuario().getConstraseña().equals(contra)){
                nuevo=aux.getUsuario();
                encontrado=true;
            }
            else{
                aux=aux.getSgte();
            }
        }
        return nuevo;
    }
    
    public Usuario BuscarUsuarioId(String id){
        NodoUsuario aux=cab;
        boolean encontrado=false;
        Usuario nuevo=null;
        while(aux!=null && !encontrado){
            if(aux.getUsuario().getIdUsuario().equals(id)){
                nuevo=aux.getUsuario();
                encontrado=true;
            }
            else{
                aux=aux.getSgte();
            }
        }
        
        return nuevo;
    }
}

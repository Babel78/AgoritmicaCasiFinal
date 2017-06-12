package Clases;

public class ListadePerfildeUsuario {
    
        NodoPerfildeUsuario cab;
        NodoPerfildeUsuario ult;
            
        public ListadePerfildeUsuario(){
            cab=null;
            ult=null;
        }
        
        public void insertar(PerfildeUsuario per){
        NodoPerfildeUsuario nuevo=new NodoPerfildeUsuario(per);
        if(cab==null){
             cab=nuevo;
             ult=nuevo;
        }
        else{
            ult.setSgte(nuevo);
            ult=nuevo;
        }
        }
        
        public void listar(){
            NodoPerfildeUsuario aux=cab;
            while(aux!=null){
                System.out.println(aux.getPerfil().toString());
                aux=aux.getSgte();
            }
        }
        
       public PerfildeUsuario BuscarUsuarioId(String id){
        NodoPerfildeUsuario aux=cab;
        boolean encontrado=false;
        PerfildeUsuario nuevo=null;
        while(aux!=null && !encontrado){
            if(aux.getPerfil().getId_Usuario().equals(id)){
                nuevo=aux.getPerfil();
                encontrado=true;
            }
            else{
                aux=aux.getSgte();
            }
        }
        return nuevo;
    }
     public void EliminarPerfil(String id){
         boolean encontrado=false;
         if(cab.getPerfil().getId_Usuario().equals(id)){
             cab=cab.getSgte();
         }
         else{
           NodoPerfildeUsuario aux=cab;  
           while(!aux.getSgte().getPerfil().getId_Usuario().equals(id)){
               aux=aux.getSgte();
           }
           NodoPerfildeUsuario aux2=aux.getSgte().getSgte();
           aux.setSgte(aux2);
         }
     }  
}

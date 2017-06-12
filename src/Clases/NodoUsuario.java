package Clases;

public class NodoUsuario{
        Usuario usuario;
        NodoUsuario sgte;
    
        NodoUsuario(Usuario u){
            usuario=u;    
            sgte=null;
        }

        public Usuario getUsuario() {
            return usuario;
        }

        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }

        public NodoUsuario getSgte() {
            return sgte;
        }

        public void setSgte(NodoUsuario sgte) {
            this.sgte = sgte;
        }
        
    }
    
 

package Clases;

public class NodoPerfildeUsuario {
        PerfildeUsuario perfil;
        NodoPerfildeUsuario sgte;
        public NodoPerfildeUsuario(PerfildeUsuario perf){
            perfil=perf;
            sgte=null;
        }

        public PerfildeUsuario getPerfil() {
            return perfil;
        }

        public void setPerfil(PerfildeUsuario perfil) {
            this.perfil = perfil;
        }

        public NodoPerfildeUsuario getSgte() {
            return sgte;
        }

        public void setSgte(NodoPerfildeUsuario sgte) {
            this.sgte = sgte;
        }
}
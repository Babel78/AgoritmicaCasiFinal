package Clases;

public class NodoInteres {
        Interes interes;
        NodoInteres sgte;
        
        public NodoInteres(Interes inter){
            interes=inter;
            sgte=null;
        }

        public Interes getInteres() {
            return interes;
        }

        public void setInteres(Interes interes) {
            this.interes = interes;
        }

        public NodoInteres getSgte() {
            return sgte;
        }

        public void setSgte(NodoInteres sgte) {
            this.sgte = sgte;
        }
        
    }

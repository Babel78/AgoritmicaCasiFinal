package Clases;

    public class NodoPagina {
        Pagina pag;
        ListaPaginas nodos;
        
        public NodoPagina(Pagina p){
            pag=p;
            nodos=null;
        }

        public Pagina getPag() {
            return pag;
        }

        public void setPag(Pagina pag) {
            this.pag = pag;
        }

    public ListaPaginas getNodos() {
        return nodos;
    }

    public void setNodos(ListaPaginas nodos) {
        this.nodos = nodos;
    }

    }
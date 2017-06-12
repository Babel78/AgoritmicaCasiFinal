package Clases;

public class Pagina{
    String NombrePag;
    String dirPag;
    String Categoria;

    @Override
    public String toString() {
        return  NombrePag + " " + dirPag + " " + Categoria;
    }

    public String getNombrePag() {
        return NombrePag;
    }

    public void setNombrePag(String NombrePag) {
        this.NombrePag = NombrePag;
    }

    public String getDirPag() {
        return dirPag;
    }

    public void setDirPag(String dirPag) {
        this.dirPag = dirPag;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }
    
}

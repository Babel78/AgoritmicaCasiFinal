package Clases;

import java.util.ArrayList;

public class ListaPaginas {
  
   public ArrayList <NodoPagina> listaP;
    public ListaPaginas(){
        listaP=new ArrayList();
    }
    
    public void AgregarPagina(Pagina nue){
        NodoPagina nuevo=new NodoPagina(nue);
        listaP.add(nuevo);
    }
    
    public void AgregarEnlaces(NodoPagina nuevo, ArrayList<Pagina> lista){
        ListaPaginas l=new ListaPaginas();
        for (int i = 0; i < lista.size(); i++) {
            Pagina get = lista.get(i);
            l.AgregarPagina(get);
        }
        nuevo.setNodos(l);
    }
    public int contar(){
        return listaP.size();
    }
    
    public String Listar(){
        String msj="";
        for (int i = 0; i < listaP.size(); i++) {
            NodoPagina get = listaP.get(i);
            msj+= get.getPag().getNombrePag()+" "+get.getPag().getDirPag()+" "+get.getPag().getCategoria()+"\n";
        }
        return msj;
    }
    
    public void MostrarEnlaces(NodoPagina p){
        System.out.println("El nodo "+ p.getPag().getNombrePag()+" Tiene enlazados a las paginas: ");
        System.out.println(p.getNodos().Listar());
    }
    
   public Pagina ObtenerPagina(String nombre){
       Pagina nuevo = null;
       int i=0;
       boolean ban=false;
       while(i<listaP.size() && !ban){
             NodoPagina get = listaP.get(i);
           if(get.getPag().getNombrePag().equals(nombre)){
               nuevo=get.getPag();
               ban=true;
           }
       }
       return nuevo;
   }
}

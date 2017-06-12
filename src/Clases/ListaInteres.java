package Clases;

public class ListaInteres {

    public NodoInteres cab;
    NodoInteres ult;
    
    public ListaInteres(){
        cab=null;
        ult=null;
    }
    
    public void insertar(Interes nue){
        NodoInteres nuevo=new NodoInteres(nue);
        if(cab==null){
             cab=nuevo;
             ult=nuevo;
        }
        else{
            ult.setSgte(nuevo);
            ult=nuevo;
        }
    }
    
    public String listarIntereses(int porcentaje){
        NodoInteres aux=cab;
        String cadena="";
        while(aux!=null){
            if(aux.getInteres().getPorcetaje()>porcentaje){
                cadena+=aux.getInteres().getNombre()+" "+aux.getInteres().getPorcetaje()+"\n";
            }
            else{
                cadena+="";
            }
            aux=aux.getSgte();
        }
        return cadena;
    }
    
    public int tamaño(){
        NodoInteres aux=cab;
        int tam=0;
        while(aux!=null){
            tam++;
        }
        return tam;
    }
            
}

package BD;

import Clases.ListaPaginas;
import Clases.NodoPagina;
import Clases.Pagina;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MetodosPaginas {
    JSONArray array;
    public void Grabar(NodoPagina pag) throws ParseException{
        JSONObject obj=new JSONObject();
        obj.put("Nombre Pagina", pag.getPag().getNombrePag());
        obj.put("URL", pag.getPag().getDirPag());
        obj.put("Categoria", pag.getPag().getCategoria());
        JSONArray enlaces=new JSONArray();
        ListaPaginas list=pag.getNodos();
        ArrayList <NodoPagina> aux=list.listaP;
        for (int i = 0; i < aux.size(); i++) {
            JSONObject o=new JSONObject();
            o.put("Nombre Pagina",aux.get(i).getPag().getNombrePag());
            o.put("URL", aux.get(i).getPag().getDirPag());
            o.put("Categoria", aux.get(i).getPag().getCategoria());
            enlaces.add(o);
        }
        obj.put("Enlaces", enlaces);
        array=ObtenerArray(); 
        if(array==null){
            array=new JSONArray();
            array.add(obj);
        }
        else{ 
          array.add(obj);
        }        
        try {
            FileWriter f=new FileWriter("Paginas.json");
            f.write(array.toJSONString());
            f.flush();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
   private  JSONArray ObtenerArray() throws ParseException{
        JSONArray jarray=null;
        JSONParser parser = new JSONParser();
        try {
            Object obj=parser.parse(new FileReader("Paginas.json"));
            jarray=(JSONArray) obj;
        } catch (IOException e) {
            System.out.println(e);
        }
        return jarray; 
    }
   
   public ArrayList<NodoPagina> ObtenerPaginas() throws ParseException{
    ArrayList<NodoPagina> lista=new ArrayList();
    JSONArray j=ObtenerArray();
    int i=0;
    while(i<j.size()){
        JSONObject obj=(JSONObject) j.get(i);
        Pagina nuevo=new Pagina();
        nuevo.setNombrePag((String)obj.get("Nombre Pagina"));
        nuevo.setDirPag((String)obj.get("URL"));
        nuevo.setCategoria((String)obj.get("Categoria"));
        NodoPagina nodo=new NodoPagina(nuevo);
        JSONArray enlaces=(JSONArray) obj.get("Enlaces");
        ListaPaginas lis=new ListaPaginas();
        for (int k = 0; k < enlaces.size(); k++) {
            JSONObject o= (JSONObject) enlaces.get(k);
            Pagina p=new Pagina();
            p.setNombrePag((String) o.get("Nombre Pagina"));
            p.setDirPag((String) o.get("URL"));
            p.setCategoria((String) o.get("Categoria"));
            lis.AgregarPagina(p);
        }
        nodo.setNodos(lis);
        lista.add(nodo);
        i++;
    }
    return lista;
   }  
   public NodoPagina ObtenerPagina(String nombre) throws ParseException{
    JSONArray j=ObtenerArray();
    int i=0;
    boolean hall=false;
    NodoPagina nodo=null;
    while(i<j.size() && !hall){
        JSONObject obj=(JSONObject) j.get(i);
        if(obj.get("Nombre Pagina").equals(nombre)){
        Pagina nuevo=new Pagina();
        nuevo.setNombrePag((String)obj.get("Nombre Pagina"));
        nuevo.setDirPag((String)obj.get("URL"));
        nuevo.setCategoria((String)obj.get("Categoria"));
        nodo=new NodoPagina(nuevo);
        JSONArray enlaces=(JSONArray) obj.get("Enlaces");
        ListaPaginas lis=new ListaPaginas();
        for (int k = 0; k < enlaces.size(); k++) {
            JSONObject o= (JSONObject) enlaces.get(k);
            Pagina p=new Pagina();
            p.setNombrePag((String) o.get("Nombre Pagina"));
            p.setDirPag((String) o.get("URL"));
            p.setCategoria((String) o.get("Categoria"));
            lis.AgregarPagina(p);
        }
        nodo.setNodos(lis);
        hall=true;
        }
        else
        i++;
    }
    return nodo;
   }
   
     JSONArray a_registro;
   public void GrabarRegistro(NodoPagina pag,Date ahora) throws ParseException{
        JSONObject obj=new JSONObject();
        SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
        SimpleDateFormat formateadorf = new SimpleDateFormat("dd-mm-yyyy");
        String hora=formateador.format(ahora);
        String fecha=formateadorf.format(ahora);
        obj.put("Fecha",fecha);
        obj.put("Hora", hora);
        obj.put("Pagina", pag.getPag().getNombrePag());
        obj.put("URL", pag.getPag().getDirPag());
        obj.put("Categoria", pag.getPag().getCategoria());
        a_registro=ObtenerRegistro(); 
        if(a_registro==null){
            a_registro=new JSONArray();
            a_registro.add(obj);
        }
        else{ 
          a_registro.add(obj);
        }        
        try {
            FileWriter f=new FileWriter("RegistroVisitas.json");
            f.write(a_registro.toJSONString());
            f.flush();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
   
      public  JSONArray ObtenerRegistro() throws ParseException{
        JSONArray jarray=null;
        JSONParser parser = new JSONParser();
        try {
            Object obj=parser.parse(new FileReader("RegistroVisitas.json"));
            jarray=(JSONArray) obj;
        } catch (IOException e) {
            System.out.println(e);
        }
        return jarray; 
    }
   
}

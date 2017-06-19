package BD;

import Clases.ListaPaginas;
import Clases.NodoPagina;
import Clases.Pagina;
import Clases.PerfildeUsuario;
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
   public void GrabarHistorial(PerfildeUsuario perfil,NodoPagina pag,Date ahora) throws ParseException{
        JSONObject obj=new JSONObject();
        SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
        SimpleDateFormat formateadorf = new SimpleDateFormat("dd-MM-yyyy");
        String hora=formateador.format(ahora);
        String fecha=formateadorf.format(ahora);
        JSONArray ar=new JSONArray();
        JSONObject o=new JSONObject();
        o.put("Fecha",fecha);
        o.put("Hora", hora);
        o.put("Pagina", pag.getPag().getNombrePag());
        o.put("URL", pag.getPag().getDirPag());
        o.put("Categoria", pag.getPag().getCategoria());
        ar.add(o);
        a_registro=ObtenerRegistro(); 
        if(a_registro==null){
            a_registro=new JSONArray();
            obj.put("id_usuario", perfil.getId_Usuario());
            obj.put("Registro", ar);
            a_registro.add(obj);
        }
        else if(existeRegistro(perfil.getId_Usuario())){
           JSONArray o1=RegistrobyId(perfil.getId_Usuario());
           int pos=posbyId(perfil.getId_Usuario());
           o1.addAll(ar);
           JSONObject nuevo=new JSONObject();
           nuevo.put("id_usuario", perfil.getId_Usuario());
           nuevo.put("Registro", o1);
           a_registro.remove(pos);
           a_registro.add(pos, nuevo);
        }   
        else{
            obj.put("id_usuario", perfil.getId_Usuario());
            obj.put("Registro", ar);
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
 
    public boolean existeRegistro(String id) throws ParseException{
        boolean existe=false;
        JSONArray lista=ObtenerRegistro();
        int i=0;
        while(i<lista.size() && !existe){
            JSONObject get = (JSONObject) lista.get(i);
            if(get.get("id_usuario").equals(id)){
               existe=true; 
            }
            else
            i++;
        }
        return existe;
    }
    public JSONArray RegistrobyId(String id) throws ParseException{
        JSONArray lis=ObtenerRegistro();
        JSONArray registro = null;
        for (int i = 0; i < lis.size(); i++) {
            JSONObject ob=(JSONObject) lis.get(i);
            if(id.equals((String) ob.get("id_usuario"))){
               registro=(JSONArray) ob.get("Registro");
               break;
            }
        }
        return registro;
    }
    
    public int posbyId(String id) throws ParseException{
        JSONArray lis=ObtenerRegistro();
        int pos=-1;
        for (int i = 0; i < lis.size(); i++) {
        JSONObject o = (JSONObject) lis.get(i);
            if(o.get("id_usuario").equals(id)){
                pos=i;
                break;
            }
        }
        return pos;
    }
    
    public void EliminarHistorial(String id) throws ParseException{
        JSONArray historial=ObtenerRegistro();
        int pos=posbyId(id);
        historial.remove(pos);
         try {
            FileWriter f=new FileWriter("RegistroVisitas.json");
            f.write(historial.toJSONString());
            f.flush();
        } catch (IOException e) {
            System.out.println(e);
        }       
        
    }
}



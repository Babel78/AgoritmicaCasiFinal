package BD;

import Clases.Interes;
import Clases.ListaInteres;
import Clases.NodoInteres;
import Clases.PerfildeUsuario;
import Clases.Usuario;
import java.io.*;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MetodosPerfildeUsuario {
    JSONArray array;
    public void Guardar(PerfildeUsuario perfil) throws ParseException{
        JSONObject obj=new JSONObject();
        obj.put("ID_Usuario", perfil.getId_Usuario());
        JSONArray inter=new JSONArray();
        if(perfil.getIntereses()!=null){
        NodoInteres aux = perfil.getIntereses().cab;
        while(aux!=null){
            JSONObject o=new JSONObject();
            o.put("Categoria", aux.getInteres().getNombre());
            o.put("Porcentaje", aux.getInteres().getPorcetaje());
            inter.add(o);
            aux=aux.getSgte();
        }
        }
        obj.put("Intereses", inter);
        array=ObtenerArray(); 
        if(array==null){
            array=new JSONArray();
            array.add(obj);
        }
        else{ 
           if(Existe(perfil)){
                System.out.println("Nombre de Usuario ya esta siendo usado");
            }
           else{
               array.add(obj);  
            try {
                FileWriter f=new FileWriter("PerfilUsuarios.json");
                f.write(array.toJSONString());
                f.flush();
            } catch (IOException e) {
            System.out.println(e);
            }
           }
        }

    }
    public JSONArray ObtenerArray() throws ParseException{
        JSONArray jarray=null;
        JSONParser parser = new JSONParser();
        try {
            Object obj=parser.parse(new FileReader("PerfilUsuarios.json"));
            jarray=(JSONArray) obj;
        } catch (IOException e) {
            System.out.println(e);
        }
        return jarray;
    }
    
    public PerfildeUsuario ObtenerPerfil(Usuario us) throws ParseException{
        JSONArray j=ObtenerArray();
        PerfildeUsuario nuevo = null;
        if(j==null){
            System.out.println("No existe el archivo");
        }
        else{
            int i=0;
            boolean hallado=false;
            while(i<j.size() && !hallado){
                JSONObject obj=(JSONObject) j.get(i);
                if(((String)obj.get("ID_Usuario")).equals(us.getIdUsuario())){
                    nuevo=new PerfildeUsuario(us);
                    ListaInteres inter=new ListaInteres();
                    JSONArray l=(JSONArray) obj.get("Intereses");
                    for (int k = 0; k < l.size(); k++) {
                        JSONObject o = (JSONObject) l.get(k);
                        Interes interes=new Interes();
                        interes.setNombre((String) o.get("Categoria"));
                        interes.setPorcetaje(Float.parseFloat(o.get("Porcentaje").toString()));
                        inter.insertar(interes);
                    }
                    nuevo.setIntereses(inter);
                    hallado=true;
                }
                else{
                    i++;
                }
            }
        }
        return nuevo;
    }
    private void AuxActualizarIntereses(PerfildeUsuario nuevo,int indice) throws ParseException{
            JSONObject obj=new JSONObject();
            obj.put("ID_Usuario", nuevo.getId_Usuario());
            JSONArray intereses=new JSONArray ();
            ListaInteres lista=nuevo.getIntereses();
            NodoInteres aux= lista.cab;
            while(aux!=null){
            JSONObject inter=new JSONObject();
            inter.put("Categoria", aux.getInteres().getNombre());
            inter.put("Porcentaje", aux.getInteres().getPorcetaje());
            intereses.add(inter);
            aux=aux.getSgte();
            }
            JSONArray lis=InteresesbyId(nuevo.getId_Usuario());
            lis.addAll(intereses);
            obj.put("Intereses", lis);
            array.remove(indice);
            array.add(indice, obj);
          try {
            FileWriter f=new FileWriter("PerfilUsuarios.json");
            f.write(array.toJSONString());
            f.flush();
        } catch (IOException e) {
            System.out.println(e);
        }    
    }
    
    public JSONArray InteresesbyId(String id) throws ParseException{
        JSONArray lis=ObtenerArray();
        JSONArray intereses = null;
        for (int i = 0; i < lis.size(); i++) {
            JSONObject ob=(JSONObject) lis.get(i);
            if(id.equals((String) ob.get("ID_Usuario"))){
                intereses=(JSONArray) ob.get("Intereses");
                break;
            }
        }

        return intereses;
    }
    public void ActualizarIntereses(PerfildeUsuario nuevo) throws ParseException{
        if(Existe(nuevo)){
            array=ObtenerArray();
            int in=Indice(nuevo, array);
            AuxActualizarIntereses(nuevo,in);    
        }
        else{
            System.out.println("Usuario no encontrado"); 
        }
    }
    public boolean Existe(PerfildeUsuario us) throws ParseException{
        boolean existe=false;
        int i=0;
        JSONArray arr=ObtenerArray();
        while(i<arr.size() && !existe){
            JSONObject o=(JSONObject) arr.get(i);
            if(o.get("ID_Usuario").equals(us.getId_Usuario())){
                existe=true;
            }
            else{
                i++;
            }
        }
       return existe; 
    }
    private int Indice(PerfildeUsuario us,JSONArray arr) throws ParseException{
        int i=0;
        int indice = 0;
        while (i<arr.size()) {
             JSONObject get = (JSONObject) arr.get(i);
            if(get.get("ID_Usuario").equals(us.getId_Usuario())){
                indice=i;
                break;
            }
            else{
                i++;
            }
        }
        return indice;
    }
   public ArrayList<String> ObtenerCategoriasPaginas(ListaInteres list) throws ParseException{
    ArrayList<String> lista=new ArrayList();
    int cont=0;
    NodoInteres aux=list.cab;
    int i=0;
    while(aux!=null){
        String cat=aux.getInteres().getNombre();
        if(aux==list.cab){
            lista.add(cat);
        }
        else{
            for (int j = 0; j < lista.size(); j++) {
                if(cat.equals(lista.get(j))){
                    cont++;
                }
            }
            if(cont==0){
                lista.add(cat);
            }
            cont=0;  

        }
       aux=aux.getSgte();
    }
    return lista;
   }
   public ArrayList<Float> ObtenerPorcentajes(ListaInteres list) throws ParseException{
    ArrayList<Float> lista2=new ArrayList();
    ArrayList<String> lista=new ArrayList();
    int cont=0;
    NodoInteres aux=list.cab;
    while(aux!=null){
        String cat=aux.getInteres().getNombre();
        float porc=aux.getInteres().getPorcetaje();
        if(aux==list.cab){
            lista2.add(porc);
            lista.add(cat);
        }
        else{
            for (int j = 0; j < lista.size(); j++) {
                if(cat.equals(lista.get(j))){
                    cont++;
                }
            }
            if(cont==0){
                lista.add(cat);
                lista2.add(porc);
            }
            else{
                int ind=indiceIntereses(cat,lista);
                lista2.set(ind, porc+lista2.get(ind));  
            }
            cont=0;  
        }
        aux=aux.getSgte();
    }
    return lista2;
   }
   
 public int indiceIntereses(String busc,ArrayList <String> list){
       int i=0;
       int indice=-1;
       boolean hallado=false;
       while (i<list.size() && !hallado) {
           String get=list.get(i);
           if(busc.equals(get)){
               indice=i;
               hallado=true;
           }
           else
           i++;
       }
       return indice;
   }
 
 public void EliminarPerfil(String id) throws ParseException{
     JSONArray perfil=ObtenerArray();
     int pos=posbyId(id);
     perfil.remove(pos);
    try {
        FileWriter f=new FileWriter("PerfilUsuarios.json");
        f.write(perfil.toJSONString());
        f.flush();
    }catch (IOException e) {
      System.out.println(e);
    }
 }
 
 public int posbyId(String id) throws ParseException{
        JSONArray lista=ObtenerArray();
        int i=0;
        int pos=-1;
        boolean hallado=false;
        while(i<lista.size() && !hallado){
            JSONObject obj=(JSONObject) lista.get(i);
            String ID=(String) obj.get("ID_Usuario");
            if(ID.equals(id)){
                pos=i;
                hallado=true;
            }
            else{
                i++;
            }
        }
        return pos;
 }
}



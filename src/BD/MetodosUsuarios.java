package BD;

import Clases.Usuario;
import java.io.*;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class MetodosUsuarios {
    JSONArray array;
    public void Guardar(Usuario nuevo) throws ParseException{
        JSONObject obj=new JSONObject();
        obj.put("Nombre", nuevo.getNombre());
        obj.put("Fecha de Nacimiento", nuevo.getFecha_nac());
        obj.put("Telefono", nuevo.getTelefono());
        obj.put("ID_Usuario", nuevo.getIdUsuario());
        obj.put("Contraseña", nuevo.getConstraseña());
        array=ObtenerArray(); 
        if(array==null){
            array=new JSONArray();
            array.add(obj);
        }
        else{
            if(Existe(nuevo)){
                System.out.println("Nombre de Usuario ya esta siendo usado");
            }
            else{
                array.add(obj);
                try {
                FileWriter f=new FileWriter("Usuarios.json");
                f.write(array.toJSONString());
                f.flush();
            } catch (IOException e) {
                System.out.println(e);
            }
         }
          
        }        
    }

private JSONArray ObtenerArray() throws ParseException{
        JSONArray jarray=null;
        JSONParser parser = new JSONParser();
        try {
            Object obj=parser.parse(new FileReader("Usuarios.json"));
            jarray=(JSONArray) obj;
        } catch (IOException e) {
            System.out.println(e);
        }
        return jarray;
    } 

public ArrayList<Usuario> ObtenerUsuarios() throws ParseException{
    ArrayList<Usuario> lista=new ArrayList();
    JSONArray j=ObtenerArray();
    int i=0;
    while(i<j.size()){
        JSONObject obj=(JSONObject) j.get(i);
        Usuario nuevo=new Usuario();
        nuevo.setNombre((String)obj.get("Nombre"));
        nuevo.setFecha_nac((String)obj.get("Fecha de Nacimiento"));
        nuevo.setTelefono((String)obj.get("Telefono"));
        nuevo.setIdUsuario((String)obj.get("ID_Usuario"));
        nuevo.setConstraseña((String)obj.get("Contraseña"));
        lista.add(nuevo);
        i++;
    }
    return lista;
}

public Usuario ObtenerUsuario(String id,String contraseña) throws ParseException{
    JSONArray j=ObtenerArray();
    Usuario nuevo = null;
    if(j==null){
        System.out.println("No existe el archivo");
    }
    else{
        int i=0;
        boolean hallado=false;
        while(i<j.size() && !hallado){
            JSONObject obj=(JSONObject) j.get(i);
            if((obj.get("ID_Usuario")).equals(id) && (obj.get("Contraseña")).equals(contraseña)){
                nuevo=new Usuario();
                nuevo.setNombre((String)obj.get("Nombre"));
                nuevo.setFecha_nac((String)obj.get("Fecha de Nacimiento"));
                nuevo.setTelefono((String)obj.get("Telefono"));
                nuevo.setIdUsuario((String)obj.get("ID_Usuario"));
                nuevo.setConstraseña((String)obj.get("Contraseña"));
                hallado=true;
            }
            else{
                i++;
            }
        }
    }
    return nuevo;
}
public Usuario ObtenerUsuarioID(String id) throws ParseException{
    JSONArray j=ObtenerArray();
    Usuario nuevo = null;
    if(j==null){
        System.out.println("No existe el archivo");
    }
    else{
        int i=0;
        boolean hallado=false;
        while(i<j.size() && !hallado){
            JSONObject obj=(JSONObject) j.get(i);
            if(((String)obj.get("ID_Usuario")).equals(id)){
                nuevo=new Usuario();
                nuevo.setNombre((String)obj.get("Nombre"));
                nuevo.setFecha_nac((String)obj.get("Fecha de Nacimiento"));
                nuevo.setTelefono((String)obj.get("Telefono"));
                nuevo.setIdUsuario((String)obj.get("ID_Usuario"));
                nuevo.setConstraseña((String)obj.get("Contraseña"));
                hallado=true;
            }
            else{
                i++;
            }
        }
    }
    return nuevo;
}

public ArrayList<Usuario> ObtenerUsuarioNombre(String nombre) throws ParseException{
    ArrayList<Usuario> lista=new ArrayList();
    JSONArray j=ObtenerArray();
    int i=0;
    while(i<j.size()){
        JSONObject obj=(JSONObject) j.get(i);
        String nomb=(String) obj.get("Nombre");
        String aux[]=nomb.split(" ");
        if(aux[0].equals(nombre)){
        Usuario nuevo=new Usuario();
        nuevo.setNombre((String)obj.get("Nombre"));
        nuevo.setFecha_nac((String)obj.get("Fecha de Nacimiento"));
        nuevo.setTelefono((String)obj.get("Telefono"));
        nuevo.setIdUsuario((String)obj.get("ID_Usuario"));
        nuevo.setConstraseña((String)obj.get("Contraseña"));
        lista.add(nuevo);
        }
        i++;
    }
    return lista;
}
    public boolean Existe(Usuario us) throws ParseException{
        boolean existe=false;
        int i=0;
        JSONArray arr=ObtenerArray();
        while(i<arr.size() && !existe){
            JSONObject o=(JSONObject) arr.get(i);
            if(o.get("ID_Usuario").equals(us.getIdUsuario())){
                existe=true;
            }
            else{
                i++;
            }
        }
       return existe; 
    }
}

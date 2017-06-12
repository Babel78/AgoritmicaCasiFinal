package Interfaz;

import BD.MetodosPaginas;
import BD.MetodosPerfildeUsuario;
import Clases.Interes;
import Clases.ListaInteres;
import Clases.ListaPaginas;
import Clases.NodoPagina;
import Clases.Pagina;
import Clases.PerfildeUsuario;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import org.json.simple.parser.ParseException;


public class Paginas extends javax.swing.JFrame {
    DefaultTableModel modelo;
    ListaInteres lis_int=new ListaInteres();
    MetodosPerfildeUsuario met=new MetodosPerfildeUsuario();
    PerfildeUsuario p;
    String cabecera[]={"Nombre de la Pagina","URL","Categoria"};
    String datos[][]={};
    public Paginas(PerfildeUsuario perfil) throws ParseException {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        modelo=new DefaultTableModel(datos,cabecera);
        tablaPaginas.setModel(modelo);
        Datos();
        p=perfil;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPaginas = new javax.swing.JTable();
        visitar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 500));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Area de Navegacion");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(202, 11, 160, 30);

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(80, 400, 92, 23);

        tablaPaginas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaPaginas);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(70, 90, 452, 280);

        visitar.setText("Visitar");
        visitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visitarActionPerformed(evt);
            }
        });
        getContentPane().add(visitar);
        visitar.setBounds(380, 400, 90, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if(lis_int.cab!=null){
            p.setIntereses(lis_int);
            met.ActualizarIntereses(p);  
            }
            PerfilUsuario perfil=new PerfilUsuario(p);
            perfil.setVisible(true);
            dispose();  
            
        } catch (ParseException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
 
    private void visitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visitarActionPerformed
        MetodosPaginas metodos=new MetodosPaginas();    
        ArrayList <NodoPagina> list;
        try {
            list = metodos.ObtenerPaginas();
            int row=tablaPaginas.getSelectedRow();
            Object o=tablaPaginas.getValueAt(tablaPaginas.getSelectedRow(), tablaPaginas.getSelectedColumn());
            NodoPagina nodo = null;
            for (int i = 0; i < list.size(); i++) {
                Pagina get = list.get(i).getPag();
                if(o.equals(get.getNombrePag())){
                    nodo=list.get(i);
                }
            }
            Date hora=new Date();
            metodos.GrabarRegistro(nodo, hora);
            Interes inter=new Interes();
            inter.setNombre(nodo.getPag().getCategoria());
            inter.setPorcetaje(1);
            lis_int.insertar(inter);
            ListaPaginas enlaces=nodo.getNodos();
            ArrayList <NodoPagina> enl=enlaces.listaP;
            tablaEnlaces(enl);
        } catch (ParseException ex) {
            System.out.println(ex);
        }

    }//GEN-LAST:event_visitarActionPerformed
    public void tablaEnlaces(ArrayList<NodoPagina> enlaces){
        Object dat[][]=new Object[enlaces.size()][3];
        for (int i = 0; i < enlaces.size(); i++) {
            Pagina pag = enlaces.get(i).getPag();
            Object o[]={pag.getNombrePag(),pag.getDirPag(),pag.getCategoria()};
            for (int j = 0; j < o.length; j++) {
                    dat[i][j]= o[j];
            }
        }
        modelo.setDataVector(dat, cabecera);
    }
    
    public void Datos() throws ParseException{
        MetodosPaginas metodos=new MetodosPaginas();
        ArrayList <NodoPagina> lista=metodos.ObtenerPaginas();
        Object Dat[][]=new Object[lista.size()][3];
        for (int i = 0; i < lista.size(); i++) {
            Pagina pag=lista.get(i).getPag();
            Object o[]={pag.getNombrePag(),pag.getDirPag(),pag.getCategoria()};
            for (int j = 0; j < o.length; j++) {
                    Dat[i][j]= o[j];
                }
        }
        modelo.setDataVector(Dat, cabecera);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPaginas;
    private javax.swing.JButton visitar;
    // End of variables declaration//GEN-END:variables
}

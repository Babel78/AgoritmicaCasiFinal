package Interfaz;

import BD.MetodosUsuarios;
import Clases.Usuario;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.json.simple.parser.ParseException;


public class AdministradorUsuario extends javax.swing.JFrame {
    MetodosUsuarios metodos=new MetodosUsuarios();
    DefaultTableModel modelo;
    String cabecera[]={"ID_Usuario","Contraseña","Nombre","Telefono","Fecha_Nac"};
    String datos[][]={};
    public AdministradorUsuario() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);

        modelo=new DefaultTableModel(datos,cabecera);
        tabla.setModel(modelo);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        ver_Usuarios = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        nom = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        salir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ver_Usuarios.setText("Ver Usuarios");
        ver_Usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ver_UsuariosActionPerformed(evt);
            }
        });

        eliminar.setText("Eliminar Usuario");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("ADMINISTRADOR");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        jLabel2.setText("BUSCAR:");

        jLabel3.setText("Nombre:");

        nom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomKeyReleased(evt);
            }
        });

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        jButton1.setText("Ordenar Usuarios");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ver_Usuarios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(salir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(261, 261, 261)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(94, 94, 94)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ver_Usuarios)
                        .addGap(30, 30, 30)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eliminar)
                        .addGap(45, 45, 45)
                        .addComponent(salir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        Administrador root=new Administrador();
        root.setVisible(true);
        dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void ver_UsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ver_UsuariosActionPerformed
        try {
            ArrayList<Usuario> lista= metodos.ObtenerUsuarios();
            MostrarDatosTabla(lista);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_ver_UsuariosActionPerformed

    private void nomKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomKeyReleased
        mostrar_datos(nom.getText());
    }//GEN-LAST:event_nomKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ArrayList<Usuario> lis;
        try {
            lis = metodos.ObtenerUsuarios();
            int der=lis.size()-1;
            int izq=0;
            Ordenar(lis, izq, der);
            MostrarDatosTabla(lis);
        } catch (ParseException ex) {
            Logger.getLogger(AdministradorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
     

    }//GEN-LAST:event_jButton1ActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        ArrayList <Usuario> list;
        try {
            Object o=tabla.getValueAt(tabla.getSelectedRow(), tabla.getSelectedColumn());
            int respuesta=JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar a este usuario?");
            if(respuesta==0){
              metodos.EliminarUsuario((String) o);
              JOptionPane.showMessageDialog(null, "Usuario Elminado");
              
            }
        } catch (ParseException ex) {
            System.out.println(ex);
        }

    }//GEN-LAST:event_eliminarActionPerformed
    public void ajustar(){
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(2).setPreferredWidth(150);
    }
    public void mostrar_datos(String texto){
          try {
            ArrayList <Usuario> lista=metodos.ObtenerUsuarioNombre(texto);
              MostrarDatosTabla(lista);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
    }
    public void Ordenar(ArrayList<Usuario> usuarios,int izq,int der){
            Usuario pivote=usuarios.get(izq);
            int i=izq;
            int j=der; 
            while(i<j){          
               while(usuarios.get(i).getNombre().charAt(0)<=pivote.getNombre().charAt(0) && i<j) i++; 
               while(usuarios.get(j).getNombre().charAt(0)>pivote.getNombre().charAt(0)) j--;         
               if (i<j) {                                 
                   Usuario aux= usuarios.get(i);                  
                   usuarios.set(i, usuarios.get(j));
                   usuarios.set(j,aux);
               }
             }
             usuarios.set(izq, usuarios.get(j)); 
             usuarios.set(j, pivote); 
             if(izq<j-1)
                Ordenar(usuarios,izq,j-1);
             if(j+1 <der)
                Ordenar(usuarios,j+1,der); 
    }
    public void MostrarDatosTabla(ArrayList <Usuario> users){
            int dim=users.size();
            Object dat[][]=new Object[dim][5];
            for (int i = 0; i < users.size(); i++) {
                Usuario usu = users.get(i);
                Object o[]={usu.getIdUsuario(),usu.getConstraseña(),usu.getNombre(),usu.getTelefono(),usu.getFecha_nac()};
                for (int j = 0; j < o.length; j++) {
                    dat[i][j]= o[j];
                }    
            }
          modelo.setDataVector(dat, cabecera);
          ajustar();
    }
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton eliminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField nom;
    private javax.swing.JButton salir;
    private javax.swing.JTable tabla;
    private javax.swing.JButton ver_Usuarios;
    // End of variables declaration//GEN-END:variables
}

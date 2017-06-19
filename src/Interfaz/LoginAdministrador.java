
package Interfaz;

import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class LoginAdministrador extends javax.swing.JFrame {

  
    public LoginAdministrador() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        contra = new javax.swing.JPasswordField();
        ingresar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADMINISTRADOR");
        setMinimumSize(new java.awt.Dimension(400, 450));
        setPreferredSize(new java.awt.Dimension(400, 450));
        getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("Cambria", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 255, 204));
        jLabel3.setText("INICIO");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(150, 180, 110, 43);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(110, 240, 80, 19);
        getContentPane().add(usuario);
        usuario.setBounds(220, 240, 93, 19);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(110, 280, 90, 19);
        getContentPane().add(contra);
        contra.setBounds(220, 280, 93, 19);

        ingresar.setText("Ingresar");
        ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarActionPerformed(evt);
            }
        });
        getContentPane().add(ingresar);
        ingresar.setBounds(150, 320, 90, 25);

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(150, 360, 90, 25);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contrasena.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(140, 30, 130, 130);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Abstract 38.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 500, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Login l=new Login();
        l.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarActionPerformed
        try {
            verificar();
        } catch (ParseException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_ingresarActionPerformed
    public void verificar() throws ParseException{
         JSONArray jarray=null;
        JSONParser parser = new JSONParser();
        try {
            Object obj=parser.parse(new FileReader("Administrador.json"));
            jarray=(JSONArray) obj;
            JSONObject o=(JSONObject) jarray.get(0);
            if(o.get("Usuario").equals(usuario.getText()) && o.get("Contraseña").equals(contra.getText())){
                Administrador root=new Administrador();
                root.setVisible(true);
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrecto");
                usuario.setText("");
                contra.setText("");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField contra;
    private javax.swing.JButton ingresar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}

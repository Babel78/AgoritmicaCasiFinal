package Interfaz;

import BD.MetodosPerfildeUsuario;
import BD.MetodosUsuarios;
import Clases.PerfildeUsuario;
import Clases.Usuario;
import javax.swing.JOptionPane;
import org.json.simple.parser.ParseException;


public class LoginUsuario extends javax.swing.JFrame {
  

    public LoginUsuario() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }
 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        contraseña = new javax.swing.JPasswordField();
        ingresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("USUARIO");
        setMinimumSize(new java.awt.Dimension(400, 400));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 100, 70, 17);

        jLabel2.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(100, 140, 90, 17);

        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });
        getContentPane().add(usuario);
        usuario.setBounds(210, 100, 120, 19);
        getContentPane().add(contraseña);
        contraseña.setBounds(210, 140, 120, 19);

        ingresar.setText("Ingresar");
        ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarActionPerformed(evt);
            }
        });
        getContentPane().add(ingresar);
        ingresar.setBounds(150, 190, 110, 25);

        jLabel3.setFont(new java.awt.Font("Cambria", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 255, 204));
        jLabel3.setText("INICIO");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(140, 30, 110, 43);

        jButton1.setText("Registrate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(150, 240, 110, 25);

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(150, 290, 110, 25);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Abstract 38.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 760, 420);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        
    }//GEN-LAST:event_usuarioActionPerformed

    private void ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarActionPerformed
        try {
            loguear();
        } catch (ParseException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_ingresarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Formulario f=new Formulario();
        f.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Login l=new Login();
        l.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
    public void loguear() throws ParseException{
        if(verificar()){
          MetodosUsuarios met=new MetodosUsuarios();
          Usuario nuevo=met.ObtenerUsuario(usuario.getText(), contraseña.getText());
          if(nuevo!=null){
            MetodosPerfildeUsuario mer=new MetodosPerfildeUsuario();
            PerfildeUsuario pdu=mer.ObtenerPerfil(nuevo);
            PerfilUsuario perfil=new PerfilUsuario(pdu);
            perfil.setVisible(true);
            dispose();
            }
            else{
            JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrecto");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
        }
        limpiar();
        
    }
    
    public boolean verificar(){
        boolean veri=false;
        if(!usuario.getText().equals("") && !contraseña.getText().equals("")){
            veri=true;
        }
        return veri;
    }
    
    public void limpiar(){
        usuario.setText("");
        contraseña.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField contraseña;
    private javax.swing.JButton ingresar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}

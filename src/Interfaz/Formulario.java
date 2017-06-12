package Interfaz;

import BD.MetodosPerfildeUsuario;
import BD.MetodosUsuarios;
import Clases.PerfildeUsuario;
import Clases.Usuario;
import javax.swing.JOptionPane;
import org.json.simple.parser.ParseException;

public class Formulario extends javax.swing.JFrame {
    public Formulario() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        telefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        nacimiento = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        registrar = new javax.swing.JButton();
        contra = new javax.swing.JPasswordField();
        Salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FORMULARIO");
        setPreferredSize(new java.awt.Dimension(600, 550));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Bienvenido");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        jLabel2.setText("Complete los siguientes campos");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel3.setText("Nombres y apellidos: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 220, -1));

        jLabel4.setText("Telefono:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));
        getContentPane().add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 220, -1));

        jLabel5.setText("Fecha de Nacimiento: (DD-MM-AA) ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));
        getContentPane().add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 220, -1));

        jLabel7.setText("Usuario:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, -1, -1));

        jLabel8.setText("DATOS PERSONALES");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 450, 20));

        jLabel9.setText("DATOS DE USUARIO");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 450, 20));

        nacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nacimientoActionPerformed(evt);
            }
        });
        getContentPane().add(nacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 220, -1));

        jLabel10.setText("Contraseña:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, -1, -1));

        registrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        registrar.setText("Registrar");
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });
        getContentPane().add(registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 120, -1));
        getContentPane().add(contra, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 220, -1));

        Salir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        getContentPane().add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 110, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        
    }//GEN-LAST:event_nombreActionPerformed

    private void nacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nacimientoActionPerformed
        
    }//GEN-LAST:event_nacimientoActionPerformed

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        try {
            registrar();
        } catch (ParseException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_registrarActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        dispose();
    }//GEN-LAST:event_SalirActionPerformed
    
    private void registrar() throws ParseException{
        Usuario nuevo=new Usuario();
        if(verificar()){
            nuevo.setNombre(nombre.getText());
            nuevo.setTelefono(telefono.getText());
            nuevo.setFecha_nac(nacimiento.getText());
            nuevo.setIdUsuario(usuario.getText());
            nuevo.setConstraseña(contra.getText());
            MetodosUsuarios usua=new MetodosUsuarios();
            MetodosPerfildeUsuario mpu=new MetodosPerfildeUsuario();
            usua.Guardar(nuevo);
            PerfildeUsuario perfil=new PerfildeUsuario(nuevo);
            mpu.Guardar(perfil);
            JOptionPane.showMessageDialog(null, "Registro completado con exito!");
        }
        else{
           JOptionPane.showMessageDialog(null, "Rellene todos los campos");
        }
        limpiar();
    }
    
    public boolean verificar(){
        boolean verifica=false;
        if(!nombre.getText().equals("") && !telefono.getText().equals("") && !nacimiento.getText().equals("") && !usuario.getText().equals("") && !contra.getText().equals("")){
           verifica=true; 
        }
        return verifica;
    }
    
    public void limpiar(){
        nombre.setText("");
        telefono.setText("");
        nacimiento.setText("");
        usuario.setText("");
        contra.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Salir;
    private javax.swing.JPasswordField contra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField nacimiento;
    private javax.swing.JTextField nombre;
    private javax.swing.JButton registrar;
    private javax.swing.JTextField telefono;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}

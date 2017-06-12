package Interfaz;

import BD.MetodosPaginas;
import Clases.ListaPaginas;
import Clases.NodoPagina;
import Clases.Pagina;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.json.simple.parser.ParseException;

public class AgregarPagina extends javax.swing.JFrame {
  MetodosPaginas metodos=new MetodosPaginas();
  ListaPaginas lista=new ListaPaginas();
  ArrayList<String> enlac=new ArrayList();
    public AgregarPagina() throws ParseException {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        inicial();
        AgregarCategorias();
        AgregarEnlaces();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nombrep = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        urlp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        categorias = new javax.swing.JComboBox<>();
        nuevac = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        catep = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        enlaces = new javax.swing.JComboBox<>();
        agregarE = new javax.swing.JButton();
        agregarP = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre:");

        jLabel2.setText("URL:");

        jLabel3.setText("Categoria:");

        nuevac.setText("Nueva Categoria");
        nuevac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevacActionPerformed(evt);
            }
        });

        jLabel4.setText("Categoria:");

        jLabel5.setText("Enlaces: ");

        agregarE.setText("Agregar Enlace");
        agregarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarEActionPerformed(evt);
            }
        });

        agregarP.setText("Agregar Pagina");
        agregarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPActionPerformed(evt);
            }
        });

        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(agregarP)
                .addGap(63, 63, 63))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(nombrep, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(urlp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(catep))
                            .addComponent(categorias, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel5)
                        .addGap(22, 22, 22)
                        .addComponent(enlaces, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(agregarE, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(nuevac)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nombrep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(urlp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(categorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(nuevac)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(catep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(enlaces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregarE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarP)
                    .addComponent(jButton4))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevacActionPerformed
        catep.setEditable(true);
        categorias.setEnabled(false);
    }//GEN-LAST:event_nuevacActionPerformed

    private void agregarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarPActionPerformed
        Pagina nueva=new Pagina();
        String careg;
        if(Verificar()){
            nueva.setNombrePag(nombrep.getText());
            nueva.setDirPag(urlp.getText());
                if(catep.isEditable()){
                   careg=catep.getText();
                
                }
                else{
                    careg=(String) categorias.getSelectedItem();
                }
            nueva.setCategoria(careg);
            NodoPagina nuevo=new NodoPagina(nueva); 
            for (int i = 0; i < enlac.size(); i++) {
                try {
                    NodoPagina aux=metodos.ObtenerPagina(enlac.get(i));
                    lista.AgregarPagina(aux.getPag());
                } catch (ParseException ex) {
                    System.out.println(ex);
                }
            }
            nuevo.setNodos(lista);
        try {
            metodos.Grabar(nuevo);
            JOptionPane.showMessageDialog(null, "Pagina guardada correctamente");
            limpiar();
            inicial();
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        }
        else{     
            JOptionPane.showMessageDialog(null, "Rellene todos los campos");
        }
    }//GEN-LAST:event_agregarPActionPerformed

    private void agregarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarEActionPerformed
        String enlace=(String) enlaces.getSelectedItem();
        enlac.add(enlace);
        JOptionPane.showMessageDialog(null, "Enlace "+enlace+" agregado");
    }//GEN-LAST:event_agregarEActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        AdministradorPaginas admin=new AdministradorPaginas();
        admin.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed
    public void inicial(){
        catep.setEditable(false);
    }
    
    public void AgregarCategorias() throws ParseException{
        ArrayList <NodoPagina> lis=metodos.ObtenerPaginas();
        ArrayList <String> aux=new ArrayList();
        int cont=0;
        for (int i = 0; i < lis.size(); i++) {
            NodoPagina get = lis.get(i);
            aux.add(get.getPag().getCategoria());
            if(i==0){
                categorias.addItem(get.getPag().getCategoria());
            }
            if(i>0){
                for (int j = 0; j < aux.size(); j++) {
                    if(aux.get(i).equals(categorias.getItemAt(j))){
                        cont++;
                    }
                }
                if(cont==0){
                    categorias.addItem(aux.get(i));
                }
                cont=0;
            }
        }
    }
    public void AgregarEnlaces() throws ParseException{
        ArrayList <NodoPagina> li=metodos.ObtenerPaginas();
        for (int i = 0; i < li.size(); i++) {
            NodoPagina get = li.get(i);
            enlaces.addItem(get.getPag().getNombrePag());
        }
    }
    public boolean Verificar(){
        boolean v=false;
        if(!nombrep.getText().equals("") && !urlp.getText().equals("")){
            if(nuevac.isSelected()){
               if(!catep.getText().equals("")){
                   v=true;
               } 
            }
            else{
                if(!categorias.getSelectedItem().equals("")){
                    v=true;
                }
            }  
        }
        
        return v;
    }
    public void limpiar(){
        nombrep.setText("");
        urlp.setText("");
        catep.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarE;
    private javax.swing.JButton agregarP;
    private javax.swing.JComboBox<String> categorias;
    private javax.swing.JTextField catep;
    private javax.swing.JComboBox<String> enlaces;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField nombrep;
    private javax.swing.JButton nuevac;
    private javax.swing.JTextField urlp;
    // End of variables declaration//GEN-END:variables
}

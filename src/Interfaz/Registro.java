
package Interfaz;

import BD.MetodosPaginas;
import Clases.PerfildeUsuario;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;


public class Registro extends javax.swing.JFrame {
    DefaultTableModel modelo;
    String cabecera[]={"fecha","Hora","Pagina","URL","Categoria"};
    String datos[][]={};
    PerfildeUsuario perfil;
    public Registro(PerfildeUsuario per) throws ParseException {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        perfil=per;
        modelo =new DefaultTableModel(datos, cabecera);
        registro.setModel(modelo);
        Datos(per);
        
    }
    public void Datos(PerfildeUsuario perfil) throws ParseException{
        MetodosPaginas metodos=new MetodosPaginas();
        JSONArray regi=metodos.ObtenerRegistro();
        Object Dat[][]=new Object[regi.size()][5];
        for (int i = 0; i < regi.size(); i++) {
            JSONObject obj=(JSONObject) regi.get(i);
            Object o[]={obj.get("Fecha"),obj.get("Hora"),obj.get("Pagina"),obj.get("URL"),obj.get("Categoria")};
            for (int j = 0; j < o.length; j++) {
                    Dat[i][j]= o[j];
            }
        }
        modelo.setDataVector(Dat, cabecera);
        ajustar();
    }
    public void ajustar(){
        TableColumnModel columnModel = registro.getColumnModel();
        columnModel.getColumn(3).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(90);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        registro = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel3.setText("REGISTRO");

        registro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(registro);

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable registro;
    // End of variables declaration//GEN-END:variables
}

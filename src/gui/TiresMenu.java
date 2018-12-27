/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import data_access.ComponenteDAO;
import business.BuildMovil;
import business.Componente;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author hasvm
 */
public final class TiresMenu extends javax.swing.JFrame {
    
    public static Map<Integer,Componente> cps;
    public static List<Integer> v = new ArrayList();
    public static int last;
    /**
     * Creates new form Color
     */
    public TiresMenu() {
        initComponents();
        getTires();
        showTires();
    }
    
    private void getTires(){
      ComponenteDAO dao = new ComponenteDAO();
        
        try {
            cps = dao.valuesTipo2(3);
        } catch (Exception ex) {
            Logger.getLogger(ColorMenu.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    private void showTires(){
        
        Componente cca;
        Set<Integer> aux = cps.keySet();
        DefaultTableModel model = (DefaultTableModel)jtiremenu.getModel();
        Object[] row = new Object[5];
        for(int c : aux){
            cca = cps.get(c);
            row[0]=cca.getCod();
            row[1]=cca.getNome();
            row[2]=cca.getDesc();
            row[3]=cca.getPreco();
            row[4]=cca.getRating();
            model.addRow(row);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtiremenu = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Color");

        jtiremenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod", "Nome", "Descrição", "Preço", "Rating"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtiremenu);

        jButton1.setText("Select");
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
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jButton1)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(jButton1)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try {
            // TODO add your handling code here:
            DefaultTableModel model = (DefaultTableModel)jtiremenu.getModel();
            int s = jtiremenu.getSelectedRow();
            List<String> va;
            v = new ArrayList();
            Componente ci;
            ci = cps.get(Integer.valueOf((String) model.getValueAt(s,0).toString()));
            BuildMovil bm = new BuildMovil();
            va = bm.addComp(ci,CustomConfiguration.p);
            
            if(CustomConfiguration.p.getConf().containsKey(ci.getCod())){
                Exist ex = new Exist();
                dispose();
            }
            for(String r : va){
                if (r.endsWith("i")) {
                    r = r.substring(0, r.length() - 1);
                    v.add(Integer.valueOf((String) r));
                }
            }
            if(v!=null) {  
                Incomp in = new Incomp();
                in.setVisible(true);
            }
            if(last==0){
                dispose();
            }
            CustomConfiguration.p.addComp(ci);
            CustomConfiguration.dm.addElement(model.getValueAt(s,1).toString());
            CustomConfiguration.jList2.setModel(CustomConfiguration.dm);
            
        } catch (Exception ex) {
            Logger.getLogger(TiresMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TiresMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TiresMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TiresMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TiresMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TiresMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jtiremenu;
    // End of variables declaration//GEN-END:variables
}

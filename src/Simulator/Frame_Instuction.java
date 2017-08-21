/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulator;
import java.awt.Toolkit;
/**
 *
 * @author MY
 */
public class Frame_Instuction extends javax.swing.JFrame {

    /**
     * Creates new form Frame_Instuction
     */
    public Frame_Instuction() {
        initComponents();
        Toolkit tk=Toolkit.getDefaultToolkit();
        this.setIconImage(tk.createImage(getClass().getResource("resources/icon.png")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        helpList = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        helpArea = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        helpList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        helpList.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        helpList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "What is 8085 Simulator ?", "A Quick Tour", "Getting Started", "How To Execute ?", "Sample Programs" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        helpList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        helpList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                helpListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(helpList);

        helpArea.setBorder(new javax.swing.border.MatteBorder(null));
        jScrollPane3.setViewportView(helpArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 280, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void helpListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpListMouseClicked
     //  helpList.getSelectedIndex();
         try {
      switch (this.helpList.getSelectedIndex()) { case 0:
        this.helpArea.setPage(getClass().getResource("/Simulator/html/0.html")); break;
      case 1:
        this.helpArea.setPage(getClass().getResource("/Simulator/html/4.html")); break;
      case 2:
        this.helpArea.setPage(getClass().getResource("/Simulator/html/1.html")); break;
      case 3:
        this.helpArea.setPage(getClass().getResource("/Simulator/html/2.html")); break;
      case 4:
        this.helpArea.setPage(getClass().getResource("/Simulator/html/5.html")); break;
    
      }
    }
    catch (Exception e)
    {
    }
    }//GEN-LAST:event_helpListMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame_Instuction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_Instuction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_Instuction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_Instuction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Frame_Instuction().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane helpArea;
    private javax.swing.JList helpList;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
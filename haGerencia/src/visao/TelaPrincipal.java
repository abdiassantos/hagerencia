/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modeloConnection.ConexaoBD;

/**
 *
 * @author abdiassantos
 */
public class TelaPrincipal extends javax.swing.JFrame {

    ConexaoBD con = new ConexaoBD();
    
    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        con.conecta();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonClientePrincipal = new javax.swing.JButton();
        jButtonProdutoPrincipal = new javax.swing.JButton();
        jButtonRelatorioPrincipal = new javax.swing.JButton();
        jLabelBemVindoPrincipal = new javax.swing.JLabel();
        jButtonLogoutPrincipal = new javax.swing.JButton();
        jButtonFacebook = new javax.swing.JButton();
        jButtonInstagram = new javax.swing.JButton();
        jLabelFundoPrincipal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("HA Gerencia");
        getContentPane().setLayout(null);

        jButtonClientePrincipal.setBackground(javax.swing.UIManager.getDefaults().getColor("Nb.ScrollPane.Border.color"));
        jButtonClientePrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cliente.png"))); // NOI18N
        jButtonClientePrincipal.setToolTipText("Abrir Clientes");
        jButtonClientePrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClientePrincipalActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonClientePrincipal);
        jButtonClientePrincipal.setBounds(20, 80, 100, 100);

        jButtonProdutoPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/produto.png"))); // NOI18N
        jButtonProdutoPrincipal.setToolTipText("Abrir Produtos");
        jButtonProdutoPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProdutoPrincipalActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonProdutoPrincipal);
        jButtonProdutoPrincipal.setBounds(140, 80, 100, 100);

        jButtonRelatorioPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/relatorio_1.png"))); // NOI18N
        jButtonRelatorioPrincipal.setToolTipText("Gerar Relatórios");
        jButtonRelatorioPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRelatorioPrincipalActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRelatorioPrincipal);
        jButtonRelatorioPrincipal.setBounds(260, 80, 100, 100);

        jLabelBemVindoPrincipal.setFont(new java.awt.Font("NanumMyeongjo", 1, 14)); // NOI18N
        jLabelBemVindoPrincipal.setText("Seja Bem Vindo,");
        getContentPane().add(jLabelBemVindoPrincipal);
        jLabelBemVindoPrincipal.setBounds(40, 30, 120, 17);

        jButtonLogoutPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        jButtonLogoutPrincipal.setToolTipText("Realizar Logout (Deslogar)");
        jButtonLogoutPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutPrincipalActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLogoutPrincipal);
        jButtonLogoutPrincipal.setBounds(320, 10, 40, 40);

        jButtonFacebook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/facebook.png"))); // NOI18N
        jButtonFacebook.setToolTipText("Abrir Facebook");
        jButtonFacebook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFacebookActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonFacebook);
        jButtonFacebook.setBounds(270, 10, 40, 40);

        jButtonInstagram.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/instagram.png"))); // NOI18N
        jButtonInstagram.setToolTipText("Abrir Instagram");
        jButtonInstagram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInstagramActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonInstagram);
        jButtonInstagram.setBounds(220, 10, 40, 40);

        jLabelFundoPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fundo_com_degrade.jpeg"))); // NOI18N
        getContentPane().add(jLabelFundoPrincipal);
        jLabelFundoPrincipal.setBounds(0, 0, 440, 200);

        setSize(new java.awt.Dimension(381, 225));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonProdutoPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProdutoPrincipalActionPerformed
        TelaEstoque telaEstoque = new TelaEstoque();
        
        telaEstoque.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonProdutoPrincipalActionPerformed

    private void jButtonLogoutPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutPrincipalActionPerformed
        TelaLogin telaLoginObject = new TelaLogin();
        
        this.dispose();
        telaLoginObject.setVisible(true);
    }//GEN-LAST:event_jButtonLogoutPrincipalActionPerformed

    private void jButtonClientePrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClientePrincipalActionPerformed
        TelaCliente telaClienteObject = new TelaCliente();
        
        this.dispose();
        telaClienteObject.setVisible(true);
    }//GEN-LAST:event_jButtonClientePrincipalActionPerformed

    private void jButtonRelatorioPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRelatorioPrincipalActionPerformed
            JOptionPane.showMessageDialog(rootPane, "EM BREVE!");
    }//GEN-LAST:event_jButtonRelatorioPrincipalActionPerformed

    private void jButtonFacebookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFacebookActionPerformed
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Desejas Abrir o Navegador?");
        
        if(resposta == JOptionPane.YES_OPTION){
            try {
                java.awt.Desktop.getDesktop().browse( new java.net.URI( "https://www.facebook.com/fiodepratamix" ) );
            } catch (URISyntaxException | IOException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonFacebookActionPerformed

    private void jButtonInstagramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInstagramActionPerformed
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Desejas Abrir o Navegador?");
        
        if(resposta == JOptionPane.YES_OPTION){
            try {
                java.awt.Desktop.getDesktop().browse( new java.net.URI( "https://www.instagram.com/fiodeprata.oeiras/" ) );
            } catch (URISyntaxException | IOException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonInstagramActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TelaPrincipal().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClientePrincipal;
    private javax.swing.JButton jButtonFacebook;
    private javax.swing.JButton jButtonInstagram;
    private javax.swing.JButton jButtonLogoutPrincipal;
    private javax.swing.JButton jButtonProdutoPrincipal;
    private javax.swing.JButton jButtonRelatorioPrincipal;
    private javax.swing.JLabel jLabelBemVindoPrincipal;
    private javax.swing.JLabel jLabelFundoPrincipal;
    // End of variables declaration//GEN-END:variables

}

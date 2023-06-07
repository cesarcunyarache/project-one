/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frame;

import BusinessObject.Cliente;
import TransferObject.ClienteDTO;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author cesarcunyarache
 */
public class Frm_Correos extends javax.swing.JPanel {

    JFileChooser fc = new JFileChooser();
    Cliente ctr;
    String destino = "";
    DefaultComboBoxModel modelo;
    Vector<ClienteDTO> clientes;
    //String[] correo = {"lualcosers@ucvvirtual.edu.pe", "cesarcunyarachecastilo@gmail.com", "ccunyaracheca@ucvvirtual.edu.pe"};

    private String emailFrom = "fagexperu14@gmail.com";
    private String passwordFrom = "orutlqgnevisppfk";
    private String emailTo;
    private String subject;
    private String content;


    private Properties mProperties;
    private Session mSession;
    private MimeMessage mCorreo;

    public Frm_Correos(JFrame frame) {
        initComponents();
        mProperties = new Properties();
        ctr = new Cliente(frame);
        clientes = ctr.MostrarCorreos();
        modelo = new DefaultComboBoxModel(clientes);
        cbo_correo.setModel(modelo);
    }

    private void createEmail() {
        try {
//            emailTo = txtTo.getText().trim();
            subject = txtSubject.getText().trim();
            content = txtContent.getText().trim();

            // Simple mail transfer protocol
            mProperties.put("mail.smtp.host", "smtp.gmail.com");
            mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            mProperties.setProperty("mail.smtp.starttls.enable", "true");
            mProperties.setProperty("mail.smtp.port", "587");
            mProperties.setProperty("mail.smtp.user", emailFrom);
            mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
            mProperties.setProperty("mail.smtp.auth", "true");

            mSession = Session.getDefaultInstance(mProperties);
            BodyPart adjunto = new MimeBodyPart();
           

            MimeMultipart m = new MimeMultipart();
            if (!destino.equals("")){
            adjunto.setDataHandler(new DataHandler(new FileDataSource(destino)));
            adjunto.setFileName(fc.getSelectedFile().getPath());
            m.addBodyPart(adjunto);
            }

            try {
                mCorreo = new MimeMessage(mSession);
                mCorreo.setFrom(new InternetAddress(emailFrom));
                if (check.isSelected()) {
                    for (ClienteDTO cli : clientes) {
                        mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(cli.getCorreo()));
                        System.out.println(cli.getCorreo());
                        mCorreo.setSubject(subject);
                        mCorreo.setText(content, "ISO-8859-1", "html");
                        if (destino ==null) {
                            mCorreo.setContent(m);
                        }
                        sendEmail();
                    }
                } else {
                    ClienteDTO c = (ClienteDTO) cbo_correo.getSelectedItem();
                    mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(c.getCorreo()));
                    System.out.println(c.getCorreo());
                    mCorreo.setSubject(subject);
                    mCorreo.setText(content, "ISO-8859-1", "html");
                    if(!destino.equals("")){
                         mCorreo.setContent(m);
                    }
                   
                    sendEmail();
                }

            } catch (AddressException ex) {
                System.out.println(ex);
            } catch (MessagingException ex) {
                Logger.getLogger(Frm_Correos.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex);
            }
        } catch (MessagingException ex) {
            Logger.getLogger(Frm_Correos.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }

    private void sendEmail() {
        try {
            Transport mTransport = mSession.getTransport("smtp");
            mTransport.connect(emailFrom, passwordFrom);
            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
            mTransport.close();

            System.out.println("Correo enviado");
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(Frm_Correos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Frm_Correos.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        txtSubject = new Components.TextField();
        jLabel1 = new javax.swing.JLabel();
        buttonShadow1 = new Components.ButtonShadow();
        buttonShadow2 = new Components.ButtonShadow();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtContent = new javax.swing.JTextArea();
        check = new Components.JCheckBoxCustom();
        cbo_correo = new Components.ComboBoxSuggestion();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSubject.setLabelText("Asunto");
        jPanel1.add(txtSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 390, 50));

        jLabel1.setText("Contenido");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, -1, -1));

        buttonShadow1.setText("📁");
        buttonShadow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonShadow1ActionPerformed(evt);
            }
        });
        jPanel1.add(buttonShadow1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 460, -1, -1));

        buttonShadow2.setText("Enviar correo");
        buttonShadow2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonShadow2ActionPerformed(evt);
            }
        });
        jPanel1.add(buttonShadow2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 520, 150, -1));

        txtContent.setColumns(20);
        txtContent.setRows(5);
        jScrollPane3.setViewportView(txtContent);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 380, 230));

        check.setText("Enviar a todos");
        jPanel1.add(check, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, -1, -1));

        cbo_correo.setToolTipText("");
        jPanel1.add(cbo_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 390, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1044, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonShadow2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonShadow2ActionPerformed
        createEmail();
    }//GEN-LAST:event_buttonShadow2ActionPerformed

    private void buttonShadow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonShadow1ActionPerformed
        int seleccion = fc.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            try {
                
                    destino = fc.getSelectedFile().getPath();
//                     fc.setSelectedFile(new File("Boleta de pago"));
                
                
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }//GEN-LAST:event_buttonShadow1ActionPerformed

    public void iniciar (){
        clientes = ctr.MostrarCorreos();
        modelo = new DefaultComboBoxModel(clientes);
        cbo_correo.setModel(modelo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.ButtonShadow buttonShadow1;
    private Components.ButtonShadow buttonShadow2;
    private Components.ComboBoxSuggestion cbo_correo;
    private Components.JCheckBoxCustom check;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txtContent;
    private Components.TextField txtSubject;
    // End of variables declaration//GEN-END:variables
}

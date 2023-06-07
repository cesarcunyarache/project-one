package Frame;

import BusinessObject.Empleados;
import BusinessObject.Usuario;
import DataAccessObject.UsuariosDAO;
import Frame.Frm_Panel;
import TransferObject.Encriptacion;
import TransferObject.UsuariosDTO;
import Frame.Frm_PanelCover;
import Frame.Frm_PanelLoginAndRegister;
import Notification.Notification;
import TransferObject.EmpleadoDTO;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Frm_Login extends javax.swing.JFrame {

    private final DecimalFormat df = new DecimalFormat("##0.###", DecimalFormatSymbols.getInstance(Locale.US));
    private MigLayout layout;
    private Frm_PanelCover cover;
    private Frm_PanelLoginAndRegister loginAndRegister;
    private boolean isLogin = true;
    private final double addSize = 30;
    private final double coverSize = 40;
    private final double loginSize = 60;

    UsuariosDTO usuario;
    Encriptacion encripatar;
    UsuariosDAO c ;
    Empleados ctr;
    Usuario ctr1 ;
    Frm_Panel p;
    Notification mensaje;
    Notification mensajeError;

    public Frm_Login() {

        initComponents();
        init();
//        this.setExtendedState(this.MAXIMIZED_BOTH);
        c = new UsuariosDAO();
        ctr = new Empleados(this);
        ctr1 = new Usuario(this);
        
        setBackground(new Color(0, 0, 0, 0));
    }

    private void init() {
        layout = new MigLayout("fill, insets 0");
        cover = new Frm_PanelCover();
//        mensaje = new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT);
//        mensajeError = new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_RIGHT);
        loginAndRegister = new Frm_PanelLoginAndRegister();
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double fractionCover;
                double fractionLogin;
                double size = coverSize;
                if (fraction <= 0.5f) {
                    size += fraction * addSize;
                } else {
                    size += addSize - fraction * addSize;
                }
                if (isLogin) {
                    fractionCover = 1f - fraction;
                    fractionLogin = fraction;
                    if (fraction >= 0.5f) {
                        cover.registerRight(fractionCover * 100);
                    } else {
                        cover.loginRight(fractionLogin * 100);
                    }
                } else {
                    fractionCover = fraction;
                    fractionLogin = 1f - fraction;
                    if (fraction <= 0.5f) {
                        cover.registerLeft(fraction * 100);
                    } else {
                        cover.loginLeft((1f - fraction) * 100);
                    }
                }
                if (fraction >= 0.5f) {
                    loginAndRegister.showRegister(isLogin);
                }
                fractionCover = Double.valueOf(df.format(fractionCover));
                fractionLogin = Double.valueOf(df.format(fractionLogin));
                layout.setComponentConstraints(cover, "width " + size + "%, pos " + fractionCover + "al 0 n 100%");
                layout.setComponentConstraints(loginAndRegister, "width " + loginSize + "%, pos " + fractionLogin + "al 0 n 100%");
                bg.revalidate();
            }

            @Override
            public void end() {
                isLogin = !isLogin;
            }
        };
        Animator animator = new Animator(800, target);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0);  //  for smooth animation
        bg.setLayout(layout);
        bg.add(cover, "width " + coverSize + "%, pos " + (isLogin ? "1al" : "0al") + " 0 n 100%");
        bg.add(loginAndRegister, "width " + loginSize + "%, pos " + (isLogin ? "0al" : "1al") + " 0 n 100%"); //  1al as 100%
        loginAndRegister.addEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!loginAndRegister.txtEmail1.getText().isEmpty()
                        && !loginAndRegister.txtPass1.getText().isEmpty()) {

                    String email = loginAndRegister.txtEmail1.getText();
                    String pass = loginAndRegister.txtPass1.getText();
                    if (ctr1.ValidarUsuario(email, pass)) {
//                        mensaje = new Notification("Informacion valida!", Main.getFrames()[0],
//                                Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT);
                           p = new Frm_Panel(ctr1.Buscar(email));
                           p.setVisible(true);
                        

                    } else {
                        mensajeError = new Notification("Informacion invalida", Frm_Login.getFrames()[0], Notification.Type.WARNING, Notification.Location.TOP_RIGHT);
                    }
                } else {
                    mensajeError = new Notification("Uno o más campos vacios", Frm_Login.getFrames()[0], Notification.Type.WARNING, Notification.Location.TOP_RIGHT);
                }
            }
        });

        loginAndRegister.addEvent2(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!loginAndRegister.txtDni.getText().isEmpty()
                        && !loginAndRegister.txtNombre.getText().isEmpty()
                        && !loginAndRegister.txtApellidos.getText().isEmpty()
                        && !loginAndRegister.txtEmail.getText().isEmpty()
                        && !loginAndRegister.txtPass.getText().isEmpty()
                        && !loginAndRegister.txtPass2.getText().isEmpty()) {

                    String dni = loginAndRegister.txtDni.getText();
                    String nombre = loginAndRegister.txtNombre.getText();
                    String apellidos = loginAndRegister.txtApellidos.getText();

                    ctr.insertar(null, null, dni, nombre, apellidos, "", "", "");
                    EmpleadoDTO emp = ctr.Buscar(dni);
                    
                    if (emp != null) {
                        String email = loginAndRegister.txtEmail.getText();
                        String pass = loginAndRegister.txtPass.getText();
                        String pass2 = loginAndRegister.txtPass2.getText();
                        
                        if (pass.equals(pass2)){
                            encripatar = new Encriptacion();
                            pass = encripatar.ecnode(loginAndRegister.txtPass.getText());
                            ctr1.insertar(email, pass, "Personal", emp.getId());
                            
                        } else {
                             mensajeError = new Notification("Las constraseñas no coinciden", Frm_Login.getFrames()[0],
                                Notification.Type.WARNING, Notification.Location.TOP_RIGHT);
                        }
                         
                    }
//                    if (c.Create(usuario)) {
//                         mensaje = new Notification("Perfil creado correctamente", Main.getFrames()[0],
//                                Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT);
//                       
//                    } else {
//                        mensajeError = new Notification("Informacion invalida", Main.getFrames()[0],
//                                Notification.Type.WARNING, Notification.Location.TOP_RIGHT);
//                    }
                } else {
                    mensajeError = new Notification("Uno o más campos vacios", Frm_Login.getFrames()[0],
                            Notification.Type.WARNING, Notification.Location.TOP_RIGHT);
                }

                //programar crear
            }
        });
        loginAndRegister.showRegister(!isLogin);
        cover.login(isLogin);
        cover.addEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();

                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setForeground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 933, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 537, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(Frm_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}

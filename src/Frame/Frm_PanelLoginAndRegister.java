package Frame;

import Components.Button;
import Components.MyPasswordField;
import Components.MyTextField;
import Notification.Notification;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import net.miginfocom.swing.MigLayout;

public class Frm_PanelLoginAndRegister extends javax.swing.JLayeredPane {

    
    
    ActionListener event;
    ActionListener event2;
    public MyTextField txtUser;
    public MyTextField txtNombre;
    public MyTextField txtApellidos;
    public MyTextField txtDni;
    public MyTextField txtEmail;
    public MyPasswordField txtPass;
    public MyTextField txtEmail1;
    public MyPasswordField txtPass1;
    public MyPasswordField txtPass2;
    
    public Frm_PanelLoginAndRegister() {
        initComponents();
        initRegister();
        initLogin();
        //login.setVisible(false);
        register.setVisible(true);

    }

    public void initRegister() {
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]10[]10[]10[]25[]push"));

        JLabel label = new JLabel("Crear cuenta");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(77, 77, 77 ));
        register.add(label);

        txtDni = new MyTextField();
        txtDni.setPrefixIcon(new ImageIcon(getClass().getResource("/Image/documento.png")));
        txtDni.setHint("DNI");
        register.add(txtDni, "w 60%");
        
        txtNombre = new MyTextField();
        txtNombre.setPrefixIcon(new ImageIcon(getClass().getResource("/Image/user.png")));
        txtNombre.setHint("Nombres");
        register.add(txtNombre, "w 60%");
        
        txtApellidos = new MyTextField();
        txtApellidos.setPrefixIcon(new ImageIcon(getClass().getResource("/Image/user.png")));
        txtApellidos.setHint("Apellidos");
        register.add(txtApellidos, "w 60%");
        
//        txtUser = new MyTextField();
//        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/Image/user.png")));
//        txtUser.setHint("Email");
//        register.add(txtUser, "w 60%");

        txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/Image/agregar.png")));
        txtEmail.setHint("Usuario");
        register.add(txtEmail, "w 60%");

        txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/Image/pass.png")));
        txtPass.setHint("Contraseña");
        register.add(txtPass, "w 60%");
        
        
        txtPass2 = new MyPasswordField();
        txtPass2.setPrefixIcon(new ImageIcon(getClass().getResource("/Image/pass.png")));
        txtPass2.setHint("Repetir contraseña");
        register.add(txtPass2, "w 60%");

        Button cmd = new Button();
        cmd.setBackground(new Color(77, 77, 77));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("Registrarse");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              event2.actionPerformed(e);
                  
            }
        });
        register.add(cmd, "w 40%, h 40");
    }

    private void initLogin() {
        
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Login");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(77, 77, 77 ));
        login.add(label);
        
         txtEmail1 = new MyTextField();
        txtEmail1.setPrefixIcon(new ImageIcon(getClass().getResource("/Image/user.png")));
        txtEmail1.setHint("Usuario");
        login.add(txtEmail1, "w 60%");
        
         txtPass1 = new MyPasswordField();
        txtPass1.setPrefixIcon(new ImageIcon(getClass().getResource("/Image/pass.png")));
        txtPass1.setHint("Password");
        login.add(txtPass1, "w 60%");
        
        JButton cmdForget = new JButton(""); // Forgot your password ?
        cmdForget.setForeground(new Color(100, 100, 100));
        cmdForget.setFont(new Font("sansserif", 1, 12));
        cmdForget.setContentAreaFilled(false);
        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.add(cmdForget);
         
        
        
        
        Button cmd = new Button();
        cmd.setBackground(new Color(77, 77, 77 ));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("Iniciar sesión");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              event.actionPerformed(e);
                  
            }
        });
        login.add(cmd, "w 40%, h 40");
    }

    public void showRegister(boolean show) {
        if (show) {
            register.setVisible(true);
            login.setVisible(false);
        } else {
            register.setVisible(false);
            login.setVisible(true);
        }
    }
    
    public void addEvent(ActionListener event) {
        this.event = event;
    }
    
    public void addEvent2(ActionListener event) {
        this.event2 = event;
    }

    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));
        login.setOpaque(false);

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 715, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 447, Short.MAX_VALUE)
        );

        add(login, "card3");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 715, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 447, Short.MAX_VALUE)
        );

        add(register, "card2");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}

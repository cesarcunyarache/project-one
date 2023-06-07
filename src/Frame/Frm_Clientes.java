package Frame;

import DataAccessObject.ClientesDAO;
import TransferObject.ClienteDTO;
import BusinessObject.Cliente;
import Components.EventCallBack;
import Components.EventTextField;
import JTable.EventAction;
import JTable.ModelAction;
import Message.Message;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import JTable.Table;
import Notification.Notification;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cesarcunyarache
 */
public class Frm_Clientes extends javax.swing.JPanel {

    ClienteDTO cliente;
    ClientesDAO crud = new ClientesDAO();
    Cliente ctr;
    EventAction eventAction;
    JFrame frame;
    DefaultTableModel df;
    Notification mensaje;
    Notification mensajeError;
    ArrayList<ClienteDTO> lista;

    public Frm_Clientes(JFrame frame) {
        ctr = new Cliente(frame);
        lista = ctr.listar();
        this.frame = frame;
        initComponents();
        table1.fixTable(jScrollPane1);

        df = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 8) {
                    return true;
                }
                if (column == 9) {
                    return false;
                }

                return false;

            }
        };

        init();

        txt_busqueda.addEvent(new EventTextField() {
            @Override
            public void onPressed(EventCallBack call) {
                //  Test
                try {
                    for (int i = 1; i <= 100; i++) {
                        Thread.sleep(5);
                    }
                    lista = ctr.BusquedaInteligente(txt_busqueda.getText());
                    init();
                    call.done();
                } catch (Exception e) {

                }
            }

            @Override
            public void onCancel() {

            }
        });

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_dni = new Components.TextField();
        txt_nombres = new Components.TextField();
        txt_apellidos = new Components.TextField();
        txt_telefono = new Components.TextField();
        cbo_sexo = new Components.Combobox();
        btn_actualizar = new Components.ButtonShadow();
        btn_agregar = new Components.ButtonShadow();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new JTable.Table();
        txt_correo = new Components.TextField();
        txt_direccion = new Components.TextField();
        txt_ruc = new Components.TextField();
        btn_reset = new Components.ButtonShadow();
        txt_busqueda = new Components.TextFieldAnimation();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_dni.setLabelText("DNI");
        jPanel1.add(txt_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 280, -1));

        txt_nombres.setLabelText("Nombres");
        jPanel1.add(txt_nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 280, -1));

        txt_apellidos.setLabelText("Apellidos");
        jPanel1.add(txt_apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 280, -1));

        txt_telefono.setLabelText("Telefono");
        jPanel1.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 280, -1));

        cbo_sexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Femenino" }));
        cbo_sexo.setSelectedIndex(-1);
        cbo_sexo.setFocusable(false);
        cbo_sexo.setLabeText("Género");
        cbo_sexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_sexoActionPerformed(evt);
            }
        });
        jPanel1.add(cbo_sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 280, -1));

        btn_actualizar.setBackground(new java.awt.Color(0, 153, 0));
        btn_actualizar.setForeground(new java.awt.Color(255, 255, 255));
        btn_actualizar.setText("✓");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 390, 40, 40));

        btn_agregar.setBackground(new java.awt.Color(51, 51, 51));
        btn_agregar.setForeground(new java.awt.Color(255, 255, 255));
        btn_agregar.setText("Agregar");
        btn_agregar.setRound(20);
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, 110, -1));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 1080, 200));

        txt_correo.setLabelText("Correo electronico");
        jPanel1.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 280, -1));

        txt_direccion.setLabelText("Dirección");
        jPanel1.add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 280, -1));

        txt_ruc.setLabelText("RUC");
        jPanel1.add(txt_ruc, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 280, -1));

        btn_reset.setForeground(new java.awt.Color(255, 255, 255));
        btn_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/actualizar.png"))); // NOI18N
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });
        jPanel1.add(btn_reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, 40, 40));
        jPanel1.add(txt_busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 40, 270, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        if (!txt_dni.getText().isEmpty()
                && !txt_nombres.getText().isEmpty()
                && !cbo_sexo.getSelectedItem().equals("Género")
                && !txt_correo.getText().isEmpty()
                && !txt_telefono.getText().isEmpty()) {

            ctr.Modificar(txt_dni.getText(), txt_nombres.getText(), txt_apellidos.getText(), (String) cbo_sexo.getSelectedItem(), txt_telefono.getText(), txt_correo.getText(), txt_direccion.getText(), txt_ruc.getText());
            limpiar();
            lista = ctr.listar();
            init();
        } else {
            mensajeError = new Notification("Algo salio mal",
                    frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT);
        }


    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        if (!txt_dni.getText().isEmpty()
                && !txt_nombres.getText().isEmpty()
                && !cbo_sexo.getSelectedItem().equals("Género")
                && !txt_correo.getText().isEmpty()
                && !txt_telefono.getText().isEmpty()) {

            ctr.insertar(txt_dni.getText(), txt_nombres.getText(), txt_apellidos.getText(), (String) cbo_sexo.getSelectedItem(), txt_telefono.getText(), txt_correo.getText(), txt_direccion.getText(), txt_ruc.getText());
            lista = ctr.listar();
            limpiar();
            init();
        } else {
            mensajeError = new Notification("Algo salio mal",
                    frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT);
        }
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        limpiar();
        lista = ctr.listar();
        init();

    }//GEN-LAST:event_btn_resetActionPerformed

    private void cbo_sexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_sexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_sexoActionPerformed

    public void init() {

        eventAction = new EventAction<ClienteDTO>() {
            @Override
            public void delete(ClienteDTO ca) {
                if (showMessage("Eliminar Cliente : " + ca.getNombres())) {

                    String id = String.valueOf(table1.getValueAt(table1.getSelectedRow(), 0));
                    ctr.Eliminar(id);
                    lista = ctr.listar();
                    llenarTabla(eventAction);

                    System.out.println("User click OK");
                } else {
                    System.out.println("User click Cancel");
                }
            }

            @Override
            public void update(ClienteDTO ca) {
                if (showMessage("Actualizar Cliente : " + ca.getNombres())) {

                    String id = String.valueOf(table1.getValueAt(table1.getSelectedRow(), 0));

                    ClienteDTO cl = ctr.Buscar(id);

                    if (cl != null) {
                        try {
                            txt_dni.setText(cl.getDni());
                            txt_nombres.setText(cl.getNombres());
                            txt_apellidos.setText(cl.getApellidos());
                            txt_telefono.setText(cl.getTelefono());
                            cbo_sexo.setSelectedItem(cl.getGenero());
                            txt_correo.setText(cl.getCorreo());
                            txt_direccion.setText(cl.getDireccion());
                            txt_ruc.setText(cl.getRuc());
                            System.out.println("User click OK");
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    } else {

                    }

                } else {
                    System.out.println("User click Cancel");
                }
            }
        };

        llenarTabla(eventAction);
    }

    public void llenarTabla(EventAction eventAction) {

        df.setColumnCount(0);
        df.setRowCount(0);

        String[] cabezera = {"DNI", "Nombres", "Apellidos", "Telefono", "Género", "Correo", "Dirección", "RUC ", "Accion"};
        df.setColumnIdentifiers(cabezera);
        ModelAction model;
        Object[] datos = new Object[df.getColumnCount()];

//        ArrayList<ClienteDTO> lista = new ArrayList<>();
//        lista = crud.Read();
        if (lista != null) {

            for (int i = 0; i < lista.size(); i++) {
                ClienteDTO c = lista.get(i);

                datos[0] = c.getDni();
                datos[1] = c.getNombres();
                datos[2] = c.getApellidos();
                datos[3] = c.getTelefono();
                datos[4] = c.getGenero();
                datos[5] = c.getCorreo();
                datos[6] = c.getDireccion();
                datos[7] = c.getRuc();
                datos[8] = model = new ModelAction<ClienteDTO>(c, eventAction);

                df.addRow(datos);
            }

            table1.setModel(df);

        }
    }

    private boolean showMessage(String message) {
        Message obj = new Message(frame, true);
        obj.showMessage(message);
        return obj.isOk();
    }

    public void limpiar() {
        txt_dni.setText("");
        txt_nombres.setText("");
        txt_apellidos.setText("");
        txt_correo.setText("");
        txt_telefono.setText("");
        txt_direccion.setText("");
        txt_ruc.setText("");
        cbo_sexo.setSelectedIndex(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.ButtonShadow btn_actualizar;
    private Components.ButtonShadow btn_agregar;
    private Components.ButtonShadow btn_reset;
    private Components.Combobox cbo_sexo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private JTable.Table table1;
    private Components.TextField txt_apellidos;
    private Components.TextFieldAnimation txt_busqueda;
    private Components.TextField txt_correo;
    private Components.TextField txt_direccion;
    private Components.TextField txt_dni;
    private Components.TextField txt_nombres;
    private Components.TextField txt_ruc;
    private Components.TextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}

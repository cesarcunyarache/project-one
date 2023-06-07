package Frame;

import BusinessObject.Categoria;
import BusinessObject.Cliente;
import BusinessObject.Detalle;
import BusinessObject.Ventas;
import DataAccessObject.ClientesDAO;
import DataAccessObject.ProductosDAO;
import JTable.ModelAction;
import Notification.Notification;
import TransferObject.CategoriaDTO;
import TransferObject.ClienteDTO;
import TransferObject.ItemDTO;
import TransferObject.DetalleDTO;
import TransferObject.List;
import TransferObject.ProductoDTO;
import TransferObject.UsuariosDTO;
import TransferObject.VentaDTO;
import datechooser.DateChooser;
import datechooser.EventDateChooser;
import datechooser.SelectedAction;
import datechooser.SelectedDate;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.*;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactoryImp;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileOutputStream;

/**
 *
 * @author cesarcunyarache
 */
public class Frm_Ventas extends javax.swing.JPanel {

    JFileChooser fc = new JFileChooser();
    ProductosDAO prod = new ProductosDAO();
    ClientesDAO crud = new ClientesDAO();
    List lista;
    ClienteDTO cliente;
    Cliente ctr_c;
    boolean isClient = false;
    DefaultComboBoxModel modeloCategoria;
    Categoria ca;
    ProductosDAO pr = new ProductosDAO();
    DefaultTableModel df = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
              return false;
        }
    };
    JFrame frame;
    ItemDTO articulo;
    DateChooser dateChooser = new DateChooser();
    DefaultComboBoxModel modeloProductos;
    Ventas ctr;
    Detalle ctr_d;
    Vector<ProductoDTO> pro;
    private Notification mensaje;
    private Notification mensajeError;


    public Frm_Ventas(JFrame frame) {
    
        initComponents();
        habilitar(false);
        table.TableCustom.apply(jScrollPane1, table.TableCustom.TableType.MULTI_LINE);
        ca = new Categoria(frame);
        this.frame = frame;
//        modeloProductos = new DefaultComboBoxModel(prod.mostrarProductos());
        modeloCategoria = new DefaultComboBoxModel(ca.mostrarCategoria());

//        cbo_productos.setModel(modeloProductos);
        lista = new List();
        cbo_categoria.setModel(modeloCategoria);
        dateChooser.setTextRefernce(txt_fecha);
        dateChooser.addEventDateChooser(new EventDateChooser() {
            @Override
            public void dateSelected(SelectedAction action, SelectedDate date) {
                System.out.println(date.getDay() + "-" + date.getMonth() + "-" + date.getYear());
                if (action.getAction() == SelectedAction.DAY_SELECTED) {
                    dateChooser.hidePopup();
                }
            }
        });
        ctr = new Ventas(frame);
        ctr_d = new Detalle(frame);
        ctr_c = new Cliente(frame);

        SpinnerNumberModel sp = new SpinnerNumberModel();
        sp.setMinimum(0);
        sp.setMaximum(1000000);
        spn_cantidad.setModel(sp);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSCustomPopuMenu1 = new rojeru_san.complementos.RSCustomPopuMenu();
        evaluatorPoint2D1 = new org.jdesktop.swing.animation.timing.evaluators.EvaluatorPoint2D();
        timingTargetAdapter1 = new org.jdesktop.core.animation.timing.TimingTargetAdapter();
        valoresEnum1 = new rojeru_san.efectos.ValoresEnum();
        verticalLabelIUI1 = new necesario.VerticalLabelIUI();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbo_productos = new RSMaterialComponent.RSComboBoxMaterial();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        cbo_categoria = new RSMaterialComponent.RSComboBoxMaterial();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_nombres = new Components.TextFieldSuggestion();
        txt_apellidos = new Components.TextFieldSuggestion();
        spn_cantidad = new Components.Spinner();
        txt_precioU = new Components.TextField();
        txt_stock = new Components.TextField();
        btn_agregar = new Components.ButtonShadow();
        txt_igv = new Components.TextFieldSuggestion();
        txt_total = new Components.TextFieldSuggestion();
        btn_generar_Boleta = new Components.ButtonShadow();
        txt_fecha = new Components.TextFieldSuggestion();
        btn_calendario = new Components.ButtonShadow();
        jLabel8 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        cbo_tipo = new RSMaterialComponent.RSComboBoxMaterial();
        btn_nuevaVenta = new Components.ButtonShadow();
        txt_dni = new Components.TextFieldSuggestion();
        btn_agregar1 = new Components.ButtonShadow();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("DNI ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 60, 30));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Apellidos");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, 140, 30));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Productos");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 120, 30));

        cbo_productos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        cbo_productos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_productosItemStateChanged(evt);
            }
        });
        jPanel1.add(cbo_productos, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, 210, 50));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 690, 20));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 690, 20));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Venta");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 120, 30));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Producto", "Precio", "Cantidad ", "Importe"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 570, 150));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Nombres ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 140, 30));

        cbo_categoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        cbo_categoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_categoriaItemStateChanged(evt);
            }
        });
        jPanel1.add(cbo_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 210, 50));

        jLabel6.setText("IGV :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 680, 60, -1));

        jLabel7.setText("Total :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 650, 70, -1));
        jPanel1.add(txt_nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 180, -1));
        jPanel1.add(txt_apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, 200, -1));

        spn_cantidad.setLabelText("Cantidad");
        jPanel1.add(spn_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 210, 50));

        txt_precioU.setLabelText("Precio");
        jPanel1.add(txt_precioU, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, 220, 50));

        txt_stock.setLabelText("Stock");
        jPanel1.add(txt_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 400, 200, -1));

        btn_agregar.setForeground(new java.awt.Color(255, 255, 255));
        btn_agregar.setText("➕");
        btn_agregar.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 400, 60, 50));

        txt_igv.setRound(0);
        txt_igv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_igvActionPerformed(evt);
            }
        });
        jPanel1.add(txt_igv, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 670, 130, 30));

        txt_total.setRound(0);
        txt_total.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_totalKeyPressed(evt);
            }
        });
        jPanel1.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 640, 130, 30));

        btn_generar_Boleta.setBackground(new java.awt.Color(51, 51, 51));
        btn_generar_Boleta.setForeground(new java.awt.Color(255, 255, 255));
        btn_generar_Boleta.setText("Generar Boleta");
        btn_generar_Boleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generar_BoletaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_generar_Boleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 660, 120, -1));
        jPanel1.add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 170, -1));

        btn_calendario.setText("🗓");
        btn_calendario.setFont(new java.awt.Font("Helvetica Neue", 0, 20)); // NOI18N
        btn_calendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calendarioActionPerformed(evt);
            }
        });
        jPanel1.add(btn_calendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 50, 40));

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Datos del cliente");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 120, 30));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 690, 20));

        cbo_tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Seleccionar-", "Boleta", "Factura" }));
        cbo_tipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_tipoItemStateChanged(evt);
            }
        });
        jPanel1.add(cbo_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 210, 50));

        btn_nuevaVenta.setText("Nueva venta   ");
        btn_nuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevaVentaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_nuevaVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, -1, -1));

        txt_dni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dniKeyPressed(evt);
            }
        });
        jPanel1.add(txt_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 190, -1));

        btn_agregar1.setForeground(new java.awt.Color(255, 255, 255));
        btn_agregar1.setText("➖");
        btn_agregar1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btn_agregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_agregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 400, 60, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 981, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbo_categoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_categoriaItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            CategoriaDTO categoria = (CategoriaDTO) cbo_categoria.getSelectedItem();
            ProductoDTO producto = new ProductoDTO();
            pro = pr.mostrarProd(categoria.getId());
            modeloProductos = new DefaultComboBoxModel(pro);
            cbo_productos.setModel(modeloProductos);
        }
    }//GEN-LAST:event_cbo_categoriaItemStateChanged

    private void cbo_productosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_productosItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            ProductoDTO producto = (ProductoDTO) cbo_productos.getSelectedItem();
            if (producto != null) {
                txt_precioU.setText(String.valueOf(producto.getPrecio()));
                txt_stock.setText(String.valueOf(producto.getStock()));
            }
        }
    }//GEN-LAST:event_cbo_productosItemStateChanged

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed

        CategoriaDTO cat = (CategoriaDTO) cbo_categoria.getSelectedItem();
        if (!cat.getCategoria().equals("-Seleccione Categoria-")) {
            ProductoDTO producto = (ProductoDTO) cbo_productos.getSelectedItem();
            if (modeloProductos != null && !producto.getDescripcion().equals("-Seleccionar Producto-")) {
                int cantidad = (int) spn_cantidad.getValue();
                if (cantidad > 0) {
                    if (producto.getStock() - cantidad >= 0) {
                        producto.setStock(producto.getStock() - cantidad);
                        txt_precioU.setText(String.valueOf(producto.getPrecio()));
                        txt_stock.setText(String.valueOf(producto.getStock()));
                        articulo = new ItemDTO(producto, cantidad);
                        articulo.CalcularImporte();
                        lista.añadir(articulo);
                        txt_total.setText(String.valueOf(lista.calcularTotal()));
                        llenarTabla();

                    } else {
                        mensajeError = new Notification("Stock insuficiente",
                                frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT);
                    }
                } else {
                    mensajeError = new Notification("Cantidad invalida",
                            frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT);
                }
            } else {
                mensajeError = new Notification("Seleccione un producto",
                        frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT);
            }

        } else {
            mensajeError = new Notification("Seleccione una categoria",
                    frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT);
        }

    }//GEN-LAST:event_btn_agregarActionPerformed

    private void txt_totalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_totalKeyPressed
        try {
            txt_total.setText(String.valueOf(lista.calcularTotal()));
        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_txt_totalKeyPressed

    private void btn_generar_BoletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generar_BoletaActionPerformed

        SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha;
        try {

            fecha = sf.parse(txt_fecha.getText());
            long l = fecha.getTime();
            java.sql.Date f = new java.sql.Date(l);

            String tipo = (String) cbo_tipo.getSelectedItem();
            double total = lista.calcularTotal();
            int idCliente = cliente.getCodigo();
            System.out.println(idCliente);

            ctr.insertar(idCliente, f, tipo, total);
            int idVenta = ctr.IdVenta();
            System.out.println(idVenta);
            for (ItemDTO var : lista.getArticulos()) {
                ctr_d.insertar(idVenta, var.getProducto().getCodigo(), var.getCantidad(), var.getImporte());
                prod.RestarStock(var.getProducto().getCodigo(), var.getCantidad());
            }
            generardoc();

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }//GEN-LAST:event_btn_generar_BoletaActionPerformed

    private void btn_calendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calendarioActionPerformed
        dateChooser.showPopup();
    }//GEN-LAST:event_btn_calendarioActionPerformed

    private void cbo_tipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_tipoItemStateChanged
        if (cbo_tipo.getSelectedItem().equals("Factura")) {
            jLabel1.setText("RUC");

        } else {
            jLabel1.setText("DNI");

        }
        habilitar(false);
    }//GEN-LAST:event_cbo_tipoItemStateChanged

    private void btn_nuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevaVentaActionPerformed
        lista = new List();
        limpiar();
    }//GEN-LAST:event_btn_nuevaVentaActionPerformed

    private void txt_dniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dniKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            cliente = ctr_c.Buscar(txt_dni.getText());
            if (cliente != null) {
                if (!cliente.getNombres().equals("")) {
                    habilitar(true);
                    isClient = true;
                    txt_nombres.setText(cliente.getNombres());
                    txt_apellidos.setText(cliente.getApellidos());
                }
            } else {
                if (jLabel1.getText().equals("DNI")) {
                    cliente = new ClienteDTO(txt_dni.getText());
                    if (crud.Create(cliente)) {
                        cliente = ctr_c.Buscar(cliente.getDni());

                    }
                } else {
                    cliente = new ClienteDTO();
                    cliente.setRuc(txt_dni.getText());
                    if (crud.Create(cliente)) {

                    }
                }
            }

        }
    }//GEN-LAST:event_txt_dniKeyPressed

    private void txt_igvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_igvActionPerformed

    }//GEN-LAST:event_txt_igvActionPerformed

    private void btn_agregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregar1ActionPerformed

        try {
            ProductoDTO producto = (ProductoDTO) cbo_productos.getSelectedItem();
            int codigo = (int) (tabla.getValueAt(tabla.getSelectedRow(), 0));
            int cantidad = (int) (tabla.getValueAt(tabla.getSelectedRow(), 3));
            lista.eliminar(codigo);
            producto.setStock(producto.getStock() + cantidad);
            txt_precioU.setText(String.valueOf(producto.getPrecio()));
            txt_stock.setText(String.valueOf(producto.getStock()));

            llenarTabla();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_agregar1ActionPerformed

    public void llenarTabla() {
        df.setColumnCount(0);
        df.setRowCount(0);
        String[] cabezera = {"Código", "Descripción", "Precio", "Cantidad", "Importe"};
        df.setColumnIdentifiers(cabezera);
        Object[] datos = new Object[df.getColumnCount()];

        for (int i = 0; i < lista.getArticulos().size(); i++) {
            ItemDTO aux = lista.getArticulos().get(i);

            datos[0] = aux.getProducto().getCodigo();
            datos[1] = aux.getProducto().getDescripcion();
            datos[2] = aux.getProducto().getPrecio();
            datos[3] = aux.getCantidad();
            datos[4] = aux.getImporte();

            df.addRow(datos);
        }

        tabla.setModel(df);
    }

    public void generardoc() {
        Document doc = new Document();
        String destino = "";
        try {

            int seleccion = fc.showOpenDialog(this);

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                try {
                    destino = fc.getSelectedFile().getPath();
                    fc.setSelectedFile(new File("Boleta de pago"));
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(doc, new FileOutputStream(destino + ".pdf"));

            Image header = Image.getInstance("/Users/cesarcunyarache/Downloads/Proyectos Netbens/FagexPeru/src/Image/fagex.png");
            header.scaleToFit(200, 100);
            header.setAlignment(Chunk.ALIGN_LEFT);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Chunk.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Arial", 20, Font.ITALIC, BaseColor.BLACK));
            parrafo.add(" \n Boleta de venta  \n \n");

            Paragraph parrafo1 = new Paragraph();
            parrafo1.setAlignment(Chunk.ALIGN_LEFT);
            parrafo1.setFont(FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLACK));
            parrafo1.add(" Cliente : " + cliente.getApellidos() + " " + cliente.getNombres() + " \n");

            Paragraph parrafo2 = new Paragraph();
            parrafo2.setAlignment(Chunk.ALIGN_LEFT);
            parrafo2.setFont(FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLACK));
            parrafo2.add(" DNI : " + cliente.getDni() + " \n");

            Paragraph parrafo3 = new Paragraph();
            parrafo3.setAlignment(Chunk.ALIGN_LEFT);
            parrafo3.setFont(FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLACK));
            parrafo3.add(" RUC : " + cliente.getRuc() + " \n");

            Paragraph parrafo4 = new Paragraph();
            parrafo4.setAlignment(Chunk.ALIGN_LEFT);
            parrafo4.setFont(FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLACK));
            parrafo4.add(" RUC : " + cliente.getRuc() + " \n \n");

            Paragraph parrafo5 = new Paragraph();
            parrafo5.setAlignment(Chunk.ALIGN_LEFT);
            parrafo5.setFont(FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLACK));
            parrafo5.add(" Fecha de emisión : " + txt_fecha.getText() + " \n \n");

            doc.open();
            doc.add(header);
            doc.add(parrafo);
            doc.add(parrafo1);
            doc.add(parrafo2);
            doc.add(parrafo3);
//            doc.add(parrafo4);
            doc.add(parrafo5);
            PdfPTable table = new PdfPTable(5);

//            cell.setBackground(new Color (65, 65, 65));
            Phrase p = new Phrase();
            p.add("Codigo");
            Paragraph parr = new Paragraph();
            parr.add("Codigo");
            parr.setFont(FontFactory.getFont("Arial", 18, Font.BOLD, BaseColor.WHITE));
            p.setFont(FontFactory.getFont("Arial", 18, Font.BOLD, BaseColor.WHITE));
            PdfPCell cell = new PdfPCell(parr);
//            cell.setBackgroundColor(new BaseColor(196, 89, 18));
            table.addCell(cell);

            table.addCell("Descripción");
            table.addCell("Precio");
            table.addCell("Cantidad");
            table.addCell("Importe");

            for (ItemDTO var : lista.getArticulos()) {
                table.addCell(String.valueOf(var.getProducto().getCodigo()));
                table.addCell(var.getProducto().getDescripcion());
                table.addCell(String.valueOf(var.getProducto().getPrecio()));
                table.addCell(String.valueOf((var.getCantidad())));
                table.addCell(String.valueOf(var.getImporte()));
            }

            doc.add(table);

            Paragraph parrafo6 = new Paragraph();
            parrafo6.setAlignment(Chunk.ALIGN_RIGHT);
            parrafo6.setFont(FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLACK));
            parrafo6.add(" Total : " + txt_total.getText() + " \n");

            Paragraph parrafo7 = new Paragraph();
            parrafo7.setAlignment(Chunk.ALIGN_RIGHT);
            parrafo7.setFont(FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.BLACK));
            String igv = String.format("%.2f", Double.parseDouble(txt_total.getText()) * 0.18);
            parrafo7.add(" IGV : " + igv + " \n");
            doc.add(parrafo7);
            doc.add(parrafo6);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            doc.close();
        }
    }

    public void habilitar(boolean var) {
        jLabel5.setVisible(var);
        txt_nombres.setVisible(var);
        jLabel2.setVisible(var);
        txt_apellidos.setVisible(var);
    }

    public void limpiar() {
        cbo_tipo.setSelectedIndex(0);
        txt_fecha.setText("");
        txt_dni.setText("");
        txt_nombres.setText("");
        txt_apellidos.setText("");
        cbo_categoria.setSelectedIndex(0);
        cbo_productos.setSelectedIndex(0);
        spn_cantidad.setValue(0);
        txt_precioU.setText("");
        txt_stock.setText("");
        txt_total.setText("");
        txt_igv.setText("");
        df.setColumnCount(0);
        df.setRowCount(0);
    }

    public void reset() {

        modeloCategoria = new DefaultComboBoxModel(ca.mostrarCategoria());
        cbo_categoria.setModel(modeloCategoria);
        CategoriaDTO categoria = (CategoriaDTO) cbo_categoria.getSelectedItem();
        ProductoDTO producto = new ProductoDTO();
        pro = pr.mostrarProd(categoria.getId());
        modeloProductos = new DefaultComboBoxModel(pro);
        cbo_productos.setModel(modeloProductos);
        spn_cantidad.setValue(0);
        txt_precioU.setText("");
        txt_stock.setText("");

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.ButtonShadow btn_agregar;
    private Components.ButtonShadow btn_agregar1;
    private Components.ButtonShadow btn_calendario;
    private Components.ButtonShadow btn_generar_Boleta;
    private Components.ButtonShadow btn_nuevaVenta;
    private RSMaterialComponent.RSComboBoxMaterial cbo_categoria;
    private RSMaterialComponent.RSComboBoxMaterial cbo_productos;
    private RSMaterialComponent.RSComboBoxMaterial cbo_tipo;
    private org.jdesktop.swing.animation.timing.evaluators.EvaluatorPoint2D evaluatorPoint2D1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private rojeru_san.complementos.RSCustomPopuMenu rSCustomPopuMenu1;
    private Components.Spinner spn_cantidad;
    private javax.swing.JTable tabla;
    private org.jdesktop.core.animation.timing.TimingTargetAdapter timingTargetAdapter1;
    private Components.TextFieldSuggestion txt_apellidos;
    private Components.TextFieldSuggestion txt_dni;
    private Components.TextFieldSuggestion txt_fecha;
    private Components.TextFieldSuggestion txt_igv;
    private Components.TextFieldSuggestion txt_nombres;
    private Components.TextField txt_precioU;
    private Components.TextField txt_stock;
    private Components.TextFieldSuggestion txt_total;
    private rojeru_san.efectos.ValoresEnum valoresEnum1;
    private necesario.VerticalLabelIUI verticalLabelIUI1;
    // End of variables declaration//GEN-END:variables
}

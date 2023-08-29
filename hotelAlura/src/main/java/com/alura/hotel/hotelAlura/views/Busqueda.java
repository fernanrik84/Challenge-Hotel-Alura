package com.alura.hotel.hotelAlura.views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableCellEditor;

import com.alura.hotel.hotelAlura.controller.huespedController;
import com.alura.hotel.hotelAlura.controller.reservasController;
import com.alura.hotel.hotelAlura.model.huespedModel;
import com.alura.hotel.hotelAlura.model.reservasModel;
import com.toedter.calendar.JCalendar;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Date;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHuespedes;
	private JTable tbReservas;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloHuesped;
	private JLabel labelAtras;
	private JLabel labelExit;
	int xMouse, yMouse;
	
	private reservasController ReservaController;
    private huespedController HuespedController;

    private final String[] nacionalidad = new String[] {
            "afgano-afgana",
            "alemán-",
            "alemana",
            "árabe-árabe",
            "argentino-argentina",
            "australiano-australiana",
            "belga-belga",
            "boliviano-boliviana",
            "brasileño-brasileña",
            "camboyano-camboyana",
            "canadiense-canadiense",
            "chileno-chilena",
            "chino-china",
            "colombiano-colombiana",
            "coreano-coreana",
            "costarricense-costarricense",
            "cubano-cubana",
            "danés-danesa",
            "ecuatoriano-ecuatoriana",
            "egipcio-egipcia",
            "salvadoreño-salvadoreña",
            "escocés-escocesa",
            "español-española",
            "estadounidense-estadounidense",
            "estonio-estonia",
            "etiope-etiope",
            "filipino-filipina",
            "finlandés-finlandesa",
            "francés-francesa",
            "galés-galesa",
            "griego-griega",
            "guatemalteco-guatemalteca",
            "haitiano-haitiana",
            "holandés-holandesa",
            "hondureño-hondureña",
            "indonés-indonesa",
            "inglés-inglesa",
            "iraquí-iraquí",
            "iraní-iraní",
            "irlandés-irlandesa",
            "israelí-israelí",
            "italiano-italiana",
            "japonés-japonesa",
            "jordano-jordana",
            "laosiano-laosiana",
            "letón-letona",
            "letonés-letonesa",
            "malayo-malaya",
            "marroquí-marroquí",
            "mexicano-mexicana",
            "nicaragüense-nicaragüense",
            "noruego-noruega",
            "neozelandés-neozelandesa",
            "panameño-panameña",
            "paraguayo-paraguaya",
            "peruano-peruana",
            "polaco-polaca",
            "portugués-portuguesa",
            "puertorriqueño-puertorriqueño",
            "dominicano-dominicana",
            "rumano-rumana",
            "ruso-rusa",
            "sueco-sueca",
            "suizo-suiza",
            "tailandés-tailandesa",
            "taiwanes-taiwanesa",
            "turco-turca",
            "ucraniano-ucraniana",
            "uruguayo-uruguaya",
            "venezolano-venezolana",
            "vietnamita-vietnamita"
    };
    
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Busqueda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		//*****************************************************
		this.HuespedController = new huespedController();
        this.ReservaController = new reservasController();
		//*****************************************************
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblNewLabel_4.setBounds(331, 62, 280, 42);
		contentPane.add(lblNewLabel_4);

		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);

		tbReservas = new JTable();
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		
		modelo = (DefaultTableModel) tbReservas.getModel();
		modelo.addColumn("Numero de Reserva");
		modelo.addColumn("Fecha Check In");
		modelo.addColumn("Fecha Check Out");
		modelo.addColumn("Valor");
		modelo.addColumn("Forma de Pago");
		
		JScrollPane scroll_table = new JScrollPane(tbReservas);
		panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")), scroll_table,
				null);
		scroll_table.setVisible(true);

		tbHuespedes = new JTable();
		tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		modeloHuesped = (DefaultTableModel) tbHuespedes.getModel();
		modeloHuesped.addColumn("Número de Huesped");
		modeloHuesped.addColumn("Nombre");
		modeloHuesped.addColumn("Apellido");
		modeloHuesped.addColumn("Fecha de Nacimiento");
		modeloHuesped.addColumn("Nacionalidad");
		modeloHuesped.addColumn("Telefono");
		modeloHuesped.addColumn("Número de Reserva");
		
		//********************************************************
		JComboBox<String> jComboBox = new JComboBox<>(nacionalidad);
        TableColumn tableColumn = this.tbHuespedes.getColumnModel().getColumn(4);
        TableCellEditor tce = new DefaultCellEditor(jComboBox);
        tableColumn.setCellEditor(tce);

        JCalendar fechaNacimiento = new JCalendar();
        TableColumn tableColumn2 = this.tbHuespedes.getColumnModel().getColumn(3);

        cargarTablaHuespedes();
		//********************************************************
		
		JScrollPane scroll_tableHuespedes = new JScrollPane(tbHuespedes);
		panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")),
				scroll_tableHuespedes, null);
		scroll_tableHuespedes.setVisible(true);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);

		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);

			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);

		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAtras.setBackground(Color.white);
				labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);

		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);

		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                int result = JOptionPane.showConfirmDialog(
                        new JFrame(),
                        "¿Desea salir de la aplicacion?",
                        "pregunta",
                        JOptionPane.YES_NO_OPTION);
                if (result == 0) {
                    System.exit(0);
                }
            }

			@Override
			public void mouseEntered(MouseEvent e) { // Al usuario pasar el mouse por el botón este cambiará de color
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) { // Al usuario quitar el mouse por el botón este volverá al estado
													// original
				btnexit.setBackground(Color.white);
				labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);

		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);

		JPanel btnbuscar = new JPanel();
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
	                cargarTablaHuespedesPorReserva(HuespedController.obtenerPorReserva(Integer.parseInt(txtBuscar.getText())));
	                cargarTablaReservasResult(ReservaController.obtenerReservaPorNumero(Integer.parseInt(txtBuscar.getText())));
	            } catch (NumberFormatException err) {
	            	cargarTablaHuespedesResult(HuespedController.obtenerPorApellido(txtBuscar.getText()));
	            }
			}
		});
		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);

		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));

		//****************************************************
		// restaurar resultados
        JPanel btnRestaurar = new JPanel();
        btnRestaurar.setLayout(null);
        btnRestaurar.setBackground(new Color(12, 138, 199));
        btnRestaurar.setBounds(358, 508, 267, 35);
        btnRestaurar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentPane.add(btnRestaurar);

        JLabel restaurar = new JLabel("VER TODOS LOS REGISTROS");
        restaurar.setHorizontalAlignment(SwingConstants.CENTER);
        restaurar.setForeground(Color.WHITE);
        restaurar.setFont(new Font("Roboto", Font.PLAIN, 18));
        restaurar.setBounds(0, 0, 267, 36);
        btnRestaurar.add(restaurar);
        btnRestaurar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cargarTablaReservas();
                cargarTablaHuespedes();
            }
        });
        // fin restaurar resultados
		//****************************************************

		
		JPanel btnEditar = new JPanel();
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);

		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);
		
		//****************************************************
		btnEditar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                modificar();
            }
        });
		//****************************************************


		JPanel btnEliminar = new JPanel();
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		btnEliminar.setBounds(767, 508, 122, 35);
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);

		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		setResizable(false);
		
		//****************************************************
		btnEliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	eliminar();
            }
        });
        //fin eliminar
	}
		
		//****************************************************NEW PART
		//****************************************************
		 private void eliminar(){
	        if(tieneFilaElegidaReserva() && tieneFilaElegidaHuespedes()) {
	            JOptionPane.showMessageDialog(this, "Por favor, elija un campo de reserva o huesped");
	            return;
	        }
	        if(!tieneFilaElegidaReserva()){
	            eliminarReserva();
	        } else {
	            eliminarHuesped();
	        }
	    }

		private void eliminarReserva() {
	        Optional.ofNullable(modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
	                .ifPresentOrElse(fila -> {
	                    int id = Integer.parseInt(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());
	                    int CantidadEliminada;
	                    CantidadEliminada = this.ReservaController.eliminar(id);

	                    modelo.removeRow(tbReservas.getSelectedRow());

	                    JOptionPane.showMessageDialog(this,CantidadEliminada + " Item eliminado con éxito!");
	                }, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));
	    }

	    private void eliminarHuesped() {
	        Optional.ofNullable(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
	                .ifPresentOrElse(fila -> {
	                    int id = Integer.parseInt(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());
	                    int CantidadEliminada;
	                    CantidadEliminada = this.HuespedController.eliminar(id);

	                    modeloHuesped.removeRow(tbHuespedes.getSelectedRow());

	                    JOptionPane.showMessageDialog(this,CantidadEliminada + " huesped eliminado con éxito!");
	                }, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un huesped"));
	    }

	    private void modificar(){
	        if(tieneFilaElegidaReserva() && tieneFilaElegidaHuespedes()) {
	            JOptionPane.showMessageDialog(this, "Por favor, elija un campo de reserva o huesped");
	            return;
	        }
	        if(!tieneFilaElegidaReserva()){
	            modificarReserva();
	            cargarTablaReservas();
	        } else {
	            this.modificarHuesped();
	            cargarTablaHuespedes();
	        }
	    }
	    
	    private void modificarHuesped() {
	        Optional.ofNullable(this.modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
	                .ifPresentOrElse(fila -> {
	                    Long id = Long.parseLong( modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());
	                    String nombre = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 1);
	                    String apellido = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 2);
	                    Date fNacimiento =  Date.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 3).toString());
	                    String nacionalidad = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 4);
	                    String telefono =(String)  modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(),5);
	                    Long reserva =Long.valueOf(  modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(),6).toString());
	                    int cantidadAfectada;
	                    huespedModel huesped = new huespedModel(
	                        id,nombre,apellido,fNacimiento,nacionalidad,telefono,reserva
	                    );
	                    cantidadAfectada = this.HuespedController.modificar(huesped);
	                    JOptionPane.showMessageDialog(this,cantidadAfectada + " Huesped actualizado con éxito!");
	                }, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un Huesped"));
	    }

	    private void modificarReserva() {
	        Optional.ofNullable(this.modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
	                .ifPresentOrElse(fila -> {
	                    Long id = Long.parseLong(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());
	                    Date fEntrada =  Date.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 1).toString());
	                    Date fSalida = Date.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 2).toString());
	                    float valor = Float.parseFloat( modelo.getValueAt(tbReservas.getSelectedRow(), 3).toString());
	                    String formaDePago =(String)  modelo.getValueAt(tbReservas.getSelectedRow(),4);

	                    int cantidadAfectada;
	                    reservasModel reserva = new reservasModel(
	                            fEntrada,fSalida,valor,formaDePago
	                    );
	                    reserva.setIdreservas(id);

	                    cantidadAfectada = this.ReservaController.modificar(reserva);
	                    JOptionPane.showMessageDialog(this,cantidadAfectada + " reserva actualizado con éxito!");
	                }, () -> JOptionPane.showMessageDialog(this, "Por favor, elije una reserva"));
	    }

	    private boolean tieneFilaElegidaReserva() {
	        return tbReservas.getSelectedRowCount() == 0 || tbReservas.getSelectedColumnCount() == 0;
	    }

	    private boolean tieneFilaElegidaHuespedes() {
	        return tbHuespedes.getSelectedRowCount() == 0 || tbHuespedes.getSelectedColumnCount() == 0;
	    }

	    private void cargarTablaHuespedes() {
	        modeloHuesped.setRowCount(0);
	        var huespedes = this.HuespedController.obtenerHuespedes();
	        huespedes.forEach(huesped -> this.modeloHuesped.addRow(new Object[]{
	                huesped.getIdhuespedes(),
	                huesped.getNombre(),
	                huesped.getApellido(),
	                huesped.getFecha_nacimiento(),
	                huesped.getNacionalidad(),
	                huesped.getTelefono(),huesped.getIdreserva()
	        }));
	    }

	    private void cargarTablaHuespedesResult(List<huespedModel> huespedList) {
	        modeloHuesped.setRowCount(0);
	        huespedList.forEach(huesped -> this.modeloHuesped.addRow(new Object[]{
	                huesped.getIdhuespedes(),
	                huesped.getNombre(),
	                huesped.getApellido(),
	                huesped.getFecha_nacimiento(),
	                huesped.getNacionalidad(),
	                huesped.getTelefono(),
	                huesped.getIdreserva()
	        }));
	    }
	    
	    private void cargarTablaHuespedesPorReserva(List<huespedModel> huespedList) {
	        modeloHuesped.setRowCount(0);

	        huespedList.forEach(huesped -> this.modeloHuesped.addRow(new Object[]{
	                huesped.getIdhuespedes(),
	                huesped.getNombre(),
	                huesped.getApellido(),
	                huesped.getFecha_nacimiento(),
	                huesped.getNacionalidad(),
	                huesped.getTelefono(),
	                huesped.getIdreserva()
	        }));
	    }

	    private void cargarTablaReservas() {
	        modelo.setRowCount(0);
	        var reservas = this.ReservaController.obtenerReservas();
	        reservas.forEach(reserva -> this.modelo.addRow(new Object[]{
	                reserva.getIdreservas(),
	                reserva.getFecha_entrada(),
	                reserva.getFecha_salida(),
	                reserva.getValor(),
	                reserva.getForma_pago()
	        }));
	    }
	    private void cargarTablaReservasResult(List<reservasModel> reservaList) {
	        modelo.setRowCount(0);
	        reservaList.forEach(reserva -> this.modelo.addRow(new Object[]{
	                reserva.getIdreservas(),
	                reserva.getFecha_entrada(),
	                reserva.getFecha_salida(),
	                reserva.getValor(),
	                reserva.getForma_pago()
	        }));
	    }
		
		//****************************************************
		//****************************************************


//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
		xMouse = evt.getX();
		yMouse = evt.getY();
	}

	private void headerMouseDragged(java.awt.event.MouseEvent evt) {
		int x = evt.getXOnScreen();
		int y = evt.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}
}

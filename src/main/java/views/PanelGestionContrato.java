package views;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JToolBar;

import mavenContratosExamenLike.entities.Contrato;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class PanelGestionContrato extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Contrato current = null;
	
	private JTextField jtfTipoContrato;
	private JTextField jtfUsuario;

	/**
	 * Create the panel.
	 */
	public PanelGestionContrato() {
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		JButton btnFirst = new JButton("");
		btnFirst.setIcon(new ImageIcon(PanelGestionContrato.class.getResource("/mavenContratosExamenLike/res/gotostart.png")));
		toolBar.add(btnFirst);
		
		JButton btnPrevious = new JButton("");
		btnPrevious.setIcon(new ImageIcon(PanelGestionContrato.class.getResource("/mavenContratosExamenLike/res/previous.png")));
		toolBar.add(btnPrevious);
		
		JButton btnNext = new JButton("");
		btnNext.setIcon(new ImageIcon(PanelGestionContrato.class.getResource("/mavenContratosExamenLike/res/next.png")));
		toolBar.add(btnNext);
		
		JButton btnLast = new JButton("");
		btnLast.setIcon(new ImageIcon(PanelGestionContrato.class.getResource("/mavenContratosExamenLike/res/gotoend.png")));
		toolBar.add(btnLast);
		
		JButton btnNew = new JButton("");
		btnNew.setIcon(new ImageIcon(PanelGestionContrato.class.getResource("/mavenContratosExamenLike/res/nuevo.png")));
		toolBar.add(btnNew);
		
		JButton btnSave = new JButton("");
		btnSave.setIcon(new ImageIcon(PanelGestionContrato.class.getResource("/mavenContratosExamenLike/res/guardar.png")));
		toolBar.add(btnSave);
		
		JButton btnDelete = new JButton("");
		btnDelete.setIcon(new ImageIcon(PanelGestionContrato.class.getResource("/mavenContratosExamenLike/res/eliminar.png")));
		toolBar.add(btnDelete);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Gestion de contratos");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha: ");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JFormattedTextField ftfFecha = new JFormattedTextField();
		GridBagConstraints gbc_ftfFecha = new GridBagConstraints();
		gbc_ftfFecha.insets = new Insets(0, 0, 5, 5);
		gbc_ftfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftfFecha.gridx = 1;
		gbc_ftfFecha.gridy = 1;
		panel.add(ftfFecha, gbc_ftfFecha);
		
		JLabel lblNewLabel_2 = new JLabel("Límite: ");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JSpinner jspLimite = new JSpinner();
		GridBagConstraints gbc_jspLimite = new GridBagConstraints();
		gbc_jspLimite.fill = GridBagConstraints.HORIZONTAL;
		gbc_jspLimite.insets = new Insets(0, 0, 5, 5);
		gbc_jspLimite.gridx = 1;
		gbc_jspLimite.gridy = 2;
		panel.add(jspLimite, gbc_jspLimite);
		
		JLabel lblNewLabel_3 = new JLabel("Saldo: ");
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JSlider jslSaldo = new JSlider();
		GridBagConstraints gbc_jslSaldo = new GridBagConstraints();
		gbc_jslSaldo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jslSaldo.insets = new Insets(0, 0, 5, 5);
		gbc_jslSaldo.gridx = 1;
		gbc_jslSaldo.gridy = 3;
		panel.add(jslSaldo, gbc_jslSaldo);
		
		JLabel lblNewLabel_4 = new JLabel("  Tipo contrato: ");
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfTipoContrato = new JTextField();
		jtfTipoContrato.setEditable(false);
		GridBagConstraints gbc_jtfTipoContrato = new GridBagConstraints();
		gbc_jtfTipoContrato.insets = new Insets(0, 0, 5, 5);
		gbc_jtfTipoContrato.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTipoContrato.gridx = 1;
		gbc_jtfTipoContrato.gridy = 4;
		panel.add(jtfTipoContrato, gbc_jtfTipoContrato);
		jtfTipoContrato.setColumns(10);
		
		JButton btnSelectTipoContrato = new JButton("Seleccionar");
		GridBagConstraints gbc_btnSelectTipoContrato = new GridBagConstraints();
		gbc_btnSelectTipoContrato.insets = new Insets(0, 0, 5, 0);
		gbc_btnSelectTipoContrato.gridx = 2;
		gbc_btnSelectTipoContrato.gridy = 4;
		panel.add(btnSelectTipoContrato, gbc_btnSelectTipoContrato);
		
		JLabel lblNewLabel_5 = new JLabel("Usuario: ");
		lblNewLabel_5.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jtfUsuario = new JTextField();
		jtfUsuario.setEditable(false);
		GridBagConstraints gbc_jtfUsuario = new GridBagConstraints();
		gbc_jtfUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_jtfUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfUsuario.gridx = 1;
		gbc_jtfUsuario.gridy = 5;
		panel.add(jtfUsuario, gbc_jtfUsuario);
		jtfUsuario.setColumns(10);
		
		JButton btnSelectUsuario = new JButton("Seleccionar");
		GridBagConstraints gbc_btnSelectUsuario = new GridBagConstraints();
		gbc_btnSelectUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_btnSelectUsuario.gridx = 2;
		gbc_btnSelectUsuario.gridy = 5;
		panel.add(btnSelectUsuario, gbc_btnSelectUsuario);

	}
	
	
	
	/**
	 * 
	 * @return
	 */
	private JFormattedTextField getJFormattedTextFieldDatePersonalizado() {
		JFormattedTextField jftf = new JFormattedTextField(
				new JFormattedTextField.AbstractFormatter() {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			@Override
			public String valueToString(Object value) throws ParseException {
				if (value != null && value instanceof Date) {
					return sdf.format(((Date) value));
				}
				return "";
			}

			@Override
			public Object stringToValue(String text) throws ParseException {
				try {
					return sdf.parse(text);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error en la fecha");
					return null;
				}
			}
		});
		jftf.setColumns(20);
		jftf.setValue(new Date());
		return jftf;
	}
	
	
	
	
	
	
	
	/**
	 * 
	 * @param a
	 */
	private void cargaItem(Contrato c) {
		
		if (c != null) {
			
			this.current = c;
			
			
			
			
			
		}	
	}
	
	//=============== BUTTONS ==========================//
	
		/**
		 * 
		 */
//		private void cargaPrimero() {
//			cargaItem((Articulo) ControladorArticulo.getInsctance().findFirst());
//		}
//
//		/**
//		 * 
//		 */
//		private void cargaAnterior() {
//			Entidad entidadActual = ControladorArticulo.getInsctance().findById(Integer.parseInt(this.jtfId.getText()));
//			cargaItem((Articulo) ControladorArticulo.getInsctance().findPrevious(entidadActual));
//		}
//		
//		/**
//		 * 
//		 */
//		private void cargaSiguiente() {
//			Entidad entidadActual = ControladorArticulo.getInsctance().findById(Integer.parseInt(this.jtfId.getText()));
//			cargaItem((Articulo) ControladorArticulo.getInsctance().findNext(entidadActual));
//		}
//		
//		/*
//		 * 
//		 */
//		private void cargaUltimo() {
//			cargaItem((Articulo) ControladorArticulo.getInsctance().findLast());
//		}
//		
		
	
	

}

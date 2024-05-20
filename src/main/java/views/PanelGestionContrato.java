package views;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JToolBar;

import mavenContratosExamenLike.controllers.ControladorContrato;
import mavenContratosExamenLike.controllers.ControladorTipoContrato;
import mavenContratosExamenLike.controllers.ControladorUsuario;
import mavenContratosExamenLike.entities.Contrato;
import mavenContratosExamenLike.entities.Tipocontrato;
import mavenContratosExamenLike.entities.Usuario;

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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelGestionContrato extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Contrato currentContrato = null;
	
	private JTextField jtfDescripcion;
	private JFormattedTextField jftf;
	private JSpinner jspLimite;
	private JSlider jslSaldo;
	private JLabel jlbSaldo;
	private JTextField jtfTipoContrato;
	private JTextField jtfUsuario;
	private JLabel jlbFooter;
	

	/**
	 * Create the panel.
	 */
	public PanelGestionContrato() {
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		
		//===================== BTN FIRST ========================//
		JButton btnFirst = new JButton("");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaItem((Contrato) ControladorContrato.getInsctance().findFirst());
			}
		});
		btnFirst.setIcon(new ImageIcon(PanelGestionContrato.class.getResource("/mavenContratosExamenLike/res/gotostart.png")));
		toolBar.add(btnFirst);
		
		//===================== BTN PREVIOUS ========================//
		JButton btnPrevious = new JButton("");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaItem((Contrato) ControladorContrato.getInsctance().findPrevious(currentContrato));
			}
		});
		btnPrevious.setIcon(new ImageIcon(PanelGestionContrato.class.getResource("/mavenContratosExamenLike/res/previous.png")));
		toolBar.add(btnPrevious);
		
		//===================== BTN NEXT ========================//
		JButton btnNext = new JButton("");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaItem((Contrato) ControladorContrato.getInsctance().findNext(currentContrato));
			}
		});
		btnNext.setIcon(new ImageIcon(PanelGestionContrato.class.getResource("/mavenContratosExamenLike/res/next.png")));
		toolBar.add(btnNext);
		
		//===================== BTN LAST ========================//
		JButton btnLast = new JButton("");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaItem((Contrato) ControladorContrato.getInsctance().findLast());
			}
		});
		btnLast.setIcon(new ImageIcon(PanelGestionContrato.class.getResource("/mavenContratosExamenLike/res/gotoend.png")));
		toolBar.add(btnLast);
		
		//===================== BTN NEW ========================//
		JButton btnNew = new JButton("");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newEntity();
			}
		});
		btnNew.setIcon(new ImageIcon(PanelGestionContrato.class.getResource("/mavenContratosExamenLike/res/nuevo.png")));
		toolBar.add(btnNew);
		
		//===================== BTN SAVE ========================//
		JButton btnSave = new JButton("");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveEntity();
			}
		});
		btnSave.setIcon(new ImageIcon(PanelGestionContrato.class.getResource("/mavenContratosExamenLike/res/guardar.png")));
		toolBar.add(btnSave);
		
		
		//===================== BTN DELETE ========================//
		JButton btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteEntity();
			}
		});
		btnDelete.setIcon(new ImageIcon(PanelGestionContrato.class.getResource("/mavenContratosExamenLike/res/eliminar.png")));
		toolBar.add(btnDelete);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Gestion de contratos");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_6 = new JLabel("Descripción: ");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 1;
		panel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		jtfDescripcion = new JTextField();
		GridBagConstraints gbc_jtfDescripcion = new GridBagConstraints();
		gbc_jtfDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDescripcion.gridx = 1;
		gbc_jtfDescripcion.gridy = 1;
		panel.add(jtfDescripcion, gbc_jtfDescripcion);
		jtfDescripcion.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha: ");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		GridBagConstraints gbc_jftfFecha = new GridBagConstraints();
		gbc_jftfFecha.insets = new Insets(0, 0, 5, 5);
		gbc_jftfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jftfFecha.gridx = 1;
		gbc_jftfFecha.gridy = 2;
		panel.add(getJFormattedTextFieldDatePersonalizado(), gbc_jftfFecha);
		
		JLabel lblNewLabel_2 = new JLabel("Límite: ");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jspLimite = new JSpinner();
		jspLimite.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int intValue = ((Number) jspLimite.getValue()).intValue();
				jslSaldo.setMaximum(intValue);
				jslSaldo.setValue((int) currentContrato.getSaldo());
				showSliderBarDescription();
			}
		});
		GridBagConstraints gbc_jspLimite = new GridBagConstraints();
		gbc_jspLimite.fill = GridBagConstraints.HORIZONTAL;
		gbc_jspLimite.insets = new Insets(0, 0, 5, 5);
		gbc_jspLimite.gridx = 1;
		gbc_jspLimite.gridy = 3;
		panel.add(jspLimite, gbc_jspLimite);
		
		JLabel lblNewLabel_3 = new JLabel("Saldo: ");
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jslSaldo = new JSlider();
		jslSaldo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				showSliderBarDescription();
			}
		});
		GridBagConstraints gbc_jslSaldo = new GridBagConstraints();
		gbc_jslSaldo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jslSaldo.insets = new Insets(0, 0, 5, 5);
		gbc_jslSaldo.gridx = 1;
		gbc_jslSaldo.gridy = 4;
		panel.add(jslSaldo, gbc_jslSaldo);
		
		jlbSaldo = new JLabel("0 de 0");
		GridBagConstraints gbc_jlbSaldo = new GridBagConstraints();
		gbc_jlbSaldo.insets = new Insets(0, 0, 5, 0);
		gbc_jlbSaldo.gridx = 2;
		gbc_jlbSaldo.gridy = 4;
		panel.add(jlbSaldo, gbc_jlbSaldo);
		
		JLabel lblNewLabel_4 = new JLabel("  Tipo contrato: ");
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfTipoContrato = new JTextField();
		jtfTipoContrato.setEditable(false);
		GridBagConstraints gbc_jtfTipoContrato = new GridBagConstraints();
		gbc_jtfTipoContrato.insets = new Insets(0, 0, 5, 5);
		gbc_jtfTipoContrato.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTipoContrato.gridx = 1;
		gbc_jtfTipoContrato.gridy = 5;
		panel.add(jtfTipoContrato, gbc_jtfTipoContrato);
		jtfTipoContrato.setColumns(10);
		
		JButton btnSelectTipoContrato = new JButton("Seleccionar");
		GridBagConstraints gbc_btnSelectTipoContrato = new GridBagConstraints();
		gbc_btnSelectTipoContrato.insets = new Insets(0, 0, 5, 0);
		gbc_btnSelectTipoContrato.gridx = 2;
		gbc_btnSelectTipoContrato.gridy = 5;
		panel.add(btnSelectTipoContrato, gbc_btnSelectTipoContrato);
		
		JLabel lblNewLabel_5 = new JLabel("Usuario: ");
		lblNewLabel_5.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 6;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jtfUsuario = new JTextField();
		jtfUsuario.setEditable(false);
		GridBagConstraints gbc_jtfUsuario = new GridBagConstraints();
		gbc_jtfUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_jtfUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfUsuario.gridx = 1;
		gbc_jtfUsuario.gridy = 6;
		panel.add(jtfUsuario, gbc_jtfUsuario);
		jtfUsuario.setColumns(10);
		
		JButton btnSelectUsuario = new JButton("Seleccionar");
		GridBagConstraints gbc_btnSelectUsuario = new GridBagConstraints();
		gbc_btnSelectUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_btnSelectUsuario.gridx = 2;
		gbc_btnSelectUsuario.gridy = 6;
		panel.add(btnSelectUsuario, gbc_btnSelectUsuario);
		
		jlbFooter = new JLabel("");
		add(jlbFooter, BorderLayout.SOUTH);

		cargaItem((Contrato) ControladorContrato.getInsctance().findFirst());
	}
	
	
	
	//===================== CUSTOMIZABLE ========================//
	
	/**
	 * 
	 * @return
	 */
	private JFormattedTextField getJFormattedTextFieldDatePersonalizado() {
		 jftf = new JFormattedTextField( new JFormattedTextField.AbstractFormatter() {
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
					jftf.setBackground(Color.white);
					return sdf.parse(text);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error en la fecha");
					jftf.setBackground(Color.red);
					
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
			
			this.currentContrato = c;
			
			this.jtfDescripcion.setText(this.currentContrato.getDescripcion());
			this.jftf.setText(GuiUtils.getFormattedStringFromDate("dd/MM/yyyy", this.currentContrato.getFechaFirma()));
			this.jspLimite.setValue(this.currentContrato.getLimite());
			
			this.jslSaldo.setMaximum((int) this.currentContrato.getLimite());
			this.jslSaldo.setMinimum(0);
			this.jslSaldo.setValue((int) this.currentContrato.getSaldo());
			this.showSliderBarDescription();
			
			this.jtfTipoContrato.setText(this.currentContrato.getTipocontrato().toString());
			this.jtfUsuario.setText(this.currentContrato.getUsuario().toString());
		}	
	}
	
	/**
	 * 
	 */
	private void showSliderBarDescription() {
		this.jlbSaldo.setText(this.jslSaldo.getValue() + " de " + this.jslSaldo.getMaximum());
	}
	
	
	
	
	
	//===================== BUTTONS ========================//
	
	/**
	 * 
	 */
	private void newEntity() {
		this.currentContrato = new Contrato();
		this.currentContrato.setId(0);
		this.currentContrato.setTipocontrato((Tipocontrato) ControladorTipoContrato.getInsctance().findFirst());
		this.currentContrato.setUsuario((Usuario) ControladorUsuario.getInsctance().findFirst());
	
		cargaItem(currentContrato);
	}
	
	/**
	 * 
	 */
	private void saveEntity() {
		this.currentContrato.setDescripcion(jtfDescripcion.getText());
		this.currentContrato.setFechaFirma(GuiUtils.getDateFromFormattedString("dd/MM/yyyy", this.jftf.getText()));
		this.currentContrato.setLimite(((Number) jspLimite.getValue()).intValue());
		this.currentContrato.setSaldo(this.jslSaldo.getValue());
		
		
		try {
			ControladorContrato.getInsctance().save(currentContrato);
			JOptionPane.showMessageDialog(null, "Guardado correctamente");
			jlbFooter.setText("se ha guardado");
			
		} catch (Exception e) {
			jlbFooter.setText("Error al guardar");
			jlbFooter.setBackground(Color.red);
		}
		
	}
	
	/**
	 * 
	 */
	private void deleteEntity() {
		try {
			String respuestas[] = new String[] {"Sí", "No"};
			int opcionElegida = JOptionPane.showOptionDialog(
					null, 
					"¿Realmente desea eliminar el registro?", 
					"Eliminación de fabricante", 
			        JOptionPane.DEFAULT_OPTION, 
			        JOptionPane.WARNING_MESSAGE, 
			        null, respuestas, 
			        respuestas[1]);
		    
			if(opcionElegida == 0) {
				ControladorContrato.getInsctance().deleteEntidad(currentContrato);
		    	  
		    	  // Decido qué registro voy a mostrar en pantalla.
		    	  // Voy a comprobar si existe un anterior, si existe lo muestro
		    	  // Si no existe anterior compruebo si existe siguiente, 
		    	  // si existe lo muestro. En caso contrario, no quedan registros
		    	  // así que muestro en blanco la pantalla
		    	  this.currentContrato = (Contrato) ControladorContrato.getInsctance().findPrevious(this.currentContrato);
		    	  if (this.currentContrato != null) { // Existe un anterior, lo muestro
		    		  cargaItem(currentContrato);
		    	  }
		    	  else {
		    		  this.currentContrato = (Contrato) ControladorContrato.getInsctance().findNext(this.currentContrato);
			    	  if (this.currentContrato != null) { // Existe un anterior, lo muestro
			    		  cargaItem(currentContrato);
			    	  }
		    		  else { // No quedan registros en la tabla
		    			  newEntity();
		    		  }
		    	  }
		      }
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
		
	
		
	
	

}

package mavenContratosExamenLike;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import views.PanelGestionContrato;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelGestionContrato panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		panel = new PanelGestionContrato();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panel);
	}

}

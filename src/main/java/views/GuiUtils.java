package views;

import java.awt.Component;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JPanel;


public class GuiUtils {

	/**
	 * 
	 * @param dateFormat
	 * @param date
	 * @return
	 */
	public static String getFormattedStringFromDate (String dateFormat, Date date) {
		try {
			return new SimpleDateFormat(dateFormat).format(date);
		}
		catch (Exception ex) {
			System.out.println("Unable to format date: " + date + " with format: " + dateFormat);
			return "";
		}
	}
	
	
	/**
	 * 
	 * @param dateFormat
	 * @param date
	 * @return
	 */
	public static Date getDateFromFormattedString (String dateFormat, String strDate) {
		try {
			return new SimpleDateFormat(dateFormat).parse(strDate);
		}
		catch (Exception ex) {
			System.out.println("Unable to parse string: " + strDate + " to java.util.Date with format: " + dateFormat);
			return null;
		}
	}
	
	
	/**
	 * 
	 * @param pane
	 * @param dialogTitle
	 */
	public static JDialog showCenteredPaneIntoJDialog(JPanel pane, String dialogTitle) {
		JDialog dialog = new JDialog();
		// El usuario no puede redimensionar el diálogo
		dialog.setResizable(true);
		// título del díalogo
		dialog.setTitle(dialogTitle);
		// Introducimos el panel creado sobre el diálogo
		dialog.setContentPane(pane);
		// Empaquetar el diílogo hace que todos los componentes ocupen el espacio que deben y el lugar adecuado
		dialog.pack();
		// El usuario no puede hacer clic sobre la ventana padre, si el Diálogo es modal
		dialog.setModal(true);
		// Centro el diálogo en pantalla
		dialog.setLocation(
				(Toolkit.getDefaultToolkit().getScreenSize().width)/2 - dialog.getWidth()/2, 
				(Toolkit.getDefaultToolkit().getScreenSize().height)/2 - dialog.getHeight()/2);
		// Muestro el diálogo en pantalla
		dialog.setVisible(true);
		
		return dialog;
	}

	
	/**
	 * 
	 */
	public static void closeDialogFromInnerJPanel(JPanel pane) {
		JDialog dialog = getParentDialog(pane);
        if (dialog != null) {
            dialog.dispose(); // Cerrar el JDialog
        }
	}
	
	
    /**
     * Método para encontrar el JDialog ancestro
     * @param component
     * @return
     */
    private static JDialog getParentDialog(Component component) {
        if (component == null) {
            return null;
        }
        if (component instanceof JDialog) {
            return (JDialog) component;
        }
        return getParentDialog(component.getParent());
    }

}

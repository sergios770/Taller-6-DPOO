package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelEditarRestaurante extends JPanel
{
    private JTextField txtNombre;
    private JComboBox<String> cbbCalificacion;
    private JComboBox<String> cbbVisitado;

    public PanelEditarRestaurante()
    {
        setLayout(new GridLayout(3, 2, 5, 5));

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Calificación:"));
        cbbCalificacion = new JComboBox<>(new String[]{"1", "2", "3", "4", "5"});
        add(cbbCalificacion);

        add(new JLabel("¿Visitado?"));
        cbbVisitado = new JComboBox<>(new String[]{"Sí", "No"});
        add(cbbVisitado);
    }

    public boolean getVisitado()
    {
        return cbbVisitado.getSelectedItem().equals("Sí");
    }

    public int getCalificacion()
    {
        return Integer.parseInt((String) cbbCalificacion.getSelectedItem());
    }

    public String getNombre()
    {
        return txtNombre.getText().trim();
    }
}


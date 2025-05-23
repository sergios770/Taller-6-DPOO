package uniandes.dpoo.swing.interfaz.principal;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelLista extends JPanel implements ListSelectionListener
{
    /**
     * El widget donde se muestra la lista de restaurantes
     */
    private JList<Restaurante> listaDeRestaurantes;

    /**
     * El modelo de datos que se muestra en la lista de restaurantes
     */
    private DefaultListModel<Restaurante> dataModel;

    /**
     * La ventana principal que contiene a este panel
     */
    private VentanaPrincipal ventanaPrincipal;

    public PanelLista(VentanaPrincipal ventanaPrincipal)
    {
        this.ventanaPrincipal = ventanaPrincipal;
        setBorder(new TitledBorder("Restaurantes"));
        setLayout(new BorderLayout());

        dataModel = new DefaultListModel<>();
        listaDeRestaurantes = new JList<>(dataModel);
        listaDeRestaurantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaDeRestaurantes.addListSelectionListener(this);

        JScrollPane scroll = new JScrollPane(listaDeRestaurantes);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scroll, BorderLayout.CENTER);
    }

    /**
     * Actualiza la lista de restaurantes que se muestran en el panel.
     * @param restaurantes Lista de restaurantes a mostrar
     */
    public void actualizarLista(List<Restaurante> restaurantes)
    {
        dataModel.clear();
        for (Restaurante r : restaurantes)
        {
            dataModel.addElement(r);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        if (!e.getValueIsAdjusting())
        {
            Restaurante seleccionado = listaDeRestaurantes.getSelectedValue();
            if (seleccionado != null)
            {
                ventanaPrincipal.cambiarRestauranteSeleccionado(seleccionado);
            }
        }
    }

    /**
     * Cambia el restaurante seleccionado en la lista
     * @param restaurante Restaurante a seleccionar
     */
    public void seleccionarRestaurante(Restaurante restaurante)
    {
        listaDeRestaurantes.setSelectedValue(restaurante, true);
    }
}

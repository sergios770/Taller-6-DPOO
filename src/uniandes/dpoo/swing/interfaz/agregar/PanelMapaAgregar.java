package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class PanelMapaAgregar extends JPanel
{
    private JLabel labMapa;
    private int xSeleccionado = -1;
    private int ySeleccionado = -1;

    public PanelMapaAgregar()
    {
        setLayout(null);
        labMapa = new JLabel(new ImageIcon("./imagenes/mapa.png"));
        labMapa.setBounds(0, 0, 500, 500); // ajusta el tamaño según tu imagen
        labMapa.setBorder(new LineBorder(Color.BLACK));
        add(labMapa);

        labMapa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                xSeleccionado = e.getX();
                ySeleccionado = e.getY();
                repaint();
            }
        });

        setPreferredSize(labMapa.getPreferredSize());
    }

    public int getXSeleccionado()
    {
        return xSeleccionado;
    }

    public int getYSeleccionado()
    {
        return ySeleccionado;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (xSeleccionado >= 0 && ySeleccionado >= 0)
        {
            g.setColor(Color.RED);
            g.fillOval(xSeleccionado - 5, ySeleccionado - 5, 10, 10);
        }
    }
}


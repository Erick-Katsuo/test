package appmaxi;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Actividad2 extends JFrame {
    
    static final boolean REDIMENSIONABLE = true;
    
    int valorTiempo = 0;
    
    //Declaro Objetos.
    JSlider velocidad, distancia;
    JLabel Labelvelocidad, Labeldistancia, Labeltiempo;

    //Constructor.
    public Actividad2() {
        super("Tiempo");
        setSize(1050, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(REDIMENSIONABLE);

        //FlowLayout
        setLayout(new GridLayout(1, 2));

        //Objetos.
        setLookAndFeel();
        //Velocidad
        velocidad = new JSlider(JSlider.VERTICAL, 0, 200, 5);
        velocidad.setMajorTickSpacing(25);
        velocidad.setMinorTickSpacing(5);
        velocidad.setPaintTicks(true);
        velocidad.setFont(new Font("Serif", Font.ITALIC, 12));
        velocidad.setPaintLabels(true);
        //Distancia
        distancia = new JSlider(JSlider.VERTICAL, 0, 400, 5);
        distancia.setMajorTickSpacing(25);
        distancia.setMinorTickSpacing(5);
        distancia.setPaintTicks(true);
        distancia.setPaintLabels(true);
        distancia.setFont(new Font("Serif", Font.ITALIC, 12));
        //Etiqueta
        Labelvelocidad = new JLabel("Velocidad: 0");
        Labeldistancia = new JLabel("Distancia: 0");
        Labeltiempo = new JLabel("Tiempo: 0");
        //Muestra la Ventana.
        setVisible(true);
        add(velocidad);
        add(distancia);

        distancia.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int distanciavalue = distancia.getValue();
                Labeldistancia.setText("Distancia: " + distanciavalue);

                valorTiempo = distancia.getValue() / velocidad.getValue();

                Labeltiempo.setText("Tiempo: " + valorTiempo);
            }
        });
        
        velocidad.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int velocidadvalue = velocidad.getValue();
                Labelvelocidad.setText("Velocidad: " + velocidadvalue);

                valorTiempo = distancia.getValue() / velocidad.getValue();

                Labeltiempo.setText("Tiempo: " + valorTiempo);
            }
        });

        add(Labelvelocidad);
        add(Labeldistancia);
        add(Labeltiempo);
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {

            //No hacer nada
        }
    }

    /*public class event {
    public void calcularVelocidad (ChangeEvent e){

        int value = distancia.getValue();
        
        value = distancia.getValue() / velocidad.getValue();

        Labeltiempo.setText("Tiempo: " +value);
    
} 
    }*/
    public static void main(String[] args) {
        //llamara al contructor
        SwingUtilities.invokeLater(Actividad2::new);

    }
}

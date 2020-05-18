package appmaxi;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Actividad2 extends JFrame {

    //Declaro Objetos.
    JSlider velocidad, distancia;
    JLabel Labelvelocidad, Labeldistancia, Labeltiempo;

    //Constructor.
    public Actividad2() {
        super("Tiempo");

        setSize(1050, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

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
        add(Labelvelocidad);
        add(Labeldistancia);
        add(Labeltiempo);
        
        //uso el objeto velocidad para obtner el evento del slider
        velocidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });
        
    }
    
    
    
    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {

            //No hacer nada
        }
    }
    
    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {                                      
        // TODO add your handling code here:
        //calcularVelocidad();
        System.out.println("FUNCIONA");
    } 
    
    public void calcularVelocidad(){
        // x = x_inicial + velocidad * t
        // x / v = t
        int resultadoTiempo = 0;
        
        resultadoTiempo = distancia.getValue() / velocidad.getValue();
        
        //Labeltiempo.setText( String.valueOf(resultadoTiempo));
        
        Labeltiempo.setText("Tiempo"+ resultadoTiempo);
        
    }
    
    
    public static void main(String[] args) {
        //llamara al contructor
        new Actividad2();
    }
}

package Forma;
 
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.*;
 
public class Forma extends JFrame {
 
    //CREAMOS LAS VARIABLES QUE VAMOS A USAR
    private JPanel panel1;
    private JTextField fNumero = new JTextField(9);
    private JButton bDibujar = new JButton("Dibujar");
    private JButton bLimpiar = new JButton("Limpiar");
    private int numero = 0;
 
    //ESTO INICIA LA APLICACION
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Forma frame = new Forma();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
 
    //CREAMOS EL JFRAME CON SU TAMAÑO JUNTO CON EL PANEL
    public Forma() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        panel1 = new JPanel();
        panel1.setLayout(null);
        setBounds(0, 0, 800, 600);
 
        //CREAMOS EL BOTÓN Dibujar
        bDibujar.setBounds(125, 125, 100, 30);
        //LO AÑADIMOS AL PANEL
        panel1.add(bDibujar);
        //ESTO PROVOCARA QUE SE EJECUTE EL MÉTODO 'PAINT'
        bDibujar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
 
                repaint();
            }
        });
 
        //CREAMOS EL BOTON LIMPIAR
        bLimpiar.setBounds(250, 125, 100, 30);
        //LO AÑADIMOS AL PANEL
        panel1.add(bLimpiar);
        bLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                numero = 0;
                fNumero.setText(String.valueOf(0));
                repaint();
            }
        });
 
        //CREAMOS EL TEXTFIELD
        fNumero.setBounds(200, 50, 50, 20);
        fNumero.setText(String.valueOf(numero));
        //LO AÑADIMOS AL PANEL
        panel1.add(fNumero);
 
        //APLICAMOS EL PANEL
        setContentPane(panel1);
    }
 
    public void paint(Graphics grph) {
        super.paint(grph);
        //TOMAMOS EL VALOR DEL JTEXTFIELD
        numero = Integer.parseInt(fNumero.getText());
 
        //CREAMOS DOS VARIABLES DEL TAMAÑO DE LOS CIRCULOS
        int largo = 50;
        int alto = 50;
 
        //SI EL VALOR DEL JTF ES 0 NO HARÁ NADA
        //SI ES MAYOR DE 0
        if (numero > 0) {
            //CREA UN BUCLE QUE DIBUJARÁ TANTOS CIRCULITOS COMO EL NÚMEO DEL JTF
            for (int x = 0; x < numero; x++) {
 
                //CREAMOS UN COLOR ALEATORIO MEDIANTE AZUL VERDE ROJO
                int r = (int) (Math.round(Math.random() * 255));
                int g = (int) (Math.round(Math.random() * 255));
                int b = (int) (Math.round(Math.random() * 255));
 
                Color col = new Color(r, g, b);
 
                //LE DAMOS COLOR
                grph.setColor(col);
                //CREAMOS DOS VARIABLES CON INT ALEATORIOS
                int xAleatorio = (int) (Math.random() * 450 + 1);
                int yAleatorio = (int) (Math.random() * 450 + 1);
                //DIBUJAMOS LOS CIRCULOS
                grph.fillOval(xAleatorio, yAleatorio, 20, 20);
            }
        }
 
    }
 
}
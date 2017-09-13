package examen;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Convertidor extends JFrame {

    double resultado = 0;
    boolean OpeNue = true;
    String operacion;
    JPanel panelIzquierdo = new JPanel();
    JPanel panelDerecho = new JPanel();
    JTextField pantalla = new JTextField("0", 10);

    public Convertidor() {

        super();
        setSize(450, 500);
        setResizable(false);
        setTitle("Convertidor");

        JPanel pane = (JPanel) this.getContentPane();
        pane.setLayout(new BorderLayout());

        pantalla.setEditable(false);
        pane.add("North", pantalla);

        panelIzquierdo.setLayout(new GridLayout(4, 3));

        for (int i = 9; i >= 0; i--) {
            BotonNume("" + i);
        }

        BotonNume(".");
        pane.add("Center", panelIzquierdo);

        panelDerecho.setLayout(new GridLayout(7, 2));
        BotonOpe("CE");
        BotonOpe("Convertir");
        pane.add("East", panelDerecho);

    }

    private void BotonNume(String digito) {
        JButton boton = new JButton();
        boton.setText(digito);
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent evt) {
                JButton btn1 = (JButton) evt.getSource();
                numeroPulsado(btn1.getText());
            }
        });

        panelIzquierdo.add(boton);
    }

    private void BotonOpe(String ope) {
        JButton btn = new JButton(ope);
        btn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent evt) {
                JButton btn2 = (JButton) evt.getSource();
                operacionPulsado(btn2.getText());
            }
        });

        panelDerecho.add(btn);
    }

    private void numeroPulsado(String num) {
        if (pantalla.getText().equals("0")) {
            pantalla.setText(num);
        } else {
            pantalla.setText(pantalla.getText() + num);
        }
        OpeNue = false;
    }

    private void operacionPulsado(String tecla) {
        if (tecla.equals("Convertir")) {
            try {
                resultado = Double.parseDouble(String.valueOf(pantalla.getText())) / 19;
                if(pantalla.getText().equals("0"))
                    pantalla.setText("0");
                else
                pantalla.setText(String.valueOf(resultado));
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Dato invalido");
                pantalla.setText("0");
            }
        } else if (tecla.equals("CE")) {
            resultado = 0;
            pantalla.setText("0");
        }
        OpeNue = true;
    }

}

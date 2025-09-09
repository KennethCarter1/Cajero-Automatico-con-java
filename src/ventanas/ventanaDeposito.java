package ventanas;
import javax.swing.*;
import Conexion.validacion;

public class ventanaDeposito extends JFrame {
    private JLabel ingreseMonto;
    private JTextField txtMonto;
    private JButton btn_confirmacion, btn_salir;

    public ventanaDeposito(String pinIngresado){
        setTitle("Cajero Automático");
        setSize(400, 200);
        setLayout(null); // Para usar setBounds
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        validacion validar = new validacion();

        ingreseMonto = new JLabel("Ingrese el Monto");
        txtMonto = new JTextField();
        btn_confirmacion = new JButton("Confirmar");
        btn_salir = new JButton("Salir");

        ingreseMonto.setBounds(150,30,150,20);
        txtMonto.setBounds(150,60,100,20);
        btn_confirmacion.setBounds(70, 100, 100, 30);
        btn_salir.setBounds(200, 100, 100, 30);

        add(ingreseMonto);
        add(txtMonto);
        add(btn_confirmacion);
        add(btn_salir);

        btn_confirmacion.addActionListener(new java.awt.event.ActionListener() {
          
            public void actionPerformed(java.awt.event.ActionEvent e) {
                try {
                    double montoNuevo = Double.parseDouble(txtMonto.getText());

                    int verificacion = JOptionPane.showConfirmDialog(
                    null,
                    "¿Seguro que quieres depositar este monto?",
                    "Confirmar deposito",
                    JOptionPane.YES_NO_OPTION
                );

                    if(verificacion == JOptionPane.YES_OPTION){
                        boolean verificar = validar.depositarDinero(pinIngresado, montoNuevo);

                        if(verificar){
                            JOptionPane.showMessageDialog(null,"Depositado con exito.");
                            dispose(); 
                            new principal(pinIngresado);
                        }else{
                            JOptionPane.showMessageDialog(null,"Error al depositar.");
                            dispose(); 
                            new principal(pinIngresado);
                        }
                        
                    }

                    

                
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(ventanaDeposito.this, "Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
                    txtMonto.setText("");
                }

                        }
                    });

        btn_salir.addActionListener(new java.awt.event.ActionListener() {
          
            public void actionPerformed(java.awt.event.ActionEvent e) {
                    dispose(); 
                    new principal(pinIngresado);
                }
                
            });
        
        setVisible(true);

    }
}

package ventanas;
import javax.swing.*;
import Conexion.validacion;

public class login extends JFrame {
    private JLabel lblPin, lblCajero;
    private JPasswordField txtPin;
    private JButton btnIngresar, btnSalir;

    public login() {
        setTitle("Cajero Automático");
        setSize(400, 250);
        setLayout(null); // Para usar setBounds
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

 
        lblCajero = new JLabel("Cajero Automático");
        lblPin = new JLabel("Ingrese su PIN:");
        txtPin = new JPasswordField();
        btnIngresar = new JButton("Ingresar");
        btnSalir = new JButton("Salir");


        lblCajero.setBounds(120, 20, 200, 30);
        lblPin.setBounds(50, 70, 120, 25);
        txtPin.setBounds(180, 70, 120, 25);
        btnIngresar.setBounds(70, 130, 100, 30);
        btnSalir.setBounds(200, 130, 100, 30);

    
        add(lblCajero);
        add(lblPin);
        add(txtPin);
        add(btnIngresar);
        add(btnSalir);

        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                // Obtener el PIN ingresado
                String pinIngresado = new String(txtPin.getPassword());

                if (pinIngresado.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese su PIN");
                    return;
                }

                // Crear objeto de validación (CuentaDAO)
                validacion cuentaDAO = new validacion(); // si tu clase está en Conexion.validacion

                // Validar PIN
                if (cuentaDAO.validarPin(pinIngresado)) {
                    JOptionPane.showMessageDialog(null, "PIN correcto. Bienvenido!");
                    dispose(); 
                    new principal(pinIngresado);

    
                } else {
                    JOptionPane.showMessageDialog(null, "PIN incorrecto");
                    txtPin.setText("");
                }
            }
        });

        btnSalir.addActionListener(new java.awt.event.ActionListener() {
          
            public void actionPerformed(java.awt.event.ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(
                    null,
                    "¿Seguro que quieres salir?",
                    "Confirmar salida",
                    JOptionPane.YES_NO_OPTION
                );

                if (respuesta == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null,"Gracias por visitar Vuelva Pronto.");
                    System.exit(0);
                }
            }
        });

        setVisible(true);
    }
}

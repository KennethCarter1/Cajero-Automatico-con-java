package ventanas;
import javax.swing.*;
import Conexion.validacion;


public class ventanaSaldo extends JFrame{
    private JButton btn_Salir;
    private JLabel saldo;
    private Double saldoActual;

    
    public ventanaSaldo(String pinIngresado){
        setTitle("Cajero Automático");
        setSize(400, 200);
        setLayout(null); // Para usar setBounds
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        validacion validar = new validacion();

        saldoActual = validar.saldoActual(pinIngresado);


        saldo =new JLabel("Saldo: " + saldoActual + "$");

        saldo.setBounds(150,20,100,100);

        btn_Salir = new JButton("Salir");
        btn_Salir.setBounds(130, 100, 130, 30);    


        btn_Salir.addActionListener(new java.awt.event.ActionListener() {
          
            public void actionPerformed(java.awt.event.ActionEvent e) {
                dispose(); 
                new principal(pinIngresado);
            }
        });


        
        add(saldo);
        add(btn_Salir);

        setVisible(true);

    }
    
}


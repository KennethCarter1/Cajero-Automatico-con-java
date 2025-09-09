package ventanas;
import javax.swing.*;

public class principal extends JFrame{
    private JLabel bienvenido;
    private JButton btn_consultar,btn_depositar,btn_retirar, btn_Salir;

    
    public principal(String pinIngresado){
        setTitle("Cajero Automático");
        setSize(400, 250);
        setLayout(null); // Para usar setBounds
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        bienvenido = new JLabel("bienvenido Usuario");
        btn_consultar = new JButton("Consultar saldo");
        btn_depositar = new JButton("Depositar Saldo");
        btn_Salir = new JButton("Salir");
        btn_retirar = new JButton("Retirar Dinero");
        
        bienvenido.setBounds(10,1,150,20);
        btn_consultar.setBounds(1, 30, 140, 30);  
        btn_depositar.setBounds(270, 30, 130, 30);
        btn_retirar.setBounds(1, 100, 140, 30);    
        btn_Salir.setBounds(270, 100, 130, 30);    


        add(bienvenido);
        add(btn_consultar);
        add(btn_depositar);
        add(btn_Salir);
        add(btn_retirar);

        btn_consultar.addActionListener(new java.awt.event.ActionListener() {
          
            public void actionPerformed(java.awt.event.ActionEvent e) {
                dispose(); 
                new ventanaSaldo(pinIngresado);

            }
        });;

        btn_Salir.addActionListener(new java.awt.event.ActionListener() {
          
            public void actionPerformed(java.awt.event.ActionEvent e) {
                dispose(); 
                new login();

            }
        });;

        btn_depositar.addActionListener(new java.awt.event.ActionListener() {
          
            public void actionPerformed(java.awt.event.ActionEvent e) {
                dispose(); 
                new ventanaDeposito(pinIngresado);

            }
        });;

        btn_retirar.addActionListener(new java.awt.event.ActionListener() {
          
            public void actionPerformed(java.awt.event.ActionEvent e) {
                dispose(); 
                new ventanaRetiro(pinIngresado);

            }
        });;

        setVisible(true);

    }
    
}

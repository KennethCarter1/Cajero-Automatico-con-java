package Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class validacion {
    Connection conexion = ConexionBD.getConnection();

    public boolean validarPin(String pin){
        
        if(conexion != null){
            try {
                String sql = "SELECT pin FROM Cuenta WHERE pin = ?";
                PreparedStatement ps = conexion.prepareStatement(sql);
                ps.setString(1, pin); 

                ResultSet rs = ps.executeQuery();

                boolean encontrado = rs.next();

                rs.close();
                ps.close();

                return encontrado;

                
            } catch (SQLException e) {
               e.printStackTrace();
            }
        }
        return false;
    }

    public double saldoActual(String pin){
        double saldo = 0.0;
        if(conexion != null){
        try {

            String sql = "SELECT saldo FROM Cuenta WHERE pin = ? ";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, pin);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            saldo = rs.getDouble("saldo");
            }
            
            rs.close();
            ps.close();

            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        return saldo;
    }

    public boolean depositarDinero(String pin, double newSaldo){
        if (conexion != null) {
            try {
                // validar que el monto sea positivo
                if (newSaldo <= 0) {
                    return false; // no se permite depósito con monto negativo o cero
                }

                double antiguoSaldo = saldoActual(pin);
                double nuevoSaldo = antiguoSaldo + newSaldo;

                String sql = "UPDATE Cuenta SET saldo = ? WHERE pin = ?";
                PreparedStatement ps = conexion.prepareStatement(sql);
                ps.setDouble(1, nuevoSaldo);
                ps.setString(2, pin);

                int deposito = ps.executeUpdate();
                ps.close();
                return deposito > 0;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    public boolean retirarDinero(String pin, double retiroSaldo) {
        if (conexion != null) {
            try {
                double saldoAntiguo = saldoActual(pin);

              
                if (retiroSaldo <= 0) {
                    return false; 
                }


                if (retiroSaldo > saldoAntiguo) {
                    return false; 
                }

                double nuevoSaldo = saldoAntiguo - retiroSaldo;

                String sql = "UPDATE Cuenta SET saldo = ? WHERE pin = ?";
                PreparedStatement ps = conexion.prepareStatement(sql);
                ps.setDouble(1, nuevoSaldo);
                ps.setString(2, pin);

                int retiro = ps.executeUpdate();
                ps.close();
                return retiro > 0;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }



}

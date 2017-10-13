package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
    
    Connection conexion;
    
    public Connection getConexion(){
        return conexion;
    }
    
    public boolean crearConexion(){
       try {
          Class.forName("com.mysql.jdbc.Driver");
          conexion = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","");
       } catch (SQLException ex) {
          ex.printStackTrace();
          return false;
       } catch (ClassNotFoundException ex) {
          ex.printStackTrace();
          return false;
       }

       return true;
    }
    
    public boolean ejecutarSQL(String sql){
       try {
          Statement sentencia = conexion.createStatement();
          sentencia.executeUpdate(sql);
       } catch (SQLException ex) {
          ex.printStackTrace();
       return false;
       }

       return true;
    }
    
    public ResultSet ejecutarSQLSelect(String sql){
       ResultSet resultado;
       try {
          Statement sentencia = conexion.createStatement();
          resultado = sentencia.executeQuery(sql);
       } catch (SQLException ex) {
          ex.printStackTrace();
          return null;
       }

       return resultado;
    }
    
}

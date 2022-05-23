package com.baseutim;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.Statement;

public class Conex {
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/dbuser";
    private String user;
    private String paswd;
    private Connection mysqlCon = null;
    private Statement stmt;
    private ResultSet res;

    public Conex(){
        user = "usermag";
        paswd = "iot22";
    }
    public boolean setConexion(){
        try {
            Class.forName(driver);
            mysqlCon = DriverManager.getConnection(url, user, paswd);
            stmt = (Statement) mysqlCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null," " + ex.toString(),"Conexión", 2);
            return false;
          }catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, " " + e.toString(),"Del driver", 2);
            return false;
         }
        return true;
    }
    public ResultSet getDato(String sqlDato){
        setConexion();
        try {
          stmt = (Statement) mysqlCon.createStatement();
          res = ((java.sql.Statement) stmt).executeQuery(sqlDato);
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, " " + ex.toString(),"Del driver", 2);
        }
        return res;
      }
    public void setCerrar(){
        try {
          mysqlCon.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " " + ex.toString(),"Del driver", 2);
        }
      }
}

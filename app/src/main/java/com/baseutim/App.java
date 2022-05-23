package com.baseutim;
import java.sql.*;

/**
 * Hello world!
 *
 */
public class App{
    public static void main( String[] args )  {
        try {
        Conex cdb = new Conex();
        boolean cddbC = cdb.setConexion();
        String strSql = "select * from alumnos";
        ResultSet rs = cddbC.getDato(strSql);
        while (rs.next())
        //Se cierra la conexión 
         cddbC,setCerrar();
      } catch (Exception e) {
    //Imprimir errores 
    System.out.println(e);
}
    }
}

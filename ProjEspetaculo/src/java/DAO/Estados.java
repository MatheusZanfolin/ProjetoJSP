/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBO.Estado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author u16189
 */
public class Estados extends Dao {
    private final static String TODOS_OS_ESTADOS = "SELECT * FROM Estado";
    
    public Estados() throws Exception { 
        super();
    }
    
    public static ArrayList<Estado> getEstados() throws SQLException, Exception {
        ArrayList<Estado> estados = new ArrayList<>();
        
        cmd = conn.prepareStatement(TODOS_OS_ESTADOS);
        
        ResultSet rs = cmd.executeQuery();
        
        while (rs.next())
            estados.add(new Estado(rs.getInt("codEstado"), rs.getString("nome")));
        
        return estados;
    }
}
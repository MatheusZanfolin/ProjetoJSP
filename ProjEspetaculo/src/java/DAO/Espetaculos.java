/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBO.Espetaculo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author u16189
 */
public class Espetaculos extends Dao {
    private final static String TODOS_OS_ESPETACULOS = "SELECT * FROM Espetaculo";
    private final static String DATAS_ESPETACULO     = "SELECT dataEspetaculo FROM DataEspetaculo WHERE codEspetaculo = ?";
    
    public Espetaculos() throws Exception {
        super();
    }
    
    @SuppressWarnings("empty-statement")
    public static ArrayList<Espetaculo> getEspetaculos() throws SQLException, Exception {
        ArrayList<Espetaculo> espetaculos = new ArrayList<>();
        
        cmd = conn.prepareStatement(TODOS_OS_ESPETACULOS);
        
        ResultSet rs = cmd.executeQuery();
        
        while (rs.next())
            espetaculos.add(new Espetaculo(rs.getInt("codEspetaculo"), rs.getString("nome"), rs.getInt("classificacaoIndicativa"), getDatasEspetaculo(rs.getInt("codEspetaculo"))));
        
        return espetaculos;
    }
    
    private static ArrayList<Timestamp> getDatasEspetaculo(int codEspetaculo) throws SQLException {
        ArrayList<Timestamp> datas = new ArrayList<>();
        
        cmd = conn.prepareStatement(DATAS_ESPETACULO);
        
        cmd.setInt(1, codEspetaculo);
        
        ResultSet rs = cmd.executeQuery();
        
        while (rs.next())
            datas.add(rs.getTimestamp("data"));
        
        return datas;
    }
}

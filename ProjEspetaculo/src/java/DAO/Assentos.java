/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBO.Assento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author u16189
 */
public class Assentos extends Dao {
    private final static String TODOS_OS_ASSENTOS    = "SELECT * FROM Assento";
    private final static String OCUPACOES_DO_ASSENTO = "SELECT ocupado FROM AssentoOcupado WHERE dataEspetaculo = ? AND codAssento = ?";
    private final static String TODAS_AS_DATAS       = "SELECT * FROM DataEspetaculo";
    private final static String OCUPAR_ASSENTO       = "UPDATE AssentoOcupado SET ocupado = 1 WHERE codAssento = ?";    
    
    public Assentos() throws Exception {
        super();
    }
    
    public static ArrayList<Assento> getAssentos() throws SQLException, Exception{
        ArrayList<Assento> assentos = new ArrayList<>();
        
        cmd = conn.prepareStatement(TODOS_OS_ASSENTOS);
        
        ResultSet rs = cmd.executeQuery();
        
        while (rs.next())
            assentos.add(new Assento(rs.getInt("codAssento"), getOcupacoes(rs.getInt("codAssento"))));
        
        return assentos;
    }
    
    public static int ocupar(int codAssento) throws Exception {
        if (codAssento < 1)
            throw new Exception("Assentos: ocupação de assento com código inválido.");
        
        cmd = conn.prepareStatement(OCUPAR_ASSENTO);
        
        cmd.setInt(1, codAssento);
        
        return cmd.executeUpdate();
    }

    private static Map<Timestamp, Boolean> getOcupacoes(int codAssento) throws SQLException {
        HashMap<Timestamp, Boolean> ocupacoes = new HashMap<>();
        
        ArrayList<Timestamp> datasEspetaculo = new ArrayList<>();
        
        datasEspetaculo = getDatasEspetaculos();
        
        Iterator<Timestamp> datas = datasEspetaculo.iterator();
        
        while (datas.hasNext())
        {
            Timestamp dataAtual = datas.next();
            
            cmd = conn.prepareStatement(OCUPACOES_DO_ASSENTO);
            
            cmd.setTimestamp(1, dataAtual);
            cmd.setInt(2, codAssento);
            
            ResultSet rs = cmd.executeQuery();
            
            while (rs.next())
                ocupacoes.put(dataAtual, rs.getBoolean("ocupado"));
        }
        
        return ocupacoes;
    }

    private static ArrayList<Timestamp> getDatasEspetaculos() throws SQLException {
        ArrayList<Timestamp> datas = new ArrayList<>();
        
        cmd = conn.prepareStatement(TODAS_AS_DATAS);
        
        ResultSet rs = cmd.executeQuery();
        
        while (rs.next())
            datas.add(rs.getTimestamp("dataEspetaculo"));
        
        return datas;
    }
}

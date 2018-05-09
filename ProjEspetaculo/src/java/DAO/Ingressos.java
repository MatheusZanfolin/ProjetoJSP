/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBO.TipoIngresso;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author u16189
 */
public class Ingressos extends Dao {
    private final static String QUANTOS_INGRESSOS = "SELECT qtde FROM QtdeIngressoApresentacao WHERE dataEspetaculo = ?";
    
    public Ingressos() throws Exception {
        super();
    }
    
    public static int registrarIngresso(String emailEspectador, Timestamp dataEspetaculo, TipoIngresso tipo) throws SQLException {
        CallableStatement procedimento = conn.prepareCall("{call compraIngresso_sp(?,?,?)}");
        
        procedimento.setString(1, emailEspectador);
        procedimento.setTimestamp(2, dataEspetaculo);
        procedimento.setInt(3, tipo.getCodTipo());
        
        return procedimento.executeUpdate();
    }
    
    public static int quantosIngressos(Timestamp dataApresentacao) throws Exception {
        if (dataApresentacao == null)
            throw new Exception("Ingressos: verificação de quantidade total de ingressos com data de apresentação nula.");
        
        int quantos = -1;
        
        cmd = conn.prepareStatement(QUANTOS_INGRESSOS);
        
        cmd.setTimestamp(1, dataApresentacao);
        
        ResultSet rs = cmd.executeQuery();
        
        if (rs.next())
            quantos = rs.getInt("qtde");
        else
            throw new Exception("Ingressos: verificação da quantidade total de ingressos não encontrou nenhum espetáculo na data apresentada");
        
        return quantos;
    }
}
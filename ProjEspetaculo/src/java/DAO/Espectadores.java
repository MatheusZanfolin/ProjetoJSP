/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBO.Espectador;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author u16189
 */
public class Espectadores extends Dao {
    private final static String INSERIR_ESPECTADOR = "INSERT INTO Espectador VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final static String VERIFICA_USUARIO   = "SELECT * FROM Espectador WHERE email = ?";
    
    public Espectadores() throws Exception {
        super();
    }
    
    public static int inserirEspectador(Espectador e) throws SQLException, Exception {
        if (e == null)
            throw new Exception("Espectadores: inserção de espectador nulo.");
        
        cmd = conn.prepareStatement(INSERIR_ESPECTADOR);
        
        cmd.setString(1, e.getEmail());
        cmd.setString(2, e.getSenha());
        cmd.setString(3, e.getNome());
        cmd.setString(4, e.getCpf());
        cmd.setDate(5, e.getNascimento());
        cmd.setBoolean(6, e.isMasculino());
        cmd.setString(7, e.getTelefone());
        cmd.setString(8, e.getCep());
        cmd.setString(9, e.getEndereco());
        cmd.setString(10, e.getNumero());
        cmd.setString(11, e.getComplemento());
        cmd.setString(12, e.getBairro());
        cmd.setString(13, e.getCidade());
        cmd.setInt(14, e.getEstado().getCodEstado());
        
        return cmd.executeUpdate();
    }
    
    public boolean isCadastrado(String email) throws SQLException {
        if (email == null)
            return false;
        
        boolean cadastrado = false;
        
        cmd = conn.prepareStatement(VERIFICA_USUARIO);
        
        cmd.setString(1, email);
        
        ResultSet rs = cmd.executeQuery();
        
        cadastrado = rs.next();
        
        return cadastrado;
    }
}

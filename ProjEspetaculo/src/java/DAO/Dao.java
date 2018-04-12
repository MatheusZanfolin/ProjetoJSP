/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author u16189
 */
public class Dao {
    protected Connection conn;
    protected PreparedStatement  cmd;
    private boolean preparado;

    public Dao () throws Exception
    {
        try
        {
            Class.forName ("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }
        catch (ClassNotFoundException e)
        {
            throw new Exception ("BD: erro de driver");
        }

        try
        {
            conn = DriverManager.getConnection ("jdbc:sqlserver://regulus:1433;databasename=bdjsp", "JSP1RB16189", "JSP1RB16189");
        }
        catch (SQLException e)
        {
            throw new Exception ("BD: erro de conexao");
        }
        
        this.preparado = false;
    }

    public int execComando (String cmdSQL) throws Exception
    {
        if (!this.preparado)
            throw new Exception ("BD: execucao de comando sem preparação de statement");
        
        int resultado = -1;
        
        try
        {
            resultado = this.cmd.executeUpdate (cmdSQL);
        }
        catch (SQLException e)
        {
            throw new Exception ("BD: erro de execucao de comando");
        }
        
        this.preparado = false;
        
        return resultado;
    }

    public ResultSet execConsulta (String qrySQL) throws Exception
    {
        if (!this.preparado)
            throw new Exception ("BD: execucao de consulta sem preparação de statement");
        
        ResultSet resultado = null;

        try
        {
            resultado = this.cmd.executeQuery (qrySQL);
        }
        catch (SQLException e)
        {
            throw new Exception ("BD: erro de execucao de consulta");
        }

        this.preparado = false;
        
        return resultado;
    }

    public void fecharConexao () throws Exception
    {
        try
        {
            this.cmd.close ();
            this.cmd = null;

            this.conn.close ();
            this.conn = null;
        }
        catch (SQLException e)
        {
            throw new Exception ("BD: erro de fechamento de conexão");
        }
    }
    
    protected void preparar(String sql) throws Exception {
        if (sql == null)
            throw new Exception ("BD: erro de preparação de sql.");
        
        cmd = conn.prepareStatement(sql);
        
        this.preparado = true;
    }
    
    public boolean isPreparado() {
        return this.preparado;
    }
}

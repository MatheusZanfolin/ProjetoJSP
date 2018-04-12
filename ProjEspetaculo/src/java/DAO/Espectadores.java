/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 * @author u16189
 */
public class Espectadores extends Dao {
    public Espectadores() throws Exception {
        super();
    }
    
    public int incluirEspectador() throws Exception {
        this.preparar("INSERT INTO Espectador VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        
        this.cmd.setString(1 , "");
        this.cmd.setString(2 , "");
        this.cmd.setString(3 , "");
        this.cmd.setString(4 , "");
        this.cmd.setDate(5, new Date(0));
        this.cmd.setBoolean(6 , false);
        this.cmd.setString(7 , "");
        this.cmd.setString(8 , "");
        this.cmd.setString(9 , "");
        this.cmd.setString(10, "");
        this.cmd.setString(11, "");
        this.cmd.setString(12, "");
        this.cmd.setString(13, "");
        this.cmd.setInt(14, 0);
        
        int res = this.cmd.executeUpdate();
        
        return res;
    } 
}

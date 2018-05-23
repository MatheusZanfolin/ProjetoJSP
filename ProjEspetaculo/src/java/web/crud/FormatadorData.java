/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.crud;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;



/**
 *
 * @author u14187
 */
public class FormatadorData{
    public String formatar(Timestamp data){
        return data.toLocalDateTime().format(DateTimeFormatter.ISO_DATE);
    }
}

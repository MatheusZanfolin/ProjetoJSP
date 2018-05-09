/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBO;

/**
 *
 * @author u16189
 */
public enum TipoIngresso {
    Inteira     (1),
    Idoso       (2),
    Estudante   (3),    
    DoadorSangue(4),
    Jornalista  (5);
   
    int codTipo;
            
    TipoIngresso(int codTipo) {
        this.codTipo = codTipo;
    }
    
    public int getCodTipo() {
        return this.codTipo;
    }
}
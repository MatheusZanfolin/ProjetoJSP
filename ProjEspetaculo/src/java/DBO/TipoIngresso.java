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
    INTEIRA      (1, "Inteira", 70),
    IDOSO        (2, "Idoso", 35),
    ESTUDANTE    (3, "Estudante", 35),    
    DOADOR_SANGUE(4, "Doador de Sangue", 35),
    JORNALISTA   (5, "Jornalista", 35);
   
    private final int codTipo;
    private final String label;
    private final double valor;
            
    TipoIngresso(int codTipo, String label, double valor) {
        this.codTipo = codTipo;
        this.label = label;
        this.valor = valor;
    }
    
    public int getCodTipo() {
        return this.codTipo;
    }

    public String getLabel() {
        return label;
    }

    public double getValor() {
        return valor;
    }
    
    public String getValorFormatado(){
        return String.format("R$ %.2f", valor);
    }
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import DAO.Assentos;
import DAO.Espetaculos;
import DAO.Estados;
import DBO.Assento;
import DBO.Espetaculo;
import DBO.Estado;
import java.util.ArrayList;

/**
 *
 * @author u16189
 */
public class BancoDeDados {
    public static void main(String[] args) {
        try {
            ArrayList<Estado> estados = Estados.getEstados();
            
            for (Estado estado : estados) {
                System.out.println(estado);
            }
            
            System.out.println();
            System.out.println();
            
            ArrayList<Espetaculo> espetaculos = Espetaculos.getEspetaculos();
            
            for (Espetaculo espetaculo : espetaculos) {
                System.out.println(espetaculo);
            }
            
            System.out.println();
            System.out.println();
            
            ArrayList<Assento> assentos = Assentos.getAssentos();
            
            for (Assento assento : assentos) {
                System.out.println(assento);
            }
        } catch (Exception e) {
            e.printStackTrace();
            
            System.err.println();
            System.err.println();
            
            System.err.println(e.getMessage());
        }
    }
}

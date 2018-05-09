/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import DAO.Assentos;
import DAO.Espectadores;
import DAO.Espetaculos;
import DAO.Estados;
import DBO.Assento;
import DBO.Espectador;
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
            
            estados.forEach((estado) -> {
                System.out.println(estado);
            });
            
            System.out.println();
            System.out.println();
            
            ArrayList<Espetaculo> espetaculos = Espetaculos.getEspetaculos();
            
            espetaculos.forEach((espetaculo) -> {
                System.out.println(espetaculo);
            });
            
            System.out.println();
            System.out.println();
            
            ArrayList<Assento> assentos = Assentos.getAssentos();
            
            assentos.forEach((assento) -> {
                System.out.println(assento);
            });
            
            System.out.println();
            System.out.println();
            
            boolean cadastrado = Espectadores.isCadastrado("joao");
            
            System.out.println("João " + (cadastrado ? "está cadastrado" : "não está cadastrado"));
        } catch (Exception e) {
            e.printStackTrace();
            
            System.err.println();
            System.err.println();
            
            System.err.println(e.getMessage());
        }
    }
}

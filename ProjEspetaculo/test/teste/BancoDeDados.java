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
import DAO.Ingressos;
import DBO.Assento;
import DBO.Espectador;
import DBO.Espetaculo;
import DBO.Estado;
import DBO.TipoIngresso;
import java.sql.Date;
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
            
            boolean cadastrado = Espectadores.isCadastrado("joao", "123456");
            
            System.out.println("João " + (cadastrado ? "está cadastrado" : "não está cadastrado"));
            
            System.out.println();
            System.out.println();
            
            Espectador tadeu;
            
            tadeu = new Espectador("tadeu@ntes.ele", "tadeu", "Tadeu-Antes-Ele-Do-Que-Eu", "123.456.787/12", new Date(System.currentTimeMillis() + 1), true, "1234-5678", "12345", "Rua dos bobos", "0", "Não tinha teto, nem nada",  "Cidade dos bobos", "Bairro dos bobos", Estados.getEstados().get(0));
            
            int codAssentoParaOcupar = 2;
            
            int registrado = Ingressos.registrarIngresso(tadeu.getEmail(), Espetaculos.getEspetaculos().get(0).getDatasApresentacao().get(0), TipoIngresso.INTEIRA, Assentos.getAssentos().get(codAssentoParaOcupar - 1).getCodAssento());
            
            System.out.println("Tadeu " + (registrado <= 0 ? "não " : "") + "comprou um ingresso!");
            
            /*
            String nome = "Tadeu-Antes-Ele-Do-Que-Eu";
            
            int resultado = Espectadores.inserirEspectador(
                    new Espectador(
                            "tadeu@ntes.ele", "tadeu", nome, "123.456.787/12", new Date(System.currentTimeMillis() + 1), true, 
                            "1234-5678", "12345", "Rua dos bobos", "0", "Não tinha teto, nem nada", 
                            "Cidade dos bobos", "Bairro dos bobos", Estados.getEstados().get(0)));
            
            if (resultado > 0)
                System.out.println(nome + " foi inserido com sucesso! :)");
            else
                System.out.println(nome + " não foi inserido com sucesso! :(");
            */
            
            
        } catch (Exception e) {
            e.printStackTrace();
            
            System.err.println();
            System.err.println();
            
            System.err.println(e.getMessage());
        }
    }
}

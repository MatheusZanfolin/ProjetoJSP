package web;

import java.util.Arrays;
import java.util.List;

public class Cadastro {
    List<Pessoa> pessoas;

    public Cadastro(){
    	pessoas = Arrays.asList(
            new Pessoa("Matheus", 19),
            new Pessoa("Michelle", 19)
      	);
    }

    public static Cadastro executar(Cadastro cadastro, String operacao){
        if (cadastro == null || operacao == null)
                return new Cadastro();
        
        try{ 
            Cadastro.class.getMethod(operacao).invoke(cadastro);
        }
        catch(Exception e){
        }
        
        return cadastro;
    }
}
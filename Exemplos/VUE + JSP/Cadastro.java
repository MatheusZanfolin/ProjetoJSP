public class Cadastro {
	List<Pessoa> pessoas;

    public Cadastro(){
    	pessoas = Arrays.asList(
	        new Pessoa("Matheus", 19),
	        new Pessoa("Michelle", 19)
      	));
    }

    public static void executar(Cadastro cadastro, String operacao){
        if (cadadastro == null || operacao == null)
            return new Cadastro();

    	switch (operacao){
    		case "consultar" :
    			// TODO
    		break;

    		case "salvar"
    			// TODO
    		break ;
    	}

        return cadastro;
    }
}
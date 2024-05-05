import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {

    private List<Livro> livrosDisponiveis = new ArrayList<>();

    //Adiciona livro na lista
    public void adicionarLivro(Livro livro){
            livrosDisponiveis.add(livro);
    }

    public List<Livro> getLivrosDisponiveis(){
        return livrosDisponiveis.stream()
                .filter(e -> e.isDisponivel())
                .collect(Collectors.toList());
    }
}

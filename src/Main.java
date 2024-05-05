import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Livro.setBiblioteca(biblioteca);

        Livro livro1 = new Livro("Harry Potter", "JK Rowlling");
        Livro livro2 = new Livro("Senhor dos Anéis", "J.R.R. Tolkien");
        Livro livro3 = new Livro("O Alquimista", "Paulo Coelho");
        Livro livro4 = new Livro("O Código da Vinci", "Dan Brown");
        Livro livro5 = new Livro("O Diario de Anne Frank", "Anne Frank");
        Livro livro6 = new Livro("Dom Casmurro", "Machado de Assis");

        Usuario us1 = new Usuario("Caio");
        Usuario us2 = new Usuario("Maria");
        Usuario us3 = new Usuario("Joaquim");
        Usuario us4 = new Usuario("Livia");

        Emprestimo emp1 = new Emprestimo(livro1, us1);
        Emprestimo emp2 = new Emprestimo(livro2, us1);
        Emprestimo emp3 = new Emprestimo(livro1, us2);

        emp1.emprestarLivro();
        emp2.emprestarLivro();
        emp3.emprestarLivro();

        System.out.println("\nStatus dos emprestimos após emprestar: ");
        Emprestimo.getEmprestimos()
                        .forEach(e -> System.out.println(e));

        emp1.devolverLivro();
        emp2.devolverLivro();
        emp3.emprestarLivro();

        System.out.println("\nStatus dos emprestimos após devolver: ");
        Emprestimo.getEmprestimos()
                .forEach(e -> System.out.println(e));

        System.out.println("\nLivros disponíveis na biblioteca: ");
        biblioteca.getLivrosDisponiveis()
                .forEach(livro -> System.out.println(livro.getTitulo() + ", escrito por " + livro.getAutor()));

        System.out.println("\nLista de emprestimos atuais: ");
        Emprestimo.getEmprestimosAtuais()
                .forEach(e -> System.out.println(e));

        System.out.println("\nLista de livros por usuario: ");
        Optional<List<Livro>> livrosCaio = Emprestimo.encontrarLivrosPorUsuario(us1);

        System.out.println("Livros emprestados por Caio: ");
        livrosCaio.ifPresent(livros -> livros.forEach(livro -> System.out.println(livro)));

    }
}
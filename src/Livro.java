import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Livro {
    private static int nextId = 1;
    private Integer id;
    private String titulo;
    private String autor;
    private boolean disponivel;
    private static Biblioteca biblioteca;

    public Livro(String titulo, String autor) {
        this.id = nextId++;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
        biblioteca.adicionarLivro(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public static void setBiblioteca(Biblioteca bib){
        biblioteca = bib;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", disponivel=" + disponivel +
                '}';
    }
}

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Emprestimo {
    private static int nextId = 1;
    private Integer id;
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private Optional<LocalDate> dataRealDevolucao = Optional.empty();

    private static List<Emprestimo> emprestimos = new ArrayList<>();


    public Emprestimo(Livro livro, Usuario usuario) {
        this.id = nextId++;
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = this.dataEmprestimo.plusDays(30);
    }

    public static List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    //Método para emprestar um livro
    public void emprestarLivro(){
        if(this.getLivro().isDisponivel()){
            this.getLivro().setDisponivel(false);
            if(!emprestimos.contains(this)){
                emprestimos.add(this);
            }
            System.out.println("Livro emprestado com sucesso");
        } else{
            System.out.println("O Livro não está disponível no momento!");
        }
    }

    //Méetodo para devolver livro
    public void devolverLivro(){
        this.setDataRealDevolucao(LocalDate.now());
        if(this.dataDevolucao.isBefore(this.dataRealDevolucao.get())){
            System.out.println("Você devolveu o livro com atraso!!!");
        }
        this.getLivro().setDisponivel(true);
        System.out.println("Livro devolvido com sucesso!");
    }

    //Método para listar todos os emprestimos atuais
    public static List<Emprestimo> getEmprestimosAtuais(){
        return emprestimos.stream()
                .filter(e -> e.dataRealDevolucao.isEmpty())
                .collect(Collectors.toList());
    }

    //Método para encontrar livros por usuario
    public static Optional<List<Livro>> encontrarLivrosPorUsuario(Usuario user){
        if(user == null){
            return Optional.empty();
        }

        List<Livro> livrosEmprestados = emprestimos.stream()
                .filter(e -> e.getUsuario().equals(user))
                .map(Emprestimo::getLivro)
                .collect(Collectors.toList());

        return Optional.of(livrosEmprestados);
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Optional<LocalDate> getDataRealDevolucao() {
        return dataRealDevolucao;
    }

    public void setDataRealDevolucao(LocalDate date) {
        this.dataRealDevolucao = Optional.ofNullable(date);
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "id=" + id +
                ", livro=" + livro +
                ", usuario=" + usuario +
                ", dataEmprestimo=" + dataEmprestimo +
                ", dataDevolucao=" + dataDevolucao +
                ", dataRealDevolucao=" + dataRealDevolucao +
                '}';
    }
}

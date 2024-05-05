public class Usuario {

    private static int nextId = 1;
    private String nome;
    private Integer id;

    public Usuario(String nome) {
        this.id = nextId++;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                '}';
    }
}

package todolist;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private static int nextId = 1;

    private int id;
    private String nome;
    private String email;
    private List<Task> tarefas;

    public Usuario(String nome, String email) {
        this.id = nextId++;
        this.nome = nome;
        this.email = email;
        this.tarefas = new ArrayList<>();
    }

    public void atribuirTarefa(Task task) {
        tarefas.add(task);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Task> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Task> tarefas) {
        this.tarefas = tarefas;
    }
}
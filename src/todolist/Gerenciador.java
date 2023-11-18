package todolist;

import java.util.ArrayList;
import java.util.List;

public class Gerenciador {
    private List<Task> tarefas;
    private List<Usuario> usuarios;
//AQUI SERIA OS MÉTODOS FUNDAMENTAIS PARA O FUNCIONAMENTO DO TODOLIST
    public Gerenciador() {
        this.tarefas = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void addTarefa(Task tarefa) {
        tarefas.add(tarefa);
    }

    public void removerTarefa(Task tarefa) {
        tarefas.remove(tarefa);
    }

    public Usuario criarUsuario(String nome, String email) {
        Usuario novoUsuario = new Usuario(nome, email);
        usuarios.add(novoUsuario);
        return novoUsuario;
    }

    public void atribuirTarefa(Task tarefa, Usuario usuario) {
        usuario.atribuirTarefa(tarefa);
    }
}
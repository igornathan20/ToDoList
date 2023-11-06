package todolist;

import java.util.List;

public class Usuario {
 public int id;
 public String nome;
 public String email;
 public List<Task> tarefas ; 

 
    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
    
    public void atribuirTarefa (Task task ){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

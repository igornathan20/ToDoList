package todolist;

import java.util.Date;

public class Task {
    private static int nextId = 1;

    private int id;
    private String descricao;
    private Date criacaoData;
    private Date finalizacaoData;
    private String status;

    public Task(String descricao, Date criacaoData, String status) {
        this.id = nextId++;
        this.descricao = descricao;
        this.criacaoData = criacaoData;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getCriacaoData() {
        return criacaoData;
    }

    public void setCriacaoData(Date criacaoData) {
        this.criacaoData = criacaoData;
    }

    public Date getFinalizacaoData() {
        return finalizacaoData;
    }

    public void setFinalizacaoData(Date finalizacaoData) {
        this.finalizacaoData = finalizacaoData;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
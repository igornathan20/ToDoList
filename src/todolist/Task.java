package todolist;

import java.util.Date;

public class Task {
    public int id;
    public String descrição;
    public Date criacaoData;
    public Date finalizacaoData;
    public String status;

    public Task(String descrição, Date criacaoData, String status) {
        this.descrição = descrição;
        this.criacaoData = criacaoData;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
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

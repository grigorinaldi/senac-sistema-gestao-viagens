package br.senac.agencia.model;

public class ReservaView {
    private int id;
    private String cliente;
    private String pacote;
    private String data;
    private String status;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }
    public String getPacote() { return pacote; }
    public void setPacote(String pacote) { this.pacote = pacote; }
    public String getData() { return data; }
    public void setData(String data) { this.data = data; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

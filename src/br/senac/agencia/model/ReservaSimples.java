package br.senac.agencia.model;

public class ReservaSimples {
    private String cliente;
    private String pacote;
    private String data;
    private String status;

    public ReservaSimples(String cliente, String pacote, String data, String status) {
        this.cliente = cliente;
        this.pacote = pacote;
        this.data = data;
        this.status = status;
    }

    public String getCliente() { return cliente; }
    public String getPacote() { return pacote; }
    public String getData() { return data; }
    public String getStatus() { return status; }
}

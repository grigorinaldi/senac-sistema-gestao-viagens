package br.senac.agencia.model;

import java.util.Date;

public class Reserva {
    private int id;
    private Date dataReserva;
    private StatusReserva status;
    private Cliente cliente;
    private Pacote pacote;
}
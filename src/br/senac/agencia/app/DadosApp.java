package br.senac.agencia.app;

import br.senac.agencia.model.Cliente;
import br.senac.agencia.model.Pacote;
import br.senac.agencia.model.ReservaSimples;

import java.util.ArrayList;
import java.util.List;

public class DadosApp {

    public static final List<Cliente> CLIENTES = new ArrayList<>();
    public static final List<Pacote> PACOTES = new ArrayList<>();
    public static final List<ReservaSimples> RESERVAS = new ArrayList<>();

    static {
        Cliente c1 = new Cliente();
        c1.setNome("Giovanni Silva");
        c1.setCpf("111.111.111-11");
        c1.setTelefone("(11) 99999-1111");
        c1.setEmail("giovanni@gmail.com");

        Cliente c2 = new Cliente();
        c2.setNome("Maria Oliveira");
        c2.setCpf("222.222.222-22");
        c2.setTelefone("(11) 98888-2222");
        c2.setEmail("maria@gmail.com");

        Cliente c3 = new Cliente();
        c3.setNome("Carlos Santos");
        c3.setCpf("333.333.333-33");
        c3.setTelefone("(11) 97777-3333");
        c3.setEmail("carlos@gmail.com");

        CLIENTES.add(c1);
        CLIENTES.add(c2);
        CLIENTES.add(c3);

        Pacote p1 = new Pacote();
        p1.setDestino("Rio de Janeiro");
        p1.setDataInicio("10/10/2025");
        p1.setDataFim("15/10/2025");
        p1.setPreco(2500.00);

        Pacote p2 = new Pacote();
        p2.setDestino("São Paulo");
        p2.setDataInicio("05/11/2025");
        p2.setDataFim("08/11/2025");
        p2.setPreco(1800.00);

        Pacote p3 = new Pacote();
        p3.setDestino("Salvador");
        p3.setDataInicio("20/12/2025");
        p3.setDataFim("27/12/2025");
        p3.setPreco(3200.00);

        PACOTES.add(p1);
        PACOTES.add(p2);
        PACOTES.add(p3);
    }
}
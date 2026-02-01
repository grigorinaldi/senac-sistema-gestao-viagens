package br.senac.agencia.app;

import br.senac.agencia.ui.TelaMenu;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new TelaMenu().setVisible(true));
    }
}
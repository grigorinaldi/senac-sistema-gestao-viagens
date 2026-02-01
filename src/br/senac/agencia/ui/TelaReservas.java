package br.senac.agencia.ui;

import br.senac.agencia.dao.ClienteDAO;
import br.senac.agencia.dao.PacoteDAO;
import br.senac.agencia.dao.ReservaDAO;
import br.senac.agencia.model.Cliente;
import br.senac.agencia.model.Pacote;
import br.senac.agencia.model.ReservaView;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaReservas extends javax.swing.JFrame {

    private final ClienteDAO clienteDAO = new ClienteDAO();
    private final PacoteDAO pacoteDAO = new PacoteDAO();
    private final ReservaDAO reservaDAO = new ReservaDAO();

    private List<Cliente> cacheClientes = new ArrayList<>();
    private List<Pacote> cachePacotes = new ArrayList<>();
    private List<ReservaView> cacheReservas = new ArrayList<>();

    public TelaReservas() {
        initComponents();
        carregarCombos();
        carregarTabelaReservas();
    }

    private void carregarCombos() {
        try {
            // CLIENTES
            cacheClientes = clienteDAO.listar();
            cbCliente.removeAllItems();
            cbCliente.addItem("Selecione um cliente...");
            for (Cliente c : cacheClientes) {
                cbCliente.addItem(c.getNome() + " - " + c.getCpf());
            }

            // PACOTES
            cachePacotes = pacoteDAO.listar();
            cbPacote.removeAllItems();
            cbPacote.addItem("Selecione um pacote...");
            for (Pacote p : cachePacotes) {
                cbPacote.addItem(p.getDestino());
            }

            // STATUS
            cbStatus.removeAllItems();
            cbStatus.addItem("ABERTA");
            cbStatus.addItem("CONFIRMADA");
            cbStatus.addItem("CANCELADA");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Erro ao carregar combos: " + e.getMessage());
        }
    }

    private void carregarTabelaReservas() {
        try {
            cacheReservas = reservaDAO.listar();

            DefaultTableModel model =
                    (DefaultTableModel) tblReservas.getModel();
            model.setRowCount(0);

            for (ReservaView r : cacheReservas) {
                model.addRow(new Object[]{
                    r.getCliente(),
                    r.getPacote(),
                    r.getData(),
                    r.getStatus()
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Erro ao listar reservas: " + e.getMessage());
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEditar1 = new javax.swing.JButton();
        cbCliente = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cbPacote = new javax.swing.JComboBox<>();
        cbStatus = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDataReserva = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReservas = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        btnEditar1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEditar1.setText("Menu");
        btnEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um cliente...", "Pedro", "Maria", "Zé" }));
        cbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbClienteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Reservar");

        cbPacote.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbPacote.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um pacote...", "Pacote1", "Pacote2", "Pacote3" }));
        cbPacote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPacoteActionPerformed(evt);
            }
        });

        cbStatus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um status...", "Aberta", "Confirmada", "Cancelada" }));
        cbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStatusActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Nova Reserva");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Data da Reserva:");

        txtDataReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataReservaActionPerformed(evt);
            }
        });

        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRegistrar.setText("Registrar Reserva");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Reservar Registradas");

        tblReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cliente", "Pacote", "Data", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblReservas);

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar Reserva");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnVoltar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnVoltar.setText("Menu");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(288, 288, 288)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 253, Short.MAX_VALUE)
                .addComponent(btnVoltar)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(btnRegistrar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbPacote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(89, 89, 89))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addGap(143, 143, 143))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVoltar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbPacote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtDataReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistrar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbClienteActionPerformed

    private void cbPacoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPacoteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPacoteActionPerformed

    private void cbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbStatusActionPerformed

    private void txtDataReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataReservaActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
try {
            int idxCliente = cbCliente.getSelectedIndex() - 1;
            int idxPacote  = cbPacote.getSelectedIndex() - 1;

            if (idxCliente < 0 || idxPacote < 0) {
                JOptionPane.showMessageDialog(this,
                        "Selecione um cliente e um pacote.");
                return;
            }

            String data = txtDataReserva.getText().trim();
            if (data.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Informe a data da reserva.");
                return;
            }

            int clienteId = cacheClientes.get(idxCliente).getId();
            int pacoteId  = cachePacotes.get(idxPacote).getId();
            String status = cbStatus.getSelectedItem().toString();

            reservaDAO.inserir(clienteId, pacoteId, data, status);

            carregarTabelaReservas();
            JOptionPane.showMessageDialog(this,
                    "Reserva registrada com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Erro ao registrar reserva: " + e.getMessage());
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
try {
            int linha = tblReservas.getSelectedRow();
            if (linha == -1) {
                JOptionPane.showMessageDialog(this,
                        "Selecione uma reserva.");
                return;
            }

            int id = cacheReservas.get(linha).getId();
            reservaDAO.excluir(id);

            carregarTabelaReservas();
            JOptionPane.showMessageDialog(this,
                    "Reserva cancelada.");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Erro ao cancelar reserva: " + e.getMessage());
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditar1ActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
new TelaMenu().setVisible(true);
this.dispose();

    }//GEN-LAST:event_btnVoltarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaReservas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar1;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbCliente;
    private javax.swing.JComboBox<String> cbPacote;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblReservas;
    private javax.swing.JTextField txtDataReserva;
    // End of variables declaration//GEN-END:variables
}

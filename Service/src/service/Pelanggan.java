/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ruikenichi
 */
public class Pelanggan extends javax.swing.JFrame {

    /**
     * Creates new form Pelanggan
     */
    public Pelanggan() {
        initComponents();
    }

    public void hapusData() {
        idPelanggan.setText("");
        namaPelanggan.setText("");
        noTelp.setText("");
        cbjnsService.setSelectedItem("-");
        trfService.setText("");
        byaTambah.setText("");
    }

    public void hapusData2() {
        namaPelanggan.setText("");
        noTelp.setText("");
        cbjnsService.setSelectedItem("-");
        trfService.setText("");
        byaTambah.setText("");
    }

    public void CariData() {
        if (idPelanggan.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID kosong! Silakan masukkan ID.");
            hapusData2();
        } else {
            try (Connection connection = Koneksi.openConnect()) {
                String sql = "SELECT * FROM jasa WHERE id=?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, idPelanggan.getText());

                    try (ResultSet rs = statement.executeQuery()) {
                        if (rs.next()) {
                            idPelanggan.setText(rs.getString("id_jasa"));
                            namaPelanggan.setText(rs.getString("nama"));
                            noTelp.setText(rs.getString("notelp"));
                            cbjnsService.setSelectedItem(rs.getString("jenis_service"));
                            trfService.setText(rs.getString("tarif_service"));
                            byaTambah.setText(rs.getString("biaya_tambahan"));
                            JOptionPane.showMessageDialog(this, "Data ditemukan. Silakan lakukan pengeditan.");
                        } else {
                            JOptionPane.showMessageDialog(this, "Data tidak ditemukan. Mohon periksa kembali ID.");
                            hapusData2(); // Panggil metode hapusData untuk mengosongkan inputan
                        }
                        tampilketabel(); // Panggil metode tampilketabel untuk menampilkan tabel pelanggan
                    }
                }
            } catch (SQLException e) {
                // Tangani exception jika terjadi kesalahan
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        }
    }

    public void tampilketabel() {
        try (Connection connection = Koneksi.openConnect()) {
            String[] judul = {"ID", "Nama", "No Telp", "Jenis Service", "Tarif Service", "Biaya Tambahan", "Total Bayar"};
            DefaultTableModel ttable = new DefaultTableModel(null, judul);
            tbPelanggan.setModel(ttable);
            jScrollPelanggan.getViewport().add(tbPelanggan);
            tbPelanggan.setEnabled(true);

            String sql = "SELECT * FROM jasa";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                    ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    String id = rs.getString("id_jasa");
                    String siswaId = rs.getString("nama");
                    String nama_siswa = rs.getString("notelp");
                    String jenis_tagihan = rs.getString("jenis_service");
                    String jenis_kelamin = rs.getString("tarif_service");
                    String tanggal_tagihan = rs.getString("biaya_tambahan");
                    String total_bayar = rs.getString("total_bayar");
                    String[] data = {id, siswaId, nama_siswa, jenis_tagihan, jenis_kelamin, tanggal_tagihan, total_bayar};
                    ttable.addRow(data);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        idPelanggan = new javax.swing.JTextField();
        namaPelanggan = new javax.swing.JTextField();
        noTelp = new javax.swing.JTextField();
        cbjnsService = new javax.swing.JComboBox<>();
        trfService = new javax.swing.JTextField();
        byaTambah = new javax.swing.JTextField();
        btCari = new javax.swing.JButton();
        btUbah = new javax.swing.JButton();
        btSimpan = new javax.swing.JButton();
        btClear = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btKeluar = new javax.swing.JButton();
        jScrollPelanggan = new javax.swing.JScrollPane();
        tbPelanggan = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Pelanggan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Nama");

        jLabel3.setText("No Telp");

        jLabel4.setText("Jenis Service");

        jLabel5.setText("Tarif Service");

        jLabel6.setText("Biaya Tambahan");

        jLabel8.setText("ID");

        cbjnsService.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Penggantian Baterai", "Perbaikan Layar", "Perbaikan Software", "Penggantian Mesin" }));
        cbjnsService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbjnsServiceActionPerformed(evt);
            }
        });

        trfService.setEditable(false);

        btCari.setText("Cari");
        btCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCariActionPerformed(evt);
            }
        });

        btUbah.setText("Ubah");
        btUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUbahActionPerformed(evt);
            }
        });

        btSimpan.setText("Simpan");
        btSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSimpanActionPerformed(evt);
            }
        });

        btClear.setText("Clear");
        btClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearActionPerformed(evt);
            }
        });

        btDelete.setText("Delete");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        btKeluar.setText("Keluar");
        btKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKeluarActionPerformed(evt);
            }
        });

        tbPelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nama", "No Telp", "Jenis Service", "Tarif Service", "Biaya Tambahan", "Total Bayar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPelanggan.setViewportView(tbPelanggan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btUbah)
                                        .addGap(18, 18, 18)
                                        .addComponent(btSimpan)
                                        .addGap(18, 18, 18)
                                        .addComponent(btClear)
                                        .addGap(18, 18, 18)
                                        .addComponent(btDelete)
                                        .addGap(18, 18, 18)
                                        .addComponent(btKeluar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(idPelanggan)
                                            .addComponent(namaPelanggan)
                                            .addComponent(noTelp)
                                            .addComponent(cbjnsService, 0, 135, Short.MAX_VALUE)
                                            .addComponent(trfService)
                                            .addComponent(byaTambah))
                                        .addGap(18, 18, 18)
                                        .addComponent(btCari)))))
                        .addGap(0, 104, Short.MAX_VALUE))
                    .addComponent(jScrollPelanggan, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(idPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCari))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(namaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(noTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbjnsService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(trfService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(byaTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btUbah)
                    .addComponent(btSimpan)
                    .addComponent(btClear)
                    .addComponent(btDelete)
                    .addComponent(btKeluar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 71, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(616, 689));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        tampilketabel();
    }//GEN-LAST:event_formWindowOpened

    private void btSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSimpanActionPerformed
        // TODO add your handling code here:
        try (Connection connection = Koneksi.openConnect()) {
            String sql = "INSERT INTO jasa (id_jasa, nama, notelp, jenis_service, tarif_service, biaya_tambahan)\n"
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, idPelanggan.getText());
                stmt.setString(2, namaPelanggan.getText());
                stmt.setString(3, noTelp.getText());
                stmt.setString(4, cbjnsService.getSelectedItem().toString());
                stmt.setString(5, trfService.getText());
                stmt.setString(6, byaTambah.getText());

                int rows = stmt.executeUpdate();
                if (rows > 0) {
                    JOptionPane.showMessageDialog(this, "Data Sukses Di Tambahkan!!!");
                    tampilketabel();
                } else {
                    JOptionPane.showMessageDialog(this, "Gagal menambahkan data siswa.");
                }
            }
        } catch (SQLException e) {
            // Tangani exception jika terjadi kesalahan
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btSimpanActionPerformed

    private void cbjnsServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbjnsServiceActionPerformed
        // TODO add your handling code here:
        String selectedOption = cbjnsService.getSelectedItem().toString();
        switch (selectedOption) {
            case "Penggantian Baterai":
                trfService.setText("350000");
                break;
            case "Perbaikan Layar":
                trfService.setText("500000");
                break;
            case "Perbaikan Software":
                trfService.setText("200000");
                break;
            case "Penggantian Mesin":
                trfService.setText("1000000");
                break;
            default:
                // Tambahkan logika sesuai kebutuhan jika tidak ada opsi yang cocok
                break;
        }
    }//GEN-LAST:event_cbjnsServiceActionPerformed

    private void btKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKeluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btKeluarActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        // TODO add your handling code here:
        try (Connection connection = Koneksi.openConnect()) {
            String sql = "DELETE FROM jasa WHERE `jasa`.`id_jasa` = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, idPelanggan.getText());

                int rows = stmt.executeUpdate();
                if (rows > 0) {
                    JOptionPane.showMessageDialog(this, "DATA BERHASIL DIHAPUS!!!");
                    tampilketabel();
                } else {
                    JOptionPane.showMessageDialog(this, "Gagal menghapus data tagihan.");
                }
            }
            hapusData(); // Jika perlu menghapus data lainnya
            tampilketabel(); // Jika perlu menampilkan tabel lainnya
        } catch (SQLException e) {
            // Tangani exception jika terjadi kesalahan
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage());
        }

    }//GEN-LAST:event_btDeleteActionPerformed

    private void btUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUbahActionPerformed
        // TODO add your handling code here:
        try (Connection connection = Koneksi.openConnect()) {
            String sql = "UPDATE `jasa` SET `nama` = ?, `notelp` = ?, `jenis_service` = ?, `tarif_service` = ?, `biaya_tambahan` = ? WHERE `id_jasa` = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, namaPelanggan.getText());
                stmt.setString(2, noTelp.getText());
                stmt.setString(3, cbjnsService.getSelectedItem().toString());
                stmt.setString(4, trfService.getText());
                stmt.setString(5, byaTambah.getText());
                stmt.setString(6, idPelanggan.getText());

                int rows = stmt.executeUpdate();
                if (rows > 0) {
                    JOptionPane.showMessageDialog(this, "Data Sukses Diubah!!!");
                    tampilketabel();
                } else {
                    JOptionPane.showMessageDialog(this, "Gagal mengubah data pelanggan.");
                }
            }
        } catch (SQLException e) {
            // Tangani exception jika terjadi kesalahan
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage());
        }

    }//GEN-LAST:event_btUbahActionPerformed

    private void btCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCariActionPerformed
        // TODO add your handling code here:\
        CariData();
    }//GEN-LAST:event_btCariActionPerformed

    private void btClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearActionPerformed
        // TODO add your handling code here:
        hapusData();
    }//GEN-LAST:event_btClearActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Pelanggan().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCari;
    private javax.swing.JButton btClear;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btKeluar;
    private javax.swing.JButton btSimpan;
    private javax.swing.JButton btUbah;
    private javax.swing.JTextField byaTambah;
    private javax.swing.JComboBox<String> cbjnsService;
    private javax.swing.JTextField idPelanggan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPelanggan;
    private javax.swing.JTextField namaPelanggan;
    private javax.swing.JTextField noTelp;
    private javax.swing.JTable tbPelanggan;
    private javax.swing.JTextField trfService;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tagihan_sekolah;

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
public class Tagihan extends javax.swing.JFrame {

    /**
     * Creates new form Tagihan
     */
    public Tagihan() {
        initComponents();
        initializeData();
    }

    private void initializeData() {
        tampilIdSiswa();
        Siswa();
    }

    public void hapusData() {
        idTagihan.setText("");
        cbIdSiswa.setSelectedItem("-");
        namaSiswa.setText("");
        jenisTagihan.setText("");
        jumlahTagihan.setText("");
        tanggalTagihan.setText("");
    }

    public void hapusData2() {
        cbIdSiswa.setSelectedItem("-");
        namaSiswa.setText("");
        jenisTagihan.setText("");
        jumlahTagihan.setText("");
        tanggalTagihan.setText("");
    }

    public void tampilketabel() {
        try (Connection connection = Koneksi.openConnect()) {
            String[] judul = {"ID", "ID Siswa", "Nama Siswa", "Jenis Tagihan", "Jumlah Tagihan", "Tanggal Tagihan"};
            DefaultTableModel ttable = new DefaultTableModel(null, judul);
            tbTagihan.setModel(ttable);
            jScrollTagihan.getViewport().add(tbTagihan);
            tbTagihan.setEnabled(true);

            String sql = "SELECT * FROM tagihan JOIN siswa ON tagihan.siswa_id = siswa.id";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                    ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    String id = rs.getString("id");
                    String siswaId = rs.getString("siswa_id");
                    String nama_siswa = rs.getString("nama");
                    String jenis_tagihan = rs.getString("jenis_tagihan");
                    String jenis_kelamin = rs.getString("jumlah");
                    String tanggal_tagihan = rs.getString("tanggal_tagihan");
                    String[] data = {id, siswaId, nama_siswa, jenis_tagihan, jenis_kelamin, tanggal_tagihan};
                    ttable.addRow(data);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public void CariData() {
        if (idTagihan.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID kosong! Silakan masukkan ID.");
            hapusData2();
        } else {
            try (Connection connection = Koneksi.openConnect()) {
                String sql = "SELECT * FROM tagihan WHERE id=?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, idTagihan.getText());

                    try (ResultSet rs = statement.executeQuery()) {
                        if (rs.next()) {
                            idTagihan.setText(rs.getString("id"));
                            cbIdSiswa.setSelectedItem(rs.getString("siswa_id"));
                            jenisTagihan.setText(rs.getString("jenis_tagihan"));
                            jumlahTagihan.setText(rs.getString("jumlah"));
                            tanggalTagihan.setText(rs.getString("tanggal_tagihan"));
                            JOptionPane.showMessageDialog(this, "Data ditemukan, Silakan lakukan pengeditan.");
                        } else {
                            JOptionPane.showMessageDialog(this, "Data tidak ditemukan, Mohon periksa kembali ID.");
                            hapusData2(); // Panggil metode hapusData untuk mengosongkan inputan
                        }
                        tampilketabel(); // Panggil metode tampilketabel untuk menampilkan tabel siswa
                    }
                }
            } catch (SQLException e) {
                // Tangani exception jika terjadi kesalahan
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        }
    }

    public void tampilIdSiswa() {
        try (Connection connection = Koneksi.openConnect()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM siswa");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                cbIdSiswa.addItem(rs.getString("id"));
            }
        } catch (SQLException ex) {
            // Handle the exception if an error occurs
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public void Siswa() {
        if (cbIdSiswa.getSelectedItem().toString().isEmpty()) {
            return;
        }

        try (Connection connection = Koneksi.openConnect();
                PreparedStatement statement = connection.prepareStatement("SELECT siswa.nama FROM siswa WHERE id = ?")) {

            statement.setString(1, cbIdSiswa.getSelectedItem().toString());

            try (ResultSet rs1 = statement.executeQuery()) {
                if (rs1.next()) {
                    /* Jika Ditemukan */
                    namaSiswa.setText(rs1.getString("nama"));
                }
            }
        } catch (SQLException e) {
            // Handle the exception if an error occurs
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
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
        idTagihan = new javax.swing.JTextField();
        jenisTagihan = new javax.swing.JTextField();
        jumlahTagihan = new javax.swing.JTextField();
        btUbah = new javax.swing.JButton();
        btSimpan = new javax.swing.JButton();
        btClear = new javax.swing.JButton();
        btKeluar = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        jScrollTagihan = new javax.swing.JScrollPane();
        tbTagihan = new javax.swing.JTable();
        tanggalTagihan = new javax.swing.JTextField();
        btCari = new javax.swing.JButton();
        cbIdSiswa = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        namaSiswa = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Tagihan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(226, 226, 226))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel2.setText("ID");

        jLabel3.setText("ID Siswa");

        jLabel4.setText("Jenis Tagihan");

        jLabel5.setText("Jumlah Tagihan");

        jLabel6.setText("Tanggal Tagihan");

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

        btKeluar.setText("Keluar");
        btKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKeluarActionPerformed(evt);
            }
        });

        btDelete.setText("Delete");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        tbTagihan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "ID Siswa", "Nama Siswa", "Jenis Tagihan", "Jumlah Tagihan", "Tanggal Tagihan"
            }
        ));
        jScrollTagihan.setViewportView(tbTagihan);

        btCari.setText("Cari");
        btCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCariActionPerformed(evt);
            }
        });

        cbIdSiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIdSiswaActionPerformed(evt);
            }
        });

        jLabel7.setText("Nama Siswa");

        namaSiswa.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(btUbah)
                        .addGap(18, 18, 18)
                        .addComponent(btSimpan)
                        .addGap(18, 18, 18)
                        .addComponent(btClear)
                        .addGap(18, 18, 18)
                        .addComponent(btKeluar)
                        .addGap(18, 18, 18)
                        .addComponent(btDelete)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollTagihan, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jenisTagihan)
                                    .addComponent(idTagihan)
                                    .addComponent(jumlahTagihan)
                                    .addComponent(tanggalTagihan)
                                    .addComponent(cbIdSiswa, 0, 135, Short.MAX_VALUE)
                                    .addComponent(namaSiswa))
                                .addGap(18, 18, 18)
                                .addComponent(btCari)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(idTagihan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCari))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbIdSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(namaSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jenisTagihan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jumlahTagihan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tanggalTagihan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btUbah)
                    .addComponent(btSimpan)
                    .addComponent(btClear)
                    .addComponent(btKeluar)
                    .addComponent(btDelete))
                .addGap(18, 18, 18)
                .addComponent(jScrollTagihan, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(566, 614));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUbahActionPerformed
        // TODO add your handling code here:
        try (Connection connection = Koneksi.openConnect()) {
            String sql = "UPDATE `tagihan` SET `siswa_id` = ?, `jenis_tagihan` = ?, `jumlah` = ?, `tanggal_tagihan` = ? WHERE `id` = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, cbIdSiswa.getSelectedItem().toString());
                stmt.setString(2, jenisTagihan.getText());
                stmt.setString(3, jumlahTagihan.getText());
                stmt.setString(4, tanggalTagihan.getText());
                stmt.setString(5, idTagihan.getText());

                int rows = stmt.executeUpdate();
                if (rows > 0) {
                    JOptionPane.showMessageDialog(this, "Data Sukses Diubah!!!");
                    tampilketabel();
                } else {
                    JOptionPane.showMessageDialog(this, "Gagal mengubah data tagihan.");
                }
            }
        } catch (SQLException e) {
            // Tangani exception jika terjadi kesalahan
            JOptionPane.showMessageDialog(this, "Error : " + e.getMessage());
        }
    }//GEN-LAST:event_btUbahActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        tampilketabel();
    }//GEN-LAST:event_formWindowOpened

    private void btCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCariActionPerformed
        // TODO add your handling code here:
        CariData();
    }//GEN-LAST:event_btCariActionPerformed

    private void btSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSimpanActionPerformed
        // TODO add your handling code here:
        try (Connection connection = Koneksi.openConnect()) {
            String sql = "INSERT INTO tagihan (id, siswa_id, jenis_tagihan, jumlah, tanggal_tagihan) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, idTagihan.getText());
                stmt.setString(2, cbIdSiswa.getSelectedItem().toString());
                stmt.setString(3, jenisTagihan.getText());
                stmt.setString(4, jumlahTagihan.getText());
                stmt.setString(5, tanggalTagihan.getText());

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

    private void cbIdSiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIdSiswaActionPerformed
        // TODO add your handling code here:
        Siswa();
    }//GEN-LAST:event_cbIdSiswaActionPerformed

    private void btClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearActionPerformed
        // TODO add your handling code here:
        hapusData();
    }//GEN-LAST:event_btClearActionPerformed

    private void btKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKeluarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        menuUtama form1 = new menuUtama();
        form1.setVisible(true);
    }//GEN-LAST:event_btKeluarActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        // TODO add your handling code here:
        try (Connection connection = Koneksi.openConnect()) {
            String sql = "DELETE FROM tagihan WHERE `tagihan`.`id` = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, idTagihan.getText());

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
            java.util.logging.Logger.getLogger(Tagihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Tagihan().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCari;
    private javax.swing.JButton btClear;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btKeluar;
    private javax.swing.JButton btSimpan;
    private javax.swing.JButton btUbah;
    private javax.swing.JComboBox<String> cbIdSiswa;
    private javax.swing.JTextField idTagihan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollTagihan;
    private javax.swing.JTextField jenisTagihan;
    private javax.swing.JTextField jumlahTagihan;
    private javax.swing.JTextField namaSiswa;
    private javax.swing.JTextField tanggalTagihan;
    private javax.swing.JTable tbTagihan;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dt_rs;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ruikenichi
 */
public class pasien extends javax.swing.JFrame {

    private DefaultTableModel ttable1;

    /**
     * Creates new form pasien
     */
    public pasien() {
        initComponents();
    }

    public void HapusData() {
        txtkode.setText("");
        txtpasien.setText("");
        cb_jk.setSelectedItem("-");
        cbJP.setSelectedItem("-");
        cb_dokter.setSelectedItem("-");
        txtdokter.setText("");
        txtbiaya.setText("");
        cbObat.setSelectedItem("-");
        txtHarga.setText("");
    }

    public void HapusData2() {
        txtpasien.setText("");
        cb_jk.setSelectedItem("-");
        cbJP.setSelectedItem("-");
        cb_dokter.setSelectedItem("-");
        txtdokter.setText("");
        txtbiaya.setText("");
        cbObat.setSelectedItem("-");
        txtHarga.setText("");
    }

    public void deletetable1() {
        int row = ttable1.getRowCount();
        for (int i = 0; i < row; i++) {
            ttable1.removeRow(0);
        }
    }

    public void tampilketabel() {
        try {
            String[] judul = {"Kode Pasien", "Nama Pasien", "Jenis Kelamin", "Jenis Periksa", "Biaya Periksa", "Obat", "Harga Obat"};
            ttable1 = new DefaultTableModel(null, judul);
            tabel.setModel(ttable1);
            jScroll.getViewport().add(tabel);
            tabel.setEnabled(true);

            koneksi ObjKoneksi1 = new koneksi();
            Connection connection = ObjKoneksi1.openConnect();
            Statement st1 = connection.createStatement();

            String sql1 = ""
                    + " SELECT pasien.*"
                    + " FROM pasien"
                    + " WHERE kd_pasien ='" + txtkode.getText() + "'";
            ResultSet rs1 = st1.executeQuery(sql1);

            while (rs1.next()) {
                String kd_pasien = rs1.getString("kd_pasien");
                String nm_pasien = rs1.getString("nm_pasien");
                String jns_kelamin = rs1.getString("jns_kelamin");
                String jns_periksa = rs1.getString("jns_periksa");
                String biaya = rs1.getString("biaya");
                String obat = rs1.getString("obat");
                String harga = rs1.getString("harga");
                String[] data = {kd_pasien, nm_pasien, jns_kelamin, jns_periksa, biaya, obat, harga};
                ttable1.addRow(data);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex);
        }
    }

    public void Dokter() {
        if (cb_dokter.getSelectedItem().equals("")) {
        } else {
            try {
                koneksi ObHrgoneksi1 = new koneksi();
                try (Connection connection = ObHrgoneksi1.openConnect()) {
                    Statement st1 = connection.createStatement();
                    String sql1 = ""
                            + " SELECT dokter.nm_dokter"
                            + " FROM dokter"
                            + " WHERE kd_dokter='" + cb_dokter.getSelectedItem() + "'";

                    try (ResultSet rs1 = st1.executeQuery(sql1)) {
                        if (rs1.next()) {
                            /* Jika Ditemukan */
                            txtdokter.setText(rs1.getString("nm_dokter"));
                        }
                    }
                }
            } catch (SQLException e) {
            }
        }
    }

    public void CariData() {
        if (txtkode.getText().equals("")) {
        } else {
            try {
                koneksi ObHrgoneksi1 = new koneksi();
                try (Connection connection = ObHrgoneksi1.openConnect()) {
                    Statement st1 = connection.createStatement();
                    String sql1 = ""
                            + " SELECT pasien.*"
                            + " FROM pasien"
                            + " WHERE kd_pasien ='" + txtkode.getText() + "'";
                    try (ResultSet rs1 = st1.executeQuery(sql1)) {
                        if (rs1.next()) {
                            txtkode.setText(rs1.getString("kd_pasien"));
                            txtpasien.setText(rs1.getString("nm_pasien"));
                            cb_jk.setSelectedItem(rs1.getString("jns_kelamin"));
                            cbJP.setSelectedItem(rs1.getString("jns_periksa"));
                            cb_dokter.setSelectedItem(rs1.getString("kd_dokter"));
                            txtbiaya.setText(rs1.getString("biaya"));
                            cbObat.setSelectedItem(rs1.getString("obat"));
                            txtHarga.setText(rs1.getString("harga"));
                            JOptionPane.showMessageDialog(this, "DATA ADA, SILAHKAN EDIT!!!");
                        } else {
                            JOptionPane.showMessageDialog(this, "DATA TIDAK DITEMUKAN!!!");
                            HapusData2();
                        }
                    }
                }
                tampilketabel();
            } catch (SQLException e) {
            }
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtkode = new javax.swing.JTextField();
        txtpasien = new javax.swing.JTextField();
        cb_jk = new javax.swing.JComboBox<>();
        cbJP = new javax.swing.JComboBox<>();
        cb_dokter = new javax.swing.JComboBox<>();
        txtdokter = new javax.swing.JTextField();
        txtbiaya = new javax.swing.JTextField();
        cbObat = new javax.swing.JComboBox<>();
        txtHarga = new javax.swing.JTextField();
        cbCari = new javax.swing.JButton();
        jbSimpan = new javax.swing.JButton();
        cbUbah = new javax.swing.JButton();
        cbDelete = new javax.swing.JButton();
        jbHapus = new javax.swing.JButton();
        jbKeluar = new javax.swing.JButton();
        jScroll = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        cbCari1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Pasien");

        jLabel2.setText("Kode Pasien");

        jLabel3.setText("Nama Pasien");

        jLabel4.setText("Jenis Kelamin");

        jLabel5.setText("Jenis Periksa");

        jLabel6.setText("Kode Dokter");

        jLabel7.setText("Nama Dokter");

        jLabel8.setText("Biaya Periksa");

        jLabel9.setText("Obat");

        jLabel10.setText("Harga Obat");

        txtkode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkodeActionPerformed(evt);
            }
        });

        cb_jk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbJP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cb_dokter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_dokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_dokterActionPerformed(evt);
            }
        });

        cbObat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbCari.setText("Cari");
        cbCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCariActionPerformed(evt);
            }
        });

        jbSimpan.setText("Simpan");
        jbSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSimpanActionPerformed(evt);
            }
        });

        cbUbah.setText("Ubah");

        cbDelete.setText("Delete");
        cbDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDeleteActionPerformed(evt);
            }
        });

        jbHapus.setText("Clear");

        jbKeluar.setText("Keluar");
        jbKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbKeluarActionPerformed(evt);
            }
        });

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScroll.setViewportView(tabel);

        cbCari1.setText("Data Dokter");
        cbCari1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCari1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtdokter))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtpasien, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(txtkode)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb_jk, 0, 130, Short.MAX_VALUE)
                                    .addComponent(cbJP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cb_dokter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtbiaya)
                                    .addComponent(cbObat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtHarga))))
                        .addGap(18, 18, 18)
                        .addComponent(cbCari)
                        .addGap(18, 18, 18)
                        .addComponent(cbCari1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 67, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(277, 277, 277))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSimpan)
                .addGap(18, 18, 18)
                .addComponent(cbUbah)
                .addGap(18, 18, 18)
                .addComponent(cbDelete)
                .addGap(18, 18, 18)
                .addComponent(jbHapus)
                .addGap(18, 18, 18)
                .addComponent(jbKeluar)
                .addGap(104, 104, 104))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtkode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCari)
                    .addComponent(cbCari1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtpasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cb_jk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbJP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cb_dokter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtdokter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtbiaya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSimpan)
                    .addComponent(cbUbah)
                    .addComponent(cbDelete)
                    .addComponent(jbHapus)
                    .addComponent(jbKeluar))
                .addGap(18, 18, 18)
                .addComponent(jScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(616, 724));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtkodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkodeActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        tampilketabel();
    }//GEN-LAST:event_formWindowOpened

    private void jbSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSimpanActionPerformed
        // TODO add your handling code here:
        try {
            koneksi ObHrgoneksi1 = new koneksi();
            try (Connection connection = ObHrgoneksi1.openConnect()) {
                Statement st1 = (Statement) connection.createStatement();
                String sql1 = "insert into pasien(kd_pasien, nm_pasien, jns_kelamin, jns_periksa, kd_dokter, biaya, obat, harga) "
                        + "values('" + txtkode.getText()
                        + "','" + txtpasien.getText()
                        + "','" + cb_jk.getSelectedItem().toString()
                        + "','" + cbJP.getSelectedItem().toString()
                        + "','" + cb_dokter.getSelectedItem().toString()
                        + "','" + txtbiaya.getText()
                        + "','" + cbObat.getSelectedItem().toString()
                        + "','" + txtHarga.getText() + "')";
                int rows1 = st1.executeUpdate(sql1);

                if (rows1 == 1) {
                    JOptionPane.showMessageDialog(this, "Data Sukses Di Tambahkan!!!");
                }

                tampilketabel();
            }
        } catch (SQLException e) {
        }
    }//GEN-LAST:event_jbSimpanActionPerformed

    private void cb_dokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_dokterActionPerformed
        // TODO add your handling code here:
        Dokter();
    }//GEN-LAST:event_cb_dokterActionPerformed

    private void cbCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCariActionPerformed
        // TODO add your handling code here:
        CariData();
    }//GEN-LAST:event_cbCariActionPerformed

    private void cbCari1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCari1ActionPerformed
        // TODO add your handling code here:
        dokter form1 = new dokter(); //Untuk memanggil form dokter
        form1.setVisible(true);
    }//GEN-LAST:event_cbCari1ActionPerformed

    private void cbDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDeleteActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cbDeleteActionPerformed

    private void jbKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbKeluarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        menuUtama form1 = new menuUtama();
        form1.setVisible(true);
    }//GEN-LAST:event_jbKeluarActionPerformed

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
            java.util.logging.Logger.getLogger(pasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new pasien().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cbCari;
    private javax.swing.JButton cbCari1;
    private javax.swing.JButton cbDelete;
    private javax.swing.JComboBox<String> cbJP;
    private javax.swing.JComboBox<String> cbObat;
    private javax.swing.JButton cbUbah;
    private javax.swing.JComboBox<String> cb_dokter;
    private javax.swing.JComboBox<String> cb_jk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScroll;
    private javax.swing.JButton jbHapus;
    private javax.swing.JButton jbKeluar;
    private javax.swing.JButton jbSimpan;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtbiaya;
    private javax.swing.JTextField txtdokter;
    private javax.swing.JTextField txtkode;
    private javax.swing.JTextField txtpasien;
    // End of variables declaration//GEN-END:variables
}

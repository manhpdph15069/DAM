package VIEW;

import DAO.NhanVienDAO;
import Utils.Auth;
import Utils.MsgBox;
import Utils.XImage;
import Utils.utilityHelper;
import static java.awt.Color.pink;
import static java.awt.Color.white;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.NhanVien;

public class nhanVienForm extends javax.swing.JInternalFrame {

    NhanVienDAO dao = new NhanVienDAO();
    int row = -1;

    /**
     * Creates new form nhanVienJInternalFrame
     */
    public nhanVienForm() {
        initComponents();
        init();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        pnlEdit = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        lblMK = new javax.swing.JLabel();
        lblMKM = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtXacNhanMK = new javax.swing.JPasswordField();
        txtMK = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        rdoTruongPhong = new javax.swing.JRadioButton();
        rdoNhanVien = new javax.swing.JRadioButton();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        txtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        pnlList = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("QUẢN LÝ NHÂN VIÊN");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN QUẢN TRỊ");

        jLabel2.setText("Mã nhân viên");

        txtMaNV.setName("Mã nhân viên"); // NOI18N

        lblMK.setText("Mật khẩu");

        lblMKM.setText("Xác nhận mật khẩu");

        txtHoTen.setName("Họ và tên"); // NOI18N

        jLabel5.setText("Họ và tên");

        txtXacNhanMK.setName("Xác nhận mật khẩu"); // NOI18N

        txtMK.setName("Mật khẩu"); // NOI18N

        jLabel6.setText("Vai trò");

        buttonGroup1.add(rdoTruongPhong);
        rdoTruongPhong.setSelected(true);
        rdoTruongPhong.setText("Trưởng phòng ");

        buttonGroup1.add(rdoNhanVien);
        rdoNhanVien.setText("Nhân viên");

        btnInsert.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add to basket.png"))); // NOI18N
        btnInsert.setText("Thêm");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Notes.png"))); // NOI18N
        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Unordered list.png"))); // NOI18N
        btnClear.setText("Mới");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnFirst.setBackground(new java.awt.Color(51, 51, 255));
        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dau.png"))); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrev.setBackground(new java.awt.Color(51, 51, 255));
        btnPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/lui.png"))); // NOI18N
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setBackground(new java.awt.Color(255, 153, 0));
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/tien.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setBackground(new java.awt.Color(255, 153, 0));
        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cuoi.png"))); // NOI18N
        btnLast.setToolTipText("");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        jLabel7.setText("Email");

        javax.swing.GroupLayout pnlEditLayout = new javax.swing.GroupLayout(pnlEdit);
        pnlEdit.setLayout(pnlEditLayout);
        pnlEditLayout.setHorizontalGroup(
            pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaNV)
                    .addComponent(txtHoTen)
                    .addComponent(txtXacNhanMK)
                    .addComponent(txtMK)
                    .addGroup(pnlEditLayout.createSequentialGroup()
                        .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(lblMK)
                            .addComponent(lblMKM)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addGroup(pnlEditLayout.createSequentialGroup()
                                .addComponent(rdoTruongPhong)
                                .addGap(18, 18, 18)
                                .addComponent(rdoNhanVien))
                            .addGroup(pnlEditLayout.createSequentialGroup()
                                .addComponent(btnInsert)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClear)
                                .addGap(29, 29, 29)
                                .addComponent(btnFirst)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPrev)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNext)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLast))
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtEmail))
                .addContainerGap())
        );
        pnlEditLayout.setVerticalGroup(
            pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMK)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMKM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtXacNhanMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoTruongPhong)
                    .addComponent(rdoNhanVien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnClear)
                    .addComponent(btnFirst)
                    .addComponent(btnPrev)
                    .addComponent(btnNext)
                    .addComponent(btnLast))
                .addGap(65, 65, 65))
        );

        tabs.addTab("CẬP NHẬT", new javax.swing.ImageIcon(getClass().getResource("/icon/Edit.png")), pnlEdit, "Cập nhật"); // NOI18N

        pnlList.setLayout(new java.awt.BorderLayout());

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "MÃ NV", "MẬT KHẨU", "HỌ VÀ TÊN", "VAI TRÒ", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNhanVien.setEditingRow(1);
        tblNhanVien.setRowHeight(25);
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);
        if (tblNhanVien.getColumnModel().getColumnCount() > 0) {
            tblNhanVien.getColumnModel().getColumn(2).setPreferredWidth(140);
        }

        pnlList.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        tabs.addTab("DANH SÁCH", new javax.swing.ImageIcon(getClass().getResource("/icon/List.png")), pnlList, "Danh sách"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tabs)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabs)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        last();
    }//GEN-LAST:event_btnLastActionPerformed


    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

    }//GEN-LAST:event_formInternalFrameOpened

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        if (evt.getClickCount() == 2) {
            this.row = tblNhanVien.getSelectedRow();
            String manv = (String) tblNhanVien.getValueAt(this.row, 0);
            NhanVien nv = dao.selectByID(manv);
            txtEmail.setText(nv.getEmail());
            txtMaNV.setText(nv.getMaNV());
            txtHoTen.setText(nv.getHoTen());
            if (nv.isVaiTro()) {
                rdoTruongPhong.setSelected(true);
            } else {
                rdoNhanVien.setSelected(true);
            }
            txtMK.setEnabled(false);
            txtXacNhanMK.setEnabled(false);
            tabs.setSelectedIndex(0);
            this.updateStatus();
        }
    }//GEN-LAST:event_tblNhanVienMouseClicked

    public boolean checkTrungMa(JTextField txt) {
        txt.setBackground(white);
        if (dao.selectByID(txt.getText()) == null) {
            return true;
        } else {
            txt.setBackground(pink);
            MsgBox.alert(this, txt.getName() + " đã bị tồn tại.");
            return false;
        }
    }

    public int themtrung(JTextField t) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (dao.trung(t.getText()) != null) {
            NhanVien nv = getForm();
            dao.checkTrung(nv);
            fillTable();
            clearForm();
            MsgBox.alert(this, "Thêm thành công");
            return 1;
        } else {
            if (dao.selectByID(t.getText()) == null) {
                return 2;
            } else {
                t.setBackground(pink);
                MsgBox.alert(this, "Mã đã bị tồn tại.");
                return 3;
            }
        }
    }
    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        if (utilityHelper.checkNullText(txtMaNV)
                && utilityHelper.checkNullPass(txtMK)
                && utilityHelper.checkNullPass(txtXacNhanMK)
                && utilityHelper.checkNullText(txtHoTen)
                && utilityHelper.checkNullText(txtEmail)) {
            if (utilityHelper.checkPass(txtMK)
                    && utilityHelper.checkName(txtHoTen)
                    && utilityHelper.checkEmail(txtEmail)) {
                try {
                    if (themtrung(txtMaNV)==1) {
                        return;
                    }
                        insert();
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(nhanVienForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(nhanVienForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (utilityHelper.checkNullText(txtHoTen)
                && utilityHelper.checkNullText(txtEmail)
                && utilityHelper.checkName(txtHoTen)
                && utilityHelper.checkEmail(txtEmail)) {

            update();
        }

    }//GEN-LAST:event_btnUpdateActionPerformed
    public boolean checkChinhMinh(JTextField txt) {
        NhanVien nv = dao.selectByID(txt.getText());
        if (nv.getMaNV().equals(Auth.user.getMaNV())) {
            MsgBox.alert(this, "bạn không được xóa chính mình.");
            return false;
        } else {
            return true;
        }
    }
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (Auth.user.isVaiTro()) {
            if (checkChinhMinh(txtMaNV)) {
                delete();
            }
        } else {
            MsgBox.alert(this, "Chỉ trưởng phòng mới được phép xóa");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearForm();
        txtMK.setEnabled(true);
        txtXacNhanMK.setEnabled(true);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        first();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        prev();
    }//GEN-LAST:event_btnPrevActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMK;
    private javax.swing.JLabel lblMKM;
    private javax.swing.JPanel pnlEdit;
    private javax.swing.JPanel pnlList;
    private javax.swing.JRadioButton rdoNhanVien;
    private javax.swing.JRadioButton rdoTruongPhong;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JPasswordField txtMK;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JPasswordField txtXacNhanMK;
    // End of variables declaration//GEN-END:variables

    void init() {
        setFrameIcon((Icon) XImage.APP_ICON1);
        this.fillTable();
        this.row = -1;
        this.updateStatus();
    }

    public String khongHienMK(String pass) {
        String sao = "";
        for (int i = 0; i < pass.length(); i++) {
            sao += "*";
        }
        return sao;
    }

    void insert() {
        NhanVien nv = getForm();
        String mk2 = new String(txtXacNhanMK.getPassword());
        if (!mk2.equals(nv.getMatKhau())) {
            MsgBox.alert(this, "Xác nhận mật khẩu không đúng");
        } else {

            dao.insert(nv);
            this.fillTable();
            this.clearForm();
            MsgBox.alert(this, "Thêm Mới thành công");

        }
    }

    void update() {
        NhanVien nv = getForm();
        String mk2 = new String(txtXacNhanMK.getPassword());
//        String manv = txtMaNV.getText();
//        if (manv.equals(Auth.user.getMaNV())) {
//            
//        }
//        if (!mk2.equals(nv.getMatKhau())) {
//            MsgBox.alert(this, "Xác nhận mật khẩu không đúng");
//        } else {
        try {
            dao.update(nv);
            this.fillTable();
            this.clearForm();
            MsgBox.alert(this, "Cập Nhập thành công");
        } catch (Exception e) {
            MsgBox.alert(this, "Cập nhập thất bại");
        }
//        }
    }

    void delete() {
        if (!Auth.isManager()) {
            MsgBox.alert(this, "Bạn không có quyền xóa nhân viên");
        } else {
            String manv = txtMaNV.getText();
            if (manv.equals(Auth.user.getMaNV())) {
                MsgBox.alert(this, "Bạn không được xóa chính bạn");
            } else if (MsgBox.comfirm(this, "Bạn thực sự muốn xóa nhân viên này?")) {
                try {
                    dao.delete(manv);
                    this.fillTable();
                    this.clearForm();
                    MsgBox.alert(this, "Xóa thành công");
                } catch (Exception e) {
                    MsgBox.alert(this, "Xóa thất bại");
                }
            }
        }
    }

    void clearForm() {
        NhanVien nv = new NhanVien();
        try {
            this.setForm(nv);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(nhanVienForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(nhanVienForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.row = -1;
        this.updateStatus();
    }

    void edit() {
        String manv = (String) tblNhanVien.getValueAt(this.row, 0);
        NhanVien nv = dao.selectByID(manv);
        try {
            this.setForm(nv);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(nhanVienForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(nhanVienForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        tabs.setSelectedIndex(0);//quay về form số 0
        this.updateStatus();

    }

    void first() {
        this.row = 0;
        this.edit();
    }

    void prev() {
        if (this.row > 0) {
            this.row--;
            this.edit();
        }
    }

    void next() {
        if (this.row < tblNhanVien.getRowCount() - 1) {
            this.row++;
            this.edit();
        }
    }

    void last() {
        this.row = tblNhanVien.getRowCount() - 1;
        this.edit();
    }

    void fillTable() {
        DefaultTableModel dtm = (DefaultTableModel) this.tblNhanVien.getModel();
        dtm.setRowCount(0);
        try {
            List<NhanVien> list = dao.selectAll();//đọc dữ liệu từ CSDL
            for (NhanVien nv : list) {
                Object[] row = {
                    nv.getMaNV(),
                    "******",
                    nv.getHoTen(),
                    nv.isVaiTro() ? "Trưởng Phòng" : "Nhân Viên",
                    nv.getEmail()
                };
                dtm.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu");
        }
    }

    void setForm(NhanVien n) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        txtMaNV.setText(n.getMaNV());
        txtHoTen.setText(n.getHoTen());
        txtMK.setText(n.getMatKhau());
        txtXacNhanMK.setText(n.getMatKhau());
        rdoTruongPhong.setSelected(n.isVaiTro());
        rdoNhanVien.setSelected(!n.isVaiTro());
        txtEmail.setText(n.getEmail());
    }

    NhanVien getForm() {
        NhanVien nv = new NhanVien();
        nv.setMaNV(txtMaNV.getText());
        nv.setHoTen(txtHoTen.getText());
        nv.setMatKhau(new String(txtMK.getPassword()));
        nv.setVaiTro(rdoTruongPhong.isSelected());
        nv.setEmail(txtEmail.getText());
        return nv;
    }

    void updateStatus() {
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblNhanVien.getRowCount() - 1);
        //Trạng thái form
        txtMaNV.setEditable(!edit);
        btnInsert.setEnabled(!edit);
        btnUpdate.setEnabled(edit);
        btnDelete.setEnabled(edit);
        //trạng thái điều hướng
        btnFirst.setEnabled(edit && !first);
        btnPrev.setEnabled(edit && !first);
        btnNext.setEnabled(edit && !last);
        btnLast.setEnabled(edit && !last);
    }
}

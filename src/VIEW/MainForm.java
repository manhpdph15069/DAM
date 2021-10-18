package VIEW;

import Utils.Auth;
import Utils.MsgBox;
import Utils.XImage;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.Timer;

public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form formCha
     */
    public MainForm() {
        initComponents();
        init();
        
    }
       //Dùng để mở JInternalFrame
    private void openX(JInternalFrame x) {
        for (JInternalFrame frmChild : jdesktop.getAllFrames()) {
            frmChild.dispose();
        }
        x.setLocation(this.getWidth() / 2 - x.getWidth() / 2,
                (this.getHeight() - 20) / 2 - x.getHeight() / 2 - 60);
        jdesktop.add(x);
        x.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu = new javax.swing.JPopupMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jToolBar1 = new javax.swing.JToolBar();
        btnDangXuat = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        btnKetThuc = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        btnCHuyenDe = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        btnKhoaHocj = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        btnNguoiHojc = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        btnHuongDan = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblDongHo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jdesktop = new javax.swing.JDesktopPane(){
            protected void  paintComponent (Graphics g){
                Image img = new ImageIcon(this.getClass().getResource("/icon/logo.png")).getImage();
                try {
                    Graphics g2d = (Graphics2D)g;
                    double x= img.getWidth(null);
                    double y= img.getHeight(null);
                    //g2d.scale(getWidth()/x,getHeight()/y);
                    //g2d.drawImage(img, 0, 0, this);
                    g2d.drawImage(img, this.getWidth()/4+100,this.getHeight()/4-100,this);
                } catch (Exception e) {
                    System.out.println("Gap loi");
                }
            }
        };
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuHeThong = new javax.swing.JMenu();
        mnidangNhap = new javax.swing.JMenuItem();
        mniDangXuat = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mniDoiMatKhau = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mniKetThuc = new javax.swing.JMenuItem();
        mnuQuanLy = new javax.swing.JMenu();
        mniNguoiHojc = new javax.swing.JMenuItem();
        mniChuyenDe = new javax.swing.JMenuItem();
        mniKhoaHocj = new javax.swing.JMenuItem();
        mniNhanVien = new javax.swing.JMenuItem();
        mniHojcVien = new javax.swing.JMenuItem();
        mnuThongKe = new javax.swing.JMenu();
        mniLuongNguoiHocj = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mniBangDiem = new javax.swing.JMenuItem();
        mniDiemChuyenDe = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mniDoanhThu = new javax.swing.JMenuItem();
        mnuTroGiup = new javax.swing.JMenu();
        mniHuongDan = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mniGioiThieu = new javax.swing.JMenuItem();

        jMenuItem15.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Funny.png"))); // NOI18N
        jMenuItem15.setText("CHÚC BẠN HỌC TẬP TỐT");
        jMenuItem15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        popupMenu.add(jMenuItem15);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HỆ THỐNG QUẢN LÝ ĐÀO TẠO");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/icon/logo.png")).getImage());

        btnDangXuat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Exit.png"))); // NOI18N
        btnDangXuat.setText("Đăng xuất");
        btnDangXuat.setFocusable(false);
        btnDangXuat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDangXuat.setMargin(new java.awt.Insets(12, 30, 12, 30));
        btnDangXuat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDangXuat);
        jToolBar1.add(jSeparator8);

        btnKetThuc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnKetThuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Stop.png"))); // NOI18N
        btnKetThuc.setText("Kết thúc");
        btnKetThuc.setFocusable(false);
        btnKetThuc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKetThuc.setMargin(new java.awt.Insets(12, 30, 12, 30));
        btnKetThuc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetThucActionPerformed(evt);
            }
        });
        jToolBar1.add(btnKetThuc);
        jToolBar1.add(jSeparator7);

        btnCHuyenDe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCHuyenDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Lists.png"))); // NOI18N
        btnCHuyenDe.setText("Chuyên đề");
        btnCHuyenDe.setFocusable(false);
        btnCHuyenDe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCHuyenDe.setMargin(new java.awt.Insets(12, 30, 12, 30));
        btnCHuyenDe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCHuyenDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCHuyenDeActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCHuyenDe);
        jToolBar1.add(jSeparator9);

        btnKhoaHocj.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnKhoaHocj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Certificate.png"))); // NOI18N
        btnKhoaHocj.setText("Khóa học");
        btnKhoaHocj.setFocusable(false);
        btnKhoaHocj.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKhoaHocj.setMargin(new java.awt.Insets(12, 30, 12, 30));
        btnKhoaHocj.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnKhoaHocj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoaHocjActionPerformed(evt);
            }
        });
        jToolBar1.add(btnKhoaHocj);
        jToolBar1.add(jSeparator10);

        btnNguoiHojc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNguoiHojc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Conference.png"))); // NOI18N
        btnNguoiHojc.setText("Người học");
        btnNguoiHojc.setFocusable(false);
        btnNguoiHojc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNguoiHojc.setMargin(new java.awt.Insets(12, 30, 12, 30));
        btnNguoiHojc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNguoiHojc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNguoiHojcActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNguoiHojc);
        jToolBar1.add(jSeparator6);

        btnHuongDan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnHuongDan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Globe.png"))); // NOI18N
        btnHuongDan.setText("Hướng dẫn");
        btnHuongDan.setFocusable(false);
        btnHuongDan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHuongDan.setMargin(new java.awt.Insets(12, 30, 12, 30));
        btnHuongDan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHuongDan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuongDanActionPerformed(evt);
            }
        });
        jToolBar1.add(btnHuongDan);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Info.png"))); // NOI18N
        jLabel1.setText("Hệ quản lý đào tạo");
        jPanel1.add(jLabel1, java.awt.BorderLayout.CENTER);

        lblDongHo.setForeground(new java.awt.Color(0, 51, 255));
        lblDongHo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Alarm.png"))); // NOI18N
        lblDongHo.setText("10:55 PM");
        jPanel1.add(lblDongHo, java.awt.BorderLayout.LINE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout jdesktopLayout = new javax.swing.GroupLayout(jdesktop);
        jdesktop.setLayout(jdesktopLayout);
        jdesktopLayout.setHorizontalGroup(
            jdesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 798, Short.MAX_VALUE)
        );
        jdesktopLayout.setVerticalGroup(
            jdesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdesktop)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdesktop)
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        mnuHeThong.setText("Hệ thống");
        mnuHeThong.setMargin(new java.awt.Insets(5, 5, 5, 5));

        mnidangNhap.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        mnidangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Key.png"))); // NOI18N
        mnidangNhap.setText("Đăng nhập");
        mnidangNhap.setMargin(new java.awt.Insets(5, 5, 5, 5));
        mnidangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnidangNhapActionPerformed(evt);
            }
        });
        mnuHeThong.add(mnidangNhap);

        mniDangXuat.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        mniDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Log out.png"))); // NOI18N
        mniDangXuat.setText("Đăng xuất");
        mniDangXuat.setMargin(new java.awt.Insets(5, 5, 5, 5));
        mniDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDangXuatActionPerformed(evt);
            }
        });
        mnuHeThong.add(mniDangXuat);
        mnuHeThong.add(jSeparator1);

        mniDoiMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Refresh.png"))); // NOI18N
        mniDoiMatKhau.setText("Đổi mật khẩu");
        mniDoiMatKhau.setMargin(new java.awt.Insets(5, 5, 5, 5));
        mniDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDoiMatKhauActionPerformed(evt);
            }
        });
        mnuHeThong.add(mniDoiMatKhau);
        mnuHeThong.add(jSeparator2);

        mniKetThuc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        mniKetThuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Stop.png"))); // NOI18N
        mniKetThuc.setText("Kết thúc");
        mniKetThuc.setMargin(new java.awt.Insets(5, 5, 5, 5));
        mniKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniKetThucActionPerformed(evt);
            }
        });
        mnuHeThong.add(mniKetThuc);

        jMenuBar1.add(mnuHeThong);

        mnuQuanLy.setText("Quản lý");
        mnuQuanLy.setMargin(new java.awt.Insets(5, 5, 5, 5));

        mniNguoiHojc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        mniNguoiHojc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Conference.png"))); // NOI18N
        mniNguoiHojc.setText("Người học");
        mniNguoiHojc.setMargin(new java.awt.Insets(5, 5, 5, 5));
        mniNguoiHojc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniNguoiHojcActionPerformed(evt);
            }
        });
        mnuQuanLy.add(mniNguoiHojc);

        mniChuyenDe.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
        mniChuyenDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Lists.png"))); // NOI18N
        mniChuyenDe.setText("Chuyên đề");
        mniChuyenDe.setMargin(new java.awt.Insets(5, 5, 5, 5));
        mniChuyenDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniChuyenDeActionPerformed(evt);
            }
        });
        mnuQuanLy.add(mniChuyenDe);

        mniKhoaHocj.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_MASK));
        mniKhoaHocj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Certificate.png"))); // NOI18N
        mniKhoaHocj.setText("Khóa học");
        mniKhoaHocj.setMargin(new java.awt.Insets(5, 5, 5, 5));
        mniKhoaHocj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniKhoaHocjActionPerformed(evt);
            }
        });
        mnuQuanLy.add(mniKhoaHocj);

        mniNhanVien.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_MASK));
        mniNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/User group.png"))); // NOI18N
        mniNhanVien.setText("Nhân viên");
        mniNhanVien.setMargin(new java.awt.Insets(5, 5, 5, 5));
        mniNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniNhanVienActionPerformed(evt);
            }
        });
        mnuQuanLy.add(mniNhanVien);

        mniHojcVien.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.CTRL_MASK));
        mniHojcVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/User.png"))); // NOI18N
        mniHojcVien.setText("Học viên");
        mniHojcVien.setMargin(new java.awt.Insets(5, 5, 5, 5));
        mniHojcVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniHojcVienActionPerformed(evt);
            }
        });
        mnuQuanLy.add(mniHojcVien);

        jMenuBar1.add(mnuQuanLy);

        mnuThongKe.setText("Thống kê");
        mnuThongKe.setMargin(new java.awt.Insets(5, 5, 5, 5));

        mniLuongNguoiHocj.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.ALT_MASK));
        mniLuongNguoiHocj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Clien list.png"))); // NOI18N
        mniLuongNguoiHocj.setText("Lượng Người Học");
        mniLuongNguoiHocj.setMargin(new java.awt.Insets(5, 5, 5, 5));
        mniLuongNguoiHocj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLuongNguoiHocjActionPerformed(evt);
            }
        });
        mnuThongKe.add(mniLuongNguoiHocj);
        mnuThongKe.add(jSeparator3);

        mniBangDiem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.ALT_MASK));
        mniBangDiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Card file.png"))); // NOI18N
        mniBangDiem.setText("Bảng Điểm");
        mniBangDiem.setMargin(new java.awt.Insets(5, 5, 5, 5));
        mniBangDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniBangDiemActionPerformed(evt);
            }
        });
        mnuThongKe.add(mniBangDiem);

        mniDiemChuyenDe.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.ALT_MASK));
        mniDiemChuyenDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Bar chart.png"))); // NOI18N
        mniDiemChuyenDe.setText("Điểm Chuyên Đề");
        mniDiemChuyenDe.setMargin(new java.awt.Insets(5, 5, 5, 5));
        mniDiemChuyenDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDiemChuyenDeActionPerformed(evt);
            }
        });
        mnuThongKe.add(mniDiemChuyenDe);
        mnuThongKe.add(jSeparator4);

        mniDoanhThu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.ALT_MASK));
        mniDoanhThu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Dollar.png"))); // NOI18N
        mniDoanhThu.setText("Doanh thu");
        mniDoanhThu.setMargin(new java.awt.Insets(5, 5, 5, 5));
        mniDoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDoanhThuActionPerformed(evt);
            }
        });
        mnuThongKe.add(mniDoanhThu);

        jMenuBar1.add(mnuThongKe);

        mnuTroGiup.setText("Trợ giúp");
        mnuTroGiup.setMargin(new java.awt.Insets(5, 5, 5, 5));

        mniHuongDan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        mniHuongDan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Globe.png"))); // NOI18N
        mniHuongDan.setText("Hướng dẫn sử dụng");
        mniHuongDan.setMargin(new java.awt.Insets(5, 5, 5, 5));
        mniHuongDan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniHuongDanActionPerformed(evt);
            }
        });
        mnuTroGiup.add(mniHuongDan);
        mnuTroGiup.add(jSeparator5);

        mniGioiThieu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        mniGioiThieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Brick house.png"))); // NOI18N
        mniGioiThieu.setText("Giới thiệu sản phẩm");
        mniGioiThieu.setMargin(new java.awt.Insets(5, 5, 5, 5));
        mniGioiThieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniGioiThieuActionPerformed(evt);
            }
        });
        mnuTroGiup.add(mniGioiThieu);

        jMenuBar1.add(mnuTroGiup);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        dangXuat();
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void mniDiemChuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDiemChuyenDeActionPerformed
        // TODO add your handling code here:
        openThongKe(2);
    }//GEN-LAST:event_mniDiemChuyenDeActionPerformed

    private void mniNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniNhanVienActionPerformed
        // TODO add your handling code here:
        openNhanVien();
    }//GEN-LAST:event_mniNhanVienActionPerformed

    private void mniDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDoiMatKhauActionPerformed
        openDoiMatKhau();
    }//GEN-LAST:event_mniDoiMatKhauActionPerformed

    private void mniDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDangXuatActionPerformed
       dangXuat();
    }//GEN-LAST:event_mniDangXuatActionPerformed

    private void btnKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetThucActionPerformed
        // TODO add your handling code here:
        ketThuc();
    }//GEN-LAST:event_btnKetThucActionPerformed

    private void mniKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniKetThucActionPerformed
        // TODO add your handling code here:
        ketThuc();
    }//GEN-LAST:event_mniKetThucActionPerformed

    private void mniChuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniChuyenDeActionPerformed
        openChuyenDe();
    }//GEN-LAST:event_mniChuyenDeActionPerformed

    private void btnCHuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCHuyenDeActionPerformed
        // TODO add your handling code here:
        openChuyenDe();
    }//GEN-LAST:event_btnCHuyenDeActionPerformed

    private void mniNguoiHojcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniNguoiHojcActionPerformed
        // TODO add your handling code here:
        openNguoihoc();
    }//GEN-LAST:event_mniNguoiHojcActionPerformed

    private void btnNguoiHojcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNguoiHojcActionPerformed
        // TODO add your handling code here:
        openNguoihoc();
    }//GEN-LAST:event_btnNguoiHojcActionPerformed

    private void mniKhoaHocjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniKhoaHocjActionPerformed
        // TODO add your handling code here:
        openKhoaHoc();
    }//GEN-LAST:event_mniKhoaHocjActionPerformed

    private void btnKhoaHocjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoaHocjActionPerformed
        // TODO add your handling code here:
        openKhoaHoc();
    }//GEN-LAST:event_btnKhoaHocjActionPerformed

    private void mniHojcVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniHojcVienActionPerformed
        // TODO add your handling code here:
        openhocVien();
    }//GEN-LAST:event_mniHojcVienActionPerformed

    private void mniLuongNguoiHocjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLuongNguoiHocjActionPerformed
        // TODO add your handling code here:
        openThongKe(1);
    }//GEN-LAST:event_mniLuongNguoiHocjActionPerformed

    private void mniBangDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniBangDiemActionPerformed
        // TODO add your handling code here:
        openThongKe(0);
    }//GEN-LAST:event_mniBangDiemActionPerformed

    private void mniDoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDoanhThuActionPerformed
        // TODO add your handling code here:
        openThongKe(3);
    }//GEN-LAST:event_mniDoanhThuActionPerformed

    private void mniGioiThieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniGioiThieuActionPerformed
        // TODO add your handling code here:
        openGioiThieu();
    }//GEN-LAST:event_mniGioiThieuActionPerformed

    private void btnHuongDanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuongDanActionPerformed
        // TODO add your handling code here:
        openHuongDan();
    }//GEN-LAST:event_btnHuongDanActionPerformed

    private void mniHuongDanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniHuongDanActionPerformed
        // TODO add your handling code here:
        openHuongDan();
    }//GEN-LAST:event_mniHuongDanActionPerformed

    private void mnidangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnidangNhapActionPerformed
        // TODO add your handling code here:
       new DangNhap(this, true).setVisible(true);
    }//GEN-LAST:event_mnidangNhapActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCHuyenDe;
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnHuongDan;
    private javax.swing.JButton btnKetThuc;
    private javax.swing.JButton btnKhoaHocj;
    private javax.swing.JButton btnNguoiHojc;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JDesktopPane jdesktop;
    private javax.swing.JLabel lblDongHo;
    private javax.swing.JMenuItem mniBangDiem;
    private javax.swing.JMenuItem mniChuyenDe;
    private javax.swing.JMenuItem mniDangXuat;
    private javax.swing.JMenuItem mniDiemChuyenDe;
    private javax.swing.JMenuItem mniDoanhThu;
    private javax.swing.JMenuItem mniDoiMatKhau;
    private javax.swing.JMenuItem mniGioiThieu;
    private javax.swing.JMenuItem mniHojcVien;
    private javax.swing.JMenuItem mniHuongDan;
    private javax.swing.JMenuItem mniKetThuc;
    private javax.swing.JMenuItem mniKhoaHocj;
    private javax.swing.JMenuItem mniLuongNguoiHocj;
    private javax.swing.JMenuItem mniNguoiHojc;
    private javax.swing.JMenuItem mniNhanVien;
    private javax.swing.JMenuItem mnidangNhap;
    private javax.swing.JMenu mnuHeThong;
    private javax.swing.JMenu mnuQuanLy;
    private javax.swing.JMenu mnuThongKe;
    private javax.swing.JMenu mnuTroGiup;
    private javax.swing.JPopupMenu popupMenu;
    // End of variables declaration//GEN-END:variables

    private void init() {
        setExtendedState(MainForm.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setIconImage(XImage.getAppIcon());
        new ChaoJDialog(this, true).setVisible(true);
        new DangNhap(this, true).setVisible(true);
        startDongHo();
    }
    
    void startDongHo(){
        new Timer(1000,new  ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               Date now = new Date();
               SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss a");
               String text = format.format(now);
               lblDongHo.setText(text);
           }
       }).start();
    }
    
    void openDoiMatKhau(){
        if (Auth.isLogin()) {
            new DoiMatKhau(this, true).setVisible(true);
        }else{
            MsgBox.alert(this, "Vui Lòng Đăng Nhập");
        }
    }
    
    void dangXuat(){
        Auth.clear();
        new DangNhap(this, true).setVisible(true);
    }
    
    void ketThuc(){
        if (MsgBox.comfirm(this, "Bạn muốn kết thúc ứng dụng?")) {
            System.exit(0);
        }
    }
    
    void openNhanVien(){
         if (Auth.isLogin()) {
            nhanVienForm nv = new nhanVienForm();
             openX(nv);
        }else{
            MsgBox.alert(this, "Vui lòng đăng nhập");
        }
    }
    
    void openKhoaHoc(){
         if (Auth.isLogin()) {
           khoaHocForm kh = new khoaHocForm();
             openX(kh);
        }else{
            MsgBox.alert(this, "Vui lòng đăng nhập");
        }
    }
    
    void openChuyenDe(){
        if (Auth.isLogin()) {
           chuyenDeForm cd = new chuyenDeForm();
            openX(cd);
        }else{
            MsgBox.alert(this, "Vui lòng đăng nhập");
        }
    }
    
    void openNguoihoc(){
        if(Auth.isLogin()){
           nguoiHocForm nh = new nguoiHocForm();
            openX(nh);
        }else{
            MsgBox.alert(this, "Vui lòng đăng nhập");
        }
    }
    
    void openhocVien(){
        if (Auth.isLogin()) {
            HocVienForm hv = new HocVienForm();
            openX(hv);
        }else{
            MsgBox.alert(this, "Vui lòng đăng nhập");
        }
    }
    
    void openThongKe(int index){
        if (Auth.isLogin()) {
            if (index == 3 && !Auth.isManager()) {
                MsgBox.alert(this, "Bạn không có quyền xem thông tin doanh thu");
            }else{
                thongKeForm tk = new thongKeForm(index);
                openX(tk);
                tk.selectTab(index);
            }
        }else{
            MsgBox.alert(this, "Vui lòng đăng nhập");
        }
    }
    
    void openGioiThieu(){
        new GioiTHieu(this, true).setVisible(true);
    }
    
    void openHuongDan(){
        try {
            Desktop.getDesktop().browse(new File("help/index.html").toURI());
            
        } catch (Exception e) {
            MsgBox.alert(this, "Không tìm thấy file hưỡng dẫn");
        }

    }
    
}

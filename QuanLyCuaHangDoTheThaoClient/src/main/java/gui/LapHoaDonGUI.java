package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.DecimalFormat;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

//import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class LapHoaDonGUI extends JFrame {
	private JPanel pnlBanHangMain;
	private JPanel pnlBanHangMainTop;

	private JLabel lblMaHDBan;
	private JTextField txtMaHDBan;
	private JLabel lblNgayBan;
	private JTextField txtNgayBan;
	private JLabel lblMaNV;
	private JTextField txtMaNV;
	private JLabel lblTenNV;
	private JTextField txtTenNV;
	private JLabel lblMaKH;
	private JTextField txtMaKH;
	private JLabel lblTenKH;
	private JTextField txtTenKH;
	private JLabel lblDiaChi;
	private JTextField txtDiaChi;
	private JLabel lblDienThoai;
	private JTextField txtDienThoai;
	private JButton btnTimKH;
	private JPanel pnlBanHangMainCenter;
	private JLabel lblMaSanPham;
	private JTextField txtMaSanPham;
	private JButton btnTimKiemMaSP;
	private JLabel lblTenSP;
	private JComboBox<String> cmbTenSP;
	private JLabel lblSoLuong;
	private JTextField txtSoLuong;
	private JLabel lblGiamGia;
	private JTextField txtGiamGia;
	private JLabel lblDonGia;
	private JTextField txtDonGia;
	private JPanel pnlBanHangMainTable;
	String header[] = { "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Đơn Giá", "Thành Tiền" };
	private JScrollPane scr;
	private JPanel pnlThanhTien;
	private JLabel lblThanhTien;
	private JLabel lblTongThanhTien;

	private JPanel pnlBanHangMainConTrol;
	private JButton btnLuuTT;
	private JButton btnXoaSP;
	private JButton btnSuaSP;
	private JButton btnXoaRong;
	private JButton btnInHD, btnInHD2;
	private JButton btnLuuHD;
	private JButton btnSuaHD = new JButton("Sửa");
	private JButton btnXoaHD = new JButton("Xóa");
	JTable tb;
	DefaultTableModel model;
	private double TongTien = 0.0;
	private DefaultTableModel modelHoaDon;
	private JTable tblHoaDon;
//	private ArrayList<entity.HoaDon> dsHD;
	private DefaultTableModel modedCTHoaDon;
	private JTable tblCTHoaDon;

	private JComboBox<String> cmbTimHoaDon;
	private JButton btnXoaRongHD;

	DecimalFormat formatter = new DecimalFormat("###,### VND");

	
	public LapHoaDonGUI() {
		pnlBanHangMain = new JPanel(null);
		
		add(pnlBanHangMain);
		pnlBanHangMainTop = new JPanel();
		pnlBanHangMainTop.setBounds(0, 0, 1128, 190);
		pnlBanHangMainTop.setBorder(BorderFactory.createTitledBorder("Thông tin chung"));
		pnlBanHangMainTop.setLayout(null);

		// TOP_LEFT
		pnlBanHangMainTop.add(lblMaHDBan = new JLabel("Mã Hóa Đơn: "));
		lblMaHDBan.setBounds(600, 20, 120, 20);
		pnlBanHangMainTop.add(txtMaHDBan = new JTextField());
		txtMaHDBan.setBounds(720, 20, 270, 20);
//		txtMaHDBan.setText(hoaDonFacade.getMaHDMoi());
		txtMaHDBan.setEditable(false);

		pnlBanHangMainTop.add(lblNgayBan = new JLabel("Ngày Bán: "));
		lblNgayBan.setBounds(600, 50, 120, 20);
		pnlBanHangMainTop.add(txtNgayBan = new JTextField());
		txtNgayBan.setBounds(720, 50, 270, 20);
		txtNgayBan.setText(String.valueOf(LocalDate.now()));
		txtNgayBan.setEditable(false);

		pnlBanHangMainTop.add(lblMaNV = new JLabel("Mã Nhân Viên: "));
		lblMaNV.setBounds(600, 80, 130, 20);
		pnlBanHangMainTop.add(txtMaNV = new JTextField());
		txtMaNV.setBounds(720, 80, 270, 20);
		txtMaNV.setEditable(false);

		pnlBanHangMainTop.add(lblTenNV = new JLabel("Tên Nhân Viên: "));
		lblTenNV.setBounds(600, 110, 150, 20);
		pnlBanHangMainTop.add(txtTenNV = new JTextField());
		txtTenNV.setBounds(720, 110, 270, 20);
		txtTenNV.setEditable(false);
		// TOP_RIGHT
		pnlBanHangMainTop.add(lblMaKH = new JLabel("Mã Khách Hàng: "));
		lblMaKH.setBounds(30, 20, 150, 20);
		pnlBanHangMainTop.add(txtMaKH = new JTextField());
		txtMaKH.setBounds(150, 20, 300, 20);
//		txtMaKH.setText(khachHangFacade.getMaMoiNhat());
		txtMaKH.setEditable(false);

		pnlBanHangMainTop.add(lblTenKH = new JLabel("Tên Khách Hàng: "));
		lblTenKH.setBounds(30, 50, 150, 20);
		pnlBanHangMainTop.add(txtTenKH = new JTextField());
		txtTenKH.setBounds(150, 50, 300, 20);

		pnlBanHangMainTop.add(lblDiaChi = new JLabel("Địa chỉ: "));
		lblDiaChi.setBounds(30, 80, 150, 20);
		pnlBanHangMainTop.add(txtDiaChi = new JTextField());
		txtDiaChi.setBounds(150, 80, 300, 20);

		pnlBanHangMainTop.add(lblDienThoai = new JLabel("Điện Thoại: "));
		lblDienThoai.setBounds(30, 110, 150, 20);
		pnlBanHangMainTop.add(txtDienThoai = new JTextField());
		txtDienThoai.setBounds(150, 110, 250, 20);
		pnlBanHangMainTop.add(btnTimKH = new JButton("Tìm"));
		btnTimKH.setBounds(395, 110, 55, 20);
//												PANEL_CENTER
		pnlBanHangMainCenter = new JPanel(null);
		pnlBanHangMainCenter.setBounds(0, 190, 1128, 100);
		pnlBanHangMainCenter.setBorder(BorderFactory.createTitledBorder("Thông tin sản phẩm: "));

//		
		pnlBanHangMainCenter.add(lblMaSanPham = new JLabel("Mã sản phẩm: "));
		lblMaSanPham.setBounds(30, 20, 150, 20);
		pnlBanHangMainCenter.add(txtMaSanPham = new JTextField());
		txtMaSanPham.setBounds(150, 20, 150, 20);
		pnlBanHangMainCenter.add(btnTimKiemMaSP = new JButton("Tìm"));
		btnTimKiemMaSP.setBounds(305, 20, 55, 20);

		pnlBanHangMainCenter.add(lblTenSP = new JLabel("Tên sản phẩm: "));
		lblTenSP.setBounds(30, 55, 150, 20);
		pnlBanHangMainCenter.add(cmbTenSP = new JComboBox<String>());

		/*
		 * try { sanPhams = sanPhamFacade.layDSSP(); for (SanPham sanPham : sanPhams) {
		 * cmbTenSP.addItem(sanPham.getTenSP()); } } catch (RemoteException e1) { //
		 * TODO Auto-generated catch block e1.printStackTrace(); } // add item vao
		 * combobox
		 */
//		AutoCompleteDecorator.decorate(cmbTenSP);
		cmbTenSP.setEditable(true);
		cmbTenSP.setSelectedIndex(-1);
		cmbTenSP.setBounds(150, 55, 210, 20);

		pnlBanHangMainCenter.add(lblSoLuong = new JLabel("Số Lượng: "));
		lblSoLuong.setBounds(430, 20, 150, 20);
		pnlBanHangMainCenter.add(txtSoLuong = new JTextField());
		txtSoLuong.setBounds(520, 20, 150, 20);

//		pnlBanHangMainCenter.add(lblGiamGia = new JLabel("Giảm giá (%): "));
//		lblGiamGia.setBounds(430, 55, 150, 20);
//		pnlBanHangMainCenter.add(txtGiamGia = new JTextField());
//		txtGiamGia.setText("0.0");
//		txtGiamGia.setBounds(520, 55, 150, 20);

		pnlBanHangMainCenter.add(lblDonGia = new JLabel("Đơn giá: "));
		lblDonGia.setBounds(770, 20, 150, 20);
		pnlBanHangMainCenter.add(txtDonGia = new JTextField());
		txtDonGia.setBounds(840, 20, 150, 20);
		txtDonGia.setEditable(false);

//													PANEL_TABLE
		pnlBanHangMainTable = new JPanel(null);
		pnlBanHangMainTable.setBounds(0, 290, 1128, 220);

		model = new DefaultTableModel(header, 0);
		tb = new JTable(model);
		tb.setBounds(5, 10, 1027, 200);
		pnlBanHangMainTable.add(scr = new JScrollPane(tb));
		scr.setBounds(5, 10, 1027, 200);

		// THÀNH TIỀN
		pnlThanhTien = new JPanel(null);
		pnlThanhTien.setBounds(600, 505, 1120, 50);
		pnlThanhTien.add(lblThanhTien = new JLabel("Tổng tiền thanh toán:"));
		lblThanhTien.setBounds(0, 10, 300, 25);
		lblThanhTien.setFont(new Font("Serif", Font.PLAIN, 20));
		pnlThanhTien.add(lblTongThanhTien = new JLabel(""));
		lblTongThanhTien.setBounds(200, 9, 350, 25);
		lblTongThanhTien.setText(String.valueOf(formatter.format(0.0)));
		lblTongThanhTien.setForeground(Color.red);
		lblTongThanhTien.setFont(new Font("Serif", Font.PLAIN, 22));

//													PANEL_CTRL
		pnlBanHangMainConTrol = new JPanel();
		pnlBanHangMainConTrol.setBounds(0, 560, 1128, 70);
		pnlBanHangMainConTrol.setBorder(BorderFactory.createTitledBorder("Bảng Điều Khiển"));
		pnlBanHangMainConTrol.add(btnLuuTT = new JButton("Thêm sản phẩm"));
		pnlBanHangMainConTrol.add(btnXoaSP = new JButton("Xóa sản phẩm"));
		pnlBanHangMainConTrol.add(btnSuaSP = new JButton("Sửa sản phẩm"));
		pnlBanHangMainConTrol.add(btnXoaRong = new JButton("Làm mới"));
		pnlBanHangMainConTrol.add(btnInHD = new JButton("In hóa đơn"));
		pnlBanHangMainConTrol.add(btnLuuHD = new JButton("Lưu hóa đơn"));

		pnlBanHangMain.add(pnlBanHangMainTop);
		pnlBanHangMain.add(pnlBanHangMainCenter);
		pnlBanHangMain.add(pnlBanHangMainTable);
		pnlBanHangMain.add(pnlThanhTien);
		pnlBanHangMain.add(pnlBanHangMainConTrol);

		/*
		 * btnLuuHD.addActionListener(this); btnLuuTT.addActionListener(this);
		 * btnTimKiemMaSP.addActionListener(this); btnXoaSP.addActionListener(this);
		 * btnSuaSP.addActionListener(this); btnXoaRong.addActionListener(this);
		 * btnTimKH.addActionListener(this); btnInHD.addActionListener(this);
		 * tb.addMouseListener(this);
		 */
		/*
		 * txtMaNV.setText(this.nhanVien.getMaNV()); // set ma nv cua user
		 * txtTenNV.setText(this.nhanVien.getTenNV());
		 */ // set ma nv cua user

		/*
		 * cmbTenSP.addActionListener(new ActionListener() { // event diền thông tin vào
		 * ô nhập liệu bằng tên public void actionPerformed(ActionEvent e) { try {
		 * SanPham sanPhamSelected = sanPhams.get(cmbTenSP.getSelectedIndex());
		 * txtMaSanPham.setText(sanPhamSelected.getMaSP());
		 * txtDonGia.setText(String.valueOf(formatter.format(sanPhamSelected.getGiaBan()
		 * ))); txtSoLuong.setText("1"); } catch (Exception e2) {
		 * txtMaSanPham.setText(""); // "" trong cmbTen
		 * 
		 * } } });
		 */

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LapHoaDonGUI lapHoaDonGUI = new LapHoaDonGUI();
					lapHoaDonGUI.setVisible(true);
					lapHoaDonGUI.setExtendedState(JFrame.MAXIMIZED_BOTH);
					lapHoaDonGUI.setDefaultCloseOperation(EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

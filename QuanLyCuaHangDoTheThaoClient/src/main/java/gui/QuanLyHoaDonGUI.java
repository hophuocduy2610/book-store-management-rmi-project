package gui;

import java.awt.EventQueue;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DecimalFormat;

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


public class QuanLyHoaDonGUI extends JFrame {
	//========================== Khai Báo Biến ==============================
	JButton btnHoaDon, btnSanPham, btnKhachHang, btnNhanVien, btnBaoCao, btnHoTro, btnDangXuat;
	private JButton btnInHD2;
	
	String header[] = { "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Đơn Giá", "Thành Tiền" };

	DecimalFormat formatter = new DecimalFormat("###,### VND");

	/*
	 * ArrayList<ChiTietHoaDon> dsSP = new ArrayList<ChiTietHoaDon>(); List<SanPham>
	 * sanPhams;
	 */
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
	
	//============================== Hiển thị giao diện ==========================
	
	public QuanLyHoaDonGUI() {
		giaoDienLapHoaDon();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	//=============================== Hàm main ===================================
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyHoaDonGUI lapHoaDonUI = new QuanLyHoaDonGUI();
					lapHoaDonUI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//============================== Code giao diện ===============================
	
	private void giaoDienLapHoaDon() {
		int indentLeftLbl = 20;
		int heightComponent = 22;
		int widthLbl = 100;
		int topSpacing = 20;

		JPanel pnlHoaDon = new JPanel(null);
		add(pnlHoaDon);
		// table

		String[] columnNames = { "Mã Hóa Đơn", "Tên Khách Hàng", "Tên Nhân Viên", "Ngày Bán", "Tổng Tiền" };
		JPanel pnlTblHoaDon = new JPanel(null);
		pnlTblHoaDon.setBorder(BorderFactory.createTitledBorder("Danh sách hóa đơn "));
		pnlTblHoaDon.setBounds(10, 20, 1030, 300);
		modelHoaDon = new DefaultTableModel(columnNames, 0);
		tblHoaDon = new JTable(modelHoaDon);
		tblHoaDon.setBounds(20, 20, 1010, 270);
		JScrollPane srcHoaDon = new JScrollPane(tblHoaDon);
		srcHoaDon.setBounds(10, 20, 1010, 270);
		pnlTblHoaDon.add(srcHoaDon);
		pnlHoaDon.add(pnlTblHoaDon);

		///
		String[] Header1 = { "Mã Hóa Đơn", "Tên sản phẩm", " Đơn giá", "Số Lượng", "Thành Tiền" };
		JPanel pnlChiTietHoaDon = new JPanel(null);
		pnlChiTietHoaDon.setBorder(BorderFactory.createTitledBorder("Bảng chi tiết hóa đơn"));
		pnlChiTietHoaDon.setBounds(10, 330, 1030, 240);
		modedCTHoaDon = new DefaultTableModel(Header1, 0);
		tblCTHoaDon = new JTable(modedCTHoaDon);
		tblCTHoaDon.setBounds(20, 20, 1010, 210);
		JScrollPane srcSanPhamPhieuNhap = new JScrollPane(tblCTHoaDon);
		srcSanPhamPhieuNhap.setBounds(10, 20, 1010, 210);
		pnlChiTietHoaDon.add(srcSanPhamPhieuNhap);
		pnlHoaDon.add(pnlChiTietHoaDon);

		///
		int widthBtn = 90;
		int heightBtn = 22;
		int spacingBetweenBtn = 100;

		JPanel pnlControl = new JPanel(null);
		pnlControl.setBorder(BorderFactory.createTitledBorder("Bảng Điều Khiển"));
		pnlControl.setBounds(10, 580, 1030, 50);
		pnlHoaDon.add(pnlControl);

//		JButton btnThemHD = new JButton("Thêm");
//		btnThemHD.setBounds(indentLeftLbl, topSpacing, widthBtn, heightBtn);
//		btnThemHD.setEnabled(false);
//		pnlControl.add(btnThemHD);
//
//		btnXoaHD.setBounds(indentLeftLbl + spacingBetweenBtn, topSpacing, widthBtn, heightBtn);
//		pnlControl.add(btnXoaHD);
//		btnXoaHD.setEnabled(false);
//
//		btnSuaHD.setBounds(indentLeftLbl + spacingBetweenBtn * 2, topSpacing, widthBtn, heightBtn);
//		pnlControl.add(btnSuaHD);
//		btnSuaHD.setEnabled(false);

		btnXoaRongHD = new JButton("Làm mới");
		btnXoaRongHD.setBounds(indentLeftLbl, topSpacing, widthBtn, heightBtn);
		pnlControl.add(btnXoaRongHD);

		btnInHD2 = new JButton("In hóa đơn");
		btnInHD2.setBounds(indentLeftLbl + spacingBetweenBtn, topSpacing, widthBtn + 50, heightBtn);
		pnlControl.add(btnInHD2);

		int indentTimMa = indentLeftLbl + spacingBetweenBtn * 4;
		int widthCmbTim = 80;
		JLabel lblTimMa = new JLabel("Tìm Theo Mã:");
		lblTimMa.setBounds(indentTimMa, topSpacing, widthLbl, heightComponent);
		cmbTimHoaDon = new JComboBox<String>();
		cmbTimHoaDon.setEditable(true);
		cmbTimHoaDon.setBounds(indentTimMa + widthLbl, topSpacing, widthCmbTim + 70, heightComponent);

		pnlControl.add(lblTimMa);
		pnlControl.add(cmbTimHoaDon);

//		btnXoaRongHD.addActionListener(this);
		/*
		 * cmbTimHoaDon.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) {
		 * tblHoaDon.getSelectionModel().clearSelection();
		 * modelHoaDon.getDataVector().removeAllElements(); Object item =
		 * cmbTimHoaDon.getSelectedItem(); if (item != null && item != "") { HoaDon hd;
		 * try { hd =
		 * hoaDonFacade.layHDTheoMa(cmbTimHoaDon.getSelectedItem().toString());
		 * hd.setChiTietHoaDons(chiTietHoaDonFacade.layHDTheoMa(hd.getMaHD()));
		 * modelHoaDon.addRow(new Object[] { hd.getMaHD(), hd.getKhachHang().getTenKH(),
		 * hd.getNhanVien().getTenNV(), hd.getNgayTao(),
		 * formatter.format(hd.getThanhTien()) }); } catch (RemoteException e1) { //
		 * TODO Auto-generated catch block e1.printStackTrace(); } } } });
		 */

		/*
		 * tblHoaDon.getSelectionModel().addListSelectionListener(new
		 * ListSelectionListener() { public void valueChanged(ListSelectionEvent e) { if
		 * (tblHoaDon.getSelectedRowCount() == 1) { int row =
		 * tblHoaDon.getSelectedRow(); String maHD = (String) tblHoaDon.getValueAt(row,
		 * 0); List<ChiTietHoaDon> chiTietHDs; try { chiTietHDs =
		 * chiTietHoaDonFacade.layHDTheoMa(maHD);
		 * tblCTHoaDon.getSelectionModel().clearSelection();
		 * modedCTHoaDon.getDataVector().removeAllElements(); modedCTHoaDon.addRow(new
		 * Object[] {}); modedCTHoaDon.removeRow(0); for (ChiTietHoaDon chiTietHD :
		 * chiTietHDs) { SanPham sanPham; try { sanPham =
		 * sanPhamFacade.laySPTheoMa(chiTietHD.getSanPham().getMaSP());
		 * modedCTHoaDon.addRow(new Object[] { chiTietHD.getHoaDon().getMaHD(),
		 * sanPham.getTenSP(), formatter.format(chiTietHD.getDonGia()),
		 * chiTietHD.getSoLuong(), formatter.format(chiTietHD.getThanhTien()) }); }
		 * catch (RemoteException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); } } } catch (RemoteException e2) { // TODO
		 * Auto-generated catch block e2.printStackTrace(); } } } });
		 */
	}
}

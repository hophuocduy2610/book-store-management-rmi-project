package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import app.Client;
import entity.Customer;
import entity.Product;
import entity.Receipt;
import entity.ReceiptDetail;
import entity.Staff;

public class LapHoaDonGUI extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1586235031492378006L;

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
	private JTextField txtTenSP;
	private JLabel lblSoLuong;
	private JTextField txtSoLuong;
	private JLabel lblDonGia;
	private JTextField txtDonGia;
	private JPanel pnlBanHangMainTable;
	String header[] = { "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Đơn Giá", "Thành Tiền" };
	@SuppressWarnings("unused")
	private JScrollPane scr;
	private JPanel pnlThanhTien;
	private JLabel lblThanhTien;
	private JLabel lblTongThanhTien;

	private JPanel pnlBanHangMainConTrol;
	private JButton btnThemSP;
	private JButton btnXoaSP;
	private JButton btnLamMoi;
	private JButton btnInHD;
	private JButton btnThanhToan;
	private JTable tb;
	private DefaultTableModel model;

	private JButton btnThoat;

	private Client client = new Client();

	@SuppressWarnings("serial")
	public LapHoaDonGUI() throws RemoteException, MalformedURLException, NotBoundException {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("HỆ THỐNG LẬP HÓA ĐƠN");

		pnlBanHangMain = new JPanel(null);
		pnlBanHangMain.setBackground(new Color(255, 179, 0));

		JLabel lblLapHD = new JLabel("LẬP HÓA ĐƠN");
		lblLapHD.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblLapHD.setBounds(540, 10, 600, 35);
		pnlBanHangMain.add(lblLapHD);

		add(pnlBanHangMain);
		pnlBanHangMainTop = new JPanel();
		pnlBanHangMainTop.setBounds(80, 50, 1128, 160);
		pnlBanHangMainTop.setBorder(BorderFactory.createTitledBorder("Thông tin chung"));
		pnlBanHangMainTop.setLayout(null);

		// TOP_LEFT
		pnlBanHangMainTop.add(lblMaHDBan = new JLabel("Mã Hóa Đơn: "));
		lblMaHDBan.setBounds(600, 20, 120, 20);
		pnlBanHangMainTop.add(txtMaHDBan = new JTextField());
		txtMaHDBan.setBounds(720, 20, 270, 20);
		txtMaHDBan.setText(client.getReceiptDAO().generateReceiptID());
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
		txtMaNV.setText(GetDataTemp.maNV);
		txtMaNV.setEditable(false);

		pnlBanHangMainTop.add(lblTenNV = new JLabel("Tên Nhân Viên: "));
		lblTenNV.setBounds(600, 110, 150, 20);
		pnlBanHangMainTop.add(txtTenNV = new JTextField());
		txtTenNV.setBounds(720, 110, 270, 20);
		txtTenNV.setText(GetDataTemp.tenNV);
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
		txtDienThoai.setBounds(150, 110, 300, 20);
		pnlBanHangMainTop.add(btnTimKH = new JButton("Tìm"));
		btnTimKH.setBounds(455, 105, 75, 25);
		btnTimKH.setBackground(new Color(226, 207, 72));
//												PANEL_CENTER
		pnlBanHangMainCenter = new JPanel(null);
		pnlBanHangMainCenter.setBounds(80, 210, 1128, 100);
		pnlBanHangMainCenter.setBorder(BorderFactory.createTitledBorder("Thông tin sản phẩm: "));

//		
		pnlBanHangMainCenter.add(lblMaSanPham = new JLabel("Mã sản phẩm: "));
		lblMaSanPham.setBounds(30, 20, 150, 20);
		pnlBanHangMainCenter.add(txtMaSanPham = new JTextField());
		txtMaSanPham.setBounds(150, 20, 210, 20);
		pnlBanHangMainCenter.add(btnTimKiemMaSP = new JButton("Tìm"));
		btnTimKiemMaSP.setBounds(365, 15, 75, 25);
		btnTimKiemMaSP.setBackground(new Color(226, 207, 72));

		pnlBanHangMainCenter.add(lblTenSP = new JLabel("Tên sản phẩm: "));
		lblTenSP.setBounds(30, 55, 150, 20);
		pnlBanHangMainCenter.add(txtTenSP = new JTextField());

		txtTenSP.setEditable(false);
		txtTenSP.setBounds(150, 55, 210, 20);

		pnlBanHangMainCenter.add(lblSoLuong = new JLabel("Số Lượng: "));
		lblSoLuong.setBounds(460, 20, 150, 20);
		pnlBanHangMainCenter.add(txtSoLuong = new JTextField());
		txtSoLuong.setBounds(540, 20, 150, 20);

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
		pnlBanHangMainTable.setBounds(80, 310, 1128, 205);
		pnlBanHangMainTable.setLayout(new GridLayout(1, 0, 0, 0));

		model = new DefaultTableModel(header, 0);
		tb = new JTable(model);
		tb.setBounds(5, 10, 1027, 200);
		pnlBanHangMainTable.add(scr = new JScrollPane(tb = new JTable(model) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		}));

		// THÀNH TIỀN
		pnlThanhTien = new JPanel(null);
		pnlThanhTien.setBounds(80, 515, 1128, 50);
		pnlThanhTien.setLayout(new BoxLayout(pnlThanhTien, BoxLayout.X_AXIS));
		pnlThanhTien.add(Box.createHorizontalStrut(750));

		pnlThanhTien.add(lblThanhTien = new JLabel("Tổng tiền thanh toán:"));
		lblThanhTien.setBounds(0, 10, 300, 25);
		lblThanhTien.setFont(new Font("Serif", Font.PLAIN, 20));
		pnlThanhTien.add(Box.createHorizontalStrut(10));

		pnlThanhTien.add(lblTongThanhTien = new JLabel(""));
		lblTongThanhTien.setBounds(200, 9, 350, 25);
		lblTongThanhTien.setText(String.valueOf(Math.round(0.0)));
		lblTongThanhTien.setForeground(Color.red);
		lblTongThanhTien.setFont(new Font("Serif", Font.PLAIN, 22));

//		PANEL_CTRL
		pnlBanHangMainConTrol = new JPanel();
		pnlBanHangMainConTrol.setBounds(80, 565, 1128, 80);
		pnlBanHangMainConTrol.setBorder(BorderFactory.createTitledBorder("Bảng Điều Khiển"));
		pnlBanHangMainConTrol.setLayout(new BoxLayout(pnlBanHangMainConTrol, BoxLayout.X_AXIS));

		pnlBanHangMainConTrol.add(Box.createHorizontalStrut(120));

		pnlBanHangMainConTrol.add(btnThemSP = new JButton("Thêm sản phẩm"));
		btnThemSP.setBackground(new Color(226, 207, 72));
		btnThemSP.setMaximumSize(new Dimension(150, 40));

		pnlBanHangMainConTrol.add(Box.createHorizontalStrut(30));

		pnlBanHangMainConTrol.add(btnXoaSP = new JButton("Xóa sản phẩm"));
		btnXoaSP.setBackground(new Color(226, 207, 72));
		btnXoaSP.setMaximumSize(new Dimension(150, 40));

		pnlBanHangMainConTrol.add(Box.createHorizontalStrut(30));

		pnlBanHangMainConTrol.add(btnLamMoi = new JButton("Làm mới"));
		btnLamMoi.setBackground(new Color(226, 207, 72));
		btnLamMoi.setMaximumSize(new Dimension(150, 40));

		pnlBanHangMainConTrol.add(Box.createHorizontalStrut(30));

		pnlBanHangMainConTrol.add(btnInHD = new JButton("In hóa đơn"));
		btnInHD.setBackground(new Color(226, 207, 72));
		btnInHD.setMaximumSize(new Dimension(150, 40));

		pnlBanHangMainConTrol.add(Box.createHorizontalStrut(30));

		pnlBanHangMainConTrol.add(btnThanhToan = new JButton("Thanh toán"));
		btnThanhToan.setBackground(new Color(226, 207, 72));
		btnThanhToan.setMaximumSize(new Dimension(150, 40));

		pnlBanHangMainConTrol.add(Box.createHorizontalStrut(30));

		pnlBanHangMain.add(pnlBanHangMainTop);
		pnlBanHangMain.add(pnlBanHangMainCenter);
		pnlBanHangMain.add(pnlBanHangMainTable);
		pnlBanHangMain.add(pnlThanhTien);
		pnlBanHangMain.add(pnlBanHangMainConTrol);

		btnThoat = new JButton();
		btnThoat.setBounds(0, 0, 60, 40);
		btnThoat.setIcon(new ImageIcon("assets/image/exit.png"));
		btnThoat.setBackground(new Color(51, 255, 51));
		pnlBanHangMain.add(btnThoat);

		btnThoat.addActionListener((LapHoaDonGUI) -> {
			int loinhac = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thoát !!!!", "Nhắc nhở",
					JOptionPane.YES_NO_OPTION);
			if (loinhac == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(this, "Cảm ơn bạn đã sử dụng dịch vụ");
				MainGUI mainGUI;
				try {
					mainGUI = new MainGUI();
					mainGUI.setVisible(true);
					setVisible(false);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnTimKH.addActionListener(this);
		btnTimKiemMaSP.addActionListener(this);
		btnThemSP.addActionListener(this);
		btnXoaSP.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnThanhToan.addActionListener(this);

		// --------Xử lí sự kiện load tổng thành tiền---------
		tb.getModel().addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				setTongThanhTien();
			}
		});
	}

	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LapHoaDonGUI lapHoaDonGUI = new LapHoaDonGUI();
					lapHoaDonGUI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(btnTimKH)) {
			try {
				timKiemKhachHang();
			} catch (RemoteException | MalformedURLException | NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource().equals(btnTimKiemMaSP)) {
			try {
				timKiemSanPham();
			} catch (RemoteException | MalformedURLException | NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource().equals(btnThemSP)) {
			if (!(txtMaSanPham.getText() == "" || txtTenSP.getText() == "" || txtSoLuong.getText() == ""
					|| txtDonGia.getText() == "")) {
				try {
					themSanPhamVaoBang();
				} catch (RemoteException | MalformedURLException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin sản phẩm", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource().equals(btnXoaSP)) {
			xoaSanPhamRaKhoiBang();
		} else if (e.getSource().equals(btnLamMoi)) {
			clearTextField();
			clearTable();
		} else if (e.getSource().equals(btnThanhToan)) {
			try {
				thanhToan();
			} catch (RemoteException | MalformedURLException | NotBoundException | ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	// ----------Xử lý sự kiện thanh toán------------------------
	public void thanhToan() throws RemoteException, MalformedURLException, NotBoundException, ParseException {
		ReceiptDetail receiptDetail;

		int rowCount = tb.getRowCount();

		model = (DefaultTableModel) tb.getModel();

		if (rowCount != 0) {
			Receipt receipt = new Receipt(txtMaHDBan.getText(), new Customer(txtMaKH.getText()),
					new Staff(txtMaNV.getText()), new SimpleDateFormat("dd-MM-yyyy").parse(txtNgayBan.getText()),
					Double.valueOf(lblTongThanhTien.getText()), ABORT);

			System.out.println(new SimpleDateFormat("dd-MM-yyyy").parse(txtNgayBan.getText()));
			client.getReceiptDAO().addReceipt(receipt);
			for (int i = 0; i < rowCount; i++) {

				String maSP = model.getValueAt(i, 0).toString();
				int soLuong = Integer.valueOf(model.getValueAt(i, 2).toString());
				Double donGia = Double.valueOf(model.getValueAt(i, 3).toString());
				Double thanhTien = Double.valueOf(model.getValueAt(i, 4).toString());

				Product productOrder = client.getProductDAO().getProductById(maSP);
				
				if (!(productOrder.getQuantity() - soLuong < 0)) {
					
					int soLuongSauKhiBan = productOrder.getQuantity() - soLuong;
					
					Receipt receiptID = new Receipt(txtMaHDBan.getText());
					Product productID = new Product(maSP);
					
					receiptDetail = new ReceiptDetail(soLuong, donGia, thanhTien, ABORT, productID, receiptID);
					
					client.getReceiptDetailDAO().addReceiptDetail(receiptDetail);
					client.getProductDAO().updateQuantity(maSP, soLuongSauKhiBan);
				}
			}
			txtMaHDBan.setText(client.getReceiptDAO().generateReceiptID());
			clearTable();
			clearTextField();
			JOptionPane.showMessageDialog(this, "Thanh toán thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "Chưa có sản phẩm để thanh toán", "Thông báo",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
	}

	// ----------Xử lý sự kiện xóa sản phẩm ra khỏi bảng------------------------

	public void xoaSanPhamRaKhoiBang() {
		if (tb.getSelectedRow() != -1) {
			int row = tb.getSelectedRow();
			model.removeRow(row);
		} else {
			JOptionPane.showMessageDialog(btnTimKH, "Chọn sản phẩm cần xóa", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	// --------Xử lý sự kiện thêm sản phẩm vào bảng--------------------------

	public void themSanPhamVaoBang() throws RemoteException, MalformedURLException, NotBoundException {
//		"Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Đơn Giá", "Thành Tiền"
		model = new DefaultTableModel();
		model.addColumn("Mã Sản Phẩm");
		model.addColumn("Tên Sản Phẩm");
		model.addColumn("Số Lượng");
		model.addColumn("Đơn Giá");
		model.addColumn("Thành Tiền");

		int rowCount = tb.getRowCount();
		model = (DefaultTableModel) tb.getModel();
		Product product = client.getProductDAO().getProductById(txtMaSanPham.getText());
		int soLuongSPTon = product.getQuantity();
		if (kiemTraSoLuong(soLuongSPTon, Integer.valueOf(txtSoLuong.getText()))) {
			JOptionPane
					.showMessageDialog(
							this, "Sản phẩm " + txtTenSP.getText()
									+ " không đủ số lượng. Số lượng hiện còn trong kho là " + soLuongSPTon,
							"Thông báo", JOptionPane.WARNING_MESSAGE);
			return;
		}
		if (rowCount != 0) {
			for (int i = 0; i < rowCount; i++) {
				if (model.getValueAt(i, 0).equals(txtMaSanPham.getText())) {
					int soLuongSau = Integer.valueOf(model.getValueAt(i, 2).toString())
							+ Integer.valueOf(txtSoLuong.getText());

					Double donGia = Double.valueOf(model.getValueAt(i, 3).toString());
					model.setValueAt(soLuongSau, i, 2);

					model.setValueAt(soLuongSau * donGia, i, 4);
					tb.setModel(model);
					return;
				}
			}
		}
		Object[] rowData1 = { txtMaSanPham.getText(), txtTenSP.getText(), txtSoLuong.getText(), txtDonGia.getText(),
				Integer.valueOf(txtSoLuong.getText()) * Double.valueOf(txtDonGia.getText()) };
		model.addRow(rowData1);
		tb.setModel(model);
	}

	public boolean kiemTraSoLuong(int soLuongTon, int soLuong) {
		if (soLuongTon - soLuong < 0) {
			return true;
		}
		return false;
	}

	// -----------------Hàm set tổng thành tiền---------------------------

	public void setTongThanhTien() {
		Double tongThanhTien = 0.0;
		int rowCount = tb.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			tongThanhTien += Double.valueOf(model.getValueAt(i, 4).toString());
			lblTongThanhTien.setText(String.valueOf(Math.round(tongThanhTien)));
		}
	}

	// --------Xử lý sự kiện tìm sản phẩm--------------------------

	public void timKiemSanPham() throws RemoteException, MalformedURLException, NotBoundException {
		if (client.getProductDAO().isExistProduct(txtMaSanPham.getText())) {
			Product product = client.getProductDAO().getProductById(txtMaSanPham.getText());

			txtTenSP.setText(product.getName());
			txtDonGia.setText(String.valueOf(product.getPrice()));
		} else {
			JOptionPane.showMessageDialog(btnTimKH, "Không tìm thấy sản phẩm", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	// --------Xử lý sự kiện tìm khách hàng---------------------------
	public void timKiemKhachHang() throws RemoteException, MalformedURLException, NotBoundException {
		if (client.getCustomerDAO().isExistCustomer(txtDienThoai.getText())) {
			Customer customer = client.getCustomerDAO().getCustomerByPhoneNumber(txtDienThoai.getText());
			txtMaKH.setText(customer.getId());
			txtTenKH.setText(customer.getName());
			txtDiaChi.setText(customer.getAddress().getAddress() + " " + customer.getAddress().getWard() + " "
					+ customer.getAddress().getDistrict() + " " + customer.getAddress().getCity());
		} else {
			JOptionPane.showMessageDialog(btnTimKH, "Không tìm thấy khách hàng", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void clearTable() {
		DefaultTableModel dm = (DefaultTableModel) tb.getModel();
		dm.getDataVector().removeAllElements();
		dm.fireTableDataChanged();
	}

	public void clearTextField() {
		txtMaKH.setText("");
		txtTenKH.setText("");
		txtDiaChi.setText("");
		txtDienThoai.setText("");
		txtMaSanPham.setText("");
		txtTenSP.setText("");
		txtSoLuong.setText("");
		txtDonGia.setText("");
		lblTongThanhTien.setText(String.valueOf(Math.round(0.0)));
	}
}

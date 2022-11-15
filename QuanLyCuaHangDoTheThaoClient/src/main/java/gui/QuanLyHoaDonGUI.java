package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

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
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import app.Client;
import entity.Receipt;
import entity.ReceiptDetail;

public class QuanLyHoaDonGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8297811490471595811L;

	// ========================== Khai Báo Biến ==============================
	JButton btnHoaDon, btnSanPham, btnKhachHang, btnNhanVien, btnBaoCao, btnHoTro, btnDangXuat;
	private JButton btnInHD2;

	private JPanel khung;
	JTable tb;
	DefaultTableModel model;
	private DefaultTableModel modelHoaDon;
	private JTable tblHoaDon;
	private DefaultTableModel modedCTHoaDon;
	private JTable tblCTHoaDon;

	private JButton btnXoaRongHD;
	String[] headerCTHD = { "Mã Hóa Đơn", "Tên sản phẩm", " Đơn giá", "Số Lượng", "Thành Tiền" };
	String[] headerHD = { "Mã Hóa Đơn", "Tên Khách Hàng", "Tên Nhân Viên", "Ngày Bán", "Tổng Tiền" };
	private JLabel lblTimKiem;
	private JTextField txtTimKiem;
	private JButton btnThoat;

	private Client client = new Client();

	// ============================== Hiển thị giao diện ==========================

	public QuanLyHoaDonGUI() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		khung = new JPanel();
		khung.setBackground(new Color(255, 179, 0));
		setContentPane(khung);
		khung.setLayout(null);

		JLabel lblQLHD = new JLabel("QUẢN LÝ HÓA ĐƠN");
		lblQLHD.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblQLHD.setBounds(490, 10, 600, 35);

		khung.add(lblQLHD);

		// table

		JPanel pnlTblHoaDon = new JPanel();
		pnlTblHoaDon.setBorder(BorderFactory.createTitledBorder("Danh sách hóa đơn "));
		pnlTblHoaDon.setBounds(10, 100, 1260, 270);
		modelHoaDon = new DefaultTableModel(headerHD, 0);
		tblHoaDon = new JTable(modelHoaDon);
		tblHoaDon.setBounds(20, 70, 1260, 270);
		JScrollPane srcHoaDon = new JScrollPane(tblHoaDon);
		srcHoaDon.setBounds(10, 20, 1260, 270);
		pnlTblHoaDon.setLayout(new GridLayout(1, 0, 0, 0));
		pnlTblHoaDon.add(srcHoaDon);
		khung.add(pnlTblHoaDon);

		///
		JPanel pnlChiTietHoaDon = new JPanel();
		pnlChiTietHoaDon.setBorder(BorderFactory.createTitledBorder("Bảng chi tiết hóa đơn"));
		pnlChiTietHoaDon.setBounds(10, 370, 1260, 210);
		modedCTHoaDon = new DefaultTableModel(headerCTHD, 0);
		tblCTHoaDon = new JTable(modedCTHoaDon);
		tblCTHoaDon.setBounds(20, 60, 1260, 180);
		JScrollPane srcSanPhamPhieuNhap = new JScrollPane(tblCTHoaDon);
		srcSanPhamPhieuNhap.setBounds(10, 20, 1260, 180);
		pnlChiTietHoaDon.setLayout(new GridLayout(1, 0, 0, 0));
		pnlChiTietHoaDon.add(srcSanPhamPhieuNhap);
		khung.add(pnlChiTietHoaDon);

		JPanel pnlControl = new JPanel();
		pnlControl.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Thông tin Khách Hàng:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		pnlControl.setBounds(10, 580, 1260, 80);
		khung.add(pnlControl);
		pnlControl.setLayout(new BoxLayout(pnlControl, BoxLayout.X_AXIS));
		pnlControl.add(Box.createHorizontalStrut(520));

		btnXoaRongHD = new JButton("Làm mới");
		btnXoaRongHD.setMaximumSize(new Dimension(130, 45));
		btnXoaRongHD.setBackground(new Color(226, 207, 72));
		pnlControl.add(btnXoaRongHD);

		pnlControl.add(Box.createHorizontalStrut(30));

		btnInHD2 = new JButton("In hóa đơn");
		btnInHD2.setMaximumSize(new Dimension(130, 45));
		btnInHD2.setBackground(new Color(226, 207, 72));
		pnlControl.add(btnInHD2);

		lblTimKiem = new JLabel("Nhập thông tin cần tìm:");
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTimKiem.setBounds(850, 45, 340, 35);

		khung.add(lblTimKiem);
		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(1050, 50, 200, 25);
		khung.add(txtTimKiem);

		btnThoat = new JButton();
		btnThoat.setBounds(0, 0, 60, 40);
		btnThoat.setIcon(new ImageIcon("assets/image/exit.png"));
		btnThoat.setBackground(new Color(51, 255, 51));
		khung.add(btnThoat);

		btnThoat.addActionListener((QuanLyKhachHangGUI) -> {
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

		// ----------------------Xử Lý Tìm Kiếm-------------------------------------//

		txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				SearchByKeyRelease(evt);
			}

			private void SearchByKeyRelease(KeyEvent evt) {
				// TODO Auto-generated method stub
				modelHoaDon = (DefaultTableModel) tblHoaDon.getModel();
				String search = txtTimKiem.getText();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelHoaDon);
				tblHoaDon.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(search));
			}
		});
		
		//----------------------Xử lý đưa dữ liệu từ bảng vào các text field-------------------------------------//
				tblHoaDon.addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						int rowclicked = tblHoaDon.getSelectedRow();
						try {
							renderDataReceiptDetailToTable(modelHoaDon.getValueAt(rowclicked, 0).toString());
						} catch (RemoteException | MalformedURLException | NotBoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub

					}
				});
	}

	// =============================== Hàm main ===================================
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

	// ------------Xử Lý Đưa dữ liệu Hóa đơn từ Database lên bảng--------------//
	public void renderDataReceiptToTable() throws RemoteException, MalformedURLException, NotBoundException {
		List<Receipt> listReceipts = client.getReceiptDAO().getListReceipts();
		int columns = headerHD.length;
		Object[] obj;
		int rows = listReceipts.size();
		if (rows > 0) {
			for (int i = 0; i < rows; i++) {
				Receipt receipt = listReceipts.get(i);
				obj = new Object[columns];
				obj[0] = receipt.getReceiptID();
				obj[1] = client.getCustomerDAO().getNameCustomerByID(receipt.getCustomer().getId());
				obj[2] = client.getStaffDAO().getNameStaffByID(receipt.getStaff().getId());
				obj[3] = receipt.getDate();
				obj[4] = receipt.getTotalPrice();
				modelHoaDon.addRow(obj);
			}
		}
	}
	
	// ------------Xử Lý Đưa dữ liệu Chi tiết hóa đơn từ Database lên bảng--------------//
	public void renderDataReceiptDetailToTable(String receiptID) throws RemoteException, MalformedURLException, NotBoundException {
		List<ReceiptDetail> listReceiptDetails = client.getReceiptDetailDAO().getListReceiptDetailtsByID(receiptID);
		int columns = headerCTHD.length;
		Object[] obj;
		int rows = listReceiptDetails.size();
		if (rows > 0) {
			for (int i = 0; i < rows; i++) {
//				String[] headerCTHD = { "Mã Hóa Đơn", "Tên sản phẩm", " Đơn giá", "Số Lượng", "Thành Tiền" };

				ReceiptDetail receiptDetail = listReceiptDetails.get(i);
				obj = new Object[columns];
				obj[0] = receiptDetail.getReceipt().getReceiptID();
				obj[1] = client.getProductDAO().getNameProductByID(receiptDetail.getProduct().getId());
				obj[2] = receiptDetail.getUnitPrice();
				obj[3] = receiptDetail.getQuantity();
				obj[4] = receiptDetail.getAmount();
				modedCTHoaDon.addRow(obj);
			}
		}
	}
}

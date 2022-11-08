package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import app.Client;
import entity.Address;
import entity.Customer;

public class QuanLyKhachHangGUI extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8763531368615487846L;

	private JPanel khung;
	private JLabel lblMaKhachHang;
	private JLabel lblTenKhachHang;
	private JLabel lblPhai;
	private JLabel lblDiaChiKhachHang;
	private JLabel lblQuan, lblPhuong, lblThanhPho;
	private JLabel lblSDT;
	private JLabel lblEmail;
	private JLabel lblTimKiem;

	private JTextField txtMaKhachHang;
	private JTextField txtTenKhachHang;
	private JTextField txtDiaChiKhachHang;
	private JTextField txtQuan, txtPhuong, txtThanhPho;
	private JTextField txtSDT;
	private JTextField txtTimKiem;
	private JTextField txtEmail;
	private JComboBox<String> cmbPhai;

	private JTable table;
	private DefaultTableModel tableModel;

	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnXoaTrang;
	private JButton btnThoat;
	String[] headers1 = { "Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Phường", "Quận", "Thành phố", "Giới tính",
			"Số điện thoại", "Email" };

	private Client client = new Client();

	@SuppressWarnings("serial")
	public QuanLyKhachHangGUI() throws RemoteException, MalformedURLException, NotBoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("HỆ THÔNG QUẢN LÝ THÔNG TIN KHÁCH HÀNG");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		khung = new JPanel();
		khung.setBackground(new Color(255, 179, 0));
		khung.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(khung);
		khung.setLayout(null);

		JLabel lblQLKH = new JLabel("QUẢN LÝ KHÁCH HÀNG");
		lblQLKH.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblQLKH.setBounds(490, 10, 600, 35);
		khung.add(lblQLKH);

		JPanel p1 = new JPanel();
		p1.setBackground(new Color(204, 204, 204));
		p1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Thông tin Khách Hàng:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		p1.setBounds(0, 80, 350, 684);
		khung.add(p1);
		p1.setLayout(null);

		// Danh sách Khách hàng
		tableModel = new DefaultTableModel(headers1, 0);
		JPanel pnTable = new JPanel();
		pnTable.setBounds(350, 80, 932, 590);
		pnTable.setBackground(new Color(204, 204, 204));
		pnTable.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh Sách Khách Hàng",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		pnTable.setLayout(new GridLayout(1, 0, 0, 0));
		khung.add(pnTable);
		JScrollPane scroll;
		pnTable.add(scroll = new JScrollPane(table = new JTable(tableModel) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		}));
		scroll.setBackground(new Color(102, 0, 102));
		table.setForeground(new Color(0, 0, 0));
		table.setBackground(new Color(204, 204, 204));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		scroll.setViewportView(table);

		// ----------------------------------------

		// add các Text vào
		lblMaKhachHang = new JLabel("Mã khách hàng:");
		lblMaKhachHang.setBounds(10, 40, 120, 14);
		p1.add(lblMaKhachHang);
		txtMaKhachHang = new JTextField();
		txtMaKhachHang.setBounds(140, 37, 200, 20);
		txtMaKhachHang.setEditable(false);
		p1.add(txtMaKhachHang);
		txtMaKhachHang.setColumns(10);

		lblTenKhachHang = new JLabel("Tên khách hàng:");
		lblTenKhachHang.setBounds(10, 90, 120, 14);
		p1.add(lblTenKhachHang);
		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setBounds(140, 87, 200, 20);
		p1.add(txtTenKhachHang);
		txtTenKhachHang.setColumns(10);

		lblPhai = new JLabel("Phái:");
		lblPhai.setBounds(10, 140, 120, 14);
		p1.add(lblPhai);
		cmbPhai = new JComboBox<String>();
		cmbPhai.setBounds(140, 137, 200, 20);
		cmbPhai.addItem("Nam");
		cmbPhai.addItem("Nữ");
		cmbPhai.addItem("Khác");
		p1.add(cmbPhai);

		lblDiaChiKhachHang = new JLabel("Địa chỉ:");
		lblDiaChiKhachHang.setBounds(10, 190, 120, 14);
		p1.add(lblDiaChiKhachHang);
		txtDiaChiKhachHang = new JTextField();
		txtDiaChiKhachHang.setBounds(140, 187, 200, 20);
		p1.add(txtDiaChiKhachHang);
		txtDiaChiKhachHang.setColumns(10);

		lblPhuong = new JLabel("Phường:");
		lblPhuong.setBounds(10, 240, 120, 14);
		p1.add(lblPhuong);
		txtPhuong = new JTextField();
		txtPhuong.setBounds(140, 237, 200, 20);
		p1.add(txtPhuong);
		txtPhuong.setColumns(10);

		lblQuan = new JLabel("Quận:");
		lblQuan.setBounds(10, 290, 120, 14);
		p1.add(lblQuan);
		txtQuan = new JTextField();
		txtQuan.setBounds(140, 287, 200, 20);
		p1.add(txtQuan);
		txtQuan.setColumns(10);

		lblThanhPho = new JLabel("Thành Phố:");
		lblThanhPho.setBounds(10, 340, 120, 14);
		p1.add(lblThanhPho);
		txtThanhPho = new JTextField();
		txtThanhPho.setBounds(140, 337, 200, 20);
		p1.add(txtThanhPho);
		txtThanhPho.setColumns(10);

		lblSDT = new JLabel("SDT:");
		lblSDT.setBounds(10, 390, 120, 14);
		p1.add(lblSDT);
		txtSDT = new JTextField();
		txtSDT.setBounds(140, 387, 200, 20);
		p1.add(txtSDT);
		txtSDT.setColumns(10);

		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 440, 120, 20);
		p1.add(lblEmail);
		txtEmail = new JTextField();
		txtEmail.setBounds(140, 437, 200, 20);
		p1.add(txtEmail);
		txtEmail.setColumns(10);

		// Thêm
		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnThem.setBackground(new Color(226, 207, 72));
		btnThem.setBounds(40, 480, 120, 40);
		p1.add(btnThem);

		// Sửa
		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSua.setBackground(new Color(226, 207, 72));
		btnSua.setBounds(180, 480, 120, 40);
		p1.add(btnSua);

		// Xóa
		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnXoa.setBackground(new Color(226, 207, 72));
		btnXoa.setBounds(40, 530, 120, 40);
		p1.add(btnXoa);

		// Xóa Trắng
		btnXoaTrang = new JButton("Xóa Trắng");
		btnXoaTrang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnXoaTrang.setForeground(new Color(0, 0, 0));
		btnXoaTrang.setBackground(new Color(226, 207, 72));
		btnXoaTrang.setBounds(180, 530, 120, 40);
		p1.add(btnXoaTrang);

//		====================================
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

		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);

		renderDataToTable();

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

//----------------------Xử Lý Tìm Kiếm-------------------------------------//

		txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				SearchByKeyRelease(evt);
			}

			private void SearchByKeyRelease(KeyEvent evt) {
				// TODO Auto-generated method stub
				tableModel = (DefaultTableModel) table.getModel();
				String search = txtTimKiem.getText();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tableModel);
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(search));
			}
		});
//----------------------Xử lý đưa dữ liệu từ bảng vào các text field-------------------------------------//
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				int rowclicked = table.getSelectedRow();
				txtMaKhachHang.setText(tableModel.getValueAt(rowclicked, 0).toString());
				txtTenKhachHang.setText(tableModel.getValueAt(rowclicked, 1).toString());
				txtDiaChiKhachHang.setText(tableModel.getValueAt(rowclicked, 2).toString());
				txtPhuong.setText(tableModel.getValueAt(rowclicked, 3).toString());
				txtQuan.setText(tableModel.getValueAt(rowclicked, 4).toString());
				txtThanhPho.setText(tableModel.getValueAt(rowclicked, 5).toString());
				cmbPhai.setSelectedItem(tableModel.getValueAt(rowclicked, 6).toString());
				txtSDT.setText(tableModel.getValueAt(rowclicked, 7).toString());
				txtEmail.setText(tableModel.getValueAt(rowclicked, 8).toString());
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
	// -
//		btnTimKiem = new JButton("Tìm");
//		btnTimKiem.setForeground(new Color(255, 255, 255));
//		btnTimKiem.setBackground(new Color(0,0,205));
//		btnTimKiem.setBounds(1210, 63, 70, 25);
//		khung.add(btnTimKiem);

//	//main
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyKhachHangGUI quanLyKhachHangGUI = new QuanLyKhachHangGUI();
					quanLyKhachHangGUI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			try {
				add();
			} catch (RemoteException | MalformedURLException | NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (o.equals(btnXoa)) {
			try {
				delete();
			} catch (HeadlessException | RemoteException | MalformedURLException | NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (o.equals(btnSua)) {
			try {
				update();
			} catch (HeadlessException | RemoteException | MalformedURLException | NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (o.equals(btnXoaTrang)) {
			clearTextField();
		}
	}

//----------------------Xử Lý Đưa dữ liệu từ Database lên bảng-------------------------------------//
	public void renderDataToTable() throws RemoteException, MalformedURLException, NotBoundException {
		List<Customer> listCustomers = client.getCustomerDAO().getListCustomers();
		int columns = headers1.length;
		Object[] obj;
		int rows = listCustomers.size();
		if (rows > 0) {
			for (int i = 0; i < rows; i++) {
				Customer cus = listCustomers.get(i);
				obj = new Object[columns];
				obj[0] = cus.getId();
				obj[1] = cus.getName();
				obj[2] = cus.getAddress().getAddress();
				obj[3] = cus.getAddress().getWard();
				obj[4] = cus.getAddress().getDistrict();
				obj[5] = cus.getAddress().getCity();
				obj[6] = cus.getGender();
				obj[7] = cus.getPhone();
				obj[8] = cus.getEmail();
				tableModel.addRow(obj);
			}
		}
	}

// ----------------------Xử lý sự kiện thêm thông tin khách hàng-------------------------------------//

	private void add() throws RemoteException, MalformedURLException, NotBoundException {
		String maKH = client.getCustomerDAO().generateCustomerID();
		String tenKH = txtTenKhachHang.getText();
		String diaChi = txtDiaChiKhachHang.getText();
		String phuong = txtPhuong.getText();
		String quan = txtQuan.getText();
		String thanhPho = txtThanhPho.getText();
		String gioiTinh = cmbPhai.getSelectedItem().toString();
		String sdt = txtSDT.getText();
		String email = txtEmail.getText();
		Address address = new Address(thanhPho, quan, phuong, diaChi);
		Customer customer = new Customer(maKH, tenKH, gioiTinh, sdt, email, address);

		client.getCustomerDAO().addCustomer(customer);
		clearTable();
		updateCustomerTable();
		clearTextField();
	}

// ----------------------Xử lý sự kiện xóa thông tin khách hàng-------------------------------------//

	private void delete() throws HeadlessException, RemoteException, MalformedURLException, NotBoundException {
		int row = table.getSelectedRow();
		if (row != -1) {
			int confirmAlert = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá Thông Tin Khách Hàng này không?",
					"Chú ý", JOptionPane.YES_NO_OPTION);
			if (confirmAlert == JOptionPane.YES_OPTION) {
				String maKH = table.getValueAt(row, 0).toString();
				if (client.getCustomerDAO().deleteCustomer(maKH)) {
					tableModel.removeRow(row);
					JOptionPane.showMessageDialog(this, "Đã xoá!");
					clearTextField();
				} else
					JOptionPane.showMessageDialog(this, "Xoá thất bại!");
			}
		} else
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn Thông Tin Khách Hàng Cần Xóa!");
	}

// ----------------------Xử lý sự kiện cập nhật thông tin khách hàng-------------------------------------//

	private void update() throws RemoteException, HeadlessException, MalformedURLException, NotBoundException {
		String maKH = txtMaKhachHang.getText();
		String tenKH = txtTenKhachHang.getText();
		String diaChi = txtDiaChiKhachHang.getText();
		String phuong = txtPhuong.getText();
		String quan = txtQuan.getText();
		String thanhPho = txtThanhPho.getText();
		String gioiTinh = cmbPhai.getSelectedItem().toString();
		String sdt = txtSDT.getText();
		String email = txtEmail.getText();
		int row = table.getSelectedRow();
		if (row != -1) {
			Address address = new Address(thanhPho, quan, phuong, diaChi);
			Customer customer = new Customer(maKH, tenKH, gioiTinh, sdt, email, address);
			if (client.getCustomerDAO().udateCustomer(customer)) {
				table.setValueAt(maKH, row, 0);
				table.setValueAt(tenKH, row, 1);
				table.setValueAt(diaChi, row, 2);
				table.setValueAt(phuong, row, 3);
				table.setValueAt(quan, row, 4);
				table.setValueAt(thanhPho, row, 5);
				table.setValueAt(gioiTinh, row, 6);
				table.setValueAt(sdt, row, 7);
				table.setValueAt(email, row, 8);
				JOptionPane.showMessageDialog(this, "Đã cập nhật!");
				clearTextField();
				updateCustomerTable();
			} else
				JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
		} else
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn Thông Tin Khách Hàng cần cập nhật!");
	}
// ----------------------Xử lý sự kiện cập nhật bảng khách hàng-------------------------------------//

	private void updateCustomerTable() throws RemoteException, MalformedURLException, NotBoundException {
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Mã khách hàng");
		tableModel.addColumn("Tên khách hàng");
		tableModel.addColumn("Địa chỉ");
		tableModel.addColumn("Phường");
		tableModel.addColumn("Quận");
		tableModel.addColumn("Thành phố");
		tableModel.addColumn("Giới tính");
		tableModel.addColumn("Số điện thoại");
		tableModel.addColumn("Email");
		List<Customer> listCustomers = client.getCustomerDAO().getListCustomers();
		for (Customer customer : listCustomers) {
			String[] rowData1 = { customer.getId(), customer.getName(), customer.getAddress().getAddress(),
					customer.getAddress().getWard(), customer.getAddress().getDistrict(),
					customer.getAddress().getCity(), customer.getGender(), customer.getPhone(), customer.getEmail() };
			tableModel.addRow(rowData1);
		}
		table.setModel(tableModel);
	}

// ------------------------------Xóa sạch bảng----------------------------------------//

	private void clearTable() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
		dm.fireTableDataChanged();
	}

// ----------------------Xóa trắng các text field-------------------------------------//

	private void clearTextField() {
		txtMaKhachHang.setText("");
		txtTenKhachHang.setText("");
		txtDiaChiKhachHang.setText("");
		txtPhuong.setText("");
		txtQuan.setText("");
		txtThanhPho.setText("");
		cmbPhai.setSelectedItem(1);
		txtSDT.setText("");
		txtEmail.setText("");
	}
}
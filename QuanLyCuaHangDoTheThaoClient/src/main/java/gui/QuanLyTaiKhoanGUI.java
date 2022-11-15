package gui;

import java.awt.Color;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
import entity.Account;
import entity.Staff;

public class QuanLyTaiKhoanGUI extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2119495183914141508L;

	private JPanel khung;
	private JLabel lblMaNV;
	private JLabel lblTenTK;
	private JLabel lblMatKhau;
	private JLabel lblTimKiem;

	private JTextField txtMaNV;
	private JTextField txtTenTK;
	private JPasswordField txtMatKhau;
	private JTextField txtTimKiem;

	private JTable table;
	private DefaultTableModel tableModel;

	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnXoaTrang;
	private JButton btnThoat;

	String[] headersTaiKhoan = { "Mã Nhân Viên", "Tên Tài Khoản" };
	private Client client = new Client();
	
	@SuppressWarnings("serial")
	public QuanLyTaiKhoanGUI() throws RemoteException, MalformedURLException, NotBoundException {
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setTitle("HỆ THỐNG QUẢN LÝ TÀI KHOẢN NHÂN VIÊN");
		setBounds(300, 100, 1300, 700);
		khung = new JPanel();
		khung.setBackground(new Color(255, 179, 0));
		khung.setForeground(new Color(255, 255, 255));
		khung.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(khung);
		khung.setLayout(null);

		JLabel lblQLLoaiSP = new JLabel("QUẢN LÝ TÀI KHOẢN NHÂN VIÊN");
		lblQLLoaiSP.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblQLLoaiSP.setForeground(new Color(0, 0, 0));
		lblQLLoaiSP.setBounds(450, 8, 600, 35);
		khung.add(lblQLLoaiSP);

		JPanel p1 = new JPanel();
		p1.setForeground(new Color(0, 255, 255));
		p1.setBackground(new Color(204, 204, 204));
		p1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Thông tin Tài Khoản:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		p1.setBounds(0, 80, 350, 684);
		khung.add(p1);
		p1.setLayout(null);

		// Danh sách Loại Sản Phẩm
		tableModel = new DefaultTableModel(headersTaiKhoan, 0);
		JPanel pnTable = new JPanel();
		pnTable.setBounds(350, 80, 932, 590);

		pnTable.setBackground(new Color(204, 204, 204));
		pnTable.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh Sách Tài Khoản",
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
		lblMaNV = new JLabel("Mã Nhân Viên:");
		lblMaNV.setBounds(10, 50, 120, 14);
		p1.add(lblMaNV);
		txtMaNV = new JTextField();
		txtMaNV.setBounds(140, 47, 200, 20);
		p1.add(txtMaNV);
		txtMaNV.setColumns(10);

		lblTenTK = new JLabel("Tên Tài Khoản:");
		lblTenTK.setBounds(10, 100, 120, 14);
		p1.add(lblTenTK);
		txtTenTK = new JTextField();
		txtTenTK.setEditable(false);
		txtTenTK.setBounds(140, 97, 200, 20);
		p1.add(txtTenTK);
		txtTenTK.setColumns(10);

		lblMatKhau = new JLabel("Mật Khẩu:");
		lblMatKhau.setBounds(10, 150, 120, 14);
		p1.add(lblMatKhau);
		txtMatKhau = new JPasswordField();
		txtMatKhau.setBounds(140, 147, 200, 20);
		p1.add(txtMatKhau);

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

		// Thêm
		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnThem.setForeground(new Color(0, 0, 0));
		btnThem.setBackground(new Color(226, 207, 72));
		btnThem.setBounds(40, 450, 120, 40);
		p1.add(btnThem);

		// Xóa
		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnXoa.setForeground(new Color(0, 0, 0));
		btnXoa.setBackground(new Color(226, 207, 72));
		btnXoa.setBounds(180, 450, 120, 40);
		p1.add(btnXoa);

		// Cập nhật
		btnSua = new JButton("Cập Nhật");
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSua.setForeground(new Color(0, 0, 0));
		btnSua.setBackground(new Color(226, 207, 72));
		btnSua.setBounds(40, 500, 120, 40);
		p1.add(btnSua);

		// Xóa trắng
		btnXoaTrang = new JButton("Xóa Trắng");
		btnXoaTrang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnXoaTrang.setForeground(new Color(0, 0, 0));
		btnXoaTrang.setBackground(new Color(226, 207, 72));
		btnXoaTrang.setBounds(180, 500, 120, 40);
		p1.add(btnXoaTrang);

//		===================================
		lblTimKiem = new JLabel("Nhập TT Tài Khoản Cần Tìm:");
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTimKiem.setBounds(780, 45, 340, 35);
		khung.add(lblTimKiem);
		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(1030, 50, 200, 25);
		khung.add(txtTimKiem);

		renderDataToTable();
		
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		
		txtMaNV.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				try {
					GenarateUsernameKeyRelease(evt);
				} catch (RemoteException | MalformedURLException | NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			private void GenarateUsernameKeyRelease(KeyEvent evt) throws RemoteException, MalformedURLException, NotBoundException {
				// TODO Auto-generated method stub
				txtTenTK.setText(client.getAccountDAO().generateUsernameByStaffID(txtMaNV.getText()));
			}
		});
		
		// -----------------------Xử Lý Tìm Kiếm-------------------------------------//

		txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				TimKiemKeyRelease(evt);
			}

			private void TimKiemKeyRelease(KeyEvent evt) {
				// TODO Auto-generated method stub
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				String search = txtTimKiem.getText();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tableModel);
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(search));
			}
		});

		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				int rowclicked = table.getSelectedRow();
				txtMaNV.setText(table.getValueAt(rowclicked, 0).toString());
				txtMaNV.setEditable(false);
				txtTenTK.setText(table.getValueAt(rowclicked, 1).toString());
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

	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		QuanLyTaiKhoanGUI quanLyTaiKhoanGUI = new QuanLyTaiKhoanGUI();
		quanLyTaiKhoanGUI.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			try {
				add(txtTenTK.getText());
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
		List<Account> listAccounts = client.getAccountDAO().getListAccounts();
		int columns = headersTaiKhoan.length;
		Object[] obj;
		int rows = listAccounts.size();
		if (rows > 0) {
			for (int i = 0; i < rows; i++) {
				Account account = listAccounts.get(i);
				obj = new Object[columns];
				obj[0] = account.getStaff().getId();
				obj[1] = account.getUserName();
				tableModel.addRow(obj);
			}
		}
	}

// ----------------------Xử lý sự kiện thêm thông tin Tài khoản-------------------------------------//

	@SuppressWarnings("deprecation")
	private void add(String tenTaiKhoan) throws RemoteException, MalformedURLException, NotBoundException {
		String maNV = txtMaNV.getText();
		String tenTK = tenTaiKhoan;
		String matKhau = txtMatKhau.getText();

		Staff staffID = new Staff(maNV);
		Account account = new Account(tenTK, matKhau, staffID);
		
		System.out.println(account);
		client.getAccountDAO().addAccount(account);
		clearTable();
		updateAccountTable();
		clearTextField();
	}

// ----------------------Xử lý sự kiện xóa thông tin loại sản phẩm-------------------------------------//

	private void delete() throws HeadlessException, RemoteException, MalformedURLException, NotBoundException {
		int row = table.getSelectedRow();
		if (row != -1) {
			int confirmAlert = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá Thông Tin Tài Khoản này không?",
					"Chú ý", JOptionPane.YES_NO_OPTION);
			if (confirmAlert == JOptionPane.YES_OPTION) {
				String maNV = table.getValueAt(row, 0).toString();
				if (client.getAccountDAO().deleteAccount(maNV)) {
					tableModel.removeRow(row);
					JOptionPane.showMessageDialog(this, "Đã xoá!");
					clearTextField();
				} else
					JOptionPane.showMessageDialog(this, "Xoá thất bại!");
			}
		} else
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn Thông Tin Tài Khoản Cần Xóa!");
	}

// ----------------------Xử lý sự kiện cập nhật thông tin Tài khoản-------------------------------------//

	@SuppressWarnings("deprecation")
	private void update() throws RemoteException, HeadlessException, MalformedURLException, NotBoundException {
		String maNV = txtMaNV.getText();
		String tenTK = txtTenTK.getText();
		String matKhau = txtMatKhau.getText();
		int row = table.getSelectedRow();
		if (row != -1) {
			Staff staffID = new Staff(maNV);
			Account account = new Account(tenTK, matKhau, staffID);
			if (client.getAccountDAO().updateAccount(account)) {
				table.setValueAt(maNV, row, 0);
				table.setValueAt(tenTK, row, 1);
				JOptionPane.showMessageDialog(this, "Đã cập nhật!");
				clearTextField();
				updateAccountTable();
			} else
				JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
		} else
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn Thông Tin Tài Khoản cần cập nhật!");
	}
// ----------------------Xử lý sự kiện cập nhật bảng Tài khoản-------------------------------------//
	
	private void updateAccountTable() throws RemoteException, MalformedURLException, NotBoundException {
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Mã Nhân Viên");
		tableModel.addColumn("Tên Tài Khoản");
		List<Account> listAccounts = client.getAccountDAO().getListAccounts();
		for (Account account : listAccounts) {
			String[] rowData1 = { account.getStaff().getId(), account.getUserName()};
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
		txtMaNV.setText("");
		txtMaNV.setEditable(true);
		txtTenTK.setText("");
		txtMatKhau.setText("");
	}
}

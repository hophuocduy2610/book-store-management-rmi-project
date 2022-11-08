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
import entity.Supplier;



public class QuanLyNCCGUI extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7565998242377216182L;

	private JPanel khung;

	private JLabel lblMaNCC;
	private JLabel lblTenNCC;
	private JLabel lblDiaChi;
	private JLabel lblPhuong;
	private JLabel lblQuan;
	private JLabel lblThanhPho;
	private JLabel lblSDT;
	private JLabel lblEmail;
	private JLabel lblTimKiem;

	private JTextField txtMaNCC;
	private JTextField txtTenNCC;
	private JTextField txtDiaChi;
	private JTextField txtPhuong;
	private JTextField txtQuan;
	private JTextField txtThanhPho;
	private JTextField txtSDT;
	private JTextField txtEmail;
	private JTextField txtTimKiem;
	

	private JTable table;
	private DefaultTableModel tableModel;

	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoaNCC;
	private JButton btnXoaTrang;
//	private JButton btnTimKiem;
	private JButton btnThoat;
	String[]headers1 = {"Mã nhà cung cấp","Tên nhà cung cấp", "Địa chỉ", "Phường", "Quận", "Thành phố", "Số điện thoại", "Email"};
	private Client client = new Client();
	
	@SuppressWarnings("serial")
	public QuanLyNCCGUI() throws RemoteException, MalformedURLException, NotBoundException {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setTitle("HỆ THÔNG QUẢN LÝ NHÀ CUNG CẤP");
		setBounds(300, 100, 1300, 700);
		khung = new JPanel();
		khung.setBackground(new Color(255, 179, 0));
		khung.setForeground(new Color(255, 255, 255));
		khung.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(khung);
		khung.setLayout(null);

		JLabel lblQLNCC = new JLabel("QUẢN LÝ NHÀ CUNG CẤP");
		lblQLNCC.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblQLNCC.setForeground(new Color(0,0,0));
		lblQLNCC.setBounds(450, 10, 600, 35);
		khung.add(lblQLNCC);

		JPanel p1 = new JPanel();
		p1.setForeground(new Color(0,255,255));
		p1.setBackground(new Color(204,204,204));
		p1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Thông tin nhà cung cấp:",TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		p1.setBounds(0, 80, 350, 684);
		khung.add(p1);
		p1.setLayout(null);

		//Danh sách Nhà cung cấp
		tableModel = new DefaultTableModel(headers1,0);
		JPanel pnTable= new JPanel();
		pnTable.setBounds(350, 80, 932, 620);
		pnTable.setBackground(new Color(204, 204, 204));
		pnTable.setBackground(new Color(204, 204, 204));
		pnTable.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh Sách Nhà Cung Cấp", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
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

		//add các Text vào 
		lblMaNCC = new JLabel("Mã Nhà Cung Cấp:");
		lblMaNCC.setBounds(10, 50, 120, 14);
		p1.add(lblMaNCC );		
		txtMaNCC  = new JTextField();
		txtMaNCC.setBounds(140, 47, 200, 20);
		p1.add(txtMaNCC);
		txtMaNCC.setColumns(10);
		txtMaNCC.setEditable(false);

		lblTenNCC = new JLabel("Tên Nhà Cung Cấp:");
		lblTenNCC.setBounds(10, 100, 120, 14);
		p1.add(lblTenNCC);		
		txtTenNCC  = new JTextField();
		txtTenNCC.setBounds(140, 97, 200, 20);
		p1.add(txtTenNCC);
		txtTenNCC.setColumns(10);	
		
		lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setBounds(10, 150, 120, 14);
		p1.add(lblDiaChi);		
		txtDiaChi  = new JTextField();
		txtDiaChi.setBounds(140, 147, 200, 20);
		p1.add(txtDiaChi);
		txtDiaChi.setColumns(10);	
		
		lblPhuong = new JLabel("Phường:");
		lblPhuong.setBounds(10, 200, 120, 14);
		p1.add(lblPhuong);		
		txtPhuong  = new JTextField();
		txtPhuong.setBounds(140, 197, 200, 20);
		p1.add(txtPhuong);
		txtPhuong.setColumns(10);	
		
		lblQuan = new JLabel("Quận:");
		lblQuan.setBounds(10, 250, 120, 14);
		p1.add(lblQuan);		
		txtQuan  = new JTextField();
		txtQuan.setBounds(140, 247, 200, 20);
		p1.add(txtQuan);
		txtQuan.setColumns(10);	
		
		lblThanhPho = new JLabel("Thành phố:");
		lblThanhPho.setBounds(10, 300, 120, 14);
		p1.add(lblThanhPho);		
		txtThanhPho  = new JTextField();
		txtThanhPho.setBounds(140, 297, 200, 20);
		p1.add(txtThanhPho);
		txtThanhPho.setColumns(10);	
		
		lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setBounds(10, 350, 120, 14);
		p1.add(lblSDT);		
		txtSDT  = new JTextField();
		txtSDT.setBounds(140, 347, 200, 20);
		p1.add(txtSDT);
		txtSDT.setColumns(10);	
		
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 400, 120, 14);
		p1.add(lblEmail);		
		txtEmail  = new JTextField();
		txtEmail.setBounds(140, 397, 200, 20);
		p1.add(txtEmail);
		txtEmail.setColumns(10);	

		btnThoat = new JButton();
		btnThoat.setBounds(0, 0, 60, 40);
		btnThoat.setIcon(new ImageIcon("assets/image/exit.png"));
		btnThoat.setBackground(new Color(51, 255, 51));
		khung.add(btnThoat);
		
		//Thêm
		btnThem = new JButton("Thêm ");
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnThem.setForeground(new Color(0, 0, 0));
		btnThem.setBackground(new Color(226, 207, 72));
		btnThem.setBounds(40, 450, 130, 40);
		p1.add(btnThem);

		//Xóa rỗng
		btnXoaNCC = new JButton("Xóa");
		btnXoaNCC.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnXoaNCC.setForeground(new Color(0, 0, 0));
		btnXoaNCC.setBackground(new Color(226, 207, 72));
		btnXoaNCC.setBounds(180,450, 120, 40);
		p1.add(btnXoaNCC);

		//lƯU
		btnSua = new JButton("Cập Nhật");
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSua.setForeground(new Color(0, 0, 0));
		btnSua.setBackground(new Color(226, 207, 72));
		btnSua.setBounds(40,500, 130, 40);
		p1.add(btnSua);

		//Xoa Trang
		btnXoaTrang = new JButton("Xóa Rỗng");
		btnXoaTrang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnXoaTrang.setForeground(new Color(0, 0, 0));
		btnXoaTrang.setBackground(new Color(226, 207, 72));
		btnXoaTrang.setBounds(180,500, 120, 40);
		p1.add(btnXoaTrang);
		
		
		
//		======================================
		lblTimKiem= new JLabel("Nhập TT Nhà Cung Cấp Cần Tìm:");
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTimKiem.setBounds(780, 45, 340, 35);
		khung.add(lblTimKiem);
		txtTimKiem= new JTextField();
		txtTimKiem.setBounds(1050,50, 200, 25);
		khung.add(txtTimKiem);
		
		//-----------------------Xử Lý Thoát-------------------------------------//

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
		
		//-----------------------Xử Lý Tìm Kiếm-------------------------------------//

		txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				TimKiemKeyRelease(evt);
			}

			private void TimKiemKeyRelease(KeyEvent evt) {
				// TODO Auto-generated method stub
				DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
				String search = txtTimKiem.getText();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tableModel);
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(search));
			}
		});
		//--------------------------------Đăng ký sự kiện cho các Button----------------------------------------------//		

		btnThem.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoaNCC.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnSua.addActionListener(this);
		
		renderDataToTable();
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				int rowclicked= table.getSelectedRow();
				txtMaNCC.setText(tableModel.getValueAt(rowclicked, 0).toString());
				txtTenNCC.setText(tableModel.getValueAt(rowclicked, 1).toString());
				txtDiaChi.setText(tableModel.getValueAt(rowclicked, 2).toString());
				txtPhuong.setText(tableModel.getValueAt(rowclicked, 3).toString());
				txtQuan.setText(tableModel.getValueAt(rowclicked, 4).toString());
				txtThanhPho.setText(tableModel.getValueAt(rowclicked, 5).toString());
				txtSDT.setText(tableModel.getValueAt(rowclicked, 6).toString());
				txtEmail.setText(tableModel.getValueAt(rowclicked, 7).toString());
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

	
//	//main
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyNCCGUI frame = new QuanLyNCCGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThem))
		{
			try {
				add();
			} catch (RemoteException | MalformedURLException | NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(o.equals(btnXoaNCC))
		{
			try {
				delete();
			} catch (HeadlessException | RemoteException | MalformedURLException | NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(o.equals(btnSua))
		{
			try {
				update();
			} catch (HeadlessException | RemoteException | MalformedURLException | NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(o.equals(btnXoaTrang))
		{
			clearTable();
			clearTextField();
		}
	}
	
	//----------------------Xử Lý Đưa dữ liệu từ Database lên bảng-------------------------------------//
	
		public void renderDataToTable() throws RemoteException, MalformedURLException, NotBoundException {
			List<Supplier> listSuppliers = client.getSupplierDAO().getListSuppliers();
			int columns = headers1.length;
			Object[] obj;
			int rows = listSuppliers.size();
			if (rows > 0) {
				for (int i = 0; i < rows; i++) {
					Supplier sup = listSuppliers.get(i);
					obj = new Object[columns];
					obj[0] = sup.getId();
					obj[1] = sup.getName();
					obj[2] = sup.getAddress().getAddress();
					obj[3] = sup.getAddress().getWard();
					obj[4] = sup.getAddress().getDistrict();
					obj[5] = sup.getAddress().getCity();
					obj[6] = sup.getPhone();
					obj[7] = sup.getEmail();
					tableModel.addRow(obj);
				}
			}
		}

	// ----------------------Xử lý sự kiện thêm thông tin nhà cung cấp-------------------------------------//
	
	private void add() throws RemoteException, MalformedURLException, NotBoundException {
		String maNCC = client.getSupplierDAO().generateSupplierID();
		String tenNCC = txtTenNCC.getText().toString();
		String diaChi = txtDiaChi.getText().toString();
		String phuong = txtPhuong.getText().toString();
		String quan = txtQuan.getText().toString();
		String thanhPho = txtThanhPho.getText().toString();
		String sdt = txtSDT.getText().toString();
		String email = txtEmail.getText().toString();
		
		Address address = new Address(thanhPho, quan, phuong, diaChi);
		Supplier supplier = new Supplier(maNCC, tenNCC, sdt, email, address, ABORT);
		
		client.getSupplierDAO().addSupplier(supplier);
		clearTable();
		updateSupplierTable();
		clearTextField();
	}
	
	// ----------------------Xử lý sự kiện xóa thông tin nhà cung cấp-------------------------------------//

		private void delete() throws HeadlessException, RemoteException, MalformedURLException, NotBoundException {
			int row = table.getSelectedRow();
			if (row != -1) {
				int confirmAlert = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá Thông Tin Nhà Cung Cấp này không?",
						"Chú ý", JOptionPane.YES_NO_OPTION);
				if (confirmAlert == JOptionPane.YES_OPTION) {
					String maNCC = table.getValueAt(row, 0).toString();
					if (client.getSupplierDAO().deleteSupplier(maNCC)) {
						tableModel.removeRow(row);
						JOptionPane.showMessageDialog(this, "Đã xoá!");
						clearTextField();
					} else
						JOptionPane.showMessageDialog(this, "Xoá thất bại!");
				}
			} else
				JOptionPane.showMessageDialog(this, "Bạn chưa chọn Thông Tin Nhà Cung Cấp Cần Xóa!");
		}

	
	// ----------------------Xử lý sự kiện cập nhật thông tin nhà cung cấp-------------------------------------//

		private void update() throws RemoteException, HeadlessException, MalformedURLException, NotBoundException {
			String maNCC = txtMaNCC.getText().toString();
			String tenNCC = txtTenNCC.getText().toString();
			String diaChi = txtDiaChi.getText().toString();
			String phuong = txtPhuong.getText().toString();
			String quan = txtQuan.getText().toString();
			String thanhPho = txtThanhPho.getText().toString();
			String sdt = txtSDT.getText().toString();
			String email = txtEmail.getText().toString();
			
			int row = table.getSelectedRow();
			if (row != -1) {
				Address address = new Address(thanhPho, quan, phuong, diaChi);
				Supplier supplier = new Supplier(maNCC, tenNCC, sdt, email, address, ABORT);
				if (client.getSupplierDAO().updateSupplier(supplier)) {
					table.setValueAt(maNCC, row, 0);
					table.setValueAt(tenNCC, row, 1);
					table.setValueAt(diaChi, row, 2);
					table.setValueAt(phuong, row, 3);
					table.setValueAt(quan, row, 4);
					table.setValueAt(thanhPho, row, 5);
					table.setValueAt(sdt, row, 6);
					table.setValueAt(email, row, 7);
					JOptionPane.showMessageDialog(this, "Đã cập nhật!");
					clearTextField();
					updateSupplierTable();
				} else
					JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
			} else
				JOptionPane.showMessageDialog(this, "Bạn chưa chọn Thông Tin Nhà Cung Cấp cần cập nhật!");
		}
	
	// ----------------------Xử lý sự kiện cập nhật bảng nhà cung cấp-------------------------------------//

		private void updateSupplierTable() throws RemoteException, MalformedURLException, NotBoundException {
//			"Mã nhà cung cấp","Tên nhà cung cấp", "Địa chỉ", "Phường", "Quận", "Thành phố", "Số điện thoại", "Email"
			tableModel = new DefaultTableModel();
			tableModel.addColumn("Mã nhà cung cấp");
			tableModel.addColumn("Tên nhà cung cấp");
			tableModel.addColumn("Địa chỉ");
			tableModel.addColumn("Phường");
			tableModel.addColumn("Quận");
			tableModel.addColumn("Thành phố");
			tableModel.addColumn("Số điện thoại");
			tableModel.addColumn("Email");
			List<Supplier> listSuppliers = client.getSupplierDAO().getListSuppliers();
			for (Supplier supplier : listSuppliers) {
				String[] rowData1 = { supplier.getId(), supplier.getName(), supplier.getAddress().getAddress(),
						supplier.getAddress().getWard(), supplier.getAddress().getDistrict(),
						supplier.getAddress().getCity(), supplier.getPhone(), supplier.getEmail() };
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
		txtMaNCC.setText("");
		txtTenNCC.setText("");
		txtDiaChi.setText("");
		txtPhuong.setText("");
		txtQuan.setText("");
		txtThanhPho.setText("");
		txtSDT.setText("");
		txtEmail.setText("");
	}
}

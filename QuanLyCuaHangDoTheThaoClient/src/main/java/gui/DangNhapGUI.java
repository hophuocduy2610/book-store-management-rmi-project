package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import app.Client;
import entity.Account;
import entity.Staff;

public class DangNhapGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8583278951567440630L;

	JLabel lblTaiKhoan, lblMatKhau, lblTieuDe, lblnote;
	JTextField txtTaiKhoan;
	JPasswordField txtMatKhau;
	JButton btnDangNhap, btnThoat;
	Color gbMain = new Color(214, 214, 214);
	private Client client = new Client();

	@SuppressWarnings("deprecation")
	public DangNhapGUI() {
		// TODO Auto-generated constructor stub
		setTitle("ĐĂNG NHẬP");
		setSize(550, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel pCenter;
		add(pCenter = new JPanel(), BorderLayout.CENTER);
		pCenter.setBackground(gbMain);
		Box x;
		pCenter.add(x = Box.createVerticalBox());
		x.add(Box.createVerticalStrut(30));

		Box x0;
		x.add(x0 = Box.createHorizontalBox());
		x0.add(lblTieuDe = new JLabel("PHẦN MỀM QUẢN LÝ CỬA HÀNG ĐỒ THỂ THAO"));
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
		x.add(Box.createVerticalStrut(30));

		Box x1;
		x.add(x1 = Box.createHorizontalBox());
		x1.add(Box.createHorizontalStrut(50));
		x1.add(lblTaiKhoan = new JLabel("Tài khoản:"));
		x1.add(Box.createHorizontalStrut(20));
		x1.add(txtTaiKhoan = new JTextField());
		x1.add(Box.createHorizontalStrut(50));
		x.add(Box.createVerticalStrut(15));

		Box x2;
		x.add(x2 = Box.createHorizontalBox());
		x2.add(Box.createHorizontalStrut(50));
		x2.add(lblMatKhau = new JLabel("Mật khẩu:"));
		x2.add(Box.createHorizontalStrut(22));
		x2.add(txtMatKhau = new JPasswordField());
		x2.add(Box.createHorizontalStrut(50));
		x.add(Box.createVerticalStrut(20));

		Box x3;
		x.add(x3 = Box.createHorizontalBox());
		btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setBackground(new Color(226, 207, 72));
		btnDangNhap.setMinimumSize(new Dimension(120, 40));
		x3.add(btnDangNhap);

		x3.add(Box.createHorizontalStrut(20));
		x3.add(btnThoat = new JButton("Thoát"));
		btnThoat.setBackground(new Color(226, 207, 72));
		x.add(Box.createVerticalStrut(30));

		btnThoat.addActionListener((e) -> {
			int loinhac = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thoát !!!!", "Nhắc nhở",
					JOptionPane.YES_NO_OPTION);
			if (loinhac == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		});

		btnDangNhap.addActionListener((e) -> {
			try {
				boolean result = client.getAccountDAO().isExistAccount(txtTaiKhoan.getText(), txtMatKhau.getText());
				if (result) {
					MainGUI mainGUI = new MainGUI();
					
					Account account = client.getAccountDAO().getAccountByName(txtTaiKhoan.getText());
					String staffID = account.getStaff().getId();
					Staff staff = client.getStaffDAO().getStaffById(staffID);
					
					GetDataTemp.maNV = staff.getId();
					GetDataTemp.tenNV = staff.getName();
					
					System.out.println(GetDataTemp.maNV);
					System.out.println(GetDataTemp.tenNV);
					
					mainGUI.setVisible(true);
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(this, "Sai tên đăng nhập hoặc mật khẩu, vui lòng nhập lại");
				}
			} catch (RemoteException | MalformedURLException | NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DangNhapGUI dangNhapGUI = new DangNhapGUI();
		dangNhapGUI.setVisible(true);
	}

}

package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.*;


public class MainGUI extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3699048493099650171L;
	private JPanel pnNorth, pnCenter;
	private JButton btnThoat;
	private JMenuItem item1, item2, item3, item4, item5, item6, item7;
	private ImageIcon img;

	public MainGUI() throws IOException {
		super("PHẦN MỀM QUẢN LÝ THÔNG TIN CỬA HÀNG ĐỒ THỂ THAO");
		giaoDien();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1080, 720);
		setVisible(true);
	}

	private void giaoDien() throws IOException {
		//================Panel North========================
		pnNorth = new JPanel();
//		pnNorth.setPreferredSize(new Dimension(1080, 40));
		pnNorth.setLayout(new BoxLayout(pnNorth,BoxLayout.X_AXIS));
		JMenuBar bar1 = new JMenuBar();
		bar1.setBackground(new Color(255, 188, 87));
		pnNorth.add(bar1);

//		============================
		JMenu menu5 = new JMenu();
		bar1.add(Box.createHorizontalStrut(20));
		bar1.add(menu5);
		menu5.setBounds(350, 0, 150, 40);
		menu5.setText("Hóa đơn");
		menu5.setIcon(new javax.swing.ImageIcon("assets/image/order-1.png"));

		item5 = new JMenuItem();
		item5.setText("Lập Hóa Đơn");
		item5.setIcon(new ImageIcon("assets/image/laphoadon.png"));

		menu5.add(item5);
		
		item6 = new JMenuItem();
		item6.setText("Quản Lý Hóa Đơn");
		item6.setIcon(new ImageIcon("assets/image/order-1.png"));

		menu5.add(item6);
		
//		==================================
		JMenu menu1 = new JMenu();
		menu1.setBounds(0, 0, 150, 40);
		menu1.setText("Sản Phẩm");
		menu1.setIcon(new javax.swing.ImageIcon("assets/image/pricetag_icon.png"));
		bar1.add(Box.createHorizontalStrut(50));
		bar1.add(menu1);

		item1 = new JMenuItem();
		item1.setText("Quản Lý Sản Phẩm");
		item1.setIcon(new javax.swing.ImageIcon("assets/image/product_icon.png"));
		
		item7 = new JMenuItem();
		item7.setText("Quản Lý Loại Sản Phẩm");
		item7.setIcon(new javax.swing.ImageIcon("assets/image/product_icon.png"));


		menu1.add(item1);
		menu1.add(item7);
//		============================
		JMenu menu4 = new JMenu();
		bar1.add(Box.createHorizontalStrut(50));
		bar1.add(menu4);
		menu4.setBounds(350, 0, 150, 40);
		menu4.setText("Nhân Viên");
		menu4.setIcon(new javax.swing.ImageIcon("assets/image/nhanvien.png"));

		item4 = new JMenuItem();
		item4.setText("Quản Lý Nhân Viên");
		item4.setIcon(new ImageIcon("assets/image/nhanvien.png"));

		menu4.add(item4);
		
//		=============================
		JMenu menu2 = new JMenu();
		bar1.add(Box.createHorizontalStrut(50));
		bar1.add(menu2);
		menu2.setBounds(150, 0, 200, 40);
		menu2.setText("Thông Tin Nhà Cung Cấp");
		menu2.setIcon(new javax.swing.ImageIcon("assets/image/home_1.png"));

		item2 = new JMenuItem();
		item2.setText("Quản Lý TT Nhà Cung Cấp");
		item2.setIcon(new javax.swing.ImageIcon("assets/image/home.png"));

		menu2.add(item2);
//		==================================

		JMenu menu3 = new JMenu();
		bar1.add(Box.createHorizontalStrut(50));
		bar1.add(menu3);
		menu3.setBounds(350, 0, 150, 40);
		menu3.setText("Khách Hàng");
		menu3.setIcon(new javax.swing.ImageIcon("assets/image/user_group_icon.png"));

		item3 = new JMenuItem();
		item3.setText("Quản Lý Khách Hàng");
		item3.setIcon(new ImageIcon("assets/image/user_icon.png"));

		menu3.add(item3);
		
//		============================

		btnThoat = new JButton();
		btnThoat.setBounds(0, 0, 60, 40);
		btnThoat.setIcon(new ImageIcon("assets/image/exit.png"));
		bar1.add(Box.createHorizontalStrut(385));
		bar1.add(btnThoat);
		btnThoat.setBackground(new Color(51, 255, 51));
		btnThoat.addActionListener((Main) -> {
			int loinhac = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thoát !!!!", "Nhắc nhở",
					JOptionPane.YES_NO_OPTION);
			if (loinhac == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(this, "Cảm ơn bạn đã sử dụng dịch vụ");
				System.exit(0);
			}
		});

//		==============================
		item1.addActionListener((e1) -> {
			QuanLySPGUI quanLySPGUI;
			try {
				quanLySPGUI = new QuanLySPGUI();
				quanLySPGUI.setVisible(true);
				setVisible(false);
			} catch (RemoteException | MalformedURLException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

		item2.addActionListener((e2) -> {
			QuanLyNCCGUI quanLyNCCGUI;
			try {
				quanLyNCCGUI = new QuanLyNCCGUI();
				quanLyNCCGUI.setVisible(true);
				setVisible(false);
			} catch (RemoteException | MalformedURLException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		item3.addActionListener((e3) -> {
			QuanLyKhachHangGUI quanLyKhachHangGUI;
			try {
				quanLyKhachHangGUI = new QuanLyKhachHangGUI();
				quanLyKhachHangGUI.setVisible(true);
				setVisible(false);
			} catch (RemoteException | MalformedURLException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		item4.addActionListener((e3) -> {
			QuanLyNhanVienGUI quanLyNhanVienGUI;
			try {
				quanLyNhanVienGUI = new QuanLyNhanVienGUI();
				quanLyNhanVienGUI.setVisible(true);
				setVisible(false);
			} catch (RemoteException | MalformedURLException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		item5.addActionListener((e3) -> {
			LapHoaDonGUI lapHoaDonGUI = new LapHoaDonGUI();
			lapHoaDonGUI.setVisible(true);
			setVisible(false);
		});
		
		item6.addActionListener((e3) -> {
			QuanLyHoaDonGUI quanLyHoaDonGUI = new QuanLyHoaDonGUI();
			quanLyHoaDonGUI.setVisible(true);
			setVisible(false);
		});
		
		item7.addActionListener((e3) -> {
			QuanLyLoaiSPGUI quanLyLoaiSPGUI;
			try {
				quanLyLoaiSPGUI = new QuanLyLoaiSPGUI();
				quanLyLoaiSPGUI.setVisible(true);
				setVisible(false);
			} catch (RemoteException | MalformedURLException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	//====================Panel North==========================
		pnCenter = new JPanel();
		img = new  ImageIcon("assets/image/background_image.jpg");
		ImageIcon newImg = scaleImage(img, 1280, 720);
		JLabel picLabel = new JLabel(newImg);
		pnCenter.add(picLabel);
		add(pnCenter, BorderLayout.CENTER);
		add(pnNorth, BorderLayout.NORTH);
	}

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//Set size image
	public ImageIcon scaleImage(ImageIcon icon, int w, int h)
    {
        int nw = icon.getIconWidth();
        int nh = icon.getIconHeight();

        if(icon.getIconWidth() > w)
        {
          nw = w;
          nh = (nw * icon.getIconHeight()) / icon.getIconWidth();
        }

        if(nh > h)
        {
          nh = h;
          nw = (icon.getIconWidth() * nh) / icon.getIconHeight();
        }

        return new ImageIcon(icon.getImage().getScaledInstance(nw, nh, Image.SCALE_SMOOTH));
    }
	@Override
	public void actionPerformed(ActionEvent e) {

	}

}

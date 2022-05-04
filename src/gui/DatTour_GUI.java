package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.KhachHang_DAO;
import dao.Tour_DAO;
import dao.VeDao;
import entity.KhachHang;
import entity.NhanVien;
import entity.Tour;
import entity.Ve;
import shareData.ShareData;

import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;

//import connectDB.ConnectDB;
//import dao.Tour_DAO;
//import entity.Tour;

public class DatTour_GUI extends JPanel implements ActionListener, MouseListener, KeyListener{
	/**
	 * 
	 */
	private JPanel contentPane;
	private JTextField txtHoTen;
	private JTextField txtCMND;
	private JTextField txtSLNguoiLon;
	private JTextField txtSlTreEm;
	private DefaultTableModel tableModel;
	private JTable table;
	private Tour_DAO tour_DAO;
	private ArrayList<Tour> danhSachTour;
	private JButton btnXacNhan;
	private JButton btnLoc;
	private JScrollPane tableDanhSach;
	private DefaultComboBoxModel<String> dfcbboxLocGia;
	private JLabel lblTTNgay;
	private JLabel lblTTThoiGian;
	private JLabel lblTTGiaNL;
	private JLabel lblTTTTGiaTE;
	private JLabel lblTTTong;
	private JComboBox cbboxGia;
	private JComboBox cbboxNgay;
	private JComboBox cbboxThang;
	private JComboBox cbboxNam;
	private JLabel errLoc;
	private JButton btnHuy;
	private JLabel errNhapThongTin;
	private JLabel lblTenTour;
	private JLabel errThanhToan;
	private JButton btnThanhToan;
	private JLabel iconDatTour;
	private JTextArea tAreaMoTa;
	private JTextField txtSDT;
	private JTextField txtGioiTinh;
	private KhachHang_DAO khachHang_DAO;
	private KhachHang khachHang;
	private VeDao veDao;
	private ArrayList<KhachHang> dsKH;

	public static void main(String[] args) {
		new DatTour_GUI().setVisible(true);

	}
	
	public DatTour_GUI() {
		
//		//ket noi SQL
		try {
			ConnectDB.getInstance().connect();
	} catch (SQLException e) {
			e.printStackTrace();
		}	
		khachHang_DAO  = new KhachHang_DAO(); 
		veDao = new VeDao();
//		
		// -------------------------------------------
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	//	setResizable(false);
		setBounds(100, 100, 1250, 700);
		setLayout(null);
		contentPane = new JPanel();
		contentPane.setBounds(0, 1, 1250, 665);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		add(contentPane);
		contentPane.setLayout(null);		
		JLabel lblNewLabel = new JLabel("Đặt Tour");
		lblNewLabel.setForeground(new Color(0, 206, 209));
		lblNewLabel.setBounds(545, 0, 222, 47);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 38));
		contentPane.add(lblNewLabel);
		
		// -------------------------------------------
		//JPanel nhap thong tin khach hang
		JPanel pnNhapThongTinKH = new JPanel();
		pnNhapThongTinKH.setBorder(new LineBorder(new Color(221, 160, 221)));
		pnNhapThongTinKH.setBounds(10, 21, 420, 257);
		contentPane.add(pnNhapThongTinKH);
		pnNhapThongTinKH.setLayout(null);
		
		JLabel lblCMND = new JLabel("CMND: ");
		lblCMND.setForeground(new Color(148, 0, 211));
		lblCMND.setBounds(10, 16, 71, 15);
		pnNhapThongTinKH.add(lblCMND);
		lblCMND.setFont(new Font("Arial", Font.PLAIN, 18));
		
		txtCMND = new JTextField();
		txtCMND.setBackground(new Color(241, 233, 233));
		txtCMND.setText("");
		txtCMND.setFont(new Font("Arial", Font.PLAIN, 14));
		txtCMND.setBounds(141, 10, 240, 23);
		pnNhapThongTinKH.add(txtCMND);
		txtCMND.setColumns(10);
		
		JLabel lblHoTen = new JLabel("Họ và tên: ");
		lblHoTen.setForeground(new Color(148, 0, 211));
		lblHoTen.setBounds(10, 41, 126, 27);
		pnNhapThongTinKH.add(lblHoTen);
		lblHoTen.setFont(new Font("Arial", Font.PLAIN, 18));
		
		txtHoTen = new JTextField();
		txtHoTen.setBackground(new Color(241, 233, 233));
		txtHoTen.setText("");
		txtHoTen.setFont(new Font("Arial", Font.PLAIN, 14));
		txtHoTen.setBounds(141, 40, 240, 23);
		pnNhapThongTinKH.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		JLabel lblSLNguoiLon = new JLabel("SL người lớn:");
		lblSLNguoiLon.setForeground(new Color(148, 0, 211));
		lblSLNguoiLon.setBounds(10, 138, 137, 32);
		pnNhapThongTinKH.add(lblSLNguoiLon);
		lblSLNguoiLon.setFont(new Font("Arial", Font.PLAIN, 18));
		
		txtSLNguoiLon = new JTextField();
		txtSLNguoiLon.setBackground(new Color(241, 233, 233));
		txtSLNguoiLon.setText("");
		txtSLNguoiLon.setFont(new Font("Arial", Font.PLAIN, 14));
		txtSLNguoiLon.setBounds(141, 140, 240, 23);
		pnNhapThongTinKH.add(txtSLNguoiLon);
		txtSLNguoiLon.setColumns(10);
		
		JLabel lblSLTreEM = new JLabel("SL Trẻ em:");
		lblSLTreEM.setForeground(new Color(148, 0, 211));
		lblSLTreEM.setBounds(10, 174, 102, 33);
		pnNhapThongTinKH.add(lblSLTreEM);
		lblSLTreEM.setFont(new Font("Arial", Font.PLAIN, 18));
		
		txtSlTreEm = new JTextField();
		txtSlTreEm.setBackground(new Color(241, 233, 233));
		txtSlTreEm.setFont(new Font("Arial", Font.PLAIN, 14));
		txtSlTreEm.setBounds(141, 177, 240, 23);
		pnNhapThongTinKH.add(txtSlTreEm);
		txtSlTreEm.setColumns(10);
		
		errNhapThongTin = new JLabel("");
		errNhapThongTin.setBounds(10, 217, 371, 32);
		pnNhapThongTinKH.add(errNhapThongTin);
		errNhapThongTin.setForeground(Color.RED);
		errNhapThongTin.setFont(new Font("Arial", Font.ITALIC, 15));
		
		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setForeground(new Color(148, 0, 211));
		lblGioiTinh.setFont(new Font("Arial", Font.PLAIN, 18));
		lblGioiTinh.setBounds(10, 106, 126, 27);
		pnNhapThongTinKH.add(lblGioiTinh);
		
		JLabel lblSDT = new JLabel("Số điện thoại");
		lblSDT.setForeground(new Color(148, 0, 211));
		lblSDT.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSDT.setBounds(10, 74, 126, 27);
		pnNhapThongTinKH.add(lblSDT);
		
		txtSDT = new JTextField();
		txtSDT.setBackground(new Color(241, 233, 233));
		txtSDT.setFont(new Font("Arial", Font.PLAIN, 14));
		txtSDT.setColumns(10);
		txtSDT.setBounds(141, 75, 240, 23);
		pnNhapThongTinKH.add(txtSDT);
		
		txtGioiTinh = new JTextField();
		txtGioiTinh.setBackground(new Color(241, 233, 233));
		txtGioiTinh.setFont(new Font("Arial", Font.PLAIN, 14));
		txtGioiTinh.setColumns(10);
		txtGioiTinh.setBounds(141, 107, 240, 23);
		pnNhapThongTinKH.add(txtGioiTinh);
		
		// -------------------------------------------
		//JPanel Xac nhan hoac huy thong tin
		btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setHorizontalTextPosition(SwingConstants.LEFT);
		btnXacNhan.setIcon(new ImageIcon("img/icon-xn.png"));
		btnXacNhan.setFont(new Font("Arial", Font.PLAIN, 17));
		btnXacNhan.setBounds(53, 288, 150, 36);
		btnXacNhan.setForeground(new Color(24, 140, 166));
		btnXacNhan.setBackground(new Color(162, 226, 242));
//		btnXacNhan.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon-xn.png"))));
		contentPane.add(btnXacNhan);
		
		btnHuy = new JButton("Huỷ ");
		btnHuy.setHorizontalTextPosition(SwingConstants.LEFT);
		btnHuy.setIcon(new ImageIcon("img/icon-huy.png"));
		btnHuy.setFont(new Font("Arial", Font.PLAIN, 17));
		btnHuy.setBounds(224, 288, 135, 36);
		btnHuy.setForeground(new Color(24, 140, 166));
		btnHuy.setBackground(new Color(162, 226, 242));
//		btnHuy.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon-huy.png"))));
		contentPane.add(btnHuy);
		
		// -------------------------------------------
		//JPanel Loc theo ngay va gia
		JPanel pnLoc = new JPanel();
		pnLoc.setAlignmentX(Component.LEFT_ALIGNMENT);
		pnLoc.setBounds(462, 67, 733, 90);
		contentPane.add(pnLoc);
		pnLoc.setLayout(null);
		
		JLabel lblGia = new JLabel("Giá Tour:");
		lblGia.setForeground(new Color(148, 0, 211));
		lblGia.setBounds(10, 10, 85, 28);
		pnLoc.add(lblGia);
		lblGia.setFont(new Font("Arial", Font.PLAIN, 17));
		
		dfcbboxLocGia = new DefaultComboBoxModel<String>(new String[] {"Từ 1tr-2tr","Từ 2tr-5tr"});
		cbboxGia = new JComboBox(dfcbboxLocGia);
		cbboxGia.setBackground(new Color(241, 233, 233));
		cbboxGia.setSelectedIndex(-1);
		cbboxGia.setBounds(101, 11, 134, 32);
		
		pnLoc.add(cbboxGia);
		cbboxGia.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel lblNgayDi = new JLabel("Ngày đi:");
		lblNgayDi.setForeground(new Color(148, 0, 211));
		lblNgayDi.setBounds(245, 10, 82, 29);
		pnLoc.add(lblNgayDi);
		lblNgayDi.setFont(new Font("Arial", Font.PLAIN, 17));
		
		DefaultComboBoxModel<Integer> dfcbboxNgay = new DefaultComboBoxModel<Integer>(phatSinhNgay());
		cbboxNgay = new JComboBox(dfcbboxNgay);
		cbboxNgay.setBackground(new Color(241, 233, 233));
		cbboxNgay.setSelectedIndex(-1);
		cbboxNgay.setBounds(330, 10, 67, 32);
		pnLoc.add(cbboxNgay);
		
		cbboxThang = new JComboBox(new DefaultComboBoxModel<Integer>(new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12}));
		cbboxThang.setBackground(new Color(241, 233, 233));
		cbboxThang.setBounds(411, 11, 67, 32);
		cbboxThang.setSelectedIndex(-1);
		pnLoc.add(cbboxThang);
		
		DefaultComboBoxModel<Integer> dfcbboxNam = new DefaultComboBoxModel<Integer>(phatSinhNam());
		cbboxNam = new JComboBox(dfcbboxNam);
		cbboxNam.setBackground(new Color(241, 233, 233));
		cbboxNam.setSelectedIndex(-1);
		cbboxNam.setBounds(488, 11, 85, 32);
		pnLoc.add(cbboxNam);
		
		btnLoc = new JButton("Lọc");
		btnLoc.setIcon(new ImageIcon("img/icon-loc.png"));
		btnLoc.setBounds(592, 6, 107, 38);
		btnLoc.setForeground(new Color(24, 140, 166));
		btnLoc.setBackground(new Color(162, 226, 242));
//		btnLoc.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon-loc.png"))));
		pnLoc.add(btnLoc);
		btnLoc.setFont(new Font("Arial", Font.PLAIN, 17));
		
		errLoc = new JLabel("");
		errLoc.setBounds(0, 48, 453, 36);
		pnLoc.add(errLoc);
		errLoc.setFont(new Font("Arial", Font.ITALIC, 18));
		errLoc.setForeground(Color.RED);
		
		// -------------------------------------------
		//JPanel Hien thi thong tin da lua chon va xac nhan thanh toan
		JPanel pnThanhToan = new JPanel();
		pnThanhToan.setBounds(10, 372, 420, 288);
		contentPane.add(pnThanhToan);
		pnThanhToan.setLayout(null);
		
		JLabel lblNgayKhoiHanh = new JLabel("Ngày khởi hành:");
		lblNgayKhoiHanh.setForeground(new Color(148, 0, 211));
		lblNgayKhoiHanh.setIcon(new ImageIcon("img/icon-ngay.png"));
		lblNgayKhoiHanh.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNgayKhoiHanh.setBounds(10, 54, 160, 42);
//		lblNgayKhoiHanh.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon-ngay.png"))));
		pnThanhToan.add(lblNgayKhoiHanh);
		
		JLabel lblThoiGian = new JLabel("Thời Gian:");
		lblThoiGian.setForeground(new Color(148, 0, 211));
		lblThoiGian.setIcon(new ImageIcon("img/icon-thoigian.png"));
		lblThoiGian.setFont(new Font("Arial", Font.PLAIN, 16));
		lblThoiGian.setBounds(10, 95, 124, 34);
//		lblThoiGian.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon-thoigian.png"))));
		pnThanhToan.add(lblThoiGian);
		
		JLabel lblGiaNL = new JLabel("Giá người lớn:");
		lblGiaNL.setForeground(new Color(148, 0, 211));
		lblGiaNL.setIcon(new ImageIcon("img/icon-nguoilon.png"));
		lblGiaNL.setFont(new Font("Arial", Font.PLAIN, 16));
		lblGiaNL.setBounds(10, 135, 141, 34);
//		lblGiaNL.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon-nguoilon.png"))));
		pnThanhToan.add(lblGiaNL);
		
		JLabel lblGiaTE = new JLabel("Giá trẻ em:");
		lblGiaTE.setForeground(new Color(148, 0, 211));
		lblGiaTE.setIcon(new ImageIcon("img/icon-treem.png"));
		lblGiaTE.setFont(new Font("Arial", Font.PLAIN, 16));
		lblGiaTE.setBounds(10, 174, 141, 34);
//		lblGiaTE.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon-treem.png"))));
		pnThanhToan.add(lblGiaTE);
		
		JLabel lblTong = new JLabel("TỔNG");
		lblTong.setForeground(new Color(148, 0, 211));
		lblTong.setIcon(new ImageIcon("img/icon-tong.png"));
		lblTong.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTong.setBounds(10, 210, 113, 34);
//		lblTong.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon-tong.png"))));
		pnThanhToan.add(lblTong);
		
		btnThanhToan = new JButton("Thanh Toán");
		btnThanhToan.setIcon(new ImageIcon("img/icon-tt.png"));
		btnThanhToan.setForeground(new Color(24, 140, 166));
		btnThanhToan.setBackground(new Color(162, 226, 242));
		btnThanhToan.setFont(new Font("Arial", Font.PLAIN, 16));
		btnThanhToan.setBounds(119, 243, 174, 35);
//		btnThanhToan.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon-tt.png"))));
		pnThanhToan.add(btnThanhToan);
		
		lblTTNgay = new JLabel();
		lblTTNgay.setForeground(new Color(148, 0, 211));
		lblTTNgay.setFont(new Font("Arial", Font.ITALIC, 18));
		lblTTNgay.setBounds(180, 54, 230, 33);
		pnThanhToan.add(lblTTNgay);
		
		lblTTThoiGian = new JLabel();
		lblTTThoiGian.setForeground(new Color(148, 0, 211));
		lblTTThoiGian.setFont(new Font("Arial", Font.ITALIC, 18));
		lblTTThoiGian.setBounds(174, 95, 236, 33);
		pnThanhToan.add(lblTTThoiGian);
		
		lblTTGiaNL = new JLabel();
		lblTTGiaNL.setForeground(new Color(148, 0, 211));
		lblTTGiaNL.setFont(new Font("Arial", Font.ITALIC, 18));
		lblTTGiaNL.setBounds(161, 139, 236, 33);
		pnThanhToan.add(lblTTGiaNL);
		
		lblTTTTGiaTE = new JLabel();
		lblTTTTGiaTE.setForeground(new Color(148, 0, 211));
		lblTTTTGiaTE.setFont(new Font("Arial", Font.ITALIC, 18));
		lblTTTTGiaTE.setBounds(161, 175, 236, 33);
		pnThanhToan.add(lblTTTTGiaTE);
		
		lblTTTong = new JLabel();
		lblTTTong.setForeground(new Color(148, 0, 211));
		lblTTTong.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		lblTTTong.setBounds(133, 206, 284, 33);
		pnThanhToan.add(lblTTTong);
		
		lblTenTour = new JLabel("");
		lblTenTour.setForeground(new Color(148, 0, 211));
		lblTenTour.setBounds(28, 10, 316, 34);
		pnThanhToan.add(lblTenTour);
		lblTenTour.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		
		// -------------------------------------------
		//JPanel Mo ta thong tin tour
		JPanel pnMoTa = new JPanel();
		pnMoTa.setBounds(462, 550, 733, 103);
		contentPane.add(pnMoTa);
		pnMoTa.setLayout(null);
		
		tAreaMoTa = new JTextArea();
		tAreaMoTa.setBounds(-193, 0, 727, 103);
		pnMoTa.add(tAreaMoTa);
		tAreaMoTa.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel lblMoTa = new JLabel("Mô tả:");
		lblMoTa.setForeground(new Color(148, 0, 211));
		lblMoTa.setBounds(462, 516, 192, 36);
		contentPane.add(lblMoTa);
		lblMoTa.setFont(new Font("Arial", Font.PLAIN, 17));
		String[] header = "Mã tour;Tên tour;Ngày đi;Địa điểm;Thời gian;Giá người lớn;Giá trẻ em".split(";");
		tableModel = new DefaultTableModel(header,0);
		
		tour_DAO = new Tour_DAO();
		danhSachTour = tour_DAO.getAllTour();
		for(Tour tour : danhSachTour) {
			tableModel.addRow(new Object[] {tour.getMaTour(),tour.getTenTour(),tour.getNgayKhoiHanh(),tour.getDiemDen(),tour.getThoiGian(),
					tour.getGia(),tour.getGiaTreEm()
			});
		}
		
		JPanel pnBang = new JPanel();
		pnBang.setBounds(462, 155, 733, 347);
		contentPane.add(pnBang);
		pnBang.setLayout(null);
		
		// -------------------------------------------
		//JPanel danh sach cac tour
		JLabel lblDanhSach = new JLabel("Danh Sách Tour:");
		lblDanhSach.setForeground(new Color(148, 0, 211));
		lblDanhSach.setBounds(0, 0, 267, 24);
		//lblDanhSach.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon-bang.png"))));
		pnBang.add(lblDanhSach);
		lblDanhSach.setFont(new Font("Arial", Font.PLAIN, 17));
		tableDanhSach = new JScrollPane(table = new JTable(tableModel));
		tableDanhSach.setBounds(0, 30, 716, 317);
		pnBang.add(tableDanhSach);
		
		errThanhToan = new JLabel("");
		errThanhToan.setBounds(10, 326, 349, 36);
		contentPane.add(errThanhToan);
		errThanhToan.setForeground(Color.RED);
		errThanhToan.setFont(new Font("Arial", Font.ITALIC, 18));
		
		iconDatTour = new JLabel("");
		iconDatTour.setFont(new Font("Tahoma", Font.PLAIN, 20));
		iconDatTour.setBounds(637, 10, 78, 47);
//		iconDatTour.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon-dattour.png"))));
		contentPane.add(iconDatTour);

		
		
		// -------------------------------------------
		//Dang ky lang nghe
		btnLoc.addActionListener(this);
		btnXacNhan.addActionListener(this);
		btnHuy.addActionListener(this);
		btnThanhToan.addActionListener(this);
		table.addMouseListener(this);
		txtCMND.addKeyListener(this);
	}

		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			if(o.equals(btnLoc)) {
				if(cbboxGia.getSelectedIndex() == -1 || cbboxNgay.getSelectedIndex() == -1 || cbboxThang.getSelectedIndex() == -1 || cbboxNam.getSelectedIndex() == -1) {
					errLoc.setText("Vui lòng chọn giá và ngày tháng năm");
					return;
				}
				errLoc.setText("");
				locTheoNgayVaGia();
			}
			if(o.equals(btnHuy)) {
				clearTextField();
			}
			if(o.equals(btnXacNhan)) {
				if(validData()) {
					int row = table.getSelectedRow();
					if (row == -1) {
						JOptionPane.showMessageDialog(this, "Chọn Tour");
					}else {
						if (validDataKhachHang()==false) {
							
						KhachHang khachHang = getDataFromTable();
						khachHang_DAO.insert(khachHang);
						
						boolean rs = veDao.insert(getVeFromTable());
						
						if(rs == true) {
							DecimalFormat df = new DecimalFormat("###,###,###");
							errThanhToan.setText("");
							lblTenTour.setText(tableModel.getValueAt(row, 1).toString());
							lblTTNgay.setText(tableModel.getValueAt(row, 2).toString());
							lblTTThoiGian.setText(tableModel.getValueAt(row, 4).toString());
						
							double giaNL = Double.parseDouble( tableModel.getValueAt(row, 5).toString());
							double giaTongNL = giaNL*Integer.parseInt(txtSLNguoiLon.getText());
							lblTTGiaNL.setText(df.format(giaTongNL)+"");
						
							double giaTE = Double.parseDouble(tableModel.getValueAt(row, 6).toString());
							double giaTongTE = giaTE * Integer.parseInt(txtSlTreEm.getText());
							lblTTTTGiaTE.setText(df.format(giaTongTE)+"");
						
							double giaTong = giaTongNL + giaTongTE;
							lblTTTong.setText(df.format(giaTong)+"");
							
							Tour tour = tour_DAO.getTourTheoMa(tableModel.getValueAt(row, 0).toString());
							tAreaMoTa.setText(tour.getMoTa());
							
						}
						errNhapThongTin.setText("Đăng ký thành công");
					}
						else {
							boolean rs = veDao.insert(getVeFromTable());
							
							if(rs == true) {
								DecimalFormat df = new DecimalFormat("###,###,###");
								errThanhToan.setText("");
								lblTenTour.setText(tableModel.getValueAt(row, 1).toString());
								lblTTNgay.setText(tableModel.getValueAt(row, 2).toString());
								lblTTThoiGian.setText(tableModel.getValueAt(row, 4).toString());
							
								double giaNL = Double.parseDouble( tableModel.getValueAt(row, 5).toString());
								double giaTongNL = giaNL*Integer.parseInt(txtSLNguoiLon.getText());
								lblTTGiaNL.setText(df.format(giaTongNL)+"");
							
								double giaTE = Double.parseDouble(tableModel.getValueAt(row, 6).toString());
								double giaTongTE = giaTE * Integer.parseInt(txtSlTreEm.getText());
								lblTTTTGiaTE.setText(df.format(giaTongTE)+"");
							
								double giaTong = giaTongNL + giaTongTE;
								lblTTTong.setText(df.format(giaTong)+"");
								
								Tour tour = tour_DAO.getTourTheoMa(tableModel.getValueAt(row, 0).toString());
								tAreaMoTa.setText(tour.getMoTa());
								
							}
							errNhapThongTin.setText("Đăng ký thành công");
						}
					
					}
				}
			}
			if(o.equals(btnThanhToan)) {
				if(lblTenTour.getText().trim().length() <= 0) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin và chọn loại tour");
				}
				else {
					JOptionPane.showMessageDialog(this, "Thanh toán thành công");
				}
			}
		}
		
		
		private boolean validData() {
			String cmnd = txtCMND.getText().trim();
			String hoTen = txtHoTen.getText().trim();
			String sdt = txtSDT.getText().trim();
			String gioiTinh = txtGioiTinh.getText().trim();
			String slNguoiLon = txtSLNguoiLon.getText().trim();
			String slTreEm = txtSlTreEm.getText().trim();
			
			
			if(!(cmnd.length() > 0 && cmnd.matches("\\d{9}|\\d{12}"))) {
				errNhapThongTin.setText("Chứng minh nhân dân phải 9 hoặc 12 số");
				return false;
			}
//			if(!(hoTen.length() > 0 && hoTen.matches("^[A-Z][a-z]*\\s([A-Z][a-z]*\\s?)+"))) {
//				errNhapThongTin.setText("Chữ cái đầu phải viết hoa và phải có ít nhất 2 từ");
//				return false;
//			}
			if(!(sdt.length() > 0  && sdt.matches("^0\\d{9}"))) {
				errNhapThongTin.setText("Số điện thoại phải 10 số và bắt đầu bằng số 0");
				return false;
			}
			if(!(gioiTinh.length() > 0) && gioiTinh.matches("(Nam)|(Nữ)|(Nu)|(nam)|(nữ)|(nu)")) {
				errNhapThongTin.setText("Vui lòng nhập nam hoặc nữ");
				return false;
			}
			if(!(slNguoiLon.length() > 0 && slNguoiLon.matches("\\d*"))) {
				errNhapThongTin.setText("Số lượng phải nhập số");
				return false;
			}
			if(!(slTreEm.length() > 0 && slTreEm.matches("\\d*"))) {
				errNhapThongTin.setText("Số lượng phải nhập số");
				return false;
			}
			
			return true;
		}

		private void clearTextField() {
			txtCMND.setText("");
			txtHoTen.setText("");
			txtSDT.setText("");
			txtGioiTinh.setText("");
			txtSLNguoiLon.setText("");
			txtSlTreEm.setText("");
			errNhapThongTin.setText("");
			txtCMND.requestFocus();
		}

		private Integer[] phatSinhNgay() {
			int i = 0;  
			Integer[] ngay = new Integer[31];
			while(i<31) {
				ngay[i] = ++i;
			} return ngay;
		}
		private Integer[] phatSinhNam() {
			Calendar cld = Calendar.getInstance();
			int namHienTai = cld.get(Calendar.YEAR);
			int i = 0;
			Integer[] nam = new Integer[5];
			while(i<5) {
				nam[i++] = namHienTai++;
			}
			return nam;
		}
		private void locTheoNgayVaGia() {
			//Lay gia tour
			String giaTour = (cbboxGia.getSelectedItem()+"").replace("tr", "000000");
			String giaTourFirst = giaTour.substring(3,10);
			String giaTourLast = giaTour.substring(11,18);
			
			//Lay Ngay thang nam
			String date = cbboxNam.getSelectedItem()+"-"+cbboxThang.getSelectedItem()+"-"+cbboxNgay.getSelectedItem();
			danhSachTour = tour_DAO.getTourTheoDieuKien(giaTourFirst, giaTourLast, date);
			tableModel.getDataVector().removeAllElements();
			for(Tour tour : danhSachTour) {
				tableModel.addRow(new Object[] {tour.getMaTour(),tour.getTenTour(),tour.getNgayKhoiHanh(),tour.getDiemDen(),tour.getThoiGian(),
						tour.getGia(),tour.getGiaTreEm()
				});
			}
		}
		private boolean kiemTraRong() {
			String cmnd = txtCMND.getText().trim();
			String hoTen = txtHoTen.getText().trim();
			String sdt = txtSDT.getText().trim();
			String gioitinh = txtGioiTinh.getText().trim();
			String slNL = txtSLNguoiLon.getText().trim();
			String slTE = txtSlTreEm.getText().trim();
			if(cmnd.length() <= 0 || hoTen.length() <= 0 || sdt.length() <= 0 || gioitinh.length() <= 0 || slNL.length() <= 0 || slTE.length() <= 0)
				return false;
			return true;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			int row = table.getSelectedRow();
			if(!kiemTraRong()) {
				errThanhToan.setText("Bạn chưa nhập thông tin");
			} else {
//				errThanhToan.setText("");
//				lblTenTour.setText(tableModel.getValueAt(row, 1).toString());
//				lblTTNgay.setText(tableModel.getValueAt(row, 2).toString());
//				lblTTThoiGian.setText(tableModel.getValueAt(row, 4).toString());
//			
//				double giaNL = Double.parseDouble( tableModel.getValueAt(row, 5).toString());
//				double giaTongNL = giaNL*Integer.parseInt(txtSLNguoiLon.getText());
//				lblTTGiaNL.setText(giaTongNL+"");
//			
//				double giaTE = Double.parseDouble(tableModel.getValueAt(row, 6).toString());
//				double giaTongTE = giaTE * Integer.parseInt(txtSlTreEm.getText());
//				lblTTTTGiaTE.setText(giaTongTE+"");
//			
//				double giaTong = giaTongNL + giaTongTE;
//				lblTTTong.setText(giaTong+"");
//				
//				Tour tour = tour_DAO.getTourTheoMa(tableModel.getValueAt(row, 0).toString());
//				tAreaMoTa.setText(tour.getMoTa());
			}
			
		}
		
		public Ve getVeFromTable() {
		int row = table.getSelectedRow();
		int maTour = Integer.parseInt(tableModel.getValueAt(row, 0).toString());
		int slNguoiLon = Integer.parseInt( txtSLNguoiLon.getText());
		int slTreEm = Integer.parseInt(txtSlTreEm.getText());
		Tour tour = new Tour(maTour);
		NhanVien nVien = new NhanVien(ShareData.taiKhoan.getTenDN());
		KhachHang kh = null;
		dsKH = khachHang_DAO.getALLKhachHang();
		for (KhachHang khachHang : dsKH) {
			if (txtCMND.getText().contains(khachHang.getCmnd())) {
				kh=khachHang;
			}
		}
		Ve ve = new Ve(0, slNguoiLon, slTreEm, 0, tour, kh, nVien);

		return ve;

		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			Object o = e.getSource();
			if(o.equals(txtCMND)) {
				
			if(e.getKeyCode()==KeyEvent.VK_ENTER) {
				int count = 0;
				String cmnd = txtCMND.getText().trim();
				ArrayList<KhachHang > khachHangs = khachHang_DAO.getALLKhachHang();
				for(KhachHang kh :khachHangs) {
					if(cmnd.contains(kh.getCmnd())) {
						khachHang =kh;
						txtHoTen.setText(kh.getTenKH());
						txtSDT.setText(kh.getSdt());
						txtGioiTinh.setText(kh.getGioiTinh());
						count++;
					}
				}
				
				if(count<=0) {
					txtHoTen.setText("");
					txtGioiTinh.setText("");
					txtSDT.setText("");
					txtHoTen.requestFocus();
					
				}
			}
			
		}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		private boolean validDataKhachHang() {
			dsKH = khachHang_DAO.getALLKhachHang();
			if (dsKH == null || dsKH.size() <= 0)
				return false;
			String tenKH = txtCMND.getText();
			String cmnd = txtCMND.getText();
			String  ten = txtHoTen.getText();
			for (KhachHang kh : dsKH) {
				if (ten.contains(kh.getTenKH())&& cmnd.contains(kh.getCmnd())) {
					return true;
				}
			}

			return false;
		}
		
		public KhachHang getDataFromTable() {
			KhachHang kh = new KhachHang(txtHoTen.getText(), txtSDT.getText(), txtGioiTinh.getText(), txtCMND.getText());
			
			return kh;
		}

}

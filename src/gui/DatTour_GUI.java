package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.Tour_DAO;
import entity.Tour;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class DatTour_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtHoTen;
	private JTextField txtCMND;
	private JTextField txtSLNguoiLon;
	private JTextField txtSlTreEm;
	private DefaultTableModel tableModel;
	private JTable table;
	private Tour_DAO tour_DAO;
	private ArrayList<Tour> danhSachTour;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DatTour_GUI frame = new DatTour_GUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
	public DatTour_GUI() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1060, 780);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đặt Tour");
		lblNewLabel.setBounds(447, 21, 143, 36);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		contentPane.add(lblNewLabel);
		
		JPanel pnNhapThongTinKH = new JPanel();
		pnNhapThongTinKH.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnNhapThongTinKH.setBounds(10, 57, 370, 206);
		contentPane.add(pnNhapThongTinKH);
		pnNhapThongTinKH.setLayout(null);
		
		JLabel lblCMND = new JLabel("CMND: ");
		lblCMND.setBounds(10, 13, 71, 24);
		pnNhapThongTinKH.add(lblCMND);
		lblCMND.setFont(new Font("Arial", Font.PLAIN, 20));
		
		txtCMND = new JTextField();
		txtCMND.setBounds(141, 10, 218, 27);
		pnNhapThongTinKH.add(txtCMND);
		txtCMND.setColumns(10);
		
		JLabel lblHoTen = new JLabel("Họ và tên: ");
		lblHoTen.setBounds(10, 66, 126, 27);
		pnNhapThongTinKH.add(lblHoTen);
		lblHoTen.setFont(new Font("Arial", Font.PLAIN, 20));
		
		txtHoTen = new JTextField();
		txtHoTen.setBounds(141, 63, 218, 27);
		pnNhapThongTinKH.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		JLabel lblSLNguoiLon = new JLabel("SL người lớn:");
		lblSLNguoiLon.setBounds(10, 115, 137, 32);
		pnNhapThongTinKH.add(lblSLNguoiLon);
		lblSLNguoiLon.setFont(new Font("Arial", Font.PLAIN, 20));
		
		txtSLNguoiLon = new JTextField();
		txtSLNguoiLon.setBounds(141, 118, 218, 27);
		pnNhapThongTinKH.add(txtSLNguoiLon);
		txtSLNguoiLon.setColumns(10);
		
		JLabel lblSLTreEM = new JLabel("SL Trẻ em:");
		lblSLTreEM.setBounds(10, 165, 102, 33);
		pnNhapThongTinKH.add(lblSLTreEM);
		lblSLTreEM.setFont(new Font("Arial", Font.PLAIN, 20));
		
		txtSlTreEm = new JTextField();
		txtSlTreEm.setBounds(141, 169, 218, 27);
		pnNhapThongTinKH.add(txtSlTreEm);
		txtSlTreEm.setColumns(10);
		
		JButton btnXacNhan = new JButton("Xác nhận");
//		btnXacNhan.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		btnXacNhan.setFont(new Font("Arial", Font.PLAIN, 20));
		btnXacNhan.setBounds(49, 291, 128, 36);
		contentPane.add(btnXacNhan);
		
		JButton btnHuy = new JButton("Huỷ");
		btnHuy.setFont(new Font("Arial", Font.PLAIN, 20));
		btnHuy.setBounds(219, 291, 128, 36);
		contentPane.add(btnHuy);
		
		JPanel pnLoc = new JPanel();
		pnLoc.setBounds(404, 70, 578, 49);
		contentPane.add(pnLoc);
		pnLoc.setLayout(null);
		
		JLabel lblGia = new JLabel("Giá Tour:");
		lblGia.setBounds(10, 10, 85, 28);
		pnLoc.add(lblGia);
		lblGia.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(101, 11, 119, 28);
		pnLoc.add(spinner);
		spinner.setModel(new SpinnerNumberModel(new Double(0), null, null, new Double(1)));
		spinner.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel lblNgayDi = new JLabel("Ngày đi:");
		lblNgayDi.setBounds(245, 10, 82, 29);
		pnLoc.add(lblNgayDi);
		lblNgayDi.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(337, 11, 119, 28);
		pnLoc.add(spinner_1);
		spinner_1.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JButton btnLoc = new JButton("Lọc");
		btnLoc.setBounds(481, 5, 70, 38);
		pnLoc.add(btnLoc);
		btnLoc.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel lblDanhSach = new JLabel("Danh Sách Tour:");
		lblDanhSach.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDanhSach.setBounds(452, 134, 159, 32);
		contentPane.add(lblDanhSach);
		
		JPanel pnXacNhan = new JPanel();
		pnXacNhan.setBounds(22, 370, 370, 363);
		contentPane.add(pnXacNhan);
		pnXacNhan.setLayout(null);
		
		JLabel lblTenTour = new JLabel("");
		lblTenTour.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTenTour.setBounds(32, 10, 304, 34);
		pnXacNhan.add(lblTenTour);
		
		JLabel lblNgayKhoiHanh = new JLabel("Ngày khởi hành:");
		lblNgayKhoiHanh.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNgayKhoiHanh.setBounds(10, 73, 113, 42);
		pnXacNhan.add(lblNgayKhoiHanh);
		
		JLabel lblThoiGian = new JLabel("Thời Gian:");
		lblThoiGian.setFont(new Font("Arial", Font.PLAIN, 16));
		lblThoiGian.setBounds(10, 125, 113, 34);
		pnXacNhan.add(lblThoiGian);
		
		JLabel lblGiaNL = new JLabel("Giá người lớn:");
		lblGiaNL.setFont(new Font("Arial", Font.PLAIN, 16));
		lblGiaNL.setBounds(10, 175, 113, 34);
		pnXacNhan.add(lblGiaNL);
		
		JLabel lblGiaTE = new JLabel("Giá trẻ em:");
		lblGiaTE.setFont(new Font("Arial", Font.PLAIN, 16));
		lblGiaTE.setBounds(10, 224, 113, 34);
		pnXacNhan.add(lblGiaTE);
		
		JLabel lblTong = new JLabel("Tổng:");
		lblTong.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTong.setBounds(10, 274, 113, 34);
		pnXacNhan.add(lblTong);
		
		JButton btnThanhToan = new JButton("Thanh Toán");
		btnThanhToan.setFont(new Font("Arial", Font.PLAIN, 16));
		btnThanhToan.setBounds(90, 318, 174, 35);
		pnXacNhan.add(btnThanhToan);
		
		JPanel pnMoTa = new JPanel();
		pnMoTa.setBounds(413, 550, 569, 168);
		contentPane.add(pnMoTa);
		pnMoTa.setLayout(null);
		
		JTextArea tAreaMoTa = new JTextArea();
		tAreaMoTa.setBounds(0, 0, 569, 168);
		pnMoTa.add(tAreaMoTa);
		tAreaMoTa.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 0, 45, 13);
		pnMoTa.add(lblNewLabel_1);
		
		JLabel lblMoTa = new JLabel("Mô tả:");
		lblMoTa.setBounds(452, 504, 109, 36);
		contentPane.add(lblMoTa);
		lblMoTa.setFont(new Font("Arial", Font.PLAIN, 20));
		
		
		String[] header = "Mã tour;Tên tour;Ngày đi;Địa điểm;Thời gian;Giá người lớn;Giá trẻ em".split(";");
		tableModel = new DefaultTableModel(header,0);
		
		tour_DAO = new Tour_DAO();
		danhSachTour = tour_DAO.getAllTour();
		for(Tour tour : danhSachTour) {
			tableModel.addRow(new Object[] {tour.getMaTour(),tour.getTenTour(),tour.getNgayKhoiHanh(),tour.getDiemDen(),tour.getThoiGian(),
					tour.getGia(),tour.getGiaTreEm()
			});
		}
		JScrollPane tableDanhSach = new JScrollPane(table = new JTable(tableModel));
		tableDanhSach.setBounds(413, 186, 567, 293);
		contentPane.add(tableDanhSach);
		
		
	}
	
	public static void main(String[] args) {
		new DatTour_GUI().setVisible(true);
	}
}

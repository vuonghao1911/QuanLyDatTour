package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.Tour_DAO;
import entity.Tour;



public class GDQuanLyTour extends JFrame implements ActionListener, MouseListener{
		
	 	private static final long serialVersionUID = 1L;
		
		private JTable tableTour;
		private DefaultTableModel modelTour;
		
		private JLabel lblTieuDe;
		private JTextField txtMaTour;
		private JTextField txtThoiGian;
		private JTextField txtTenTour;
		private JTextField txtNKH;
		private JTextField txtDiemDen;
		private JTextField txtDiemDi;
		private JTextField txtGia;
		private JTextField txtGiaTE;
		private JTextField txtMoTa;
		private JTextField txtTim;
		private JTextField txtSoLuong;
		private JButton bttTimKiem;
		private JButton bttThem;	
		private JButton bttCapNhat;
		private JButton bttXoa;
		
		
		
			
	
		public GDQuanLyTour() {
			
			setTitle("QUANLYTOUR");
			setSize(1250, 700);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
//			setResizable(false);
				
			JPanel pnQLTour = new JPanel();
			pnQLTour.setLayout(new BoxLayout(pnQLTour, BoxLayout.Y_AXIS));
			
			JPanel pnTieuDe = new JPanel();
			pnTieuDe.setLayout(new FlowLayout());
			lblTieuDe = new JLabel("QUAN LY DU LICH - LU HANH");
			lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
			lblTieuDe.setForeground(Color.blue);
			pnTieuDe.add(lblTieuDe);
			pnQLTour.add(pnTieuDe);
			
			
			JPanel pnThongTin = new JPanel();
			pnThongTin.setLayout(new GridLayout(1, 2));

//			Bên trái		
			JPanel p1 = new JPanel();
			p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
			
			JPanel p11 = new JPanel();
	        JLabel lblMa = new JLabel("Mã tour: ");
	        txtMaTour = new JTextField(30);
	        p11.add(lblMa);
	        p11.add(txtMaTour);
	        p1.add(p11);
	        
	        JPanel p12 = new JPanel();
	        JLabel lblTen = new JLabel("Tên tour: ");
	        txtTenTour = new JTextField(30);
	        p12.add(lblTen);
	        p12.add(txtTenTour);
	        p1.add(p12);
	        
	        JPanel p13 = new JPanel();
	        JLabel lblDiemDen = new JLabel("Điểm đến: ");
	        txtDiemDen = new JTextField(30);
	        p13.add(lblDiemDen);
	        p13.add(txtDiemDen);
	        p1.add(p13);
	        
	        JPanel p14 = new JPanel();
	        JLabel lblDiemDi = new JLabel("Điểm xuất phát: ");
	        txtDiemDi = new JTextField(30);
	        p14.add(lblDiemDi);
	        p14.add(txtDiemDi);
	        p1.add(p14);
	        
	        JPanel p15 = new JPanel();
	        JLabel lblMoTa = new JLabel("Mô tả: ");
	        txtMoTa = new JTextField(30);
	        p15.add(lblMoTa);
	        p15.add(txtMoTa);
	        p1.add(p15);
	        
			pnThongTin.add(p1);
			
//			Bên phải 
			JPanel p2 = new JPanel();
			p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
			
			JPanel p21 = new JPanel();
	        JLabel lblThoiGian = new JLabel("Thời gian: ");
	        txtThoiGian = new JTextField(30);
	        p21.add(lblThoiGian);
	        p21.add(txtThoiGian);
	        p2.add(p21);
	        
	        JPanel p22 = new JPanel();
	        JLabel lblNKH = new JLabel("Ngày khởi hành: ");
	        txtNKH = new JTextField(30);
	        p22.add(lblNKH);
	        p22.add(txtNKH);
	        p2.add(p22);
	        
	        JPanel p23 = new JPanel();
	        JLabel lblGia = new JLabel("Giá: ");
	        txtGia = new JTextField(30);
	        p23.add(lblGia);
	        p23.add(txtGia);
	        p2.add(p23);
	        
	        JPanel p24 = new JPanel();
	        JLabel lblGiaTE = new JLabel("Giá trẻ em: ");
	        txtGiaTE = new JTextField(30);
	        p24.add(lblGiaTE);
	        p24.add(txtGiaTE);
	        p2.add(p24);
	        
	        JPanel p25 = new JPanel();
	        JLabel lblSoLuong = new JLabel("Số lượng: ");
	        txtSoLuong = new JTextField(30);
	        p25.add(lblSoLuong);
	        p25.add(txtSoLuong);
	        p2.add(p25);
	        
			pnThongTin.add(p2);
			
			lblMa.setPreferredSize(lblNKH.getPreferredSize());
			lblDiemDen.setPreferredSize(lblNKH.getPreferredSize());
			lblMoTa.setPreferredSize(lblNKH.getPreferredSize());
			lblTen.setPreferredSize(lblNKH.getPreferredSize());
			lblSoLuong.setPreferredSize(lblNKH.getPreferredSize());
			lblThoiGian.setPreferredSize(lblNKH.getPreferredSize());
			lblGia.setPreferredSize(lblNKH.getPreferredSize());
			lblGiaTE.setPreferredSize(lblNKH.getPreferredSize());
			
			
			Border boderThongTin = BorderFactory.createLineBorder(Color.BLUE);
			TitledBorder titleThongTin = new TitledBorder(boderThongTin, " THÔNG TIN TOUR ");
			titleThongTin.setTitleJustification(TitledBorder.LEFT);
			titleThongTin.setTitleColor(Color.RED);
			pnThongTin.setBorder(titleThongTin);
			
			pnQLTour.add(pnThongTin);		        		      
			pnQLTour.add(Box.createVerticalStrut(15));
			
//			Chức năng
			JPanel	pnCN  = new JPanel();
			pnCN.setLayout(new FlowLayout());
			
			JTextField txtTim = new JTextField(20);
	        bttTimKiem = new JButton("Tìm kiếm");
	        bttCapNhat = new JButton("Cập nhật");
	        bttThem = new JButton("Thêm");
	        bttXoa = new JButton("Xóa");
	     
			
	        bttXoa.setBackground(Color.RED);
	        
	        
	        bttTimKiem.setPreferredSize(bttCapNhat.getPreferredSize());
	        bttThem.setPreferredSize(bttCapNhat.getPreferredSize());
	        bttXoa.setPreferredSize(bttCapNhat.getPreferredSize());
	        

	        pnCN.add(txtTim);
	        pnCN.add(Box.createHorizontalStrut(10));
	        pnCN.add(bttTimKiem);
	        pnCN.add(Box.createHorizontalStrut(10));
	        pnCN.add(bttThem);
	        pnCN.add(Box.createHorizontalStrut(10));
	        pnCN.add(bttCapNhat);
	        pnCN.add(Box.createHorizontalStrut(10));
	        pnCN.add(bttXoa);
	        
	        Border boderCN = BorderFactory.createLineBorder(Color.BLUE);
			TitledBorder titleCN = new TitledBorder(boderCN, " CHỨC NĂNG ");
			titleCN.setTitleJustification(TitledBorder.LEFT);
			titleCN.setTitleColor(Color.RED);
			pnCN.setBorder(titleCN);
	        
			pnQLTour.add(pnCN);
			pnQLTour.add(Box.createVerticalStrut(15));
	
//			bảng
			JPanel pnBang = new JPanel();
			pnBang.setLayout(new BorderLayout());
			String[] colHeader = { "Mã Tour", "Tên Tour", "Điểm xuất phát", "Điểm đến", "Thời gian", "Ngày khởi hành", "Mô tả", "Giá", "Giá trẻ em", "Số lượng" };
			modelTour = new DefaultTableModel(colHeader, 0);
			tableTour = new JTable(modelTour);
			pnBang.add(new JScrollPane(tableTour), BorderLayout.CENTER);
			Border boderDanhSach = BorderFactory.createLineBorder(Color.BLUE);
			TitledBorder titleDanhSach = new TitledBorder(boderDanhSach, " DANH SÁCH ");
			titleDanhSach.setTitleJustification(TitledBorder.CENTER);
			titleDanhSach.setTitleColor(Color.RED);
			pnBang.setBorder(titleDanhSach);
			pnQLTour.add(pnBang);

			add(pnQLTour);

//			khởi tạo đối tượng kết nối xuống database
			try {
				ConnectDB.getInstance().connect();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			bttTimKiem.addActionListener(this);
			bttThem.addActionListener(this);
			bttCapNhat.addActionListener(this);
			bttXoa.addActionListener(this);
			
		}
		
		public static void main(String[] args) {
			new GDQuanLyTour().setVisible(true);
		}
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object object = e.getSource();
			Tour_DAO tourDAO = new Tour_DAO();
			List<Tour> dstour = tourDAO.getAllTour();
			if (object.equals(bttTimKiem)) {
				Tour tour = tourDAO.findByID(txtTim.getText());
				if (txtTim.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng điền mã tour để tìm kiếm!");
				} else if (tourDAO.findByID(bttTimKiem.getText()) == null) {
					JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin về tour !");
				} else {
					modelTour.getDataVector().removeAllElements();

					modelTour.addRow(new Object[] { String( tour.getMaTour(), tour.getTenTour(), tour.getDiemDen(), tour.getDiemXuatPhat(),
							tour.getThoiGian(), tour.getMoTa(), tour.getNgayKhoiHanh(), tour.getGia(), tour.getGiaTreEm(), tour.getSoLuong())});

					modelTour.addRow(new Object[] {  tour.getMaTour(), tour.getTenTour(), tour.getDiemDen(), tour.getDiemXuatPhat(),
							tour.getThoiGian(), tour.getMoTa(), tour.getNgayKhoiHanh(), tour.getGia(), tour.getGiaTreEm(), tour.getSoLuong()});

				}
			} else if (object.equals(bttThem)) { 
				int maTour = Integer.parseInt(txtMaTour.getText().trim());
				String tenTour = txtTenTour.getText().trim();
				String diemDi = txtDiemDi.getText().trim();
				String diemDen = txtDiemDen.getText().trim();
				String thoiGian = txtThoiGian.getText().trim();
				String moTa = txtMoTa.getText().trim();
				String ngaykhoihanh = txtNKH.getText().trim();
				Double gia = Double.parseDouble(txtGia.getText().trim());
				Double giaTE = Double.parseDouble(txtGiaTE.getText().trim());
				int soLuong = Integer.parseInt(txtSoLuong.getText().trim());
				
				Tour tour = new Tour(maTour, tenTour, diemDen, diemDi, thoiGian, null, moTa, gia, giaTE, soLuong);	
					try {
						tourDAO.them(tour);
						modelTour.addRow(new Object[] { maTour, tenTour, diemDen, diemDi, thoiGian, null, moTa, gia, giaTE, soLuong});
						JOptionPane.showMessageDialog(null, "Thêm Tour Thành Công!");
					} catch (SQLException e1) 

					{
						JOptionPane.showMessageDialog(null, "Có Lỗi Xảy Ra, Vui Lòng Thử Lại Sau!");
					}
					xoaTrang();
				}	
		
			else if (object.equals(bttXoa)) {
				if (tableTour.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Chọn Một Tour Trước Khi Xóa");
				} else {
					try {
						tourDAO.xoa(txtMaTour.getText());

						int currentPostition = 0;
						modelTour.removeRow(currentPostition);				
						JOptionPane.showMessageDialog(null, "Xóa Thành Công!");
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Có Lỗi Xảy Ra, Vui Lòng Thử Lại Sau!");
					}
					xoaTrang();
				}
			}
		}
		
		
		private Object String(int maTour, java.lang.String tenTour, java.lang.String diemDen,
				java.lang.String diemXuatPhat, java.lang.String thoiGian, java.lang.String moTa, Date ngayKhoiHanh,
				Double gia, Double giaTreEm, int soLuong) {
			// TODO Auto-generated method stub
			return null;
		}
		private int String(String text, String text2, String text3, String text4, String text5, String text6,
				String text7, String text8, String text9, String text10) {
			// TODO Auto-generated method stub
			return 0;
		}
		

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
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

		private void xoaTrang(){
			txtMaTour.setText("");
			txtTenTour.setText("");
			txtDiemDen.setText("");
			txtDiemDi.setText("");
			txtMoTa.setText("");
			txtNKH.setText("");
			txtThoiGian.setText("");
			txtGia.setText("");
			txtGiaTE.setText("");
			txtSoLuong.setText("");
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int currentPostition = tableTour.getSelectedRow();
			txtMaTour.setText(String.valueOf(tableTour.getValueAt(currentPostition, 1)));
			txtTenTour.setText(String.valueOf(tableTour.getValueAt(currentPostition, 2)));
			txtDiemDen.setText(String.valueOf(tableTour.getValueAt(currentPostition, 3)));
			txtDiemDi.setText(String.valueOf(tableTour.getValueAt(currentPostition, 4)));
			txtThoiGian.setText(String.valueOf(tableTour.getValueAt(currentPostition, 5)));
			txtNKH.setText(String.valueOf(tableTour.getValueAt(currentPostition, 6)));
			txtMoTa.setText(String.valueOf(tableTour.getValueAt(currentPostition, 7)));
			txtGia.setText(String.valueOf(tableTour.getValueAt(currentPostition, 8)));
			txtGiaTE.setText(String.valueOf(tableTour.getValueAt(currentPostition, 9)));
			txtSoLuong.setText(String.valueOf(tableTour.getValueAt(currentPostition, 10)));
			
		}
		
//		private boolean isValidField() {
//			try {
//				Integer.parseInt(txtMaTour.getText());
//			} catch (Exception e) {
//				JOptionPane.showMessageDialog(null, "Mã Tour Là Bắt Buộc Và Chỉ Chứa Các Số Nguyên!");
//				return false;
//			}
//
//			if (!txtTenTour.getText()
//					.matches("^(?:[\\p{L}\\p{Mn}\\p{Pd}\\'\\x{2019}]+\\s[\\p{L}\\p{Mn}\\p{Pd}\\'\\x{2019}]+\\s?)+$")) {
//				JOptionPane.showMessageDialog(null, "Tên T Là Bắt Buộc Chỉ Chứa Chữ Cái Và Dấu Cách!");
//				return false;
//			}
//		if (!txtNKH.getText()
//				.matches("^[0-9]{8} + []")) {
//			JOptionPane.showMessageDialog(null, "Tên T Là Bắt Buộc Chỉ Chứa Chữ Cái Và Dấu Cách!");
//			return false;
//		}
//
//			return true;
//		}

	}



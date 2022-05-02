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

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;



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
		private JTextField txtGia;
		private JTextField txtGiaTE;
		private JTextField txtMoTa;
		private JTextField txtLoc;
		private JTextField txtSoLuong;
		
		private JButton bttTimKiem;
		private JButton bttThem;
		private JButton bttHTDS;	
		private JButton bttCapNhat;
		private JButton bttLuu;
		private JButton bttXoa;
		
		
		
		
		public GDQuanLyTour() {
			
			setTitle("QUANLYTOUR");
			setSize(1000, 600);
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
	        JLabel lblMoTa = new JLabel("Mô tả: ");
	        txtMoTa = new JTextField(30);
	        p14.add(lblMoTa);
	        p14.add(txtMoTa);
	        p1.add(p14);
	        
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
	        txtGia = new JTextField(13);
	        p23.add(lblGia);
	        p23.add(txtGia);
	        p23.add(Box.createHorizontalStrut(10));
	        JLabel lblGiaTE = new JLabel("Giá trẻ em: ");
	        txtGiaTE = new JTextField(14);
	        p23.add(lblGiaTE);
	        p23.add(txtGiaTE);
	   
	        p2.add(p23);
	        
	        JPanel p24 = new JPanel();
	        JLabel lblSoLuong = new JLabel("Số lượng: ");
	        txtSoLuong = new JTextField(30);
	        p24.add(lblSoLuong);
	        p24.add(txtSoLuong);
	        p2.add(p24);
	        
			pnThongTin.add(p2);
			
			lblMa.setPreferredSize(lblNKH.getPreferredSize());
			lblDiemDen.setPreferredSize(lblNKH.getPreferredSize());
			lblMoTa.setPreferredSize(lblNKH.getPreferredSize());
			lblTen.setPreferredSize(lblNKH.getPreferredSize());
			lblSoLuong.setPreferredSize(lblNKH.getPreferredSize());
			lblThoiGian.setPreferredSize(lblNKH.getPreferredSize());
			
			
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
			
			JTextField lblTim = new JTextField(20);
	        bttTimKiem = new JButton("Tìm kiếm");
	        bttCapNhat = new JButton("Cập nhật");
	        bttThem = new JButton("Thêm");
	        bttHTDS = new JButton("Hiển thị DS");
	        bttXoa = new JButton("Xóa");
	        bttLuu = new JButton("Lưu");
			
	        bttXoa.setBackground(Color.RED);
	        
	        
	        bttTimKiem.setPreferredSize(bttHTDS.getPreferredSize());
	        bttLuu.setPreferredSize(bttHTDS.getPreferredSize());
	        bttThem.setPreferredSize(bttHTDS.getPreferredSize());
	        bttCapNhat.setPreferredSize(bttHTDS.getPreferredSize());
	        bttXoa.setPreferredSize(bttHTDS.getPreferredSize());
	        

	        pnCN.add(lblTim);
	        pnCN.add(Box.createHorizontalStrut(10));
	        pnCN.add(bttTimKiem);
	        pnCN.add(Box.createHorizontalStrut(10));
	        pnCN.add(bttHTDS);
	        pnCN.add(Box.createHorizontalStrut(10));
	        pnCN.add(bttThem);
	        pnCN.add(Box.createHorizontalStrut(10));
	        pnCN.add(bttLuu);
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
			String[] colHeader = { "Mã Tour", "Tên Tour", "Điểm đến", "Thời gian", "Ngày khởi hành", "Mô tả", "Giá", "Giá trẻ em", "Số lượng" };
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
			
			
		}
		
		public static void main(String[] args) {
			new GDQuanLyTour().setVisible(true);
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			
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

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}

	}



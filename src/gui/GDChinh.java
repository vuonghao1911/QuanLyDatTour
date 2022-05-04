package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;

import dao.NhanVien_DAO;
import entity.NhanVien;

import shareData.ShareData;

import javax.swing.JLabel;


import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.border.LineBorder;

public class GDChinh extends JFrame implements MouseListener {

	private JPanel contentPane;
	private JLabel lblGio;
	private JLabel lblNgay;
	private JLabel lblNhanVien;
	private JPanel panel;
	private JPanel pnDatTour;
	private JPanel pnNhanVien;
	private JPanel pnKH;
	private JPanel pnTour;
	private JPanel pnTK;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDChinh frame = new GDChinh();
					frame.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GDChinh() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/Group.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 850);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		FlatCyanLightIJTheme.setup();
		contentPane.setLayout(null);
		//JPanel pnKhachHang = new GDQuanLyTour();
		
		JLabel lblNewLabel = new JLabel("Công Ty Du Lịch 17");
		lblNewLabel.setForeground(new Color(147, 112, 219));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel.setBounds(20, 10, 218, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblaCh = new JLabel("Địa Chỉ : 213 Nguyễn Du , Quận 1, TPHCM");
		lblaCh.setForeground(new Color(147, 112, 219));
		lblaCh.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblaCh.setBounds(20, 43, 324, 40);
		contentPane.add(lblaCh);
		
		lblNgay = new JLabel("12/2");
		lblNgay.setForeground(new Color(123, 104, 238));
		lblNgay.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNgay.setBounds(574, 10, 147, 34);
		contentPane.add(lblNgay);
		
		lblNhanVien = new JLabel("Nhân Viên : Tiến Đạt");
		lblNhanVien.setForeground(new Color(178, 34, 34));
		lblNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNhanVien.setBounds(1071, 60, 205, 34);
		contentPane.add(lblNhanVien);
		
		lblGio = new JLabel("12/2");
		lblGio.setForeground(new Color(123, 104, 238));
		lblGio.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblGio.setBounds(584, 49, 147, 34);
		contentPane.add(lblGio);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("img/employee-infographic.png"));
		lblNewLabel_2.setBounds(993, 30, 88, 76);
		contentPane.add(lblNewLabel_2);
		
		panel = new JPanel();
		panel.setBounds(10, 153, 1250, 660);
		contentPane.add(panel);
		
		pnDatTour = new JPanel();
		pnDatTour.setBorder(new LineBorder(new Color(72, 209, 204), 2));
		pnDatTour.setBackground(new Color(147, 112, 219));
		pnDatTour.setBounds(20, 93, 171, 50);
		contentPane.add(pnDatTour);
		pnDatTour.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(21, 11, 32, 32);
		pnDatTour.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("img/calendar.png"));
		
		JLabel lblNewLabel_3 = new JLabel("Đặt Tour");
		lblNewLabel_3.setBounds(74, 11, 75, 31);
		pnDatTour.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setForeground(new Color(75, 0, 130));
		
		pnNhanVien = new JPanel();
		pnNhanVien.setLayout(null);
		pnNhanVien.setBorder(new LineBorder(new Color(72, 209, 204), 2));
		pnNhanVien.setBackground(new Color(64, 224, 208));
		pnNhanVien.setBounds(192, 93, 181, 50);
		contentPane.add(pnNhanVien);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("img/employee.png"));
		lblNewLabel_1_1.setBounds(10, 10, 32, 32);
		pnNhanVien.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("QL Nhân Viên");
		lblNewLabel_3_1.setForeground(new Color(75, 0, 130));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(73, 10, 98, 32);
		pnNhanVien.add(lblNewLabel_3_1);
		
		pnKH = new JPanel();
		pnKH.setLayout(null);
		pnKH.setBorder(new LineBorder(new Color(72, 209, 204), 2));
		pnKH.setBackground(new Color(64, 224, 208));
		pnKH.setBounds(374, 93, 181, 50);
		contentPane.add(pnKH);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon("img/customer-review.png"));
		lblNewLabel_1_1_1.setBounds(10, 10, 32, 32);
		pnKH.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("QL Khách Hàng");
		lblNewLabel_3_1_1.setForeground(new Color(75, 0, 130));
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_1.setBounds(67, 10, 104, 30);
		pnKH.add(lblNewLabel_3_1_1);
		
		pnTour = new JPanel();
		pnTour.setLayout(null);
		pnTour.setBorder(new LineBorder(new Color(72, 209, 204), 2));
		pnTour.setBackground(new Color(64, 224, 208));
		pnTour.setBounds(556, 93, 181, 50);
		contentPane.add(pnTour);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1.setIcon(new ImageIcon("img/travel-schedule.png"));
		lblNewLabel_1_1_1_1.setBounds(10, 10, 32, 32);
		pnTour.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("QL Tour");
		lblNewLabel_3_1_1_1.setForeground(new Color(75, 0, 130));
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_1_1.setBounds(67, 10, 104, 30);
		pnTour.add(lblNewLabel_3_1_1_1);
		
		pnTK = new JPanel();
		pnTK.setLayout(null);
		pnTK.setBorder(new LineBorder(new Color(72, 209, 204), 2));
		pnTK.setBackground(new Color(64, 224, 208));
		pnTK.setBounds(738, 93, 181, 50);
		contentPane.add(pnTK);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("");
		lblNewLabel_1_1_1_2.setIcon(new ImageIcon("img/graphical-report.png"));
		lblNewLabel_1_1_1_2.setBounds(10, 10, 32, 32);
		pnTK.add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_3_1_1_2 = new JLabel("Thống Kê");
		lblNewLabel_3_1_1_2.setForeground(new Color(75, 0, 130));
		lblNewLabel_3_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_1_2.setBounds(67, 10, 104, 30);
		pnTK.add(lblNewLabel_3_1_1_2);
		
		clock();
		ngay();
		checkQuyen();
		ChangeFrame(new DatTour_GUI());
		pnDatTour.addMouseListener(this);
		pnKH.addMouseListener(this);
		pnNhanVien.addMouseListener(this);
		pnTK.addMouseListener(this);
		pnTour.addMouseListener(this);
		pnNhanVien.setEnabled(false);
	}
	
	public void clock() {
		Thread a = new Thread() {
			@SuppressWarnings("deprecation")
			public void run() {
				try {
		            while (true) {
		                Calendar calendar = Calendar.getInstance();
		             
						String hour = (calendar.getTime().getHours() > 9) ? 
		                        "" + calendar.getTime().getHours() + ""
		                        : "0" + calendar.getTime().getHours();
		                String minute = (calendar.getTime().getMinutes() > 9) ? 
		                        "" + calendar.getTime().getMinutes() + ""
		                        : "0" + calendar.getTime().getMinutes();
		                String second = (calendar.getTime().getSeconds() > 9) ? 
		                        "" + calendar.getTime().getSeconds() + ""
		                        : "0" + calendar.getTime().getSeconds();
		               lblGio.setText(hour + ":" + minute + ":" + second);
		                Thread.sleep(1000);
		            }
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
			}
		};
		a.start();
	}
	public void ngay() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		lblNgay.setText(sdf.format(date));
	}
	public void checkQuyen() {
		
		NhanVien_DAO nvDao= new NhanVien_DAO();
		NhanVien nhanVien = nvDao.findByID(String.valueOf(ShareData.taiKhoan.getTenDN()));
		
		if (ShareData.taiKhoan.getQuyen()==2) {
			lblNhanVien.setText("Nhân Viên : "+nhanVien.getTenNV() );
			pnNhanVien.setVisible(false);;
			pnKH.setBounds(192, 93, 181, 50);
			pnTour.setBounds(374, 93, 181, 50);
			pnTK.setBounds(556, 93, 181, 50);
			//pnTK.setBounds(738, 93, 181, 50);
		}else {
			lblNhanVien.setText("Quản Lý : "+nhanVien.getTenNV());
		}
	}
	private void ChangeFrame(JPanel panel1) {
		panel.removeAll();
		panel.setLayout(new CardLayout());
		panel.add(panel1);
		panel.validate();
		panel.repaint();

	}
	public void ChangeColor(JPanel pnFocus, JPanel unFocus1,JPanel unFocus2,JPanel unFocus3,JPanel unFocus4) {
		pnFocus.setBackground(new Color(147, 112, 219));
		
		unFocus1.setBackground(new Color(64, 224, 208));
		unFocus2.setBackground(new Color(64, 224, 208));
		unFocus3.setBackground(new Color(64, 224, 208));
		unFocus4.setBackground(new Color(64, 224, 208));
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o==pnNhanVien) {
			ChangeFrame(new GDQuanLyNhanVien());
			ChangeColor(pnNhanVien, pnKH, pnDatTour, pnTK,pnDatTour);
		}
		if (o==pnDatTour) {
			ChangeFrame(new DatTour_GUI());
			ChangeColor(pnDatTour, pnKH, pnTour, pnTK,pnNhanVien);
		}
		if (o==pnKH) {
			ChangeFrame(new GDQuanLyKhachHang());
			ChangeColor(pnKH, pnTK, pnDatTour, pnTour,pnNhanVien);
		}
		
		if (o==pnTour) {
			ChangeFrame(new GDQuanLyTour());
			ChangeColor(pnTour, pnKH, pnDatTour, pnTK,pnNhanVien);
		}
		if (o==pnTK) {
			ChangeFrame(new GDThongKe());
			ChangeColor(pnTK, pnKH, pnDatTour, pnNhanVien,pnTour);
		}
		
		
		
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

	
}

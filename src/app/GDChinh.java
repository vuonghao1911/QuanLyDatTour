package app;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;

import dao.NhanVien_DAO;
import entity.NhanVien;
import entity.TaiKhoan;
import gui.DatTour_GUI;
import gui.GDQuanLyTour;
import gui.GDThongKe;
import shareData.ShareData;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GDChinh extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblGio;
	private JLabel lblNgay;
	private JLabel lblNhanVien;
	private JButton btnThongKe;
	private JButton btnThngKe;
	private JButton btnQLNV;
	private JPanel panel;

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
		JPanel pnKhachHang = new GDQuanLyTour();
		
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
		lblNewLabel_2.setIcon(new ImageIcon("D:\\JavaProjects\\HSK_QLTour\\img\\employee-infographic.png"));
		lblNewLabel_2.setBounds(993, 30, 88, 76);
		contentPane.add(lblNewLabel_2);
		
		panel = new JPanel();
		panel.setBounds(10, 153, 1250, 660);
		contentPane.add(panel);
		
		btnThongKe = new JButton("Đặt Tour");
	 
				
		btnThongKe.setBackground(new Color(127, 255, 212));
		btnThongKe.setBounds(26, 106, 106, 40);
		contentPane.add(btnThongKe);
		
		btnThngKe = new JButton("Thống kê");
		btnThngKe.setBackground(new Color(127, 255, 212));
		btnThngKe.setBounds(132, 106, 106, 40);
		contentPane.add(btnThngKe);
		
		btnQLNV = new JButton("Quản lý nhan viên");
		btnQLNV.setBackground(new Color(127, 255, 212));
		btnQLNV.setBounds(238, 106, 106, 40);
		contentPane.add(btnQLNV);
		
		clock();
		ngay();
		//checkQuyen();
		ChangeFrame(new GDThongKe());
		btnQLNV.addActionListener(this);
		btnThngKe.addActionListener(this);
		btnThongKe.addActionListener(this);
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
		
		if (ShareData.taiKhoan.getQuyen()==1) {
			lblNhanVien.setText("Nhân Viên : "+nhanVien.getTenNV() );
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		if (object == btnThongKe) {
			ChangeFrame(new GDThongKe());
			
		}
		if (object == btnQLNV) {
			ChangeFrame(new GDQuanLyTour());
		}
		
	}
}

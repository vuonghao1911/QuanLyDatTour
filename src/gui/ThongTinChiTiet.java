package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.Ve;

import javax.swing.JLabel;
import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Toolkit;

public class ThongTinChiTiet extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//ThongTinChiTiet frame = new ThongTinChiTiet();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ThongTinChiTiet(Ve  ve) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/Group.png"));
		
		DecimalFormat df = new DecimalFormat("###,###,###");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 737, 376);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Chi Tiết Vé");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(223, 10, 272, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ngày Đặt : "+ve.getNgayDat());
		lblNewLabel_1.setForeground(new Color(64, 224, 208));
		lblNewLabel_1.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setBounds(39, 122, 252, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tour : " +ve.getTour().getTenTour());
		lblNewLabel_1_1.setForeground(new Color(64, 224, 208));
		lblNewLabel_1_1.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_1.setBounds(39, 80, 252, 32);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Nhân Viên : " +ve.getNhanVien().getTenNV());
		lblNewLabel_1_1_1.setForeground(new Color(221, 160, 221));
		lblNewLabel_1_1_1.setFont(new Font("Sitka Small", Font.ITALIC, 15));
		lblNewLabel_1_1_1.setBounds(424, 297, 258, 32);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Khách Hàng : " +ve.getKhachHang().getTenKH()) ;
		lblNewLabel_1_2.setForeground(new Color(64, 224, 208));
		lblNewLabel_1_2.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_2.setBounds(361, 80, 289, 32);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Giá : "+ df.format(ve.getTour().getGia())+"VND");
		lblNewLabel_1_3.setForeground(new Color(64, 224, 208));
		lblNewLabel_1_3.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_3.setBounds(39, 179, 272, 32);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Giá Trẻ Em : " + df.format(ve.getTour().getGiaTreEm())+ "VND");
		lblNewLabel_1_3_1.setForeground(new Color(64, 224, 208));
		lblNewLabel_1_3_1.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_3_1.setBounds(39, 232, 272, 32);
		contentPane.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Số Người Lớn : " +ve.getSoNguoiLon());
		lblNewLabel_1_3_2.setForeground(new Color(64, 224, 208));
		lblNewLabel_1_3_2.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_3_2.setBounds(361, 131, 227, 32);
		contentPane.add(lblNewLabel_1_3_2);
		
		JLabel lblNewLabel_1_3_2_1 = new JLabel("Số Trẻ Em : " +ve.getSoTreEm());
		lblNewLabel_1_3_2_1.setForeground(new Color(64, 224, 208));
		lblNewLabel_1_3_2_1.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_3_2_1.setBounds(361, 179, 227, 32);
		contentPane.add(lblNewLabel_1_3_2_1);
		
		JLabel lblNewLabel_1_3_2_1_1 = new JLabel("Tổng Tiền : "+ df.format(ve.TongTien())+"VND");
		lblNewLabel_1_3_2_1_1.setForeground(new Color(64, 224, 208));
		lblNewLabel_1_3_2_1_1.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_3_2_1_1.setBounds(361, 232, 309, 32);
		contentPane.add(lblNewLabel_1_3_2_1_1);
	}
}

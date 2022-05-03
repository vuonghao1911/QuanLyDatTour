package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class GDChinh extends JFrame {

	private JPanel contentPane;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\JavaProjects\\HSK_QLTour\\img\\Group.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 850);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		FlatCyanLightIJTheme.setup();
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(20, 93, 1250, 700);
		JPanel pnKhachHang = new GDQuanLyKhachHang();
		//pnKhachHang.setPreferredSize(new Dimension(tabbedPane.getWidth(),tabbedPane.getHeight()));
		tabbedPane.addTab("thong ke", new GDThongKe());
		contentPane.add(tabbedPane);
		
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
		
		JLabel lblPhnMmQun = new JLabel("Phần Mềm Quản Lý Đặt Tour");
		lblPhnMmQun.setForeground(new Color(123, 104, 238));
		lblPhnMmQun.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblPhnMmQun.setBounds(520, 25, 363, 34);
		contentPane.add(lblPhnMmQun);
		
		JLabel lblNewLabel_1 = new JLabel("Nhân Viên : Tiến Đạt");
		lblNewLabel_1.setForeground(new Color(178, 34, 34));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(1071, 60, 205, 34);
		contentPane.add(lblNewLabel_1);
	}
}

package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Image;


import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.VeDao;

import entity.Tour;
import entity.Ve;

import javax.swing.JComboBox;
import java.awt.Toolkit;

public class GDThongKe extends JFrame implements ActionListener, KeyListener, MouseListener {

	private JPanel contentPane;
	private JTextField txtTenNV;
	private JTextField txtTenKH;
	private JTextField textField;
	private JTable table;
	private JComboBox cboThang;
	private String cboString [] = {"1","2","3","4","5","6","7","8","9","10","11","12"};
	private String[] colsTC ={"Mã Vé", " Tên Tour","Tên Khách Hàng","Nhân Viên","Ngày Đặt","Thành Tiền" };	
	private JDateChooser dcNgay;
	private DefaultTableModel model;
	private JLabel lblDoanhThu;
	private JLabel lblSoVe;
	private VeDao veDao;
	private ArrayList<Ve> dsVe ;
	private ArrayList<Ve> dsVeNgay ;
	private JPanel pnThongKe;
	private JButton btnTim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDThongKe frame = new GDThongKe();
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
	public GDThongKe() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/Group.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		FlatCyanLightIJTheme.setup();
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		panel.setBounds(0, 0, 1204, 94);
		contentPane.add(panel);
		panel.setLayout(null);
		

		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		veDao = new VeDao();
		
		JLabel lblNewLabel_1 = 	new JLabel("New label");
		lblNewLabel_1.setBounds(788, 16, 71, 60);
		panel.add(lblNewLabel_1);
		
		
		
		try {
			BufferedImage imgImage = ImageIO.read(new File("img/report-analysis.512x496.png"));
			
			Image img = imgImage.getScaledInstance(lblNewLabel_1.getWidth(),lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon icontk = new ImageIcon(img);
			lblNewLabel_1.setIcon(icontk);
			
			JLabel lblNewLabel = new JLabel("THỐNG KÊ VÀ TRA CỨU ");
			lblNewLabel.setBounds(335, 10, 524, 69);
			panel.add(lblNewLabel);
			lblNewLabel.setForeground(new Color(240, 248, 255));
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			
			JPanel panel_1 = new JPanel();
			panel_1.setSize(new Dimension(3, 2));
			panel_1.setBorder(new LineBorder(new Color(224, 255, 255), 2));
			panel_1.setBounds(new Rectangle(4, 5, 2, 2));
			panel_1.setBackground(new Color(162, 226, 242));
			panel_1.setBounds(24, 110, 182, 34);
			contentPane.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JLabel lblNewLabel_2 = new JLabel("Tìm Theo Tên Nhân Viên");
			lblNewLabel_2.setForeground(new Color(	24, 140, 166));
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			panel_1.add(lblNewLabel_2);
			
			txtTenNV = new JTextField();
			txtTenNV.setBackground(new Color(241, 233, 233));
			txtTenNV.setBounds(216, 110, 161, 34);
			contentPane.add(txtTenNV);
			txtTenNV.setColumns(10);
			
			JPanel panel_1_1 = new JPanel();
			panel_1_1.setSize(new Dimension(3, 2));
			panel_1_1.setBounds(new Rectangle(4, 5, 2, 2));
			panel_1_1.setBorder(new LineBorder(new Color(224, 255, 255), 2));
			panel_1_1.setBackground(new Color(162, 226, 242));
			panel_1_1.setBounds(409, 110, 197, 34);
			contentPane.add(panel_1_1);
			panel_1_1.setLayout(new BorderLayout(0, 0));
			
			JLabel lblNewLabel_2_1 = new JLabel("Tìm Theo Tên Khách Hàng");
			panel_1_1.add(lblNewLabel_2_1, BorderLayout.CENTER);
			lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_1.setForeground(new Color(24, 140, 166));
			lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			txtTenKH = new JTextField();
			txtTenKH.setColumns(10);
			txtTenKH.setBackground(new Color(241, 233, 233));
			txtTenKH.setBounds(616, 110, 161, 34);
			contentPane.add(txtTenKH);
			
			dcNgay = new JDateChooser();
			dcNgay.setBorder(new LineBorder(new Color(239, 195, 197)));
			dcNgay.setBackground(new Color(241, 233, 233));
			dcNgay.setBounds(878, 110, 171, 34);
			contentPane.add(dcNgay);
			
			btnTim = new JButton("TÌM");
			btnTim.setIcon(new ImageIcon("img/Vector.png"));
			btnTim.setBorder(new LineBorder(new Color(224, 255, 255)));
			btnTim.setForeground(new Color(24, 140, 166));
			btnTim.setBackground(new Color(162, 226, 242));
			btnTim.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnTim.setBounds(1081, 110, 95, 34);
			contentPane.add(btnTim);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new LineBorder(new Color(152, 251, 152), 2));
			panel_2.setBackground(new Color(50, 205, 50));
			panel_2.setBounds(100, 164, 364, 117);
			contentPane.add(panel_2);
			panel_2.setLayout(null);
			
			lblDoanhThu = new JLabel("4.500.000 VND");
			lblDoanhThu.setFont(new Font("Times New Roman", Font.BOLD, 19));
			lblDoanhThu.setForeground(new Color(245, 255, 250));
			lblDoanhThu.setBounds(122, 73, 153, 27);
			panel_2.add(lblDoanhThu);
			
			JLabel lblNewLabel_3 = new JLabel("   TỔNG DOANH THU");
			lblNewLabel_3.setBounds(55, 10, 240, 70);
			panel_2.add(lblNewLabel_3);
			lblNewLabel_3.setVerticalTextPosition(SwingConstants.TOP);
			lblNewLabel_3.setForeground(new Color(248, 248, 255));
			lblNewLabel_3.setIcon(new ImageIcon("img/coin.png"));
			lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
			
			JPanel panel_2_1 = new JPanel();
			panel_2_1.setBorder(new LineBorder(new Color(255, 215, 0), 2));
			panel_2_1.setLayout(null);
			panel_2_1.setBackground(new Color(255, 165, 0));
			panel_2_1.setBounds(726, 164, 364, 117);
			contentPane.add(panel_2_1);
			
			lblSoVe = new JLabel("4.500.000 VND");
			lblSoVe.setHorizontalAlignment(SwingConstants.CENTER);
			lblSoVe.setForeground(new Color(245, 255, 250));
			lblSoVe.setFont(new Font("Times New Roman", Font.BOLD, 19));
			lblSoVe.setBounds(93, 55, 187, 38);
			panel_2_1.add(lblSoVe);
			
			JLabel lblNewLabel_3_1 = new JLabel("TỔNG SỐ VÉ ĐÃ ĐẶT");
			lblNewLabel_3_1.setIcon(new ImageIcon("img/soluotdatphong.png"));
			lblNewLabel_3_1.setVerticalTextPosition(SwingConstants.TOP);
			lblNewLabel_3_1.setForeground(new Color(248, 248, 255));
			lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lblNewLabel_3_1.setBounds(55, 10, 240, 70);
			panel_2_1.add(lblNewLabel_3_1);
			
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBackground(new Color(255, 255, 255));
			tabbedPane.setBounds(10, 303, 1166, 450);
			contentPane.add(tabbedPane);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBackground(SystemColor.menu);
			tabbedPane.addTab("Thông Tin Vé", new ImageIcon("img/business-report.png"), panel_3, null);
			tabbedPane.setBackgroundAt(0, new Color(224, 255, 255));
			panel_3.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 10, 1161, 402);
			panel_3.add(scrollPane);
			
			 model = new DefaultTableModel(colsTC,0);
			
			table = new JTable(model);
			
			

			JTableHeader tableHeader = table.getTableHeader();
			tableHeader.setBackground(new Color(108, 166, 205));
			tableHeader.setFont(new Font("Arial", Font.BOLD, 14));
			tableHeader.setForeground(Color.white);
			scrollPane.setViewportView(table);
			
			JPanel pnBieuDo = new JPanel();
			tabbedPane.addTab("Xem Biểu Đồ", new ImageIcon("img/barchar.png"), pnBieuDo, null);
			tabbedPane.setBackgroundAt(1, new Color(240, 255, 255));
			pnBieuDo.setLayout(null);
			
			JPanel panel_1_2 = new JPanel();
			panel_1_2.setSize(new Dimension(3, 2));
			panel_1_2.setBounds(new Rectangle(4, 5, 2, 2));
			panel_1_2.setBorder(new LineBorder(new Color(224, 255, 255), 2));
			panel_1_2.setBackground(new Color(162, 226, 242));
			panel_1_2.setBounds(431, 10, 169, 29);
			pnBieuDo.add(panel_1_2);
			panel_1_2.setLayout(new BorderLayout(0, 0));
			
			JLabel lblNewLabel_2_2 = new JLabel("Chọn Tháng Cần Xem");
			panel_1_2.add(lblNewLabel_2_2, BorderLayout.CENTER);
			lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_2.setForeground(new Color(24, 140, 166));
			lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			cboThang = new JComboBox<>(cboString);
			cboThang.setBackground(new Color(241, 233, 233));
			cboThang.setBounds(625, 10, 137, 29);
			
			pnBieuDo.add(cboThang);
			
			pnThongKe = new JPanel();
			pnThongKe.setBounds(10, 49, 1141, 353);
			pnBieuDo.add(pnThongKe);
			
			ThongKeDoanhThuThang(pnThongKe, LocalDate.now().getMonthValue());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cboThang.addActionListener(this);
		txtTenKH.addKeyListener(this);
		txtTenNV.addKeyListener(this);
		btnTim.addActionListener(this);
		table.addMouseListener(this);
		
	
		DocDuLieuVaoTable(veDao.getAllVes());
		RenderDataForLabel(veDao.getAllVes());
	}
	
	private void DocDuLieuVaoTable(ArrayList<Ve> dsVes) {
		DecimalFormat df = new DecimalFormat("###,###,###");
		for (Ve ve : dsVes) {
			model.addRow(new Object[] {ve.getMaVe(),ve.getTour().getTenTour(),ve.getKhachHang().getTenKH(),ve.getNhanVien().getTenNV(),ve.getNgayDat(),df.format(ve.TongTien())});
		}

	}
	private void RenderDataForLabel(ArrayList<Ve> adVes) {
		DecimalFormat df = new DecimalFormat("###,###,###");
		double tong = 0;
		for (Ve ve : adVes) {
			tong += ve.TongTien();
		}
		
		lblDoanhThu.setText(df.format(tong) +" VND");
		lblSoVe.setText(+adVes.size()+" Vé Được Đặt ");
	}
	
	private void ThongKeDoanhThuThang(JPanel pnPanel , int month) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM");
		
		dsVe = veDao.getVeByMonth(month);	
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		if (dsVe != null) {
			for (Ve ve : dsVe) {
				double tong = 0;
				dsVeNgay = veDao.getAllVeByDate(ve.getNgayDat());

				if (dsVeNgay.size() == 1) {
					dataset.addValue(ve.TongTien(), "Doanh Thu(VND)",sdf.format( ve.getNgayDat()));
				} else {
					for (Ve veNgay : dsVeNgay) {

						tong += ve.TongTien();
					}
					dataset.addValue(tong, "Doanh Thu(VND)",sdf.format(ve.getNgayDat()));
				}

			}

		}

		JFreeChart freeChart = ChartFactory.createBarChart("Doanh thu trong tháng ".toUpperCase() + month + "",
				"Ngày", "VND", dataset, PlotOrientation.VERTICAL, true, true, false);

		BarRenderer r = (BarRenderer) freeChart.getCategoryPlot().getRenderer();
		r.setSeriesPaint(0, new Color(45, 137, 216));
		
		CategoryPlot cplot = (CategoryPlot) freeChart.getPlot();
		cplot.setBackgroundPaint(SystemColor.inactiveCaption);
		
		CategoryItemRenderer renderer = ((CategoryPlot) freeChart.getPlot()).getRenderer();
		renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setItemLabelsVisible(true);
		ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.TOP_CENTER);
		renderer.setNegativeItemLabelPosition(position);
		
		ChartPanel chartPanel = new ChartPanel(freeChart);

		freeChart.getTitle().setFont(new Font("Arial", Font.BOLD, 24));
		chartPanel.setPreferredSize(new Dimension(pnPanel.getWidth(), pnPanel.getHeight()));
		pnPanel.removeAll();
		pnPanel.setLayout(new CardLayout());
		pnPanel.add(chartPanel);
		pnPanel.validate();
		pnPanel.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	Object o = e.getSource();
	if (o==cboThang) {
		int month = Integer.parseInt(cboThang.getSelectedItem().toString());
		ThongKeDoanhThuThang(pnThongKe, month);
		RenderDataForLabel(veDao.getVeByMonth(month));
	}
	if (o==btnTim) {
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
		DocDuLieuVaoTable(veDao.getAllVeByDate(dcNgay.getDate()));
		RenderDataForLabel(veDao.getAllVeByDate(dcNgay.getDate()));
	}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Object o = e.getSource();
		if(o==txtTenNV) {
		String ten = txtTenNV.getText().trim();
		ArrayList<Ve> dsHD = veDao.getVeByNameNhanVien(ten);
				while (model.getRowCount() > 0) {
					model.removeRow(0);
				}
				DocDuLieuVaoTable(dsHD);
				RenderDataForLabel(dsHD);
		}
		if(o==txtTenKH) {
			String ten = txtTenKH.getText().trim();
			ArrayList<Ve> dsHD = veDao.getVeByNameKhachHang(ten);
					while (model.getRowCount() > 0) {
						model.removeRow(0);
					}
					DocDuLieuVaoTable(dsHD);
					RenderDataForLabel(dsHD);
		
	}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		int ma = Integer.parseInt(table.getValueAt(row, 0).toString());
		ThongTinChiTiet thongTinChiTiet = new ThongTinChiTiet(veDao.getVeByMaVe(ma));
		thongTinChiTiet.setVisible(true);
		
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

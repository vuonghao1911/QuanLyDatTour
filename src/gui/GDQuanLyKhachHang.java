package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.KhachHang_DAO;
import entity.KhachHang;

@SuppressWarnings("serial")
public class GDQuanLyKhachHang extends JPanel implements ActionListener, MouseListener {
	private JPanel pnlControl;
	private JPanel pnlTask;
	private JPanel pnlContent;
	private JLabel lblTitle;
	private JLabel lblID;
	private JLabel lblName;
	private JLabel lblTel;
	private JLabel lblCode;
	private JLabel lblGender;
	private JLabel lblTourCode;
	private JTextField tfID;
	private JTextField tfName;
	private JTextField tfTel;
	private JTextField tfCode;
	private JComboBox<String> cbxGender;
	private JTextField tfTourCode;
	private JTextField tfSearch;
	private JButton btnSearch;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JTable tblCustomer;
	private DefaultTableModel defaultTableModel;
	private int currentPostition = -1;

	public GDQuanLyKhachHang() {
		initGUI();
		setListener();
		autoLoadDatabase();
	}

	private void autoLoadDatabase() {
		KhachHang_DAO customerDAO = new KhachHang_DAO();
		List<KhachHang> customers = customerDAO.getALLKhachHang();
		for (KhachHang customer : customers) {
			defaultTableModel.addRow(new Object[] { customer.getMaKH(), customer.getTenKH(), customer.getSdt(),
					customer.getGioiTinh(), customer.getCmnd() });
		}
	}

	private void setListener() {
		btnSearch.addActionListener(this);
		btnAdd.addActionListener(this);
		btnDelete.addActionListener(this);
		btnUpdate.addActionListener(this);
		tblCustomer.addMouseListener(this);
	}

	private void initGUI() {
		setSize(1240, 574);

//		this.setResizable(false);
//		this.setTitle("Qu???n L?? Kh??ch H??ng");
//		this.setLocationRelativeTo(null);
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		
		JPanel jpnGDQuanLyKH = new JPanel();
		jpnGDQuanLyKH.setLayout(new BoxLayout(jpnGDQuanLyKH, BoxLayout.Y_AXIS) );
		
		String[] gender = { "Nam", "N???" };
		jpnGDQuanLyKH.add(lblTitle = new JLabel("QU???N L?? KH??CH H??NG", JLabel.CENTER));
		
		JPanel pnlTT = new JPanel();
		pnlTT.setLayout(new GridLayout(1, 2));
		
//		B??n tr??i		
		JPanel p1 = new JPanel();
		p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
		
		JPanel p11 = new JPanel();
        JLabel lblID = new JLabel("M?? Kh??ch H??ng: ");
        tfID = new JTextField(30);
        p11.add(lblID);
        p11.add(tfID);
        p1.add(p11);
        
        JPanel p12 = new JPanel();
        JLabel lblName = new JLabel("T??n Kh??ch H??ng: ");
        tfName = new JTextField(30);
        p12.add(lblName);
        p12.add(tfName);
        p1.add(p12);
        
        JPanel p13 = new JPanel();
        JLabel lblTel = new JLabel("S??? ??i???n Tho???i: ");
        tfTel = new JTextField(30);
        p13.add(lblTel);
        p13.add(tfTel);
        p1.add(p13);
        
		pnlTT.add(p1);
		
//		B??n ph???i 
		JPanel p2 = new JPanel();
		p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
		
		JPanel p21 = new JPanel();
        JLabel lblCode = new JLabel("S??? CMND: ");
        tfCode = new JTextField(30);
        p21.add(lblCode);
        p21.add(tfCode);
        p2.add(p21);
        
        JPanel p22 = new JPanel();
        JLabel lblTourCode = new JLabel("M?? Tour: ");
        tfTourCode = new JTextField(30);
        p22.add(lblTourCode);
        p22.add(tfTourCode);
        p2.add(p22);
        
        JPanel p23 = new JPanel();
        JLabel lblGender = new JLabel("Gi???i t??nh: ");
        cbxGender = new JComboBox<String>(gender);
        p23.add(lblGender);
        p23.add(cbxGender);
        p2.add(p23);
        pnlTT.add(p2);
        jpnGDQuanLyKH.add(pnlTT);
		
		jpnGDQuanLyKH.add(pnlTask = new JPanel());
		pnlTask.add(tfSearch = new JTextField(30));
		pnlTask.add(btnSearch = new JButton("T??m Ki???m"));
		pnlTask.add(btnAdd = new JButton("Th??m"));
		pnlTask.add(btnUpdate = new JButton("C???p Nh???t"));
		pnlTask.add(btnDelete = new JButton("X??a"));

		String[] header = { "M?? Kh??ch H??ng", "T??n Kh??ch H??ng", "S??? ??i???n Tho???i", "Gi???i T??nh", "M?? ?????nh Danh" };
		defaultTableModel = new DefaultTableModel(header, 0);
		jpnGDQuanLyKH.add(new JScrollPane(tblCustomer = new JTable(defaultTableModel)));
		JTableHeader tableHeader = tblCustomer.getTableHeader();
		tableHeader.setBackground(new Color(108, 166, 205));
		tableHeader.setFont(new Font("Arial", Font.BOLD, 14));
		tableHeader.setForeground(Color.white);

		

		lblTitle.setPreferredSize(new Dimension(640, 35));
		lblID.setPreferredSize(new Dimension(100, 20));
		lblName.setPreferredSize(new Dimension(100, 20));
		lblGender.setPreferredSize(new Dimension(100, 20));
		lblCode.setPreferredSize(new Dimension(100, 20));
		lblTel.setPreferredSize(new Dimension(100, 20));
		lblTourCode.setPreferredSize(new Dimension(100, 20));
		cbxGender.setPreferredSize(new Dimension(190, 20));
		btnSearch.setPreferredSize(new Dimension(100, 25));
		btnAdd.setPreferredSize(new Dimension(100, 25));
		btnUpdate.setPreferredSize(new Dimension(100, 25));
		btnDelete.setPreferredSize(new Dimension(100, 25));
		tblCustomer.setPreferredScrollableViewportSize(new Dimension(1220, 280));

		lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
		lblTitle.setForeground(Color.RED);

		pnlTask.setBorder(BorderFactory.createTitledBorder("Thao T??c Qu???n L??: "));
		
		add(jpnGDQuanLyKH);
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	public static void main(String[] args) {
//		new GDQuanLyKhachHang().setVisible(true);
//	}

	@Override
	public void mouseClicked(MouseEvent e) {
		currentPostition = tblCustomer.getSelectedRow();
		tfID.setText(String.valueOf(defaultTableModel.getValueAt(currentPostition, 0)));
		tfName.setText(String.valueOf(defaultTableModel.getValueAt(currentPostition, 1)));
		tfTel.setText(String.valueOf(defaultTableModel.getValueAt(currentPostition, 2)));
		cbxGender.setSelectedItem(String.valueOf(defaultTableModel.getValueAt(currentPostition, 3)));
		tfCode.setText(String.valueOf(defaultTableModel.getValueAt(currentPostition, 4)));
		//tfTourCode.setText(String.valueOf(defaultTableModel.getValueAt(currentPostition, 5)));
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		KhachHang_DAO customerDAO = new KhachHang_DAO();
		List<KhachHang> customers = customerDAO.getAll();
		if (object.equals(btnSearch)) {
			KhachHang customer = customerDAO.findByID(tfSearch.getText());
			if (tfSearch.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui l??ng ??i???n m?? kh??ch h??ng ????? t??m ki???m!");
			} else if (customerDAO.findByID(tfSearch.getText()) == null) {
				JOptionPane.showMessageDialog(null, "Kh??ng t??m th???y th??ng tin kh??ch h??ng!");
			} else {
				defaultTableModel.getDataVector().removeAllElements();
				defaultTableModel.addRow(new Object[] { customer.getMaKH(), customer.getTenKH(), customer.getSdt(),
						customer.getGioiTinh(), customer.getCmnd(), customer.getMaVe() });
			}
		} else if (object.equals(btnAdd)) {
			if (customers.contains(new KhachHang(Integer.parseInt(tfID.getText())))) {
				JOptionPane.showMessageDialog(null, "M?? Nh??n Vi??n ???? T???n T???i!");
			} else if (isValidField()) {
				try {
					KhachHang customer = new KhachHang(Integer.parseInt(tfID.getText()), tfName.getText(), tfTel.getText(),
							cbxGender.getSelectedItem().toString(), tfCode.getText());
					customerDAO.add(customer);
					defaultTableModel.addRow(new Object[] { customer.getMaKH(), customer.getTenKH(), customer.getSdt(),
							customer.getGioiTinh(), customer.getCmnd(), customer.getMaVe() });
					clearField();
					JOptionPane.showMessageDialog(null, "Th??m Kh??ch H??ng Th??nh C??ng!");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "C?? L???i X???y Ra, Vui L??ng Th??? L???i Sau!");
				}
				clearField();
			}
			
		} else if (object.equals(btnUpdate)) {
			if (tblCustomer.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Ch???n M???t Kh??ch H??ng Tr?????c Khi C???p Nh???t");
			} else if (isValidField()) {
				KhachHang customer = new KhachHang(Integer.parseInt(tfID.getText()), tfName.getText(), tfTel.getText(),
						cbxGender.getSelectedItem().toString(), tfCode.getText());
				try {
					customerDAO.update(customer, tfID.getText());
					defaultTableModel.removeRow(currentPostition);
					defaultTableModel.addRow(new Object[] { customer.getMaKH(), customer.getTenKH(), customer.getSdt(),
							customer.getGioiTinh(), customer.getCmnd(), customer.getMaVe() });
					clearField();
					JOptionPane.showMessageDialog(null, "C???p Nh???t Th??nh C??ng!");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "C?? L???i X???y Ra Trong Qu?? T??nh C???p Nh???t!");
				}

			}
		} else if (object.equals(btnDelete)) {
			if (tblCustomer.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Ch???n M???t Kh??ch H??ng Tr?????c Khi X??a");
			} else {
				try {
					customerDAO.delete(tfID.getText());
					defaultTableModel.removeRow(currentPostition);
					JOptionPane.showMessageDialog(null, "X??a Th??nh C??ng!");
				} catch (SQLException e1) {
				}
				clearField();
			}
		}
	}

	private void clearField() {
		tfID.setText("");
		tfName.setText("");
		tfCode.setText("");
		tfTel.setText("");
		tfTourCode.setText("");
	}

	private boolean isValidField() {
		try {
			Integer.parseInt(tfID.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "M?? Kh??ch H??ng L?? B???t Bu???c V?? Ch??? Ch???a C??c S??? Nguy??n!");
			return false;
		}

		try {
			Integer.parseInt(tfTourCode.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "M?? V?? L?? B???t Bu???c V?? Ch??? Ch???a S???!");
			return false;
		}

		if (!tfName.getText()
				.matches("^(?:[\\p{L}\\p{Mn}\\p{Pd}\\'\\x{2019}]+\\s[\\p{L}\\p{Mn}\\p{Pd}\\'\\x{2019}]+\\s?)+$")) {
			JOptionPane.showMessageDialog(null, "T??n Kh??ch H??ng L?? B???t Bu???c Ch??? Ch???a Ch??? C??i V?? D???u C??ch!");
			return false;
		}

		if (!tfCode.getText().matches("^[0-9]{8}$")) {
			JOptionPane.showMessageDialog(null, "M?? ?????nh Danh C?? Nh??n L?? B???t Bu???c V?? Ch???a 8 S???!");
			return false;
		}

		if (!tfTel.getText().matches("^[0-9]{10}$")) {
			JOptionPane.showMessageDialog(null, "S??? ??i???n Tho???i L?? B???t Bu???c V?? Ch???a 10 S???!");
			return false;
		}
		return true;
	}
}

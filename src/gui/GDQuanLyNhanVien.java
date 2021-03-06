package gui;


import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.NhanVien_DAO;
import entity.NhanVien;

@SuppressWarnings("serial")
public class GDQuanLyNhanVien extends JPanel implements ActionListener, MouseListener {
	private JPanel pnlTask;

	private JLabel lblTitle;
	private JLabel lblID;
	private JLabel lblName;
	private JLabel lblTel;
	private JLabel lblAddress;
	private JLabel lblDayOfBirth;
	private JLabel lblGender;
	private JTextField tfID;
	private JTextField tfName;
	private JTextField tfTel;
	private JTextField tfAddress;
	private JDateChooser dchDayOfBirth;
	private JComboBox<String> cbxGender;
	private JTextField tfSearch;
	private JButton btnSearch;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JTable tblEmployee;
	private DefaultTableModel defaultTableModel;
	private int currentPostition = -1;

	public GDQuanLyNhanVien() {
		initGUI();
		setListener();
		autoLoadDatabase();
	}

	private void autoLoadDatabase() {
		NhanVien_DAO employeeDAO = new NhanVien_DAO();
		List<NhanVien> employees = employeeDAO.getAll();
		for (NhanVien employee : employees) {
			defaultTableModel.addRow(new Object[] { employee.getMaNV(), employee.getTenNV(), employee.getDiaChi(),
					employee.getSdt(), employee.getNgaySinh(), employee.getGioiTinh() });
		}
	}

	private void setListener() {
		btnSearch.addActionListener(this);
		btnAdd.addActionListener(this);
		btnDelete.addActionListener(this);
		btnUpdate.addActionListener(this);
		tblEmployee.addMouseListener(this);
	}

	private void initGUI() {
		setSize(1250, 574);
//		this.setResizable(false);
//		this.setTitle("Qu???n L?? Nh??n Vi??n");
//		this.setLocationRelativeTo(null);
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel jpnGDQuanLyNV = new JPanel();
		jpnGDQuanLyNV.setLayout(new BoxLayout(jpnGDQuanLyNV, BoxLayout.Y_AXIS) );
		
		String[] gender = { "Nam", "N???" };
		jpnGDQuanLyNV.add(lblTitle = new JLabel("QU???N L?? NH??N VI??N", JLabel.CENTER));
		
		JPanel pnlTT = new JPanel();
		pnlTT.setLayout(new GridLayout(1, 2));
		
//		B??n tr??i		
		JPanel p1 = new JPanel();
		p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
		
		JPanel p11 = new JPanel();
        JLabel lblID = new JLabel("M?? Nh??n Vi??n: ");
        tfID = new JTextField(30);
        p11.add(lblID);
        p11.add(tfID);
        p1.add(p11);
        
        JPanel p12 = new JPanel();
        JLabel lblName = new JLabel("T??n Nh??n Vi??n: ");
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
        JLabel lblAddress = new JLabel("?????a Ch???: ");
        tfAddress = new JTextField(30);
        p21.add(lblAddress);
        p21.add(tfAddress);
        p2.add(p21);
        
        JPanel p22 = new JPanel();
        JLabel lblDayOfBirth = new JLabel("Ng??y Sinh: ");
        dchDayOfBirth = new JDateChooser();
        p22.add(lblDayOfBirth);
        p22.add(dchDayOfBirth);
        p2.add(p22);
        
        JPanel p23 = new JPanel();
        JLabel lblGender = new JLabel("Gi???i t??nh: ");
        cbxGender = new JComboBox<String>(gender);
        p23.add(lblGender);
        p23.add(cbxGender);
        p2.add(p23);
        
        pnlTT.add(p2);
        jpnGDQuanLyNV.add(pnlTT);
       
		jpnGDQuanLyNV.add(pnlTask = new JPanel());	
		pnlTask.add(tfSearch = new JTextField(20));
		pnlTask.add(btnSearch = new JButton("T??m Ki???m"));
		pnlTask.add(btnAdd = new JButton("Th??m"));
		pnlTask.add(btnUpdate = new JButton("C???p Nh???t"));
		pnlTask.add(btnDelete = new JButton("X??a"));
		pnlTask.setPreferredSize(new Dimension(1220, 60));
		
		String[] header = { "M?? Nh??n Vi??n", "T??n Nh??n Vi??n", "?????a Ch???", "S??? ??i???n Tho???i", "Ng??y Sinh", "Gi???i T??nh" };
		defaultTableModel = new DefaultTableModel(header, 0);
		jpnGDQuanLyNV.add(new JScrollPane(tblEmployee = new JTable(defaultTableModel)));

		lblTitle.setPreferredSize(new Dimension(650, 35));
		lblID.setPreferredSize(new Dimension(100, 20));
		lblAddress.setPreferredSize(new Dimension(100, 20));
		lblDayOfBirth.setPreferredSize(new Dimension(100, 20));
		lblName.setPreferredSize(new Dimension(100, 20));
		lblTel.setPreferredSize(new Dimension(100, 20));
		lblGender.setPreferredSize(new Dimension(100, 20));
		dchDayOfBirth.getComponent(0).setPreferredSize(new Dimension(135, 20));
		cbxGender.setPreferredSize(new Dimension(190, 20));
		btnSearch.setPreferredSize(new Dimension(100, 25));
		btnAdd.setPreferredSize(new Dimension(100, 25));
		btnUpdate.setPreferredSize(new Dimension(100, 25));
		btnDelete.setPreferredSize(new Dimension(100, 25));
		
		tblEmployee.setPreferredScrollableViewportSize(new Dimension(1220, 288));

		lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
		lblTitle.setForeground(Color.RED);

		pnlTask.setBorder(BorderFactory.createTitledBorder("Thao T??c Qu???n L??: "));
		
		add(jpnGDQuanLyNV);
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	public static void main(String[] args) {
//		new GDQuanLyNhanVien().setVisible(true);
//	}

	@Override
	public void mouseClicked(MouseEvent e) {
		currentPostition = tblEmployee.getSelectedRow();
		tfID.setText(String.valueOf(defaultTableModel.getValueAt(currentPostition, 0)));
		tfName.setText(String.valueOf(defaultTableModel.getValueAt(currentPostition, 1)));
		tfAddress.setText(String.valueOf(defaultTableModel.getValueAt(currentPostition, 2)));
		tfTel.setText(String.valueOf(defaultTableModel.getValueAt(currentPostition, 3)));
		dchDayOfBirth.setDate((Date) defaultTableModel.getValueAt(currentPostition, 4));
		cbxGender.setSelectedItem(String.valueOf(defaultTableModel.getValueAt(currentPostition, 5)));
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
		NhanVien_DAO employeeDAO = new NhanVien_DAO();
		List<NhanVien> employees = employeeDAO.getAll();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		if (object.equals(btnSearch)) {
			NhanVien employee = employeeDAO.findByID(tfSearch.getText());
			if (tfSearch.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui l??ng ??i???n m?? nh??n vi??n ????? t??m ki???m!");
			} else if (employeeDAO.findByID(tfSearch.getText()) == null) {
				JOptionPane.showMessageDialog(null, "Kh??ng t??m th???y th??ng tin nh??n vi??n!");
			} else {
				defaultTableModel.getDataVector().removeAllElements();
				defaultTableModel.addRow(new Object[] { String.valueOf(employee.getMaNV()), employee.getTenNV(),
						employee.getDiaChi(), employee.getSdt(), simpleDateFormat.format(employee.getNgaySinh()),
						employee.getGioiTinh() });
			}
		} else if (object.equals(btnAdd)) {
			if (employees.contains(new NhanVien(Integer.parseInt(tfID.getText())))) {
				JOptionPane.showMessageDialog(null, "M?? Nh??n Vi??n ???? T???n T???i!");
			} else if (isValidField()) {
				try {
					NhanVien employee = new NhanVien(Integer.parseInt(tfID.getText()), tfName.getText(),
							tfAddress.getText(), cbxGender.getSelectedItem().toString(),
							new java.sql.Date(dchDayOfBirth.getDate().getTime()), tfTel.getText());
					employeeDAO.add(employee);
					defaultTableModel.addRow(new Object[] { String.valueOf(employee.getMaNV()), employee.getTenNV(),
							employee.getDiaChi(), employee.getSdt(), simpleDateFormat.format(employee.getNgaySinh()),
							employee.getGioiTinh() });
					JOptionPane.showMessageDialog(null, "Th??m Nh??n Vi??n Th??nh C??ng!");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "C?? L???i X???y Ra, Vui L??ng Th??? L???i Sau!");
				}
				clearField();
			}
		} else if (object.equals(btnUpdate)) {
			if (tblEmployee.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Ch???n M???t Nh??n Vi??n Tr?????c Khi C???p Nh???t");
			} else if (isValidField()) {
				NhanVien employee = new NhanVien(Integer.parseInt(tfID.getText()), tfName.getText(),
						tfAddress.getText(), cbxGender.getSelectedItem().toString(),
						new java.sql.Date(dchDayOfBirth.getDate().getTime()), tfTel.getText());
				try {
					employeeDAO.update(employee, tfID.getText());
					defaultTableModel.removeRow(currentPostition);
					defaultTableModel.addRow(new Object[] { String.valueOf(employee.getMaNV()), employee.getTenNV(),
							employee.getDiaChi(), employee.getSdt(), simpleDateFormat.format(employee.getNgaySinh()),
							employee.getGioiTinh() });
					JOptionPane.showMessageDialog(null, "C???p Nh???t Nh??n Vi??n Th??nh C??ng!");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "C?? L???i X???y Ra, Vui L??ng Th??? L???i Sau!");
				}
				clearField();
			}
		} else if (object.equals(btnDelete)) {
			if (tblEmployee.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Ch???n M???t Nh??n Vi??n Tr?????c Khi X??a");
			} else {
				try {
					employeeDAO.delete(tfID.getText());
					defaultTableModel.removeRow(currentPostition);
					JOptionPane.showMessageDialog(null, "X??a Th??nh C??ng!");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "C?? L???i X???y Ra, Vui L??ng Th??? L???i Sau!");
				}
				clearField();
			}
		}
	}

	private boolean isValidField() {
		try {
			Integer.parseInt(tfID.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "M?? Nh??n Vi??n L?? B???t Bu???c V?? Ch??? Ch???a C??c S??? Nguy??n!");
			return false;
		}

		if (!tfName.getText()
				.matches("^(?:[\\p{L}\\p{Mn}\\p{Pd}\\'\\x{2019}]+\\s[\\p{L}\\p{Mn}\\p{Pd}\\'\\x{2019}]+\\s?)+$")) {
			JOptionPane.showMessageDialog(null, "T??n Nh??n Vi??n L?? B???t Bu???c Ch??? Ch???a Ch??? C??i V?? D???u C??ch!");
			return false;
		}

		if (!tfAddress.getText()
				.matches("^(?:[\\p{L}\\p{Mn}\\p{Pd}\\'\\x{2019}]+\\s[\\p{L}\\p{Mn}\\p{Pd}\\'\\x{2019}]+\\s?)+$")) {
			JOptionPane.showMessageDialog(null, "T???nh Th??nh L?? B???c Bu???c Ch??? Ch???a Ch??? C??i V?? D???u C??ch!");
			return false;
		}

		if (!tfTel.getText().matches("^[0-9]{10}$")) {
			JOptionPane.showMessageDialog(null, "S??? ??i???n Tho???i L?? B???t Bu???c V?? Ch???a 10 S???!");
			return false;
		}
		return true;
	}

	private void clearField() {
		tfID.setText("");
		tfName.setText("");
		tfAddress.setText("");
		tfTel.setText("");
	}
}

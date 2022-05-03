package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
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

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.NhanVien_DAO;
import entity.NhanVien;

@SuppressWarnings("serial")
public class GDQuanLyNhanVien extends JFrame implements ActionListener, MouseListener {
	private JPanel pnlControl;
	private JPanel pnlTask;
	private JPanel pnlContent;
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
		this.setSize(640, 480);
		this.setResizable(false);
		this.setTitle("Quản Lý Nhân Viên");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.add(pnlContent = new JPanel(), BorderLayout.CENTER);
		this.add(pnlControl = new JPanel(), BorderLayout.NORTH);

		String[] gender = { "Nam", "Nữ" };
		pnlControl.add(lblTitle = new JLabel("QUẢN LÝ NHÂN VIÊN", JLabel.CENTER));
		pnlControl.add(lblID = new JLabel("Mã Nhân Viên"));
		pnlControl.add(tfID = new JTextField(17));
		pnlControl.add(lblName = new JLabel("Tên Nhân Viên"));
		pnlControl.add(tfName = new JTextField(17));
		pnlControl.add(lblTel = new JLabel("Số Điện Thoại"));
		pnlControl.add(tfTel = new JTextField(17));
		pnlControl.add(lblAddress = new JLabel("Địa Chỉ"));
		pnlControl.add(tfAddress = new JTextField(17));
		pnlControl.add(lblDayOfBirth = new JLabel("Ngày Sinh"));
		pnlControl.add(dchDayOfBirth = new JDateChooser());
		pnlControl.add(lblGender = new JLabel("Giới Tính"));
		pnlControl.add(cbxGender = new JComboBox<String>(gender));
		pnlControl.add(pnlTask = new JPanel());

		pnlTask.add(tfSearch = new JTextField(17));
		pnlTask.add(btnSearch = new JButton("Tìm Kiếm"));
		pnlTask.add(btnAdd = new JButton("Thêm"));
		pnlTask.add(btnUpdate = new JButton("Cập Nhật"));
		pnlTask.add(btnDelete = new JButton("Xóa"));

		String[] header = { "Mã Nhân Viên", "Tên Nhân Viên", "Địa Chỉ", "Số Điện Thoại", "Ngày Sinh", "Giới Tính" };
		defaultTableModel = new DefaultTableModel(header, 0);
		pnlContent.add(new JScrollPane(tblEmployee = new JTable(defaultTableModel)));

		pnlControl.setPreferredSize(new Dimension(640, 180));
		pnlContent.setPreferredSize(new Dimension(640, 300));

		lblTitle.setPreferredSize(new Dimension(640, 35));
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
		tblEmployee.setPreferredScrollableViewportSize(new Dimension(620, 280));

		lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
		lblTitle.setForeground(Color.RED);

		pnlTask.setBorder(BorderFactory.createTitledBorder("Thao Tác Quản Lý: "));

		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new GDQuanLyNhanVien().setVisible(true);
	}

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
				JOptionPane.showMessageDialog(null, "Vui lòng điền mã nhân viên để tìm kiếm!");
			} else if (employeeDAO.findByID(tfSearch.getText()) == null) {
				JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin nhân viên!");
			} else {
				defaultTableModel.getDataVector().removeAllElements();
				defaultTableModel.addRow(new Object[] { String.valueOf(employee.getMaNV()), employee.getTenNV(),
						employee.getDiaChi(), employee.getSdt(), simpleDateFormat.format(employee.getNgaySinh()),
						employee.getGioiTinh() });
			}
		} else if (object.equals(btnAdd)) {
			if (employees.contains(new NhanVien(Integer.parseInt(tfID.getText())))) {
				JOptionPane.showMessageDialog(null, "Mã Nhân Viên Đã Tồn Tại!");
			} else if (isValidField()) {
				try {
					NhanVien employee = new NhanVien(Integer.parseInt(tfID.getText()), tfName.getText(),
							tfAddress.getText(), cbxGender.getSelectedItem().toString(),
							new java.sql.Date(dchDayOfBirth.getDate().getTime()), tfTel.getText());
					employeeDAO.add(employee);
					defaultTableModel.addRow(new Object[] { String.valueOf(employee.getMaNV()), employee.getTenNV(),
							employee.getDiaChi(), employee.getSdt(), simpleDateFormat.format(employee.getNgaySinh()),
							employee.getGioiTinh() });
					JOptionPane.showMessageDialog(null, "Thêm Nhân Viên Thành Công!");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Có Lỗi Xảy Ra, Vui Lòng Thử Lại Sau!");
				}
				clearField();
			}
		} else if (object.equals(btnUpdate)) {
			if (tblEmployee.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Chọn Một Nhân Viên Trước Khi Cập Nhật");
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
					JOptionPane.showMessageDialog(null, "Cập Nhật Nhân Viên Thành Công!");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Có Lỗi Xảy Ra, Vui Lòng Thử Lại Sau!");
				}
				clearField();
			}
		} else if (object.equals(btnDelete)) {
			if (tblEmployee.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Chọn Một Nhân Viên Trước Khi Xóa");
			} else {
				try {
					employeeDAO.delete(tfID.getText());
					defaultTableModel.removeRow(currentPostition);
					JOptionPane.showMessageDialog(null, "Xóa Thành Công!");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Có Lỗi Xảy Ra, Vui Lòng Thử Lại Sau!");
				}
				clearField();
			}
		}
	}

	private boolean isValidField() {
		try {
			Integer.parseInt(tfID.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Mã Nhân Viên Là Bắt Buộc Và Chỉ Chứa Các Số Nguyên!");
			return false;
		}

		if (!tfName.getText()
				.matches("^(?:[\\p{L}\\p{Mn}\\p{Pd}\\'\\x{2019}]+\\s[\\p{L}\\p{Mn}\\p{Pd}\\'\\x{2019}]+\\s?)+$")) {
			JOptionPane.showMessageDialog(null, "Tên Nhân Viên Là Bắt Buộc Chỉ Chứa Chữ Cái Và Dấu Cách!");
			return false;
		}

		if (!tfAddress.getText()
				.matches("^(?:[\\p{L}\\p{Mn}\\p{Pd}\\'\\x{2019}]+\\s[\\p{L}\\p{Mn}\\p{Pd}\\'\\x{2019}]+\\s?)+$")) {
			JOptionPane.showMessageDialog(null, "Tỉnh Thành Là Bắc Buộc Chỉ Chứa Chữ Cái Và Dấu Cách!");
			return false;
		}

		if (!tfTel.getText().matches("^[0-9]{10}$")) {
			JOptionPane.showMessageDialog(null, "Số Điện Thoại Là Bắt Buộc Và Chứa 10 Số!");
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

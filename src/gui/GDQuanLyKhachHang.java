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
		List<KhachHang> customers = customerDAO.getAll();
		for (KhachHang customer : customers) {
			defaultTableModel.addRow(new Object[] { customer.getMaKH(), customer.getTenKH(), customer.getSdt(),
					customer.getGioiTinh(), customer.getCmnd(), customer.getMaVe() });
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
		setLayout(new BorderLayout());
		//this.setResizable(false);
		//this.setTitle("Quản Lý Khách Hàng");
	//	this.setLocationRelativeTo(null);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.add(pnlContent = new JPanel(), BorderLayout.CENTER);
		this.add(pnlControl = new JPanel(), BorderLayout.NORTH);

		String[] gender = { "Nam", "Nữ" };
		pnlControl.add(lblTitle = new JLabel("QUẢN LÝ KHÁCH HÀNG", JLabel.CENTER));
		pnlControl.add(lblID = new JLabel("Mã Khách Hàng"));
		pnlControl.add(tfID = new JTextField(17));
		pnlControl.add(lblName = new JLabel("Tên Khách Hàng"));
		pnlControl.add(tfName = new JTextField(17));
		pnlControl.add(lblTel = new JLabel("Số Điện Thoại"));
		pnlControl.add(tfTel = new JTextField(17));
		pnlControl.add(lblCode = new JLabel("Số CMND"));
		pnlControl.add(tfCode = new JTextField(17));
		pnlControl.add(lblTourCode = new JLabel("Mã Tour"));
		pnlControl.add(tfTourCode = new JTextField(17));
		pnlControl.add(lblGender = new JLabel("Giới Tính"));
		pnlControl.add(cbxGender = new JComboBox<String>(gender));
		pnlControl.add(pnlTask = new JPanel());

		pnlTask.add(tfSearch = new JTextField(17));
		pnlTask.add(btnSearch = new JButton("Tìm Kiếm"));
		pnlTask.add(btnAdd = new JButton("Thêm"));
		pnlTask.add(btnUpdate = new JButton("Cập Nhật"));
		pnlTask.add(btnDelete = new JButton("Xóa"));

		String[] header = { "Mã Khách Hàng", "Tên Khách Hàng", "Số Điện Thoại", "Giới Tính", "Mã Định Danh", "Mã Vé" };
		defaultTableModel = new DefaultTableModel(header, 0);
		pnlContent.add(new JScrollPane(tblCustomer = new JTable(defaultTableModel)));

		pnlControl.setPreferredSize(new Dimension(640, 180));
		pnlContent.setPreferredSize(new Dimension(640, 300));

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
		tblCustomer.setPreferredScrollableViewportSize(new Dimension(620, 280));

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
		new GDQuanLyKhachHang().setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		currentPostition = tblCustomer.getSelectedRow();
		tfID.setText(String.valueOf(defaultTableModel.getValueAt(currentPostition, 0)));
		tfName.setText(String.valueOf(defaultTableModel.getValueAt(currentPostition, 1)));
		tfTel.setText(String.valueOf(defaultTableModel.getValueAt(currentPostition, 2)));
		cbxGender.setSelectedItem(String.valueOf(defaultTableModel.getValueAt(currentPostition, 3)));
		tfCode.setText(String.valueOf(defaultTableModel.getValueAt(currentPostition, 4)));
		tfTourCode.setText(String.valueOf(defaultTableModel.getValueAt(currentPostition, 5)));
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
				JOptionPane.showMessageDialog(null, "Vui lòng điền mã khách hàng để tìm kiếm!");
			} else if (customerDAO.findByID(tfSearch.getText()) == null) {
				JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin khách hàng!");
			} else {
				defaultTableModel.getDataVector().removeAllElements();
				defaultTableModel.addRow(new Object[] { customer.getMaKH(), customer.getTenKH(), customer.getSdt(),
						customer.getGioiTinh(), customer.getCmnd(), customer.getMaVe() });
			}
		} else if (object.equals(btnAdd)) {
			if (customers.contains(new KhachHang(Integer.parseInt(tfID.getText())))) {
				JOptionPane.showMessageDialog(null, "Mã Nhân Viên Đã Tồn Tại!");
			} else if (isValidField()) {
				try {
					KhachHang customer = new KhachHang(Integer.parseInt(tfID.getText()), tfName.getText(), tfTel.getText(),
							cbxGender.getSelectedItem().toString(), tfCode.getText());
					customerDAO.add(customer);
					defaultTableModel.addRow(new Object[] { customer.getMaKH(), customer.getTenKH(), customer.getSdt(),
							customer.getGioiTinh(), customer.getCmnd(), customer.getMaVe() });
					clearField();
					JOptionPane.showMessageDialog(null, "Thêm Khách Hàng Thành Công!");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Có Lỗi Xảy Ra, Vui Lòng Thử Lại Sau!");
				}
				clearField();
			}
			
		} else if (object.equals(btnUpdate)) {
			if (tblCustomer.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Chọn Một Khách Hàng Trước Khi Cập Nhật");
			} else if (isValidField()) {
				KhachHang customer = new KhachHang(Integer.parseInt(tfID.getText()), tfName.getText(), tfTel.getText(),
						cbxGender.getSelectedItem().toString(), tfCode.getText());
				try {
					customerDAO.update(customer, tfID.getText());
					defaultTableModel.removeRow(currentPostition);
					defaultTableModel.addRow(new Object[] { customer.getMaKH(), customer.getTenKH(), customer.getSdt(),
							customer.getGioiTinh(), customer.getCmnd(), customer.getMaVe() });
					clearField();
					JOptionPane.showMessageDialog(null, "Cập Nhật Thành Công!");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Có Lỗi Xảy Ra Trong Quá Tình Cập Nhật!");
				}

			}
		} else if (object.equals(btnDelete)) {
			if (tblCustomer.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Chọn Một Khách Hàng Trước Khi Xóa");
			} else {
				try {
					customerDAO.delete(tfID.getText());
					defaultTableModel.removeRow(currentPostition);
					JOptionPane.showMessageDialog(null, "Xóa Thành Công!");
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
			JOptionPane.showMessageDialog(null, "Mã Khách Hàng Là Bắt Buộc Và Chỉ Chứa Các Số Nguyên!");
			return false;
		}

		try {
			Integer.parseInt(tfTourCode.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Mã Vé Là Bắt Buộc Và Chỉ Chứa Số!");
			return false;
		}

		if (!tfName.getText()
				.matches("^(?:[\\p{L}\\p{Mn}\\p{Pd}\\'\\x{2019}]+\\s[\\p{L}\\p{Mn}\\p{Pd}\\'\\x{2019}]+\\s?)+$")) {
			JOptionPane.showMessageDialog(null, "Tên Khách Hàng Là Bắt Buộc Chỉ Chứa Chữ Cái Và Dấu Cách!");
			return false;
		}

		if (!tfCode.getText().matches("^[0-9]{8}$")) {
			JOptionPane.showMessageDialog(null, "Mã Định Danh Cá Nhân Là Bắt Buộc Và Chứa 8 Số!");
			return false;
		}

		if (!tfTel.getText().matches("^[0-9]{10}$")) {
			JOptionPane.showMessageDialog(null, "Số Điện Thoại Là Bắt Buộc Và Chứa 10 Số!");
			return false;
		}
		return true;
	}
}

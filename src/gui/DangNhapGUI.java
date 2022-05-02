package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.TaiKhoanDao;
import entity.TaiKhoan;

public class DangNhapGUI extends JFrame implements ActionListener, MouseListener {
	
	private JTextField txtDangNhap, txtMatKhau;
	private JLabel lblDangNhap, lblMatKhau, lblTieuDe;
	private JButton jbtDangNhap, jbtHuy;
	
	public DangNhapGUI () {
		setTitle("QUANLYTOUR");
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		JPanel pnDangNhap = new JPanel();
		pnDangNhap.setLayout(new BoxLayout(pnDangNhap, BoxLayout.Y_AXIS));
		
//		Tiêu đề 
		JPanel pnTieuDe = new JPanel();
		pnTieuDe.setLayout(new FlowLayout());
		lblTieuDe = new JLabel(" ĐĂNG NHẬP ");
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
		lblTieuDe.setForeground(Color.blue);
		pnTieuDe.add(lblTieuDe);
		pnDangNhap.add(pnTieuDe);
		
		
//		Tài khoản
		JPanel p1 = new JPanel();
//		p1.setLayout(new FlowLayout());
        JLabel lblDangNhap = new JLabel("Tên đăng nhập: ");
        txtDangNhap = new JTextField(20);
        p1.add(lblDangNhap);
        p1.add(txtDangNhap);
        pnDangNhap.add(p1);
        
//		Mật khẩu
		JPanel p2 = new JPanel();
        JLabel lblMatKhau = new JLabel("Mật khẩu: ");
        txtMatKhau = new JTextField(20);
        p2.add(lblMatKhau);
        p2.add(txtMatKhau);
        pnDangNhap.add(p2);

        lblMatKhau.setPreferredSize(lblDangNhap.getPreferredSize());
        
//		Button
        JPanel pnNut = new JPanel();
        pnNut.setLayout(new FlowLayout());
        jbtDangNhap = new JButton("Đăng nhập");
        jbtHuy = new JButton(" Hủy ");

//       
        jbtDangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {

        		TaiKhoanDao tkDao = new TaiKhoanDao();
        		
        		//lay ten dang nhap tren form
        		int tenDangNhap = Integer.parseInt(txtDangNhap.getText().toString().trim());
        		
        		//tim ten dang nhap trong DB
        		TaiKhoan tk =  tkDao.findTKByUserName(tenDangNhap);
        		
        		//neu co ten dang nhap -> kiem tra passworld
        		if(tk != null) {
        			String pass = txtMatKhau.getText();
        			if(pass.equals(tk.getMaKhau())) {
        				//dang nhap thanh cong
        				JOptionPane.showMessageDialog(lblMatKhau, "sucessfully" );
//viet code tiep o day
        				
        				
        			}
        			else {
        				//thong bao sai mat khau
        				JOptionPane.showMessageDialog(lblMatKhau, "passwold is not valid" );
        			}
        		}
        		else {
        			//thong bao sai
        			JOptionPane.showMessageDialog(lblMatKhau, "username is not valid" );
        		}
            }
        });
        
        jbtHuy.setBackground(Color.RED);
        
        jbtHuy.setPreferredSize(jbtDangNhap.getPreferredSize());
        
        pnNut.add(jbtDangNhap);
        pnNut.add(Box.createHorizontalStrut(5));
        pnNut.add(jbtHuy);
        
        pnDangNhap.add(pnNut);
        
		add(pnDangNhap);
		
	}
	
//	public static void main(String[] args) {
//		new DangNhapGUI().setVisible(true);
//	}
	
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

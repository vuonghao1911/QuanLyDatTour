package gui;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;

import connectDB.ConnectDB;
import dao.TaiKhoanDao;
import entity.TaiKhoan;
import shareData.ShareData;

public class DangNhapGUI extends JFrame  implements MouseListener, ActionListener{

	private JTextField txtDangNhap;
	private JPasswordField txtMatKhau;
	private JLabel lblDangNhap, lblMatKhau, lblTieuDe;
	private JButton jbtDangNhap, jbtHuy;
	private JCheckBox htmk;

	public DangNhapGUI () {
		setTitle("QUANLYTOUR");
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		JPanel pnDangNhap = new JPanel();
		pnDangNhap.setLayout(new BoxLayout(pnDangNhap, BoxLayout.Y_AXIS));
		FlatCyanLightIJTheme.setup();
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
        txtMatKhau = new JPasswordField(20);
        p2.add(lblMatKhau);
        p2.add(txtMatKhau);
        pnDangNhap.add(p2);

        lblMatKhau.setPreferredSize(lblDangNhap.getPreferredSize());
        
        JPanel pncheck = new JPanel();
        pncheck.setLayout(new FlowLayout());
        htmk = new JCheckBox("Hiển thị mật khẩu");
        pncheck.add(htmk);
        pnDangNhap.add(pncheck);
        
        htmk.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
			if(txtMatKhau.getText().equals("Mật khẩu")) 
			{
				txtMatKhau.setEchoChar((char)0);	
				htmk.setSelected(false);
				return ;
			}
			
			if(htmk.isSelected()) 
			{
	        	txtMatKhau.setEchoChar((char)0);
			}else {
				txtMatKhau.setEchoChar('*');
			}
        }
        });
        
	
        
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
//viet code tiep o day			
        					ShareData.taiKhoan = tk;
        					dispose();
        					new GDChinh().setVisible(true); 						
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
	
	public static void main(String[] args) {
		new DangNhapGUI().setVisible(true);
	}
	
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

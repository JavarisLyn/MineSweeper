package GUI;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import databse.Signin;
import databse.Signup;
import javafx.scene.shape.DrawMode;

class welcomepage {
	static JFrame welframe = new JFrame("WELCOME");
	static JButton qstart = new JButton("QUICK START");
	static JButton sigin = new JButton("SIGN IN");
	static JButton sigup = new JButton("SIGN UP");
	static JButton rank = new JButton("RANK");
	
	JTextField inname = new JTextField();
	JTextField inpsd = new JTextField();
	JTextField upname = new JTextField();
	JTextField uppsd = new JTextField();
	
	public void welUI()
	{
		//welframe.setVisible(true);
		//buttonֻ����껬���ǲ���ʾ�����������������
		welframe.setSize(300, 638);
		welframe.setLayout(null);
		welframe.setDefaultCloseOperation(welframe.EXIT_ON_CLOSE);
		Decorate decorate = new Decorate();
		decorate.decorate();
		
		qstart.setBounds(0, 0, 300, 140);
		sigin.setBounds(0, 140, 300, 160);
		sigup.setBounds(0, 300, 300, 160);
		rank.setBounds(0, 460, 300, 150);
		
		qstart.setFocusPainted(false);
		sigin.setFocusable(false);
		sigup.setFocusable(false);
		rank.setFocusable(false);
		
		welframe.add(qstart);
		welframe.add(sigin);
		welframe.add(sigup);
		welframe.add(rank);
		
		welframe.setVisible(true);
		
		qstart.addActionListener(new qsclicked());
		sigin.addActionListener(new signinclicked());
		sigup.addActionListener(new signupclicked());
		rank.addActionListener(new rankclicked());
		
		
	}
	
	class qsclicked  implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			welframe.dispose();
			
			Runnable runnable = new mainrun();
			Thread thread = new Thread(runnable);
			thread.start();
			
			Runnable trun = new timerun();
			Thread thread2 = new Thread(trun);
			thread2.start();
		}
	
	}
	
	//*****************************
	class signinclicked  implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JFrame signinframe = new JFrame("SIGN IN");
			signinframe.setLayout(null);
			signinframe.setVisible(true);
			signinframe.setDefaultCloseOperation(signinframe.EXIT_ON_CLOSE);
			signinframe.setDefaultCloseOperation(signinframe.DISPOSE_ON_CLOSE);
			signinframe.setSize(400,300);		

			signinframe.setLocationRelativeTo(null);
			
//			JTextField name = new JTextField();
//			JTextField psd = new JTextField();
			inname.setBounds(100, 50, 200, 30);
			
			inname.setText("�û���");
			inname.addFocusListener(new FocusAdapter()
	        {
	            @Override
	            public void focusGained(FocusEvent e)
	            {
	               inname.setText("");
	            }
//	            @Override
//	            public void focusLost(FocusEvent e)
//	            {
//	                namet.setText("ss");
//	            }
	        });
			
			inpsd.setText("����");
			inpsd.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e)
				{
					inpsd.setText("");
				}
			});
			signinframe.requestFocus();
			
			inpsd.setBounds(100, 110, 200, 30);
			signinframe.add(inname);
			signinframe.add(inpsd);
			JButton signin = new JButton("SIGN IN");
			signin.setBounds(100, 170, 200, 30);
			signin.setFocusPainted(false);
			signin.addActionListener(new signed(signinframe));
			signinframe.add(signin);
			
		}
		
	}
	
	class signupclicked implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JFrame signupframe = new JFrame("SIGN UP");
			signupframe.setLayout(null);
			signupframe.setVisible(true);
			signupframe.setDefaultCloseOperation(signupframe.EXIT_ON_CLOSE);
			signupframe.setDefaultCloseOperation(welframe.DISPOSE_ON_CLOSE);
			signupframe.setSize(400,300);		

			signupframe.setLocationRelativeTo(null);
			
			upname.setBounds(100, 50, 200, 30);
			
			upname.setText("�û���");
			upname.addFocusListener(new FocusAdapter()
	        {
	            @Override
	            public void focusGained(FocusEvent e)
	            {
	               upname.setText("");
	            }
	        });
			
			uppsd.setText("����");
			uppsd.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e)
				{
					uppsd.setText("");
				}
			});
			signupframe.requestFocus();
		
			
			uppsd.setBounds(100, 110, 200, 30);
			signupframe.add(upname);
			signupframe.add(uppsd);
			JButton signup = new JButton("SIGN UP");
			signup.addActionListener(new user_info(signupframe));
			signup.setBounds(100, 170, 200, 30);
			signup.setFocusPainted(false);
			signupframe.add(signup);
			
			
		}
		
	}
	
	class user_info implements ActionListener
	{
		JFrame frmae = new JFrame();
		public user_info(JFrame tempframe)
		{
			frmae=tempframe;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println(upname.getText());
			Signup signuped= new Signup(upname.getText(),uppsd.getText(),frmae);
			signuped.savainfo();
		}
		
	}
	
	class signed implements ActionListener
	{
		JFrame Frame =new JFrame();
		public  signed(JFrame jFrame) {
			// TODO Auto-generated constructor stub
			Frame=jFrame;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Signin signined = new Signin(inname.getText(), inpsd.getText(), Frame);
			signined.signed();
		}
		
	}
	
	class rankclicked implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			maketable ranklist= new maketable();
			System.out.println("sss");
			ranklist.Show();
		}
		
	}
	//��Ϸ�������а�
	class maketable extends JFrame
	{
		private JScrollPane scpDemo;
		private JTableHeader jth;
		private JTable tabDemo;

		public maketable(){
	
			super("RANK");
			this.setSize(330,400);
			//this.setLayout(null);
			this.setLocation(100,50);
			
			this.scpDemo = new JScrollPane();
			this.scpDemo.setBounds(10,50,300,270);
			
			scpDemo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//��ֱ������
		    scpDemo.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//		    
		
			add(this.scpDemo);
		
			this.setVisible(true);
		}
		//�˴������飺��ʼʱ��������Ϊshow�����̳еĸ���WINDOW������Ϊshow�ķ�����������ʵ��д�˸���ķ�����ÿ��
		//��ʼ������ʱϵͳ�����show���������Գ���
		public void Show(){
			System.out.println("s");
		try{
	        Connection ct=null;
	        ResultSet rs=null;
	        String url = "jdbc:mysql://cdb-mjtujujs.bj.tencentcdb.com:10057/MineSweeper";
	        String user="root";  //��������Ա
	        String password="javaris0801";  //����

	        try {
	            //1.��������
	            Class.forName("com.mysql.jdbc.Driver");
	            System.out.println("���������ɹ���");
	        }catch(Exception e) {
	            e.printStackTrace();
	            System.out.println("��������ʧ�ܣ�");
	        }
	        try {  
	            //2.����
	            ct=DriverManager.getConnection( url,user,password);
	            System.out.println("�������ݿ�ɹ���");
	        }catch(Exception e) {
	            e.printStackTrace();
	            System.out.println("�������ݿ�ʧ�ܣ�");
	        
	        }
		// �����ж�������¼
			int count = 0;
			String sql = " SELECT ID,AVG(time) AS GTIME,AVG(rate) AS GRATE FROM game_stats GROUP BY id ORDER BY AVG(rate) DESC";  
			PreparedStatement pst = ct.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);  
			rs=pst.executeQuery();
			while(rs.next()){
			count++;
			}
			rs = pst.executeQuery();
			// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
			Object[][] info = new Object[count][4];
			count = 0;
			while(rs.next()){
			info[count][0] = rs.getString("ID");
			info[count][1] = rs.getString("GTIME");
			info[count][2] = rs.getString("GRATE");
			count++;
			}
			// �����ͷ
			String[] title = {"ID","TIME(s)","RATE"};
			// ����JTable
			this.tabDemo = new JTable(info,title);
			// ��ʾ��ͷ
			this.jth = this.tabDemo.getTableHeader();
			// ��JTable���뵽���������������
			this.scpDemo.getViewport().add(tabDemo); 
		}
		catch(SQLException sqle){
			JOptionPane.showMessageDialog(null,"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
		}
		}
	
	}
}

	

package databse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import GUI.main;


public class Signin {
	public JFrame frame = new JFrame();
	public String id;
	public String psd;
	
	public Signin(String ID,String PSD,JFrame jFrame)
	{
		frame=jFrame;
		id=ID;
		psd=PSD;
	}
	
	public void signed()
	{
		PreparedStatement ps=null;      //(����Ҳ����ʹ��statement,���������)
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

		try {
			int count=0;
        String sql = "select * from user_info where user_id=? and user_psd=?";  
        PreparedStatement pst = ct.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);  
        pst.setString(1,id);
       pst.setString(2, psd);

        rs=pst.executeQuery();
        while(rs.next()){
			count++;
			}
        if(count!=0)
        {
        	//JOptionPane.showMessageDialog(frame, "��¼�ɹ�", null, 0);
        	System.out.println(id+psd);
        	pst.close(); 
            frame.dispose();
            
            main.userid=id;
            main.userpsd=psd;
        }
        else {
        	JOptionPane.showMessageDialog(frame, "�û������������", null, 0);
        }
        
		} 
        catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//JOptionPane.showMessageDialog(null, "�û��������ظ���Ϊ��", null, 0);
		}
        //д�������ݵ�SQL���
       


	}
}


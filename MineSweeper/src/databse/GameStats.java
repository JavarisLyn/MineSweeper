package databse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GameStats {
	public String id;
	public long time;
	public float grate;
	
	public GameStats(String ID,long TIME,float rate)
	{
		id=ID;
		time=TIME;
		grate=rate;
	}
	
	public void update()
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
			
        String sql = "INSERT INTO game_stats VALUES(?,?,?)";  
        PreparedStatement pst = ct.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);  
        pst.setString(1,id);
        pst.setLong(2, time);
        pst.setFloat(3, grate);
        pst.executeUpdate();  
        pst.close(); 
        System.out.println("������Ϸ���ݳɹ�");
//        PreparedStatement stmt = ct.prepareStatement(sql);
//        boolean flag = stmt.execute();
//        boolean flag=pst.execute();
//        
//        if(flag==true)
//        {
//        	JOptionPane.showMessageDialog(frame, "��½�ɹ�", null, 0);
//        	pst.close(); 
//            frame.dispose();
//        }
//        else {
//        	JOptionPane.showMessageDialog(frame, "�û������������", null, 0);
//        }
//        
		} 
        catch (SQLException e) {
			// TODO Auto-generated catch block
        	System.out.println("��¼��Ϸ����ʧ��");
			e.printStackTrace();
			//JOptionPane.showMessageDialog(null, "�û��������ظ���Ϊ��", null, 0);
		}
        //д�������ݵ�SQL���
       


	}
}



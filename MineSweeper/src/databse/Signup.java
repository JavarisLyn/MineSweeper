package databse;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Signup {
	public String id;
	public String psd;
	public JFrame upFrame  = new JFrame();
	
	public Signup(String ID,String PSD,JFrame frame)
	{
		id=ID;
		psd=PSD;
		upFrame=frame;
	}
	
	public void savainfo() {
        // TODO Auto-generated method stub
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
        String sql = "insert into user_info values(?,?) ";  
        PreparedStatement pst = ct.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);  
        pst.setString(1,id);
        pst.setString(2, psd);
        pst.executeUpdate();  
        pst.close(); 
        JOptionPane.showMessageDialog(upFrame, "ע��ɹ�", null, 0);
        upFrame.dispose();
		} 
        catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(upFrame, "�û��������ظ���Ϊ��", null, 0);
		}
        //д�������ݵ�SQL���
       


	}
}

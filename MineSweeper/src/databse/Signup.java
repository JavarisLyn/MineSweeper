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
        PreparedStatement ps=null;      //(这里也可以使用statement,视情况而定)
        Connection ct=null;
        ResultSet rs=null;
        
        String url = "jdbc:mysql://cdb-mjtujujs.bj.tencentcdb.com:10057/MineSweeper";
        String user="root";  //超级管理员
        String password="javaris0801";  //密码

        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("加载驱动成功！");
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("加载驱动失败！");
        }
        try {  
            //2.连接
            ct=DriverManager.getConnection( url,user,password);
            System.out.println("连接数据库成功！");
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("连接数据库失败！");
        }

		try {
        String sql = "insert into user_info values(?,?) ";  
        PreparedStatement pst = ct.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);  
        pst.setString(1,id);
        pst.setString(2, psd);
        pst.executeUpdate();  
        pst.close(); 
        JOptionPane.showMessageDialog(upFrame, "注册成功", null, 0);
        upFrame.dispose();
		} 
        catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(upFrame, "用户名不能重复或为空", null, 0);
		}
        //写插入数据的SQL语句
       


	}
}

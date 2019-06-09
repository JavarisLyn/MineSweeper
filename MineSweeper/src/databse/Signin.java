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
        	//JOptionPane.showMessageDialog(frame, "登录成功", null, 0);
        	System.out.println(id+psd);
        	pst.close(); 
            frame.dispose();
            
            main.userid=id;
            main.userpsd=psd;
        }
        else {
        	JOptionPane.showMessageDialog(frame, "用户名或密码错误", null, 0);
        }
        
		} 
        catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//JOptionPane.showMessageDialog(null, "用户名不能重复或为空", null, 0);
		}
        //写插入数据的SQL语句
       


	}
}


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
			
        String sql = "INSERT INTO game_stats VALUES(?,?,?)";  
        PreparedStatement pst = ct.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);  
        pst.setString(1,id);
        pst.setLong(2, time);
        pst.setFloat(3, grate);
        pst.executeUpdate();  
        pst.close(); 
        System.out.println("插入游戏数据成功");
//        PreparedStatement stmt = ct.prepareStatement(sql);
//        boolean flag = stmt.execute();
//        boolean flag=pst.execute();
//        
//        if(flag==true)
//        {
//        	JOptionPane.showMessageDialog(frame, "登陆成功", null, 0);
//        	pst.close(); 
//            frame.dispose();
//        }
//        else {
//        	JOptionPane.showMessageDialog(frame, "用户名或密码错误", null, 0);
//        }
//        
		} 
        catch (SQLException e) {
			// TODO Auto-generated catch block
        	System.out.println("记录游戏数据失败");
			e.printStackTrace();
			//JOptionPane.showMessageDialog(null, "用户名不能重复或为空", null, 0);
		}
        //写插入数据的SQL语句
       


	}
}



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
inport java.sql.SQLExcepttion;

private void okMouseClick(java.awt.event.MouseEvent) 
	{
	string url="jdbc:mysql://localhost:3306/commodity";
	string user="root";
	string password="0000";
	string sql="insert into shoes(name,price,quantity) values(?,?,?,?)";

	try{
	Connection conn=DriverManager.gerconnection(url,user,password);
	PreparedStatement ps=conn.preparestament(sql);
	
	ps.setString(1, red_sneakers);
	ps.setInt(2, 1500);
	ps.setInt(3, 200);

	System.out.print("ok");}
	catch (SQLExcepttion e)
	{System.out.print("no")}
	
	 }
	
package site;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class SiteBbsDAO {
	
	public void insert(SiteBbsDTO dto) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/site";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		String sql = "insert into bbs values (?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getBid());
		ps.setString(2, dto.getPw());
		ps.setString(3, dto.getTitle());
		ps.setString(4, dto.getContent());
		ps.setString(5, dto.getBbsDate());
		
		ps.executeUpdate();
		System.out.println("SQL");
	}
		
		public ArrayList<SiteBbsDTO> selectAll() throws Exception {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/site";
			String user = "root";
			String password = "1234";

			Connection con = DriverManager.getConnection(url, user, password);

			String sql = "select * from bbs";
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			System.out.println("start " + rs.getRow());
			
			
			
			SiteBbsDTO dto = null;
			ArrayList<SiteBbsDTO> list = new ArrayList<>();
			
			while (rs.next()) {
				System.out.println("row: " + rs.getRow());
				dto = new SiteBbsDTO();

				String bid = rs.getString(1);
				String pw = rs.getString(2);
				String title = rs.getString(3);
				String content = rs.getString(4);
				String bbsDate = rs.getString(5);

				dto.setBid(bid);
				dto.setPw(pw);
				dto.setTitle(title);
				dto.setContent(content);
				dto.setBbsDate(bbsDate);
				
				list.add(dto);
				System.out.println();
			}
			return list;
		}

		public SiteBbsDTO select(String input) throws Exception {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/site";
			String user = "root";
			String password = "1234";

			Connection con = DriverManager.getConnection(url, user, password);

			String sql = "select * from bbs where bid = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, input);

			ResultSet rs = ps.executeQuery();
			SiteBbsDTO dto = null;
			while (rs.next()) { 
				dto = new SiteBbsDTO();

				String bid = rs.getString(1);
				String pw = rs.getString(2);
				String title = rs.getString(3);
				String content = rs.getString(4);
				String bbsDate = rs.getString(5);

				dto.setBid(bid);
				dto.setPw(pw);
				dto.setTitle(title);
				dto.setContent(content);
				dto.setBbsDate(bbsDate);
				
			}
			return dto;
		}
		
		

}



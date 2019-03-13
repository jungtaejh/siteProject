package site;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class SiteDAO {
	public boolean login(String id) throws Exception {
		// 1. 드라이버(connector) 셋팅
		Class.forName("com.mysql.jdbc.Driver");

		// 2. DB연결(->my서버설정+db명+id+pw)
		String url = "jdbc:mysql://localhost:3306/site";
		String user = "root";
		String password = "1234";

		Connection con = DriverManager.getConnection(url, user, password);

		// 3. SQL문 객체화
		String sql = "select * from siteMember where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		
		// 4. SQL문 실행 요청
		ResultSet rs = ps.executeQuery();
		SiteDTO dto = null;
		boolean result = false;
		if (rs.next()) { // 커서를 옮겨서 레코드가 있는지 체크
			result = true;
		}
		return result;
	}
	
	
	public void update(SiteDTO dto) throws Exception {
		//1. 드라이버(connector) 셋팅
		Class.forName("com.mysql.jdbc.Driver");
		
		//2. DB연결(->my서버설정+db명+id+pw)
		String url = "jdbc:mysql://localhost:3306/site";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		//3. SQL문 객체화
		String sql = "update siteMember set name = ?, addr = ? where id = ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(3, dto.getId());
		ps.setString(1, dto.getName());
		ps.setString(2, dto.getAddr());
		
		//4. SQL문 실행 요청
		ps.executeUpdate();
		System.out.println("SQL문 요청 완료..");
	}
	public void delete(String id) throws Exception {
		//1. 드라이버(connector) 셋팅
		Class.forName("com.mysql.jdbc.Driver");
		
		//2. DB연결(->my서버설정+db명+id+pw)
		String url = "jdbc:mysql://localhost:3306/site";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		//3. SQL문 객체화
		String sql = "delete from siteMember where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);

		
		//4. SQL문 실행 요청
		ps.executeUpdate();
		System.out.println("SQL문 요청 완료..");
	}
	
	public void insert(SiteDTO dto) throws Exception {
		//1. 드라이버(connector) 셋팅
		Class.forName("com.mysql.jdbc.Driver");
		
		//2. DB연결(->my서버설정+db명+id+pw)
		String url = "jdbc:mysql://localhost:3306/site";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		//3. SQL문 객체화
		String sql = "insert into siteMember values (?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getPw());
		ps.setString(3, dto.getName());
		ps.setString(4, dto.getTel());
		ps.setString(5, dto.getAddr());
		ps.setString(6, dto.getFavorite());
		
		//4. SQL문 실행 요청
		ps.executeUpdate();
		System.out.println("SQL문 요청 완료..");
	}
		
		public ArrayList<SiteDTO> selectAll() throws Exception {
			// 1. 드라이버(connector) 셋팅
			Class.forName("com.mysql.jdbc.Driver");

			// 2. DB연결(->my서버설정+db명+id+pw)
			String url = "jdbc:mysql://localhost:3306/site";
			String user = "root";
			String password = "1234";

			Connection con = DriverManager.getConnection(url, user, password);

			// 3. SQL문 객체화
			String sql = "select * from siteMember";
			PreparedStatement ps = con.prepareStatement(sql);

			// 4. SQL문 실행 요청
			ResultSet rs = ps.executeQuery();
			System.out.println("start " + rs.getRow());
			
			//해당 row index의 값이 존재하는가? 체크..
			//System.out.println(rs.first());
			//System.out.println(rs.absolute(1));
			
			//해당 ResultSet의 갯수를 구하는 방법..==========
			//rs의 맨 끝으로 이동
			//rs.last();
			//그 맨 끝의 getRow()를 출력
			//System.out.println("레코드의 갯수는 " + rs.getRow());
			
			
			SiteDTO dto = null;
			ArrayList<SiteDTO> list = new ArrayList<>();
			
			while (rs.next()) { // 커서를 옮겨서 레코드가 있는지 체크
				System.out.println("row: " + rs.getRow());
				dto = new SiteDTO();

				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				String tel = rs.getString(4);
				String addr = rs.getString(5);
				String favorite = rs.getString(6);

				dto.setId(id);
				dto.setPw(pw);
				dto.setName(name);
				dto.setTel(tel);
				dto.setAddr(addr);
				dto.setFavorite(favorite);
				
				list.add(dto);
				System.out.println();
			}
			return list;
		}

		public SiteDTO select(String input) throws Exception {
			// 1. 드라이버(connector) 셋팅
			Class.forName("com.mysql.jdbc.Driver");

			// 2. DB연결(->my서버설정+db명+id+pw)
			String url = "jdbc:mysql://localhost:3306/site";
			String user = "root";
			String password = "1234";

			Connection con = DriverManager.getConnection(url, user, password);

			// 3. SQL문 객체화
			String sql = "select * from siteMember where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, input);

			// 4. SQL문 실행 요청
			ResultSet rs = ps.executeQuery();
			SiteDTO dto = null;
			while (rs.next()) { // 커서를 옮겨서 레코드가 있는지 체크
				dto = new SiteDTO();

				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				String tel = rs.getString(4);
				String addr = rs.getString(5);
				String favorite = rs.getString(6);

				dto.setId(id);
				dto.setPw(pw);
				dto.setName(name);
				dto.setTel(tel);
				dto.setAddr(addr);
				dto.setFavorite(favorite);
			}
			return dto;
		}
		
		

}



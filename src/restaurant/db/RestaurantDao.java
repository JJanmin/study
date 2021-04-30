package restaurant.db;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import oracle.db.DbConnect;

public class RestaurantDao {
	DbConnect db= new DbConnect();
	public List<RestaurantDto> getAllDatas()
	{
		List<RestaurantDto>list= new Vector<RestaurantDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from restaurant order by num desc";
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				RestaurantDto dto=new RestaurantDto();
				dto.setNum(rs.getString("num"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				dto.setStar(rs.getString("star"));
				dto.setContent(rs.getString("content"));
				dto.setImage(rs.getString("Image"));
				dto.setWriter(rs.getString("writer"));
				dto.setPass(rs.getString("pass"));
				

				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.dbclose(rs, pstmt, conn);
		}
		return list;
	}
	//�κ� ��� list
	/*public List<RestaurantDto> getPagingDatas(int start)
	{
		List<RestaurantDto>list= new Vector<RestaurantDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select a.* from (select rownum as rnum,b.* from "
				+ "(select * from restaurant order by num desc)b)a where a.RNUM>=? and a.RNUM<=?";
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//���ε�
			pstmt.setInt(1, start);
			pstmt.setInt(2, start+4);
			//����
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				RestaurantDto dto=new RestaurantDto();
				dto.setNum(rs.getString("num"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				dto.setStar(rs.getString("star"));
				dto.setContent(rs.getString("content"));
				dto.setImage(rs.getString("Image"));
				dto.setWriter(rs.getString("writer"));
				dto.setPass(rs.getString("pass"));
				
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbclose(rs, pstmt, conn);
		}
		return list;
	}*/
	//��ü ���� ���ϴ� �޼���
			public int getTotalCount() {
				Connection conn=null;
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				
				conn=db.getConnection();
				String sql="select count(*) from restaurant";
				int total=0;
				try {
					pstmt=conn.prepareStatement(sql);
					rs=pstmt.executeQuery();
					if(rs.next())
						total=rs.getInt(1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					db.dbclose(rs,pstmt,conn);
				}
				return total;
		}
			
			
		
	//�߰� addform
	public void insertRestaurant(RestaurantDto dto)
	{
		Connection conn = null;
		PreparedStatement pstmt=null;
		String sql="insert into restaurant values (seq2.nextval," + "?,?,?,?,?,?,?)";
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//���ε�
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setString(3, dto.getStar());
			pstmt.setString(4, dto.getContent());
			pstmt.setString(5, dto.getImage());
			pstmt.setString(6, dto.getWriter());
			pstmt.setString(7, dto.getPass());
			//����
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbclose(pstmt, conn);
		}
	}
	public RestaurantDto getData(String num){
		RestaurantDto dto =new RestaurantDto(); 
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from restaurant where num=?";
		
		//db ����
		conn=db.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			//���ε�
			pstmt.setString(1, num);
			//rs �� ��´�
			rs=pstmt.executeQuery();
			
			if(rs.next())//�����Ͱ� �Ѱ��� while ���� �ʿ� x ������ ������ ���� ���� ������ if�� �ִ´�
			{
				dto.setNum(rs.getString("num"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				dto.setStar(rs.getString("star"));
				dto.setContent(rs.getString("content"));
				dto.setImage(rs.getString("image"));
				dto.setWriter(rs.getString("writer"));
				dto.setPass(rs.getString("pass"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbclose(rs, pstmt, conn);
		}
		
		return dto;
		
	}
	//��� Ȯ��
	public boolean isPassCheck(String num,String pass) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		conn=db.getConnection();
		String sql="select count(*) from restaurant where num=? and pass=?";
		
		int r=0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.setString(2, pass);
			rs=pstmt.executeQuery();
			if(rs.next())
				r=rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbclose(rs, pstmt, conn);
		}
		return r==1?true:false;
	}

	
	//����
	public void deleterestaurant(String num) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		conn=db.getConnection();
		String sql="delete from restaurant where num=?";
		
		int r=0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbclose(pstmt, conn);
		}		

	}
	
			//����
			public void updateRestaurant(RestaurantDto dto) {
				Connection conn=null;
				PreparedStatement pstmt=null;
				String sql="update restaurant set name=?,addr=?,star=?,content=?,image=?,writer=? where num=?";
				System.out.println(dto.getNum());
				conn=db.getConnection();
				try {
					pstmt=conn.prepareStatement(sql);
					//���ε�
					pstmt.setString(1, dto.getName());
					pstmt.setString(2, dto.getAddr());
					pstmt.setString(3, dto.getStar());
					pstmt.setString(4, dto.getContent());
					pstmt.setString(5, dto.getImage());
					pstmt.setString(6, dto.getWriter());
					pstmt.setString(7, dto.getNum());
					//����
					pstmt.execute(); 
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					db.dbclose(pstmt, conn);
				}
			}
		}
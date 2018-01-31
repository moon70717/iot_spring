package si.mp.le.user.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import si.mp.le.user.vo.User;

@Repository
public class UserDAO {

	@Autowired
	private JdbcTemplate jt;
	
	@Autowired
	private User user;
	
	public User selectUser() {
		String sql="select * from user_info where uino=1";
		return (User)jt.queryForObject(sql, new BeanPropertyRowMapper(User.class));
	}
	
	public List<User> selectUserList(){
		List<User> userList=new ArrayList<User>();
		String sql="select * from user_info";
		List<Map<String,Object>> list=jt.queryForList(sql);
		System.out.println(list);
		for(Map<String,Object> m:list) {
			User u=new User();
			u.setUiAge((Integer)m.get("uiage"));
			u.setUiName((String)m.get("uiname"));
			userList.add(u);
		}
		return userList;
	}
	
	public int insertUser() {
		String sql="insert into user_info(uiname,uiage,uiid,uipwd,cino,uiregdate,address) values(?,?,?,?,?,now(),?)";
		int result=0;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("uiname", "이름");
		param.put("uiage", 33);
		param.put("uiid", "id");
		param.put("uipwd", "uipwd");
		param.put("cino", 2);
		param.put("address", "주소");
		PreparedStatementSetter pss=new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
			}
		};
		result=jt.update(sql, param);
		
		return result;
	}
}

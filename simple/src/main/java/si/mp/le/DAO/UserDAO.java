package si.mp.le.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import si.mp.le.common.DBCon;
import si.mp.le.vo.User;

@Repository
public class UserDAO {

	@Autowired
	private JdbcTemplate jt;
	
	@Autowired
	private DBCon dbc;
	@Autowired
	private User user;
	
	public User selectUser() {
		System.out.println(dbc.getConnection());
		String sql="select * from user_info where uino=1";
		return (User)jt.queryForObject(sql, new BeanPropertyRowMapper(User.class));
	}
	
	public List<User> selectUserList(){
		List<User> userList=new ArrayList<User>();
		String sql="select * from user_info";
		List<Map<String,Object>> list=jt.queryForList(sql);
		System.out.println(list);
		/*userList=jt.queryForObject(sql, new BeanPropertyRowMapper(User.class));
		for(int i=0;i<10;i++) {
			User uus=new User();
			userList.add(uus);
		}*/
		
		
		return userList;
	}
}

package si.mp.le.emp;

import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmpDAO {

	private JdbcTemplate jt;

	public void setJdbcTemplate(JdbcTemplate jt) {
		this.jt = jt;
	}

	public void test() {
		try {
			jt.getDataSource().getConnection();
			System.out.println("연결성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Emp> selectEmpList() {
		String sql = "select * from emp";
		return jt.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
	}

	public Emp selectEmp(Emp e) {
		String sql = "select * from emp where empno=?";
		return jt.queryForObject(sql, new Object[] { e.getEmpNo() }, new BeanPropertyRowMapper<Emp>(Emp.class));
	}

	public int insertEmp(Emp e) {
		String sql = "insert into emp(empName,empSal)values(?,?)";
		Object[] param = { e.getEmpName(), e.getEmpSal() };
		return jt.update(sql, param);
	}

	public int updateEmp(Emp e) {
		String sql = "update emp set empName=?,empSal=? where empNo=?";
		Object[] param = { e.getEmpName(), e.getEmpSal(), e.getEmpNo() };
		return jt.update(sql, param);
	}

	public int deleteEmp(Emp e) {
		String sql = "delete from emp where empNo=?";
		Object[] param = { e.getEmpNo() };
		return jt.update(sql, param);
	}
}

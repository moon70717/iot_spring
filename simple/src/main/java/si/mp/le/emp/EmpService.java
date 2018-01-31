package si.mp.le.emp;

import java.util.List;

public class EmpService {

	private EmpDAO eDAO;
	
	public void seteDAO(EmpDAO eDAO) {
		this.eDAO = eDAO;
	}

	public List<Emp> selectEmpList() {
		return eDAO.selectEmpList(); 
	}
	public Emp selectEmp(Emp e) {
		return eDAO.selectEmp(e);
	}
	
	public int insertEmp(Emp e) {
		return eDAO.insertEmp(e);
	}
	
	public int updateEmp(Emp e) {
		return eDAO.updateEmp(e);
	}
	
	public int deleteEmp(Emp e) {
		return eDAO.deleteEmp(e);
	}
}

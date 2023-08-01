package json.service;

import java.util.List;

import json.dao.ILprodDao;
import json.dao.LprodDaoImpl;
import vo.LprodVO;

public class LprodServiceImpl implements ILprodService{
	
	private static LprodServiceImpl service;
	private LprodServiceImpl() {}
	
	public static LprodServiceImpl getInstance() {
		if(service==null) service=new LprodServiceImpl();
		return service;
	}
	
	ILprodDao dao = LprodDaoImpl.getInstance();
	
	@Override
	public List<LprodVO> getLprod() {
		return dao.getLprod();
	}
	
	
}

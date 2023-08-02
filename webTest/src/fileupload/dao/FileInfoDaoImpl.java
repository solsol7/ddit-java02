package fileupload.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import util.MybatisUtil;
import vo.FileInfoVO;

public class FileInfoDaoImpl implements IFileInfoDao {
	
	private static FileInfoDaoImpl dao;
	
	private FileInfoDaoImpl() {}
	
	public static FileInfoDaoImpl getInstance() {
		if(dao==null) dao = new FileInfoDaoImpl();
		return dao;
	}

	@Override
	public int insertFileInfo(FileInfoVO fileVo) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("fileinfo.insertFileinfo", fileVo);
			if(cnt>0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		
		return cnt;
	}

	@Override
	public List<FileInfoVO> getAllFileInfo() {
		SqlSession session = null;
		List<FileInfoVO> fileList = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			fileList = session.selectList("fileinfo.getAllFileinfo");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		
		return fileList;
	}

	@Override
	public FileInfoVO getFileInfo(int fileNo) {
		SqlSession session = null;
		FileInfoVO fileVo = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			fileVo = session.selectOne("fileinfo.getFileinfo",fileNo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		
		return fileVo;
	}

}

package fileupload.service;

import java.util.List;

import fileupload.dao.FileInfoDaoImpl;
import fileupload.dao.IFileInfoDao;
import vo.FileInfoVO;

public class FileInfoServiceImpl implements IFileInfoService {

	private IFileInfoDao dao;
	
	private static FileInfoServiceImpl service;
	
	private FileInfoServiceImpl() {
		dao = FileInfoDaoImpl.getInstance();
	}
	
	public static FileInfoServiceImpl getInstance() {
		if(service==null) service = new FileInfoServiceImpl();
		return service;
	}
	
	@Override
	public int insertFileInfo(FileInfoVO fileVo) {
		return dao.insertFileInfo(fileVo);
	}

	@Override
	public List<FileInfoVO> getAllFileInfo() {
		return dao.getAllFileInfo();
	}

	@Override
	public FileInfoVO getFileInfo(int fileNo) {
		return dao.getFileInfo(fileNo);
	}

}

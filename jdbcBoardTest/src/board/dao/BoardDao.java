package board.dao;

import java.util.Map;

public interface BoardDao {
	public void write(String title, String writer, String content);
	
	public Map<String, Object> read(int no);
	
	public Map<String, Object> search(String title);
	
	public int update(int no);
	
	public int delete(int no);
}

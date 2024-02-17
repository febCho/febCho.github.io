package kr.spring.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.board.vo.BoardFavVO;
import kr.spring.board.vo.BoardReplyVO;
import kr.spring.board.vo.BoardVO;

@Mapper
public interface BoardMapper {
	//부모글
	public List<BoardVO> selectList(Map<String,Object> map);
	public int selectRowCount(Map<String,Object> map);
	public void insertBoard(BoardVO board);
	public BoardVO selectBoard(int board_num);
	@Update("UPDATE spboard SET hit=hit+1 WHERE board_num=#{board_num}")
	public void updateHit(int board_num);
	public void updateBoard(BoardVO board);
	@Delete("DELETE FROM spboard WHERE board_num=#{board_num}")
	public void deleteBoard(int board_num);
	@Update("UPDATE spboard SET filename='' WHERE board_num=#{board_num}")
	public void deleteFile(int board_num);
	
	//좋아요
	@Select("SELECT * FROM spboard_fav WHERE board_num=#{board_num} AND mem_num=#{mem_num}")
	public BoardFavVO selectFav(BoardFavVO fav);
	@Select("SELECT COUNT(*) FROM spboard_fav WHERE board_num=#{board_num}")
	public int selectFavCount(int board_num);
	@Insert("INSERT INTO spboard_fav (board_num, mem_num) VALUES (#{board_num},#{mem_num})")
	public void insertFav(BoardFavVO fav);
	@Delete("DELETE FROM spboard_fav WHERE board_num=#{board_num} AND mem_num=#{mem_num}")
	public void deleteFav(BoardFavVO boardFav);
	@Delete("DELETE FROM spboard_fav WHERE board_num=#{board_num}")
	public void deleteFavByBoardNum(int board_num);
	
	//댓글
	public List<BoardReplyVO> selectListReply(Map<String,Object> map);
	@Select("SELECT COUNT(*) FROM spboard_reply WHERE board_num=#{board_num}")
	public int selectRowCountReply(Map<String,Object> map);
	//댓글 수정, 삭제 시 작성자 회원번호 구할 때 사용
	@Select("SELECT * FROM spboard_reply WHERE re_num=#{re_num}")
	public BoardReplyVO selectReply(int re_num);
	public void insertReply(BoardReplyVO boardReply);
	@Update("UPDATE spboard_reply SET re_content=#{re_content},re_ip=#{re_ip},re_mdate=SYSDATE WHERE re_num=#{re_num}")
	public void updateReply(BoardReplyVO boardReply);
	@Delete("DELETE FROM spboard_reply WHERE re_num=#{re_num}")
	public void deleteReply(int re_num);
	@Delete("DELETE FROM spboard_reply WHERE board_num=#{board_num}")
	public void deleteReplyByBoardNum(int board_num);
}

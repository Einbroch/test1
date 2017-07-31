package com.dj.bbs;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;

import com.dj.bbs.model.BbsDAO;
import com.dj.bbs.service.BbsService;
import com.dj.bbs.vo.BbsVO;

public class BBSDAOTest {
	
	@Inject
	private SqlSessionTemplate sqlSession;
	
	public BbsDAO getBbsDAO() {
		return sqlSession.getMapper(BbsDAO.class);
	}
	
	private BbsVO vo = new BbsVO();
	
	@org.junit.Before
	public void before(){
		vo.setId("BBFDA0020002000f");
		vo.setNum(0);
		vo.setTitle("asdadfs");
		vo.setOwnerId("66FDA00100010000");
		vo.setOwnerName("LJK");
		vo.setRegistDate(null);
		vo.setContent("\2017\07\17");
		vo.setContentPath("\2017\07\17");
	}
	
	@Test
	public void testSetBbsInfo() {
		BbsService bbs = new BbsService();
		getBbsDAO().insertBBSInfo(vo);
	}

}

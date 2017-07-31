package com.dj.bbs.service;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.dj.bbs.model.BbsDAO;
import com.dj.bbs.model.LoginDAO;
import com.dj.bbs.util.UploadFileUtils;
import com.dj.bbs.vo.BbsVO;
import com.dj.bbs.vo.SequenceVO;

@Service
public class BbsService {
	@Inject
	private SqlSessionTemplate sqlSession;

	@Resource(name = "contentPath")
	private String contentPath;

	public BbsDAO getBbsDAO() {
		return sqlSession.getMapper(BbsDAO.class);
	}

	public LoginDAO getLoginDAO() {
		return sqlSession.getMapper(LoginDAO.class);
	}

	public List<BbsVO> getBbsList(int value) {
		return getBbsDAO().totalBBSList(value * 100);
	}

	public void setBbsInfo(BbsVO vo) throws Exception {
		// 시퀀스 셋팅
		SequenceVO seq = getLoginDAO().selectUID("bbs");
		String id = seq.getIdentifier() + seq.getSequence1() + seq.getSequence2();
		vo.setId(id);
		
		if (seq.getSequence2().equals("FFFF")) {
			Long l = Long.valueOf(seq.getSequence1(), 16);
			l++;
			seq.setSequence1(String.format("%04x", l));
			seq.setSequence2("0001");
		} else {
			Long l = Long.valueOf(seq.getSequence2(), 16);
			l++;
			seq.setSequence2(String.format("%04x", l));
		}
		
		getLoginDAO().increaseSequence(seq);
		// 파일 저장
		UploadFileUtils.contentFile(contentPath, vo);
		// vo에 우리가 원하는 정보 삽입
		System.out.println(vo.toString());
		vo.setContentPath(vo.getContentPath().replace(File.separatorChar, '/'));
		getBbsDAO().insertBBSInfo(vo);
	}

	public BbsVO getBBSDetail(BbsVO vo) throws Exception {
		BbsVO rvo = getBbsDAO().selectBBSDetail(vo);
		System.out.println(rvo);
		BufferedReader br = new BufferedReader(new FileReader(
				new File(contentPath + rvo.getContentPath().replace('/', File.separatorChar), rvo.getContent())));
		rvo.setContent(br.readLine());
		return rvo;
	}

}

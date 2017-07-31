package com.dj.bbs.service;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dj.bbs.model.LoginDAO;
import com.dj.bbs.vo.EmpVO;
import com.dj.bbs.vo.SequenceVO;

@Service
public class LoginService implements LoginServiceInterface {

	@Inject
	private SqlSessionTemplate sqlSession;

	public LoginDAO getLoginDAO() {
		return sqlSession.getMapper(LoginDAO.class);
	}

	public boolean isExistEmp(EmpVO vo) {
		if (getLoginDAO().existEmp(vo) > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkIdService(EmpVO vo) {
		if (getLoginDAO().checkID(vo) > 0) {
			return false;
		} else {
			return true;
		}
	}

	// 1. @Transactional 사용 방식
	/*
	 * <tx:annotation-driven/> <TransactionManager> <aop:aspectj-autoproxy/>
	 * 
	 */
	// @Transactional
	public boolean setEmp(EmpVO vo) throws Exception {
		// SequenceVO에 시퀀스를 가져오는 부분
		SequenceVO seq = getLoginDAO().selectUID("EMP");
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
		// 에러코드 삽입
		vo.setId("66FDA00100010012");

		getLoginDAO().increaseSequence(seq);
		System.out.println(vo);
		getLoginDAO().insertEmp(vo);
		return true;
	}

	public EmpVO getEmpDetail() {
		return getLoginDAO().selectEmpDetail("66FDA00100010000");
	}
}

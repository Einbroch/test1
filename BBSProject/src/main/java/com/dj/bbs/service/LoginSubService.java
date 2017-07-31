package com.dj.bbs.service;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.dj.bbs.model.LoginDAO;
import com.dj.bbs.vo.EmpVO;
import com.dj.bbs.vo.SequenceVO;

@Service
public class LoginSubService {
	
	@Inject
	private SqlSessionTemplate sqlSession;
	
	@Inject
	private PlatformTransactionManager transactionManager;
	
	DefaultTransactionDefinition def = null;
	TransactionStatus status = null;
	
	public LoginDAO getLoginDAO(){
		return sqlSession.getMapper(LoginDAO.class);
	}
	
	public boolean setEmp(EmpVO vo) throws Exception{
		def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(
				TransactionDefinition.PROPAGATION_REQUIRED);
		status = transactionManager.getTransaction(def);
		
		try {
			// SequenceVO에 시퀀스를 가져오는 부분
			SequenceVO seq = getLoginDAO().selectUID("EMP");
			String id = seq.getIdentifier()+
					seq.getSequence1()+
					seq.getSequence2();
			vo.setId(id);
			if(seq.getSequence2().equals("FFFF")){
				Long l=Long.valueOf(seq.getSequence1(), 16);
				l++;
				seq.setSequence1(
						String.format("%04x", l));
				seq.setSequence2("0001");
			}else{
				Long l=Long.valueOf(seq.getSequence2(), 16);
				l++;
				seq.setSequence2(
						String.format("%04x", l));
			}
			//에러코드 삽입
			vo.setId("66FDA00100010012");
			
			getLoginDAO().increaseSequence(seq);
			System.out.println(vo);
			getLoginDAO().insertEmp(vo);
			transactionManager.commit(status);
		} catch (Exception e) {
			transactionManager.rollback(status);
		}
		
		return true;
	}
}

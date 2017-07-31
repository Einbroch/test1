package com.dj.bbs.service;

import org.springframework.transaction.annotation.Transactional;

import com.dj.bbs.vo.EmpVO;

public interface LoginServiceInterface {
	public boolean isExistEmp(EmpVO vo);
	public boolean checkIdService(EmpVO vo);
	// 1. @Transactional 사용 방식
	/* <tx:annotation-driven/>
	 * <TransactionManager>
	 * <aop:aspectj-autoproxy/>
	 *  */
	public boolean setEmp(EmpVO vo) throws Exception;
}







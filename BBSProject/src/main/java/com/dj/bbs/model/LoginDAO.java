package com.dj.bbs.model;

import com.dj.bbs.vo.EmpVO;
import com.dj.bbs.vo.SequenceVO;

public interface LoginDAO {
	public int existEmp(EmpVO vo);
	public int checkID(EmpVO vo);
	public SequenceVO selectUID(String str);
	public void increaseSequence(SequenceVO vo);
	public void insertEmp(EmpVO vo);
	public EmpVO selectEmpDetail(String id);
}

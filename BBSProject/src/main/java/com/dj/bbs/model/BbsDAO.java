package com.dj.bbs.model;

import java.util.List;

import com.dj.bbs.vo.BbsVO;

public interface BbsDAO {
	public List<BbsVO> totalBBSList(int value);
	public void insertBBSInfo(BbsVO vo);
	public BbsVO selectBBSDetail(BbsVO vo);
}

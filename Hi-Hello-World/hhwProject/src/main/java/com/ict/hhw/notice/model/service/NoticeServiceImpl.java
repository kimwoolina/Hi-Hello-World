package com.ict.hhw.notice.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.hhw.common.SearchDate;
import com.ict.hhw.notice.model.dao.NoticeDao;
import com.ict.hhw.notice.model.vo.Notice;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
	//의존성 주입(new 객체 생성 구문 자동으로)
	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public ArrayList<Notice> selectAll() {
		return noticeDao.selectList();
	}

	@Override
	public Notice selectnotice(int nid) {
		return noticeDao.selectOne(nid);
	}

	@Override
	public int insertNotice(Notice notice) {
		return noticeDao.insertNotice(notice);
	}

	@Override
	public int updateNotice(Notice notice) {
		return noticeDao.updateNotice(notice);
	}

	@Override
	public int deleteNotice(int nid) {
		return noticeDao.deletenotice(nid);
	}

	@Override
	public ArrayList<Notice> selectNewTop3() {
		return noticeDao.selectNewTop3();
	}

	@Override
	public ArrayList<Notice> selectSearchTitle(String keyword) {
		return noticeDao.selectSearchTitle(keyword);
	}

	@Override
	public ArrayList<Notice> selectSearchWriter(String keyword) {
		return noticeDao.selectSearchWriter(keyword);
	}

	@Override
	public ArrayList<Notice> selectSearchDate(SearchDate dates) {
		return noticeDao.selectSearchDate(dates);
	}

	@Override
	public ArrayList<Notice> selectNoticeList(int currentPage, int limit) {
		return noticeDao.selectNoticeList(currentPage, limit);
	}

	@Override
	public int addNoticeCount(int nid) {
	     return noticeDao.addNoticeCount(nid);
	}

	@Override
	public int getListCount() {
		return noticeDao.getListCount();
	}

}
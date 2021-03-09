package com.ict.hhw.notice.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ict.hhw.board.model.vo.Board;
import com.ict.hhw.common.SearchDate;
import com.ict.hhw.member.model.vo.Member;
import com.ict.hhw.notice.model.service.NoticeService;
import com.ict.hhw.notice.model.vo.Notice;


@Controller
public class NoticeController {

	// 잘연결되었는지 로그로 확인 -> 로그 객체 선언
	private static final Logger logger = LoggerFactory.getLogger("NoticeController.class");

	// 자동으로 의존성 주입(자동으로 DI선언) //컨트롤러-서비스연결
	@Autowired
	private NoticeService noticeService;
	
	// about us 페이지로 이동
	@RequestMapping("aboutUs.do")
	public String aboutUs() {
		return "notice/aboutUs";
	}

	// 사이트 사용법 페이지로 이동
	@RequestMapping("howTo.do")
	public String howTo() {
		return "notice/howTo";
	}

	// ajax로 최신 공지글 조회 요청 처리용
		@RequestMapping(value = "ntop3.do", method = RequestMethod.POST)
		@ResponseBody
		public String noticeNewTop3Method(HttpServletResponse response) throws UnsupportedEncodingException {
			// 최신 공지글 3개 조회해 옴
			ArrayList<Notice> list = noticeService.selectNewTop3();

			// 전송용 json 객체 준비
			JSONObject sendJson = new JSONObject();
			// list 옮길 json 배열 준비
			JSONArray jarr = new JSONArray();
			// list를 jarr로 옮기기 (복사)
			for (Notice notice : list) {
				// notice 필드값 저장할 json 객체 생성
				JSONObject job = new JSONObject();

				job.put("nid", notice.getNid());
				job.put("ntype", notice.getNtype());
				job.put("ntitle", URLEncoder.encode(notice.getNtitle(), "utf-8"));
				job.put("n_create_date", notice.getN_date().toString()); // 날짜형은 반! 드! 시! String으로 변환해줘야함
				job.put("ncount", notice.getNcount());


				// job를 jarr에 저장
				jarr.add(job);
			}
			// 전송용 json 객체에 jarr 담음
			sendJson.put("list", jarr);

			// 원래는 출력스트림을 만들어서 내보내는 작업을 했었음
			// 그러면 이제는 response과 관련된 작업을 해야하는데
			// 이거는 Spring이 자동으로 제공하는데
			// 이 때 JSONObject를 사용하겠다고 servlet-context에 설정해줬기 때문에
			// JSONView가 반환되도록 annotation만 사용하면된다

			return sendJson.toJSONString(); // jsonView가 리턴됨
		}

		// 공지사항 전체 목록보기 요청 처리용
		@RequestMapping("nlist.do")
		public String NoticeListMethod(@RequestParam("page") int currentPage, Model model) {
			
			int limit = 10;
			ArrayList<Notice> list = noticeService.selectNoticeList(currentPage, limit);
			
			// 페이지 처리와 관련된 값 처리
			// 총 페이지 계산을 위한 총 목록 갯수 조회
			int listCount = noticeService.getListCount();
			int maxPage = (int) ((double) listCount / limit + 0.9);
			// 현재 페이지가 속한 페이지그룹의 시작페이지 값 설정
			// 예 : 현재 페이지가 35이면, 시작페이지를 31로 지정(페이지 갯수를 10개 표시할 경우)
			int startPage = ((int) (double) currentPage / 10) * 10 + 1;
			int endPage = startPage + 9;

			if (maxPage < endPage)
				endPage = maxPage;

			if (list.size() > 0) {
				model.addAttribute("list", list);
				model.addAttribute("currentPage", currentPage);
				model.addAttribute("maxPage", maxPage);
				model.addAttribute("startPage", startPage);
				model.addAttribute("endPage", endPage);

				return "notice/noticeListView";
			} else {
				model.addAttribute("msg", currentPage + "페이지 출력 목록 조회 실패.");
				return "common/errorPage";
			}
		}

		// 공지글 상세보기 요청 처리용
		@RequestMapping("ndetail.do")
		public String noticeDetailViewMethod(
				@RequestParam(value="nid", required=false) int nid,
				@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage, Model model) {
			Notice notice = noticeService.selectnotice(nid);
			int result = noticeService.addNoticeCount(nid); // 조회수 1증가 처리

			if (notice != null && result > 0) {
				model.addAttribute("page", currentPage);
				model.addAttribute("notice", notice);
				return "notice/noticeDetailView";
			} else {
				model.addAttribute("msg", nid + "번 게시글 조회 실패");
				return "common/erroPage";
			}

		}

		// 공지글 등록 페이지 요청 처리용
		@RequestMapping("nwform.do")
		public String noticeWriteForm() {
			return "notice/noticeWriteForm";
		}

		// 공지글 수정 페이지 요청 처리용
		@RequestMapping("upmove.do")
		public String noticeUpdateForm(@RequestParam("nid") int nid, Model model) {
			Notice notice = noticeService.selectnotice(nid);
			if (notice != null) {
				model.addAttribute("notice", notice);
				return "notice/noticeUpdateForm";
			} else {
				model.addAttribute("msg", nid + "번 공지 수정페이지로 요청");
				return "common/errorPage";
			}
		}

		// 파일업로드 기능이 있는 공지글 등록 요청 처리용
		@RequestMapping(value = "ninsert.do", method = RequestMethod.POST)
		public String noticeInsertMethod(Notice notice, HttpServletRequest request,
				@RequestParam(name = "upfile", required = false) MultipartFile mfile, Model model) {
			// 업로드된 파일 저장 폴더 지정하기
			String savePath = request.getSession().getServletContext().getRealPath("resources/notice_files");

			// 첨부파일이 있을때 업로드된 파일을 지정 폴더로 옮기기
			if (mfile != null) {
				String fileName = mfile.getOriginalFilename();
				if (fileName != null && fileName.length() > 0) {
					try {
						mfile.transferTo(new File(savePath + "\\" + fileName));
					} catch (Exception e) {
						e.printStackTrace();
						model.addAttribute("msg", "전송 파일 저장 실패");
						return "common/errorPage";
					}
					notice.setN_file_name(mfile.getOriginalFilename());
					logger.info("ninsert.do : " + notice);
				}
			}

			if (noticeService.insertNotice(notice) > 0) {
				return "redirect:nlist.do?page=1";
			} else {
				model.addAttribute("msg", "공지글 등록 실패.");
				return "common/errorPage";
			}
		}

		// 첨부파일 다운로드 요청 처리용
		// return Type : 파일명 스트립 타입 , ModelAndView, void // 저장폴더에 대한 지정도 있어야 된다}
		@RequestMapping("nfdown.do")
		public ModelAndView fileDownMethod(@RequestParam("ofile") String originalFilename,
				@RequestParam("rfile") String renameFilename, HttpServletRequest request, Model model) {

			String savePath = request.getSession().getServletContext().getRealPath("resources/notice_files");
			File renameFile = new File(savePath + "\\" + renameFilename);

			model.addAttribute("renameFile", renameFile);
			model.addAttribute("originalFilename", originalFilename);
			return new ModelAndView("filedown2", "downFile", model);
		}
		

		// 공지글 삭제 요청 처리용
		// 삭제하면 목록보기로 가야되서 return type : string
		@RequestMapping("ndel.do")
		public String noticeDeleteMethod(@RequestParam("nid") int nid,
				@RequestParam(name = "file_path", required = false) String fileName, HttpServletRequest request,
				Model model) {
			if (noticeService.deleteNotice(nid) > 0) {
				// 첨부파일이 있는 글일 때, 저장폴더에 있는 파일도 삭제함
				if (fileName != null) {
					new File(request.getSession().getServletContext().getRealPath("resources/notice_files") + "\\"
							+ fileName).delete();
				}
				return "redirect:nlist.do?page=1";
			} else {
				model.addAttribute("msg", "번 공지글 삭제 실패");
				return "common/errorPage";
			}
		}

		//  공지글 수정 요청 처리용
		@RequestMapping(value = "nupdate.do", method = RequestMethod.POST)
		public String noticeUpdateMethod(Notice notice, HttpServletRequest request, Model model,
				@RequestParam(name = "delFlag", required = false) String delFlag,
				@RequestParam(name = "upfile", required = false) MultipartFile mfile) {
			// 업로드된 파일 저장 폴더 지정하기
			String savePath = request.getSession().getServletContext().getRealPath("resources/notice_files");

			// 원래 첨부파일이 있었는데 삭제를 선택한 경우
			if (notice.getN_file_name() != null && delFlag != null && delFlag.contentEquals("yes")) {
				// 저장 폴더에서 파일을 삭제함
				new File(savePath + "\\" + notice.getN_file_name()).delete();
				notice.setN_file_name(null);
			}

			// 원래 첨부파일이 없었는데 새로 추가한 경우
			if (mfile != null) {
				String fileName = mfile.getOriginalFilename();
				if (notice.getN_file_name() == null && fileName.length() > 0) {
					// 업로드된 파일을 지정 폴더로 옮기기
					try {
						mfile.transferTo(new File(savePath + "\\" + mfile.getOriginalFilename()));
					} catch (Exception e) {
						e.printStackTrace();
						model.addAttribute("msg", "전송파일 저장 실패");
						return "common/errorPage";
					}
					notice.setN_file_name(mfile.getOriginalFilename());
				}
			}

			if (noticeService.updateNotice(notice) > 0) {
				return "redirect:nlist.do?page=1";
			} else {
				model.addAttribute("msg", notice.getNid() + "번 공지글 수정 실패.");
				return "common/errorPage";
			}
		}
		
		@RequestMapping(value="nsearchTitle.do", method=RequestMethod.POST)
		public String noticeSearchTitleMethod(@RequestParam("keyword") String keyword, Model model) {
			ArrayList<Notice> list = noticeService.selectSearchTitle(keyword);

			if (list.size() > 0) {
				model.addAttribute("list", list);
				return "notice/noticeListView";
			} else {
				model.addAttribute("msg", keyword + "로 검색된 공지사항 정보가 없습니다.");
				return "common/errorPage";
			}
		}
		
		@RequestMapping(value="nsearchWriter.do", method=RequestMethod.POST)
		public String noticeSearchWriterMethod(@RequestParam("keyword") String keyword, Model model) {
			ArrayList<Notice> list = noticeService.selectSearchWriter(keyword);

			if (list.size() > 0) {
				model.addAttribute("list", list);
				return "notice/noticeListView";
			} else {
				model.addAttribute("msg",  keyword + "로 검색된 공지사항 정보가 없습니다.");
				return "common/errorPage";
			}
		}
		
		@RequestMapping(value="nsearchDate.do", method=RequestMethod.POST)
		public String noticeSearchDateMethod(SearchDate dates, Model model) {
			ArrayList<Notice> list = noticeService.selectSearchDate(dates);

			if (list.size() > 0) {
				model.addAttribute("list", list);
				return "notice/noticeListView";
			} else {
				model.addAttribute("msg", "날짜로 검색된 공지사항 정보가 없습니다.");
				return "common/errorPage";
			}
		}
	
	
}

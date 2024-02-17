package kr.spring.ch12.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.ch11.vo.PageRank;

@Controller
public class PageReportController {
	@RequestMapping("/pageJsonReport.do")
	@ResponseBody
	public List<PageRank> jsonReport(){
		List<PageRank> pageRanks = new ArrayList<PageRank>();
		pageRanks.add(new PageRank(1,"/item/list.do"));
		pageRanks.add(new PageRank(2,"/item/search.do"));
		pageRanks.add(new PageRank(3,"/item/register.do"));
		
		return pageRanks;
	}
}

package com.hy.capstone.company;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.hy.capstone.project.ProjectService;

@Controller
public class CompanyController {
	  @Autowired
	  private CompanyService companyService;

	  
	  @RequestMapping(value="/company.do")
	  public String companyList(Model model, HttpServletRequest request) throws Exception{
		  	String pgParam = request.getParameter("pg");
	        int pg = pgParam != null ? Integer.parseInt(pgParam) : 1; // 페이지 번호, 기본값은 1
	        int recordCountPerPage = 10; // 페이지당 레코드 수

	     // 검색 조건 받아오기
	        String searchFlag = request.getParameter("search_flg");
	        String searchKeyword = request.getParameter("search");
	        
	        int totalRecordCount = companyService.getTotalCompanyCount(searchFlag, searchKeyword);
	        
	        int totalPageCount = (int) Math.ceil((double) totalRecordCount / recordCountPerPage);

	        // 현재 페이지에서 보여줄 레코드의 시작 인덱스
	        int startIdx = (pg - 1) * recordCountPerPage;

		  	List<CompanyVO> companyList = companyService.getCompanyList(startIdx, recordCountPerPage, searchFlag, searchKeyword);
		  	
		  	model.addAttribute("companyList", companyList);
		  	model.addAttribute("pg", pg);
		    model.addAttribute("totalRecordCount", totalRecordCount);
		    model.addAttribute("totalPageCount", totalPageCount);
		    model.addAttribute("startIdx", startIdx);
		  	return "/company";
	  }
	  
	  @RequestMapping(value="/insertCompany.do")
	  public String insertCompany(HttpServletRequest request, @ModelAttribute("CompanyVO")CompanyVO cvo ) throws Exception{
		  request.setCharacterEncoding("UTF-8");
		  companyService.insertCompany(cvo);
		  return "redirect:/company.do";
	  }
	  
	  @RequestMapping(value="/deleteCompany.do")
	  public String deleteCompany(@RequestParam("companyIds") List<String> companyIds) {
		  for(String companyId : companyIds) {
			  companyService.deleteCompany(companyId);
		  }
		  return "redirect:/company.do";
	  }
	  
	  @RequestMapping(value="/updateCompany.do")
	  public String updateCompany(@ModelAttribute("CompanyVO")CompanyVO cvo) {
		  companyService.updateCompany(cvo);
		  return "redirect:/company.do";
	  }
	  
	  
	  @RequestMapping(value="/companyDtl.do")
	  public String companyDtl(@RequestParam("company_id")String companyId, Model model) {
		  try {
			  CompanyVO companyDtl = companyService.getCompanyDtl(companyId);
			  model.addAttribute("companyDtl",companyDtl);
		  }catch (Exception e) {
			  e.printStackTrace();
			  return "/";
		  }
		  return "company_dtl";
	  }
}

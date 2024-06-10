package com.hy.capstone.project;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.hy.capstone.company.CompanyService;
import com.hy.capstone.company.CompanyVO;
import egovframework.com.utl.fcc.service.EgovFileUploadUtil;
import egovframework.com.utl.fcc.service.EgovFormBasedFileVo;

@Controller
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Autowired CompanyService companyService;
    @RequestMapping(value = "/projectList.do")
    public String projectList(ModelMap model, HttpServletRequest request) throws Exception {
        String pgParam = request.getParameter("pg");
        int pg = pgParam != null ? Integer.parseInt(pgParam) : 1; // 페이지 번호, 기본값은 1
        int recordCountPerPage = 10; // 페이지당 레코드 수
        
        
        // 검색 조건 받아오기
        String searchFlag = request.getParameter("search_flg");
        String searchKeyword = request.getParameter("search");

        // 전체 레코드 수 가져오기
        int totalRecordCount = projectService.getTotalProjectCount(searchFlag, searchKeyword);
        // 전체 페이지 수 계산
        int totalPageCount = (int) Math.ceil((double) totalRecordCount / recordCountPerPage);

        // 현재 페이지에서 보여줄 레코드의 시작 인덱스
        int startIdx = (pg - 1) * recordCountPerPage;
        
        List<CompanyVO> companyList = companyService.getCompanyList(0, 100,"","");

        // 프로젝트 리스트 가져오기
        List<ProjectVO> projectList = projectService.getProjectList(startIdx, recordCountPerPage, searchFlag, searchKeyword);

        model.addAttribute("projectList", projectList);
        model.addAttribute("pg", pg);
        model.addAttribute("totalRecordCount", totalRecordCount);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("startIdx", startIdx);
        model.addAttribute("companyList", companyList);

        return "/projectList";
    }
    
    @RequestMapping(value = "/insertProject.do", method = RequestMethod.POST)
    public String insertProject(HttpServletRequest request, @ModelAttribute("ProjectVO")ProjectVO pvo) throws Exception{
    	request.setCharacterEncoding("UTF-8");
    	projectService.insertProject(pvo);
      return "redirect:/projectList.do";
    }
    
    
    
    @RequestMapping(value="/projectDtl.do")
    public String projectDtl(@RequestParam("project_id") String projectId, Model model) {
    	try {
    		ProjectVO projectDtl = projectService.getProjectDtl(projectId); 
    		model.addAttribute("projectDtl", projectDtl);
    		List<ProjectVO> file = projectService.getFileList(projectId);
    		model.addAttribute("file",file);
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    		return "/";
    	}
    	return "project_dtl";
    }
    
    @Autowired
    private ServletContext servletContext;
    @RequestMapping(value="/downloadFile")
    public ResponseEntity<Resource> downloadFile(@RequestParam("filePath") String filePath,
                                                 @RequestParam("fileName") String fileName,
                                                 HttpServletRequest request) throws IOException {

        // 파일 이름을 URL 인코딩하여 전달
        String encodedFileName = UriComponentsBuilder.fromUriString(fileName)
                                                     .build()
                                                     .encode()
                                                     .toString();

        
    	String realPath = servletContext.getRealPath("/");
        String absolutePath = realPath + filePath.replace("/", "\\");

        Path path = Paths.get(absolutePath);
        Resource resource = new FileSystemResource(path.toString());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", encodedFileName);
        
        return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
    }

    @RequestMapping(value="/updateProject.do")
    public String fileInsert(MultipartHttpServletRequest  request, Model model) throws Exception {
    	request.setCharacterEncoding("UTF-8");

		ProjectVO pvo = new ProjectVO();
		pvo.setProject_id(request.getParameter("project_id"));
		pvo.setCompany_ceo(request.getParameter("company_cep"));
		pvo.setCompany_name(request.getParameter("company_name"));
		pvo.setCompany_phone(request.getParameter("company_phone"));
		pvo.setEnd_date(request.getParameter("end_date"));
		pvo.setManage_group(request.getParameter("manage_group"));
		pvo.setManage_phone(request.getParameter("manage_phone"));
		pvo.setProject_contents(request.getParameter("project_contents"));
		pvo.setProject_cost(request.getParameter("project_cost"));
		pvo.setProject_manage(request.getParameter("project_manage"));
		pvo.setProject_name(request.getParameter("project_name"));
		pvo.setStart_date(request.getParameter("start_date"));
		
		projectService.updateProject(pvo);
		
		//파일업로드 시작
		List<MultipartFile> fileList = new ArrayList<>();

		for (int i = 1; ; i++) {
		    MultipartFile file = request.getFile("file" + i);
		    if (file == null) break; 
		    fileList.add(file);
		}

		String root = request.getSession().getServletContext().getRealPath("/");
		String uploadPath = root + "/upload/file/";
		int size = 10 * 1024 * 1024;

		List<EgovFormBasedFileVo> uploadedFiles = EgovFileUploadUtil.uploadFiles(request, uploadPath, size);

		for (int i = 0; i < fileList.size(); i++) {
		    fileList.get(i);
		    EgovFormBasedFileVo fileVo = uploadedFiles.get(i);

		    ProjectVO projectVo = new ProjectVO();
		    projectVo.setProject_id(request.getParameter("project_id"));
		    projectVo.setFile_name(fileVo.getFileName());
		    projectVo.setFile_path("/upload/file/" + fileVo.getServerSubPath() + "/" + fileVo.getPhysicalName());
		    
		    projectService.fileUpload(projectVo);
		}
		// 파일 업로드 끝

		return "redirect:/projectList.do";
    
    }
    
    
    @RequestMapping(value="/deleteProjects.do", method=RequestMethod.POST)
    public String deleteProjects(@RequestParam("projectIds") List<String> projectIds) {
        for (String projectId : projectIds) {
            projectService.deleteProject(projectId);
        }
        return "redirect:/projectList.do";
    }
    
    @RequestMapping(value="/jungong.do")
    public String jungong(@RequestParam("projectId")String projectId, Model model) {
    	ProjectVO data = projectService.getExcelData(projectId);
    	model.addAttribute("data", data);
    	return "jungong";
    }
    @RequestMapping(value="/soo.do")
    public String soo(@RequestParam("projectId")String projectId, Model model) {
    	ProjectVO data = projectService.getExcelData(projectId);
    	model.addAttribute("data", data);
    	return "soo";
    }

}

package com.hy.capstone.project;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
    @Resource(name = "projectDao")
    private ProjectDao projectDao;

    @Override
    public List<ProjectVO> getProjectList(int startIdx, int recordCountPerPage, String searchFlag, String searchKeyword) {
        return projectDao.getProjectList(startIdx, recordCountPerPage, searchFlag, searchKeyword);
    }

    @Override
    public int getTotalProjectCount(String searchFlag, String searchKeyword) {
        return projectDao.getTotalProjectCount(searchFlag, searchKeyword);
    }

	@Override
	public void insertProject(ProjectVO pvo) throws Exception {
		 projectDao.insertProject(pvo);
	}

	@Override
	public ProjectVO getProjectDtl(String projectId) {
		return projectDao.getProjectDtl(projectId);
	}

	@Override
	public List<ProjectVO> getFileList(String projectId) {
		return projectDao.getFileList(projectId);
	}

	@Override
	public int updateProject(ProjectVO pvo) throws Exception {
		return projectDao.updateProject(pvo);
	}

	@Override
	public void fileUpload(ProjectVO pvo) {
		projectDao.fileUpload(pvo);
	}

	@Override
	public int deleteProject(String projectIds) {
		return projectDao.deleteProject(projectIds);
	}

	@Override
	public ProjectVO getExcelData(String projectId) {
		return projectDao.getExcelData(projectId);
	}
	
}

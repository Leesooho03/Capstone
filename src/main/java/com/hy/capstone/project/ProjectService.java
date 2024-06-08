package com.hy.capstone.project;

import java.util.List;

public interface ProjectService {
    List<ProjectVO> getProjectList(int startIdx, int recordCountPerPage, String searchFlag, String searchKeyword) throws Exception;

    int getTotalProjectCount(String searchFlag, String searchKeyword) throws Exception;

	void insertProject(ProjectVO pvo) throws Exception;

	public ProjectVO getProjectDtl(String projectId);

	List<ProjectVO> getFileList(String projectId);

	int updateProject(ProjectVO pvo) throws Exception;

	void fileUpload(ProjectVO pvo);

	int deleteProject(String projectId);

	ProjectVO getExcelData(String projectId);
}
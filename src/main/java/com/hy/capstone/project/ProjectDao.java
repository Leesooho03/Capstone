package com.hy.capstone.project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("projectDao")
public class ProjectDao {
    private final SqlSession sql;

    @Autowired
    public ProjectDao(SqlSession sql) {
        this.sql = sql;
    }

    public List<ProjectVO> getProjectList(int startIdx, int recordCountPerPage, String searchFlag, String searchKeyword) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("startIdx", startIdx);
        params.put("recordCountPerPage", recordCountPerPage);
        params.put("searchFlag", searchFlag);
        params.put("searchKeyword", searchKeyword);
        return sql.selectList("ProjectSQL.getProjectList", params);
    }

    public int getTotalProjectCount(String searchFlag, String searchKeyword) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("searchFlag", searchFlag);
        params.put("searchKeyword", searchKeyword);
        return sql.selectOne("ProjectSQL.getTotalProjectCount", params);
    }

	public void insertProject(ProjectVO pvo) throws Exception {
			sql.insert("ProjectSQL.insertProject", pvo);
			sql.insert("ProjectSQL.insertProjectDtl", pvo);
	}

	public ProjectVO getProjectDtl(String projectId) {
		return sql.selectOne("ProjectSQL.getProjectDtl", projectId);
	}

	public List<ProjectVO> getFileList(String projectId) {
		return sql.selectList("ProjectSQL.getFileList", projectId);
	}

	public int updateProject(ProjectVO pvo) {
		return sql.update("ProjectSQL.updateProject", pvo);
	}

	public void fileUpload(ProjectVO pvo) {
			sql.insert("ProjectSQL.fileUpload", pvo);
	}

	public int deleteProject(String projectIds) {
		return sql.update("ProjectSQL.deleteProject", projectIds);
	}

	public ProjectVO getExcelData(String projectId) {
		return sql.selectOne("ProjectSQL.getExcelData", projectId);
	}
}

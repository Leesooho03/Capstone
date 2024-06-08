package com.hy.capstone.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hy.capstone.project.ProjectVO;

@Repository("companyDao")
public class CompanyDao {
    private final SqlSession sql;

    @Autowired
    public CompanyDao(SqlSession sql) {
        this.sql = sql;
    }

	public int getTotalCompanyCount(String searchFlag, String searchKeyword) {
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("searchFlag", searchFlag);
        params.put("searchKeyword", searchKeyword);
		return sql.selectOne("CompanySQL.getTotalCompanyCount", params);
	}

	public List<CompanyVO> getCompanyList(int startIdx, int recordCountPerPage, String searchFlag, String searchKeyword){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("startIdx", startIdx);
		params.put("recordCountPerPage", recordCountPerPage);
        params.put("searchFlag", searchFlag);
        params.put("searchKeyword", searchKeyword);
		return sql.selectList("CompanySQL.getCompanyList",params);
	}

	public void insertCompany(CompanyVO cvo) {
		sql.insert("CompanySQL.insertCompany", cvo);
	}

	public int deleteCompany(String companyId) {
		return sql.update("CompanySQL.deleteCompany", companyId);
	}

	public int updateCompany(CompanyVO cvo) {
		return sql.update("CompanySQL.updateCompany",cvo);
	}

	public CompanyVO getCompanyDtl(String companyId) {
		return sql.selectOne("CompanySQL.getCompanyDtl",companyId);
	}
}

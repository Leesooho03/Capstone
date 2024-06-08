package com.hy.capstone.company;

import java.util.List;

public interface CompanyService {

	int getTotalCompanyCount(String searchFlag, String searchKeyword);
	List<CompanyVO> getCompanyList(int startIdx, int recordCountPerPage, String searchFlag, String searchKeyword);
	void insertCompany(CompanyVO cvo);
	int deleteCompany(String companyId);
	int updateCompany(CompanyVO cvo);
	public CompanyVO getCompanyDtl(String companyId);
}

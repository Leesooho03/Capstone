package com.hy.capstone.company;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService {
    @Resource(name = "companyDao")
    private CompanyDao companyDao;
    
    @Override
	public int getTotalCompanyCount(String searchFlag, String searchKeyword) {
    	return companyDao.getTotalCompanyCount(searchFlag, searchKeyword);
    }

	@Override
	public List<CompanyVO> getCompanyList(int startIdx, int recordCountPerPage, String searchFlag, String searchKeyword) {
		return companyDao.getCompanyList(startIdx, recordCountPerPage, searchFlag, searchKeyword);
	}

	@Override
	public void insertCompany(CompanyVO cvo) {
		companyDao.insertCompany(cvo);
	}

	@Override
	public int deleteCompany(String companyId) {
		return companyDao.deleteCompany(companyId);
	}

	@Override
	public int updateCompany(CompanyVO cvo) {
		return companyDao.updateCompany(cvo);
	}

	@Override
	public CompanyVO getCompanyDtl(String companyId) {
		return companyDao.getCompanyDtl(companyId);
	}
    

	
}

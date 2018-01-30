/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.common.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezida.easy2write.common.persistence.Page;
import com.gezida.easy2write.common.service.CrudService;
import com.gezida.easy2write.common.bean.CommonMajor;
import com.gezida.easy2write.common.dao.CommonMajorDao;

/**
 * 关于CommonMajor专业的Service
 * @author Tangbinqi
 * @version 2017-08-15
 */
@Service
@Transactional(readOnly = true)
public class CommonMajorService extends CrudService<CommonMajorDao, CommonMajor> {

	public CommonMajor get(String id) {
		return super.get(id);
	}
	
	public List<CommonMajor> findList(CommonMajor commonMajor) {
		return super.findList(commonMajor);
	}
	
	public Page<CommonMajor> findPage(Page<CommonMajor> page, CommonMajor commonMajor) {
		return super.findPage(page, commonMajor);
	}
	
	@Transactional(readOnly = false)
	public void save(CommonMajor commonMajor) {
		super.save(commonMajor);
	}
	
	@Transactional(readOnly = false)
	public void delete(CommonMajor commonMajor) {
		super.delete(commonMajor);
	}
	
}
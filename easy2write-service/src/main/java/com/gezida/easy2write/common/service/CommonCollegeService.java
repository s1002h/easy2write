/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.common.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezida.easy2write.common.persistence.Page;
import com.gezida.easy2write.common.service.CrudService;
import com.gezida.easy2write.common.bean.CommonCollege;
import com.gezida.easy2write.common.dao.CommonCollegeDao;

/**
 * 关于CommonCollege高校表的Service
 * @author Tangbinqi
 * @version 2017-08-15
 */
@Service
@Transactional(readOnly = true)
public class CommonCollegeService extends CrudService<CommonCollegeDao, CommonCollege> {

	public CommonCollege get(String id) {
		return super.get(id);
	}
	
	public List<CommonCollege> findList(CommonCollege commonCollege) {
		return super.findList(commonCollege);
	}
	
	public Page<CommonCollege> findPage(Page<CommonCollege> page, CommonCollege commonCollege) {
		return super.findPage(page, commonCollege);
	}
	
	@Transactional(readOnly = false)
	public void save(CommonCollege commonCollege) {
		super.save(commonCollege);
	}
	
	@Transactional(readOnly = false)
	public void delete(CommonCollege commonCollege) {
		super.delete(commonCollege);
	}
	
}
/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.common.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezida.easy2write.common.persistence.Page;
import com.gezida.easy2write.common.service.CrudService;
import com.gezida.easy2write.common.bean.CommonParameter;
import com.gezida.easy2write.common.dao.CommonParameterDao;

/**
 * 关于CommonParameter系统参数表的Service
 * @author Tangbinqi
 * @version 2017-08-15
 */
@Service
@Transactional(readOnly = true)
public class CommonParameterService extends CrudService<CommonParameterDao, CommonParameter> {

	public CommonParameter get(String id) {
		return super.get(id);
	}
	
	public List<CommonParameter> findList(CommonParameter commonParameter) {
		return super.findList(commonParameter);
	}
	
	public Page<CommonParameter> findPage(Page<CommonParameter> page, CommonParameter commonParameter) {
		return super.findPage(page, commonParameter);
	}
	
	@Transactional(readOnly = false)
	public void save(CommonParameter commonParameter) {
		super.save(commonParameter);
	}
	
	@Transactional(readOnly = false)
	public void delete(CommonParameter commonParameter) {
		super.delete(commonParameter);
	}
	
}
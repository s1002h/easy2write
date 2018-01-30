/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.gezida.easy2write.common.sys.dao;

import java.util.List;

import com.gezida.easy2write.common.annotation.MyBatisDao;
import com.gezida.easy2write.common.entity.Dict;
import com.gezida.easy2write.common.persistence.CrudDao;

/**
 * 字典DAO接口
 * @author ThinkGem
 * @version 2014-05-16
 */
@MyBatisDao
public interface DictDao extends CrudDao<Dict> {

	public List<String> findTypeList(Dict dict);
	
}

package com.gezida.easy2write.common;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gezida.easy2write.common.entity.GenConfig;
import com.gezida.easy2write.common.entity.GenScheme;
import com.gezida.easy2write.common.entity.GenTable;
import com.gezida.easy2write.common.entity.GenTableColumn;
import com.gezida.easy2write.common.entity.GenTemplate;
import com.gezida.easy2write.common.gen.dao.GenDataBaseDictDao;
import com.gezida.easy2write.common.gen.dao.GenSchemeDao;
import com.gezida.easy2write.common.gen.dao.GenTableColumnDao;
import com.gezida.easy2write.common.gen.dao.GenTableDao;
import com.gezida.easy2write.common.gen.util.GenUtils;
import com.gezida.easy2write.common.utils.StringUtils;

public class GenMain {
	
	@Autowired
	private GenSchemeDao genSchemeDao;
//	@Autowired
//	private GenTemplateDao genTemplateDao;
	@Autowired
	private GenTableDao genTableDao;
	@Autowired
	private GenTableColumnDao genTableColumnDao;
	@Autowired
	private GenDataBaseDictDao genDataBaseDictDao;
	
	@Value( "${jdbc.url}" )
	private String jdbcUrl;
	
	private static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("/application_gen.xml");  
		
		GenMain a = (GenMain) ctx.getBean("genMain");
		//PropertiesFactoryBean pfb = ctx.getBean(requiredType)
	//select concat('a.generateCode("","',t.TABLE_NAME,'","',t.TABLE_COMMENT,'");') from information_schema.`TABLES` t where t.TABLE_SCHEMA = 'easy2write'	
		System.out.println(a.jdbcUrl);
		System.out.println(Arrays.toString(ctx.getBeanDefinitionNames()));
		
		
		a.generateCode("account","t_account_alipay","绑定支付宝");
		a.generateCode("account","t_account_base","账户额度表");
		a.generateCode("account","t_account_free","免费额度获取记录表");
		a.generateCode("account","t_account_recharge","充值记录表");
		a.generateCode("account","t_account_withdraw","账户提现记录表");
		a.generateCode("common","t_common_college","高校表");
		a.generateCode("common","t_common_major","专业");
		a.generateCode("common","t_common_parameter","系统参数表");
		a.generateCode("crm","t_crm_contact_bind","联系方式绑定");
		a.generateCode("crm","t_crm_custom_edu","用户教育情况记录表");
		a.generateCode("crm","t_crm_customer","用户表");
		a.generateCode("crm","t_crm_follow","用户关注表");
		a.generateCode("crm","t_crm_oauth_bind","第三方登录绑定");
		a.generateCode("crm","t_crm_student","学生信息");
		a.generateCode("crm","t_crm_tutor","导师");
		a.generateCode("good","t_good_base","商品信息表");
		a.generateCode("good","t_good_service_type","服务类型");
		a.generateCode("good","t_good_service_flow","服务流程配置表");
		a.generateCode("message","t_message_board","留言板");
		a.generateCode("message","t_message_notice","通知");
		a.generateCode("order","t_order_base","订单表");
		a.generateCode("order","t_order_complaints","服务申述");
		a.generateCode("order","t_order_pay","订单账户支付表");
		a.generateCode("order","t_order_score","服务订单评分表");
		a.generateCode("order","t_order_service_record","订单服务流程记录表");


		
	}
	
	/**
	 * @param moduleName 模块包
	 * @param table 表
	 * @param comments 注释
	 */
	public void generateCode(String moduleName,String table,String comments){
		GenScheme genScheme = initGenScheme(table,comments,moduleName);
		generateCode(genScheme); 
	}
	
	private GenScheme initGenScheme(String table,String comments,String moduleName){
          
		String className = table;
		if(StringUtils.startsWithIgnoreCase(className,"t_")){
			className = StringUtils.toCapitalizeCamelCase(className.substring(2));
		}
		String name = table+"计划"; 	// 名称
		String category = "curd";		// 分类
		String packageName="com.gezida.easy2write";		// 生成包路径
		//String moduleName="crmx";		// 生成模块名
		String subModuleName="";		// 生成子模块名
		String functionName="关于"+className+comments+"的";		// 生成功能名
		String functionNameSimple=className+comments;		// 生成功能名（简写）
		String functionAuthor="Tangbinqi";		// 生成功能作者
		GenTable genTable = new GenTable();		// 业务表名
		genTable.setName(table);
		genTable.setClassName(className);
		genTable.setComments(comments);
		
		String flag = "1"; 	// 0：保存方案； 1：保存方案并生成代码
		
		Boolean replaceFile = true;	// 是否替换现有文件    0：不替换；1：替换文件  
		
		GenScheme genScheme = new GenScheme();
		genScheme.setName(name);
		genScheme.setCategory(category);
		genScheme.setPackageName(packageName);
		genScheme.setGenTable(genTable);
		genScheme.setFlag(flag);
		genScheme.setReplaceFile(replaceFile);
		genScheme.setModuleName(moduleName);
		genScheme.setSubModuleName(subModuleName);
		genScheme.setFunctionName(functionName); 
		genScheme.setFunctionNameSimple(functionNameSimple);
		genScheme.setFunctionAuthor(functionAuthor);
		
		return genScheme;
	}

	String generateCode(GenScheme genScheme){
		
		List<GenScheme> genSchemeDBList = genSchemeDao.findList(genScheme);
		if(genSchemeDBList.size() >0){
			genScheme.setId(genSchemeDBList.get(0).getId());
		}
		GenTable genTableDB = genScheme.getGenTable();
		genTableDB = getTableFormDb(genTableDB);
		genScheme.setGenTable(genTableDB);
		if (StringUtils.isBlank(genScheme.getId())){
			save(genTableDB);
			genScheme.preInsert();
			genSchemeDao.insert(genScheme);
		}else{
			save(genTableDB);
			genScheme.preUpdate();
			genSchemeDao.update(genScheme);
		}

		StringBuilder result = new StringBuilder();
		
		// 查询主表及字段列
		GenTable genTable = genTableDao.get(genScheme.getGenTable().getId());
		genTable.setColumnList(genTableColumnDao.findList(new GenTableColumn(new GenTable(genTable.getId()))));
		
		// 获取所有代码模板
		GenConfig config = GenUtils.getConfig();
		
		// 获取模板列表
		List<GenTemplate> templateList = GenUtils.getTemplateList(config, genScheme.getCategory(), false);
		List<GenTemplate> childTableTemplateList = GenUtils.getTemplateList(config, genScheme.getCategory(), true);
		
		// 如果有子表模板，则需要获取子表列表
		if (childTableTemplateList.size() > 0){
			GenTable parentTable = new GenTable();
			parentTable.setParentTable(genTable.getName());
			genTable.setChildList(genTableDao.findList(parentTable));
		}
		
		// 生成子表模板代码
		for (GenTable childTable : genTable.getChildList()){
			childTable.setParent(genTable);
			childTable.setColumnList(genTableColumnDao.findList(new GenTableColumn(new GenTable(childTable.getId()))));
			genScheme.setGenTable(childTable);
			Map<String, Object> childTableModel = GenUtils.getDataModel(genScheme);
			for (GenTemplate tpl : childTableTemplateList){
				result.append(GenUtils.generateToFile(tpl, childTableModel, genScheme.getReplaceFile()));
			}
		}
		
		// 生成主表模板代码
		genScheme.setGenTable(genTable);
		Map<String, Object> model = GenUtils.getDataModel(genScheme);
		for (GenTemplate tpl : templateList){
			try{
				String fileURL = GenUtils.generateToFile(tpl, model, genScheme.getReplaceFile());			
				result.append(fileURL);
				System.out.println(tpl.getFilePath()+"_"+tpl.getFileName()+"=="+fileURL);
			}catch(Exception e){
				System.out.println(tpl.getFilePath()+"_"+tpl.getFileName());
				e.printStackTrace();
			}
		}
		return result.toString();
	}
	
	/**
	 * 获取物理数据表列表
	 * @param genTable
	 * @return
	 */
	private GenTable getTableFormDb(GenTable genTable){
		// 如果有表名，则获取物理表
		if (StringUtils.isNotBlank(genTable.getName())){
			
			List<GenTable> list = genDataBaseDictDao.findTableList(genTable);
			if (list.size() > 0){
				
				// 如果是新增，初始化表属性
				if (StringUtils.isBlank(genTable.getId())){
					GenTable genTableDB = list.get(0);
					// 设置字段说明
					if (StringUtils.isBlank(genTable.getComments())){
						if(StringUtils.isBlank(genTableDB.getComments()) == false){
							genTable.setComments(genTableDB.getComments());
						}else{
							genTable.setComments(genTable.getName());
						}
					}
					if (StringUtils.isBlank(genTable.getClassName())){
						genTable.setClassName(StringUtils.toCapitalizeCamelCase(genTable.getName()));
					}
				}
				
				// 添加新列
				List<GenTableColumn> columnList = genDataBaseDictDao.findTableColumnList(genTable);
				for (GenTableColumn column : columnList){
					boolean b = false;
					for (GenTableColumn e : genTable.getColumnList()){
						if (e.getName().equals(column.getName())){
							b = true;
						}
					}
					if (!b){
						genTable.getColumnList().add(column);
					}
				}
				
				// 删除已删除的列
				for (GenTableColumn e : genTable.getColumnList()){
					boolean b = false;
					for (GenTableColumn column : columnList){
						if (column.getName().equals(e.getName())){
							b = true;
						}
					}
					if (!b){
						e.setDelFlag(GenTableColumn.DEL_FLAG_DELETE);
					}
				}
				
				// 获取主键
				genTable.setPkList(genDataBaseDictDao.findTablePK(genTable));
				
				// 初始化列属性字段
				GenUtils.initColumnField(genTable);
				
			}
		}
		return genTable;
	}
	
	private void save(GenTable genTable) {
		if (StringUtils.isBlank(genTable.getId())){
			genTable.preInsert();
			genTableDao.insert(genTable);
		}else{
			genTable.preUpdate();
			genTableDao.update(genTable);
		}
		// 保存列
		for (GenTableColumn column : genTable.getColumnList()){
			column.setGenTable(genTable);
			if (StringUtils.isBlank(column.getId())){
				column.preInsert();
				genTableColumnDao.insert(column);
			}else{
				column.preUpdate();
				genTableColumnDao.update(column);
			}
		}
	}
}

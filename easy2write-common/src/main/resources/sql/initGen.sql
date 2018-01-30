CREATE TABLE `gen_scheme` (
	`id` VARCHAR(64) NOT NULL COMMENT '编号' COLLATE 'utf8_bin',
	`name` VARCHAR(200) NULL DEFAULT NULL COMMENT '名称' COLLATE 'utf8_bin',
	`category` VARCHAR(2000) NULL DEFAULT NULL COMMENT '分类' COLLATE 'utf8_bin',
	`package_name` VARCHAR(500) NULL DEFAULT NULL COMMENT '生成包路径' COLLATE 'utf8_bin',
	`module_name` VARCHAR(30) NULL DEFAULT NULL COMMENT '生成模块名' COLLATE 'utf8_bin',
	`sub_module_name` VARCHAR(30) NULL DEFAULT NULL COMMENT '生成子模块名' COLLATE 'utf8_bin',
	`function_name` VARCHAR(500) NULL DEFAULT NULL COMMENT '生成功能名' COLLATE 'utf8_bin',
	`function_name_simple` VARCHAR(100) NULL DEFAULT NULL COMMENT '生成功能名（简写）' COLLATE 'utf8_bin',
	`function_author` VARCHAR(100) NULL DEFAULT NULL COMMENT '生成功能作者' COLLATE 'utf8_bin',
	`gen_table_id` VARCHAR(200) NULL DEFAULT NULL COMMENT '生成表编号' COLLATE 'utf8_bin',
	`create_by` VARCHAR(64) NULL DEFAULT NULL COMMENT '创建者' COLLATE 'utf8_bin',
	`create_date` DATETIME NULL DEFAULT NULL COMMENT '创建时间',
	`update_by` VARCHAR(64) NULL DEFAULT NULL COMMENT '更新者' COLLATE 'utf8_bin',
	`update_date` DATETIME NULL DEFAULT NULL COMMENT '更新时间',
	`remarks` VARCHAR(255) NULL DEFAULT NULL COMMENT '备注信息' COLLATE 'utf8_bin',
	`del_flag` CHAR(1) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）' COLLATE 'utf8_bin',
	PRIMARY KEY (`id`),
	INDEX `gen_scheme_del_flag` (`del_flag`)
)
COMMENT='生成方案'
COLLATE='utf8_bin'
ENGINE=InnoDB

CREATE TABLE `gen_table` (
	`id` VARCHAR(64) NOT NULL COMMENT '编号' COLLATE 'utf8_bin',
	`name` VARCHAR(200) NULL DEFAULT NULL COMMENT '名称' COLLATE 'utf8_bin',
	`comments` VARCHAR(500) NULL DEFAULT NULL COMMENT '描述' COLLATE 'utf8_bin',
	`class_name` VARCHAR(100) NULL DEFAULT NULL COMMENT '实体类名称' COLLATE 'utf8_bin',
	`parent_table` VARCHAR(200) NULL DEFAULT NULL COMMENT '关联父表' COLLATE 'utf8_bin',
	`parent_table_fk` VARCHAR(100) NULL DEFAULT NULL COMMENT '关联父表外键' COLLATE 'utf8_bin',
	`create_by` VARCHAR(64) NULL DEFAULT NULL COMMENT '创建者' COLLATE 'utf8_bin',
	`create_date` DATETIME NULL DEFAULT NULL COMMENT '创建时间',
	`update_by` VARCHAR(64) NULL DEFAULT NULL COMMENT '更新者' COLLATE 'utf8_bin',
	`update_date` DATETIME NULL DEFAULT NULL COMMENT '更新时间',
	`remarks` VARCHAR(255) NULL DEFAULT NULL COMMENT '备注信息' COLLATE 'utf8_bin',
	`del_flag` CHAR(1) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）' COLLATE 'utf8_bin',
	PRIMARY KEY (`id`),
	INDEX `gen_table_name` (`name`),
	INDEX `gen_table_del_flag` (`del_flag`)
)
COMMENT='业务表'
COLLATE='utf8_bin'
ENGINE=InnoDB
;
CREATE TABLE `gen_table_column` (
	`id` VARCHAR(64) NOT NULL COMMENT '编号' COLLATE 'utf8_bin',
	`gen_table_id` VARCHAR(64) NULL DEFAULT NULL COMMENT '归属表编号' COLLATE 'utf8_bin',
	`name` VARCHAR(200) NULL DEFAULT NULL COMMENT '名称' COLLATE 'utf8_bin',
	`comments` VARCHAR(500) NULL DEFAULT NULL COMMENT '描述' COLLATE 'utf8_bin',
	`jdbc_type` VARCHAR(100) NULL DEFAULT NULL COMMENT '列的数据类型的字节长度' COLLATE 'utf8_bin',
	`java_type` VARCHAR(500) NULL DEFAULT NULL COMMENT 'JAVA类型' COLLATE 'utf8_bin',
	`java_field` VARCHAR(200) NULL DEFAULT NULL COMMENT 'JAVA字段名' COLLATE 'utf8_bin',
	`is_pk` CHAR(1) NULL DEFAULT NULL COMMENT '是否主键' COLLATE 'utf8_bin',
	`is_null` CHAR(1) NULL DEFAULT NULL COMMENT '是否可为空' COLLATE 'utf8_bin',
	`is_insert` CHAR(1) NULL DEFAULT NULL COMMENT '是否为插入字段' COLLATE 'utf8_bin',
	`is_edit` CHAR(1) NULL DEFAULT NULL COMMENT '是否编辑字段' COLLATE 'utf8_bin',
	`is_list` CHAR(1) NULL DEFAULT NULL COMMENT '是否列表字段' COLLATE 'utf8_bin',
	`is_query` CHAR(1) NULL DEFAULT NULL COMMENT '是否查询字段' COLLATE 'utf8_bin',
	`query_type` VARCHAR(200) NULL DEFAULT NULL COMMENT '查询方式（等于、不等于、大于、小于、范围、左LIKE、右LIKE、左右LIKE）' COLLATE 'utf8_bin',
	`show_type` VARCHAR(200) NULL DEFAULT NULL COMMENT '字段生成方案（文本框、文本域、下拉框、复选框、单选框、字典选择、人员选择、部门选择、区域选择）' COLLATE 'utf8_bin',
	`dict_type` VARCHAR(200) NULL DEFAULT NULL COMMENT '字典类型' COLLATE 'utf8_bin',
	`settings` VARCHAR(2000) NULL DEFAULT NULL COMMENT '其它设置（扩展字段JSON）' COLLATE 'utf8_bin',
	`sort` DECIMAL(10,0) NULL DEFAULT NULL COMMENT '排序（升序）',
	`create_by` VARCHAR(64) NULL DEFAULT NULL COMMENT '创建者' COLLATE 'utf8_bin',
	`create_date` DATETIME NULL DEFAULT NULL COMMENT '创建时间',
	`update_by` VARCHAR(64) NULL DEFAULT NULL COMMENT '更新者' COLLATE 'utf8_bin',
	`update_date` DATETIME NULL DEFAULT NULL COMMENT '更新时间',
	`remarks` VARCHAR(255) NULL DEFAULT NULL COMMENT '备注信息' COLLATE 'utf8_bin',
	`del_flag` CHAR(1) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）' COLLATE 'utf8_bin',
	PRIMARY KEY (`id`),
	INDEX `gen_table_column_table_id` (`gen_table_id`),
	INDEX `gen_table_column_name` (`name`),
	INDEX `gen_table_column_sort` (`sort`),
	INDEX `gen_table_column_del_flag` (`del_flag`)
)
COMMENT='业务表字段'
COLLATE='utf8_bin'
ENGINE=InnoDB
;

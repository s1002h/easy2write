<html>
<head>
	<title>CommonCollege高校表管理</title>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="/common/commonCollege/">CommonCollege高校表列表</a></li>
		<li><a href="/common/commonCollege/form">CommonCollege高校表添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="commonCollege" action="/common/commonCollege/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>高校ID：</label>
			<input path="collegeId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>院校代码：</label>
			<input path="code" htmlEscape="false" maxlength="5" class="input-medium"/>
			</li>
			<li><label>院校名称：</label>
			<input path="name" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>院系简称：</label>
			<input path="simpleName" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>所在省份：</label>
			<input path="provinceId" htmlEscape="false" maxlength="6" class="input-medium"/>
			</li>
			<li><label>省份：</label>
			<input path="province" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>所在城市：</label>
			<input path="cityId" htmlEscape="false" maxlength="6" class="input-medium"/>
			</li>
			<li><label>城市：</label>
			<input path="city" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>高校性质：</label>
			<input path="nature" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>学校简介：</label>
			<input path="introduction" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>父院校：</label>
			<input path="parent.id" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>创建者：</label>
			<input path="createBy.id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>创建时间：</label>
			<input path="createDate" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>修改者：</label>
			<input path="updateBy.id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>修改时间2：</label>
			<input path="updateDate" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>可用开关(1:可用)：</label>
			<input path="onoff" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>

	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>高校ID</th>
				<th>院校代码</th>
				<th>院校名称</th>
				<th>院系简称</th>
				<th>所在省份</th>
				<th>省份</th>
				<th>所在城市</th>
				<th>城市</th>
				<th>高校性质</th>
				<th>学校简介</th>
				<th>父院校</th>
				<th>创建者</th>
				<th>创建时间</th>
				<th>修改者</th>
				<th>修改时间2</th>
				<th>可用开关(1:可用)</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		 <#list page.list as commonCollege >
			<tr>
				
						<td>
								<a href="/common/commonCollege/form?collegeId=${commonCollege.collegeId}">
								${commonCollege.collegeId}
							
								</a>
						</td>
						
						<td>
								${commonCollege.code}
							
						</td>
						
						<td>
								${commonCollege.name}
							
						</td>
						
						<td>
								${commonCollege.simpleName}
							
						</td>
						
						<td>
								${commonCollege.provinceId}
							
						</td>
						
						<td>
								${commonCollege.province}
							
						</td>
						
						<td>
								${commonCollege.cityId}
							
						</td>
						
						<td>
								${commonCollege.city}
							
						</td>
						
						<td>
								${commonCollege.nature}
							
						</td>
						
						<td>
								${commonCollege.introduction}
							
						</td>
						
						<td>
								${commonCollege.parent.id}
							
						</td>
						
						<td>
								${commonCollege.createBy.id}
							
						</td>
						
						<td>
								${commonCollege.createDate}
							
						</td>
						
						<td>
								${commonCollege.updateBy.id}
							
						</td>
						
						<td>
								${commonCollege.updateDate}
							
						</td>
						
						<td>
								${commonCollege.onoff}
							
						</td>
						
						<td>
							<a href="/common/commonCollege/form?collegeId=${commonCollege.collegeId}">修改</a>
							<a href="/common/commonCollege/delete?collegeId=${commonCollege.collegeId}" onclick="return confirmx('确认要删除该CommonCollege高校表吗？', this.href)">删除</a>
						</td>
				
    				
				
			</tr>
		</#list>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
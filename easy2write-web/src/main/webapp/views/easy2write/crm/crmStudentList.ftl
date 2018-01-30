<html>
<head>
	<title>CrmStudent学生信息管理</title>
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
		<li class="active"><a href="/crm/crmStudent/">CrmStudent学生信息列表</a></li>
		<li><a href="/crm/crmStudent/form">CrmStudent学生信息添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="crmStudent" action="/crm/crmStudent/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>用户ID：</label>
			<input path="user.id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>学习专业：</label>
			<input path="majId" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>个人简介：</label>
			<input path="summary" htmlEscape="false" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>

	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>用户ID</th>
				<th>学习专业</th>
				<th>个人简介</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		 <#list page.list as crmStudent >
			<tr>
				
						<td>
								<a href="/crm/crmStudent/form?user.id=${crmStudent.user.id}">
								${crmStudent.user.name}
							
								</a>
						</td>
						
						<td>
								${crmStudent.majId}
							
						</td>
						
						<td>
								${crmStudent.summary}
							
						</td>
						
						<td>
							<a href="/crm/crmStudent/form?user.id=${crmStudent.user.id}">修改</a>
							<a href="/crm/crmStudent/delete?user.id=${crmStudent.user.id}" onclick="return confirmx('确认要删除该CrmStudent学生信息吗？', this.href)">删除</a>
						</td>
				
    				
				
			</tr>
		</#list>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
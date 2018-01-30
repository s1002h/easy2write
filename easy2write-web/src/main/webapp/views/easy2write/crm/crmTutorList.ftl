<html>
<head>
	<title>CrmTutor导师管理</title>
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
		<li class="active"><a href="/crm/crmTutor/">CrmTutor导师列表</a></li>
		<li><a href="/crm/crmTutor/form">CrmTutor导师添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="crmTutor" action="/crm/crmTutor/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>用户ID：</label>
			<input path="user.id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>导师任职机构：</label>
			<input path="tutorOffice" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>已认证(1:已)：</label>
			<input path="verified" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>证明文件路径：</label>
			<input path="verifiedFile" htmlEscape="false" maxlength="500" class="input-medium"/>
			</li>
			<li><label>擅长专业：</label>
			<input path="majorGood" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>导师介绍：</label>
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
				<th>导师任职机构</th>
				<th>已认证(1:已)</th>
				<th>证明文件路径</th>
				<th>擅长专业</th>
				<th>导师介绍</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		 <#list page.list as crmTutor >
			<tr>
				
						<td>
								<a href="/crm/crmTutor/form?user.id=${crmTutor.user.id}">
								${crmTutor.user.name}
							
								</a>
						</td>
						
						<td>
								${crmTutor.tutorOffice}
							
						</td>
						
						<td>
								${crmTutor.verified}
							
						</td>
						
						<td>
								${crmTutor.verifiedFile}
							
						</td>
						
						<td>
								${crmTutor.majorGood}
							
						</td>
						
						<td>
								${crmTutor.summary}
							
						</td>
						
						<td>
							<a href="/crm/crmTutor/form?user.id=${crmTutor.user.id}">修改</a>
							<a href="/crm/crmTutor/delete?user.id=${crmTutor.user.id}" onclick="return confirmx('确认要删除该CrmTutor导师吗？', this.href)">删除</a>
						</td>
				
    				
				
			</tr>
		</#list>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
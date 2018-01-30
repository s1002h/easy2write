<html>
<head>
	<title>CrmCustomEdu用户教育情况记录表管理</title>
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
		<li class="active"><a href="/crm/crmCustomEdu/">CrmCustomEdu用户教育情况记录表列表</a></li>
		<li><a href="/crm/crmCustomEdu/form">CrmCustomEdu用户教育情况记录表添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="crmCustomEdu" action="/crm/crmCustomEdu/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>高校ID：</label>
			<input path="collegeId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>专业ID：</label>
			<input path="majId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>用户ID：</label>
			<input path="user.id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>开始时间：</label>
			<input path="startDate" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>结束时间：</label>
			<input path="endDate" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>状态（1:毕业 0:在读）：</label>
			<input path="status" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>编辑时间：</label>
			<input path="updateDate" htmlEscape="false" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>

	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>高校ID</th>
				<th>专业ID</th>
				<th>用户ID</th>
				<th>开始时间</th>
				<th>结束时间</th>
				<th>状态（1:毕业 0:在读）</th>
				<th>编辑时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		 <#list page.list as crmCustomEdu >
			<tr>
				
						<td>
								<a href="/crm/crmCustomEdu/form?collegeId=${crmCustomEdu.collegeId}">
								${crmCustomEdu.collegeId}
							
								</a>
						</td>
						
						<td>
								${crmCustomEdu.majId}
							
						</td>
						
						<td>
								${crmCustomEdu.user.name}
							
						</td>
						
						<td>
								${crmCustomEdu.startDate}
							
						</td>
						
						<td>
								${crmCustomEdu.endDate}
							
						</td>
						
						<td>
								${crmCustomEdu.status}
							
						</td>
						
						<td>
								${crmCustomEdu.updateDate}
							
						</td>
						
						<td>
							<a href="/crm/crmCustomEdu/form?collegeId=${crmCustomEdu.collegeId}">修改</a>
							<a href="/crm/crmCustomEdu/delete?collegeId=${crmCustomEdu.collegeId}" onclick="return confirmx('确认要删除该CrmCustomEdu用户教育情况记录表吗？', this.href)">删除</a>
						</td>
				
    				
				
			</tr>
		</#list>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
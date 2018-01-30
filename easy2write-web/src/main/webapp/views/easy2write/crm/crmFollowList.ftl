<html>
<head>
	<title>CrmFollow用户关注表管理</title>
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
		<li class="active"><a href="/crm/crmFollow/">CrmFollow用户关注表列表</a></li>
		<li><a href="/crm/crmFollow/form">CrmFollow用户关注表添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="crmFollow" action="/crm/crmFollow/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>关注_用户ID：</label>
			<input path="followUserId" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>被关注_用户ID：</label>
			<input path="befollowUserId" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>创建时间：</label>
			<input path="createAt" htmlEscape="false" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>

	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>关注_用户ID</th>
				<th>被关注_用户ID</th>
				<th>创建时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		 <#list page.list as crmFollow >
			<tr>
				
						<td>
								<a href="/crm/crmFollow/form?followUserId=${crmFollow.followUserId}">
								${crmFollow.followUserId}
							
								</a>
						</td>
						
						<td>
								${crmFollow.befollowUserId}
							
						</td>
						
						<td>
								${crmFollow.createAt}
							
						</td>
						
						<td>
							<a href="/crm/crmFollow/form?followUserId=${crmFollow.followUserId}">修改</a>
							<a href="/crm/crmFollow/delete?followUserId=${crmFollow.followUserId}" onclick="return confirmx('确认要删除该CrmFollow用户关注表吗？', this.href)">删除</a>
						</td>
				
    				
				
			</tr>
		</#list>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
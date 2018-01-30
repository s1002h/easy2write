<html>
<head>
	<title>CrmOauthBind第三方登录绑定管理</title>
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
		<li class="active"><a href="/crm/crmOauthBind/">CrmOauthBind第三方登录绑定列表</a></li>
		<li><a href="/crm/crmOauthBind/form">CrmOauthBind第三方登录绑定添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="crmOauthBind" action="/crm/crmOauthBind/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>绑定ID：</label>
			<input path="bindId" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>用户ID：</label>
			<input path="user.id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>第三方授权ID：</label>
			<input path="oauthId" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>第三方授权昵称：</label>
			<input path="oauthNickname" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>第三方授权类型：</label>
			<input path="oauthType" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>绑定时间：</label>
			<input path="bindDate" htmlEscape="false" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>

	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>绑定ID</th>
				<th>用户ID</th>
				<th>第三方授权ID</th>
				<th>第三方授权昵称</th>
				<th>第三方授权类型</th>
				<th>绑定时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		 <#list page.list as crmOauthBind >
			<tr>
				
						<td>
								<a href="/crm/crmOauthBind/form?bindId=${crmOauthBind.bindId}">
								${crmOauthBind.bindId}
							
								</a>
						</td>
						
						<td>
								${crmOauthBind.user.name}
							
						</td>
						
						<td>
								${crmOauthBind.oauthId}
							
						</td>
						
						<td>
								${crmOauthBind.oauthNickname}
							
						</td>
						
						<td>
								${crmOauthBind.oauthType}
							
						</td>
						
						<td>
								${crmOauthBind.bindDate}
							
						</td>
						
						<td>
							<a href="/crm/crmOauthBind/form?bindId=${crmOauthBind.bindId}">修改</a>
							<a href="/crm/crmOauthBind/delete?bindId=${crmOauthBind.bindId}" onclick="return confirmx('确认要删除该CrmOauthBind第三方登录绑定吗？', this.href)">删除</a>
						</td>
				
    				
				
			</tr>
		</#list>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
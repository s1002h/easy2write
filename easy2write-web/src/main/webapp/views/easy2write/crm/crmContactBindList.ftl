<html>
<head>
	<title>CrmContactBind联系方式绑定管理</title>
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
		<li class="active"><a href="/crm/crmContactBind/">CrmContactBind联系方式绑定列表</a></li>
		<li><a href="/crm/crmContactBind/form">CrmContactBind联系方式绑定添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="crmContactBind" action="/crm/crmContactBind/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>手机绑定ID：</label>
			<input path="contactId" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>用户ID：</label>
			<input path="user.id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>联系方式类型(1:手机 2:有限)：</label>
			<input path="contactType" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>联系方式：</label>
			<input path="contact" htmlEscape="false" maxlength="50" class="input-medium"/>
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
				<th>手机绑定ID</th>
				<th>用户ID</th>
				<th>联系方式类型(1:手机 2:有限)</th>
				<th>联系方式</th>
				<th>绑定时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		 <#list page.list as crmContactBind >
			<tr>
				
						<td>
								<a href="/crm/crmContactBind/form?contactId=${crmContactBind.contactId}">
								${crmContactBind.contactId}
							
								</a>
						</td>
						
						<td>
								${crmContactBind.user.name}
							
						</td>
						
						<td>
								${crmContactBind.contactType}
							
						</td>
						
						<td>
								${crmContactBind.contact}
							
						</td>
						
						<td>
								${crmContactBind.bindDate?string("yyyy-MM-dd HH:mm:ss zzzz")}
							
						</td>
						
						<td>
							<a href="/crm/crmContactBind/form?contactId=${crmContactBind.contactId}">修改</a>
							<a href="/crm/crmContactBind/delete?contactId=${crmContactBind.contactId}" onclick="return confirmx('确认要删除该CrmContactBind联系方式绑定吗？', this.href)">删除</a>
						</td>
				
    				
				
			</tr>
		</#list>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
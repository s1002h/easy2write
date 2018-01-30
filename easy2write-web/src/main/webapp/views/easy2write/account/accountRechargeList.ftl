<html>
<head>
	<title>AccountRecharge充值记录表管理</title>
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
		<li class="active"><a href="/account/accountRecharge/">AccountRecharge充值记录表列表</a></li>
		<li><a href="/account/accountRecharge/form">AccountRecharge充值记录表添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="accountRecharge" action="/account/accountRecharge/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>充值记录ID：</label>
			<input path="recordId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>账户ID：</label>
			<input path="accountId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>充值消费金额：</label>
			<input path="moneyNum" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>积分额：</label>
			<input path="pointNum" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>充值时间：</label>
			<input path="createAt" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>充值类型：</label>
			<input path="type" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>

	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>充值记录ID</th>
				<th>账户ID</th>
				<th>充值消费金额</th>
				<th>积分额</th>
				<th>充值时间</th>
				<th>充值类型</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		 <#list page.list as accountRecharge >
			<tr>
				
						<td>
								<a href="/account/accountRecharge/form?recordId=${accountRecharge.recordId}">
								${accountRecharge.recordId}
							
								</a>
						</td>
						
						<td>
								${accountRecharge.accountId}
							
						</td>
						
						<td>
								${accountRecharge.moneyNum}
							
						</td>
						
						<td>
								${accountRecharge.pointNum}
							
						</td>
						
						<td>
								${accountRecharge.createAt}
							
						</td>
						
						<td>
								${accountRecharge.type}
							
						</td>
						
						<td>
							<a href="/account/accountRecharge/form?recordId=${accountRecharge.recordId}">修改</a>
							<a href="/account/accountRecharge/delete?recordId=${accountRecharge.recordId}" onclick="return confirmx('确认要删除该AccountRecharge充值记录表吗？', this.href)">删除</a>
						</td>
				
    				
				
			</tr>
		</#list>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
<html>
<head>
	<title>AccountWithdraw账户提现记录表管理</title>
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
		<li class="active"><a href="/account/accountWithdraw/">AccountWithdraw账户提现记录表列表</a></li>
		<li><a href="/account/accountWithdraw/form">AccountWithdraw账户提现记录表添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="accountWithdraw" action="/account/accountWithdraw/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>提现记录ID：</label>
			<input path="提现记录id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>账户ID：</label>
			<input path="accountId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>绑定ID：</label>
			<input path="alipayId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>提现数额：</label>
			<input path="numWithdraw" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>提现时间：</label>
			<input path="withdrawDate" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>提现状态(0:申请 1:成功 -1:失败)：</label>
			<input path="status" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>审批原因：</label>
			<input path="auditReason" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>

	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>提现记录ID</th>
				<th>账户ID</th>
				<th>绑定ID</th>
				<th>提现数额</th>
				<th>提现时间</th>
				<th>提现状态(0:申请 1:成功 -1:失败)</th>
				<th>审批原因</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		 <#list page.list as accountWithdraw >
			<tr>
				
						<td>
								<a href="/account/accountWithdraw/form?提现记录id=${accountWithdraw.提现记录id}">
								${accountWithdraw.提现记录id}
							
								</a>
						</td>
						
						<td>
								${accountWithdraw.accountId}
							
						</td>
						
						<td>
								${accountWithdraw.alipayId}
							
						</td>
						
						<td>
								${accountWithdraw.numWithdraw}
							
						</td>
						
						<td>
								${accountWithdraw.withdrawDate}
							
						</td>
						
						<td>
								${accountWithdraw.status}
							
						</td>
						
						<td>
								${accountWithdraw.auditReason}
							
						</td>
						
						<td>
							<a href="/account/accountWithdraw/form?提现记录id=${accountWithdraw.提现记录id}">修改</a>
							<a href="/account/accountWithdraw/delete?提现记录id=${accountWithdraw.提现记录id}" onclick="return confirmx('确认要删除该AccountWithdraw账户提现记录表吗？', this.href)">删除</a>
						</td>
				
    				
				
			</tr>
		</#list>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
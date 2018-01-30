<html>
<head>
	<title>AccountAlipay绑定支付宝管理</title>
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
		<li class="active"><a href="/account/accountAlipay/">AccountAlipay绑定支付宝列表</a></li>
		<li><a href="/account/accountAlipay/form">AccountAlipay绑定支付宝添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="accountAlipay" action="/account/accountAlipay/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>绑定ID：</label>
			<input path="alipayId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>账户ID：</label>
			<input path="accountId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>支付宝用户名：</label>
			<input path="alipayName" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>真实姓名：</label>
			<input path="realname" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>支付宝账户：</label>
			<input path="alipayAccount" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>

	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>绑定ID</th>
				<th>账户ID</th>
				<th>支付宝用户名</th>
				<th>真实姓名</th>
				<th>支付宝账户</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		 <#list page.list as accountAlipay >
			<tr>
				
						<td>
								<a href="/account/accountAlipay/form?alipayId=${accountAlipay.alipayId}">
								${accountAlipay.alipayId}
							
								</a>
						</td>
						
						<td>
								${accountAlipay.accountId}
							
						</td>
						
						<td>
								${accountAlipay.alipayName}
							
						</td>
						
						<td>
								${accountAlipay.realname}
							
						</td>
						
						<td>
								${accountAlipay.alipayAccount}
							
						</td>
						
						<td>
							<a href="/account/accountAlipay/form?alipayId=${accountAlipay.alipayId}">修改</a>
							<a href="/account/accountAlipay/delete?alipayId=${accountAlipay.alipayId}" onclick="return confirmx('确认要删除该AccountAlipay绑定支付宝吗？', this.href)">删除</a>
						</td>
				
    				
				
			</tr>
		</#list>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
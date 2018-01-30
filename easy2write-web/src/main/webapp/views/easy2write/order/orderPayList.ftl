<html>
<head>
	<title>OrderPay订单账户支付表管理</title>
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
		<li class="active"><a href="/order/orderPay/">OrderPay订单账户支付表列表</a></li>
		<li><a href="/order/orderPay/form">OrderPay订单账户支付表添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="orderPay" action="/order/orderPay/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>支付ID：</label>
			<input path="payId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>支付编码：</label>
			<input path="payNum" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>订单ID：</label>
			<input path="orderId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>支付_账户ID：</label>
			<input path="fromAccountId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>收款_账户ID：</label>
			<input path="toAccountId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>支付金额：</label>
			<input path="payAmount" htmlEscape="false" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>

	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>支付ID</th>
				<th>支付编码</th>
				<th>订单ID</th>
				<th>支付_账户ID</th>
				<th>收款_账户ID</th>
				<th>支付金额</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		 <#list page.list as orderPay >
			<tr>
				
						<td>
								<a href="/order/orderPay/form?payId=${orderPay.payId}">
								${orderPay.payId}
							
								</a>
						</td>
						
						<td>
								${orderPay.payNum}
							
						</td>
						
						<td>
								${orderPay.orderId}
							
						</td>
						
						<td>
								${orderPay.fromAccountId}
							
						</td>
						
						<td>
								${orderPay.toAccountId}
							
						</td>
						
						<td>
								${orderPay.payAmount}
							
						</td>
						
						<td>
							<a href="/order/orderPay/form?payId=${orderPay.payId}">修改</a>
							<a href="/order/orderPay/delete?payId=${orderPay.payId}" onclick="return confirmx('确认要删除该OrderPay订单账户支付表吗？', this.href)">删除</a>
						</td>
				
    				
				
			</tr>
		</#list>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
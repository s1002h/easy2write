<html>
<head>
	<title>OrderBase订单表管理</title>
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
		<li class="active"><a href="/order/orderBase/">OrderBase订单表列表</a></li>
		<li><a href="/order/orderBase/form">OrderBase订单表添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="orderBase" action="/order/orderBase/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>订单ID：</label>
			<input path="orderId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>订单编号：</label>
			<input path="orderNum" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>服务ID：</label>
			<input path="id" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>用户ID：</label>
			<input path="user.id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>用户表_用户ID：</label>
			<input path="crmUserId" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>支付金额：</label>
			<input path="payMoney" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>支付状态：</label>
			<input path="payStatus" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>清算金额：</label>
			<input path="settlementMoney" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>当前处理用户：</label>
			<input path="currentUserId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>创建时间：</label>
			<input path="createDate" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>修改者：</label>
			<input path="updateBy.id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>修改时间：</label>
			<input path="updateDate" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>可用开关(1:可用)：</label>
			<input path="onoff" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>

	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>订单ID</th>
				<th>订单编号</th>
				<th>服务ID</th>
				<th>用户ID</th>
				<th>用户表_用户ID</th>
				<th>支付金额</th>
				<th>支付状态</th>
				<th>清算金额</th>
				<th>当前处理用户</th>
				<th>创建时间</th>
				<th>修改者</th>
				<th>修改时间</th>
				<th>可用开关(1:可用)</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		 <#list page.list as orderBase >
			<tr>
				
						<td>
								<a href="/order/orderBase/form?orderId=${orderBase.orderId}">
								${orderBase.orderId}
							
								</a>
						</td>
						
						<td>
								${orderBase.orderNum}
							
						</td>
						
						<td>
								${orderBase.id}
							
						</td>
						
						<td>
								${orderBase.user.name}
							
						</td>
						
						<td>
								${orderBase.crmUserId}
							
						</td>
						
						<td>
								${orderBase.payMoney}
							
						</td>
						
						<td>
								${orderBase.payStatus}
							
						</td>
						
						<td>
								${orderBase.settlementMoney}
							
						</td>
						
						<td>
								${orderBase.currentUserId}
							
						</td>
						
						<td>
								${orderBase.createDate}
							
						</td>
						
						<td>
								${orderBase.updateBy.id}
							
						</td>
						
						<td>
								${orderBase.updateDate}
							
						</td>
						
						<td>
								${orderBase.onoff}
							
						</td>
						
						<td>
							<a href="/order/orderBase/form?orderId=${orderBase.orderId}">修改</a>
							<a href="/order/orderBase/delete?orderId=${orderBase.orderId}" onclick="return confirmx('确认要删除该OrderBase订单表吗？', this.href)">删除</a>
						</td>
				
    				
				
			</tr>
		</#list>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
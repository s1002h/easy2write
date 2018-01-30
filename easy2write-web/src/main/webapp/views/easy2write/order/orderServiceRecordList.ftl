<html>
<head>
	<title>OrderServiceRecord订单服务流程记录表管理</title>
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
		<li class="active"><a href="/order/orderServiceRecord/">OrderServiceRecord订单服务流程记录表列表</a></li>
		<li><a href="/order/orderServiceRecord/form">OrderServiceRecord订单服务流程记录表添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="orderServiceRecord" action="/order/orderServiceRecord/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>记录ID：</label>
			<input path="recordId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>流程ID：</label>
			<input path="flowId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>订单ID：</label>
			<input path="orderId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>发生时间：</label>
			<input path="datetime" htmlEscape="false" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>

	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>记录ID</th>
				<th>流程ID</th>
				<th>订单ID</th>
				<th>发生时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		 <#list page.list as orderServiceRecord >
			<tr>
				
						<td>
								<a href="/order/orderServiceRecord/form?recordId=${orderServiceRecord.recordId}">
								${orderServiceRecord.recordId}
							
								</a>
						</td>
						
						<td>
								${orderServiceRecord.flowId}
							
						</td>
						
						<td>
								${orderServiceRecord.orderId}
							
						</td>
						
						<td>
								${orderServiceRecord.datetime}
							
						</td>
						
						<td>
							<a href="/order/orderServiceRecord/form?recordId=${orderServiceRecord.recordId}">修改</a>
							<a href="/order/orderServiceRecord/delete?recordId=${orderServiceRecord.recordId}" onclick="return confirmx('确认要删除该OrderServiceRecord订单服务流程记录表吗？', this.href)">删除</a>
						</td>
				
    				
				
			</tr>
		</#list>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
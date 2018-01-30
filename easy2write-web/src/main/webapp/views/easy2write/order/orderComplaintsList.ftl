<html>
<head>
	<title>OrderComplaints服务申述管理</title>
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
		<li class="active"><a href="/order/orderComplaints/">OrderComplaints服务申述列表</a></li>
		<li><a href="/order/orderComplaints/form">OrderComplaints服务申述添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="orderComplaints" action="/order/orderComplaints/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>投诉ID：</label>
			<input path="complaintsId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>订单ID：</label>
			<input path="orderId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>投诉类型：</label>
			<input path="complaintsType" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>投诉内容：</label>
			<input path="complaintsContent" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>创建者：</label>
			<input path="createBy.id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>创建时间：</label>
			<input path="createDate" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>处理状态：</label>
			<input path="processStatus" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>处理结果：</label>
			<input path="processResult" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>处理者：</label>
			<input path="updateBy.id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>最新处理时间：</label>
			<input path="updateDate" htmlEscape="false" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>

	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>投诉ID</th>
				<th>订单ID</th>
				<th>投诉类型</th>
				<th>投诉内容</th>
				<th>创建者</th>
				<th>创建时间</th>
				<th>处理状态</th>
				<th>处理结果</th>
				<th>处理者</th>
				<th>最新处理时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		 <#list page.list as orderComplaints >
			<tr>
				
						<td>
								<a href="/order/orderComplaints/form?complaintsId=${orderComplaints.complaintsId}">
								${orderComplaints.complaintsId}
							
								</a>
						</td>
						
						<td>
								${orderComplaints.orderId}
							
						</td>
						
						<td>
								${orderComplaints.complaintsType}
							
						</td>
						
						<td>
								${orderComplaints.complaintsContent}
							
						</td>
						
						<td>
								${orderComplaints.createBy.id}
							
						</td>
						
						<td>
								${orderComplaints.createDate}
							
						</td>
						
						<td>
								${orderComplaints.processStatus}
							
						</td>
						
						<td>
								${orderComplaints.processResult}
							
						</td>
						
						<td>
								${orderComplaints.updateBy.id}
							
						</td>
						
						<td>
								${orderComplaints.updateDate}
							
						</td>
						
						<td>
							<a href="/order/orderComplaints/form?complaintsId=${orderComplaints.complaintsId}">修改</a>
							<a href="/order/orderComplaints/delete?complaintsId=${orderComplaints.complaintsId}" onclick="return confirmx('确认要删除该OrderComplaints服务申述吗？', this.href)">删除</a>
						</td>
				
    				
				
			</tr>
		</#list>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
<html>
<head>
	<title>GoodServiceType服务类型管理</title>
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
		<li class="active"><a href="/good/goodServiceType/">GoodServiceType服务类型列表</a></li>
		<li><a href="/good/goodServiceType/form">GoodServiceType服务类型添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="goodServiceType" action="/good/goodServiceType/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>服务ID：</label>
			<input path="serviceTypeId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>服务名称：</label>
			<input path="serviceName" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>服务内容介绍：</label>
			<input path="seviceDesc" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>最低价：</label>
			<input path="priceLowest" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>最高价：</label>
			<input path="priceHighest" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>创建时间：</label>
			<input path="createAt" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>创建者：</label>
			<input path="createUserId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>状态：</label>
			<input path="status" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>修改时间：</label>
			<input path="updateAt" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>修改者：</label>
			<input path="updateUserId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>

	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>服务ID</th>
				<th>服务名称</th>
				<th>服务内容介绍</th>
				<th>最低价</th>
				<th>最高价</th>
				<th>创建时间</th>
				<th>创建者</th>
				<th>状态</th>
				<th>修改时间</th>
				<th>修改者</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		 <#list page.list as goodServiceType >
			<tr>
				
						<td>
								<a href="/good/goodServiceType/form?serviceTypeId=${goodServiceType.serviceTypeId}">
								${goodServiceType.serviceTypeId}
							
								</a>
						</td>
						
						<td>
								${goodServiceType.serviceName}
							
						</td>
						
						<td>
								${goodServiceType.seviceDesc}
							
						</td>
						
						<td>
								${goodServiceType.priceLowest}
							
						</td>
						
						<td>
								${goodServiceType.priceHighest}
							
						</td>
						
						<td>
								${goodServiceType.createAt}
							
						</td>
						
						<td>
								${goodServiceType.createUserId}
							
						</td>
						
						<td>
								${goodServiceType.status}
							
						</td>
						
						<td>
								${goodServiceType.updateAt}
							
						</td>
						
						<td>
								${goodServiceType.updateUserId}
							
						</td>
						
						<td>
							<a href="/good/goodServiceType/form?serviceTypeId=${goodServiceType.serviceTypeId}">修改</a>
							<a href="/good/goodServiceType/delete?serviceTypeId=${goodServiceType.serviceTypeId}" onclick="return confirmx('确认要删除该GoodServiceType服务类型吗？', this.href)">删除</a>
						</td>
				
    				
				
			</tr>
		</#list>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
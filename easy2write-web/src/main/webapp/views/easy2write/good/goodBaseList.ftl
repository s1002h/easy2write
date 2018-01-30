<html>
<head>
	<title>GoodBase商品信息表管理</title>
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
		<li class="active"><a href="/good/goodBase/">GoodBase商品信息表列表</a></li>
		<li><a href="/good/goodBase/form">GoodBase商品信息表添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="goodBase" action="/good/goodBase/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>商品ID：</label>
			<input path="goodId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>服务ID：</label>
			<input path="serviceId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>专业ID：</label>
			<input path="majorId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>用户ID：</label>
			<input path="user.id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>创建时间：</label>
			<input path="createDate" htmlEscape="false" class="input-medium"/>
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
				<th>商品ID</th>
				<th>服务ID</th>
				<th>专业ID</th>
				<th>用户ID</th>
				<th>创建时间</th>
				<th>修改时间</th>
				<th>可用开关(1:可用)</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		 <#list page.list as goodBase >
			<tr>
				
						<td>
								<a href="/good/goodBase/form?goodId=${goodBase.goodId}">
								${goodBase.goodId}
							
								</a>
						</td>
						
						<td>
								${goodBase.serviceId}
							
						</td>
						
						<td>
								${goodBase.majorId}
							
						</td>
						
						<td>
								${goodBase.user.name}
							
						</td>
						
						<td>
								${goodBase.createDate}
							
						</td>
						
						<td>
								${goodBase.updateDate}
							
						</td>
						
						<td>
								${goodBase.onoff}
							
						</td>
						
						<td>
							<a href="/good/goodBase/form?goodId=${goodBase.goodId}">修改</a>
							<a href="/good/goodBase/delete?goodId=${goodBase.goodId}" onclick="return confirmx('确认要删除该GoodBase商品信息表吗？', this.href)">删除</a>
						</td>
				
    				
				
			</tr>
		</#list>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
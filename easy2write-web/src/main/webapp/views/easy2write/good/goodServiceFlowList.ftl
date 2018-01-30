<html>
<head>
	<title>GoodServiceFlow服务流程配置表管理</title>
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
		<li class="active"><a href="/good/goodServiceFlow/">GoodServiceFlow服务流程配置表列表</a></li>
		<li><a href="/good/goodServiceFlow/form">GoodServiceFlow服务流程配置表添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="goodServiceFlow" action="/good/goodServiceFlow/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>流程ID：</label>
			<input path="flowId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>服务ID：</label>
			<input path="serviceId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>流程配置信息：</label>
			<input path="flowInfo" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>流程层级：</label>
			<input path="level" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>父流程ID：</label>
			<input path="parentFlowId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>

	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>流程ID</th>
				<th>服务ID</th>
				<th>流程配置信息</th>
				<th>流程层级</th>
				<th>父流程ID</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		 <#list page.list as goodServiceFlow >
			<tr>
				
						<td>
								<a href="/good/goodServiceFlow/form?flowId=${goodServiceFlow.flowId}">
								${goodServiceFlow.flowId}
							
								</a>
						</td>
						
						<td>
								${goodServiceFlow.serviceId}
							
						</td>
						
						<td>
								${goodServiceFlow.flowInfo}
							
						</td>
						
						<td>
								${goodServiceFlow.level}
							
						</td>
						
						<td>
								${goodServiceFlow.parentFlowId}
							
						</td>
						
						<td>
							<a href="/good/goodServiceFlow/form?flowId=${goodServiceFlow.flowId}">修改</a>
							<a href="/good/goodServiceFlow/delete?flowId=${goodServiceFlow.flowId}" onclick="return confirmx('确认要删除该GoodServiceFlow服务流程配置表吗？', this.href)">删除</a>
						</td>
				
    				
				
			</tr>
		</#list>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
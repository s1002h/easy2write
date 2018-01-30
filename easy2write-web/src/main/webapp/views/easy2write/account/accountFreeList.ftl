<html>
<head>
	<title>AccountFree免费额度获取记录表管理</title>
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
		<li class="active"><a href="/account/accountFree/">AccountFree免费额度获取记录表列表</a></li>
		<li><a href="/account/accountFree/form">AccountFree免费额度获取记录表添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="accountFree" action="/account/accountFree/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>免费额度记录ID：</label>
			<input path="recordId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>账户ID：</label>
			<input path="accountId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>积分：</label>
			<input path="point" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>积分事项：</label>
			<input path="pointEvent" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>

	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>免费额度记录ID</th>
				<th>账户ID</th>
				<th>积分</th>
				<th>积分事项</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		 <#list page.list as accountFree >
			<tr>
				
						<td>
								<a href="/account/accountFree/form?recordId=${accountFree.recordId}">
								${accountFree.recordId}
							
								</a>
						</td>
						
						<td>
								${accountFree.accountId}
							
						</td>
						
						<td>
								${accountFree.point}
							
						</td>
						
						<td>
								${accountFree.pointEvent}
							
						</td>
						
						<td>
							<a href="/account/accountFree/form?recordId=${accountFree.recordId}">修改</a>
							<a href="/account/accountFree/delete?recordId=${accountFree.recordId}" onclick="return confirmx('确认要删除该AccountFree免费额度获取记录表吗？', this.href)">删除</a>
						</td>
				
    				
				
			</tr>
		</#list>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
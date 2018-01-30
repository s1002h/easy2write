<html>
<head>
	<title>CommonMajor专业管理</title>
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
		<li class="active"><a href="/common/commonMajor/">CommonMajor专业列表</a></li>
		<li><a href="/common/commonMajor/form">CommonMajor专业添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="commonMajor" action="/common/commonMajor/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>专业ID：</label>
			<input path="majorId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>专业名称：</label>
			<input path="name" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>专业代码：</label>
			<input path="code" htmlEscape="false" maxlength="7" class="input-medium"/>
			</li>
			<li><label>专业等级：</label>
			<input path="level" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>父ID：</label>
			<input path="parent.id" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>创建者：</label>
			<input path="createBy.id" htmlEscape="false" maxlength="64" class="input-medium"/>
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
				<th>专业ID</th>
				<th>专业名称</th>
				<th>专业代码</th>
				<th>专业等级</th>
				<th>父ID</th>
				<th>创建者</th>
				<th>创建时间</th>
				<th>修改者</th>
				<th>修改时间</th>
				<th>可用开关(1:可用)</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		 <#list page.list as commonMajor >
			<tr>
				
						<td>
								<a href="/common/commonMajor/form?majorId=${commonMajor.majorId}">
								${commonMajor.majorId}
							
								</a>
						</td>
						
						<td>
								${commonMajor.name}
							
						</td>
						
						<td>
								${commonMajor.code}
							
						</td>
						
						<td>
								${commonMajor.level}
							
						</td>
						
						<td>
								${commonMajor.parent.id}
							
						</td>
						
						<td>
								${commonMajor.createBy.id}
							
						</td>
						
						<td>
								${commonMajor.createDate}
							
						</td>
						
						<td>
								${commonMajor.updateBy.id}
							
						</td>
						
						<td>
								${commonMajor.updateDate}
							
						</td>
						
						<td>
								${commonMajor.onoff}
							
						</td>
						
						<td>
							<a href="/common/commonMajor/form?majorId=${commonMajor.majorId}">修改</a>
							<a href="/common/commonMajor/delete?majorId=${commonMajor.majorId}" onclick="return confirmx('确认要删除该CommonMajor专业吗？', this.href)">删除</a>
						</td>
				
    				
				
			</tr>
		</#list>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
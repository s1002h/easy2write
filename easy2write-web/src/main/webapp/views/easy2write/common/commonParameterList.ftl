<html>
<head>
	<title>CommonParameter系统参数表管理</title>
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
		<li class="active"><a href="/common/commonParameter/">CommonParameter系统参数表列表</a></li>
		<li><a href="/common/commonParameter/form">CommonParameter系统参数表添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="commonParameter" action="/common/commonParameter/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>分类：</label>
			<input path="type" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>参数：</label>
			<input path="parameter" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>参数注释：</label>
			<input path="comment" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>值：</label>
			<input path="value" htmlEscape="false" maxlength="10" class="input-medium"/>
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
				<th>分类</th>
				<th>参数</th>
				<th>参数注释</th>
				<th>值</th>
				<th>创建者</th>
				<th>创建时间</th>
				<th>修改者</th>
				<th>修改时间</th>
				<th>可用开关(1:可用)</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		 <#list page.list as commonParameter >
			<tr>
				
						<td>
								<a href="/common/commonParameter/form?type=${commonParameter.type}">
								${commonParameter.type}
							
								</a>
						</td>
						
						<td>
								${commonParameter.parameter}
							
						</td>
						
						<td>
								${commonParameter.comment}
							
						</td>
						
						<td>
								${commonParameter.value}
							
						</td>
						
						<td>
								${commonParameter.createBy.id}
							
						</td>
						
						<td>
								${commonParameter.createDate}
							
						</td>
						
						<td>
								${commonParameter.updateBy.id}
							
						</td>
						
						<td>
								${commonParameter.updateDate}
							
						</td>
						
						<td>
								${commonParameter.onoff}
							
						</td>
						
						<td>
							<a href="/common/commonParameter/form?type=${commonParameter.type}">修改</a>
							<a href="/common/commonParameter/delete?type=${commonParameter.type}" onclick="return confirmx('确认要删除该CommonParameter系统参数表吗？', this.href)">删除</a>
						</td>
				
    				
				
			</tr>
		</#list>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
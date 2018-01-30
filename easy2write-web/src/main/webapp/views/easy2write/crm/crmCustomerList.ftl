<html>
<head>
	<title>CrmCustomer用户表管理</title>
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
		<li class="active"><a href="/crm/crmCustomer/">CrmCustomer用户表列表</a></li>
		<li><a href="/crm/crmCustomer/form">CrmCustomer用户表添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="crmCustomer" action="/crm/crmCustomer/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>用户ID：</label>
			<input path="user.id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>登录名：</label>
			<input path="loginName" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>密码：</label>
			<input path="password" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>昵称：</label>
			<input path="name" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>是导师(1:是)：</label>
			<input path="isTutor" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>是学生(1:是)：</label>
			<input path="isStudent" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>是管理员(1:是)：</label>
			<input path="isSys" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>性别(1:男)：</label>
			<input path="sex" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>省份：</label>
			<input path="province" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>城市：</label>
			<input path="city" htmlEscape="false" maxlength="20" class="input-medium"/>
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
				<th>用户ID</th>
				<th>登录名</th>
				<th>密码</th>
				<th>昵称</th>
				<th>是导师(1:是)</th>
				<th>是学生(1:是)</th>
				<th>是管理员(1:是)</th>
				<th>性别(1:男)</th>
				<th>省份</th>
				<th>城市</th>
				<th>创建者</th>
				<th>创建时间</th>
				<th>修改者</th>
				<th>修改时间</th>
				<th>可用开关(1:可用)</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		 <#list page.list as crmCustomer >
			<tr>
				
						<td>
								<a href="/crm/crmCustomer/form?user.id=${crmCustomer.user.id}">
								${crmCustomer.user.name}
							
								</a>
						</td>
						
						<td>
								${crmCustomer.loginName}
							
						</td>
						
						<td>
								${crmCustomer.password}
							
						</td>
						
						<td>
								${crmCustomer.name}
							
						</td>
						
						<td>
								${crmCustomer.isTutor}
							
						</td>
						
						<td>
								${crmCustomer.isStudent}
							
						</td>
						
						<td>
								${crmCustomer.isSys}
							
						</td>
						
						<td>
								${crmCustomer.sex}
							
						</td>
						
						<td>
								${crmCustomer.province}
							
						</td>
						
						<td>
								${crmCustomer.city}
							
						</td>
						
						<td>
								${crmCustomer.createBy.id}
							
						</td>
						
						<td>
								${crmCustomer.createDate?string("yyyy-MM-dd HH:mm:ss")}
							
						</td>
						
						<td>
								${crmCustomer.updateBy.id}
							
						</td>
						
						<td>
								${crmCustomer.updateDate?string("yyyy-MM-dd HH:mm:ss")}
							
						</td>
						
						<td>
								${crmCustomer.onoff}
							
						</td>
						
						<td>
							<a href="/crm/crmCustomer/form?user.id=${crmCustomer.user.id}">修改</a>
							<a href="/crm/crmCustomer/delete?user.id=${crmCustomer.user.id}" onclick="return confirmx('确认要删除该CrmCustomer用户表吗？', this.href)">删除</a>
						</td>
				
    				
				
			</tr>
		</#list>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
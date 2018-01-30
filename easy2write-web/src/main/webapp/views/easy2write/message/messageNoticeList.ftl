<html>
<head>
	<title>MessageNotice通知管理</title>
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
		<li class="active"><a href="/message/messageNotice/">MessageNotice通知列表</a></li>
		<li><a href="/message/messageNotice/form">MessageNotice通知添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="messageNotice" action="/message/messageNotice/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>通知ID：</label>
			<input path="noticeId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>通知类型：</label>
			<input path="noticeType" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>发送者：</label>
			<input path="sendUserId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>接收者：</label>
			<input path="receiveUserId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>时间：</label>
			<input path="createAt" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>通知内容：</label>
			<input path="message" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>

	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>通知ID</th>
				<th>通知类型</th>
				<th>发送者</th>
				<th>接收者</th>
				<th>时间</th>
				<th>通知内容</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		 <#list page.list as messageNotice >
			<tr>
				
						<td>
								<a href="/message/messageNotice/form?noticeId=${messageNotice.noticeId}">
								${messageNotice.noticeId}
							
								</a>
						</td>
						
						<td>
								${messageNotice.noticeType}
							
						</td>
						
						<td>
								${messageNotice.sendUserId}
							
						</td>
						
						<td>
								${messageNotice.receiveUserId}
							
						</td>
						
						<td>
								${messageNotice.createAt}
							
						</td>
						
						<td>
								${messageNotice.message}
							
						</td>
						
						<td>
							<a href="/message/messageNotice/form?noticeId=${messageNotice.noticeId}">修改</a>
							<a href="/message/messageNotice/delete?noticeId=${messageNotice.noticeId}" onclick="return confirmx('确认要删除该MessageNotice通知吗？', this.href)">删除</a>
						</td>
				
    				
				
			</tr>
		</#list>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
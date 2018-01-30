<html>
<head>
	<title>MessageBoard留言板管理</title>
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
		<li class="active"><a href="/message/messageBoard/">MessageBoard留言板列表</a></li>
		<li><a href="/message/messageBoard/form">MessageBoard留言板添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="messageBoard" action="/message/messageBoard/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>留言ID：</label>
			<input path="messageId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>发送者：</label>
			<input path="sendUserId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>接收者：</label>
			<input path="receiveUserId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>创建时间：</label>
			<input path="createAt" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>导师回复：</label>
			<input path="replyMsg" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>回复时间：</label>
			<input path="replyAt" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>删除标记：</label>
			<input path="deleteFlag" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>删除原因：</label>
			<input path="deleteCause" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>

	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>留言ID</th>
				<th>发送者</th>
				<th>接收者</th>
				<th>创建时间</th>
				<th>导师回复</th>
				<th>回复时间</th>
				<th>删除标记</th>
				<th>删除原因</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		 <#list page.list as messageBoard >
			<tr>
				
						<td>
								<a href="/message/messageBoard/form?messageId=${messageBoard.messageId}">
								${messageBoard.messageId}
							
								</a>
						</td>
						
						<td>
								${messageBoard.sendUserId}
							
						</td>
						
						<td>
								${messageBoard.receiveUserId}
							
						</td>
						
						<td>
								${messageBoard.createAt}
							
						</td>
						
						<td>
								${messageBoard.replyMsg}
							
						</td>
						
						<td>
								${messageBoard.replyAt}
							
						</td>
						
						<td>
								${messageBoard.deleteFlag}
							
						</td>
						
						<td>
								${messageBoard.deleteCause}
							
						</td>
						
						<td>
							<a href="/message/messageBoard/form?messageId=${messageBoard.messageId}">修改</a>
							<a href="/message/messageBoard/delete?messageId=${messageBoard.messageId}" onclick="return confirmx('确认要删除该MessageBoard留言板吗？', this.href)">删除</a>
						</td>
				
    				
				
			</tr>
		</#list>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
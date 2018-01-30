<html>
<head>
	<title>OrderScore服务订单评分表管理</title>
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
		<li class="active"><a href="/order/orderScore/">OrderScore服务订单评分表列表</a></li>
		<li><a href="/order/orderScore/form">OrderScore服务订单评分表添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="orderScore" action="/order/orderScore/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>评分ID：</label>
			<input path="scoreId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>订单ID：</label>
			<input path="orderId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>订单表_订单ID：</label>
			<input path="ordOrderId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>评分值：</label>
			<input path="scoreValue" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>评分详情：</label>
			<input path="scoreInfo" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>评分标签：</label>
			<input path="scoreTag" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>创建时间：</label>
			<input path="createDate" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>导师回复：</label>
			<input path="replyInfo" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>回复时间：</label>
			<input path="replyDate" htmlEscape="false" class="input-medium"/>
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
				<th>评分ID</th>
				<th>订单ID</th>
				<th>订单表_订单ID</th>
				<th>评分值</th>
				<th>评分详情</th>
				<th>评分标签</th>
				<th>创建时间</th>
				<th>导师回复</th>
				<th>回复时间</th>
				<th>删除标记</th>
				<th>删除原因</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		 <#list page.list as orderScore >
			<tr>
				
						<td>
								<a href="/order/orderScore/form?scoreId=${orderScore.scoreId}">
								${orderScore.scoreId}
							
								</a>
						</td>
						
						<td>
								${orderScore.orderId}
							
						</td>
						
						<td>
								${orderScore.ordOrderId}
							
						</td>
						
						<td>
								${orderScore.scoreValue}
							
						</td>
						
						<td>
								${orderScore.scoreInfo}
							
						</td>
						
						<td>
								${orderScore.scoreTag}
							
						</td>
						
						<td>
								${orderScore.createDate}
							
						</td>
						
						<td>
								${orderScore.replyInfo}
							
						</td>
						
						<td>
								${orderScore.replyDate}
							
						</td>
						
						<td>
								${orderScore.deleteFlag}
							
						</td>
						
						<td>
								${orderScore.deleteCause}
							
						</td>
						
						<td>
							<a href="/order/orderScore/form?scoreId=${orderScore.scoreId}">修改</a>
							<a href="/order/orderScore/delete?scoreId=${orderScore.scoreId}" onclick="return confirmx('确认要删除该OrderScore服务订单评分表吗？', this.href)">删除</a>
						</td>
				
    				
				
			</tr>
		</#list>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
<html>
<head>
	<title>AccountBase账户额度表管理</title>
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
		<li class="active"><a href="/account/accountBase/">AccountBase账户额度表列表</a></li>
		<li><a href="/account/accountBase/form">AccountBase账户额度表添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="accountBase" action="/account/accountBase/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>账户ID：</label>
			<input path="accountId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>用户ID：</label>
			<input path="user.id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>余额免费：</label>
			<input path="balanceFree" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>余额充值：</label>
			<input path="balanceRecharge" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>余额总额：</label>
			<input path="balance" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>充值总额：</label>
			<input path="totalRecharge" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>充值总次数：</label>
			<input path="countRecharge" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>免费总额：</label>
			<input path="totalFree" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>免费总次数：</label>
			<input path="countFree" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>提现总额：</label>
			<input path="totalWithdraw" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>提现次数：</label>
			<input path="countWithdraw" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>

	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>账户ID</th>
				<th>用户ID</th>
				<th>余额免费</th>
				<th>余额充值</th>
				<th>余额总额</th>
				<th>充值总额</th>
				<th>充值总次数</th>
				<th>免费总额</th>
				<th>免费总次数</th>
				<th>提现总额</th>
				<th>提现次数</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		 <#list page.list as accountBase >
			<tr>
				
						<td>
								<a href="/account/accountBase/form?accountId=${accountBase.accountId}">
								${accountBase.accountId}
							
								</a>
						</td>
						
						<td>
								${accountBase.user.name}
							
						</td>
						
						<td>
								${accountBase.balanceFree}
							
						</td>
						
						<td>
								${accountBase.balanceRecharge}
							
						</td>
						
						<td>
								${accountBase.balance}
							
						</td>
						
						<td>
								${accountBase.totalRecharge}
							
						</td>
						
						<td>
								${accountBase.countRecharge}
							
						</td>
						
						<td>
								${accountBase.totalFree}
							
						</td>
						
						<td>
								${accountBase.countFree}
							
						</td>
						
						<td>
								${accountBase.totalWithdraw}
							
						</td>
						
						<td>
								${accountBase.countWithdraw}
							
						</td>
						
						<td>
							<a href="/account/accountBase/form?accountId=${accountBase.accountId}">修改</a>
							<a href="/account/accountBase/delete?accountId=${accountBase.accountId}" onclick="return confirmx('确认要删除该AccountBase账户额度表吗？', this.href)">删除</a>
						</td>
				
    				
				
			</tr>
		</#list>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
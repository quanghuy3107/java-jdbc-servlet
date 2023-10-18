<%@page import="com.laptrinhjavaweb.model.NewsModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sach bai viet</title>
</head>
<body>

<div class="main-content">

		<form action="admin-new" id="formSubmit" method="get">
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">Trang chủ</a>
							</li>
						</ul>
						<!-- /.breadcrumb -->
					</div>
					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								
								<div class="widget-box table-filter">
									<div class="table-btn-controls">
										<div class="pull-right tableTools-container">
											<div class="dt-buttons btn-overlap btn-group">
												<a flag="info"
												   class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
												   title='Thêm bài viết' href='admin-new?type=edit'>
															<span>
																<i class="fa fa-plus-circle bigger-110 purple"></i>
															</span>
												</a>
												<button id="btnDelete" type="button"
														class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='Xóa bài viết'>
																<span>
																	<i class="fa fa-trash-o bigger-110 pink"></i>
																</span>
												</button>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12">
										<div class="table-responsive">
											<table class="table table-bordered">
												<thead>
													<tr>
														
														<th>Tên bài viết</th>
														<th>Mô tả ngắn</th>
														
													</tr>
												</thead>
												<tbody>
												<!--  -->
													<c:forEach var="item" items="${model.listResult}">
														<tr>
															
															<td>${item.title}</td>
															<td>${item.shortDescription}</td>
															
														</tr>
													</c:forEach>
												</tbody>
											</table>
											<ul class="pagination" id="pagination"></ul>
											<input type="hidden" value="" id="page" name="page"/>
											<input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
											<input type="hidden" value="" id="sortName" name="sortName"/>
											<input type="hidden" value="" id="sortBy" name="sortBy"/>
											<input type="hidden" value="" id="type" name="type"/>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
		</form>
		</div>
		<!-- /.main-content -->
		<script>
		var totalPage = ${model.totalPage};
		var currentPage = ${model.page};
		var limit = 2;
		  $(function () {
		        window.pagObj = $('#pagination').twbsPagination({
		            totalPages: totalPage, // so luong page
		            visiblePages: 10, // so nut hien tren màn hinh
		            startPage: currentPage, // page bat dau
		            onPageClick: function (event, page) {
			            if(currentPage != page){
			            	 $('#maxPageItem').val(limit);
					         $('#page').val(page);
					         $('#sortName').val('title');
					         $('#sortBy').val('desc');
				             $('#formSubmit').submit();
				          }
		            }
		        }).on('page', function (event, page) {
		            console.info(page + ' (from event listening)');
		        });
		    });
		</script>
</body>
</html>
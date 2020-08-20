<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<%@ include file="../include/head.jsp" %>
$(document).ready(function () {

    var formObj = $("form[role='form']");
    console.log(formObj);

    $(".modBtn").on("click", function () {
        formObj.submit();
    });

    $(".cancelBtn").on("click", function () {
        history.go(-1);
    });

    $(".listBtn").on("click", function () {
        self.location = "/article/list"
    });

});
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

 	<!-- Main Header -->
  	<%@ include file="../include/main_header.jsp" %>
  	<!-- Left side column. contains the logo and sidebar -->
	<%@ include file="../include/left_column.jsp" %>
	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
	   <!-- Content Header (Page header) -->
	<section class="content-header">
	  <h1>
	    Page Header
	    <small>Optional description</small>
	  </h1>
	  <ol class="breadcrumb">
	    <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
	    <li class="active">Here</li>
	  </ol>
	</section>
	
	<!-- Main content -->
	<section class="content container-fluid">
	
	  <!--------------------------
	    | Your Page Content Here |
	    -------------------------->
	
	</section>
	<!-- /.content -->
	</div>


  	<!-- Main Footer -->
	<%@ include file="../include/main_footer.jsp" %>

	<div class="control-sidebar-bg"></div>
</div>

<!-- REQUIRED JS SCRIPTS -->
<%@ include file="../include/plugin_js.jsp" %>

</body>
</html>
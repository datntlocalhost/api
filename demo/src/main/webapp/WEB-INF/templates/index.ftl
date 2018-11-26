<#ftl encoding='UTF-8'>
<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Validation Common</title>

  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

  <link rel="stylesheet" href="<@spring.url '/css/bootstrap.min.css'/>">
  <link rel="stylesheet" href="<@spring.url '/css/font-awesome.min.css'/>">
  <link rel="stylesheet" href="<@spring.url '/css/AdminLTE.min.css'/>">
  <link rel="stylesheet" href="<@spring.url '/css/_all-skins.min.css'/>">

  <link rel="stylesheet"
        href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar" style="padding-top: 0; height: 100%;">
    <section class="sidebar" style="height: 35%; overflow-x: scroll; overflow-y: scroll; background-color: #222D32;">

      <ul class="sidebar-menu">
        <li class="header">CLASS</li>
        
        <#list classList as list>
        	<li><a href="" class="js-click-class">${list.clazz}</a></li>
        </#list>
        
      </ul>  
    </section>

    <section class="sidebar" style="height: 65%; overflow-x: scroll;overflow-y: scroll; background-color: #222D32;">
       <form id="js-search-frm" action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="method" class="form-control" placeholder="Search method...">
          <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
          </span>
        </div>
      </form>
      <ul id="js-list-method" class="sidebar-menu">
        <li class="header">METHODS</li>
        
        <#list classList as list>
        	<#list list.methods as method>
        		<li class="js-methods"><a class="js-click-method" href='/method?class=${list.clazz}&method=${method.methodName}&signature=${method.signature}' value='${list.clazz}'>${method.methodName}</a></li>
        	</#list>
        </#list>
        
      </ul>  
    </section>
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper" style="height: 100%;">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        <span id="method"></span>
        <small><b id="class"></b></small>
      </h1>
      <ol class="breadcrumb">
        <li><a id="js-update" href=""><i class="fa fa-dashboard"></i>Update</a></li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
     
      <div class="row"  id="js-description" style="display: none;">
        <div class="col-md-12">
          <div class="box">
            <div class="box-header with-border">
              <h3 class="box-title">Description</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <div class="row">
                <div class="col-md-8">
                  <!-- render info method-->
                  <p  id="js-dst-content"></p>
                  <div id="js-dst-detail" style="display: none;">
                  	<label>Parameters</label>
                  	<p id="js-dst-param" style="margin-left: 5%;"></p>
                  	<label>Return</label>
                  	<p id="js-dst-return" style="margin-left: 5%;"></p>
                  </div>
                </div>
                <!-- /.col -->
       
                <!-- /.col -->
              </div>
              <!-- /.row -->
            </div>
            <!-- ./box-body -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->

      <!-- Main row -->
      <div id="js-unit-test" class="row" style="display: none;">
        <!-- Left col -->
        <div class="col-md-12">
          <!-- MAP & BOX PANE -->
          <div class="box box-success">
            <div class="box-header with-border">
              <h3 class="box-title">Unit testing</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body no-padding">
              <div class="row">
	              <div class="col-md-6">
	               	<form id="js-test-frm" class="form-horizontal">
	              		<div class="box-body">
	              			<div id="js-input-frm">
		                		<!-- To generate input parameter -->
	                		</div>
	                		<div class="form-group">
	                  			<label for="" class="col-sm-2 control-label"></label>
	
	                  			<div class="col-sm-10">
	                    			<button type="submit" class="btn btn-info form-control">Submit</button>
	                  			</div>
	                		</div>
	               			
	              		</div>
	            	</form>
	              </div>
	              
	              <div class="col-md-6">
	                  <div class="form-horizontal">
	                  	<div class="box-body">
	                  		<div class="form-group">
	                  			<label for="" class="col-sm-2 control-label">return</label>
	
	                  			<div class="col-sm-10">
	                    			<input id="js-return" type="text" class="form-control" disabled>
	                  			</div>
	                		</div>
	                		
	                		<div class="form-group">
	                  			<label for="" class="col-sm-2 control-label">exception</label>
	
	                  			<div class="col-sm-10">
	                    			<input id="js-exception" type="text" class="form-control" disabled>
	                  			</div>
	                		</div>
	                  	</div>
	                  </div>
	              </div>
	              
              </div>
              <!-- /.row -->

            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->

        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

</div>
<!-- ./wrapper -->

<script src="<@spring.url '/js/jquery.min.js'/>"></script>
<script src="<@spring.url '/js/bootstrap.min.js'/>"></script>
<script src="<@spring.url '/js/adminlte.min.js'/>"></script>
<script src="<@spring.url '/js/main.js'/>"></script>
</body>
</html>

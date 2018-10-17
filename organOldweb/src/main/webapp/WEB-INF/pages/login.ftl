<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <title>古美路街道智慧养老信息化管理系统 - 登录</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="/css/animate.min.css" rel="stylesheet">
    <link href="/css/style.min.css" rel="stylesheet">
    <link href="/css/login.min.css" rel="stylesheet">
    <!--[if lt IE 8]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>
        if(window.top!==window.self){window.top.location=window.location};
    </script>

</head>

<body class="signin">
<div class="signinpanel">
    <div class="row">
        <div class="col-sm-6">
            <div class="signin-info">
                <div class="logopanel m-b">
                    <h1>古美路街道</h1>
                    <h1>智慧养老信息化管理系统</h1>
                </div>
                <div class="m-b"></div>
                <h4><strong></strong></h4>
            <#--<ul class="m-b">-->
            <#--<li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势一</li>-->
            <#--<li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势二</li>-->
            <#--<li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势三</li>-->
            <#--<li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势四</li>-->
            <#--<li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势五</li>-->
            <#--</ul>-->
            <#--<strong>还没有账号？ <a href="#">立即注册&raquo;</a></strong>-->
            </div>
        </div>
        <div class="col-sm-6">
            <form method="post" action="j_spring_security_check">
                <h2 class="no-margins">登录：</h2>
            <#--<p class="m-t-md">登录到古美路街道综合为老服务平台</p>-->
                <input style="font-size: 20px !important;padding: 18px!important;margin-top: 30px;margin-bottom: 20px" type="text" class="form-control uname" placeholder="用户名" name="j_username" />
                <input style="font-size: 20px !important;padding: 18px!important;margin-bottom: 30px"  type="password" class="form-control pword m-b" placeholder="密码" name="j_password" />
            <#--<a href="">忘记密码了？</a>-->
                <span style="color: red">${(((SPRING_SECURITY_LAST_EXCEPTION.message)!)?contains("Exception"))?string("登陆超时！",(SPRING_SECURITY_LAST_EXCEPTION.message)!)}</span>
                <button style="font-size: 24px" class="btn btn-success btn-block">登录</button>
            </form>
        </div>
    </div>
    <div class="signup-footer">
    <#--<div class="pull-left">-->
    <#--&copy; 2015 All Rights Reserved. H+-->
    <#--</div>-->
    </div>
</div>
</body>

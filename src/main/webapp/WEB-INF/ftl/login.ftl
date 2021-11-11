<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>武汉人民在线-数据研发部</title>
    <link rel="stylesheet" href="/resources/layui/css/layui.css">
    <style>
        body {
            background-color: #f2f2f2;
        }

        .oa-container {
            /*background-color: #0C0C0C;*/
            position: absolute;
            width: 400px;
            height: 350px;
            top: 50%;
            left: 50%;
            padding: 20px;
            margin-left: -200px;
            margin-top: -175px;
        }
        #username,#password{
            /*text-align: center;*/
            /*font-size: 24px;*/
        }
    </style>
</head>
<body>
<div class="oa-container">
    <h1 style="text-align: center;margin-bottom: 20px">武汉人民在线-数据研发部</h1>
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <input type="username" id="username" name="username" required lay-verify="required" placeholder="请输入用户名"
                   autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-item">
            <input type="password" id="password" name="password" required lay-verify="required" placeholder="请输入密码"
                   autocomplete="off"
                   class="layui-input">
        </div>

        <div class="layui-form-item">
            <button class="layui-btn layui-btn-fluid" lay-submit lay-filter="formDemo">登录</button>
        </div>
    </form>
</div>

<script src="/resources/layui/layui.all.js"></script>

<script>
    var table = layui.table; //table数据表格对象
    var $ = layui.$; //jQuery
    var editor = null; //wangEditor富文本编辑器对象

    layui.form.on('submit(formDemo)', function(data){
        console.log(data);
        //向服务器发送请求
        $.post("/check_login" , data.field , function(json){
            if(json.code=="0"){
                // window.location = "/?ts=" + new Date().getTime();
                layui.layer.msg("登录成功");
                window.location.href = json.redirect_url;
            }else{
                layui.layer.msg(json.msg);
            }
        } ,"json")
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。此时要ajax请求，所以填false
    });
</script>
</body>
</html>
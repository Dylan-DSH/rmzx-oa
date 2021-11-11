<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>微博</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/resources/layui/css/layui.css"  media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

<div class="demoTable">
    搜索ID：
    <div class="layui-inline">
        <input class="layui-input" name="id" id="demoReload" autocomplete="off">
    </div>
    <button class="layui-btn" data-type="reload">搜索</button>
</div>

<table class="layui-hide" id="LAY_table_user" lay-filter="user"></table>


<script src="/resources/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 -->
<script>
    layui.use('table', function(){

        var table = layui.table;

        //方法级渲染
        table.render({
            elem: '#LAY_table_user'
            ,url: '/weibo/list'
            ,cols: [[
                {checkbox: true, fixed: true}
                ,{field:'id', title: 'ID',  sort: true}
                ,{field:'text', title: '内容'}
                ,{field:'screenName', title: '版权来源'}
                ,{field : "createdAt" , title : "发布时间" , templet: function (d) {
                        var newDate = new Date(d.createdAt);
                        return newDate.getFullYear() + "-" +
                            (newDate.getMonth() + 1) + "-" + newDate.getDate()
                            + " " + newDate.getHours() + ":" + newDate.getMinutes() + ":" + newDate.getSeconds();
                    }}
                // ,{field:'sign', title: '签名'}
                // ,{field:'experience', title: '积分', sort: true, width:80}
                // ,{field:'score', title: '评分', sort: true, width:80}
                // ,{field:'classify', title: '职业', width:80}
                // ,{field:'wealth', title: '财富', sort: true, width:135}
            ]]
            ,id: 'testReload'
            ,page: true
            ,height: 310
        });

        var $ = layui.$, active = {
            reload: function(){
                var demoReload = $('#demoReload');

                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    ,where: {
                        key: {
                            id: demoReload.val()
                        }
                    }
                });
            }
        };

        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

    });
</script>

</body>
</html>
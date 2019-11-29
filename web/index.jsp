<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<script type="text/javascript" src="/js/jquery-3.4.1.js"></script>

<%--<body>--%>
<%--手机号：<input type="text" name="phone" id="phone"><br><br>--%>
<%--<input type="button" value="点击获取" id="btn">--%>
<%--</body>--%>
<%--<script>--%>
<%--$(function () {--%>
<%--$("#phone").blur(function () {--%>
<%--var phone=$("#phone").val();--%>
<%--$.ajax({--%>
<%--type: "get",--%>
<%--url: "/ajax",--%>
<%--data: {phone:phone},--%>
<%--dataType: "text",--%>
<%--success: function (data) {--%>
<%--if (data==500){--%>
<%--alert("该手机号已注册");--%>
<%--} else {--%>
<%--alert("注册成功");--%>
<%--}--%>
<%--},--%>
<%--error: function () {--%>

<%--}--%>
<%--})--%>
<%--})--%>
<%--})--%>


<%--// $(function () {--%>
<%--//     $.ajax({--%>
<%--//         type:"get",--%>
<%--//         url:"/login",--%>
<%--//         data:"",--%>
<%--//         dataType:"text",--%>
<%--//         success:function (data) {--%>
<%--//             alert(data)--%>
<%--//         },--%>
<%--//         error:function () {--%>
<%--//--%>
<%--//         }--%>
<%--//     })--%>
<%--// })--%>
<%--</script>--%>
<script>
    $(function () {
        $.ajax({
            url: "/province",
            type: "get",
            data: "",
            dataType: "json",
            success: function (data) {
                var html = '<option value="-1">请选择</option>';
                for (var i = 0; i < data.length; i++) {
                    html = html + '<option value="' + data[i].id + '">' + data[i].name + '</option>';
                }

                $("#province").append(html);
            }
        });

        $("#province").change(function () {
            var id = $("#province option:selected").val();
            if(id==-1){
                $("#city").empty();
                return;
            }
            $.ajax({
                url: "/city",
                type: "get",
                data: {id: id},
                dataType: "json",
                success: function (data) {
                    $("#city").empty();
                    var html = '<option value="-1">请选择</option>';
                    for (var i = 0; i < data.length; i++) {
                        html = html + '<option value="' + data[i].id + '">' + data[i].name + '</option>';
                    }
                    $("#city").append(html);
                }
            });
        });

        $("#city").change(function () {
            var id = $("#city option:selected").val();
            if(id==-1){
                $("#region").empty();
                return;
            }
            $.ajax({
                url: "/region",
                type: "get",
                data: {id: id},
                dataType: "json",
                success: function (data) {
                    $("#region").empty();
                    var html = '<option value="-1">请选择</option>';
                    for (var i = 0; i < data.length; i++) {
                        html = html + '<option value="' + data[i].id + '">' + data[i].name + '</option>';
                    }
                    $("#region").append(html);
                }
            });

        });
    });
</script>
<body>
请选择省: <select id="province">

</select><br><br>
请选择市：<select id="city">

</select><br><br>

请选择区：<select id="region">

</select>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<body>
<h2>Hello World!</h2>
<button onclick="get()" value="获取">获取</button>
<img src="" id="imageId">
</body>
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script type='text/javascript'>

    function get() {
        alert("执行前");
        var path = '';
        $.ajax({
            url:'${pageContext.request.contextPath }/file/getCode',
            type:"post",
            data:{
                    appid:'wx82d06619359fabd5',
                    secret:'3bcb7e32e48478f1af90c7f5e385b57f'
            },
            success:function (e) {
                path ="${pageContext.request.contextPath }" +"/images/"+ e+".png";
                alert(path);
                document.getElementById("imageId").src = path ;
            }
        });
    }
</script>
</html>

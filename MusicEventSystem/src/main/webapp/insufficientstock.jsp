<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <!-- import Bootstrap -->
    <link rel="stylesheet" href="./bootstrap/bootstrap-select/dist/css/bootstrap-select.min.css">
    <script src="./assets/js/vendor/vendor.min.js"></script>
    <script src="./bootstrap/bootstrap-select/dist/js/bootstrap-select.min.js"></script>

    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- import font-awesome -->
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="application/javascript">
        function change(url,index){
            $(".list-group-item").removeClass("active");
            $(".list-group-item").eq(index).addClass("active");
            $("iframe").attr("src",url);
        }
    </script>
</head>
<body>
<div class="container text-center" style="margin-top: 100px;">
    <h1>Insufficient stock</h1>
    <p>Inventory is zero, or purchases exceed the limit.</p>
    <button class="btn btn-primary" onclick="goBack()">Back</button>
</div>
<script>
    function goBack() {
        window.history.back();
    }
</script>
</body>
</html>

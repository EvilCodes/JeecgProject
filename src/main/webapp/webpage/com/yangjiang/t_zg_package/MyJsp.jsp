<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>test</title>
<style>
*{margin:0;padding:0;}
#header{
    height:100px;
    background:blue;
}
#main{
    width:100%;
    overflow:hidden;
}
#main .main-left{
    width:50%;
    height:200px;
    background:lightgreen;
    float:left;
}
#main .main-right{
    width:50%;
    height:200px;
    float:right;
    background:red;
}
#main .main-right .right-l{
    width:80%;
    height:400px;
    background:yellow;
    float:left;
}
#main .main-right .right-r{
    width:20%;
    height:800px;
    background:pink;
    float:right;
}
#footer{
    height:500px;
    background:green;
}
</style>
</head>
<body>
<div id="header">head</div>
<div id="main">
    <div class="main-left">left</div>
    <div class="main-right">right</div>
</div>
<div id="footer">footer</div>
</body>
</html>
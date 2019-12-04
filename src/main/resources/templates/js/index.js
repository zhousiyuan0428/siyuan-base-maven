ReactDOM.render(
    <h1>Hello, world!</h1>,
    document.getElementById('root')
);

function jqajax() {
    //传入参数
    var urlName = $("#urlName").val();
    var url = "http://localhost:8080/skill/queryAll";//后台数据库接口
    // $.get(url,function(data,status){
    //     alert("数据: " + data + "\n状态: " + status);
    // });
    $.ajax({
        type:'get',
        url: url,
        contentType: "application/x-www-form-urlencoded",
        dataType: 'json',
        success: function(res){
            console.log(res)
        }
    })
}
$(function () {
    $('#acquisitionTime').datetimepicker({
        format: 'YYYY-MM-DD HH:mm',
        locale: moment.locale('zh-cn'),
        defaultDate: new Date()
    });
});

function saveQuestion(){
    let data = {
        questionDescribe: $(questionDescribe).val(),
        InputFile: $("#InputFile").val(),
    }
    console.log("保存疑问数据.....")
    console.log(data)
    // let url = "http://localhost:8082/question/add";//后台数据库接口
    // //let url = "http://localhost:8082/company/question/add";//生产库接口
    // $.ajax({
    //     type: 'post',
    //     url: url,
    //     data: data,
    //     contentType: "application/x-www-form-urlencoded",
    //     dataType: 'json',
    //     success: function (res) {
    //         console.log("返回参数为:" + res);
    //     }
    // })
}

function getTableInfo() {
    console.log("获取当日技能点数数据.....")
    let url = "http://localhost:8082/skill/queryAll";//后台数据库接口
    //let url = "http://localhost:8082/company/skill/queryAll";//生产库接口
    $.ajax({
        type: 'get',
        url: url,
        contentType: "application/x-www-form-urlencoded",
        dataType: 'json',
        success: function (res) {
            if (res.length == 0) {
                return;
            }
            let tbodyContent = "";
            let trClassWarning = "<tr class=\"warning\">";
            let trClassInfo = "<tr class=\"info\">";
            let trClassSuccess = "<tr class=\"success\">";
            for (let i = 0; i < 5; i++) {
                let trClass = "";
                if (res[i].skillPoints < 1) {
                    trClass = trClassWarning;
                } else if (res[i].skillPoints == 1) {
                    trClass = trClassInfo;
                } else if (res[i].skillPoints >= 2) {
                    trClass = trClassSuccess;
                } else {
                    trClass = "<tr>"
                }
                tbodyContent += trClass + '<td>' + res[i].skillType + '</td><td>' + res[i].skillDescribe + '</td><td>' + res[i].skillPoints + '</td><td>' + res[i].acquisitionTime + '</td></tr>';
                $("tbody").html(tbodyContent);
            }
        }
    })
}

function saveInfo() {
    let data = {
        skillPoints: $("#skillPoints").val(),
        skillType: $("#skillType").val(),
        skillDescribe: $("#skillDescribe").val(),
        acquisitionTime: $("#acquisitionTime1").val()
    }
    console.log(data)
    let url = "http://localhost:8082/skill/add";//后台数据库接口
    //let url = "http://localhost:8082/company/skill/add";//生产库接口
    $.ajax({
        type: 'post',
        url: url,
        data: data,
        contentType: "application/x-www-form-urlencoded",
        dataType: 'json',
        success: function (res) {
            console.log("返回参数为:" + res);
        }
    })
}
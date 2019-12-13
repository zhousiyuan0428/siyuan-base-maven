let questionId = 0;

$(function () {
    getTableInfo();
    getQuestionInfo();
});
/*** 获取当前阻碍事件的js方法 ****/
function getQuestionInfo() {
    console.log("事件 - 获取阻碍事件的数据 start")
    let url = "http://localhost:8080/question/getOneQuestion";//开发环境
    //let url = "http://localhost:8082/company/skill/queryAll";//生产库接口
    let botton = `<a class="glyphicon glyphicon-wrench btn btn-warning btn-sm" aria-hidden="true"` +
        `data-toggle="modal" data-target="#modal-solution-add"></a>`
    $.ajax({
        type: 'get',
        url: url,
        contentType: "application/x-www-form-urlencoded",
        dataType: 'json',
        success: function (res) {
            console.log("事件 - 获取阻碍事件的数据 end ")
            $("#questionBroad").html(botton + "&nbsp;&nbsp;&nbsp;&nbsp;" + res.thingDescribe)
            //绑定全局变量
            $("#solutionForQuestion").html("<h5>"+res.thingDescribe+"</h5>");
            $("#questionId").val(res.id);
        }
    })
}
/*** 新增当前阻碍事件的js方法 ****/
function saveQuestion() {
    let data = {
        thingDescribe: $("#thingDescribe").val(),
        skillType: $("#skillType").val(),
        InputFile: $("#InputFile").val(),
    }
    console.log("事件 - 保存事件数据 start")
    console.log(data)
    let url = "http://localhost:8080/question/add";//后台数据库接口
    //let url = "http://localhost:8082/company/question/add";//生产库接口
    $.ajax({
        type: 'post',
        url: url,
        data: data,
        dataType: 'JSON',
        contentType: "application/x-www-form-urlencoded",
        success: function (res) {
            console.log("事件 - 保存事件数据 end"),
            $('#modal-question-add').modal('hide')
            getQuestionInfo();
        }
    })
}
/*** 新增当前阻碍事件解决方案的js方法 ****/
function saveSolution() {
    let data = {
        questionId:$("#questionId").val(),
        solutionDescribe: $("#solutionDescribe").val(),
        solutionPicture: $("#solutionPicture").val(),
    }
    console.log("事件 - 保存方案数据 start")
    console.log(data)
    let url = "http://localhost:8080/solution/save";//后台数据库接口
    //let url = "http://localhost:8082/company/question/add";//生产库接口
    $.ajax({
        type: 'post',
        url: url,
        data: data,
        dataType: 'JSON',
        contentType: "application/x-www-form-urlencoded",
        success: function (res) {
            console.log("事件 - 保存方案数据 end "+res.resultCode)
            $('#modal-solution-add').modal('hide');
        }
    })
}

/*** 获取今日技能点数的js方法 ****/
function getTableInfo() {
    console.log("技能点 - 获取当日技能点数数据.....")
    let url = "http://localhost:8080/skill/queryAll";//开发环境
    //let url = "http://localhost:8082/company/skill/queryAll";//生产库接口
    $.ajax({
        type: 'get',
        url: url,
        contentType: "application/x-www-form-urlencoded",
        dataType: 'json',
        success: function (res) {
            console.log("技能点 - 获取完成 end")
            if (res.length == 0) {
                return;
            }
            let tbodyContent = "";
            let trClassWarning = "<tr class=\"warning\">";
            let trClassInfo = "<tr class=\"info\">";
            let trClassSuccess = "<tr class=\"success\">";
            for (let i = 0; i < res.length; i++) {
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

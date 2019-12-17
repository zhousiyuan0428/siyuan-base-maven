let questionId = 0;
let questionContent = "";
let barHundred = 100;
let blank1 = "&nbsp;";
let blank2 = "&nbsp;&nbsp;&nbsp;&nbsp;";

$(function () {
    getThingRecordInfo(1);
    getTableInfo();
});
/** JQuery 定时器 **/
setInterval(progressBarFlush, 36000);

/*** 获取事件信息的js方法 ****/
function getThingRecordInfo(thingStatus) {
    let data = {
        "thingStatus":thingStatus
    }
    let url = "http://localhost:8080/thingRecord/getInfo";//开发环境
    //let url = "http://localhost:8082/company/thingRecord/getInfo";//生产库接口
    $.ajax({
        type: 'get',
        url: url,
        data: data,
        contentType: "application/x-www-form-urlencoded",
        dataType: 'json',
        success: function (res) {
            if(res.length == 0){
                return;
            }
            if(thingStatus == 1){
                //绑定全局变量
                questionId = res[0].id;
                questionContent = res[0].thingDescribe;
                //按钮组和方案黑板内容的渲染
                accumulateButton(1);
                $("#solutionForQuestion").html(questionContent);
                //调用同样的方法查询当前挂起的任务
                getThingRecordInfo(2)
            }
            if(thingStatus == 2){
                let SuspendContent = "";
                for (let i = 0; i < res.length; i++) {
                    SuspendContent+=res[i].thingDescribe
                }
                $("#SuspendContent").html(SuspendContent);
            }
        }
    })
}

/*** 新增阻碍事件的js方法 ****/
function addThingRecord() {
    let data = {
        id: questionId,
        thingDescribe: $("#thingDescribe").val(),
        skillType: $("#skillType").val(),
        InputFile: $("#InputFile").val(),
    }
    console.log(data)
    let url = "http://localhost:8080/thingRecord/add";//后台数据库接口
    //let url = "http://localhost:8082/company/thingRecord/add";//生产库接口
    $.ajax({
        type: 'post',
        url: url,
        data: data,
        dataType: 'JSON',
        contentType: "application/x-www-form-urlencoded",
        success: function (res) {
            //根据保存结果给出用户提示
            if(res.ressultCode=="0000"){
                console.log("新增成功")
            }
            //隐藏模态框重新查询
            $('#modal-question-add').modal('hide')
            getThingRecordInfo(1);
        }
    })
}

/*** 新增当前阻碍事件解决方案的js方法 ****/
function updateThingRecord() {
    let data = {
        id: questionId,
        solutionDescribe: $("#solutionDescribe").val(),
    }
    console.log(data)
    let url = "http://localhost:8080/thingRecord/update";//后台数据库接口
    //let url = "http://localhost:8082/company/thingRecord/update";//生产库接口
    $.ajax({
        type: 'post',
        url: url,
        data: data,
        dataType: 'JSON',
        contentType: "application/x-www-form-urlencoded",
        success: function (res) {
            console.log("事件 - 保存方案数据 end " + res.resultCode)
            $('#modal-solution-add').modal('hide');
            $('#questionBroad').empty();
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
            //let trClassInfo = "<tr class=\"info\">";
            let trClassSuccess = "<tr class=\"success\">";
            for (let i = 0; i < res.length; i++) {
                let trClass = "";
                if (res[i].skillPoints < 1) {
                    trClass = trClassSuccess;
                } else if (res[i].skillPoints >= 2.5) {
                    trClass = trClassWarning;
                } else {
                    trClass = "<tr>"
                }
                tbodyContent += trClass + '<td>' + res[i].skillType + '</td><td>' + res[i].skillDescribe + '</td><td>' + res[i].skillPoints + '</td><td>' + res[i].acquisitionTime + '</td></tr>';
                $("tbody").html(tbodyContent);
            }
        }
    })
}

/*** 挂起当前任务的js方法 ****/
function HangUpTask() {
    let data = {
        thingId: $("#questionId").val(),
        questionContent: questionContent,
    }
    console.log(data);
    let bottonStop = `<a class="glyphicon glyphicon-off btn btn-primary btn-xs" aria-hidden="true"` +
        `onclick="test()" " ></a>`;
    let originalContent = $("#SuspendContent").html();
    let addContetnt = "<h5>" + bottonStop + blank2 + questionContent + "</h5>";
    $("#SuspendContent").html(originalContent+addContetnt);
}

/*** 暂停当前任务的js方法 ****/
function SuspendTask() {
    let data = {
        thingId: $("#questionId").val(),
        questionContent: questionContent,
    }
    let SuspendProgress =
        '<div class="progress">' +
        '<div id="progressBar" class="progress-bar progress-bar-success progress-bar-striped active" role="progressbar" aria-valuenow="25"' +
        ' aria-valuemin="0" aria-valuemax="100" style="width: 100%">' +
        `<span id="progressBarContent">100%</span></div>`
    $("#SuspendProgress").html(SuspendProgress);
    $("#questionBroad").empty();
    accumulateButton(2);
}

/*** 暂停任务进度条动态刷新的js方法 ****/
function progressBarFlush() {
    barHundred -=1;
    if(barHundred<=50){
        $('#progressBar').attr("class", "progress-bar progress-bar-warning progress-bar-striped active");
    }
    if(barHundred<=20){
        $('#progressBar').attr("class", "progress-bar progress-bar-danger progress-bar-striped active");
    }
    let str = "width: "+ barHundred +"%"
    $('#progressBar').attr("style", str);
    $('#progressBarContent').html(barHundred+"%");
}

/*** 继续当前任务的js方法 ****/
function GoOnTask() {
    let data = {
        thingId: $("#questionId").val(),
        questionContent: questionContent,
    }
    $("#SuspendProgress").empty();
    $("#questionBroad").empty();
    accumulateButton(1);
    barHundred = 100;
}

/** 组合按钮组内容控制 **/
function accumulateButton(type) {
    let buttonSolution = `<a class="glyphicon glyphicon-wrench btn btn-success btn-sm" aria-hidden="false"` +
        `data-toggle="modal" data-target="#modal-solution-add" title="解决方案" id="buttonSolution"></a>`;
    let buttonStop = `<a class="glyphicon glyphicon-stop btn btn-danger btn-sm" aria-hidden="true"` +
        `data-toggle="modal" data-target="#modal-question-add" title="挂起任务" id="buttonStop"></a>`;
    let buttonSuspend = `<a class="glyphicon glyphicon-pause btn btn-warning btn-sm" aria-hidden="true" ` +
        `onclick="SuspendTask()" title="暂停任务"></a>`;
    let buttonGoOn = `<a class="glyphicon glyphicon-play btn btn-info btn-sm" aria-hidden="true" ` +
        `onclick="GoOnTask()" title="继续任务"></a>`;
    //按钮组内容拼接
    if (type == 2) {
        $("#questionBroad").html(buttonSolution + blank1 + buttonStop + blank1 + buttonGoOn + blank2 + questionContent)
        ModelControl(false);
    } else {
        $("#questionBroad").html(buttonSolution + blank1 + buttonStop + blank1 + buttonSuspend + blank2 + questionContent)
        ModelControl(true);
    }
}

/** 模态框的控制 **/
function ModelControl(Flag) {
    if (Flag) {
        $('#addTask').attr("disabled", true);
        $('#addTask').attr("data-target", "#");
        $('#buttonSolution').attr("disabled", false);
        $('#buttonStop').attr("disabled", false);
        //$('#addTask').attr("data-target", "#modal-question-add");
        $('#buttonSolution').attr("data-target", "#modal-solution-add");
        $('#buttonStop').attr("data-target", "#modal-question-add");
    } else {
        $('#buttonSolution').attr("disabled", true);
        $('#buttonStop').attr("disabled", true);
        $('#addTask').attr("disabled", true);
        $('#addTask').attr("data-target", "#");
        $('#buttonSolution').attr("data-target", "#");
        $('#buttonStop').attr("data-target", "#");
    }
}
$(function(){
    getTableInfo()
});
function getTableInfo() {
    //传入参数
    var urlName = $("#urlName").val();
    var url = "http://localhost:8080/skill/queryAll";//后台数据库接口
    $.ajax({
        type:'get',
        url: url,
        contentType: "application/x-www-form-urlencoded",
        dataType: 'json',
        success: function(res){
            let tbodyContent = "";
            let trClassWarning = "<tr class=\"warning\">" ;
            let trClassInfo = "<tr class=\"info\">" ;
            let trClassSuccess = "<tr class=\"success\">" ;
            for (let i = 0; i < 5; i++) {
                let trClass = "";
                if(res[i].skillPoints<1){
                    trClass = trClassWarning;
                }else if(res[i].skillPoints==1){
                    trClass = trClassInfo;
                }else if(res[i].skillPoints>=2){
                    trClass = trClassSuccess;
                }else{
                    trClass = "<tr>"
                }
                tbodyContent+=trClass+'<td>'+res[i].skillType+'</td><td>'+res[i].skillDescribe+'</td><td>'+res[i].skillPoints+'</td><td>'+res[i].acquisitionTime+'</td></tr>';
                $("tbody").html(tbodyContent);
            }
        }
    })
}

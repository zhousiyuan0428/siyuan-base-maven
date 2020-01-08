// 基于准备好的dom，初始化echarts实例
let firstXInfo = "";
let content = {type: 'line', smooth: true, seriesLayoutBy: 'row'};
let sourceTemp = [];
let series = [
    {
        type: 'pie',
        id: 'pie',
        radius: '30%',
        center: ['50%', '30%'],
        label: {
            formatter: '{b}: {@' + firstXInfo + '} ({d}%)'
        },
        encode: {
            itemName: 'product',
            value: firstXInfo,
            tooltip: firstXInfo
        }
    }
];

var myChart = echarts.init(document.getElementById('main'));

setTimeout(function () {

    option = {
        legend: {},
        tooltip: {
            trigger: 'axis',
            showContent: false
        },
        dataset: {
            source: sourceTemp
        },
        xAxis: {type: 'category'},
        yAxis: {gridIndex: 0},
        grid: {top: '55%'},
        series: series
    };

    myChart.on('updateAxisPointer', function (event) {
        var xAxisInfo = event.axesInfo[0];
        if (xAxisInfo) {
            var dimension = xAxisInfo.value + 1;
            myChart.setOption({
                series: {
                    id: 'pie',
                    label: {
                        formatter: '{b}: {@[' + dimension + ']} ({d}%)'
                    },
                    encode: {
                        value: dimension,
                        tooltip: dimension
                    }
                }
            });
        }
    });

    myChart.setOption(option);

}, 800);

$(function () {
    getInfo();
});

function getInfo() {
    if (currentEnv == "local") {
        url = "http://localhost:8080/skill/getEchartInfo";//后台数据库接口
    } else {
        url = "http://localhost:8082/company/skill/getEchartInfo";//生产库接口
    }
    $.ajax({
        type: 'get',
        url: url,
        dataType: 'JSON',
        contentType: "application/x-www-form-urlencoded",
        success: function (res) {
            console.log(res);
            //折线图条数确定
            for (let i = 0; i < 4; i++) {
                series.push(content)
            }
            //第一行数据拼接
            let firstRow = [];
            firstRow.push("product");
            for (let i = 0; i < res.length; i++) {
                firstXInfo = res[0].name.slice(5, 10)
                firstRow.push(res[i].name.slice(5, 10))
            }
            sourceTemp.push(firstRow);
            //JavaSE行数据拼接
            let twoRow = [];
            twoRow.push("major-study");
            let threeRow = [];
            threeRow.push("major-practice");
            let fourRow = [];
            fourRow.push("relationShip");
            let fiveRow = [];
            fiveRow.push("assist-skill");
            for (let i = 0; i < res.length; i++) {
                let CurrentDaySum1 = 0;
                let CurrentDaySum2 = 0;
                let CurrentDaySum3 = 0;
                let CurrentDaySum4 = 0;
                for (let j = 0; j < res[i].skillCardEntities.length ;j++) {
                    if("M" == res[i].skillCardEntities[j].skillTypeFlag && "Dev" != res[i].skillCardEntities[j].skillType){
                        CurrentDaySum1 += parseFloat(res[i].skillCardEntities[j].skillPoints);
                    }
                    if("M" == res[i].skillCardEntities[j].skillTypeFlag && "Dev" == res[i].skillCardEntities[j].skillType){
                        CurrentDaySum2 += parseFloat(res[i].skillCardEntities[j].skillPoints);
                    }
                    if( "relationship" == res[i].skillCardEntities[j].skillType){
                        CurrentDaySum3 += parseFloat(res[i].skillCardEntities[j].skillPoints);
                    }
                    if( "A" == res[i].skillCardEntities[j].skillTypeFlag){
                        CurrentDaySum4 += parseFloat(res[i].skillCardEntities[j].skillPoints);
                    }
                }
                twoRow.push(CurrentDaySum1);
                threeRow.push(CurrentDaySum2);
                fourRow.push(CurrentDaySum3);
                fiveRow.push(CurrentDaySum4);
            }
            sourceTemp.push(twoRow);
            sourceTemp.push(threeRow);
            sourceTemp.push(fourRow);
            sourceTemp.push(fiveRow);
            console.log(sourceTemp)
        }
    })
}

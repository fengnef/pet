<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>数据报表</title>
</head>
<link rel="stylesheet" type="text/css" href="/static/plugins/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="/static/plugins/easyui/themes/icon.css">
<script type="text/javascript" src="/static/plugins/easyui/jquery.min.js"></script>
<script type="text/javascript" src="/static/plugins/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/static/plugins/echarts-2.2.7/echarts-all.js"></script>
<script type="text/javascript" src="/static/plugins/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">

    $(function () {

        load();

    })


    function load() {
        var myChart = echarts.init(document.getElementById('main'));

        option = {
            title: {
                text: '出入账报表',
                subtext: '含出账, 入账, 盈利'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: ['出账', '入账', '盈利']
            },
            toolbox: {
                show: true,
                feature: {
                    mark: {show: true},
                    dataView: {show: true, readOnly: false},
                    magicType: {show: true, type: ['line', 'bar']},
                    restore: {show: true},
                    saveAsImage: {show: true}
                }
            },
            calculable: true,
            xAxis: [
                {
                    type: 'category',
                    data:${requestScope.listData}
                }
            ],
            yAxis: [
                {
                    type: 'value'
                }
            ],
            series: [
                {
                    name: '出账',
                    type: 'bar',
                    data:${requestScope.listOut},
                    markPoint: {
                        data: [
                            {type: 'max', name: '最大值'},
                            {type: 'min', name: '最小值'}
                        ]
                    },
                    markLine: {
                        data: [
                            {type: 'average', name: '平均值'}
                        ]
                    }
                },
                {
                    name: '入账',
                    type: 'bar',
                    data:${requestScope.listIn},
                    markLine: {
                        data: [
                            {type: 'average', name: '平均值'}
                        ]
                    }
                },
                {
                    name: '盈利',
                    type: 'bar',
                    data:${requestScope.listIncome},
                    markLine: {
                        data: [
                            {type: 'average', name: '平均值'}
                        ]
                    }
                }
            ]
        };


// 为echarts对象加载数据
        myChart.clear();
        myChart.setOption(option, true);
    }

    function research() {
        var date = $("#dd").datebox("getValue");
        var year;
        var month;
        var url;
        if (date) {
            year = date.substring(0, 4);
            month = date.substring(5, 7);
        }
        var type = $("#state").combobox("getValue");

        if (type == 0) {
            url = "/line.do"
        }
        if (type == 1) {
            url = "/line_month.do"
        }
        if (type == 2) {
            url = "/line_year.do"
        }


        if (year && month) {
            window.location.href = url + "?year=" + year + "&month=" + month;
            console.log(url + "?year=" + year + "&month=" + month)
        }
        else if (year) {
            window.location.href = url + "?year=" + year;
        }
        else{
            window.location.href = url;
        }
    }

</script>
<body>
<form method="post" id="reportform" style="margin-top: 20px">
    <input id="dd" type="text" class="easyui-datebox"></input>&nbsp;
    <select id="state" class="easyui-combobox" panelHeight="auto" name="state" style="width:100px;">
        <option value="0">日报表</option>
        <option value="1">月报表</option>
        <option value="2">年报表</option>
    </select>&nbsp;
    <a href="javascript:;" class="easyui-linkbutton" iconCls="icon-search" text="查询" plain="true"
       onclick="research()"></a>&nbsp;&nbsp;<span>本报表是以选择日期为准分别显示日报表(选择日期当月每日数据)、月报表（选择日期当年每月数据）、年报表（每年数据）,
		不选则默认为<span
            style="color: red">当年当月</span>数据</span>
</form>

<div id="main" style="height:400px"></div>

</body>
</html>
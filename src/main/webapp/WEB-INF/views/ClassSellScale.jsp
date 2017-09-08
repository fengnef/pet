<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<html>
<head>
	<title>分类销售比例</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="/static/plugins/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="/static/plugins/easyui/themes/icon.css">
	<script type="text/javascript" src="/static/plugins/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="/static/plugins/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/static/plugins/echarts-2.2.7/echarts-all.js"></script>
    <script type="text/javascript" src="/static/plugins/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
    function load(kind) {
        var myChart = echarts.init(document.getElementById('main'));

        option = {
            title: {
                text: '分类销售比例',
                subtext: '',
                x: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                x: 'left',
                data:${requestScope.listData}
            },
            toolbox: {
                show: true,
                feature: {
                    mark: {show: true},
                    dataView: {show: true, readOnly: false},
                    magicType: {
                        show: true,
                        type: ['pie', 'funnel'],
                        option: {
                            funnel: {
                                x: '25%',
                                width: '50%',
                                funnelAlign: 'left',
                                max: 1548
                            }
                        }
                    },
                    restore: {show: true},
                    saveAsImage: {show: true}
                }
            },
            calculable: true,
            series: [
                {
                    name: '访问来源',
                    type: 'pie',
                    radius: '55%',
                    center: ['50%', '60%'],
                    data:${requestScope.listMap}
                }
            ]
        };
// 为echarts对象加载数据
        myChart.clear();
        myChart.setOption(option, true);
    }

    function research() {
        var date = $("#dd").datebox("getValue");    //日期
        var year="";
        var month="";
        var url;
        if (date) {
            year = date.substring(0, 4);
            month = date.substring(5, 7);
        }

        var kindway = $("#kindway").combobox("getValue");   //显示类型
        var type = $("#state").combobox("getValue");    //类型

        if (kindway == 0) {
            //销售额比例
            if (type == 0) {
                url = "/pie.do?date="+date;      //日报表
            }
            if (type == 1) {
                url = "/pie_month.do?year="+year+"&month="+month;   //月报表
            }
            if (type == 2) {
                url = "/pie_year.do?year="+year; //年报表
            }
        }

        if (kindway == 1) {
            //销售数量比例
            if (type == 0) {
                url = "/pies.do?date="+date ;     //日报表
            }
            if (type == 1) {
                url = "/pie_months.do?year="+year+"&month="+month;  //月报表
            }
            if (type == 2) {
                url = "/pie_years.do?year="+year; //年报表
            }
        }

        window.location.href = url;
//		if (year && month) {
//			window.location.href = url + "?year=" + year + "&month=" + month;
//			console.log(url + "?year=" + year + "&month=" + month)
//		}
//		else if (year) {
//			window.location.href = url + "?year=" + year;
//		} else {
//			window.location.href = url;
//		}
    }

    $(function () {

        load();

    })


</script>
<body>

<form method="post" id="reportform" style="margin-top: 20px">
	<input id="dd" type="text" class="easyui-datebox"></input>&nbsp;
	<select id="kindway" class="easyui-combobox" panelHeight="auto" name="state" style="width:100px;">
		<option value="0">销售额比例</option>
		<option value="1">销售数量比例</option>
	</select>&nbsp;
	<select id="state" class="easyui-combobox" panelHeight="auto" name="state" style="width:100px;">
		<option value="0">日报表</option>
		<option value="1">月报表</option>
		<option value="2">年报表</option>
	</select>&nbsp;
	<a href="javascript:;" class="easyui-linkbutton" iconCls="icon-search" text="查询" plain="true"
	   onclick="research()"></a>&nbsp;&nbsp;<span>本报表是以选择日期为准分别显示日报表(选择日期当月每日数据)、月报表（选择日期当年每月数据）、年报表（每年数据）,
		不选则默认为<span
			style="color: blue">当年当月</span>数据</span>
</form>

<div id="main" style="height:400px">
默认显示<span style="color: blue">当天</span>的数据,没有数据则显示无数据</div>
</body>
</html>
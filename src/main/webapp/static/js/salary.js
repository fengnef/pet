$(function () {

    // 初始化数据表格
    $("#salary_datagrid").datagrid({
        url: "/salary_list.do",
        fitColumns: true,
        striped: true,
        fit: true,
        pagination: true,
        singleSelect: true,
        toolbar: "#salary_tb",
        columns: [[{
            field: 'sn',
            title: '工号',
            width: 100
        }, {
            field: 'username',
            title: '姓名',
            width: 100
        }, {
            field: 'basicSalary',
            title: '基本工资',
            width: 100
        }, {
            field: 'postallowance',
            title: '岗位津贴',
            width: 100,
            formatter: postallowanceFormatter
        }, {
            field: 'trafficsubsidies',
            title: '交通补贴',
            width: 100,
            formatter: trafficsubsidiesFormatter
        }, {
            field: 'phonesubsidies',
            title: '话费补贴',
            width: 100,
            formatter: phonesubsidiesFormatter
        }, {
            field: 'subsidizedmeals',
            title: '餐补',
            width: 100,
            formatter: subsidizedmealsFormatter
        }, {
            field: 'fulltime',
            title: '全勤',
            width: 100,
            formatter: fulltimeFormatter
        }, {
            field: 'commission',
            title: '提成',
            width: 100,
            formatter: commissionFormatter
        }, {
            field: 'salary',
            title: '请假',
            width: 100
        }, {
            field: 'total',
            title: '总计',
            width: 100
        }

        ]]

    });

    //请假的字段格式化
    function postallowanceFormatter(value, row, index) {
        return row.positionName ? row.positionName.postallowance : ""
    }

    function trafficsubsidiesFormatter(value, row, index) {
        return row.positionName ? row.positionName.trafficsubsidies : ""
    }
    function phonesubsidiesFormatter(value, row, index) {
        return row.positionName ? row.positionName.phonesubsidies : ""
    }
    function subsidizedmealsFormatter(value, row, index) {
        return row.positionName ? row.positionName.subsidizedmeals : ""
    }
    function fulltimeFormatter(value, row, index) {
        return row.positionName ? row.positionName.fulltime : ""
    }
    function commissionFormatter(value, row, index) {
        return row.positionName ? row.positionName.commission : ""
    }




    /*// 部门格式化
     function posFormatter(value, row, index) {
     return value ? value.positionname : "";
     }

     // 获取部门的其他数据,但是field不能设置重复,我们就通过row来获取
     /!*
     * function deptFormatter1(value,row,index){ return row.dept?row.dept.id:""; }
     *!/
     // 状态格式化
     function stateFormatter(value, row, index) {
     return value ? "在职" : "<font color='red'>离职</font>";
     }

     // 是否管理员格式化
     function adminFormatter(value, row, index) {
     return value ? "是" : "否";
     }
     function sexFormatter(value, row, index) {
     return value ? "男" : "女";
     }
     */

});


// 高级查询
function searchForm() {
    // 获取关键字文本框的值
    var currentDate = $("[name='currentDate']").val();
    var username = $("[name='username']").val();

    $("#salary_datagrid").datagrid('load', {
        currentDate: currentDate,
        username: username
    });
}

// 查询全部数据
function reload() {
    // 清空查询条件的内容
    $("#currentDate").datebox('setValue','');
    $("[name='username']").val('');

    $("#salary_datagrid").datagrid('load', {});
}


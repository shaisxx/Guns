/**
 * 实训任务管理初始化
 */
var Task = {
    id: "TaskTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Task.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'uuid', visible: true, align: 'center', valign: 'middle'},
            {title: '课程实训管理表ID', field: 'courseTrainingId', visible: true, align: 'center', valign: 'middle'},
            {title: '实训任务名称', field: 'title', visible: true, align: 'center', valign: 'middle'},
            {title: '实训任务说明', field: 'taskDesc', visible: true, align: 'center', valign: 'middle'},
            {title: '任务状态：0-已创建未启动；1进行中；2-已挂起；3-已结束；11-正在启动中；12-正在挂起中；13-正在结束中', field: 'taskStatus', visible: true, align: 'center', valign: 'middle'},
            {title: '0-未删除 1-已删除(页面不可见)', field: 'logicDelete', visible: true, align: 'center', valign: 'middle'},
            {title: '创建者主键编号', field: 'createUserId', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createDate', visible: true, align: 'center', valign: 'middle'},
            {title: '修改者主键编号', field: 'modifyUserId', visible: true, align: 'center', valign: 'middle'},
            {title: '修改时间', field: 'modifyDate', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Task.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Task.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加实训任务
 */
Task.openAddTask = function () {
    var index = layer.open({
        type: 2,
        title: '添加实训任务',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/task/task_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看实训任务详情
 */
Task.openTaskDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '实训任务详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/task/task_update/' + Task.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除实训任务
 */
Task.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/task/delete", function (data) {
            Feng.success("删除成功!");
            Task.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("taskId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询实训任务列表
 */
Task.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Task.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Task.initColumn();
    var table = new BSTable(Task.id, "/task/list", defaultColunms);
    table.setPaginationType("client");
    Task.table = table.init();
});

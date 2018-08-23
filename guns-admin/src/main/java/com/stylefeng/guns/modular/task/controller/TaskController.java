package com.stylefeng.guns.modular.task.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.task.model.Task;
import com.stylefeng.guns.modular.task.service.ITaskService;

/**
 * 实训任务控制器
 *
 * @author fengshuonan
 * @Date 2018-08-23 11:38:51
 */
@Controller
@RequestMapping("/task")
public class TaskController extends BaseController {

    private String PREFIX = "/task/task/";

    @Autowired
    private ITaskService taskService;

    /**
     * 跳转到实训任务首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "task.html";
    }

    /**
     * 跳转到添加实训任务
     */
    @RequestMapping("/task_add")
    public String taskAdd() {
        return PREFIX + "task_add.html";
    }

    /**
     * 跳转到修改实训任务
     */
    @RequestMapping("/task_update/{taskId}")
    public String taskUpdate(@PathVariable Integer taskId, Model model) {
        Task task = taskService.selectById(taskId);
        model.addAttribute("item",task);
        LogObjectHolder.me().set(task);
        return PREFIX + "task_edit.html";
    }

    /**
     * 获取实训任务列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return taskService.selectList(null);
    }

    /**
     * 新增实训任务
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Task task) {
        taskService.insert(task);
        return SUCCESS_TIP;
    }

    /**
     * 删除实训任务
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer taskId) {
        taskService.deleteById(taskId);
        return SUCCESS_TIP;
    }

    /**
     * 修改实训任务
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Task task) {
        taskService.updateById(task);
        return SUCCESS_TIP;
    }

    /**
     * 实训任务详情
     */
    @RequestMapping(value = "/detail/{taskId}")
    @ResponseBody
    public Object detail(@PathVariable("taskId") Integer taskId) {
        return taskService.selectById(taskId);
    }
}

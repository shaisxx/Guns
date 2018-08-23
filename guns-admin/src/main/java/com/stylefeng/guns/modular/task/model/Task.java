package com.stylefeng.guns.modular.task.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 实训任务表; InnoDB free: 74752 kB
 * </p>
 *
 * @author stylefeng
 * @since 2018-08-23
 */
@TableName("info_task")
public class Task extends Model<Task> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String uuid;
    /**
     * 课程实训管理表ID
     */
    @TableField("course_training_id")
    private Integer courseTrainingId;
    /**
     * 实训任务名称
     */
    private String title;
    /**
     * 实训任务说明
     */
    @TableField("task_desc")
    private String taskDesc;
    /**
     * 任务状态：0-已创建未启动；1进行中；2-已挂起；3-已结束；11-正在启动中；12-正在挂起中；13-正在结束中
     */
    @TableField("task_status")
    private Integer taskStatus;
    /**
     * 0-未删除 1-已删除(页面不可见)
     */
    @TableField("logic_delete")
    private Integer logicDelete;
    /**
     * 创建者主键编号
     */
    @TableField("create_user_id")
    private Integer createUserId;
    /**
     * 创建时间
     */
    @TableField("create_date")
    private Date createDate;
    /**
     * 修改者主键编号
     */
    @TableField("modify_user_id")
    private Integer modifyUserId;
    /**
     * 修改时间
     */
    @TableField("modify_date")
    private Date modifyDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getCourseTrainingId() {
        return courseTrainingId;
    }

    public void setCourseTrainingId(Integer courseTrainingId) {
        this.courseTrainingId = courseTrainingId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Integer getLogicDelete() {
        return logicDelete;
    }

    public void setLogicDelete(Integer logicDelete) {
        this.logicDelete = logicDelete;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Integer modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Task{" +
        "id=" + id +
        ", uuid=" + uuid +
        ", courseTrainingId=" + courseTrainingId +
        ", title=" + title +
        ", taskDesc=" + taskDesc +
        ", taskStatus=" + taskStatus +
        ", logicDelete=" + logicDelete +
        ", createUserId=" + createUserId +
        ", createDate=" + createDate +
        ", modifyUserId=" + modifyUserId +
        ", modifyDate=" + modifyDate +
        "}";
    }
}

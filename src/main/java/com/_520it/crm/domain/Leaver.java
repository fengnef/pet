package com._520it.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Leaver {
    private Long id;
    //请假类别
    private LeaveClass leaveClass;
    //请假事由
    private String leavefor;
    //请假开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone ="GMT+8")
    private Date leaveTimes;
    //请假结束时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone ="GMT+8")
    private Date leaveTimed;
    //请假时长(天)
    private Integer leaveDuration;
    //领导意见
    private String leaderShipoption;
    //是否正常请假
    private Boolean isLeave;
    //状态
    private Boolean state;
    //取消原因
    private String reason;

    private Employee employee;
}
package com._520it.crm.util;

import com._520it.crm.domain.Employee;
import com._520it.crm.domain.Shopkeeper;
import com._520it.crm.domain.Systemlog;
import com._520it.crm.service.ISystemlogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

//日志工具类
public class LogUtil {
    @Autowired
    private ISystemlogService systemlogService;

    public void writelog(JoinPoint joinPoint) throws Exception {
        if (joinPoint.getTarget() instanceof ISystemlogService){
            return;
        }

        Systemlog systemlog = new Systemlog();
        //设置操作时间
        systemlog.setOptime(new Date());
        //设置操作用户
        Object shopkeeper = SecurityUtils.getSubject().getPrincipal();
        if (shopkeeper!=null) {
            systemlog.setOpuser((Shopkeeper) shopkeeper);
        }
        //设置操作表达式
        String target = joinPoint.getTarget().getClass().getName();
        String method = joinPoint.getSignature().getName();
        systemlog.setFunction(target+":"+method);
        //调用时传入的参数
        Object[] args = joinPoint.getArgs();
        systemlog.setParams(new ObjectMapper().writeValueAsString(args));
        //获取ip
        //获取与当前线程绑定在一起的请求对象
        HttpServletRequest request = ThreadUtil.getRequest();
        if (request!=null) {
        systemlog.setOpip(request.getRemoteHost());
        }

        systemlogService.insert(systemlog);
    }
}

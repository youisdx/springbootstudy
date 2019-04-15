package com.soft1721.jianyue.api.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
//@Async
public class TaskService {
    @Autowired
    private MailService mailService;

    @Scheduled(cron = "0 01 10 ? * *")
    public void proces(){
        mailService.sendMail("16422802@qq.com","赵鹏飞的邮件","你好啊");
        System.out.println("111");
    }
}
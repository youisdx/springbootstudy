package com.soft1721.jianyue.api.task;

public interface MailService {
    /**
     * 发送简单邮件
     */
    void sendMail(String to,String subject,String content);
}

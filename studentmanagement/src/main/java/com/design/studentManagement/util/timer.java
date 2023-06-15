package com.design.studentManagement.util;


import com.design.studentManagement.pojo.Payment;
import com.design.studentManagement.pojo.Users;
import com.design.studentManagement.service.PaymentService;
import com.design.studentManagement.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class timer {
    @Autowired
    private UsersService usersService;
    @Autowired
    private PaymentService paymentService;
    @Scheduled(cron = "0 */1 * * * ?") //每分钟执行一次
    //@Scheduled(cron = "0/30 * * * * ?")//每30秒执行一次
    public void test(){
        System.out.println("每1分钟执行一次");
        //获取当前年份
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
//        Date date = new Date();
//       // 获取所有未结业的学生的数据
//        List<Users> list =usersService.getAllStudentsList();
//        if(list.size()>0) //数据大于0才进来
//        {
//            for(Users users:list){
//                Payment payment = new Payment();
//                payment.setUserId(users.getId()); //用户id存到缴费记录表
//                if(users.getClasseId()!=null){
//                    payment.setClasseId(users.getClasseId()); //班级id存到缴费记录表
//                }
//                payment.setProfessionId(users.getProfessionId()); //专业id存到缴费记录表
//                payment.setYearClass(users.getYear()); //年级存到缴费记录表
//                payment.setIsPay(0);//一开始为未缴费
//                payment.setYear(Integer.parseInt(sdf.format(date))); //年份
//                paymentService.insert(payment);
//            }
//        }


    }

}

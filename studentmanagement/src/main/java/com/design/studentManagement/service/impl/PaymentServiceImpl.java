package com.design.studentManagement.service.impl;

import com.design.studentManagement.dto.Page;
import com.design.studentManagement.mapper.ClasseMapper;
import com.design.studentManagement.mapper.ProfessionMapper;
import com.design.studentManagement.pojo.Classe;
import com.design.studentManagement.pojo.Payment;
import com.design.studentManagement.mapper.PaymentMapper;
import com.design.studentManagement.pojo.Profession;
import com.design.studentManagement.pojo.Users;
import com.design.studentManagement.service.PaymentService;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.design.studentManagement.pojo.res.RestFulBean;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import com.design.studentManagement.util.PageUtil;
/**
 * (Payment)表服务实现类
 *
 * @author makejava
 * @since 2022-08-06 12:38:13
 */
@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;
    @Autowired
    private ProfessionMapper professionMapper;
    @Autowired
    private ClasseMapper classeMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传过来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<Payment> page) throws Exception{
        //前端传来的参数 第几页
        Integer pageNum =page.getPageNum();
        //mysql从0开始算起 0 为第一页 所以要减1   startNum 值为从第几条开始拿
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Payment> list= paymentMapper.getPageListByCondition(page);
        if(list.size()>0){  //数据大于0 才进去
            for(Payment payment: list){
               
            }
        }
        //根据条件查询数据的条数
        Integer count = paymentMapper.getPageListCount(page);
        //拿到总条数跟总页数 在前端渲染
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //讲查询的数据用map对象返回
        map.put("list",list);
        return RestFulBean.succ(map);
    }
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<Payment> queryById(Integer id) throws WriteException, IOException{
         Payment payment=this.paymentMapper.queryById(id);
        payment.setTotal(payment.getTuition()+payment.getStayFee());
        if(payment.getIsPay()==0)
        {
            payment.setPay("未缴费");
        }
        if(payment.getIsPay()==1)
        {
            payment.setPay("已缴费");
        }
        this.export(payment);
        payment.setExcelUrl("http://localhost:8087/file/payment.xls");
         return RestFulBean.succ(payment);
    }
    //导出excel表 学年注册名单
    public void export(Payment payment)throws WriteException, IOException {

        //1. 导出Excel的路径
        String filePath ="D:\\design\\images\\payment.xls";
        WritableWorkbook wwb =null;
        try {
            wwb = Workbook.createWorkbook(new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        WritableSheet sheet = wwb.createSheet("注册列表",0);//或者rwb.getSheet(0)获取第一个区域
        //设置titles
        String[] titles={"年份","专业","学费","住宿费","合计","缴费状态"};
        //单元格
        Label label=null;
        //第一行设置列名
        for(int i=0;i<titles.length;i++){

            label=new Label(i,0,titles[i]);
            //7：添加单元格
            sheet.addCell(label);
        }

        try {
                sheet.addCell(new Number(0,1,payment.getYear()));
                sheet.addCell(new Label(1,1,payment.getName()));
                //Label对应数据库String类型数据
                sheet.addCell(new Number(2,1,payment.getTuition()));
                //Label对应数据库String类型数据
                sheet.addCell(new Number(3,1,payment.getStayFee()));
                sheet.addCell(new Number(4,1,payment.getTotal()));
            sheet.addCell(new Label(5,1,payment.getPay()));
            wwb.write();

        } catch(Exception e) {
            e.printStackTrace();
        }
        finally{
            wwb.close();
        }
    }
    /**
     * 新增数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Payment payment) {
        this.paymentMapper.insert(payment);
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Payment payment) {
        this.paymentMapper.update(payment);
        return RestFulBean.succ("修改成功");
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public RestFulBean<String> deleteById(Integer id) {
        this.paymentMapper.deleteById(id);
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<List<Payment>> queryByUserId(Integer userId) {
        List<Payment> list =paymentMapper.queryByUserId(userId);
        if(list.size()>0){
            for(Payment payment :list){ //费用合计
                payment.setTotal(payment.getTuition()+payment.getStayFee());
                if(payment.getIsPay()==0)
                {
                    payment.setDisabled(false);
                }
                if(payment.getIsPay()==1)
                {
                    payment.setDisabled(true);
                }
            }
        }
        return RestFulBean.succ(list);
    }

    @Override
    public RestFulBean<String> pay(Payment payment) {
        this.paymentMapper.pay(payment);
        return RestFulBean.succ("缴费成功");
    }

    @Override
    public RestFulBean<Map> getTotalList(Page<Payment> page) throws Exception {
        //前端传来的参数 第几页
        Integer pageNum =page.getPageNum();
        //mysql从0开始算起 0 为第一页 所以要减1   startNum 值为从第几条开始拿
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Payment> list= paymentMapper.getTotalListByCondition(page);
        if(list.size()>0){  //数据大于0 才进去
            for(Payment payment: list){

                //根据年份 年级 专业 班级 统计总的学费
                List<Payment> payList =paymentMapper.getTotalFee(payment);
                //已交学费
                List<Payment> payedList =paymentMapper.getHavedTotalFee(payment);
                //未交学费
                List<Payment> unPayedList =paymentMapper.getUnhavedTotalFee(payment);
                //拿到专业的学费
                Profession profession=professionMapper.queryById(payment.getProfessionId());
                Classe classe =classeMapper.queryById(payment.getClasseId());
                payment.setProfessionName(profession.getName());
                payment.setClassName(classe.getClassName());
                payment.setTotal(payList.size()*(profession.getStayFee()+profession.getTuition())); //班级总学费
                payment.setHavedTotal(payedList.size()*(profession.getStayFee()+profession.getTuition())); //班级已交学费
                payment.setUnHavedTotal(unPayedList.size()*(profession.getStayFee()+profession.getTuition())); //班级未学费
            }
        }
        //这里修改一下 不用mysql分页 因为是分组的查出来数据条数有问题
        // 得到最大页数，总条数
        Map<Object, Object> map = PageUtil.pagingPrepare(page, list.size());
        // 得到分页数据
        List<Payment> pagetList = new LinkedList<>();
        int startIndex = (page.getPageNum() - 1) * page.getPageSize();
        int a = 0;
        while (a < page.getPageSize() && startIndex < list.size()) {
            a++;
            pagetList.add(list.get(startIndex++));
        }
        map.put("list", pagetList);
        return RestFulBean.succ(map);
    }
}

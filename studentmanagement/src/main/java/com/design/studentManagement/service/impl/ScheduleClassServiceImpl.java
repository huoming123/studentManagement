package com.design.studentManagement.service.impl;

import com.design.studentManagement.dto.Page;
import com.design.studentManagement.mapper.*;
import com.design.studentManagement.pojo.*;
import com.design.studentManagement.service.ScheduleClassService;
import com.design.studentManagement.util.PageUtil;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.design.studentManagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * (ScheduleClass)表服务实现类
 *
 * @author makejava
 * @since 2022-08-10 15:31:35
 */
@Service("scheduleClassService")
public class ScheduleClassServiceImpl implements ScheduleClassService {
    @Autowired
    private ScheduleClassMapper scheduleClassMapper;
    @Autowired
    private ChooseCourseMapper chooseCourseMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private ClasseMapper classeMapper;
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private ScoreMapper scoreMapper;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<ScheduleClass> queryById(Integer id) {
       ScheduleClass scheduleClass=this.scheduleClassMapper.queryById(id);
         return RestFulBean.succ(scheduleClass);
    }

    /**
     * 新增数据
     *
     * @param scheduleClass 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(ScheduleClass scheduleClass) {
        if(scheduleClass.getCourseId()==null)
        {
            RestFulBean.error("课程不能为空");
        }
        if(scheduleClass.getRoom()==null)
        {
            RestFulBean.error("课室不能为空");
        }
        if(scheduleClass.getUserId()==null)
        {
            RestFulBean.error("教师不能为空");
        }
        if(scheduleClass.getWeekDay()==null)
        {
            RestFulBean.error("时间不能为空");
        }
        if(scheduleClass.getStartTime()==null)
        {
            RestFulBean.error("时间段不能为空");
        }
        if(scheduleClass.getEndTime()==null)
        {
            RestFulBean.error("时间段不能为空");
        }
        if (scheduleClass.getStartTime().equals(scheduleClass.getEndTime())) {
            return RestFulBean.error("时间段不能相等");
        }
        if(scheduleClass.getElective()!=null && scheduleClass.getElective()==1)
        {
            scheduleClass.setClasseId(1); //如果是选修课班级设置为1 为选修班

        }
        Integer aa = null;
        //时间段根据：去切割数据 比如 08:00 切成 08 00
        System.out.println(scheduleClass.getStartTime().split(":")[0]+"隔开"+scheduleClass.getStartTime().split(":")[1]+"fdfdfd");
        String first = scheduleClass.getStartTime().split(":")[0]; //取第一个 比如 08
        if ("12".equals(first)) {  //判断开始时间段是否等于12
            return RestFulBean.error("时间段包含午休时间,请重新选择");
        }
        if (first.startsWith("0")) { //再判断切出来的第一个first 是否是0开头的 比如 08
            String result = first.split("0")[1]; //如果是 则根据0再切割 然后取第二个 则 取 8
            aa = Integer.parseInt(String.valueOf(result)); //把字符串转为整形
        } else {//如果不是0开头的 则 直接把它转为整形 比如 10
            aa = Integer.parseInt(String.valueOf(first));
        }
        //第二个时间的同理可得
        Integer bb = null;
        String second = scheduleClass.getEndTime().split(":")[0];
        if (second.startsWith("0")) {
            String result1 = second.split("0")[1];
            bb = Integer.parseInt(String.valueOf(result1));
        } else {
            bb = Integer.parseInt(String.valueOf(second));
        }
        //第二个时间段减去第一个时间
        if (bb - aa < 0) {
            return RestFulBean.error("开始时间段不能大于结束时间段");
        }
        if (bb - aa > 2) {
            return RestFulBean.error("课程只能选两节课");
        }

        scheduleClass.setRoom(scheduleClass.getRoom().trim());//课室去空 因为是字符串 可能会有空格
        //判断是否有相同的时间 选相同 的课室 如果有 返回错误信息
        ScheduleClass scheduled = scheduleClassMapper.getByTime(scheduleClass);
        if(scheduled!=null){
            return RestFulBean.error("该时间段该课室已有安排");
        }
        //判断同个时间段班级是否已经有课表了
        ScheduleClass scheduled1 = scheduleClassMapper.getByTime1(scheduleClass);
        if(scheduled1!=null){
            return RestFulBean.error("这个时间段该班级已经有课表了");
        }
        this.scheduleClassMapper.insert(scheduleClass);
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param scheduleClass 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(ScheduleClass scheduleClass) {
        this.scheduleClassMapper.update(scheduleClass);
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
        this.scheduleClassMapper.deleteById(id);
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<Map> getList(Page<ScheduleClass> page) throws Exception {
        //前端传来的参数 第几页
        Integer pageNum =page.getPageNum();
        //mysql从0开始算起 0 为第一页 所以要减1   startNum 值为从第几条开始拿
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<ScheduleClass> list= scheduleClassMapper.getPageListByCondition(page);
        if(list.size()>0){

        }
        //根据条件查询数据的条数
        Integer count = scheduleClassMapper.getPageListCount(page);
        //拿到总条数跟总页数 在前端渲染
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //讲查询的数据用map对象返回
        map.put("list",list);
        return RestFulBean.succ(map);
    }

    @Override
    public RestFulBean<Map> getChooseList(Page<ScheduleClass> page)throws Exception {
        //前端传来的参数 第几页
        Integer pageNum =page.getPageNum();
        //mysql从0开始算起 0 为第一页 所以要减1   startNum 值为从第几条开始拿
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<ScheduleClass> list= scheduleClassMapper.getPageChooseListByCondition(page);
        if(list.size()>0){
            for(ScheduleClass scheduleClass :list)
            {
                //根据课程id 统计出这门课被选了多少次
                List<ChooseCourse> chooseCourseList =chooseCourseMapper.getByCourseId(scheduleClass.getCourseId(),scheduleClass.getYear(),scheduleClass.getTerm());
                scheduleClass.setRemainNum(scheduleClass.getNum()-chooseCourseList.size()); //剩余人数
            }

        }
        //根据条件查询数据的条数
        Integer count = scheduleClassMapper.getPageChooseListCount(page);
        //拿到总条数跟总页数 在前端渲染
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //讲查询的数据用map对象返回
        map.put("list",list);
        return RestFulBean.succ(map);
    }

    @Override
    public RestFulBean<Map> getCourseByUserId(Page<ScheduleClass> page) throws Exception {
        List<ScheduleClass> list = scheduleClassMapper.getCourseByUserId(page);
        Map<Object, Object> map =new HashMap<>();
        if (list.size() > 0) {
            Map<String, ScheduleClass> onlyMap = new HashMap<>();
            for (ScheduleClass bcDto : list) {
                // 以教师id 班级id  课程id为key，去重集合 获取教师所教科目
                onlyMap.put(bcDto.getUserId().toString() + bcDto.getCourseId() + bcDto.getClasseId(), bcDto);
            }
            // 得到去重后的数据集合
            List<ScheduleClass> resultList = new LinkedList<>();
            for (String key : onlyMap.keySet()) {
                ScheduleClass value = onlyMap.get(key);
                resultList.add(value);
            }
            // 得到最大页数，总条数
            map = PageUtil.pagingPrepare(page, resultList.size());
            // 得到分页数据
            List<ScheduleClass> pagetList = new LinkedList<>();
            int startIndex = (page.getPageNum() - 1) * page.getPageSize();
            int a = 0;
            while (a < page.getPageSize() && startIndex < resultList.size()) {
                a++;
                pagetList.add(resultList.get(startIndex++));
            }
            map.put("list", pagetList);

        }
        return RestFulBean.succ(map);
    }

    @Override
    public RestFulBean<List<Score>> getStudentList(ScheduleClass scheduleClass) {
        List<Score> lsit =new ArrayList<>();
        if(scheduleClass.getClassName().equals("选修"))
        {

            lsit =scoreMapper.getScoreList1(scheduleClass); //找出该教师所教选修所有学生的成绩
        }
        else{
            //找出该教师所教班级所教科目所有学生的成绩
         lsit =scoreMapper.getScoreList(scheduleClass);
        }

        if(lsit.size()>0){ //如果成绩表 已有成绩了 直接渲染数据
            for(Score score:lsit){
                Classe classe =classeMapper.queryById(score.getClasseId());
                Course course=courseMapper.queryById(score.getCourseId());
                Users users =usersMapper.queryById(score.getUserId());
                score.setUserNo(users.getUserNo());
                score.setUserName(users.getUserName());
                score.setClassName(classe.getClassName());
                score.setCourseName(course.getCourseName());
            }
            return RestFulBean.succ(lsit);
        }
        else{ //如果没有成绩 则需要先把该班所有同学的先录入 然后老师录入成绩
            if(scheduleClass.getClassName().equals("选修"))
            {
                List<Score> studentList1 =scoreMapper.queryByScheduleClassId(scheduleClass.getId()); //找出选修课人员名单
                for(Score ss1 : studentList1){
                    Score sc =new Score();
                    sc.setClasseId(ss1.getClasseId());
                    sc.setCourseId(scheduleClass.getCourseId());
                    sc.setCreatedBy(scheduleClass.getCreatedBy());
                    sc.setUserId(ss1.getUserId());
                    sc.setYear(ss1.getYear());
                    sc.setTerm(ss1.getTerm());
                    sc.setElective(1);
                    scoreMapper.insert(sc);
                }
            }
           else{
                List<ScheduleClass> studentList=scheduleClassMapper.getStudentList(scheduleClass); //找出必修教师所有班级所教科目所有的学生名单
                for(ScheduleClass ss : studentList){
                    Score score =new Score();
                    score.setClasseId(scheduleClass.getClasseId());
                    score.setCourseId(scheduleClass.getCourseId());
                    score.setCreatedBy(scheduleClass.getCreatedBy());
                    score.setUserId(ss.getUserId());
                    score.setYear(scheduleClass.getYear());
                    score.setTerm(scheduleClass.getTerm());
                    score.setElective(0);
                    scoreMapper.insert(score);

                }
            }
            List<Score> lsit1 = new ArrayList<>();
            if(scheduleClass.getClassName().equals("选修"))
            {
                lsit1 =scoreMapper.getScoreList1(scheduleClass); //找出该教师所教选修所有学生的成绩
            }
            else{
                //找出该教师所教班级所教科目所有学生的成绩
                lsit1 =scoreMapper.getScoreList(scheduleClass);
            }
            for(Score score1:lsit1){
                Classe classe1 =classeMapper.queryById(score1.getClasseId());
                Course course1=courseMapper.queryById(score1.getCourseId());
                Users users1 =usersMapper.queryById(score1.getUserId());
                score1.setUserNo(users1.getUserNo());
                score1.setUserName(users1.getUserName());
                score1.setClassName(classe1.getClassName());
                score1.setCourseName(course1.getCourseName());
            }
            return RestFulBean.succ(lsit1);
        }
    }




}

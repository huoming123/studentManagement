package com.design.studentManagement.service.impl;

import com.design.studentManagement.dto.Page;
import com.design.studentManagement.mapper.*;
import com.design.studentManagement.pojo.*;
import com.design.studentManagement.service.ChooseCourseService;
import com.design.studentManagement.util.PageUtil;
import org.springframework.stereotype.Service;
import com.design.studentManagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * (ChooseCourse)表服务实现类
 *
 * @author makejava
 * @since 2022-08-11 11:23:09
 */
@Service("chooseCourseService")
public class ChooseCourseServiceImpl implements ChooseCourseService {
    @Autowired
    private ChooseCourseMapper chooseCourseMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private ScheduleClassMapper scheduleClassMapper;

    @Autowired
    private ClasseMapper classeMapper;
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private ScoreMapper scoreMapper;
    private Object obj = new Object();
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<ChooseCourse> queryById(Integer id) {
       ChooseCourse chooseCourse=this.chooseCourseMapper.queryById(id);
         return RestFulBean.succ(chooseCourse);
    }

    /**
     * 新增数据
     *
     * @param chooseCourse 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(ChooseCourse chooseCourse) {
        //多线程加锁
        synchronized (obj) {
            try{
                //根据用户id 跟课程id 判断是的重复选择课程
                ChooseCourse chooseCoursed =chooseCourseMapper.getByUserIdAndCourseId(chooseCourse);
                if(chooseCoursed !=null)
                {
                    return RestFulBean.error("你已选了该课程");
                }
                //根据课程id 找到对应课程限制的人数
                Course course = courseMapper.queryById(chooseCourse.getCourseId());
                //根据课程id 统计出这门课被选了多少次
                List<ChooseCourse> chooseCourseList =chooseCourseMapper.getByCourseId(chooseCourse.getCourseId(),chooseCourse.getYear(),chooseCourse.getTerm());
                if(chooseCourseList.size()<course.getNum())
                {
                    this.chooseCourseMapper.insert(chooseCourse);
                }
                else{
                    return RestFulBean.error("该课程已满人");
                }
            }
            catch (Exception e)
            { e.printStackTrace(); }
        }
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param chooseCourse 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(ChooseCourse chooseCourse) {
        this.chooseCourseMapper.update(chooseCourse);
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
        this.chooseCourseMapper.deleteById(id);
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<Map> getList(Page<ChooseCourse> page) throws Exception {
        //前端传来的参数 第几页
        Integer pageNum =page.getPageNum();
        //mysql从0开始算起 0 为第一页 所以要减1   startNum 值为从第几条开始拿
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<ChooseCourse> list= chooseCourseMapper.getPageListByCondition(page);
        List<ScheduleClass> list1 =new ArrayList<>();
        if(list.size()>0){
            for(ChooseCourse chooseCourse :list)
            {
                ScheduleClass  scheduleClass =  new ScheduleClass();
                //根据课表id 获取对应的数据在学生选课记录页面显示
                scheduleClass  =   scheduleClassMapper.getById(chooseCourse.getScheduleClassId());
                if(chooseCourse.getConfirm()==0) //这个条件为选课还没确定提交 那么学生可以退课跟提交操作
                {
                    scheduleClass.setDisabled(false);
                    scheduleClass.setConfirm("未提交");
                }
              if(chooseCourse.getConfirm()==1)//提交的数据就不给操作了
              { scheduleClass.setDisabled(true);
                    scheduleClass.setConfirm("已提交");
                }
                scheduleClass.setChooseId(chooseCourse.getId());
                list1.add(scheduleClass);
            }
        }
        //根据条件查询数据的条数
        Integer count = chooseCourseMapper.getPageListCount(page);
        //拿到总条数跟总页数 在前端渲染
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //讲查询的数据用map对象返回
        map.put("list",list1);
        return RestFulBean.succ(map);
    }


}

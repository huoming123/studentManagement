package com.design.studentManagement.service.impl;

import com.design.studentManagement.pojo.Classe;
import com.design.studentManagement.pojo.Course;
import com.design.studentManagement.mapper.CourseMapper;
import com.design.studentManagement.service.CourseService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.design.studentManagement.pojo.res.RestFulBean;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import com.design.studentManagement.util.PageUtil;
import com.design.studentManagement.dto.Page;
/**
 * (Course)表服务实现类
 *
 * @author makejava
 * @since 2022-08-08 22:12:17
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<Course> page) throws Exception{
        //前端传来的参数 第几页
        Integer pageNum =page.getPageNum();
        //mysql从0开始算起 0 为第一页 所以要减1   startNum 值为从第几条开始拿
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Course> list= courseMapper.getPageListByCondition(page);
        if(list.size()>0){  //数据大于0 才进去
            for(Course course: list){
               
            }
        }
        //根据条件查询数据的条数
        Integer count = courseMapper.getPageListCount(page);
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
    public RestFulBean<Course> queryById(Integer id) {
       Course course=this.courseMapper.queryById(id);
         return RestFulBean.succ(course);
    }

    /**
     * 新增数据
     *
     * @param course 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Course course) {
        //13位时间戳 不可能重复
        long timeMillis=System.currentTimeMillis(); //当前系统时间戳
        //取前7位作为一个课程编号
        String courseNo=String.valueOf(timeMillis).substring(0,7);
        course.setCourseNo(String.valueOf(courseNo));
        if(course.getCourseName()==null){
            return RestFulBean.error("课程名称不能为空");
        }
        if(course.getProfessionId()==null){
            return RestFulBean.error("专业不能为空");
        }
        if(course.getGpa()==null){
            return RestFulBean.error("学分不能为空");
        }
        this.courseMapper.insert(course);
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param course 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Course course) {
        if(course.getCourseName()==null){
            return RestFulBean.error("课程名称不能为空");
        }
        if(course.getProfessionId()==null){
            return RestFulBean.error("专业不能为空");
        }
        if(course.getGpa()==null){
            return RestFulBean.error("学分不能为空");
        }
        this.courseMapper.update(course);
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
        this.courseMapper.deleteById(id);
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<List<Course>> getByprofessionId(Integer professionId) {
        List<Course> list =courseMapper.getByprofessionId(professionId);
        return RestFulBean.succ(list);
    }
}

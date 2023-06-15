package com.design.studentManagement.service.impl;

import com.design.studentManagement.dto.Page;
import com.design.studentManagement.pojo.Application;
import com.design.studentManagement.mapper.ApplicationMapper;
import com.design.studentManagement.pojo.Course;
import com.design.studentManagement.service.ApplicationService;
import com.design.studentManagement.util.PageUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.design.studentManagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * (Application)表服务实现类
 *
 * @author makejava
 * @since 2022-08-10 09:08:58
 */
@Service("applicationService")
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationMapper applicationMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<Application> queryById(Integer id) {
       Application application=this.applicationMapper.queryById(id);
         return RestFulBean.succ(application);
    }

    /**
     * 新增数据
     *
     * @param application 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Application application) {
        if(application.getName()==null){
            return RestFulBean.error("课程不能为空");
        }
        if(application.getReason()==null){
            return RestFulBean.error("理由不能为空");
        }
        this.applicationMapper.insert(application);
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param application 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Application application) {
        this.applicationMapper.update(application);
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
        this.applicationMapper.deleteById(id);
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<Map> getList(Page<Application> page) throws Exception {
        //前端传来的参数 第几页
        Integer pageNum =page.getPageNum();
        //mysql从0开始算起 0 为第一页 所以要减1   startNum 值为从第几条开始拿
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Application> list= applicationMapper.getPageListByCondition(page);
        if(list.size()>0){  //数据大于0 才进去
            for(Application application: list){
               if(application.getChecked()==null){ //未审核的开题申请可以删除
                   application.setDisabled(false);
               }
               else{ //审核后的数据不给删除
                   application.setDisabled(true);
               }
            }
        }
        //根据条件查询数据的条数
        Integer count = applicationMapper.getPageListCount(page);
        //拿到总条数跟总页数 在前端渲染
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //讲查询的数据用map对象返回
        map.put("list",list);
        return RestFulBean.succ(map);
    }
}

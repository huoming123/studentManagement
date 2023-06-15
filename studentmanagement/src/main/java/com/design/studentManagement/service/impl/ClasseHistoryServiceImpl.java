package com.design.studentManagement.service.impl;

import com.design.studentManagement.pojo.ClasseHistory;
import com.design.studentManagement.mapper.ClasseHistoryMapper;
import com.design.studentManagement.service.ClasseHistoryService;
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
 * (ClasseHistory)表服务实现类
 *
 * @author makejava
 * @since 2022-08-13 12:43:58
 */
@Service("classeHistoryService")
public class ClasseHistoryServiceImpl implements ClasseHistoryService {
    @Autowired
    private ClasseHistoryMapper classeHistoryMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<ClasseHistory> page) throws Exception{
        //前端传来的参数 第几页
        Integer pageNum =page.getPageNum();
        //mysql从0开始算起 0 为第一页 所以要减1   startNum 值为从第几条开始拿
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<ClasseHistory> list= classeHistoryMapper.getPageListByCondition(page);
        if(list.size()>0){  //数据大于0 才进去
            for(ClasseHistory classeHistory: list){
               
            }
        }
        //根据条件查询数据的条数
        Integer count = classeHistoryMapper.getPageListCount(page);
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
    public RestFulBean<ClasseHistory> queryById(Integer id) {
       ClasseHistory classeHistory=this.classeHistoryMapper.queryById(id);
         return RestFulBean.succ(classeHistory);
    }

    /**
     * 新增数据
     *
     * @param classeHistory 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(ClasseHistory classeHistory) {
        if(classeHistory.getUserId()==null){
            return RestFulBean.error("教师不能为空");
        }
        if(classeHistory.getClasseId()==null){
            return RestFulBean.error("班级不能为空");
        }
        if(classeHistory.getYear()==null){
            return RestFulBean.error("年级不能为空");
        }
        //根据前端传来的参数判断是否该年级该班级已有数据了
        ClasseHistory classeHist=classeHistoryMapper.getClasseHistory(classeHistory);
        if(classeHist!=null){
            return RestFulBean.error("该年级该班级已有班主任");
        }
        this.classeHistoryMapper.insert(classeHistory);
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param classeHistory 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(ClasseHistory classeHistory) {
        this.classeHistoryMapper.update(classeHistory);
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
        this.classeHistoryMapper.deleteById(id);
         return RestFulBean.succ("删除成功");
    }
}

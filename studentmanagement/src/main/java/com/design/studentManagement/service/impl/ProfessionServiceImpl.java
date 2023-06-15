package com.design.studentManagement.service.impl;

import com.design.studentManagement.dto.Page;
import com.design.studentManagement.pojo.Profession;
import com.design.studentManagement.mapper.ProfessionMapper;
import com.design.studentManagement.pojo.Users;
import com.design.studentManagement.service.ProfessionService;
import com.design.studentManagement.util.PageUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.design.studentManagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * (Profession)表服务实现类
 *
 * @author makejava
 * @since 2022-08-05 10:45:22
 */
@Service("professionService")
public class ProfessionServiceImpl implements ProfessionService {
    @Autowired
    private ProfessionMapper professionMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<Profession> queryById(Integer id) {
       Profession profession=this.professionMapper.queryById(id);
         return RestFulBean.succ(profession);
    }

    /**
     * 新增数据
     *
     * @param profession 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Profession profession) {
        this.professionMapper.insert(profession);
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param profession 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Profession profession) {
        this.professionMapper.update(profession);
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
        this.professionMapper.deleteById(id);
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<List<Profession>> getList() {
        List<Profession> list= this.professionMapper.getList();
        return RestFulBean.succ(list);
    }

    @Override
    public RestFulBean<Map> getPageList(Page<Profession> page) throws Exception {
        //前端传来的参数 第几页
        Integer pageNum =page.getPageNum();
        //mysql从0开始算起 0 为第一页 所以要减1   startNum 值为从第几条开始拿
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Profession> list= professionMapper.getPageListByCondition(page);
        if(list.size()>0){
            for(Profession profession :list){ //费用合计
                profession.setTotal(profession.getTuition()+profession.getStayFee());
            }
        }
        //根据条件查询数据的条数
        Integer count = professionMapper.getPageListCount(page);
        //拿到总条数跟总页数 在前端渲染
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //讲查询的数据用map对象返回
        map.put("list",list);
        return RestFulBean.succ(map);
    }
}

package com.design.studentManagement.service;

import com.design.studentManagement.dto.Page;
import com.design.studentManagement.pojo.Users;
import com.design.studentManagement.pojo.res.RestFulBean;
import jxl.write.WriteException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * (Users)表服务接口
 *
 * @author makejava
 * @since 2022-08-04 15:05:48
 */
public interface UsersService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Users> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Users users);

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Users users);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<Map<String, Object>> login(Users users);

    RestFulBean<Map> getList(Page<Users> page)throws Exception;

    RestFulBean<Map> upload(MultipartFile coverFile) throws Exception;

    RestFulBean<Map> downExcel(Page<Users> page)throws WriteException, IOException;

    RestFulBean<Map> getCountList(Page<Users> page)throws Exception;

    RestFulBean<Map> downExcelCount(Page<Users> page)throws WriteException, IOException;

    List<Users> getAllStudentsList();

    RestFulBean<String> group(List<Users> usersList);

    RestFulBean<List<Users>> getTeachList();

    RestFulBean<Map> getAbsenteeCountList(Page<Users> page)throws Exception;

    RestFulBean<String> updatePassword(Users users);
}

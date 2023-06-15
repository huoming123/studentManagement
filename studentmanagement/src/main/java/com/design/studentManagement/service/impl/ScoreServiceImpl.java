package com.design.studentManagement.service.impl;

import com.design.studentManagement.mapper.*;
import com.design.studentManagement.pojo.Classe;
import com.design.studentManagement.pojo.Course;
import com.design.studentManagement.pojo.Score;
import com.design.studentManagement.pojo.Users;
import com.design.studentManagement.service.ScoreService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import com.design.studentManagement.util.PageUtil;
import com.design.studentManagement.dto.Page;
/**
 * (Score)表服务实现类
 *
 * @author makejava
 * @since 2022-08-08 23:10:18
 */
@Service("scoreService")
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;
    @Autowired
    private ScheduleClassMapper scheduleClassMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private ClasseMapper classeMapper;
    @Autowired
    private UsersMapper usersMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<Score> page) throws Exception{
        //前端传来的参数 第几页
        Integer pageNum =page.getPageNum();
        //mysql从0开始算起 0 为第一页 所以要减1   startNum 值为从第几条开始拿
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Score> list= scoreMapper.getPageListByCondition(page);
        if(list.size()>0){  //数据大于0 才进去
            for(Score score: list){
               
            }
        }
        //根据条件查询数据的条数
        Integer count = scoreMapper.getPageListCount(page);
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
    public RestFulBean<Score> queryById(Integer id) {
       Score score=this.scoreMapper.queryById(id);
         return RestFulBean.succ(score);
    }

    /**
     * 新增数据
     *
     * @param score 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Score score) {
        if(score.getScore()==null){
            return RestFulBean.error("分数不能为空");
        }
        this.scoreMapper.insert(score);
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param score 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Score score) {
        this.scoreMapper.update(score);
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
        this.scoreMapper.deleteById(id);
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<List<Score>> getScoreList(Score score) {
      return null;
    }

    @Override
    public RestFulBean<Map> export(Score score) throws WriteException, IOException {
        Map map =new HashMap();
        if(score.getScoreList().size()>0){
            if(score.getParam().equals("score")){
                this.exportExcel(score.getScoreList());
                map.put("excelUrl","http://localhost:8087/file/scoreList.xls");
                return RestFulBean.succ(map);
            }
            else{
                this.exportExcel1(score.getScoreList());
                map.put("excelUrl","http://localhost:8087/file/studentList.xls");
                return RestFulBean.succ(map);
            }
        }
        else{
            return RestFulBean.error("没有数据");
        }
    }

    @Override
    public RestFulBean<List<Score>> getStudentScoreList(Page<Score> page) {
        List<Score> list= scoreMapper.getStudentScoreList(page);
        if(list.size()>0)
        {
            for(Score score :list){
                Classe classe =classeMapper.queryById(score.getClasseId());
                Course course=courseMapper.queryById(score.getCourseId());
                Users users =usersMapper.queryById(score.getUserId());
                score.setUserNo(users.getUserNo());
                score.setUserName(users.getUserName());
                score.setClassName(classe.getClassName());
                score.setCourseName(course.getCourseName());
                if(score.getElective()==1){
                    score.setElectived("选修");
                }
                if(score.getElective()==0){
                    score.setElectived("必修");
                }
            }
        }
        return RestFulBean.succ(list);
    }

    //导出excel表 成绩
    public void exportExcel1(List<Score> list)throws WriteException, IOException {

        //1. 导出Excel的路径
        String filePath ="D:\\design\\images\\studentList.xls";
        WritableWorkbook wwb =null;
        try {
            wwb = Workbook.createWorkbook(new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        WritableSheet sheet = wwb.createSheet("学生名单",0);//或者rwb.getSheet(0)获取第一个区域
        //设置titles
        String[] titles={"年级","学期","班级","学号","姓名"};
        //单元格
        Label label=null;
        //第一行设置列名
        for(int i=0;i<titles.length;i++){

            label=new Label(i,0,titles[i]);
            //7：添加单元格
            sheet.addCell(label);
        }

        try {

            for(int i = 0; i<list.size(); i++){
                sheet.addCell(new jxl.write.Number(0,i+1,list.get(i).getYear()));
                sheet.addCell(new Label(1,i+1,list.get(i).getTerm()));
                //Label对应数据库String类型数据
                sheet.addCell(new Label(2,i+1,list.get(i).getClassName()));
                //Label对应数据库String类型数据
                sheet.addCell(new Label(3,i+1,list.get(i).getUserNo()));
                sheet.addCell(new Label(4,i+1,list.get(i).getUserName()));
            }
            wwb.write();

        } catch(Exception e) {
            e.printStackTrace();
        }
        finally{
            wwb.close();
        }
    }
    //导出excel表 成绩
    public void exportExcel(List<Score> list)throws WriteException, IOException {

        //1. 导出Excel的路径
        String filePath ="D:\\design\\images\\scoreList.xls";
        WritableWorkbook wwb =null;
        try {
            wwb = Workbook.createWorkbook(new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        WritableSheet sheet = wwb.createSheet("成绩",0);//或者rwb.getSheet(0)获取第一个区域
        //设置titles
        String[] titles={"年级","学期","班级","学号","姓名","课程","成绩"};
        //单元格
        Label label=null;
        //第一行设置列名
        for(int i=0;i<titles.length;i++){

            label=new Label(i,0,titles[i]);
            //7：添加单元格
            sheet.addCell(label);
        }

        try {

            for(int i = 0; i<list.size(); i++){
                sheet.addCell(new jxl.write.Number(0,i+1,list.get(i).getYear()));
                sheet.addCell(new Label(1,i+1,list.get(i).getTerm()));
                //Label对应数据库String类型数据
                sheet.addCell(new Label(2,i+1,list.get(i).getClassName()));
                //Label对应数据库String类型数据
                sheet.addCell(new Label(3,i+1,list.get(i).getUserNo()));
                sheet.addCell(new Label(4,i+1,list.get(i).getUserName()));
                sheet.addCell(new Label(5,i+1,list.get(i).getCourseName()));
                if(list.get(i).getScore()!=null){
                    sheet.addCell(new Number(6,i+1,list.get(i).getScore()));
                }

            }
            wwb.write();

        } catch(Exception e) {
            e.printStackTrace();
        }
        finally{
            wwb.close();
        }
    }
}

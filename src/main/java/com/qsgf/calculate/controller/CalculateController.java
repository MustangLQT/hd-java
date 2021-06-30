package com.qsgf.calculate.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qsgf.calculate.dto.CalculateInput;
import com.qsgf.response.ReturnMsg;
import com.qsgf.utils.FileUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/calculate")
public class CalculateController {

    /**
    * @Description 提交计算
    * @Author  lqt
    * @Date   2021/6/29
    * @Param  input
    * @Return
    * @Exception
    *
    */
    @PostMapping("/submit")
    public ReturnMsg submitCalculate(@RequestBody CalculateInput input){
        try {
            String str = JSONObject.toJSONString(input);
            // todo 调用c++算法

            return ReturnMsg.consSuccess("计算成功");
        }catch (Exception e){
            e.printStackTrace();
            return ReturnMsg.consFail();
        }
    }
    /**
    * @Description 导入
    * @Author  lqt
    * @Date   2021/6/29
    * @Param  file
    * @Return
    * @Exception
    *
    */
    @PostMapping("/import")
    public ReturnMsg uploadFile(MultipartFile file){
        try{
            FileUtil.checkFile(file);
            Workbook workbook = FileUtil.getWorkBook(file);
            if(null == workbook){
                return ReturnMsg.consFail("文件内容为空！");
            }
            //获取表格的第一页
            Sheet sheet = workbook.getSheetAt(0);
            //获取该页有多少数据
            int rowNum = sheet.getLastRowNum();
            List<String> list = new ArrayList();
            //获取当前行
            Row row0 = sheet.getRow(0);
            for (int i = 1; i < 106; i++) {
                //获取当前行
                Row row = sheet.getRow(i);
                if (null == row || row.getPhysicalNumberOfCells() == 0) {
                    continue;
                }
                if(null == row.getCell(3)){
                    list.add(null);
                }else{
                    list.add(FileUtil.getCellValue(row.getCell(3)));
                }
            }
            CalculateInput calculateInput = new CalculateInput();
            Field[] fields = calculateInput.getClass().getDeclaredFields();
            for(int i = 0; i < fields.length; i++){
                Field f = fields[i];
                f.setAccessible(true);
                fields[i].set(calculateInput,list.get(i));
                // System.out.println("属性名:" + f.getName() + " 属性值:" + f.get(calculateInput));
            }
            String str = JSON.toJSONString(calculateInput);
            // todo 调用C++算法
            return ReturnMsg.consSuccess("上传成功！");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
            return ReturnMsg.consFail("上传失败！");
        }
    }

    // private String

    /**
    * @Description 模板下载
    * @Author  lqt
    * @Date   2021/6/29
    * @Param
    * @Return
    * @Exception
    *
    */
    @GetMapping("/download")
    public void downloadCalculateModel(HttpServletResponse response, HttpServletRequest request){

        // 以流的形式下载文件。
        try {
            //读取文件
//            InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("excel" + File.separator + "投资能力指标数据模板.xlsx");
//            InputStream fis = new BufferedInputStream(resourceAsStream);

            // ClassPathResource resource = new ClassPathResource("excel" + File.separator + "投资能力指标数据模板.xlsx");

            File file = new File(".","excel" + File.separator + "投资能力指标数据模板.xlsx");
            String filePath = file.getCanonicalPath();
            System.out.println(filePath);
            InputStream fis = new FileInputStream(filePath);
            System.out.println(fis);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            // response.reset();
            response.addHeader("Content-Length", "" + buffer.length);
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream; charset=utf-8");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-Disposition", "attachment;filename="+new String("投资能力指标数据模板.xlsx".getBytes("gbk"), "iso8859-1"));
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
            // resourceAsStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

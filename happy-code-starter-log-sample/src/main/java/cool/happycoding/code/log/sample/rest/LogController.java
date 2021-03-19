package cool.happycoding.code.log.sample.rest;

import cn.hutool.core.io.IoUtil;
import com.alibaba.fastjson.JSONObject;
import cool.happycoding.code.base.result.BaseResult;
import cool.happycoding.code.log.sample.dto.LogBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM_VALUE;

/**
 * description
 *
 * @author lanlanhappy 2021/03/19 2:47 下午
 */
@Slf4j
@Api(tags = "log组件使用测试")
@RestController
@RequestMapping("log")
public class LogController {

    @PostMapping("trace")
    @ApiOperation(value = "trace请求")
    public BaseResult<LogBean> trace(@RequestBody LogBean logBean){
        log.info("log bean:{}", JSONObject.toJSONString(logBean));
        return BaseResult.success(logBean);
    }

    @PostMapping("json")
    @ApiOperation(value = "json请求")
    public BaseResult<LogBean> json(@RequestBody LogBean logBean){
        return BaseResult.success(logBean);
    }

    @PostMapping("form")
    @ApiOperation(value = "form请求")
    public BaseResult<LogBean> form(LogBean logBean){
        return BaseResult.success(logBean);
    }

    @PostMapping("upload")
    @ApiOperation(value = "文件上传请求")
    public BaseResult<String> upload(@RequestParam("file")MultipartFile file){
        return BaseResult.success("fileName: "+file.getOriginalFilename()+", fileSize: "+file.getSize());
    }

    @SneakyThrows
    @GetMapping("download")
    @ApiOperation(value = "文件下载")
    public void download(HttpServletRequest request, HttpServletResponse response){
        File file = ResourceUtils.getFile("classpath:icon.jpg");
        response.setContentType(APPLICATION_OCTET_STREAM_VALUE);
        // 设置下载后的文件名 以及 header
        response.addHeader("Content-disposition",
                "attachment;fileName=" + file.getName());
        InputStream fis = new BufferedInputStream(new FileInputStream(file));
        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
        IoUtil.copy(fis, toClient);
        toClient.close();
        fis.close();
    }

}

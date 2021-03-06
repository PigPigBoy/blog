package group2.exception;

import group2.returnJson.Result;
import group2.returnJson.StatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author: KongKongBaby
 * @Date: 2020.02.18 19:06
 * @Description: 全局异常拦截处理
 */
@RestControllerAdvice(annotations = {RestController.class, Controller.class})
@Slf4j
public class ExceptionCatch {

    //----------------以下是系统预设异常--------------------
    @ExceptionHandler(value = {BindException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Result<Object> badRequest(BindException e) {
        log.error("参数绑定异常:\t原因：" + e.getCause() + "\t详情:" + e.getCause().getMessage());
        return Result.fail(StatusEnum.BAD_REQUEST);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Result<Object> argumentException(IllegalArgumentException e) {
        log.error("参数非法异常: \t原因：" + e.getCause() + "\t详情:" + e.getCause().getMessage());
        return Result.fail(StatusEnum.BAD_REQUEST);
    }

    @ExceptionHandler(value = {NoHandlerFoundException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public Result<Object> notFound(NoHandlerFoundException e) {
        log.error("资源未找到:\t原因：" + e.getCause() + "\t详情:" + e.getCause().getMessage());
        return Result.fail(StatusEnum.NOT_FOUND);
    }

    @ExceptionHandler(value = {MyBatisSystemException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<Object> mybatisException(MyBatisSystemException e) {
        log.error("mybatis异常:\t原因：" + e.getCause() + "\t详情:" + e.getCause().getMessage());
        return Result.fail(StatusEnum.MYBATIS_ERROR);
    }

    @ExceptionHandler(value = {SQLException.class, DataAccessException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<Object> databaseError(Exception e) {
        log.error("数据库异常: \t原因：" + e.getCause() + "\t详情:" + e.getCause().getMessage());
        return Result.fail(StatusEnum.DATABASE_ERROR);
    }

    @ExceptionHandler(value = {FileNotFoundException.class, IOException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<Object> fileException(RuntimeException e) {
        log.error("文件传输异常: \t原因：" + e.getCause() + "\t详情:" + e.getCause().getMessage());
        return Result.fail(StatusEnum.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {ClassCastException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<Object> formatException(ClassCastException e) {
        System.out.println("类型转换异常: \t原因：" + e.getCause() + "\t详情:" + e.getCause().getMessage());
        return Result.fail(StatusEnum.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {NullPointerException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Result<Object> NullPointerException(NullPointerException e) {
        log.error("参数为空异常: \t原因：" + e.getCause() + "\t详情:" + e.getCause().getMessage());
        return Result.fail(StatusEnum.INTERNAL_SERVER_ERROR);
    }

//    @ExceptionHandler(value = {UsernameNotFoundException.class})
//    @ResponseBody
//    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
//    public Result<Object> UsernameNotFoundException(UsernameNotFoundException e) {
//        log.error("用户认证异常: \t原因：" + e.getCause() + "\t详情:" + e.getCause().getMessage());
//        return Result.fail(StatusEnum.UNAUTHORIZED);
//    }

    @ExceptionHandler(value = {RuntimeException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<Object> otherException(RuntimeException e) {
        log.error("服务器异常: \t原因：" + e.getCause() + "\t详情:" + e.getCause().getMessage());
        return Result.fail(StatusEnum.INTERNAL_SERVER_ERROR);
    }
}


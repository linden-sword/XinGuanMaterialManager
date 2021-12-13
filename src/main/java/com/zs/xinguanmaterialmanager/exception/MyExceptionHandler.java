//package com.zs.xinguanmaterialmanager.exception;
//
//import com.zs.xinguanmaterialmanager.util.R;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@ControllerAdvice
//@ResponseBody
//public class MyExceptionHandler {
//
//
//    /**
//     * 算术运算异常
//     *
//     * @author Zanson
//     * @since 15:04 2021/12/11
//     **/
//    @ExceptionHandler(ArithmeticException.class)
//    public R exp1() {
//        return R.exp().setData("算术运算异常");
//    }
//
//
//    /**
//     * 空指针异常
//     *
//     * @author Zanson
//     * @since 15:05 2021/12/11
//     **/
//    @ExceptionHandler(NullPointerException.class)
//    public R exp2() {
//        return R.exp().setData("空指针异常");
//    }
//
//
////    /**
////     * 其它统一异常处理
////     *
////     * @author Zanson
////     * @since 15:06 2021/12/11
////     **/
////    @ExceptionHandler(Exception.class)
////    public R handlerException() {
////        return R.exp().setData("其它未知异常");
////    }
//}

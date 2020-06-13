package com.nbchen.utils;

import com.nbchen.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Slf4j
public class WebUtils {
    /**
     * 把Map中的值注入到对应的JavaBean属性中
     * @param value 要注入的Map参数
     * @param bean 要注入的JavaBean对象
     */
    public static <T> T copyParamToBean(Map value, T bean) {
        try {
            log.info("注入之前:{}",bean);
            BeanUtils.populate(bean,value);
            log.info("注入之后:{}",bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 字符串转换成int类型的数据
     * @param strInt 数字字符串
     * @param defaultValue 如果字符串为空,则默认返回该值
     * @return
     */
    public static int parseInt(String strInt,int defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (NumberFormatException e) {
//            e.printStackTrace();
        }
        return defaultValue;
    }
}

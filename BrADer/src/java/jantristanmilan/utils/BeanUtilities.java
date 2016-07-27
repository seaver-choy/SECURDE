package jantristanmilan.utils;


import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

public class BeanUtilities {

    /**
     * Populates the JavaBeans properties of the specified bean,
     * based on the specified name/value pairs in the servlet request.
     *
     * @param bean the Java bean to be populated with values.
     * @param request the servlet request.
     */
    public static void populate(Object bean, HttpServletRequest request) {
        try {
            BeanUtils.populate(bean, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
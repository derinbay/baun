package com.n11.selenium.helpers;

import com.n11.selenium.pages.Page;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.openqa.selenium.WebElement;
import java.lang.reflect.Field;

/**
 * Created by Taylan on 25/12/2016.
 */
public class PageUtils {

    /**
     * This method gets the page element from given string
     * @param elementName is the name of element
     * @param page is the object class of the element
     * @return WebElement
     */
    public WebElement get(String elementName, Page page) {
        Class<?> pageClass = page.getClass();
        Field field = FieldUtils.getField(pageClass, elementName, true);
        field.setAccessible(true);
        WebElement element;
        try {
            element = (WebElement) field.get(page);
        } catch (Exception e) {
            System.err.println(e);//NOSONAR
            throw new IllegalStateException("Exception on accessing field {" + elementName + "} of page");
        }

        return element;
    }
}

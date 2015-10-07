package com.mybatis.converter;
import org.springframework.core.convert.converter.Converter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Created by pl on 2015/9/25.
 */
public class DateConverter implements Converter<String,Date> {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    @Override
    public Date convert(String source) {
        Date targetDate = null;
        try {
             targetDate = sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return targetDate;
    }
}

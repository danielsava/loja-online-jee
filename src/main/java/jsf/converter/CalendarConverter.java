package jsf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@FacesConverter(forClass = Calendar.class)
public class CalendarConverter implements Converter<Calendar> {

    private DateTimeConverter converter =  new DateTimeConverter();

    public CalendarConverter() {
        converter.setPattern("dd/MM/yyyy");
        converter.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
    }

    @Override
    public Calendar getAsObject(FacesContext facesContext, UIComponent uiComponent, String dataTexto) {

        Date data = (Date) converter.getAsObject(facesContext, uiComponent, dataTexto);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);

        return calendar;

    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Calendar calendar) {

        if (calendar == null)
            return null;

        return converter.getAsString(facesContext, uiComponent, calendar.getTime());

    }
}

package IHM1;
import java.awt.Container;
import java.util.Properties;

import javax.swing.JPanel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;


public class DatePicker {
  private Object datePicker;

  public DatePicker(JPanel paneau,String statut){

UtilDateModel model = new UtilDateModel();

// Need this...

Properties p = new Properties();
p.put("text.today", "Today");
p.put("text.month", "Month");
p.put("text.year", "Year");
JDatePanelImpl datePanel = new JDatePanelImpl(model,p);
// Don't know about the formatter, but there it is...
JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
paneau.add(datePicker,statut);




}



}

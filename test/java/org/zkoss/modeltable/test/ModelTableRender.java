package org.zkoss.modeltable.test;

import org.zkoss.experiment.TableItemRenderer;
import org.zkoss.experiment.model.ModelTag;
import org.zkoss.experiment.model.api.ModelRow;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;


public class ModelTableRender implements TableItemRenderer {

	int columns = 300;
	public void renderHeader(ModelRow row) {
		row.setAttribute("style","color:red;border:1px solid red");
		for(int i = 0 ; i < columns ;++i){
			ModelTag m = new ModelTag("td");
			m.setAttribute("style","color:red");
			m.appendContent("Test Header" +i);
			
			row.appendCell(m);
			
		}
	}

	public void renderItem(ModelRow row, Object model) {
		row.appendCell(model);
		row.appendCell("Hello");
		row.appendCell("World");
		row.appendCell("Hey");
		
		Textbox tb = new Textbox();
		tb.setConstraint("no empty");
		tb.addEventListener("onChange",new EventListener() {
			public void onEvent(Event event) throws Exception {
				Messagebox.show("hi");	
			}
		});
		row.appendCell(tb);
		
		for(int i = 0 ; i < columns - 4; ++i){
			row.appendCell("Hello"+i);
		}
	}

}

package org.zkoss.modeltable.test;

import java.util.List;

import org.zkoss.experiment.TableItemRenderer;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;


public class ModelTableRender implements TableItemRenderer {

	int columns = 80;
	public void renderHeader(List row) {
		for(int i = 0 ; i < columns ;++i){
			row.add("Test Header" +i);		
		}
	}

	private Object prepareTextNode(String node){
//		return new Label(node);
		return node;
	}
	
	public void renderItem(List row, Object model) {
		row.add(model);
		row.add(prepareTextNode("Hello"));
		row.add(prepareTextNode("World"));
		row.add(prepareTextNode("Hey"));
		
		Textbox tb = new Textbox();
		tb.setConstraint("no empty");
		tb.addEventListener("onChange",new EventListener() {
			
			public void onEvent(Event event) throws Exception {
				Messagebox.show("hi");	
			}
		});
		row.add(tb);
		
		for(int i = 0 ; i < columns - 4; ++i){
			row.add(prepareTextNode("Hello"));
		}
	}

}

package org.zkoss.experiment;

import org.zkoss.experiment.model.api.ModelRow;



public interface TableItemRenderer {
	
	public void renderHeader(ModelRow row);
	
	public void renderItem(ModelRow row, Object model);
	
}

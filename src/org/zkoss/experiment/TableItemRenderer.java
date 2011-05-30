package org.zkoss.experiment;

import java.util.List;


public interface TableItemRenderer {
	
	public void renderHeader(List row);
	
	public void renderItem(List row,Object model);
	
}

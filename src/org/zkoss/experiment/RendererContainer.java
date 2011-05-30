package org.zkoss.experiment;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.ListModel;


public interface RendererContainer {
	
	public Object getRenderer();
	public void setRenderer(Object renderer);

	public void setRenderer(String clsnm) throws ClassNotFoundException, NoSuchMethodException,
			IllegalAccessException, InstantiationException, java.lang.reflect.InvocationTargetException;
	
	
    public Object getDefaultRenderer() ;
		
	public Object evaluteRender(Component target,ListModel _model);

}

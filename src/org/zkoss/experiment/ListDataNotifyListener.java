package org.zkoss.experiment;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.event.ListDataEvent;
import org.zkoss.zul.event.ListDataListener;

public class ListDataNotifyListener implements ListDataListener{
	private Component tar;
	private static final String ATTR_ON_INIT_RENDER_POSTED = "org.zkoss.zul.onInitLaterPosted";
	
	public ListDataNotifyListener(Component target){
		tar = target;
		if(tar.isListenerAvailable("onInitRender", false)){
			tar.addEventListener("onInitRender", new EventListener() {
				public void onEvent(Event event) throws Exception {
					tar.removeAttribute(ATTR_ON_INIT_RENDER_POSTED);
	                tar.invalidate();
				}
			});
		}
	}
	
	public void notifyTarget(){
        if (tar.getAttribute(ATTR_ON_INIT_RENDER_POSTED) == null) {
        	tar.setAttribute(ATTR_ON_INIT_RENDER_POSTED, Boolean.TRUE);
            Events.postEvent("onInitRender", tar, null);
    	}
	}
	
    public void onChange(ListDataEvent event) {
    	notifyTarget();
	}
}


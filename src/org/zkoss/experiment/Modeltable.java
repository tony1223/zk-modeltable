package org.zkoss.experiment;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.zkoss.json.JSONArray;
import org.zkoss.lang.Classes;
import org.zkoss.lang.Objects;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.impl.XulElement;

public class Modeltable extends XulElement {

	/* Here's a simple example for how to implements a member field */

	private TableItemRenderer _render;

	private final static String COMPONENT_VARIABLE = "$#_wgt_#$";
	private ListModel _model;
	
	private transient ListDataNotifyListener _dataListener;

	public TableItemRenderer getRender() {
		return _render;
	}

	public void setRenderer(TableItemRenderer render) {
		this._render = (TableItemRenderer) render;
	}

	public void setModel(ListModel model) {
        if (model != null) {
            if (_model != model) {
            	//ListDataNotifyListener
                    if (_model != null) {
                            _model.removeListDataListener(_dataListener);
                    }
                    _model = model;
                    _dataListener = new ListDataNotifyListener(this);
                    _dataListener.notifyTarget();
	            }
	    } else if (_model != null) {
	            _model.removeListDataListener(_dataListener);
	            _model = null;
	            invalidate();
	    }
	}

	// super//
	protected void renderProperties(org.zkoss.zk.ui.sys.ContentRenderer renderer) throws java.io.IOException {
		super.renderProperties(renderer);

		render(renderer, "headers", evaluteRenderHeader(this, getRender()));
		render(renderer, "items", evaluteRenderItem(this, getRender(), _model));

	}

	/**
	 * The default zclass is "z-modeltable"
	 */
	public String getZclass() {
		return (this._zclass != null ? this._zclass : "z-modeltable");
	}

	public Object getRenderer() {
		return _render == null ? _defRend : _render;
	}

	public void setRenderer(String clsnm) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
			InstantiationException, InvocationTargetException {
		if (clsnm != null)
			setRenderer((TableItemRenderer) Classes.newInstanceByThread(clsnm));
	}

	private static final TableItemRenderer _defRend = new TableItemRenderer() {
		public void renderHeader(List row) {
			
		}
		public void renderItem(List row, Object model) {
			row.add(Objects.toString(model));
		}
	};

	public Object getDefaultRenderer() {
		return _defRend;
	}


	private Object evaluteRenderHeader(Component target, TableItemRenderer renderer) {
		if (_model == null) {
			return new JSONArray();
		}

		JSONArray list = new JSONArray();
		renderer.renderHeader(list);
		return list;
	}
	
	private Object evaluteRenderItem(Component target, TableItemRenderer renderer, ListModel _model) {
		if (_model == null) {
			return new JSONArray();
		}

		JSONArray list = new JSONArray();

		for (int i = 0; i < _model.getSize(); ++i) {
			JSONArray row = new JSONArray();
			renderer.renderItem(row, _model.getElementAt(i));
			for(int j = 0 ; j < row.size() ; ++j ){
				Object item = row.get(j);
				if( item instanceof Component){
					row.set(j,COMPONENT_VARIABLE);
					this.appendChild( (Component) item);
				}
			}
			list.add(row);
		}

		return list;
	}

}

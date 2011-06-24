package org.zkoss.experiment;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.zkoss.experiment.model.ModelTag;
import org.zkoss.json.JSONArray;
import org.zkoss.lang.Classes;
import org.zkoss.lang.Objects;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.HtmlBasedComponent;
import org.zkoss.zul.ListModel;

public class Modeltable extends HtmlBasedComponent {

	private TableItemRenderer _render;

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
				// ListDataNotifyListener
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

	public Object getRenderer() {
		return _render == null ? _defRend : _render;
	}

	public void setRenderer(String clsnm) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
			InstantiationException, InvocationTargetException {
		if (clsnm != null)
			setRenderer((TableItemRenderer) Classes.newInstanceByThread(clsnm));
	}

	private static final TableItemRenderer _defRend = new TableItemRenderer() {

		public void renderHeader(org.zkoss.experiment.model.api.ModelRow row) {
			
		}

		public void renderItem(org.zkoss.experiment.model.api.ModelRow row, Object model) {
			row.appendCell(Objects.toString(model));
		}
	};

	public Object getDefaultRenderer() {
		return _defRend;
	}

	private Object evaluteRenderHeader(Component target, TableItemRenderer renderer) {
		if (_model == null) 
			return new JSONArray();

		ModelTag list = new ModelTag("tr", "th");
		renderer.renderHeader(list);
		List comps = list.getComponents();
		for (int j = 0; j < comps.size(); ++j) {
			Component item = (Component) comps.get(j);
			this.appendChild((Component) item);
		}
		return list;
	}

	private Object evaluteRenderItem(Component target, TableItemRenderer renderer, ListModel _model) {
		if (_model == null) {
			return null;
		}

		JSONArray list = new JSONArray();

		for (int i = 0; i < _model.getSize(); ++i) {
			ModelTag tag = new ModelTag("tr", "td");
			renderer.renderItem(tag, _model.getElementAt(i));
			List comps = tag.getComponents();
			for (int j = 0; j < comps.size(); ++j) {
				Component item = (Component) comps.get(j);
				this.appendChild((Component) item);
			}
			list.add(tag);
		}

		return list;
	}

}

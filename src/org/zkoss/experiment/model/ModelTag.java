package org.zkoss.experiment.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.zkoss.json.JSONArray;
import org.zkoss.json.JSONObject;
import org.zkoss.lang.Objects;
import org.zkoss.zk.ui.Component;

public class ModelTag extends JSONObject implements org.zkoss.experiment.model.api.ModelRow {

	private static final String KEY_CONTENT = "cnt";

	private static final String KEY_ATTRIBUTE = "attr";

	private static final String COMPONENT_FLAG = "z$wgt";

	private static final String KEY_TAGNAME = "tag";

	private static final String KEY_CHILD_TAGNAME = "ctag";

	private List components;

	private JSONObject attributes;

	private JSONArray contents;

	/**
	 * a tag name
	 * 
	 * @param tagName
	 */
	public ModelTag(String tagName) {
		put(KEY_TAGNAME, tagName);
		components = new ArrayList();
		attributes = new JSONObject();
		contents = new JSONArray();
		put(KEY_CONTENT, contents);
		put(KEY_ATTRIBUTE, attributes);
	}

	/**
	 * 
	 * @param tagName
	 * @param childtag
	 *            if you are not adding a JSONTag as child , you could have a
	 *            child tag assumed , for example , all the text in
	 *            <tr>
	 *            should be wrapped with
	 *            <td>
	 */
	public ModelTag(String tagName, String childtag) {
		this(tagName);
		put(KEY_CHILD_TAGNAME, childtag);
	}

	public void setAttribute(String attr, String value) {
		attributes.put(attr, value);
	}

	public void appendContent(org.zkoss.experiment.model.api.ModelTag tag) {
		contents.add(tag);
	}

	public void appendContent(Object child) {
		appendContent(Objects.toString(child));
	}

	/**
	 * append a component
	 * 
	 * @param cnt
	 */
	public void appendContent(Component child) {
		components.add(child);
		appendContent(COMPONENT_FLAG);
	}

	/**
	 * append pure text
	 * 
	 * @param cnt
	 */
	public void appendContent(String cnt) {
		contents.add(cnt);
	}

	public List getComponents() {
		return Collections.unmodifiableList(components);
	}

	public void clear() {
		if (contents != null)
			contents.clear();
		components.clear();
	}

	public void appendCell(org.zkoss.experiment.model.api.ModelTag tag) {
		appendContent(tag);
	}

	public void appendCell(Object child) {
		appendContent(child);
	}

	public void appendCell(Component child) {
		appendContent(child);
	}

	public void appendCell(String cnt) {
		appendContent(cnt);
	}

	public void clearContent() {
		contents.clear();
		components.clear();
	}

	public void clearAttributes() {
		attributes.clear();
	}

}

package org.zkoss.experiment.model.api;

import java.util.List;

import org.zkoss.zk.ui.Component;

public interface ModelTag {

	/**
	 * set a attribute on this.
	 * 
	 * @param tag
	 */
	public void setAttribute(String attr, String value);

	/**
	 * append a child tag with fully control
	 * 
	 * @param tag
	 */
	public void appendContent(ModelTag tag);

	/**
	 * append a object as a child (we use toString to handle this)
	 * 
	 * @param cnt
	 */
	public void appendContent(Object child);

	/**
	 * append a component
	 * 
	 * @param cnt
	 */
	public void appendContent(Component child);

	/**
	 * append pure text as a child
	 * 
	 * @param cnt
	 */
	public void appendContent(String cnt);

	public List getComponents();

	public void clearContent();

	public void clearAttributes();
}

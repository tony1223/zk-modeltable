package org.zkoss.experiment.model.api;

import java.util.List;

import org.zkoss.zk.ui.Component;

public interface ModelRow extends ModelTag {

	public void setAttribute(String attr, String value);

	public void appendCell(ModelTag tag);

	public void appendCell(Object child);

	/**
	 * append a component
	 * 
	 * @param cnt
	 */
	public void appendCell(Component child);

	/**
	 * append pure text
	 * 
	 * @param cnt
	 */
	public void appendCell(String cnt);

	/**
	 * get a unmodifiable list here.
	 * 
	 * @return
	 */
	public List getComponents();

	/**
	 * clear all the contents , also components
	 */
	public void clearContent();

	public void clearAttributes();
}

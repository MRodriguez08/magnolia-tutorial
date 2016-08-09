package com.globant.magnolia.models;

import javax.jcr.Node;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import info.magnolia.jcr.util.PropertyUtil;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.RenderableDefinition;
import info.magnolia.rendering.template.registry.TemplateDefinitionRegistry;

public class BackingBeanComponentModel<RD extends RenderableDefinition> extends RenderingModelImpl<RD> {

	private static final String TITLE_PROPERTY = "title";

	public static final Logger log = LoggerFactory.getLogger(BackingBeanComponentModel.class);

	private String pageTitle;

	public BackingBeanComponentModel(Node content, RD definition, RenderingModel<?> parent,
			TemplateDefinitionRegistry templateDefinitions) throws Exception {

		super(content, definition, parent);
	}

	@Override
	public String execute() {

		pageTitle = PropertyUtil.getString(content, TITLE_PROPERTY, StringUtils.EMPTY);
		return super.execute();
	}

	public String helloCompontent() {

		return "helloCompontent 42";
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

}
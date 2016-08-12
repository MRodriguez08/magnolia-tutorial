package info.magnolia.module;

import info.magnolia.context.MgnlContext;
import info.magnolia.module.businessCanvas.view.BusinessCanvasJs;

import javax.jcr.Session;

/**
 * This class is optional and represents the configuration for the business-canvas module.
 * By exposing simple getter/setter/adder methods, this bean can be configured via content2bean
 * using the properties and node from <tt>config:/modules/business-canvas</tt>.
 * If you don't need this, simply remove the reference to this class in the module descriptor xml.
 */
public class BusinessCanvasModuleHandler {
	public BusinessCanvasModuleHandler(){

		/**
		 * BusinessCanvas workspace setup
		 */
		Session session;
		try {
			session = MgnlContext.getInstance().getJCRSession("businessCanvas");
			new BusinessCanvasJs().initWorkSpace(session);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
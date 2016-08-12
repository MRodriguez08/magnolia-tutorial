package info.magnolia.module.businessCanvas.view;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

/**
 * Created with IntelliJ IDEA. User: schulteja Date: 20/02/14 Time: 11:30 To
 * change this template use File | Settings | File Templates.
 */
public class BusinessCanvasViewImpl implements BusinessCanvasView {
	/**
	 *
	 */
	private static final long serialVersionUID = 1442854216593824850L;
	/**
	 *
	 */
	private HorizontalLayout hLayout;
	private VerticalLayout vLayout;
	private CustomLayout layout;
	private BusinessCanvasJs businessCanvasJs;

	public BusinessCanvasViewImpl() {

		businessCanvasJs = new BusinessCanvasJs();

		// set the layout logic
		Button resetCanvasButton = new Button("Reset canvas");

		try {
			hLayout = new HorizontalLayout();
			hLayout.setMargin(true);
			vLayout = new VerticalLayout();
			vLayout.addComponent(resetCanvasButton);

		//Load the HTML. Dont to this in a real app. This was just done to keep things simple
			InputStream in = this
					.getClass()
					.getClassLoader()
					.getResourceAsStream(
							"info/magnolia/module/businessCanvas/app/html/canvas.html");
			byte[] bytes = IOUtils.toByteArray(in);
			layout = new CustomLayout(new ByteArrayInputStream(bytes));
			layout.setWidth("100%");
			layout.setHeight("1240px");
			layout.addComponent(businessCanvasJs);


			hLayout.addComponent(layout);
			hLayout.addComponent(vLayout);


			// implements the button listeners
			resetCanvasButton.addClickListener(new Button.ClickListener() {
				private static final long serialVersionUID = 1L;
				@Override
				public void buttonClick(Button.ClickEvent event) {
					businessCanvasJs.resetCanvas();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Component asVaadinComponent() {
		return hLayout;
	}
}

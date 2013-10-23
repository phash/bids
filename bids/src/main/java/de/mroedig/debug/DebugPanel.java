package de.mroedig.debug;

import org.apache.wicket.ajax.AjaxChannel;
import org.apache.wicket.ajax.AjaxChannel.Type;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class DebugPanel extends Panel {

	public DebugPanel(String id) {
		super(id);

		String sessionSize = "SessionSize: "
				+ org.apache.wicket.Session.get().getSizeInBytes();
		final Label sessionLabel = new Label("sessionLabel", sessionSize);
		sessionLabel.setOutputMarkupId(true);
		add(sessionLabel);

		add(new AjaxLink<Void>("sessionLabel-link") {
			@Override
			public void onClick(AjaxRequestTarget target) {

				target.add(sessionLabel);
			}

			@Override
			protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {
				attributes.setChannel(new AjaxChannel("effects", Type.DROP));

				super.updateAjaxAttributes(attributes);
			}
		});

	}

}

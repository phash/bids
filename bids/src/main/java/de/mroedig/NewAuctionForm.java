package de.mroedig;

import org.apache.wicket.feedback.ContainerFeedbackMessageFilter;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.NumberTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.util.value.ValueMap;

import de.mroedig.entities.Auction;

public class NewAuctionForm extends Form<ValueMap> {
	@SpringBean
	private AuctionService auctionService;

	public NewAuctionForm(String id) {
		super(id, new CompoundPropertyModel<ValueMap>(new ValueMap()));
	}

	/**
			 * 
			 */

	private static final long serialVersionUID = 3188308087212670937L;

	@Override
	protected void onInitialize() {
		// TODO Auto-generated method stub

		super.onInitialize();
		add(new TextField("itemName").setRequired(true).setLabel(
				new Model<String>("Auktionsgegenstand")));
		add(new TextField("waehrung"));
		add(new TextField("spielName"));
		add(new TextField("serverName"));
		add(new NumberTextField("startgebot"));

		final FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
		feedbackPanel.setFilter(new ContainerFeedbackMessageFilter(this));

		add(feedbackPanel);
	}

	@Override
	protected void onSubmit() {
		ValueMap values = getModelObject();

		Auction neueAuktion = new Auction();
		neueAuktion.setAuktionsGegenstand(values.getKey("itemName"));

		auctionService.createNewAuction(neueAuktion);

	}

}

package de.mroedig.helper;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormChoiceComponentUpdatingBehavior;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.WebMarkupContainer;

/**
 * Koppelt AjaxKomponenten aneinander
 * 
 * @author msir
 * 
 */
public final class AjaxHelper {

	private AjaxHelper() {

	}

	/**
	 * Einer Auslösenden Komponente werden Komponenten hinzugefügt, die
	 * upgedated werden sollen
	 * 
	 * @param pSender
	 * @param pHinzugefuegteKomponente
	 */
	public static void addAjaxUpdateBehaviorFuerGruppenFormKomponenten(
			final WebMarkupContainer pSender,
			final WebMarkupContainer... pHinzugefuegteKomponente) {
		pSender.add(new AjaxFormChoiceComponentUpdatingBehavior() {

			private static final long serialVersionUID = 2189289509059984729L;

			@Override
			protected void onUpdate(final AjaxRequestTarget target) {
				for (final WebMarkupContainer element : pHinzugefuegteKomponente) {
					target.add(element);
				}
			}
		});
	}

	/**
	 * Einer Auslösenden Komponente werden Komponenten hinzugefügt, die
	 * upgedated werden sollen
	 * 
	 * @param pSender
	 *            der Auslöser
	 * @param pHinzugefuegteKomponente
	 *            die Empfänger
	 */
	public static void addAjaxUpdateBehaviorFuerFormKomponenten(
			final WebMarkupContainer pSender,
			final WebMarkupContainer... pHinzugefuegteKomponente) {
		pSender.add(new AjaxFormComponentUpdatingBehavior("onchange") {

			/**
			 * 
			 */
			private static final long serialVersionUID = 5508494822514850286L;

			@Override
			protected void onUpdate(final AjaxRequestTarget target) {

				target.add(pHinzugefuegteKomponente);
			}
		});
	}

	public static void addAjaxUpdateBehaviorFuerFormKomponentenUndKinderResetten(
			final WebMarkupContainer pSender,
			final WebMarkupContainer... pHinzugefuegteKomponente) {
		pSender.add(new AjaxFormComponentUpdatingBehavior("onchange") {

			/**
			 * 
			 */
			private static final long serialVersionUID = -3415220374242847417L;

			@Override
			protected void onUpdate(final AjaxRequestTarget target) {
				target.add(pHinzugefuegteKomponente);
				for (final WebMarkupContainer element : pHinzugefuegteKomponente) {
					element.setDefaultModelObject(null);

				}
			}
		});
	}

}

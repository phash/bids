package de.mroedig.components;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

/**
 * Dataprovider für DataView, die editierbar sein soll. Bei der DataView muss
 * setItemReuseStrategy(ReuseIfModelsEqualStrategy.getInstance()) aufgerufen
 * werden.
 * 
 * @param <T>
 *            Typ der Elemente
 */
public class EditableListDataProvider<T extends Serializable> extends
		ListDataProvider<T> {
	// WeakHashMap damit cache-Einträge gc'ed werden können, lazy
	// initialiert und transient
	private transient Map<T, IModel<T>> modelCache;

	public EditableListDataProvider() {
		super();
	}

	public EditableListDataProvider(List<T> list) {
		super(list);
	}

	/**
	 * @return Liefert den Cache mit den Modellen
	 */
	protected Map<T, IModel<T>> getModelCache() {
		if (modelCache == null) {
			modelCache = new WeakHashMap<T, IModel<T>>();
		}
		return modelCache;
	}

	@Override
	public IModel<T> model(T object) {
		IModel<T> result = getModelCache().get(object);
		if (result == null) {
			result = new CompoundPropertyModel<T>(object);
			modelCache.put(object, result);
		}
		return result;
	}

}

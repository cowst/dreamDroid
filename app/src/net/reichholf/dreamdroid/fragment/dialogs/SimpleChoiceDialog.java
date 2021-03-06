/* © 2010 Stephan Reichholf <stephan at reichholf dot net>
 * 
 * Licensed under the Create-Commons Attribution-Noncommercial-Share Alike 3.0 Unported
 * http://creativecommons.org/licenses/by-nc-sa/3.0/
 */

package net.reichholf.dreamdroid.fragment.dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;

import net.reichholf.dreamdroid.R;
import net.reichholf.dreamdroid.helpers.BundleHelper;

/**
 * @author sre
 * 
 */
public class SimpleChoiceDialog extends ActionDialog {
	private static final String KEY_TITLE = "title";
	private static final String KEY_ACTIONS = "actions";
	private static final String KEY_ACTION_IDS = "actionIds";

	private int[] mActionIds;
	private CharSequence[] mActions;

	public static SimpleChoiceDialog newInstance(String title, CharSequence[] actions, int[] actionIds) {
		SimpleChoiceDialog fragment = new SimpleChoiceDialog();
		Bundle args = new Bundle();
		args.putString(KEY_TITLE, title);
		args.putStringArrayList(KEY_ACTIONS, BundleHelper.toStringArrayList(actions));
		args.putIntArray(KEY_ACTION_IDS, actionIds);
		fragment.setArguments(args);
		return fragment;
	}

	private void init() {
		Bundle args = getArguments();
		mActions = BundleHelper.toCharSequenceArray(args.getStringArrayList(KEY_ACTIONS));
		mActionIds = args.getIntArray(KEY_ACTION_IDS);
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		setRetainInstance(true);
		init();
		MaterialDialog.Builder builder;
		builder = new MaterialDialog.Builder(getActivity());
		builder.title(getText(R.string.pick_action))
			.items(mActions)
			.itemsCallback(new MaterialDialog.ListCallback() {
				@Override
				public void onSelection(MaterialDialog materialDialog, View view, int i, CharSequence charSequence) {
					finishDialog(mActionIds[i], null);
				}
			});

		return builder.build();
	}
}

package fragment;

import util.dataUtil.ConfigDataUtil.FragmentData;
import android.view.View;
import android.widget.TextView;
import base.BaseFragment;

public abstract class TestRootFragment extends BaseFragment {
	
	protected TextView tv;

	@Override
	public int getRootViewId() {
		return FragmentData.LayoutId;
	}
	
	@Override
	public void initView() {
		
		tv = (TextView) rootView.findViewById(FragmentData.TvId);
		tv.setText(getTvText());
		
	}

	protected abstract String getTvText();
	
	@Override
	public void setMenuVisibility(boolean menuVisible) {
		super.setMenuVisibility(menuVisible);
		
		if (this.getView() != null) {
			this.getView().setVisibility(menuVisible ? View.VISIBLE : View.GONE);
		}
		
	}

}

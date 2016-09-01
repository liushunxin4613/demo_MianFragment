package fragment;

import util.dataUtil.ConfigDataUtil.DataRootFragmentUtil;
import android.widget.TextView;
import base.BaseMainFragment;

public abstract class TestRootFragment extends BaseMainFragment {
	
	protected TextView tv;

	@Override
	public int getRootViewId() {
		return DataRootFragmentUtil.LayoutId;
	}
	
	@Override
	public void initView() {
		
		tv = (TextView) rootView.findViewById(DataRootFragmentUtil.TvId);
		tv.setText(getTvText());
		
	}

	protected abstract String getTvText();
	

}

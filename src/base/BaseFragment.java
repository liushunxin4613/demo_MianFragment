package base;

import inter.AcFmInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment implements AcFmInterface{

	protected View rootView;
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		initRootView();
		rootView = inflater.inflate(getRootViewId(), null);
		initView();
		initData();
		return rootView;
	}

	@Override
	public void initRootView() {
	}

	@Override
	public abstract int getRootViewId();

	@Override
	public void initView() {
	}

	@Override
	public void initData() {
	}
	
}

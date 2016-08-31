package base;

import inter.AcFmInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public abstract class BaseFragmentActivity extends FragmentActivity implements AcFmInterface{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initRootView();
		setContentView(getRootViewId());
		initView();
		initData();
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

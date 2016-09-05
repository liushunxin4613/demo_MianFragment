package base;

import inter.AcFmInterface;
import android.app.Activity;
import android.os.Bundle;

public class BaseActivity extends Activity implements AcFmInterface{
	
	public static String TAG;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TAG = getClass().getName();
		initRootView();
		if (getRootViewId() != 0) {
			setContentView(getRootViewId());
		}
		initView();
		initData();
	}
	

	@Override
	public void initRootView() {
	}

	@Override
	public int getRootViewId() {
		return 0;
	}

	@Override
	public void initView() {
	}

	@Override
	public void initData() {
	}

}

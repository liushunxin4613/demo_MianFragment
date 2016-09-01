package base;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

public abstract class BaseMainFragment extends BaseFragment {

	@Override
	public abstract int getRootViewId();
	
	@Override
	public void setMenuVisibility(boolean menuVisible) {
		super.setMenuVisibility(menuVisible);
		
		if (this.getView() != null) {
			this.getView().setVisibility(menuVisible ? View.VISIBLE : View.GONE);
		}
		
	}

	public int getWindowsWidth(){
		WindowManager wm = getActivity().getWindowManager();
		DisplayMetrics metrics = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(metrics);
		int width = metrics.widthPixels;
		return width;
	}
	
}

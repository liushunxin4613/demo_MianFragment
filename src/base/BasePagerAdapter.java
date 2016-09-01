package base;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;

public abstract class BasePagerAdapter<T> extends PagerAdapter{

	protected List<T> list;
	
	public BasePagerAdapter(List<T> list) {
		this.list = list;
	}
	
	@Override
	public abstract int getCount();

	@Override
	public boolean isViewFromObject(View v, Object obj) {
		return v == obj;
	}

}

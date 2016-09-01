package adapter;

import java.util.List;

import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import base.BasePagerAdapter;

public class ImgPagerAdapter extends BasePagerAdapter<ImageView> {

	public ImgPagerAdapter(List<ImageView> list) {
		super(list);
	}

	public static int MAX = 10000;
	
	@Override
	public int getCount() {
		return MAX * MAX;
	}
	
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
	}
	
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		position %= list.size();
		if (position < 0) {
			position += list.size();
		}
		ImageView iv = list.get(position);
		
		ViewParent vp = iv.getParent();
		if (vp != null) {
			ViewGroup vg = (ViewGroup) vp;
			vg.removeView(iv);
		}
		container.addView(iv);
		
		return iv;
	}

}

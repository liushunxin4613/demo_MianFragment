package base;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class BaseRootAdapter<T> extends BaseAdapter {

	protected List<T> list;
	protected Context context;
	protected int resource;
	
	public BaseRootAdapter(Context context,List<T> list,int resource) {
		this.list = list;
		this.context = context;
		this.resource = resource;
	}
	
	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public abstract View getView(int position, View convertView, ViewGroup parent);

}

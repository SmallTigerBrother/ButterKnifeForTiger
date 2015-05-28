package butterknife;

import java.util.ArrayList;

import butterknife.ButterKnife.Finder;

public abstract class ViewBinder<T>
{
	private ArrayList<ViewBinder<T>> superViewBinders;
	
	public abstract void bind(Finder finder, T target, Object source);

	public abstract void unbind(T target);
	
	public void insertSuperBinder(ViewBinder<T> viewBinder)
	{
		if(null == superViewBinders)
		{
			superViewBinders = new ArrayList<ViewBinder<T>>();
		}
		superViewBinders.add(0, viewBinder);
	}
	
	public void executeSuperBindMethod(Finder finder, T target, Object source)
	{
		if(null != superViewBinders)
		{
			for (int i = 0; i < superViewBinders.size(); i++)
			{
				superViewBinders.get(i).bind(finder, target, source);
			}
		}
	}
}


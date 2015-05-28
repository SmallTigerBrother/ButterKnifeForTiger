package butterknife;

import android.app.Activity;
import android.app.Fragment;
import android.view.View;
import android.view.ViewGroup;

public class ButterKnifeExtendByTiger
{
	private static final String ACTIVITY_CLASS_NAME = Activity.class.getName();
	
	private static final String VIEW_CLASS_NAME = View.class.getName();
	
	private static final String VIEWGROUP_CLASS_NAME = ViewGroup.class.getName();
	
	private static final String FRAGMENT_CLASS_NAME = Fragment.class.getName();
	
	private static final String OBJECT_CLASS_NAME = Object.class.getName();
	
	public static ViewBinder<Object> insertSuperBinds(ViewBinder<Object> viewBinder, Class<?> cls)
	{
		Class<?> superCls = cls.getSuperclass();
		String superClassName = superCls.getName();
		ViewBinder<Object> superViewBinder;
		
		while (!isSuperClassEnd(superClassName))
		{
			try
			{
				superViewBinder = ButterKnife.findViewBinderForClass(superCls);
				if(null != superViewBinder)
				{
					viewBinder.insertSuperBinder(superViewBinder);
				}
			}
			catch (Exception e)
			{
			}
			
			superCls = superCls.getSuperclass();
			superClassName = superCls.getName();
		}
		
		return viewBinder;
	}

	private static boolean isSuperClassEnd(String superClassName)
	{
		if(superClassName.equals(ACTIVITY_CLASS_NAME) 
				|| superClassName.equals(VIEW_CLASS_NAME) 
				|| superClassName.equals(VIEWGROUP_CLASS_NAME) 
				|| superClassName.equals(FRAGMENT_CLASS_NAME)
				|| superClassName.equals(OBJECT_CLASS_NAME))
		{
			return true;
		}
		
		return false;
	}
	
	

}

package butterknife.tiger;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import android.view.View;
import butterknife.internal.ListenerClass;
import butterknife.internal.ListenerMethod;

@Target(METHOD)
@Retention(CLASS)
@ListenerClass(targetType = "com.mn.tiger.widget.pulltorefresh.library.IPullToRefreshListenable", setter = "setOnRefreshListener", 
type = "com.mn.tiger.widget.pulltorefresh.library.PullToRefreshBase.OnRefreshListener", 
callbacks = OnPullToRefresh.Callback.class)
public @interface OnPullToRefresh
{
	/** View IDs to which the method will be bound. */
	int[] value() default { View.NO_ID };

	/** Listener callback to which the method will be bound. */
	Callback callback() default Callback.ON_PULL_UP_TO_REFRESH;

	/** {@link OnRereshListener} callback methods. */
	enum Callback
	{
		/** {@link OnRereshListener#onPullDownToRefresh()} */
		@ListenerMethod(name = "onPullDownToRefresh")
		ON_PULL_DOWN_TO_REFRESH,

		/** {@link OnRereshListener#onPullUpToRefresh()} */
		@ListenerMethod(name = "onPullUpToRefresh")
		ON_PULL_UP_TO_REFRESH,
	}
}

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
@ListenerClass(targetType = "com.mn.tiger.widget.TGSearchView", setter = "setOnQueryTextListener", 
type = "com.mn.tiger.widget.TGSearchView.OnQueryTextListener", 
callbacks = OnQueryText.Callback.class)
public @interface OnQueryText
{
	/** View IDs to which the method will be bound. */
	int[] value() default { View.NO_ID };

	/** Listener callback to which the method will be bound. */
	Callback callback() default Callback.ON_QUERY_TEXT_SUBMIT;

	/** {@link OnQueryTextListener} callback methods. */
	enum Callback
	{
		/** {@link OnQueryTextListener#onQueryTextChange()} */
		@ListenerMethod(name = "onQueryTextChange", parameters = {"java.lang.CharSequence"})
		ON_QUERY_TEXT_CHANGE,

		/** {@link OnQueryTextListener#onQueryTextSubmit()} */
		@ListenerMethod(name = "onQueryTextSubmit", parameters = {"java.lang.CharSequence"})
		ON_QUERY_TEXT_SUBMIT,
		
		/** {@link OnQueryTextListener#onTextCleaned()} */
		@ListenerMethod(name = "onTextCleaned")
		ON_TEXT_CLEANED;
	}
}
























package netscape.js;

import java.applet.Applet;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Iterator;
import java.util.ServiceLoader;



















@SuppressWarnings("deprecation")
public abstract class JSObject {




	protected JSObject() {
	}














	public abstract Object call(String methodName, Object... args) throws netscape.js.JSException;













	public abstract Object eval(String s) throws netscape.js.JSException;












	public abstract Object getMember(String name) throws netscape.js.JSException;













	public abstract void setMember(String name, Object value) throws netscape.js.JSException;











	public abstract void removeMember(String name) throws netscape.js.JSException;












	public abstract Object getSlot(int index) throws netscape.js.JSException;













	public abstract void setSlot(int index, Object value) throws netscape.js.JSException;

















	@Deprecated(since = "9")
	@SuppressWarnings("exports")
	public static JSObject getWindow(Applet applet) throws JSException {
		return ProviderLoader.callGetWindow(applet);
	}

	private static class ProviderLoader {
		private static final JSObjectProvider provider;
		static 
		{
			provider = AccessController.doPrivileged(new PrivilegedAction<JSObjectProvider>() {
				@Override
				public JSObjectProvider run() {
					Iterator<JSObjectProvider> providers = ServiceLoader.loadInstalled(JSObjectProvider.class).iterator();
					if (providers.hasNext()) {
						return providers.next();
					}
					return null;
				}
			});
		}

		private static JSObject callGetWindow(Applet applet) {
			if (provider != null) {
				return provider.getWindow(applet);
			}
			return null;
		}
	}
}
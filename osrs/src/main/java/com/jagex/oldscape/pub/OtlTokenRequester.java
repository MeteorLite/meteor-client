package com.jagex.oldscape.pub;

import java.net.URL;
import java.util.Map;
import java.util.concurrent.Future;

public interface OtlTokenRequester {
	Future request(String var1, URL var2, Map var3, String var4);
}

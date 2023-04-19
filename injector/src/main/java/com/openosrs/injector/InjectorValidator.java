/*
 * Copyright (c) 2019, Lucas <https://github.com/Lucwousin>
 * All rights reserved.
 *
 * This code is licensed under GPL3, see the complete license in
 * the LICENSE file in the root directory of this submodule.
 */
package com.openosrs.injector;

import com.openosrs.injector.injection.InjectData;
import com.openosrs.injector.rsapi.RSApi;
import com.openosrs.injector.rsapi.RSApiClass;
import com.openosrs.injector.rsapi.RSApiMethod;
import lombok.RequiredArgsConstructor;
import meteor.Logger;
import net.runelite.asm.ClassFile;
import net.runelite.asm.pool.Class;
import static com.openosrs.injector.rsapi.RSApi.API_BASE;

@RequiredArgsConstructor
public class InjectorValidator implements Validator
{
	private static final Logger log = new Logger("Validator");
	private static final String OK = "OK", ERROR = "ERROR", WTF = "WTF";
	private final InjectData inject;

	private int missing = 0, okay = 0, wtf = 0;

	public boolean validate()
	{
		final RSApi rsApi = inject.getRsApi();
		for (ClassFile cf : inject.getVanilla())
		{
			for (Class intf : cf.getInterfaces())
			{
				if (!intf.getName().startsWith(API_BASE))
				{
					continue;
				}

				RSApiClass apiC = rsApi.findClass(intf.getName());
				if (apiC == null)
				{
					log.error("{} is rs api type implemented by {} but it doesn't exist in rsapi. wtf", intf, cf.getPoolClass());
					++wtf;
					continue;
				}

				check(cf, apiC);
			}
		}

		String status = wtf > 0 ? WTF : missing > 0 ? ERROR : OK;
		if (missing > 0) {
			log.error("RSApiValidator completed. Status [{}] {} overridden methods, {} missing", status,
					okay, missing);
			//throw new RuntimeException("Implementations are missing, exiting...");
		}

		// valid, ref to static final field
		return status == OK;
	}

	private void check(ClassFile clazz, RSApiClass apiClass)
	{
		for (RSApiMethod apiMethod : apiClass)
		{
			if (apiMethod.isSynthetic() || apiMethod.isDefault())
			{
				continue;
			}

			if (clazz.findMethodDeep(apiMethod.getName(), apiMethod.getSignature()) == null)
			{
				log.error("Class {} implements interface {} but doesn't implement {}",
					clazz.getPoolClass(), apiClass.getClazz(), apiMethod.getMethod());
				++missing;
			}
			else
			{
				++okay;
			}
		}
	}
}

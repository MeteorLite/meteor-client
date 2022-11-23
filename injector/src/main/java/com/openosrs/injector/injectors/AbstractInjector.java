/*
 * Copyright (c) 2019, Lucas <https://github.com/Lucwousin>
 * All rights reserved.
 *
 * This code is licensed under GPL3, see the complete license in
 * the LICENSE file in the root directory of this submodule.
 */
package com.openosrs.injector.injectors;

import com.google.common.base.Stopwatch;
import com.openosrs.injector.injection.InjectData;
import lombok.RequiredArgsConstructor;
import meteor.Logger;

@RequiredArgsConstructor
public abstract class AbstractInjector implements Injector
{
	protected final InjectData inject;
	protected final Logger log = new Logger("Injector");
	private Stopwatch stopwatch;

	public void start()
	{
		stopwatch = Stopwatch.createStarted();
	}

	public final String getCompletionMsg()
	{
		return "finished in " + stopwatch.toString();
	}
}

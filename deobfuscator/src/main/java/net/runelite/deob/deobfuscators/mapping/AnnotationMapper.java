/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.runelite.deob.deobfuscators.mapping;

import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.Annotation;
import net.runelite.asm.attributes.Annotated;
import net.runelite.deob.DeobAnnotations;

public class AnnotationMapper
{
	private final ClassGroup source, target;
	private final ParallelExecutorMapping mapping;

	public AnnotationMapper(ClassGroup source, ClassGroup target, ParallelExecutorMapping mapping)
	{
		this.source = source;
		this.target = target;
		this.mapping = mapping;
	}

	public void run()
	{
		int count = 0;

		for (ClassFile c : source.getClasses())
		{
			ClassFile other = (ClassFile) mapping.get(c);

			count += run(c, other);
		}
	}

	private int run(ClassFile from, ClassFile to)
	{
		int count = 0;

		if (hasCopyableAnnotation(from))
		{
			if (to != null)
			{
				count += copyAnnotations(from, to);
			}
			else
			{
			}
		}

		for (Field f : from.getFields())
		{
			if (!hasCopyableAnnotation(f))
				continue;

			Field other = (Field) mapping.get(f);
			if (other == null)
			{
				continue;
			}

			count += copyAnnotations(f, other);
		}

		for (Method m : from.getMethods())
		{
			if (!hasCopyableAnnotation(m))
				continue;

			Method other = (Method) mapping.get(m);
			if (other == null)
			{
				continue;
			}

			count += copyAnnotations(m, other);
		}

		return count;
	}

	private int copyAnnotations(Annotated from, Annotated to)
	{
		int count = 0;

		if (from.getAnnotations() == null)
			return count;

		for (Annotation a : from.getAnnotations().values())
		{
			if (isCopyable(a))
			{
				to.addAnnotation(a);
				++count;
			}
		}

		return count;
	}

	private boolean hasCopyableAnnotation(Annotated a)
	{
		return a.findAnnotation(DeobAnnotations.EXPORT) != null || a.findAnnotation(DeobAnnotations.IMPLEMENTS) != null;
	}

	private boolean isCopyable(Annotation a)
	{
		return a.getType().equals(DeobAnnotations.EXPORT)
			|| a.getType().equals(DeobAnnotations.IMPLEMENTS);
	}
}

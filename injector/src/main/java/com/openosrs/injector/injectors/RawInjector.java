package com.openosrs.injector.injectors;

import com.openosrs.injector.InjectUtil;
import com.openosrs.injector.injection.InjectData;

import net.runelite.asm.Field;
import net.runelite.asm.Method;

/**
 * A Base raw injector class with utility methods for finding things in the obfuscated client
 * by the deob renamed names.
 */
public abstract class RawInjector extends AbstractInjector {

    public RawInjector(InjectData inject) {
        super(inject);
    }

    /**
     * Method called to run the raw injector.
     *
     * @throws InjectionException
     */
    public abstract void inject();

    /**
     * Searches the deobfuscated client for a static method with the name of {@code methodName}.
     *
     * @param methodName The method name to search for.
     * @return The method reference.
     * @throws InjectionException Thrown when the method could not be found.
     */
    protected final Method findStaticMethod(String hint, String methodName) {
        var result = InjectUtil.findStaticMethod(inject, methodName, hint);
        return result;
    }

    protected final Method findStaticMethod(String methodName) {
        return findStaticMethod(null, methodName);
    }

    protected final Method findMethod(String hint, String methodName) {
        var result = InjectUtil.findMethod(inject, methodName, hint);
        return result;
    }

    protected final Field findField(String className, String fieldName) {
        return InjectUtil.findField(inject, fieldName, className);
    }

}
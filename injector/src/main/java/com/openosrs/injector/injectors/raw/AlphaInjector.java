package com.openosrs.injector.injectors.raw;

import com.openosrs.injector.InjectUtil;
import com.openosrs.injector.injection.InjectData;
import com.openosrs.injector.injectors.RawInjector;

import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.ALoad;
import net.runelite.asm.attributes.code.instructions.BiPush;
import net.runelite.asm.attributes.code.instructions.GetField;
import net.runelite.asm.attributes.code.instructions.GetStatic;
import net.runelite.asm.attributes.code.instructions.IAStore;
import net.runelite.asm.attributes.code.instructions.ILoad;
import net.runelite.asm.attributes.code.instructions.IOr;
import net.runelite.asm.attributes.code.instructions.ISub;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.attributes.code.instructions.LDC;
import net.runelite.asm.attributes.code.instructions.SiPush;
import net.runelite.asm.pool.Class;
import net.runelite.asm.signature.Signature;

import java.util.ListIterator;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

public class AlphaInjector extends RawInjector {

    private static final net.runelite.asm.pool.Method DRAWALPHA_METHOD = new net.runelite.asm.pool.Method(new Class("client"),
            "drawAlpha", new Signature("([IIII)V"));

    public AlphaInjector(InjectData inject) {
        super(inject);
    }

    public void inject() {
        injectDrawAlpha();
    }

    private void injectDrawAlpha() {
        final Field graphicsPixelsField = InjectUtil.findField(inject, "Rasterizer2D_pixels", "osrs/Rasterizer2D");
        final BiPredicate<ListIterator<Instruction>, Instruction> graphicsPixelsCheck =
                (instructionListIterator, prev) -> prev instanceof GetStatic
                        && ((GetStatic) prev).getField().equals(graphicsPixelsField.getPoolField());

        matchAndModify(findStaticMethod("osrs/Rasterizer2D", "Rasterizer2D_drawHorizontalLineAlpha"), graphicsPixelsCheck, getGraphicsPixelsConsume(4));
        matchAndModify(findStaticMethod("osrs/Rasterizer2D", "Rasterizer2D_drawVerticalLineAlpha"), graphicsPixelsCheck, getGraphicsPixelsConsume(4));
        matchAndModify(findStaticMethod("osrs/Rasterizer2D", "Rasterizer2D_fillRectangleAlpha"), graphicsPixelsCheck, getGraphicsPixelsConsume(5));
        matchAndModify(findStaticMethod("osrs/Rasterizer2D", "Rasterizer2D_drawCircleAlpha"), graphicsPixelsCheck, getGraphicsPixelsConsume(4));

        replaceParamReferenceWithDrawAlpha(findStaticMethod("osrs/SpritePixels", "Sprite_drawTransparent"), 0, 9);
        replaceParamReferenceWithDrawAlpha(findStaticMethod("osrs/SpritePixels", "Sprite_drawTransScaled"), 0, 12);

        matchAndModify(findStaticMethod("osrs/AbstractFont", "AbstractFont_placeGlyphAlpha"),
                (instructionListIterator, prev) -> prev instanceof ALoad && ((ALoad) prev).getVariableIndex() == 0,
                (listIter, instruction) ->
                {
                    Instructions instructions = instruction.getInstructions();

                    listIter.remove();
                    listIter.add(new SiPush(instructions, (short) 255));
                    listIter.add(new ILoad(instructions, 9));
                    listIter.add(new ISub(instructions, InstructionType.ISUB));
                    listIter.add(new InvokeStatic(instructions, DRAWALPHA_METHOD));
                }
        );

        {
            final Field contextField = findField("osrs/class229", "context");
            final Field transparencyField = findField("osrs/Clips", "transparency");
            replaceParamReferenceWithDrawAlpha2(findMethod("osrs/RasterizerDepthDisabled", "rasterFlatLine"), 0, contextField, transparencyField);
            replaceParamReferenceWithDrawAlpha2(findMethod("osrs/RasterizerDepthDisabled", "rasterGouraudLine"), 0, contextField, transparencyField);
        }

        //TODO all these
        addAlphaToNumber(findStaticMethod("osrs/Rasterizer2D", "Rasterizer2D_drawLine"));
        addAlphaToNumber(findStaticMethod("osrs/Rasterizer2D", "Rasterizer2D_fillRectangle"));
        addAlphaToNumber(findStaticMethod("osrs/Rasterizer2D", "Rasterizer2D_setPixel"));
        addAlphaToNumber(findStaticMethod("osrs/Rasterizer2D", "drawCircle"));
        addAlphaToNumber(findStaticMethod("osrs/Rasterizer2D", "Rasterizer2D_drawVerticalLine"));
        addAlphaToNumber(findStaticMethod("osrs/Rasterizer2D", "Rasterizer2D_fillRectangleGradient"));
        addAlphaToNumber(findStaticMethod("osrs/Rasterizer2D", "Rasterizer2D_fillMaskedRectangle"));
        addAlphaToNumber(findStaticMethod("osrs/Rasterizer2D", "Rasterizer2D_drawHorizontalLine"));
       /* addAlphaToNumber(findObMethod("SpritePixels", "spriteMethod5"));
        addAlphaToNumber(findObMethod("SpritePixels", "spriteMethod6"));
        addAlphaToNumber(findObMethod("SpritePixels", "spriteMethod7"));
        addAlphaToNumber(findObMethod("SpritePixels", "spriteMethod8"));
        addAlphaToNumber(findObMethod("SpritePixels", "spriteMethod9"));*/

     /*   addAlphaToNumber(findStaticMethod("spriteMethod3"), 0);
        addAlphaToNumber(findStaticMethod("spriteMethod4"), 0);
        addAlphaToNumber(findStaticMethod("spriteMethod10"), 0);
        addAlphaToNumber(findStaticMethod("spriteMethod11"), 0);
        addAlphaToNumber(findStaticMethod("render"), 0);
        addAlphaToNumber(findStaticMethod("indexedSpriteMethod1"), 0);
        addAlphaToNumber(findStaticMethod("indexedSpriteMethod2"), 0);
        addAlphaToNumber(findMethod("osrs/RasterizerDepthDisabled", "rasterTextureAffineLine"), 0);
        addAlphaToNumber(findMethod("osrs/RasterizerDepthDisabled", "rasterTextureLine"), 0);*/

        Method method = findObMethod("osrs/Scene", "occlude");
        ListIterator<Instruction> listIter = method.getCode().getInstructions().getInstructions().listIterator();

        while (listIter.hasNext()) {
            Instruction instruction = listIter.next();

            if (instruction instanceof BiPush && (byte) ((BiPush) instruction).getConstant() == 25) {
                listIter.set(new LDC(instruction.getInstructions(), 90));
            }
        }
    }

    private BiConsumer<ListIterator<Instruction>, Instruction> getGraphicsPixelsConsume(int alphaParamId) {
        return (iter, instruction) ->
        {
            /*
             * Replaces call to Rasterizer2D#graphicsPixels with a call to client.drawAlpha() and appends params 4
             * to the call.
             */
            iter.remove();
            iter.add(new ILoad(instruction.getInstructions(), alphaParamId));
            iter.add(new InvokeStatic(instruction.getInstructions(), DRAWALPHA_METHOD));
        };
    }

    private void matchAndModify(Method method, BiPredicate<ListIterator<Instruction>, Instruction> matchPredicate, BiConsumer<ListIterator<Instruction>, Instruction> onMatch) {
        Instructions instructions = method.getCode().getInstructions();
        ListIterator<Instruction> listIter = instructions.getInstructions().listIterator();

        while (listIter.hasNext()) {
            Instruction instruction = listIter.next();

            if (instruction instanceof IAStore) {
                boolean isMatch = false;
                int currentPos = listIter.nextIndex() - 1;

                // verify the iastore is for the correct field
                while (listIter.hasPrevious()) {
                    Instruction prev = listIter.previous();

                    if (matchPredicate.test(listIter, prev)) {
                        isMatch = true;
                        break;
                    }
                }

                // skip back to where we were previously
                for (int i = 0, deltaPos = currentPos - listIter.previousIndex(); i < deltaPos; i++) {
                    listIter.next();
                }

                if (isMatch) {
                    onMatch.accept(listIter, instruction);
                }
            }
        }
    }

    /**
     * Finds {@link IAStore} where the field is {@code graphicsPixels} and replaces it with {@code client.drawAlpha}.
     *
     * @param method       The method to replace the calls in.
     * @param alphaParamId The param id that contain the alpha from {@code method}.
     */
    private void replaceGraphicPixelsWithDrawAlpha(Method method, int alphaParamId) {
        final Field field = InjectUtil.findField(inject, "Rasterizer2D_pixels", "osrs/Rasterizer2D");

        Instructions instructions = method.getCode().getInstructions();
        ListIterator<Instruction> listIter = instructions.getInstructions().listIterator();

        while (listIter.hasNext()) {
            Instruction instruction = listIter.next();

            if (instruction instanceof IAStore) {
                boolean isMatch = false;
                int currentPos = listIter.nextIndex() - 1;

                // verify the iastore is for the correct field
                while (listIter.hasPrevious()) {
                    Instruction prev = listIter.previous();

                    if (prev instanceof GetStatic && ((GetStatic) prev).getField().equals(field.getPoolField())) {
                        isMatch = true;
                        break;
                    }
                }

                // skip back to where we were previously
                for (int i = 0, deltaPos = currentPos - listIter.previousIndex(); i < deltaPos; i++) {
                    listIter.next();
                }

                if (isMatch) {
                    log.info("Injecting " + DRAWALPHA_METHOD + " call to " + method + " at " + (listIter.nextIndex() - 1));
                    listIter.remove();
                    listIter.add(new ILoad(instructions, alphaParamId));
                    listIter.add(new InvokeStatic(instructions, DRAWALPHA_METHOD));
                }
            }
        }
    }

    /**
     * Finds {@link IAStore} that references {@code arrayParamId} and replaces the assignment with
     * {@code client.drawAlpha}.
     *
     * @param method       The method to replace the references in.
     * @param arrayParamId The param id to search for assignments to.
     * @param alphaParamId The param id containing the alpha value.
     */
    private void replaceParamReferenceWithDrawAlpha(Method method, int arrayParamId, int alphaParamId) {
        Instructions instructions = method.getCode().getInstructions();
        ListIterator<Instruction> listIter = instructions.getInstructions().listIterator();

        while (listIter.hasNext()) {
            Instruction instruction = listIter.next();

            if (instruction instanceof IAStore) {
                boolean isMatch = false;
                int currentPos = listIter.nextIndex() - 1;

                // verify the iastore is for the correct field
                while (listIter.hasPrevious()) {
                    Instruction prev = listIter.previous();

                    if (prev instanceof ALoad && ((ALoad) prev).getVariableIndex() == arrayParamId) {
                        isMatch = true;
                        break;
                    }
                }

                // skip back to where we were previously
                for (int i = 0, deltaPos = currentPos - listIter.previousIndex(); i < deltaPos; i++) {
                    listIter.next();
                }

                if (isMatch) {
                    log.info("Injecting " + DRAWALPHA_METHOD + " call to " + method + " at " + (listIter.nextIndex() - 1));
                    listIter.remove();
                    listIter.add(new ILoad(instructions, alphaParamId));
                    listIter.add(new InvokeStatic(instructions, DRAWALPHA_METHOD));
                }
            }
        }
    }

    private void replaceParamReferenceWithDrawAlpha2(Method method, int arrayParamId, Field contextField, Field alphaField) {
        Instructions instructions = method.getCode().getInstructions();
        ListIterator<Instruction> listIter = instructions.getInstructions().listIterator();

        while (listIter.hasNext()) {
            Instruction instruction = listIter.next();

            if (instruction instanceof IAStore) {
                boolean isMatch = false;
                int currentPos = listIter.nextIndex() - 1;

                // verify the iastore is for the correct field
                while (listIter.hasPrevious()) {
                    Instruction prev = listIter.previous();

                    if (prev instanceof ALoad && ((ALoad) prev).getVariableIndex() == arrayParamId) {
                        isMatch = true;
                        break;
                    }
                }

                // skip back to where we were previously
                for (int i = 0, deltaPos = currentPos - listIter.previousIndex(); i < deltaPos; i++) {
                    listIter.next();
                }

                if (isMatch) {
                    log.info("Injecting " + DRAWALPHA_METHOD + " call to " + method + " at " + (listIter.nextIndex() - 1));
                    listIter.remove();
                    listIter.add(new SiPush(instructions, (short) 255));
                    listIter.add(new ALoad(instructions, 0));
                    listIter.add(new GetField(instructions, contextField.getPoolField()));
                    listIter.add(new GetField(instructions, alphaField.getPoolField()));
                    listIter.add(new ISub(instructions, InstructionType.ISUB));
                    listIter.add(new InvokeStatic(instructions, DRAWALPHA_METHOD));
                }
            }
        }
    }

    private void addAlphaToNumber(Method method) {
        final Field graphicsPixelsField = InjectUtil.findField(inject, "Rasterizer2D_pixels", "osrs/Rasterizer2D");

        Instructions instructions = method.getCode().getInstructions();
        ListIterator<Instruction> listIter = instructions.getInstructions().listIterator();

        log.info("Searching for " + graphicsPixelsField + " in " + method);

        while (listIter.hasNext()) {
            Instruction instruction = listIter.next();

            if (instruction instanceof IAStore) {
                boolean isMatch = false;
                int currentPos = listIter.nextIndex() - 1;

                // verify the iastore is for the correct field
                while (listIter.hasPrevious()) {
                    Instruction prev = listIter.previous();

                    if (prev instanceof GetStatic) {
                        net.runelite.asm.pool.Field field = ((GetStatic) prev).getField();

                        if ((field.getClazz().getName().equals(graphicsPixelsField.getClassFile().getClassName())
                                || inject.getVanilla().findClass(field.getClazz().getName()).getParent().getName().equals(graphicsPixelsField.getClassFile().getClassName()))
                                && field.getName().equals(graphicsPixelsField.getName())) {
                            isMatch = true;
                            break;
                        }
                    }
                }

                // skip back to where we were previously
                for (int i = 0, deltaPos = currentPos - listIter.previousIndex(); i < deltaPos; i++) {
                    listIter.next();
                }

                if (isMatch) {
                    log.info("Injecting 0xFF000000 OR to " + method + " at " + (listIter.nextIndex() - 1));
                    listIter.previous();
                    listIter.add(new LDC(instructions, 0xff000000));
                    listIter.add(new IOr(instructions, InstructionType.IOR));
                    listIter.next();
                }
            }
        }
    }

    private void addAlphaToNumber(Method method, int arrayParamId) {
        Instructions instructions = method.getCode().getInstructions();
        ListIterator<Instruction> listIter = instructions.getInstructions().listIterator();

        while (listIter.hasNext()) {
            Instruction instruction = listIter.next();

            if (instruction instanceof IAStore) {
                boolean isMatch = false;
                int currentPos = listIter.nextIndex() - 1;

                // verify the iastore is for the correct field
                while (listIter.hasPrevious()) {
                    Instruction prev = listIter.previous();

                    if (prev instanceof ALoad && ((ALoad) prev).getVariableIndex() == arrayParamId) {
                        isMatch = true;
                        break;
                    }
                }

                // skip back to where we were previously
                for (int i = 0, deltaPos = currentPos - listIter.previousIndex(); i < deltaPos; i++) {
                    listIter.next();
                }

                if (isMatch) {
                    log.info("Injecting 0xFF000000 OR to " + method + " at " + (listIter.nextIndex() - 1));
                    listIter.previous();
                    listIter.add(new LDC(instructions, 0xff000000));
                    listIter.add(new IOr(instructions, InstructionType.IOR));
                    listIter.next();
                }
            }
        }
    }

    @Deprecated
    private Method findObMethod(String unobbedClass, String unobbedMethod) {
        return inject.toVanilla(inject.getDeobfuscated().findClass(unobbedClass)).findMethod(unobbedMethod);
    }
}

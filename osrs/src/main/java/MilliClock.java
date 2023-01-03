import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("fy")
@Implements("MilliClock")
public class MilliClock extends Clock {
   @ObfuscatedName("h")
   long[] field1443 = new long[10];
   @ObfuscatedName("e")
   int field1444 = 256;
   @ObfuscatedName("v")
   int field1448 = 1;
   @ObfuscatedName("x")
   long field1446 = Message.method344();
   @ObfuscatedName("m")
   int field1447 = 0;
   @ObfuscatedName("q")
   int field1445;

   public MilliClock() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1443[var1] = this.field1446;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "118747683"
   )
   public void mark() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1443[var1] = 0L;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(III)I",
      garbageValue = "1532577739"
   )
   public int wait(int var1, int var2) {
      int var3 = this.field1444;
      int var4 = this.field1448;
      this.field1444 = 300;
      this.field1448 = 1;
      this.field1446 = Message.method344();
      if (this.field1443[this.field1445] == 0L) {
         this.field1444 = var3;
         this.field1448 = var4;
      } else if (this.field1446 > this.field1443[this.field1445]) {
         this.field1444 = (int)((long)(var1 * 2560) / (this.field1446 - this.field1443[this.field1445]));
      }

      if (this.field1444 < 25) {
         this.field1444 = 25;
      }

      if (this.field1444 > 256) {
         this.field1444 = 256;
         this.field1448 = (int)((long)var1 - (this.field1446 - this.field1443[this.field1445]) / 10L);
      }

      if (this.field1448 > var1) {
         this.field1448 = var1;
      }

      this.field1443[this.field1445] = this.field1446;
      this.field1445 = (this.field1445 + 1) % 10;
      int var5;
      if (this.field1448 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if (this.field1443[var5] != 0L) {
               this.field1443[var5] += (long)this.field1448;
            }
         }
      }

      if (this.field1448 < var2) {
         this.field1448 = var2;
      }

      class12.method44((long)this.field1448);

      for(var5 = 0; this.field1447 < 256; this.field1447 += this.field1444) {
         ++var5;
      }

      this.field1447 &= 255;
      return var5;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lqy;II)V",
      garbageValue = "-1714610192"
   )
   public static void readReflectionCheck(Buffer var0, int var1) {
      ReflectionCheck var2 = new ReflectionCheck();
      var2.size = var0.readUnsignedByte();
      var2.id = var0.readInt();
      var2.operations = new int[var2.size];
      var2.creationErrors = new int[var2.size];
      var2.fields = new Field[var2.size];
      var2.intReplaceValues = new int[var2.size];
      var2.methods = new Method[var2.size];
      var2.arguments = new byte[var2.size][][];

      for(int var3 = 0; var3 < var2.size; ++var3) {
         try {
            int var4 = var0.readUnsignedByte();
            String var5;
            String var6;
            int var7;
            if (var4 != 0 && var4 != 1 && var4 != 2) {
               if (var4 == 3 || var4 == 4) {
                  var5 = var0.readStringCp1252NullTerminated();
                  var6 = var0.readStringCp1252NullTerminated();
                  var7 = var0.readUnsignedByte();
                  String[] var8 = new String[var7];

                  for(int var9 = 0; var9 < var7; ++var9) {
                     var8[var9] = var0.readStringCp1252NullTerminated();
                  }

                  String var20 = var0.readStringCp1252NullTerminated();
                  byte[][] var10 = new byte[var7][];
                  int var12;
                  if (var4 == 3) {
                     for(int var11 = 0; var11 < var7; ++var11) {
                        var12 = var0.readInt();
                        var10[var11] = new byte[var12];
                        var0.readBytes(var10[var11], 0, var12);
                     }
                  }

                  var2.operations[var3] = var4;
                  Class[] var21 = new Class[var7];

                  for(var12 = 0; var12 < var7; ++var12) {
                     var21[var12] = loadClassFromDescriptor(var8[var12]);
                  }

                  Class var22 = loadClassFromDescriptor(var20);
                  if (loadClassFromDescriptor(var5).getClassLoader() == null) {
                     throw new SecurityException();
                  }

                  Method[] var13 = loadClassFromDescriptor(var5).getDeclaredMethods();
                  Method[] var14 = var13;

                  for(int var15 = 0; var15 < var14.length; ++var15) {
                     Method var16 = var14[var15];
                     if (Reflection.getMethodName(var16).equals(var6)) {
                        Class[] var17 = Reflection.getParameterTypes(var16);
                        if (var21.length == var17.length) {
                           boolean var18 = true;

                           for(int var19 = 0; var19 < var21.length; ++var19) {
                              if (var17[var19] != var21[var19]) {
                                 var18 = false;
                                 break;
                              }
                           }

                           if (var18 && var22 == var16.getReturnType()) {
                              var2.methods[var3] = var16;
                           }
                        }
                     }
                  }

                  var2.arguments[var3] = var10;
               }
            } else {
               var5 = var0.readStringCp1252NullTerminated();
               var6 = var0.readStringCp1252NullTerminated();
               var7 = 0;
               if (var4 == 1) {
                  var7 = var0.readInt();
               }

               var2.operations[var3] = var4;
               var2.intReplaceValues[var3] = var7;
               if (loadClassFromDescriptor(var5).getClassLoader() == null) {
                  throw new SecurityException();
               }

               var2.fields[var3] = Reflection.findField(loadClassFromDescriptor(var5), var6);
            }
         } catch (ClassNotFoundException var24) {
            var2.creationErrors[var3] = -1;
         } catch (SecurityException var25) {
            var2.creationErrors[var3] = -2;
         } catch (NullPointerException var26) {
            var2.creationErrors[var3] = -3;
         } catch (Exception var27) {
            var2.creationErrors[var3] = -4;
         } catch (Throwable var28) {
            var2.creationErrors[var3] = -5;
         }
      }

      class37.reflectionChecks.addFirst(var2);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;S)Ljava/lang/Class;",
      garbageValue = "-21331"
   )
   static Class loadClassFromDescriptor(String var0) throws ClassNotFoundException {
      if (var0.equals("B")) {
         return Byte.TYPE;
      } else if (var0.equals("I")) {
         return Integer.TYPE;
      } else if (var0.equals("S")) {
         return Short.TYPE;
      } else if (var0.equals("J")) {
         return Long.TYPE;
      } else if (var0.equals("Z")) {
         return Boolean.TYPE;
      } else if (var0.equals("F")) {
         return Float.TYPE;
      } else if (var0.equals("D")) {
         return Double.TYPE;
      } else if (var0.equals("C")) {
         return Character.TYPE;
      } else {
         return var0.equals("void") ? Void.TYPE : Reflection.findClass(var0);
      }
   }
}

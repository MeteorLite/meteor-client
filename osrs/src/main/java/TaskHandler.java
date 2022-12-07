import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
@Implements("TaskHandler")
public class TaskHandler implements Runnable {
   @ObfuscatedName("h")
   @Export("javaVendor")
   public static String javaVendor;
   @ObfuscatedName("e")
   @Export("javaVersion")
   public static String javaVersion;
   @ObfuscatedName("ha")
   @ObfuscatedSignature(
      descriptor = "Ldl;"
   )
   @Export("urlRequester")
   static UrlRequester urlRequester;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lfl;"
   )
   @Export("current")
   Task current = null;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Lfl;"
   )
   @Export("task")
   Task task = null;
   @ObfuscatedName("m")
   @Export("thread")
   Thread thread;
   @ObfuscatedName("q")
   @Export("isClosed")
   boolean isClosed = false;

   public TaskHandler() {
      javaVendor = "Unknown";
      javaVersion = "1.6";

      try {
         javaVendor = System.getProperty("java.vendor");
         javaVersion = System.getProperty("java.version");
      } catch (Exception var2) {
         ;
      }

      this.isClosed = false;
      this.thread = new Thread(this);
      this.thread.setPriority(10);
      this.thread.setDaemon(true);
      this.thread.start();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "898320509"
   )
   @Export("close")
   public final void close() {
      synchronized(this) {
         this.isClosed = true;
         this.notifyAll();
      }

      try {
         this.thread.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(IIILjava/lang/Object;B)Lfl;",
      garbageValue = "-5"
   )
   @Export("newTask")
   final Task newTask(int var1, int var2, int var3, Object var4) {
      Task var5 = new Task();
      var5.type = var1;
      var5.intArgument = var2;
      var5.objectArgument = var4;
      synchronized(this) {
         if (this.task != null) {
            this.task.next = var5;
            this.task = var5;
         } else {
            this.task = this.current = var5;
         }

         this.notify();
         return var5;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;IB)Lfl;",
      garbageValue = "1"
   )
   @Export("newSocketTask")
   public final Task newSocketTask(String var1, int var2) {
      return this.newTask(1, var2, 0, var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/Runnable;IS)Lfl;",
      garbageValue = "228"
   )
   @Export("newThreadTask")
   public final Task newThreadTask(Runnable var1, int var2) {
      return this.newTask(2, var2, 0, var1);
   }

   public final void run() {
      while(true) {
         Task var1;
         synchronized(this) {
            while(true) {
               if (this.isClosed) {
                  return;
               }

               if (this.current != null) {
                  var1 = this.current;
                  this.current = this.current.next;
                  if (this.current == null) {
                     this.task = null;
                  }
                  break;
               }

               try {
                  this.wait();
               } catch (InterruptedException var8) {
                  ;
               }
            }
         }

         try {
            int var5 = var1.type;
            if (var5 == 1) {
               var1.result = new Socket(InetAddress.getByName((String)var1.objectArgument), var1.intArgument);
            } else if (var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.objectArgument);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.intArgument);
               var1.result = var3;
            } else if (var5 == 4) {
               var1.result = new DataInputStream(((URL)var1.objectArgument).openStream());
            }

            var1.status = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.status = 2;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1336568457"
   )
   @Export("setLoginResponseString")
   static void setLoginResponseString(String var0, String var1, String var2) {
      Login.Login_response1 = var0;
      Login.Login_response2 = var1;
      Login.Login_response3 = var2;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/CharSequence;B)Ljava/lang/String;",
      garbageValue = "81"
   )
   public static String method3447(CharSequence var0) {
      return HealthBar.method2525('*', var0.length());
   }

   @ObfuscatedName("mf")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-2117100344"
   )
   public static boolean method3443() {
      return Client.staffModLevel >= 2;
   }
}

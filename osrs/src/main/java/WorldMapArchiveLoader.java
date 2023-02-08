import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qz")
@Implements("WorldMapArchiveLoader")
public class WorldMapArchiveLoader {
    @ObfuscatedName("z")
    String cacheName;
    @ObfuscatedName("j")
    @ObfuscatedSignature(
            descriptor = "Lln;"
    )
    AbstractArchive archive;
    @ObfuscatedName("i")
    int percentLoaded = 0;
    @ObfuscatedName("n")
    boolean loaded = false;

   @ObfuscatedSignature(
      descriptor = "(Lln;)V"
   )
   WorldMapArchiveLoader(AbstractArchive var1) {
      this.archive = var1;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(Ljava/lang/String;B)V",
            garbageValue = "-27"
    )
    void reset(String var1) {
      if (var1 != null && !var1.isEmpty()) {
         if (var1 != this.cacheName) {
            this.cacheName = var1;
            this.percentLoaded = 0;
            this.loaded = false;
            this.load();
         }
      }
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-685502052"
    )
    int load() {
      if (this.percentLoaded < 33) {
         if (!this.archive.tryLoadFileByNames(WorldMapCacheName.field2398.name, this.cacheName)) {
            return this.percentLoaded;
         }

         this.percentLoaded = 33;
      }

      if (this.percentLoaded == 33) {
         if (this.archive.isValidFileName(WorldMapCacheName.field2394.name, this.cacheName) && !this.archive.tryLoadFileByNames(WorldMapCacheName.field2394.name, this.cacheName)) {
            return this.percentLoaded;
         }

         this.percentLoaded = 66;
      }

      if (this.percentLoaded == 66) {
         if (!this.archive.tryLoadFileByNames(this.cacheName, WorldMapCacheName.field2396.name)) {
            return this.percentLoaded;
         }

         this.percentLoaded = 100;
         this.loaded = true;
      }

      return this.percentLoaded;
   }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "(I)Z",
            garbageValue = "770767761"
    )
    boolean isLoaded() {
      return this.loaded;
   }

    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "32"
    )
    int getPercentLoaded() {
      return this.percentLoaded;
   }
}

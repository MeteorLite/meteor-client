import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rh")
@Implements("WorldMapArchiveLoader")
public class WorldMapArchiveLoader {
    @ObfuscatedName("au")
    String cacheName;
    @ObfuscatedName("ab")
    @ObfuscatedSignature(
            descriptor = "Lnm;"
    )
    AbstractArchive archive;
    @ObfuscatedName("aq")
    int percentLoaded = 0;
    @ObfuscatedName("al")
    boolean loaded = false;

   @ObfuscatedSignature(
      descriptor = "(Lnm;)V"
   )
   WorldMapArchiveLoader(AbstractArchive var1) {
      this.archive = var1;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(Ljava/lang/String;I)V",
            garbageValue = "-527718287"
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

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-503506459"
    )
    int load() {
      if (this.cacheName == null) {
         this.percentLoaded = 100;
         this.loaded = true;
      } else {
         if (this.percentLoaded < 33) {
            if (!this.archive.tryLoadFileByNames(WorldMapCacheName.field2439.name, this.cacheName)) {
               return this.percentLoaded;
            }

            this.percentLoaded = 33;
         }

         if (this.percentLoaded == 33) {
            if (this.archive.isValidFileName(WorldMapCacheName.field2436.name, this.cacheName) && !this.archive.tryLoadFileByNames(WorldMapCacheName.field2436.name, this.cacheName)) {
               return this.percentLoaded;
            }

            this.percentLoaded = 66;
         }

         if (this.percentLoaded == 66) {
            if (!this.archive.tryLoadFileByNames(this.cacheName, WorldMapCacheName.field2434.name)) {
               return this.percentLoaded;
            }

            this.percentLoaded = 100;
            this.loaded = true;
         }
      }

      return this.percentLoaded;
   }

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "(I)Z",
            garbageValue = "2028152441"
    )
    boolean isLoaded() {
      return this.loaded;
   }

    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "75"
    )
    int getPercentLoaded() {
      return this.percentLoaded;
   }
}

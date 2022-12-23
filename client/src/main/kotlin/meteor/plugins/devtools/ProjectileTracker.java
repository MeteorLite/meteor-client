package meteor.plugins.devtools;

import eventbus.events.ProjectileSpawned;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

import javax.inject.Inject;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Kris | 05/02/2022
 */
@SuppressWarnings("ALL")
@Slf4j
public class ProjectileTracker {
    private final Client client;
    private final Map<StaticProjectileInfo, List<DynamicProjectileInfo>> trackedProjectiles = Collections.synchronizedMap(new HashMap<>());

    @Inject
    public ProjectileTracker(Client client) {
        this.client = client;
    }

    public Triple<StaticProjectileInfo, DynamicProjectileInfo, List<DynamicProjectileInfo>> addEvent(
            ProjectileSpawned event, Map<Player,
            Pair<Integer, WorldPoint>> playerMovements) {
        Projectile projectile = event.getProjectile();
        final int localSrcPointX = projectile.getX1();
        final int localSrcPointY = projectile.getY1();
        final LocalPoint sourcePoint = new LocalPoint(localSrcPointX, localSrcPointY);
        final int tileHeight = Perspective.getTileHeight(client, sourcePoint, projectile.getFloor());
        final int currentCycle = client.getGameCycle();
        final int startCycle = projectile.getStartCycle() - currentCycle;
        final int endCycle = projectile.getEndCycle() - currentCycle;
        final int id = projectile.getId();
        final int startHeight = -((projectile.getHeight() - tileHeight) / 4);
        final int endHeight = projectile.getEndHeight() / 4;
        final int angle = projectile.getSlope();
        final int distOffset = projectile.getStartHeight();

        final Pair<Actor, WorldPoint> source = getSource(event);
        final WorldPoint sourceTile = source.getRight();
        final Actor sourceActor = source.getLeft();
        final Pair<Actor, WorldPoint> destination = getDestination(event);
        WorldPoint destinationTile = destination.getRight();
        final Actor destinationActor = destination.getLeft();
        // If the projectile shoots from a npc to a player, it is calculated before the player has taken a step, so it must be ran against the player's
        // previous tile.
        if (sourceActor instanceof NPC && destinationActor instanceof Player) {
            final int clientTick = client.getTickCount();
            final Pair<Integer, WorldPoint> previousLocation = playerMovements.get(destinationActor);
            if (previousLocation != null && previousLocation.getLeft() == clientTick) {
                destinationTile = previousLocation.getRight();
            }
        }

        final WorldArea sourceWorldArea = sourceActor != null ? sourceActor.getWorldArea() : new WorldArea(sourceTile, 1, 1);
        final int destinationActorSize = destinationActor != null ? destinationActor.getWorldArea().getWidth() : 1;
        final WorldArea destinationWorldArea = new WorldArea(destinationTile, destinationActorSize, destinationActorSize);
        final int distance2D = sourceWorldArea.distanceTo2D(destinationWorldArea);

        final StaticProjectileInfo staticInfo = new StaticProjectileInfo(id, startHeight, endHeight, angle, distOffset, startCycle);
        final DynamicProjectileInfo dynamicInfo = new DynamicProjectileInfo(sourceActor, destinationActor, sourceWorldArea,
                destinationWorldArea, WorldPoint.fromLocal(client, sourcePoint), endCycle - startCycle, distance2D, sourceWorldArea.distanceTo(destinationTile));
        final List<DynamicProjectileInfo> trackedInformation = trackedProjectiles.computeIfAbsent(staticInfo, s -> new ArrayList<>());
        final Set<Integer> distinctDistances = new HashSet<>();
        distinctDistances.add(dynamicInfo.swDistance);
        final List<DynamicProjectileInfo> comparisonPoints =
                trackedInformation.stream().filter(element -> distinctDistances.add(element.swDistance)).collect(Collectors.toList());
        trackedInformation.add(0, dynamicInfo); // Add to the front.
        return new ImmutableTriple<>(staticInfo, dynamicInfo, comparisonPoints);
    }

    private Pair<Actor, WorldPoint> getDestination(ProjectileSpawned event) {
        Projectile projectile = event.getProjectile();
        /* If target idx isn't 0 but actor is null, we cannot accurately measure the projectile's info so discard it. */
        final int targetIdx = event.getProjectile().getRsInteracting();
        final Actor target = projectile.getInteracting();
        /* If the project is locked onto the target, but we cannot see the target as they're too far from us, we have to estimate the destination. */
        if (target == null) {
            return Pair.of(null, WorldPoint.fromLocal(client, projectile.getTarget()));
        }
        return Pair.of(target, target.getWorldLocation());
    }

    private Pair<Actor, WorldPoint> getSource(ProjectileSpawned event) {
        Projectile projectile = event.getProjectile();
        final int localSrcPointX = projectile.getX1();
        final int localSrcPointY = projectile.getY1();
        final LocalPoint sourcePoint = new LocalPoint(localSrcPointX, localSrcPointY);
        final WorldPoint worldPoint = WorldPoint.fromLocal(client, sourcePoint);
        final List<NPC> potentialNPCs = getIntersectingActors(worldPoint, client.getNpcs());
        final List<NPC> filteredNPCs = potentialNPCs.stream().filter(npc -> {
            // For size <= 2 NPCs specifically, the projectile _always_ shoots out from the south-western tile, regardless of the angle.
            if (npc.getComposition().getSize() <= 2) {
                return worldPoint.equals(npc.getWorldLocation());
            }
            /* For all the other sizes, it is rather ambiguous and works on a per-npc basis. */
            return true;
        }).collect(Collectors.toList());
        if (filteredNPCs.size() > 1) {
            final List<NPC> attackableNPCs = filteredNPCs.stream()
                    .filter(npc -> ArrayUtils.contains(npc.getComposition().getActions(), "Attack")) // Separate logic filter if there are too many matches.
                    .collect(Collectors.toList());
            /* If there are multiple potential NPCs, but only one of them is attackable, it's probably that. */
            if (attackableNPCs.size() == 1) {
                return Pair.of(attackableNPCs.get(0), attackableNPCs.get(0).getWorldLocation()); // Use single attackable npc.
            } else {
                final NPC baseNPC = filteredNPCs.get(0);
                // If all the potential NPCs are equal size, and all of them are standing on the exact same tile, we just pick one of the npcs and use that -
                // it won't matter if it's not the actual source, the projectile will get properly deciphered.
                final boolean identicalPosition = filteredNPCs.stream()
                        .allMatch(npc -> npc.getComposition().getSize() == baseNPC.getComposition().getSize() && npc.getLocalLocation().equals(baseNPC.getLocalLocation()));
                if (identicalPosition) {
                    return Pair.of(baseNPC, baseNPC.getWorldLocation());
                } else {
                    /* Ambiguous. */
                    return Pair.of(null, worldPoint);
                }
            }
        } else if (filteredNPCs.size() == 1) {
            return Pair.of(filteredNPCs.get(0), filteredNPCs.get(0).getWorldLocation());
        }

        final List<Player> potentialPlayers = getIntersectingActors(worldPoint, client.getPlayers());
        if (potentialPlayers.isEmpty()) {
            return Pair.of(null, worldPoint);
        } else {
            return Pair.of(potentialPlayers.get(0), potentialPlayers.get(0).getWorldLocation());
        }
    }

    private <T extends Actor> List<T> getIntersectingActors(WorldPoint point, List<T> actors) {
        return actors.stream()
                .filter(actor -> actor.getAnimation() > 0) // Actor needs to be playing an animation to send out a projectile; should never be decoupled.
                .filter(actor -> actor.getWorldArea().intersectsWith(new WorldArea(point, 1, 1))) // Projectile has to come from inside the actor.
                .collect(Collectors.toList());
    }

    @EqualsAndHashCode
    @Getter
    static class DynamicProjectileInfo {
        private final Actor startActor;
        private final Actor endActor;
        private final WorldArea startPoint;
        private final WorldArea endPoint;
        private final WorldPoint visualStart;
        private final int flightDuration;
        private final int distance;
        private final int swDistance;
        DynamicProjectileInfo(Actor startActor,
                              Actor endActor,
                              WorldArea startPoint,
                              WorldArea endPoint,
                              WorldPoint visualStart,
                              int flightDuration,
                              int distance,
                              int swDistance) {
            this.startActor = startActor;
            this.endActor = endActor;
            this.startPoint = startPoint;
            this.endPoint = endPoint;
            this.flightDuration = flightDuration;
            this.distance = distance;
            this.swDistance = swDistance;
            this.visualStart = visualStart;
        }
    }

    @Data
    static class StaticProjectileInfo {
        private final int id;
        private final int startHeight;
        private final int endHeight;
        private final int angle;
        private final int distanceOffset;
        private final int delay;
    }
}

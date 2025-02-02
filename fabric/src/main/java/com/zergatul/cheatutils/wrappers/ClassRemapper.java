package com.zergatul.cheatutils.wrappers;

import net.fabricmc.loader.api.FabricLoader;

import java.util.HashMap;
import java.util.Map;

public class ClassRemapper {

    private static final boolean enabled = !FabricLoader.getInstance().getMappingResolver().getCurrentRuntimeNamespace().equals("named");
    private static final Map<String, String> obfToNorm = new HashMap<>();
    private static final Map<String, String> normToObf = new HashMap<>();

    private static String[] mappings = new String[] {
            "net.minecraft.class_1915:net.minecraft.world.item.trading.Merchant",
            "net.minecraft.class_2615:net.minecraft.world.level.block.entity.Hopper",
            "net.minecraft.class_5718$class_5719:net.minecraft.world.level.gameevent.vibrations.VibrationListener$VibrationListenerConfig",
            "net.minecraft.class_1265:net.minecraft.world.ContainerListener",
            "net.minecraft.class_1296:net.minecraft.world.entity.AgeableMob",
            "net.minecraft.class_1295:net.minecraft.world.entity.AreaEffectCloud",
            "net.minecraft.class_1297:net.minecraft.world.entity.Entity",
            "net.minecraft.class_1307:net.minecraft.world.entity.FlyingMob",
            "net.minecraft.class_1303:net.minecraft.world.entity.ExperienceOrb",
            "net.minecraft.class_5776:net.minecraft.world.entity.GlowSquid",
            "net.minecraft.class_7248:net.minecraft.world.entity.HasCustomInventoryScreen",
            "net.minecraft.class_4981:net.minecraft.world.entity.ItemSteerable",
            "net.minecraft.class_1538:net.minecraft.world.entity.LightningBolt",
            "net.minecraft.class_6375:net.minecraft.world.entity.LerpingModel",
            "net.minecraft.class_6335:net.minecraft.world.entity.Marker",
            "net.minecraft.class_1309:net.minecraft.world.entity.LivingEntity",
            "net.minecraft.class_1308:net.minecraft.world.entity.Mob",
            "net.minecraft.class_5354:net.minecraft.world.entity.NeutralMob",
            "net.minecraft.class_1314:net.minecraft.world.entity.PathfinderMob",
            "net.minecraft.class_6025:net.minecraft.world.entity.OwnableEntity",
            "net.minecraft.class_1316:net.minecraft.world.entity.PlayerRideableJumping",
            "net.minecraft.class_4582:net.minecraft.world.entity.PowerableMob",
            "net.minecraft.class_4094:net.minecraft.world.entity.ReputationEventHandler",
            "net.minecraft.class_5147:net.minecraft.world.entity.Shearable",
            "net.minecraft.class_5146:net.minecraft.world.entity.Saddleable",
            "net.minecraft.class_7988:net.minecraft.world.entity.VariantHolder",
            "net.minecraft.class_1321:net.minecraft.world.entity.TamableAnimal",
            "net.minecraft.class_1421:net.minecraft.world.entity.ambient.AmbientCreature",
            "net.minecraft.class_1420:net.minecraft.world.entity.ambient.Bat",
            "net.minecraft.class_1427:net.minecraft.world.entity.animal.AbstractGolem",
            "net.minecraft.class_1422:net.minecraft.world.entity.animal.AbstractFish",
            "net.minecraft.class_1429:net.minecraft.world.entity.animal.Animal",
            "net.minecraft.class_1425:net.minecraft.world.entity.animal.AbstractSchoolingFish",
            "net.minecraft.class_5761:net.minecraft.world.entity.animal.Bucketable",
            "net.minecraft.class_4466:net.minecraft.world.entity.animal.Bee",
            "net.minecraft.class_1451:net.minecraft.world.entity.animal.Cat",
            "net.minecraft.class_1431:net.minecraft.world.entity.animal.Cod",
            "net.minecraft.class_1428:net.minecraft.world.entity.animal.Chicken",
            "net.minecraft.class_1433:net.minecraft.world.entity.animal.Dolphin",
            "net.minecraft.class_1430:net.minecraft.world.entity.animal.Cow",
            "net.minecraft.class_4019:net.minecraft.world.entity.animal.Fox",
            "net.minecraft.class_1432:net.minecraft.world.entity.animal.FlyingAnimal",
            "net.minecraft.class_1438:net.minecraft.world.entity.animal.MushroomCow",
            "net.minecraft.class_1439:net.minecraft.world.entity.animal.IronGolem",
            "net.minecraft.class_1440:net.minecraft.world.entity.animal.Panda",
            "net.minecraft.class_3701:net.minecraft.world.entity.animal.Ocelot",
            "net.minecraft.class_1452:net.minecraft.world.entity.animal.Pig",
            "net.minecraft.class_1453:net.minecraft.world.entity.animal.Parrot",
            "net.minecraft.class_1454:net.minecraft.world.entity.animal.Pufferfish",
            "net.minecraft.class_1456:net.minecraft.world.entity.animal.PolarBear",
            "net.minecraft.class_1462:net.minecraft.world.entity.animal.Salmon",
            "net.minecraft.class_1463:net.minecraft.world.entity.animal.Rabbit",
            "net.minecraft.class_1471:net.minecraft.world.entity.animal.ShoulderRidingEntity",
            "net.minecraft.class_1472:net.minecraft.world.entity.animal.Sheep",
            "net.minecraft.class_1477:net.minecraft.world.entity.animal.Squid",
            "net.minecraft.class_1473:net.minecraft.world.entity.animal.SnowGolem",
            "net.minecraft.class_1481:net.minecraft.world.entity.animal.Turtle",
            "net.minecraft.class_1474:net.minecraft.world.entity.animal.TropicalFish",
            "net.minecraft.class_1493:net.minecraft.world.entity.animal.Wolf",
            "net.minecraft.class_1480:net.minecraft.world.entity.animal.WaterAnimal",
            "net.minecraft.class_7298:net.minecraft.world.entity.animal.allay.Allay",
            "net.minecraft.class_5762:net.minecraft.world.entity.animal.axolotl.Axolotl",
            "net.minecraft.class_7102:net.minecraft.world.entity.animal.frog.Frog",
            "net.minecraft.class_7110:net.minecraft.world.entity.animal.frog.Tadpole",
            "net.minecraft.class_6053:net.minecraft.world.entity.animal.goat.Goat",
            "net.minecraft.class_1492:net.minecraft.world.entity.animal.horse.AbstractChestedHorse",
            "net.minecraft.class_1495:net.minecraft.world.entity.animal.horse.Donkey",
            "net.minecraft.class_1496:net.minecraft.world.entity.animal.horse.AbstractHorse",
            "net.minecraft.class_1501:net.minecraft.world.entity.animal.horse.Llama",
            "net.minecraft.class_1498:net.minecraft.world.entity.animal.horse.Horse",
            "net.minecraft.class_1500:net.minecraft.world.entity.animal.horse.Mule",
            "net.minecraft.class_1506:net.minecraft.world.entity.animal.horse.SkeletonHorse",
            "net.minecraft.class_3986:net.minecraft.world.entity.animal.horse.TraderLlama",
            "net.minecraft.class_1507:net.minecraft.world.entity.animal.horse.ZombieHorse",
            "net.minecraft.class_1511:net.minecraft.world.entity.boss.enderdragon.EndCrystal",
            "net.minecraft.class_1510:net.minecraft.world.entity.boss.enderdragon.EnderDragon",
            "net.minecraft.class_1528:net.minecraft.world.entity.boss.wither.WitherBoss",
            "net.minecraft.class_5915:net.minecraft.world.entity.decoration.GlowItemFrame",
            "net.minecraft.class_1531:net.minecraft.world.entity.decoration.ArmorStand",
            "net.minecraft.class_1530:net.minecraft.world.entity.decoration.HangingEntity",
            "net.minecraft.class_1532:net.minecraft.world.entity.decoration.LeashFenceKnotEntity",
            "net.minecraft.class_1533:net.minecraft.world.entity.decoration.ItemFrame",
            "net.minecraft.class_1534:net.minecraft.world.entity.decoration.Painting",
            "net.minecraft.class_1542:net.minecraft.world.entity.item.ItemEntity",
            "net.minecraft.class_1540:net.minecraft.world.entity.item.FallingBlockEntity",
            "net.minecraft.class_1541:net.minecraft.world.entity.item.PrimedTnt",
            "net.minecraft.class_1547:net.minecraft.world.entity.monster.AbstractSkeleton",
            "net.minecraft.class_1543:net.minecraft.world.entity.monster.AbstractIllager",
            "net.minecraft.class_1549:net.minecraft.world.entity.monster.CaveSpider",
            "net.minecraft.class_1545:net.minecraft.world.entity.monster.Blaze",
            "net.minecraft.class_3745:net.minecraft.world.entity.monster.CrossbowAttackMob",
            "net.minecraft.class_1548:net.minecraft.world.entity.monster.Creeper",
            "net.minecraft.class_1550:net.minecraft.world.entity.monster.ElderGuardian",
            "net.minecraft.class_1551:net.minecraft.world.entity.monster.Drowned",
            "net.minecraft.class_1559:net.minecraft.world.entity.monster.Endermite",
            "net.minecraft.class_1560:net.minecraft.world.entity.monster.EnderMan",
            "net.minecraft.class_1564:net.minecraft.world.entity.monster.Evoker",
            "net.minecraft.class_1569:net.minecraft.world.entity.monster.Enemy",
            "net.minecraft.class_1570:net.minecraft.world.entity.monster.Giant",
            "net.minecraft.class_1571:net.minecraft.world.entity.monster.Ghast",
            "net.minecraft.class_1577:net.minecraft.world.entity.monster.Guardian",
            "net.minecraft.class_1581:net.minecraft.world.entity.monster.Illusioner",
            "net.minecraft.class_1576:net.minecraft.world.entity.monster.Husk",
            "net.minecraft.class_1588:net.minecraft.world.entity.monster.Monster",
            "net.minecraft.class_1589:net.minecraft.world.entity.monster.MagmaCube",
            "net.minecraft.class_1593:net.minecraft.world.entity.monster.Phantom",
            "net.minecraft.class_3732:net.minecraft.world.entity.monster.PatrollingMonster",
            "net.minecraft.class_1603:net.minecraft.world.entity.monster.RangedAttackMob",
            "net.minecraft.class_1604:net.minecraft.world.entity.monster.Pillager",
            "net.minecraft.class_1606:net.minecraft.world.entity.monster.Shulker",
            "net.minecraft.class_1584:net.minecraft.world.entity.monster.Ravager",
            "net.minecraft.class_1613:net.minecraft.world.entity.monster.Skeleton",
            "net.minecraft.class_1614:net.minecraft.world.entity.monster.Silverfish",
            "net.minecraft.class_1617:net.minecraft.world.entity.monster.SpellcasterIllager",
            "net.minecraft.class_1621:net.minecraft.world.entity.monster.Slime",
            "net.minecraft.class_1627:net.minecraft.world.entity.monster.Stray",
            "net.minecraft.class_1628:net.minecraft.world.entity.monster.Spider",
            "net.minecraft.class_1634:net.minecraft.world.entity.monster.Vex",
            "net.minecraft.class_4985:net.minecraft.world.entity.monster.Strider",
            "net.minecraft.class_1640:net.minecraft.world.entity.monster.Witch",
            "net.minecraft.class_1632:net.minecraft.world.entity.monster.Vindicator",
            "net.minecraft.class_5136:net.minecraft.world.entity.monster.Zoglin",
            "net.minecraft.class_1639:net.minecraft.world.entity.monster.WitherSkeleton",
            "net.minecraft.class_1641:net.minecraft.world.entity.monster.ZombieVillager",
            "net.minecraft.class_1642:net.minecraft.world.entity.monster.Zombie",
            "net.minecraft.class_4760:net.minecraft.world.entity.monster.hoglin.Hoglin",
            "net.minecraft.class_1590:net.minecraft.world.entity.monster.ZombifiedPiglin",
            "net.minecraft.class_5137:net.minecraft.world.entity.monster.hoglin.HoglinBase",
            "net.minecraft.class_5418:net.minecraft.world.entity.monster.piglin.AbstractPiglin",
            "net.minecraft.class_4836:net.minecraft.world.entity.monster.piglin.Piglin",
            "net.minecraft.class_5419:net.minecraft.world.entity.monster.piglin.PiglinBrute",
            "net.minecraft.class_7260:net.minecraft.world.entity.monster.warden.Warden",
            "net.minecraft.class_3988:net.minecraft.world.entity.npc.AbstractVillager",
            "net.minecraft.class_1655:net.minecraft.world.entity.npc.Npc",
            "net.minecraft.class_6067:net.minecraft.world.entity.npc.InventoryCarrier",
            "net.minecraft.class_1646:net.minecraft.world.entity.npc.Villager",
            "net.minecraft.class_3851:net.minecraft.world.entity.npc.VillagerDataHolder",
            "net.minecraft.class_3989:net.minecraft.world.entity.npc.WanderingTrader",
            "net.minecraft.class_1657:net.minecraft.world.entity.player.Player",
            "net.minecraft.class_1665:net.minecraft.world.entity.projectile.AbstractArrow",
            "net.minecraft.class_1667:net.minecraft.world.entity.projectile.Arrow",
            "net.minecraft.class_1668:net.minecraft.world.entity.projectile.AbstractHurtingProjectile",
            "net.minecraft.class_1669:net.minecraft.world.entity.projectile.EvokerFangs",
            "net.minecraft.class_1670:net.minecraft.world.entity.projectile.DragonFireball",
            "net.minecraft.class_1672:net.minecraft.world.entity.projectile.EyeOfEnder",
            "net.minecraft.class_1671:net.minecraft.world.entity.projectile.FireworkRocketEntity",
            "net.minecraft.class_3855:net.minecraft.world.entity.projectile.Fireball",
            "net.minecraft.class_3856:net.minecraft.world.entity.projectile.ItemSupplier",
            "net.minecraft.class_1536:net.minecraft.world.entity.projectile.FishingHook",
            "net.minecraft.class_1673:net.minecraft.world.entity.projectile.LlamaSpit",
            "net.minecraft.class_1674:net.minecraft.world.entity.projectile.LargeFireball",
            "net.minecraft.class_1676:net.minecraft.world.entity.projectile.Projectile",
            "net.minecraft.class_1677:net.minecraft.world.entity.projectile.SmallFireball",
            "net.minecraft.class_1678:net.minecraft.world.entity.projectile.ShulkerBullet",
            "net.minecraft.class_1679:net.minecraft.world.entity.projectile.SpectralArrow",
            "net.minecraft.class_1680:net.minecraft.world.entity.projectile.Snowball",
            "net.minecraft.class_1682:net.minecraft.world.entity.projectile.ThrowableProjectile",
            "net.minecraft.class_3857:net.minecraft.world.entity.projectile.ThrowableItemProjectile",
            "net.minecraft.class_1684:net.minecraft.world.entity.projectile.ThrownEnderpearl",
            "net.minecraft.class_1681:net.minecraft.world.entity.projectile.ThrownEgg",
            "net.minecraft.class_1686:net.minecraft.world.entity.projectile.ThrownPotion",
            "net.minecraft.class_1683:net.minecraft.world.entity.projectile.ThrownExperienceBottle",
            "net.minecraft.class_1687:net.minecraft.world.entity.projectile.WitherSkull",
            "net.minecraft.class_1685:net.minecraft.world.entity.projectile.ThrownTrident",
            "net.minecraft.class_3763:net.minecraft.world.entity.raid.Raider",
            "net.minecraft.class_1693:net.minecraft.world.entity.vehicle.AbstractMinecartContainer",
            "net.minecraft.class_1688:net.minecraft.world.entity.vehicle.AbstractMinecart",
            "net.minecraft.class_7264:net.minecraft.world.entity.vehicle.ChestBoat",
            "net.minecraft.class_1690:net.minecraft.world.entity.vehicle.Boat",
            "net.minecraft.class_7265:net.minecraft.world.entity.vehicle.ContainerEntity",
            "net.minecraft.class_1694:net.minecraft.world.entity.vehicle.MinecartChest",
            "net.minecraft.class_1695:net.minecraft.world.entity.vehicle.Minecart",
            "net.minecraft.class_1696:net.minecraft.world.entity.vehicle.MinecartFurnace",
            "net.minecraft.class_1697:net.minecraft.world.entity.vehicle.MinecartCommandBlock",
            "net.minecraft.class_1699:net.minecraft.world.entity.vehicle.MinecartSpawner",
            "net.minecraft.class_1700:net.minecraft.world.entity.vehicle.MinecartHopper",
            "net.minecraft.class_1701:net.minecraft.world.entity.vehicle.MinecartTNT",
    };

    public static boolean isEnabled() {
        return enabled;
    }

    public static String fromObf(String className) {
        if (!enabled) {
            return className;
        }
        return obfToNorm.getOrDefault(className, className);
    }

    public static String toObf(String className) {
        if (!enabled) {
            return className;
        }
        return normToObf.getOrDefault(className, className);
    }

    static {
        for (String c: mappings) {
            String[] parts = c.split(":");
            String obf = parts[0];
            String norm = parts[1];
            obfToNorm.put(obf, norm);
            normToObf.put(norm, obf);
        }
    }
}
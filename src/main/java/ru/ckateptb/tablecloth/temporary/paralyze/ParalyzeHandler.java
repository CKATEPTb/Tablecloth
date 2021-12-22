package ru.ckateptb.tablecloth.temporary.paralyze;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.springframework.stereotype.Component;
import ru.ckateptb.tablecloth.config.TableclothConfig;
import ru.ckateptb.tablecloth.temporary.Temporary;
import ru.ckateptb.tablecloth.temporary.TemporaryService;

@Component
public class ParalyzeHandler implements Listener {
    private final TableclothConfig config;
    private final TemporaryService temporaryService;

    public ParalyzeHandler(TableclothConfig config, TemporaryService temporaryService) {
        this.config = config;
        this.temporaryService = temporaryService;
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void on(EntityDamageByEntityEvent event) {
        if (config.getParalyzeType() == ParalyzeType.MOVE_HANDLER && event.getDamager().hasMetadata("tablecloth:paralyze")) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void on(PlayerInteractEvent event) {
        if (config.getParalyzeType() == ParalyzeType.MOVE_HANDLER && event.getPlayer().hasMetadata("tablecloth:paralyze")) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void on(BlockPlaceEvent event) {
        if (config.getParalyzeType() == ParalyzeType.MOVE_HANDLER && event.getPlayer().hasMetadata("tablecloth:paralyze")) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void on(EntityChangeBlockEvent event) {
        if (config.getParalyzeType() == ParalyzeType.MOVE_HANDLER && event.getEntity().hasMetadata("tablecloth:paralyze")) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void on(EntityExplodeEvent event) {
        if (config.getParalyzeType() == ParalyzeType.MOVE_HANDLER && event.getEntity().hasMetadata("tablecloth:paralyze")) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void on(EntityInteractEvent event) {
        if (config.getParalyzeType() == ParalyzeType.MOVE_HANDLER && event.getEntity().hasMetadata("tablecloth:paralyze")) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void on(ProjectileLaunchEvent event) {
        if (config.getParalyzeType() == ParalyzeType.MOVE_HANDLER && event.getEntity().hasMetadata("tablecloth:paralyze")) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void on(EntityShootBowEvent event) {
        if (config.getParalyzeType() == ParalyzeType.MOVE_HANDLER && event.getEntity().hasMetadata("tablecloth:paralyze")) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void on(SlimeSplitEvent event) {
        if (config.getParalyzeType() == ParalyzeType.MOVE_HANDLER && event.getEntity().hasMetadata("tablecloth:paralyze")) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void on(EntityTargetEvent event) {
        if (config.getParalyzeType() == ParalyzeType.MOVE_HANDLER && event.getEntity().hasMetadata("tablecloth:paralyze")) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void on(EntityTargetLivingEntityEvent event) {
        if (config.getParalyzeType() == ParalyzeType.MOVE_HANDLER && event.getEntity().hasMetadata("tablecloth:paralyze")) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void on(EntityTeleportEvent event) {
        if (config.getParalyzeType() == ParalyzeType.MOVE_HANDLER && event.getEntity().hasMetadata("tablecloth:paralyze")) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void on(PlayerInteractAtEntityEvent event) {
        if (config.getParalyzeType() == ParalyzeType.MOVE_HANDLER && event.getPlayer().hasMetadata("tablecloth:paralyze")) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void on(PlayerMoveEvent event) {
        if (config.getParalyzeType() == ParalyzeType.MOVE_HANDLER && event.getPlayer().hasMetadata("tablecloth:paralyze")) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void on(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();
        if (config.getParalyzeType() == ParalyzeType.MOVE_HANDLER && player.hasMetadata("tablecloth:paralyze")) {
            if (!player.isSneaking()) {
                event.setCancelled(true);
            }
        }
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void on(EntityDeathEvent event) {
        LivingEntity entity = event.getEntity();
        if(entity.hasMetadata("tablecloth:paralyze")) {
            entity.getMetadata("tablecloth:paralyze").forEach(metadataValue -> {
                if (metadataValue.value() instanceof Temporary temporary) {
                    temporaryService.revert(temporary);
                }
            });
        }
    }
}
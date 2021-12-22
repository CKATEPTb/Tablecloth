package ru.ckateptb.tablecloth.config;

import lombok.Getter;
import org.bukkit.plugin.Plugin;
import org.springframework.stereotype.Component;
import ru.ckateptb.tablecloth.Tablecloth;
import ru.ckateptb.tablecloth.temporary.paralyze.ParalyzeType;

@Getter
@Component
public class TableclothConfig extends YamlConfig {
    @ConfigField(name = "language.paralyze.name")
    private String paralyzeName = "§b§l<==§2§l Paralyzed §b§l==>";
    @ConfigField(name = "language.paralyze.type", comment = "Allowed types INVENTORY (Not perfect, but very light), ARMORSTAND (recommended ), MOVE_HANDLER (May cause TPS drawdowns with a large number of instances)")
    private String paralyzeType = ParalyzeType.ARMORSTAND.name();

    public ParalyzeType getParalyzeType() {
        return ParalyzeType.valueOf(paralyzeType);
    }

    @Override
    public Plugin getPlugin() {
        return Tablecloth.getInstance();
    }
}
# Porting notes

This unofficial Fabric port targets Minecraft 1.21.1 and is based on Andrew0030's upstream `1.20.4-Fabric` revision `4dd1d145818b6b5b52464607812a5dcfa8534d2c`.

The port updates Java 21 and Fabric dependencies, entity data and spawn APIs, holder-based frog variants, map codecs for world-generation types, custom-payload networking, and the potion-brewing builder. It carries over the upstream Java code, data files, recipes, structures, models, textures, and language resources.

Frog-leg food values remain 2 hunger / 0.3 saturation for raw and 6 hunger / 0.6 saturation for cooked. The `minecraft:meat` item tag preserves the former `FoodProperties.Builder.meat()` behavior in 1.21.1.

The release is an unofficial community port. The project and its assets remain under GNU LGPL version 3; see `LICENSE.txt`. Upstream project: https://www.curseforge.com/minecraft/mc-mods/swampier-swamps-fabric. Upstream source: https://github.com/andrew0030/SwampierSwamps. Port source: https://github.com/JustHari01/SwampierSwamps-Fabric-1.21.1-Port.

AI disclosure: AI assistance was used to adapt and validate this port.
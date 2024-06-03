package modid

import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiScreen
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.TickEvent

@Mod(
    modid = ModIDHider.MOD_ID, name = ModIDHider.MOD_NAME, version = ModIDHider.MOD_VERSION
)
class ModIDHider {

    @Mod.EventHandler
    fun onInit(event: FMLInitializationEvent) {
        MinecraftForge.EVENT_BUS.register(this)
    }

    @SubscribeEvent
    fun onTick(event: TickEvent.ClientTickEvent) {
        if (event.phase != TickEvent.Phase.START || display == null) return
        mc.displayGuiScreen(display)
        display = null
    }

    companion object {
        const val MOD_ID = "hiddenmodid"
        const val MOD_NAME = "ModIDHider"
        const val MOD_VERSION = "1.0"

        val mc: Minecraft = Minecraft.getMinecraft()
        var display: GuiScreen? = null
    }
}


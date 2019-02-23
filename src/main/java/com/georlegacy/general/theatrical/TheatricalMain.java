/*
 * Copyright 2018 Theatrical Team (James Conway (615283) & Stuart (Rushmead)) and it's contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.georlegacy.general.theatrical;

import com.georlegacy.general.theatrical.guis.handlers.TheatricalGuiHandler;
import com.georlegacy.general.theatrical.integration.cc.ComputerCraftIntegration;
import com.georlegacy.general.theatrical.logic.transport.dmx.managers.DMXUniverseRuntimeBroker;
import com.georlegacy.general.theatrical.handlers.TheatricalPacketHandler;
import com.georlegacy.general.theatrical.packets.UpdateLightPacket;
import com.georlegacy.general.theatrical.packets.handlers.UpdateLightPacketHandler;
import com.georlegacy.general.theatrical.proxy.CommonProxy;
import dan200.computercraft.core.computer.Computer;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

import static com.georlegacy.general.theatrical.util.Reference.*;

/**
 * Main class for Theatrical
 *
 * @author James Conway
 */
@Mod(modid = MOD_ID, name = NAME, version = VERSION, dependencies = "after:computercraft")
public class TheatricalMain {

    @Mod.Instance
    public static TheatricalMain instance;

    @SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = COMMON_PROXY_CLASS)
    public static CommonProxy proxy;


    @Mod.EventHandler
    public static void PreInit(FMLPreInitializationEvent event) {
        proxy.preInit();
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new TheatricalGuiHandler());
    }

    private static void initComputer(){
        ComputerCraftIntegration.init();
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event) {
        proxy.registerModelBakeryVariants();
        proxy.registerColorBlocks();
        TheatricalPacketHandler.INSTANCE.registerMessage(new UpdateLightPacketHandler(), UpdateLightPacket.class, 0,
            Side.SERVER);
        if(Loader.isModLoaded("computercraft")){
            initComputer();
        }
    }

    @Mod.EventHandler
    public static void PostInit(FMLPostInitializationEvent event) {

    }

    public TheatricalMain() {
        this.dmxUniverseRuntimeBroker = new DMXUniverseRuntimeBroker();
    }

    private final DMXUniverseRuntimeBroker dmxUniverseRuntimeBroker;

    public DMXUniverseRuntimeBroker getDmxUniverseRuntimeBroker() {
        return dmxUniverseRuntimeBroker;
    }

}

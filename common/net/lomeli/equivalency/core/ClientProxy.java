package net.lomeli.equivalency.core;

import net.lomeli.equivalency.core.handler.VersionTickHandler;

import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ClientProxy extends CommonProxy{
	@Override
	public void registerTickHandler(){
		TickRegistry.registerTickHandler(new VersionTickHandler(), Side.CLIENT);
	}
}

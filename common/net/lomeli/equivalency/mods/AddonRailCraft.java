package net.lomeli.equivalency.mods;

import cpw.mods.fml.common.Loader;

public class AddonRailCraft 
{
	public static boolean checkRailcraft()
	{
		if (Loader.isModLoaded("Railcraft"))
		{
			try
			{
				return true;
			}
			catch(Exception ex)
			{
				return false;
			}
		}
		else
		{
			System.out.println("Railcraft not found, ignoring!");
			return false;
		}
	}
}

package net.lomeli.equivalency.forestry;

import cpw.mods.fml.common.Loader;

public class AddonForestry 
{
	public static boolean checkForestry()
	{
		if (Loader.isModLoaded("Forestry"))
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
			System.out.println("Forestry not found, ignoring");
			return false;
		}
	}
}

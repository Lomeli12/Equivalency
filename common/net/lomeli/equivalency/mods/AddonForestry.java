package net.lomeli.equivalency.mods;

import net.lomeli.equivalency.Equivalency;
import cpw.mods.fml.common.Loader;

public class AddonForestry 
{
	public static boolean checkForestry()
	{
		if (Loader.isModLoaded("Forestry"))
		{
			try
			{
				Equivalency.numberInstalled++;
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

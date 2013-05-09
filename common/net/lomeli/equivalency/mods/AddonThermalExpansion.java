package net.lomeli.equivalency.mods;

import net.lomeli.equivalency.Equivalency;
import cpw.mods.fml.common.Loader;

public class AddonThermalExpansion 
{
	public static boolean checkTE()
	{
		if (Loader.isModLoaded("ThermalExpansion"))
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
			System.out.println("Thermal Expansion not found, ignoring");
			return false;
		}
	}
}

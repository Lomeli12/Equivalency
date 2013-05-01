package net.lomeli.equivalency.mods;

import cpw.mods.fml.common.Loader;

public class AddonAppliedEnergistics 
{
	public static boolean checkAppliedEnergistics()
	{
		if (Loader.isModLoaded("AppliedEnergistics"))
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
			System.out.println("Applied Energistics not found, ignoring");
			return false;
		}
	}
}
